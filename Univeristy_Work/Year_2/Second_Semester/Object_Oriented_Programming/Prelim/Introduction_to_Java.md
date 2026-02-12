<aside>

# Summary

</aside>

Java is a robust, object-oriented, and platform-independent programming language created by Sun Microsystems. Its "Write Once, Run Anywhere" capability relies on the Java Virtual Machine (JVM) to translate bytecode for any operating system. Java supports various application types, including standalone programs and web applets. Control structures govern program flow: sequential execution runs lines in order, selection structures (if, switch) make decisions based on conditions, and iteration structures (for, while, do-while) repeat tasks. These features make Java secure, network-ready, and efficient for diverse computing environments.

---

<aside>

# Definition Java

</aside>

- Java is a platform-neutral, object-oriented, and secure programming language.
- **History:**
    - **Origin:** Implemented by Sun Microsystems, Inc. in the early 90s.
    - **Creators:** Led by James Gosling.
    - **Naming:** Originally called "Oak" for consumer electronics; later renamed "Java" to reflect the programmers' favorite drink (coffee).

---

<aside>

## **Key Features (Why Java?)**

</aside>

- **Platform Independent:** Follows "WORA" (Write Once, Run Anywhere). Code written on one OS (e.g., Windows) can run on another (e.g., Linux).
- **Object-Oriented:** Uses concepts like class, object, inheritance, encapsulation, and polymorphism.
- **Simple:** Designed for ease of use (e.g., calculating the area of a circle).
- **Robust:** Features strong memory management and automatic garbage collection to handle runtime errors.
- **Secure:** Runs inside a virtual machine sandbox and has no explicit pointers.
- **Multi-threaded:** Allows concurrent execution of program parts for maximum CPU utilization.
- **Dynamic:** Supports dynamic loading of classes on demand.
- **Network Ready:** Contains libraries (java.net) for network programming.

---

<aside>

## **Java Platforms**

</aside>

- **J2SE (Standard Edition):** Core platform for desktop applications.
- **J2EE (Enterprise Edition):** For business applications, development, and deployment.
- **J2ME (Micro Edition):** For small consumer devices like mobile phones.
- **Java Card:** For smart cards.
- **JavaFX:** For Rich Internet Applications (RIAs).

---

<aside>

## **Components of the Java Platform**

</aside>

1. **Java Virtual Machine (JVM):** A platform-independent environment that converts Java bytecode into machine language and executes it.
2. **Java API:** A collection of ready-made software components (libraries/packages) providing various capabilities.

---

<aside>

## **Java Application Types**

</aside>

- **Standalone Application:** Runs on its own without a host environment.
- **Java Applet:** Embedded in an HTML page and run by a web browser.
- **Java Servlet:** Small application running on a Java-enabled application server (J2EE).
- **Java Bean:** Reusable component visually manipulated in builder tools.

---

<aside>

# Definition Control Structures

</aside>

- **Flow of Control:** The order in which statements are executed in a program.

---

<aside>

## **1. Sequential Control**

</aside>

- **How it Works:** Statements are executed in a linear, line-by-line order (Statement 1 $\rightarrow$ Statement 2 $\rightarrow$ Statement 3).

---

<aside>

## **2. Selection Control (Decision Making)**

</aside>

- **Definition:** Structures that choose an action based on a condition (true or false).

<aside>

**A. `if` Statement**

- **Single Alternative:** Executes a statement only if the condition is.
    
    ```java
    if (condition)
      statement;
    ```
    
- **Two Alternatives:** Executes one statement if true, and an alternate statement (`else`) if false.
    
    ```java
    if (condition)
    	statement;
    else
      statement;
    ```
    
- **Multiple Alternatives:** Checks multiple conditions in sequence using `else if`.
    
    ```java
    if (condition1)
      statement;
    else if (condition2)
      statement;
    else
      statement;
    ```
    

**B. `switch` Statement**

- **How it Works:** Selects a statement to execute by comparing an expression against multiple `case` constants.
    
    ```java
    switch (expression) {
      case constant1: statement; break;
      case constant2: statement; break;
      default: statement;
    }
    ```
    
    *Explanation: The program jumps to the matching case. `break` exits the switch structure; `default` executes if no matches are found.*
    
</aside>

---

<aside>

## **3. Iteration Control (Loops)**

</aside>

- **Definition:** Structures that repeat an action while a condition is true.

<aside>

**A. `for` Loop**

- **How it Works:** Used when the number of iterations is known. It groups initialization, condition, and increment/decrement.
    
    ```java
    for (initialization; condition; increment/decrement)
      statement;
    ```
    

**B. `while` Loop**

- **How it Works:** Repeats a statement as long as the condition remains true. The condition is checked *before* the statement executes.
    
    ```java
    while (condition)
      statement;
    ```
    

**C. `do...while` Loop**

- **How it Works:** Executes the statement *first*, then checks the condition. This guarantees the code runs at least once.
    
    ```java
    do {
      statement;
    } while (condition);
    ```
    
</aside>

---

<aside>

# References

</aside>

* [introduction to java.pdf](https://drive.google.com/file/d/1DG_rJhLcp6j1MR9S5c82uMME6J6b1QbW/view?usp=drive_link)

* [java control structures.pdf](https://drive.google.com/file/d/1Kg0C5bMkzxteN6SeEbxyWQCShOB9atXI/view?usp=drive_link)

---