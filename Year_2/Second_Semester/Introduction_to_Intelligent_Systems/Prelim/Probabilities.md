# Uncertainty in Artificial Intelligence

## 📋 Summary
* **Core Concept:** Uncertainty in AI handles situations where outcomes are not deterministic. Probability theory provides a mathematical framework to quantify and reason about uncertain events using Bayesian networks, sampling methods, and temporal models.

> **Takeaways:** Probability enables AI systems to make informed decisions under uncertainty. Key concepts include conditional probability, Bayes' Rule for inference, Bayesian networks for representing dependencies, and Hidden Markov Models for temporal reasoning. Sampling methods like rejection sampling and likelihood weighting provide approximate solutions when exact inference is computationally expensive.


## 📖 Definition

* **Probability:** A measure of the likelihood of an event occurring, represented by a value between 0 and 1.
* **Random Variable:** A variable in probability theory with a domain of possible values it can take on.
* **Conditional Probability:** The degree of belief in a proposition given some evidence that has already been revealed, denoted as $P(a | b)$.
* **Bayesian Network:** A directed graph data structure that represents the dependencies among random variables using nodes and arrows.
* **Hidden Markov Model (HMM):** A Markov model for a system with hidden states that generate some observed event.
* **Markov Assumption:** The assumption that the current state depends on only a finite fixed number of previous states.

**Requirements:**
* For any probability $P(ω): 0 ≤ P(ω) ≤ 1$
* Sum of all probabilities in a sample space: $Σ P(ω) = 1$
* Joint probabilities must account for all variable combinations


## ❓ Why we use it

* **Uncertain Environments:** Real-world AI systems operate in environments where information is incomplete or outcomes are probabilistic (weather prediction, medical diagnosis, speech recognition).
* **Decision Making:** Probability allows agents to make rational decisions by weighing the likelihood of different outcomes.
* **Inference from Evidence:** Using observed data (visible effects) to reason backward about hidden causes or future states.
* **Handling Noise:** Sensor data and measurements are often noisy or imperfect, requiring probabilistic reasoning.
* **Prediction:** Forecasting future states based on past observations and learned patterns.


## ⚙️ How it works

### 1. Basic Probability Rules
* **Negation:** $P(¬a) = 1 − P(a)$
* **Inclusion-Exclusion:** $P(a ∨ b) = P(a) + P(b) − P(a ∧ b)$
* **Marginalization:** $P(a) = P(a, b) + P(a, ¬b)$
* **Conditioning:** $P(a) = P(a | b)P(b) + P(a | ¬b)P(¬b)$

### 2. Conditional Probability Formula
$$P(a | b) = \frac{P(a \wedge b)}{P(b)}$$

This reads as: "The probability of a given b equals the probability of both a and b divided by the probability of b."

### 3. Bayes' Rule
$$P(b | a) = \frac{P(a | b) \cdot P(b)}{P(a)}$$

**Application:** Knowing P(visible effect | unknown cause), we can calculate P(unknown cause | visible effect).

**Example:** Given that 80% of rainy afternoons start with cloudy mornings, 40% of days have cloudy mornings, and 10% of days have rainy afternoons:
$$P(\text{rain} | \text{clouds}) = \frac{P(\text{clouds} | \text{rain}) \cdot P(\text{rain})}{P(\text{clouds})} = \frac{0.8 \times 0.1}{0.4} = 0.2$$

### 4. Bayesian Networks Structure
* **Nodes:** Represent random variables
* **Arrows:** Indicate parent-child dependencies (arrow from $X$ to $Y$ means $X$ is a parent of $Y$)
* **Conditional Probability Tables:** Each node $X$ has a distribution $P(X | Parents(X))$

### 5. Inference in Bayesian Networks

**Inference by Enumeration:**
$$P(X | e) = \alpha P(X, e) = \alpha \sum_{y} P(X, e, y)$$

Where:
* $X$ is the query variable
* $e$ is the evidence
* $y$ ranges over values of hidden variables
* $α$ normalizes the result

### 6. Approximate Inference Methods

**Rejection Sampling:**
* Generate samples from the network
* Reject samples that don't match the evidence
* Compute probability from remaining samples

**Likelihood Weighting:**
1. Fix the values for evidence variables
2. Sample non-evidence variables using conditional probabilities
3. Weight each sample by its likelihood (probability of all evidence)

### 7. Hidden Markov Models

**Components:**
* **Transition Model:** Defines $P(X_{t+1} | X_t)$ - how states evolve over time
* **Sensor Model:** Defines $P(E_t | X_t)$ - how observations relate to hidden states
* **Sensor Markov Assumption:** The evidence variable depends only on the corresponding state

**Inference Tasks:**
* **Filtering:** Calculate distribution for current state given observations until now
* **Prediction:** Calculate distribution for future state given observations until now
* **Smoothing:** Calculate distribution for past state given observations until now
* **Most Likely Explanation:** Calculate most likely sequence of states given observations


## 💻 Usage / Example

```python
# Example: Simple Bayesian Network Inference
# Computing P(Appointment | light rain, no maintenance)

# Given probabilities
P_light = 0.2  # P(Rain = light)
P_no_given_light = 0.8  # P(Maintenance = no | Rain = light)

# For train being on time given light rain and no maintenance
P_train_on_time = 0.7  # P(Train = on time | light, no)
P_train_delayed = 0.3  # P(Train = delayed | light, no)

# Appointment probabilities
P_attend_given_on_time = 0.9  # P(Appointment = attend | Train = on time)
P_attend_given_delayed = 0.6  # P(Appointment = attend | Train = delayed)

# Calculate joint probabilities
P_attend_on_time = (P_light * P_no_given_light * 
                    P_train_on_time * P_attend_given_on_time)

P_attend_delayed = (P_light * P_no_given_light * 
                    P_train_delayed * P_attend_given_delayed)

# Total probability of attending
P_attend = P_attend_on_time + P_attend_delayed

print(f"P(Attend | light, no) = {P_attend:.4f}")
# Output: P(Attend | light, no) = 0.1296
```

```python
# Example: Likelihood Weighting for Approximate Inference
import random

def sample_from_distribution(distribution):
    """Sample from a probability distribution"""
    rand = random.random()
    cumulative = 0
    for value, prob in distribution.items():
        cumulative += prob
        if rand < cumulative:
            return value
    return list(distribution.keys())[-1]

def likelihood_weighting(network, evidence, query, num_samples=10000):
    """
    Perform likelihood weighting inference
    
    Args:
        network: Bayesian network structure
        evidence: Dictionary of observed variables
        query: Variable to compute probability for
        num_samples: Number of samples to generate
    """
    samples = {}
    
    for _ in range(num_samples):
        sample = {}
        weight = 1.0
        
        # Generate sample following network structure
        for node in network:
            if node in evidence:
                # Evidence variable: fix value and update weight
                sample[node] = evidence[node]
                # Weight by probability of evidence
                weight *= network[node]['prob'][evidence[node]]
            else:
                # Non-evidence: sample from conditional distribution
                sample[node] = sample_from_distribution(
                    network[node]['conditional']
                )
        
        # Record sample for query variable
        query_value = sample[query]
        if query_value not in samples:
            samples[query_value] = 0
        samples[query_value] += weight
    
    # Normalize
    total = sum(samples.values())
    return {k: v/total for k, v in samples.items()}

# Usage example (simplified)
# result = likelihood_weighting(bayesian_net, 
#                               evidence={'Train': 'on_time'}, 
#                               query='Rain',
#                               num_samples=10000)
```

```python
# Example: Hidden Markov Model - Weather Prediction
import numpy as np

# Transition model: P(X_t+1 | X_t)
transition_matrix = np.array([
    [0.8, 0.2],  # P(sun tomorrow | sun today), P(rain tomorrow | sun today)
    [0.3, 0.7]   # P(sun tomorrow | rain today), P(rain tomorrow | rain today)
])

# Sensor model: P(E_t | X_t)
sensor_matrix = np.array([
    [0.8, 0.2],  # P(umbrella | sun), P(no umbrella | sun)
    [0.1, 0.9]   # P(umbrella | rain), P(no umbrella | rain)
])

# Initial state distribution
initial_state = np.array([0.5, 0.5])  # [P(sun), P(rain)]

def predict_next_state(current_distribution, transition_matrix):
    """Predict next state distribution"""
    return current_distribution @ transition_matrix

def filtering(prior, observation, transition_matrix, sensor_matrix):
    """
    Filtering: Update belief about current state given observation
    
    Args:
        prior: Previous state distribution
        observation: Current observation (0 = no umbrella, 1 = umbrella)
        transition_matrix: State transition probabilities
        sensor_matrix: Observation probabilities
    """
    # Predict
    predicted = prior @ transition_matrix
    
    # Update based on observation
    observation_probs = sensor_matrix[:, observation]
    updated = predicted * observation_probs
    
    # Normalize
    updated = updated / np.sum(updated)
    
    return updated

# Example: Filtering over time
state = initial_state
observations = [1, 1, 0, 1]  # Sequence of umbrella observations

print(f"Initial state: P(sun)={state[0]:.3f}, P(rain)={state[1]:.3f}")

for i, obs in enumerate(observations):
    state = filtering(state, obs, transition_matrix, sensor_matrix)
    print(f"After observation {i+1} (umbrella={obs}): "
          f"P(sun)={state[0]:.3f}, P(rain)={state[1]:.3f}")

# Output demonstrates how belief updates with each observation
# Initial state: P(sun)=0.500, P(rain)=0.500
# After observation 1 (umbrella=1): P(sun)=0.154, P(rain)=0.846
# After observation 2 (umbrella=1): P(sun)=0.063, P(rain)=0.937
# After observation 3 (umbrella=0): P(sun)=0.333, P(rain)=0.667
# After observation 4 (umbrella=1): P(sun)=0.129, P(rain)=0.871
```

## References

* [CS50's Introduction to AI with Python](https://cs50.harvard.edu/ai/2024/) — Lecture 2: Uncertainty
* [Probabilistic Graphical Models](https://mitpress.mit.edu/9780262013192/) — Daphne Koller and Nir Friedman
* [Artificial Intelligence: A Modern Approach](http://aima.cs.berkeley.edu/) — Stuart Russell and Peter Norvig, Chapters 13-15