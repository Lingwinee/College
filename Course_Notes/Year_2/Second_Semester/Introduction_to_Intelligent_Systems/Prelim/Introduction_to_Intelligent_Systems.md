# Search Algorithms in Artificial Intelligence

## 📋 Summary
* **Core Concept:** Search algorithms allow an agent to find a sequence of actions that leads from an initial state to a goal state by exploring possible states in a state space.

> **Takeaways:** Search algorithms are fundamental to AI problem-solving. They work by maintaining a frontier of nodes to explore, systematically expanding nodes until the goal is reached. Different search strategies (DFS, BFS, A*) have different properties regarding completeness, optimality, time complexity, and space complexity. Uninformed search explores blindly, while informed search uses heuristics to guide the search toward the goal more efficiently.


## 📖 Definition

* **Agent:** An entity that perceives its environment and acts upon that environment.
* **State:** A configuration of the agent and its environment.
* **Initial State:** The state in which the agent begins.
* **Actions:** Choices that can be made in a state. ACTIONS(s) returns the set of actions that can be executed in state s.
* **Transition Model:** A description of what state results from performing any applicable action in any state. RESULT(s, a) returns the state resulting from performing action a in state s.
* **State Space:** The set of all states reachable from the initial state by any sequence of actions.
* **Goal Test:** A way to determine whether a given state is a goal state.
* **Path Cost:** A numerical cost associated with a given path.
* **Solution:** A sequence of actions that leads from the initial state to a goal state.
* **Optimal Solution:** A solution that has the lowest path cost among all solutions.
* **Node:** A data structure that keeps track of a state, a parent (node that generated this node), an action (action applied to parent to get node), and a path cost (from initial state to node).
* **Frontier:** The set of nodes that have been discovered but not yet explored.
* **Explored Set:** The set of nodes that have already been explored.

* **Requirements:**
    * Initial state
    * Actions
    * Transition model
    * Goal test
    * Path cost function


## 📊 Complexity Analysis

### Search Algorithm Comparison

| Algorithm | Complete | Optimal | Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- | :--- |
| Depth-First Search | No | No | $O(b^m)$ | $O(bm)$ |
| Breadth-First Search | Yes | Yes* | $O(b^d)$ | $O(b^d)$ |
| Uniform Cost Search | Yes | Yes | $O(b^{1+\lfloor C^*/\epsilon \rfloor})$ | $O(b^{1+\lfloor C^*/\epsilon \rfloor})$ |
| Greedy Best-First | No | No | $O(b^m)$ | $O(b^m)$ |
| A* Search | Yes** | Yes** | $O(b^d)$ | $O(b^d)$ |

* BFS is optimal only if all step costs are equal
** A* is complete and optimal if the heuristic is admissible and consistent

* **Time Complexity Factors:**
    * $b$ = branching factor (number of successors per node)
    * $m$ = maximum depth of the state space
    * $d$ = depth of the optimal solution
    * $C^*$ = cost of optimal solution
    * $\epsilon$ = minimum step cost

* **Space Complexity:** The amount of memory needed to store the frontier and explored set.


## ❓ Why we use search algorithms

* **Problem Solving:** Search algorithms provide a systematic approach to finding solutions when the path to the goal is not immediately obvious.
* **Optimality:** Certain search algorithms guarantee finding the optimal solution when one exists.
* **Flexibility:** Different search strategies can be chosen based on problem characteristics (time constraints, memory limitations, solution quality requirements).
* **Foundation:** Search forms the basis for many AI applications including path planning, game playing, puzzle solving, and robotics.


## ⚙️ How it works

### General Search Approach

1. **Step 1:** Start with a frontier that contains the initial state.
2. **Step 2:** Start with an empty explored set.
3. **Step 3:** Repeat the following:
    * If the frontier is empty, then no solution exists.
    * Remove a node from the frontier.
    * If node contains goal state, return the solution.
    * Add the node to the explored set.
    * Expand node, add resulting nodes to the frontier if they are not already in the frontier or the explored set.

### Depth-First Search (DFS)

* **Data Structure:** Stack (Last-In-First-Out)
* **Strategy:** Always expands the deepest node in the frontier.
* **Characteristics:**
    * Not complete (can get stuck in infinite loops)
    * Not optimal
    * Low memory usage
    * May explore very deep paths before finding the goal

### Breadth-First Search (BFS)

* **Data Structure:** Queue (First-In-First-Out)
* **Strategy:** Always expands the shallowest node in the frontier.
* **Characteristics:**
    * Complete (will find a solution if one exists)
    * Optimal (if all step costs are equal)
    * Higher memory usage
    * Explores level by level

### Informed Search (A* Algorithm)

* **Strategy:** Uses a heuristic function to estimate the cost to reach the goal.
* **Cost Function:** $f(n) = g(n) + h(n)$
    * $g(n)$ = cost from start to node n
    * $h(n)$ = estimated cost from node n to goal (heuristic)
* **Optimality Conditions:**
    * Heuristic must be **admissible**: never overestimates the true cost
    * Heuristic must be **consistent**: $h(n) \leq h(n') + c$ for every node n and successor n' with step cost c

### Adversarial Search (Minimax)

* **Application:** Two-player games where one player tries to maximize score and the other tries to minimize it.
* **Game Components:**
    * $S_0$ : initial state
    * PLAYER(s) : returns which player to move in state s
    * ACTIONS(s) : returns legal moves in state s
    * RESULT(s, a) : returns state after action a taken in state s
    * TERMINAL(s) : checks if state s is a terminal state
    * UTILITY(s) : final numerical value for terminal state s

* **Minimax Algorithm:**
    * MAX player picks action that produces highest value of MIN-VALUE
    * MIN player picks action that produces smallest value of MAX-VALUE

* **Alpha-Beta Pruning:** An optimization that eliminates branches in the game tree that do not need to be explored because they cannot affect the final decision.

* **Depth-Limited Minimax:** Uses an evaluation function to estimate the expected utility of the game from a given state when the full game tree cannot be explored.


## 💻 Usage / Program Example

### Depth-First Search Implementation

```python
def dfs(problem):
    """
    Depth-First Search implementation.
    Uses a stack (LIFO) to explore the deepest nodes first.
    """
    # Initialize frontier with starting position
    start = Node(state=problem.initial_state, parent=None, action=None)
    frontier = [start]  # Stack (using list)
    
    # Initialize explored set
    explored = set()
    
    # Keep looping until solution found
    while True:
        # If nothing left in frontier, no solution
        if len(frontier) == 0:
            return None
        
        # Remove node from frontier (LIFO - take from end)
        node = frontier.pop()
        
        # If node is goal, return solution
        if problem.goal_test(node.state):
            actions = []
            cells = []
            # Follow parent nodes back to start
            while node.parent is not None:
                actions.append(node.action)
                cells.append(node.state)
                node = node.parent
            actions.reverse()
            cells.reverse()
            return actions, cells
        
        # Mark node as explored
        explored.add(node.state)
        
        # Add neighbors to frontier
        for action, state in problem.neighbors(node.state):
            if state not in explored and state not in [n.state for n in frontier]:
                child = Node(state=state, parent=node, action=action)
                frontier.append(child)

# Time Complexity: O(b^m)
# Space Complexity: O(bm)
```

### Breadth-First Search Implementation

```python
from collections import deque

def bfs(problem):
    """
    Breadth-First Search implementation.
    Uses a queue (FIFO) to explore the shallowest nodes first.
    """
    # Initialize frontier with starting position
    start = Node(state=problem.initial_state, parent=None, action=None)
    frontier = deque([start])  # Queue
    
    # Initialize explored set
    explored = set()
    
    # Keep looping until solution found
    while True:
        # If nothing left in frontier, no solution
        if len(frontier) == 0:
            return None
        
        # Remove node from frontier (FIFO - take from beginning)
        node = frontier.popleft()
        
        # If node is goal, return solution
        if problem.goal_test(node.state):
            actions = []
            cells = []
            while node.parent is not None:
                actions.append(node.action)
                cells.append(node.state)
                node = node.parent
            actions.reverse()
            cells.reverse()
            return actions, cells
        
        # Mark node as explored
        explored.add(node.state)
        
        # Add neighbors to frontier
        for action, state in problem.neighbors(node.state):
            if state not in explored and state not in [n.state for n in frontier]:
                child = Node(state=state, parent=node, action=action)
                frontier.append(child)

# Time Complexity: O(b^d)
# Space Complexity: O(b^d)
```

### A* Search Implementation

```python
import heapq

def a_star_search(problem, heuristic):
    """
    A* Search implementation.
    Uses a priority queue ordered by f(n) = g(n) + h(n).
    """
    # Initialize frontier with starting position
    start = Node(state=problem.initial_state, parent=None, action=None, cost=0)
    # Priority queue: (f_score, counter, node)
    counter = 0
    frontier = [(heuristic(start.state), counter, start)]
    heapq.heapify(frontier)
    
    # Track nodes in frontier for quick lookup
    frontier_states = {start.state: 0}
    
    # Initialize explored set
    explored = set()
    
    while True:
        # If nothing left in frontier, no solution
        if len(frontier) == 0:
            return None
        
        # Remove node with lowest f(n) from frontier
        _, _, node = heapq.heappop(frontier)
        del frontier_states[node.state]
        
        # If node is goal, return solution
        if problem.goal_test(node.state):
            actions = []
            cells = []
            while node.parent is not None:
                actions.append(node.action)
                cells.append(node.state)
                node = node.parent
            actions.reverse()
            cells.reverse()
            return actions, cells
        
        # Mark node as explored
        explored.add(node.state)
        
        # Add neighbors to frontier
        for action, state in problem.neighbors(node.state):
            if state not in explored:
                new_cost = node.cost + 1
                
                # If state not in frontier or we found better path
                if state not in frontier_states or new_cost < frontier_states[state]:
                    counter += 1
                    child = Node(state=state, parent=node, action=action, cost=new_cost)
                    f_score = new_cost + heuristic(state)
                    heapq.heappush(frontier, (f_score, counter, child))
                    frontier_states[state] = new_cost

# Time Complexity: O(b^d)
# Space Complexity: O(b^d)
# Optimal if heuristic is admissible and consistent
```

### Minimax with Alpha-Beta Pruning

```python
def minimax(state, depth, alpha, beta, maximizing_player):
    """
    Minimax algorithm with alpha-beta pruning for game playing.
    
    Args:
        state: Current game state
        depth: Maximum depth to search
        alpha: Best value for maximizer found so far
        beta: Best value for minimizer found so far
        maximizing_player: True if current player is maximizing
    
    Returns:
        Best value for current player
    """
    # Base case: terminal state or depth limit reached
    if is_terminal(state) or depth == 0:
        return utility(state)
    
    if maximizing_player:
        max_value = float('-inf')
        for action in get_actions(state):
            next_state = result(state, action)
            value = minimax(next_state, depth - 1, alpha, beta, False)
            max_value = max(max_value, value)
            alpha = max(alpha, value)
            # Prune: beta cutoff
            if beta <= alpha:
                break
        return max_value
    else:
        min_value = float('inf')
        for action in get_actions(state):
            next_state = result(state, action)
            value = minimax(next_state, depth - 1, alpha, beta, True)
            min_value = min(min_value, value)
            beta = min(beta, value)
            # Prune: alpha cutoff
            if beta <= alpha:
                break
        return min_value

# Example: Get best move for maximizing player
def get_best_move(state):
    best_value = float('-inf')
    best_move = None
    alpha = float('-inf')
    beta = float('inf')
    
    for action in get_actions(state):
        next_state = result(state, action)
        value = minimax(next_state, depth=5, alpha=alpha, beta=beta, maximizing_player=False)
        if value > best_value:
            best_value = value
            best_move = action
        alpha = max(alpha, value)
    
    return best_move

# Time Complexity: O(b^m) worst case, but alpha-beta pruning reduces to O(b^(m/2)) on average
```

### Node Class Definition

```python
class Node:
    """
    A node in a search tree.
    Contains a state, parent node, action taken to reach this node,
    and the cost to reach this node.
    """
    def __init__(self, state, parent, action, cost=0):
        self.state = state
        self.parent = parent
        self.action = action
        self.cost = cost
    
    def __lt__(self, other):
        # For priority queue comparison
        return self.cost < other.cost
```


## References

* [Lecture 01.pdf](https://drive.google.com/file/d/1pZDmtbcc4WmQVGiwBrruhIDZwz9_mwnV/view?usp=drive_link) - Lecture Source

* [CS50's Introduction to Artificial Intelligence with Python](https://cs50.harvard.edu/ai/) — Harvard University Course
* [Russell, S. & Norvig, P. (2020). Artificial Intelligence: A Modern Approach (4th ed.)](https://aima.cs.berkeley.edu/) — Chapter 3: Solving Problems by Searching