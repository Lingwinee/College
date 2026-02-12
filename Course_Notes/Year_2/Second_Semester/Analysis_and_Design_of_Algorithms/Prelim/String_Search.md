# String Searching Algorithms

## 📋 Summary
**Core Concept:** String searching involves locating the occurrence of a pattern string $P$ within a larger text string $T$. This note compares the fundamental Brute Force approach with the optimized Boyer-Moore algorithm.

> **Takeaways:** Brute Force is simple but inefficient for large data, whereas Boyer-Moore achieves sub-linear time in best-case scenarios by using right-to-left scanning and heuristic-based shifts.

## 📖 Definition

* **Brute Force Search:** A naive algorithm that checks for a pattern match at every possible index of the text by shifting one position at a time.
* **Boyer-Moore Algorithm:** An efficient string-searching framework that skips portions of the text using the "Bad Character" and "Good Suffix" rules.
* **Bad Character Rule:** A heuristic that shifts the pattern to align a mismatched text character with its last occurrence in the pattern.
* **Good Suffix Rule:** A heuristic that shifts the pattern to align a matched suffix with its next occurrence within the pattern.

## 📊 Complexity Analysis

### Brute Force
| Notation | Name | Growth Rate |
| :--- | :--- | :--- |
| $O(n \cdot m)$ | Quadratic-like | Poor |
| $\Omega(n)$ | Linear | Good |

* **Worst-Case ($O$):** $O(m \cdot (n - m + 1))$ when many partial matches occur before a mismatch.
* **Best-Case ($\Omega$):** $O(n)$ when the first character of the pattern never matches the text.
* **Average-Case ($\Theta$):** Generally performs near $O(n)$ for large alphabets.

### Boyer-Moore
| Notation | Name | Growth Rate |
| :--- | :--- | :--- |
| $O(n \cdot m)$ | Quadratic-like | Poor (Rare) |
| $\Omega(n/m)$ | Sub-linear | Excellent |

* **Worst-Case ($O$):** $O(n \cdot m)$ (extremely rare in natural language text).
* **Best-Case ($\Omega$):** $O(n/m)$ when the text contains characters not present in the pattern, allowing maximum shifts.
* **Average-Case ($\Theta$):** Significantly faster than $O(n)$ for most practical applications.

## ❓ Why we use it

* **Brute Force:** Preferred for very short patterns, small texts, or environments where memory for preprocessing is unavailable.
* **Boyer-Moore:** The industry standard for "Find" operations in text editors and command-line tools (like grep) because its efficiency increases with pattern length.

## ⚙️ How it works

### Brute Force Steps
1. **Align:** Place pattern $P$ at the start of text $T$.
2. **Compare:** Check characters from left to right.
3. **Shift:** If a mismatch occurs, shift $P$ right by 1 and repeat.
4. **Mathematical Model:**
   $$C(n) \approx (n - m + 1) \cdot m$$



### Boyer-Moore Steps
1. **Preprocess:** Generate the Bad Character table (mapping characters to their last index in $P$).
2. **Scan:** Align $P$ and compare characters from right-to-left ($m-1$ down to $0$).
3. **Apply Heuristic:** On mismatch at `text[s+j]`, calculate shift:
   $$shift = \max(1, j - \text{bad\_char\_table}[\text{text}[s+j]])$$
4. **Shift:** Move the pattern by the calculated distance and repeat.



## 💻 Usage / Program Example

### Python Implementation (Boyer-Moore)
```python
def boyer_moore_search(text, pattern):
    m, n = len(pattern), len(text)
    if m == 0: return 0

    # Preprocessing: Bad Character Table
    bad_char = {char: i for i, char in enumerate(pattern)}

    s = 0  # shift
    while s <= n - m:
        j = m - 1
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

### C Implementation (Brute Force)
```c
#include <stdio.h>
#include <string.h>

int brute_force_search(char *text, char *pattern) {
    int n = strlen(text);
    int m = strlen(pattern);

    for (int i = 0; i <= n - m; i++) {
        int j;
        for (j = 0; j < m; j++) {
            if (text[i + j] != pattern[j])
                break;
        }
        if (j == m) return i; 
    }
    return -1;
}
```

## References

* [Introduction to Algorithms (CLRS)] — Cormen, Leiserson, Rivest, and Stein.
* [Boyer-Moore Algorithm Wikipedia](https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_string-search_algorithm) — Technical breakdown of heuristics.