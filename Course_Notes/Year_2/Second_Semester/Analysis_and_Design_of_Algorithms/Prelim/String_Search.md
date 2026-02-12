<aside>

# Summary

</aside>

- String searching (or pattern matching) is a fundamental task in computer science used to find the occurrence of a **Pattern (P)** within a larger **Text (T)**. This study guide covers the fundamental **Brute Force** approach and the highly efficient **Boyer-Moore** algorithm.

---

<aside>

# 1. Brute Force Search

</aside>

### Definition

The Brute Force (or Naive) algorithm checks for the pattern at every possible position in the text, one by one, from left to right.

### Complexity Analysis

- **Worst-case:** $O(m \cdot (n - m + 1))$, where $n$ is the length of the text and $m$ is the length of the pattern.
- **Best-case:** $O(n)$ when the first character of the pattern does not match the text.

### Why do we Use it

- It is simple to implement and understand.
- It requires no preprocessing or extra memory.
- Effective for very short patterns or small alphabets.

### How it Works

The algorithm aligns the pattern at the start of the text and compares characters. If a mismatch occurs, the pattern shifts right by exactly one position, and the comparison starts over.

### Program Example (Python)

```python
def brute_force_search(text, pattern):
    n = len(text)
    m = len(pattern)
    
    # Iterate through the text
    for i in range(n - m + 1):
        j = 0
        # Check for pattern match at current index
        while j < m and text[i + j] == pattern[j]:
            j += 1
        
        if j == m:
            return i  # Pattern found at index i
            
    return -1  # Pattern not found
```

*The outer loop moves the starting point, while the inner loop validates the characters.*

```python
#include <stdio.h>
#include <string.h>

int brute_force_search(char *text, char *pattern) {
    int n = strlen(text);
    int m = strlen(pattern);

    for (int i = 0; i <= n - m; i++) {
        int j;
        // Check for pattern match at current index
        for (j = 0; j < m; j++) {
            if (text[i + j] != pattern[j])
                break;
        }
        if (j == m) return i; // Pattern found
    }
    return -1; // Not found
}
```

*The nested loops ensure every possible alignment is checked until a match or the end of the text is reached.*

---

### 2. Boyer-Moore Algorithm

### Definition

The Boyer-Moore algorithm is an efficient string-searching framework that skips sections of the text rather than shifting by one. It is the standard for most modern "find" functions.

### Complexity Analysis

- **Worst-case:** $O(n \cdot m)$ (rarely occurs in natural language).
- **Best-case:** $O(n/m)$ (the algorithm can actually be faster than linear time).

### Why do we Use it

- It is significantly faster than Brute Force for large texts.
- It performs better as the pattern length increases.

### How it Works

Unlike Brute Force, Boyer-Moore uses two key strategies:

1. **Right-to-Left Scanning:** It compares characters from the end of the pattern to the beginning.
2. **The Bad Character Rule:** When a mismatch occurs at text character `x`, the algorithm shifts the pattern so that the last occurrence of `x` in the pattern aligns with the text. If `x` is not in the pattern, it shifts the pattern entirely past `x`.
3. **The Good Suffix Rule:** If a portion of the pattern matches, it shifts to align the next occurrence of that matched suffix.

### Step-by-Step Implementation

1. **Preprocess:** Create a "Bad Character" table (often a dictionary or array) storing the last index of every character in the pattern.
2. **Align:** Start the pattern at the beginning of the text.
3. **Compare:** Compare from $m-1$ down to $0$.
4. **Shift:** Upon mismatch, use the Bad Character table to determine the shift distance.
5. **Repeat:** Continue until a match is found or the end of the text is reached.

### Program Example (Python)

```python
def boyer_moore_search(text, pattern):
    m = len(pattern)
    n = len(text)
    if m == 0: return 0

    # Preprocessing: Bad Character Table
    bad_char = {char: i for i, char in enumerate(pattern)}

    s = 0  # s is the shift of the pattern with respect to text
    while s <= n - m:
        j = m - 1
        
        # Compare pattern from right to left
        while j >= 0 and pattern[j] == text[s + j]:
            j -= 1

        if j < 0:
            return s  # Match found
        else:
            # Shift based on Bad Character Rule
            char_in_text = text[s + j]
            last_occurrence = bad_char.get(char_in_text, -1)
            s += max(1, j - last_occurrence)
            
    return -1
```

*The `bad_char.get` lookup allows the algorithm to skip multiple characters in a single jump.*

```python
#include <stdio.h>
#include <string.h>

#define NO_OF_CHARS 256

// Preprocessing: Fill the bad character array
void badCharHeuristic(char *str, int size, int badchar[NO_OF_CHARS]) {
    for (int i = 0; i < NO_OF_CHARS; i++)
        badchar[i] = -1;

    for (int i = 0; i < size; i++)
        badchar[(int)str[i]] = i;
}

int boyer_moore_search(char *text, char *pattern) {
    int m = strlen(pattern);
    int n = strlen(text);
    int badchar[NO_OF_CHARS];

    badCharHeuristic(pattern, m, badchar);

    int s = 0; // s is shift of the pattern with respect to text
    while (s <= (n - m)) {
        int j = m - 1;

        // Keep reducing index j of pattern while characters match
        while (j >= 0 && pattern[j] == text[s + j])
            j--;

        if (j < 0) {
            return s; // Pattern found at current shift
            // For all occurrences, use: s += (s + m < n) ? m - badchar[text[s + m]] : 1;
        } else {
            // Shift the pattern so the bad character in text aligns with 
            // the last occurrence of it in pattern. 
            int shift = j - badchar[(int)text[s + j]];
            s += (shift > 1) ? shift : 1;
        }
    }
    return -1;
}
```

*The `badCharHeuristic` allows the algorithm to "jump" over characters that cannot possibly match, making it much faster than Brute Force on large datasets.*

---

<aside>

# References

</aside>

[]()

---