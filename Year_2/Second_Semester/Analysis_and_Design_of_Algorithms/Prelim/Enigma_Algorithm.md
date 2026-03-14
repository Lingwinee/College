# Enigma Machine Algorithm

## 📋 Summary
* **Core Concept:** The Enigma algorithm is a polyalphabetic substitution cipher that utilizes a series of rotating wired wheels (rotors) and a reflection mechanism to constantly change the substitution alphabet for every character pressed.

> **Takeaways:** The system's security relies on the combination of rotor wiring, the order of rotors, their initial positions, and the plugboard settings, which create a massive state space for encryption.

## 📖 Definition

* **Rotor (Scrambler):** A disk with 26 electrical contacts on each side, wired internally to map one letter to another; it rotates after each keypress to change the mapping.
* **Reflector (Umkehrwalze):** A stationary disk that connects pairs of rotor outputs, sending the electrical signal back through the rotors in reverse to ensure the cipher is self-reciprocal.
* **Plugboard (Steckerbrett):** A manual wiring board that swaps pairs of letters before they enter and after they exit the rotor stack.
* **Requirements:** * Identical initial settings (key) for both sender and receiver.
    * A set of rotors with known internal wiring.
    * A mechanism for rotors to step (rotate) like an odometer.



## 📊 Complexity Analysis

| Notation | Name | Growth Rate |
| :--- | :--- | :--- |
| $O(n)$ | Linear | Good |

* **Worst-Case ($O$):** $O(n)$ where $n$ is the length of the message; each character undergoes a constant number of substitutions regardless of message length.
* **Best-Case ($\Omega$):** $\Omega(n)$ as every character in the input must be processed through the rotor stack.
* **Average-Case ($\Theta$):** $\Theta(n)$ because the path through the rotors is a fixed-depth traversal for every letter.

## ❓ Why we use it

* **Historical Significance:** It was the primary encryption device for the German military during WWII.
* **Self-Reciprocity:** Due to the reflector, the same machine setting used to encrypt a message will decrypt it, eliminating the need for separate encryption and decryption modes.
* **Large Key Space:** With multiple rotors and plugboard swaps, it offered approximately $1.5 \times 10^{20}$ possible configurations.

## ⚙️ How it works
1. **Step 1:** The operator presses a key, which first passes through the **Plugboard** for initial letter swapping.
2. **Step 2:** The signal passes through three or four **Rotors**, each performing a substitution based on its current rotation.
3. **Step 3:** The signal hits the **Reflector**, which swaps the letter one last time and sends it back through the rotors in reverse order.
4. **Step 4:** Set up the mathematical model for a single character $E$:
   $$E = P \cdot R_1 \cdot R_2 \cdot R_3 \cdot U \cdot R_3^{-1} \cdot R_2^{-1} \cdot R_1^{-1} \cdot P^{-1}$$
   Where $P$ is the plugboard, $R$ represents rotors, and $U$ is the reflector.
5. **Step 5:** After the signal lights up a lamp, the rightmost rotor steps forward by one position. If it reaches a "notch," the next rotor to the left also steps.

## 💻 Usage / Program Example
```c
#include <stdio.h>
#include <string.h>

// Simple 3-rotor Enigma simulation (simplified wiring)
// Rotor I: EKMFLGDQVZNTOWYHXUSPAIBRCJ
char rotors[3][27] = {
    "EKMFLGDQVZNTOWYHXUSPAIBRCJ",
    "AJDKSIRUXBLHWTMCQGZNPYFVOE",
    "BDFHJLCPRTXVZNYEIWGAKMUSQO"
};
char reflector[] = "YRUHQSLDPXNGOKMIEBFZCWVJAT";

int main() {
    char message[] = "HELLO";
    int pos[3] = {0, 0, 0}; // Initial positions

    printf("Encrypted: ");
    for (int i = 0; i < strlen(message); i++) {
        int c = message[i] - 'A';

        // 1. Rotate right rotor
        pos[0] = (pos[0] + 1) % 26;

        // 2. Forward through rotors
        for (int r = 0; r < 3; r++) {
            c = (rotors[r][(c + pos[r]) % 26] - 'A' - pos[r] + 26) % 26;
        }

        // 3. Reflector
        c = reflector[c] - 'A';

        // 4. Backward through rotors
        for (int r = 2; r >= 0; r--) {
            for (int j = 0; j < 26; j++) {
                if (rotors[r][j] == (char)(c + 'A')) {
                    c = (j - pos[r] + 26) % 26;
                    break;
                }
            }
        }

        printf("%c", c + 'A');
    }
    printf("\n");
    return 0;
}
```

## References

* [The Enigma Machine](https://en.wikipedia.org/wiki/Enigma_machine) — Detailed history and mechanical breakdown.
* [Cryptography and Network Security] — William Stallings, Chapter on Classical Encryption Techniques.