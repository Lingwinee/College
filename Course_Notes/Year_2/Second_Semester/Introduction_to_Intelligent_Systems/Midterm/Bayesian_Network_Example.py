from pgmpy.models import BayesianModel
from pgmpy.inference import VariableElimination

class BayesianNetwork:
    def __init__(self):
        self.graph = {}
        self.probabilities = {}

    def add_node(self, node, parents=None):
        if parents is None:
            parents = []
        self.graph[node] = parents

    def set_probability(self, node, probability):
        self.probabilities[node] = probability

    def get_probability(self, node, evidence):
        # Simplified probability retrieval based on evidence
        if node in self.probabilities:
            return self.probabilities[node]
        return None

    def display(self):
        print("Bayesian Network Structure:")
        for node, parents in self.graph.items():
            print(f"Node: {node}, Parents: {parents}")

# Example usage
if __name__ == "__main__":
    bn = BayesianNetwork()
    bn.add_node('Rain')
    bn.add_node('Traffic', parents=['Rain'])
    bn.set_probability('Rain', 0.2)
    bn.set_probability('Traffic', {True: 0.8, False: 0.1})

    bn.display()
    print("Probability of Traffic given Rain:", bn.get_probability('Traffic', {'Rain': True}))
    # Define the Bayesian Network structure
    model = BayesianModel([('Rain', 'Traffic')])

    # Define the conditional probability distributions
    cp_rain = [0.8, 0.2]  # P(Rain=False), P(Rain=True)
    cp_traffic = {
        'Rain': [0.9, 0.8, 0.1, 0.0],  # P(Traffic | Rain=False), P(Traffic | Rain=True)
    }

    # Add CPDs to the model
    model.add_cpds(
        cp_rain,
        cp_traffic
    )

    # Perform inference
    inference = VariableElimination(model)
    prob_traffic_given_rain = inference.query(variables=['Traffic'], evidence={'Rain': True})

    print("Probability of Traffic given Rain:", prob_traffic_given_rain)