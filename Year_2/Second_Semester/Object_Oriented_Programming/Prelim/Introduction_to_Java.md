# Java Programming Fundamentals

## 📋 Summary
* **Core Concept:** Java is a robust, object-oriented, platform-independent programming language that uses the Java Virtual Machine (JVM) to achieve "Write Once, Run Anywhere" capability across different operating systems.

> **Takeaways:** Java combines platform independence, strong memory management, and object-oriented design to create secure, scalable applications ranging from desktop programs to enterprise web services.

---

## 📖 Definition

* **Java:** A platform-neutral, object-oriented, and secure programming language developed by Sun Microsystems (now owned by Oracle).
* **Java Virtual Machine (JVM):** A platform-independent execution environment that converts Java bytecode into machine-specific instructions.
* **Bytecode:** Intermediate compiled format of Java source code, executable on any platform with a JVM.
* **WORA Principle:** "Write Once, Run Anywhere" - Java code compiled on one operating system can run on any other OS with a JVM.

### **History**
* **Origin:** Developed by Sun Microsystems in the early 1990s
* **Lead Creator:** James Gosling
* **Original Name:** "Oak" (designed for consumer electronics)
* **Current Name:** "Java" (inspired by Java coffee, the programmers' favorite drink)

---

## 🎯 Key Features (Why Use Java?)

| Feature | Description | Benefit |
| :--- | :--- | :--- |
| **Platform Independent** | WORA capability via JVM | Deploy anywhere |
| **Object-Oriented** | Classes, inheritance, polymorphism | Code reusability |
| **Simple** | Clean syntax, automatic memory management | Easy to learn |
| **Robust** | Strong type checking, exception handling | Fewer runtime errors |
| **Secure** | Sandbox execution, no explicit pointers | Safe from malicious code |
| **Multi-threaded** | Concurrent execution support | Better CPU utilization |
| **Dynamic** | Runtime class loading | Flexible applications |
| **Network Ready** | Built-in networking libraries (java.net) | Internet-enabled apps |

---

## 🔧 Java Platforms

* **Java SE (Standard Edition):** Core platform for desktop and standalone applications
* **Java EE (Enterprise Edition):** Framework for large-scale business and web applications
* **Java ME (Micro Edition):** Optimized for resource-constrained devices (mobile phones, IoT)
* **Java Card:** For smart cards and embedded systems
* **JavaFX:** For building rich internet applications (RIAs) with modern UIs

---

## 🏗️ Components of the Java Platform

1. **Java Virtual Machine (JVM)**
   * Platform-independent execution engine
   * Converts bytecode to native machine code
   * Provides runtime environment and memory management

2. **Java API (Application Programming Interface)**
   * Extensive collection of pre-built classes and libraries
   * Organized into packages (e.g., java.lang, java.util, java.io)
   * Provides ready-to-use functionality for common tasks

---

## 📦 Java Application Types

* **Standalone Application:** Independent programs that run directly on the JVM without requiring a browser or server
* **Java Applet:** (Legacy) Small programs embedded in HTML pages, executed by web browsers
* **Java Servlet:** Server-side components running on Java-enabled application servers (Java EE)
* **JavaBean:** Reusable software components following specific conventions, designed for visual manipulation in IDEs

---

# Control Structures

## 📋 Summary
* **Core Concept:** Control structures determine the order and conditions under which statements execute in a program, enabling sequential processing, conditional logic, and repetitive operations.

> **Takeaways:** Java provides three primary control structure types: sequential (linear execution), selection (conditional branching), and iteration (loops), which form the foundation of program logic and flow control.

---

## 📖 Definition

* **Flow of Control:** The order in which program statements are executed
* **Control Structure:** Programming constructs that dictate the execution path based on conditions and logic
* **Boolean Expression:** An expression that evaluates to either `true` or `false`, used in decision-making structures

---

## ⚙️ How Control Structures Work

### **1. Sequential Control**

Statements execute in linear order, from top to bottom, one after another.

```java
// Example: Sequential execution
public class SequentialExample {
    public static void main(String[] args) {
        int a = 10;              // Statement 1
        int b = 20;              // Statement 2
        int sum = a + b;         // Statement 3
        System.out.println("Sum: " + sum); // Statement 4
    }
}
// Output: Sum: 30
```

---

### **2. Selection Control (Decision Making)**

Executes different code blocks based on boolean conditions.

#### **A. `if` Statement**

**Single Alternative (if):**
```java
// Execute code only if condition is true
public class IfExample {
    public static void main(String[] args) {
        int age = 20;
        
        if (age >= 18) {
            System.out.println("You are eligible to vote.");
        }
    }
}
// Output: You are eligible to vote.
```

**Two Alternatives (if-else):**
```java
// Execute one block if true, another if false
public class IfElseExample {
    public static void main(String[] args) {
        int number = 7;
        
        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
    }
}
// Output: 7 is odd.
```

**Multiple Alternatives (if-else if-else):**
```java
// Check multiple conditions in sequence
public class GradeCalculator {
    public static void main(String[] args) {
        int score = 85;
        
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }
}
// Output: Grade: B
```

#### **B. `switch` Statement**

Selects one of many code blocks to execute based on the value of an expression.

```java
// Example: Day of the week
public class SwitchExample {
    public static void main(String[] args) {
        int day = 3;
        String dayName;
        
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
                break;
        }
        
        System.out.println("Day " + day + " is " + dayName);
    }
}
// Output: Day 3 is Wednesday
```

**Note:** The `break` statement exits the switch block. Without it, execution "falls through" to subsequent cases. The `default` case handles values that don't match any case.

---

### **3. Iteration Control (Loops)**

Repeats a block of code while a condition remains true.

#### **A. `for` Loop**

Best used when the number of iterations is known in advance.

**Syntax:**
```java
for (initialization; condition; increment/decrement) {
    // statements
}
```

**Example:**
```java
// Print numbers from 1 to 5
public class ForLoopExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number: " + i);
        }
    }
}
/* Output:
Number: 1
Number: 2
Number: 3
Number: 4
Number: 5
*/
```

**Array Iteration:**
```java
// Calculate sum of array elements
public class ArraySum {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int sum = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        
        System.out.println("Sum: " + sum);
    }
}
// Output: Sum: 150
```

#### **B. `while` Loop**

Checks the condition *before* executing the loop body. Best for unknown iteration counts.

**Syntax:**
```java
while (condition) {
    // statements
}
```

**Example:**
```java
// Count down from 5 to 1
public class WhileLoopExample {
    public static void main(String[] args) {
        int count = 5;
        
        while (count > 0) {
            System.out.println("Count: " + count);
            count--;
        }
        
        System.out.println("Liftoff!");
    }
}
/* Output:
Count: 5
Count: 4
Count: 3
Count: 2
Count: 1
Liftoff!
*/
```

#### **C. `do-while` Loop**

Executes the loop body *first*, then checks the condition. Guarantees at least one execution.

**Syntax:**
```java
do {
    // statements
} while (condition);
```

**Example:**
```java
// Menu system that runs at least once
public class DoWhileExample {
    public static void main(String[] args) {
        int choice;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Option A");
            System.out.println("2. Option B");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("You selected Option A");
                    break;
                case 2:
                    System.out.println("You selected Option B");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);
        
        scanner.close();
    }
}
```

---

## 📊 Loop Comparison

| Loop Type | When to Use | Condition Check | Minimum Executions |
| :--- | :--- | :--- | :--- |
| **for** | Known iteration count | Before execution | 0 |
| **while** | Unknown iteration count | Before execution | 0 |
| **do-while** | Must execute at least once | After execution | 1 |

---

## 💻 Complete Program Example

```java
/**
 * Comprehensive example demonstrating all control structures
 * Program: Student Grade Management System
 */
public class GradeManagementSystem {
    public static void main(String[] args) {
        // Sequential: Variable declarations
        String studentName = "Alice";
        int[] scores = {85, 92, 78, 90, 88};
        int totalScore = 0;
        double average;
        
        // Iteration: Calculate total using for loop
        System.out.println("Student: " + studentName);
        System.out.println("Scores:");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + scores[i]);
            totalScore += scores[i];
        }
        
        // Sequential: Calculate average
        average = (double) totalScore / scores.length;
        System.out.println("\nTotal Score: " + totalScore);
        System.out.println("Average: " + average);
        
        // Selection: Determine grade using if-else if
        String grade;
        if (average >= 90) {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else if (average >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        
        System.out.println("Final Grade: " + grade);
        
        // Selection: Performance message using switch
        switch (grade) {
            case "A":
                System.out.println("Excellent performance!");
                break;
            case "B":
                System.out.println("Good job!");
                break;
            case "C":
                System.out.println("Satisfactory work.");
                break;
            case "D":
                System.out.println("Needs improvement.");
                break;
            default:
                System.out.println("Please study harder.");
                break;
        }
        
        // Iteration: Count passing subjects using while loop
        int passingCount = 0;
        int index = 0;
        while (index < scores.length) {
            if (scores[index] >= 60) {
                passingCount++;
            }
            index++;
        }
        
        System.out.println("\nPassing Subjects: " + passingCount + "/" + scores.length);
    }
}

/* Sample Output:
Student: Alice
Scores:
Subject 1: 85
Subject 2: 92
Subject 3: 78
Subject 4: 90
Subject 5: 88

Total Score: 433
Average: 86.6
Final Grade: B
Good job!

Passing Subjects: 5/5
*/
```

---

## 🔑 Key Takeaways

* **Sequential Control:** Default execution model; statements run line by line
* **Selection Control:** Use `if` for flexible conditions, `switch` for discrete value matching
* **Iteration Control:** Choose `for` for known counts, `while` for unknown counts, `do-while` for guaranteed execution
* **Best Practices:**
  * Always use braces `{}` for clarity, even with single statements
  * Include `break` in switch cases to prevent fall-through (unless intentional)
  * Avoid infinite loops by ensuring loop conditions eventually become false
  * Use meaningful variable names and add comments for complex logic

---

## 📚 References

* [Introduction to Java PDF](https://drive.google.com/file/d/1DG_rJhLcp6j1MR9S5c82uMME6J6b1QbW/view?usp=drive_link)
* [Java Control Structures PDF](https://drive.google.com/file/d/1Kg0C5bMkzxteN6SeEbxyWQCShOB9atXI/view?usp=drive_link)
* Oracle Java Documentation — Official Java SE Documentation
* "Thinking in Java" — Bruce Eckel, 4th Edition