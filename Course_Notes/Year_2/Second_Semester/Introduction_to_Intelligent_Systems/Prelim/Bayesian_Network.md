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

* **Conditional Independence:** Variable $X$ is conditionally independent of $Y$ given $Z$, written $X \perp Y \mid Z$, if knowing $Z$ makes $X$ and $Y$ carry no information about each other. A BN encodes these independencies structurally.

* **Prior Probability $P(X)$:** The probability of a variable before any evidence is observed.

* **Posterior Probability $P(X \mid e)$:** The updated probability of a variable after incorporating evidence $e$, computed via Bayes' Theorem:
  $$P(X \mid e) = \frac{P(e \mid X)\, P(X)}{P(e)}$$

* **d-Separation:** A graphical criterion for reading off conditional independencies from the DAG structure. Two nodes $X$ and $Y$ are d-separated given $Z$ if all paths between them are blocked by $Z$.

* **Requirements:**
    * All edges must be directed and the graph must be acyclic (no feedback loops).
    * Every node must have a valid CPT whose rows sum to 1.
    * Variables may be discrete or continuous (discrete is most common in introductory settings).
    * The Markov condition must hold: each variable is conditionally independent of its non-descendants given its parents.

---

## ❓ Why We Use It

* **Uncertainty representation:** Real-world domains are inherently uncertain. Bayesian Networks provide a principled, compact way to model and reason under uncertainty using probability theory.

* **Conditional independence exploitation:** Instead of storing a full joint distribution with $2^n$ entries for $n$ binary variables, a BN factors it into local CPTs, reducing storage and computation significantly.

* **Inference:** Given observed evidence (e.g., a symptom is present), a BN can compute the posterior probability of unobserved variables (e.g., which disease is most likely) using exact or approximate inference algorithms.

* **Learning from data:** Both the structure (graph) and the parameters (CPTs) of a BN can be learned from data, making it practical for real-world applications.

* **Interpretability:** The DAG structure is human-readable and often aligns with causal intuitions, making the model explainable — a key property in cybersecurity and medical domains.

* **Domain applications:**
    * Medical diagnosis (e.g., inferring disease from symptoms)
    * Intrusion detection and threat modeling in cybersecurity
    * Spam filtering
    * Fault diagnosis in engineering systems
    * Autonomous agents and robotics (AI planning under uncertainty)

---

## ⚙️ How It Works

1. **Define the variables:** Identify all relevant random variables in the domain. For example: $\text{Burglary}$, $\text{Earthquake}$, $\text{Alarm}$, $\text{JohnCalls}$, $\text{MaryCalls}$ — all binary (True/False).

2. **Construct the DAG:** Draw directed edges from cause to effect. A node $A$ has an edge to $B$ if $A$ directly influences $B$. The result must be acyclic.

3. **Specify the CPTs:** For each node $X_i$, define $P(X_i \mid \text{Parents}(X_i))$. A root node (no parents) stores only its prior $P(X_i)$.

4. **Factor the joint distribution** using the chain rule of Bayesian Networks:
   $$P(X_1, \ldots, X_n) = \prod_{i=1}^{n} P(X_i \mid \text{Parents}(X_i))$$

5. **Perform inference:** Given evidence $e$ (observed variables), compute the posterior of query variable $Q$:
   $$P(Q \mid e) = \alpha \sum_{\text{hidden}} P(Q, \text{hidden}, e)$$
   where $\alpha$ is a normalizing constant and the sum marginalizes over all hidden (unobserved) variables.

6. **Inference methods:**
   * **Exact inference:** Enumeration, Variable Elimination, Belief Propagation (for trees).
   * **Approximate inference:** Monte Carlo sampling (e.g., Likelihood Weighting, Gibbs Sampling) — used when exact inference is intractable.

---

## 💻 Usage / Example

```python
# Example: Burglary-Alarm Bayesian Network (Classic AI Textbook Example)
# Variables: Burglary (B), Earthquake (E), Alarm (A), JohnCalls (J), MaryCalls (M)
# Reference: Russell & Norvig, Artificial Intelligence: A Modern Approach, Chapter 13

from pgmpy.models import BayesianNetwork
from pgmpy.factors.discrete import TabularCPD
from pgmpy.inference import VariableElimination

# Step 1: Define the DAG structure (edges = direct dependencies)
model = BayesianNetwork([
    ("Burglary",   "Alarm"),
    ("Earthquake", "Alarm"),
    ("Alarm",      "JohnCalls"),
    ("Alarm",      "MaryCalls"),
])

# Step 2: Define CPTs
# P(Burglary): prior — no parents
cpd_B = TabularCPD("Burglary",   2, [[0.999], [0.001]])

# P(Earthquake): prior — no parents
cpd_E = TabularCPD("Earthquake", 2, [[0.998], [0.002]])

# P(Alarm | Burglary, Earthquake)
# Columns: B=F/E=F, B=F/E=T, B=T/E=F, B=T/E=T
cpd_A = TabularCPD(
    "Alarm", 2,
    [[0.999, 0.71, 0.06, 0.05],
     [0.001, 0.29, 0.94, 0.95]],
    evidence=["Burglary", "Earthquake"],
    evidence_card=[2, 2],
)

# P(JohnCalls | Alarm)
cpd_J = TabularCPD(
    "JohnCalls", 2,
    [[0.95, 0.05],
     [0.05, 0.95]],
    evidence=["Alarm"],
    evidence_card=[2],
)

# P(MaryCalls | Alarm)
cpd_M = TabularCPD(
    "MaryCalls", 2,
    [[0.99, 0.01],
     [0.01, 0.99]],
    evidence=["Alarm"],
    evidence_card=[2],
)

# Step 3: Add CPTs to model and validate
model.add_cpds(cpd_B, cpd_E, cpd_A, cpd_J, cpd_M)
assert model.check_model(), "Model is invalid."

# Step 4: Inference — Variable Elimination
infer = VariableElimination(model)

# Query: P(Burglary | JohnCalls=True, MaryCalls=True)
result = infer.query(
    variables=["Burglary"],
    evidence={"JohnCalls": 1, "MaryCalls": 1},
)
print(result)
# Expected: P(Burglary=True | J=T, M=T) ≈ 0.284
```

### Manually Computing a Joint Probability

```python
# P(B=T, E=F, A=T, J=T, M=T) using the factorization formula:
# P = P(B) * P(E) * P(A|B,E) * P(J|A) * P(M|A)

P_B  = 0.001          # P(Burglary=T)
P_E  = 0.998          # P(Earthquake=F)
P_A  = 0.94           # P(Alarm=T | B=T, E=F)
P_J  = 0.90           # P(JohnCalls=T | Alarm=T)
P_M  = 0.70           # P(MaryCalls=T | Alarm=T)

joint = P_B * P_E * P_A * P_J * P_M
print(f"P(B=T, E=F, A=T, J=T, M=T) = {joint:.6f}")
# ≈ 0.000592
```

---

## References

* [pgmpy Documentation](https://pgmpy.org/) — Python library for Probabilistic Graphical Models; covers BN construction, CPDs, and inference.
* [Bayesian Networks — Wikipedia](https://en.wikipedia.org/wiki/Bayesian_network) — Formal definitions, properties, and inference overview.
* [Artificial Intelligence: A Modern Approach] — Russell & Norvig, Chapter 13 (Probabilistic Reasoning) and Chapter 14 (Probabilistic Reasoning over Time). The Burglary-Alarm example originates here.
* [Pattern Recognition and Machine Learning] — Christopher Bishop, Chapter 8 (Graphical Models). Covers directed and undirected models with rigorous mathematical treatment.
* [Probabilistic Graphical Models] — Daphne Koller & Nir Friedman — The definitive graduate-level reference for BNs, inference, and structure learning.
