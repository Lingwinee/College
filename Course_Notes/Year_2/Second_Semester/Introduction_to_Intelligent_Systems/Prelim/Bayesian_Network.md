# Bayesian Network

## 📋 Summary

* **Core Concept:** A Bayesian Network is a probabilistic graphical model that represents a set of variables and their conditional dependencies using a Directed Acyclic Graph (DAG). It encodes the joint probability distribution of a domain by exploiting conditional independence among variables.

> **Takeaways:** Each node represents a random variable; each directed edge represents a probabilistic dependency. Every node stores a Conditional Probability Table (CPT) that quantifies the effect of its parents. Bayesian Networks allow efficient inference — computing the probability of unknown variables given observed evidence.

---

## 📖 Definition

* **Bayesian Network (BN):** A tuple $(G, P)$ where $G = (V, E)$ is a Directed Acyclic Graph with nodes $V$ representing random variables and edges $E$ representing direct probabilistic dependencies, and $P$ is a set of Conditional Probability Distributions (CPDs) — one per node.

* **Directed Acyclic Graph (DAG):** A graph with directed edges and no directed cycles. It encodes the causal or conditional structure among variables.

* **Conditional Probability Table (CPT):** A table associated with each node $X_i$ that stores $P(X_i \mid \text{Parents}(X_i))$ — the probability of $X_i$ given every combination of its parent values.

* **Joint Probability Distribution:** The full probability distribution over all variables. A Bayesian Network factorizes it as:
  $$P(X_1, X_2, \ldots, X_n) = \prod_{i=1}^{n} P(X_i \mid \text{Parents}(X_i))$$

* **Conditional Independence:** Variable $X$ is conditionally independent of $Y$ given $Z$, written $X \perp Y \mid Z$, if knowing $Z$ renders $X$ and $Y$ independent. A BN encodes these independencies structurally in the DAG.

* **Prior Probability $P(X)$:** The probability of a variable before any evidence is observed.

* **Posterior Probability $P(X \mid e)$:** The updated probability of a variable after incorporating evidence $e$, computed via Bayes' Theorem:
  $$P(X \mid e) = \frac{P(e \mid X)\, P(X)}{P(e)}$$

* **d-Separation:** A graphical criterion for reading conditional independencies from the DAG. Two nodes $X$ and $Y$ are d-separated given $Z$ if all paths between them are blocked by $Z$.

* **pomegranate:** A Python probabilistic modeling library (v1.0.0+) backed by PyTorch. It treats all models as probability distributions, enabling modular composition. For Bayesian Networks, it uses a **factor graph** internally for belief propagation inference, supporting both tree-structured and cyclic networks.

* **Requirements:**
    * All edges must be directed; the graph should be acyclic for guaranteed exact inference (pomegranate can still estimate on cyclic graphs via its factor graph).
    * Root nodes (no parents) must use `Categorical` distributions.
    * Child nodes (with parents) must use `ConditionalCategorical` distributions.
    * The Markov condition must hold: each variable is conditionally independent of its non-descendants given its parents.
    * Observed variables are passed as a `torch.masked.MaskedTensor`; `True` in the mask = observed, `False` = hidden.

---

## ❓ Why We Use It

* **Uncertainty representation:** Real-world domains are inherently uncertain. Bayesian Networks provide a principled, compact way to model and reason under uncertainty using probability theory.

* **Conditional independence exploitation:** Instead of storing a full joint distribution with $2^n$ entries for $n$ binary variables, a BN factors it into local CPTs, reducing storage and computation significantly.

* **Inference:** Given observed evidence (e.g., a symptom is present), a BN computes the posterior probability of unobserved variables (e.g., which disease is most likely) using belief propagation over a factor graph.

* **Learning from data:** Both the structure (graph) and parameters (CPTs) of a BN can be learned from data using `model.fit(X)` in pomegranate, using Maximum Likelihood Estimation (MLE).

* **PyTorch integration:** pomegranate v1.0.0 is built on PyTorch, enabling GPU acceleration, mini-batch learning, and seamless integration with deep learning pipelines — directly relevant to ML/AI workflows.

* **Interpretability:** The DAG structure is human-readable and often aligns with causal intuitions, making the model explainable — a key property in cybersecurity and medical domains.

* **Domain applications:**
    * Medical diagnosis (inferring disease from symptoms)
    * Intrusion detection and threat modeling in cybersecurity
    * Spam filtering
    * Fault diagnosis in engineering systems
    * Autonomous agents and robotics (AI planning under uncertainty)

---

## ⚙️ How It Works

1. **Define root node distributions** using `Categorical`. Each root stores a prior probability vector $P(X_i)$ as a tensor of shape `(1, k)` where $k$ is the number of categories.

2. **Define child node distributions** using `ConditionalCategorical`. Each child stores a CPT as a nested list (converted to tensor) whose dimensions correspond to the parent categories followed by the child's own categories.

3. **Construct the network** by passing distributions and `(parent, child)` edge tuples to `BayesianNetwork`:
   $$\text{model} = \text{BayesianNetwork}(\text{distributions}=[d_1, \ldots, d_n],\ \text{edges}=[(d_i, d_j), \ldots])$$

4. **Factor the joint distribution** using the chain rule:
   $$P(X_1, \ldots, X_n) = \prod_{i=1}^{n} P(X_i \mid \text{Parents}(X_i))$$

5. **Prepare inference input** using `torch.masked.MaskedTensor`. Encode observed variables as integer category indices; mask unobserved variables as `False`. The value underneath a `False` mask entry is ignored.

6. **Run inference** with `model.predict_proba(X_masked)`. Returns a list of tensors — one per variable — each of shape `(n_samples, n_categories)`. Observed variables return probability 1.0 for their known value; unobserved variables return the inferred posterior.

---

## 💻 Usage / Example

### Installation

```bash
pip install pomegranate   # v1.0.0+ required
pip install torch         # PyTorch backend
```

---

### Example 1 — Burglary-Alarm Network (Classic)

Variables: `Burglary (B)`, `Earthquake (E)`, `Alarm (A)`, `JohnCalls (J)`, `MaryCalls (M)`
All variables are binary: `0 = False`, `1 = True`

```python
import torch
from pomegranate.distributions import Categorical, ConditionalCategorical
from pomegranate.bayesian_network import BayesianNetwork

# ── Root nodes (priors) ───────────────────────────────────────────────────────
# Shape: (1, n_categories) → [[P(False), P(True)]]

d_B = Categorical([[0.999, 0.001]])   # P(Burglary)
d_E = Categorical([[0.998, 0.002]])   # P(Earthquake)

# ── Child node: Alarm | Burglary, Earthquake ─────────────────────────────────
# CPT shape: (n_B, n_E, n_A) = (2, 2, 2)
# Axis order: [Burglary][Earthquake][Alarm]  →  rows must sum to 1

cpd_A = [
    [[0.999, 0.001],   # B=F, E=F
     [0.71,  0.29 ]],  # B=F, E=T
    [[0.06,  0.94 ],   # B=T, E=F
     [0.05,  0.95 ]],  # B=T, E=T
]
d_A = ConditionalCategorical([cpd_A])

# ── Child node: JohnCalls | Alarm ─────────────────────────────────────────────
# CPT shape: (n_A, n_J) = (2, 2)

cpd_J = [
    [[0.95, 0.05],     # Alarm=F
     [0.10, 0.90]],    # Alarm=T
]
d_J = ConditionalCategorical([cpd_J])

# ── Child node: MaryCalls | Alarm ─────────────────────────────────────────────
cpd_M = [
    [[0.99, 0.01],     # Alarm=F
     [0.30, 0.70]],    # Alarm=T
]
d_M = ConditionalCategorical([cpd_M])

# ── Assemble the network ──────────────────────────────────────────────────────
model = BayesianNetwork(
    distributions=[d_B, d_E, d_A, d_J, d_M],
    edges=[
        (d_B, d_A),
        (d_E, d_A),
        (d_A, d_J),
        (d_A, d_M),
    ],
)

# ── Inference: P(Burglary | JohnCalls=T, MaryCalls=T) ────────────────────────
# Variable column order: [B, E, A, J, M]
# Observed: J=1, M=1  |  Hidden: B, E, A (mask=False)

X     = torch.tensor([[0, 0, 0, 1, 1]])               # placeholder values for hidden cols
mask  = torch.tensor([[False, False, False, True, True]])
X_obs = torch.masked.MaskedTensor(X, mask=mask)

posteriors = model.predict_proba(X_obs)
# Returns: list of tensors, one per variable, shape (n_samples, n_categories)

var_names = ["Burglary", "Earthquake", "Alarm", "JohnCalls", "MaryCalls"]
for name, post in zip(var_names, posteriors):
    p_true = float(post[0][1])   # P(variable=True)
    print(f"P({name:<12}=True | J=T, M=T) = {p_true:.4f}")

# Expected output (approximate):
# P(Burglary    =True | J=T, M=T) ≈ 0.2841
# P(Earthquake  =True | J=T, M=T) ≈ 0.1761
# P(Alarm       =True | J=T, M=T) ≈ 0.7620
# P(JohnCalls   =True | J=T, M=T) = 1.0000  (observed)
# P(MaryCalls   =True | J=T, M=T) = 1.0000  (observed)
```

---

### Example 2 — Computing Joint and Log Probability

```python
# P(B=T, E=F, A=T, J=T, M=T)
# Variable order: [B, E, A, J, M] encoded as integers (0=False, 1=True)

X_joint = torch.tensor([[1, 0, 1, 1, 1]])

log_prob = model.log_probability(X_joint)
prob     = torch.exp(log_prob)

print(f"log P(B=T, E=F, A=T, J=T, M=T) = {float(log_prob):.4f}")
print(f"        P(B=T, E=F, A=T, J=T, M=T) = {float(prob):.8f}")
# ≈ 0.00059224
```

---

### Example 3 — Learning Parameters from Data

```python
# When CPTs are unknown, pomegranate can estimate them via MLE from observed data.

d1 = Categorical([[0.5, 0.5]])                     # Root: B (uniform init)
d2 = ConditionalCategorical([[[0.5, 0.5],          # Child: A | B (uniform init)
                               [0.5, 0.5]]])

model_fit = BayesianNetwork(
    distributions=[d1, d2],
    edges=[(d1, d2)],
)

# Training data: columns = [B, A], rows = samples
X_train = torch.tensor([
    [0, 0], [0, 0], [0, 1],
    [1, 1], [1, 1], [1, 0],
])

model_fit.fit(X_train)   # MLE parameter estimation

print("Learned P(B):   ", model_fit.distributions[0].probs)
print("Learned P(A|B): ", model_fit.distributions[1].probs)
```

---

## References

* [pomegranate Documentation](https://pomegranate.readthedocs.io/) — Official v1.0.0 API reference covering `BayesianNetwork`, `Categorical`, and `ConditionalCategorical`.
* [pomegranate GitHub](https://github.com/jmschrei/pomegranate) — Source code, issue tracker, and BN example notebooks (e.g., Monty Hall).
* [Bayesian Networks — Wikipedia](https://en.wikipedia.org/wiki/Bayesian_network) — Formal definitions, properties, and inference overview.
* [Artificial Intelligence: A Modern Approach] — Russell & Norvig, Chapter 13–14. Origin of the Burglary-Alarm example used above.
* [Pattern Recognition and Machine Learning] — Christopher Bishop, Chapter 8 (Graphical Models). Rigorous mathematical treatment of directed graphical models.
* [Probabilistic Graphical Models] — Koller & Friedman — Graduate-level reference for BN structure learning and exact/approximate inference.
* [pomegranate JMLR Paper](https://jmlr.csail.mit.edu/papers/volume18/17-636/17-636.pdf) — Schreiber (2018), design overview and benchmarks.
