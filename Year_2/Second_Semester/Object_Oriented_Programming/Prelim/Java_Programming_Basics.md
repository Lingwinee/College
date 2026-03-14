# Java Programming Basics

## 📋 Summary
* **Core Concept:** Java is an object-oriented programming language where programs are structured as classes with a main method as the entry point. The language uses strict naming conventions, type-safe variables, and a comprehensive set of operators for computation and logic.

> **Takeaways:** Java programs must match filenames to class names, use the `.java` extension, and follow specific syntax rules for identifiers, data types, and operators. The language provides primitive types for efficient data storage and supports various operators for arithmetic, comparison, and logical operations.

## 📖 Definition

* **Java Program:** A set of instructions saved with the `.java` extension, where the filename must match the public class name defined within it.
* **Identifiers:** Case-sensitive tokens representing names of variables, methods, and classes. Must begin with a letter, underscore (`_`), or dollar sign (`$`).
* **Variables:** Named data storage locations characterized by a data type and identifier, used to store object state.
* **Literals:** Constant values that remain unchanged during program execution (e.g., `12`, `3.1416`, `'a'`, `"Hello"`).
* **Requirements:**
    * File extension must be `.java`
    * Filename must match the public class name
    * Must contain a `main` method for standalone execution

## 📊 Primitive Data Types

| Type | Size | Range/Values | Purpose |
| :--- | :--- | :--- | :--- |
| `boolean` | 1 bit | `true` or `false` | Logical values |
| `char` | 16 bits | Unicode characters | Single characters |
| `byte` | 8 bits | -128 to 127 | Small integers |
| `short` | 16 bits | -32,768 to 32,767 | Short integers |
| `int` | 32 bits | ±2.1 billion | Standard integers |
| `long` | 64 bits | ±9.2 quintillion | Large integers |
| `float` | 32 bits | ~7 decimal digits | Decimal numbers |
| `double` | 64 bits | ~15 decimal digits | Precise decimals |

* **Integer Types:** `byte`, `short`, `int`, `long` store whole numbers with varying ranges.
* **Floating-Point Types:** `float`, `double` store decimal values with different precision levels.
* **Other Types:** `boolean` for logic, `char` for single characters.

## ❓ Why We Use Java

* **Platform Independence:** Write once, run anywhere through Java Virtual Machine (JVM).
* **Type Safety:** Strict data typing prevents runtime errors and improves code reliability.
* **Object-Oriented Design:** Encourages modular, reusable, and maintainable code structure.
* **Strong Standard Library:** Comprehensive built-in classes and methods reduce development time.

## ⚙️ How It Works

1. **Step 1:** Write code in a `.java` file with a class definition matching the filename.
2. **Step 2:** Define the entry point using the `main` method signature:
   ```java
   public static void main(String[] args)
   ```
3. **Step 3:** Declare variables with specific data types and assign values using literals or expressions.
4. **Step 4:** Use operators to perform computations, comparisons, and logical operations.
5. **Step 5:** Compile the program to bytecode, then execute on the JVM.

## 💻 Program Structure

### Basic Program Template
```java
// Single-line comment
/* Multi-line comment */
/** Javadoc comment for documentation */

public class MyProgram {
    public static void main(String[] args) {
        // Variable declaration and initialization
        int age = 25;
        double price = 19.99;
        char grade = 'A';
        boolean isActive = true;
        String message = "Hello, Java!";
        
        // Output statements
        System.out.print("Age: ");
        System.out.println(age);
    }
}
```

### Variable Declaration Syntax
```java
// Format: <data_type> <identifier> [= initial_value];
int count;              // Declaration only
int total = 0;          // Declaration with initialization
double rate = 5.5;
String name = "Student";
```

### Operators in Action
```java
// Mathematical operators
int a = 10, b = 3;
int sum = a + b;        // 13
int difference = a - b; // 7
int product = a * b;    // 30
int quotient = a / b;   // 3
int remainder = a % b;  // 1

// Shorthand operators
int number = 10;
number += 5;  // number = number + 5; Result: 15
number -= 3;  // number = number - 3; Result: 12
number *= 2;  // number = number * 2; Result: 24

// Increment/Decrement
int x = 5;
x++;  // x becomes 6
x--;  // x becomes 5

// Relational operators
boolean result1 = (10 > 5);   // true
boolean result2 = (10 == 5);  // false
boolean result3 = (10 != 5);  // true

// Logical operators
boolean condition1 = true;
boolean condition2 = false;
boolean and = condition1 && condition2;  // false
boolean or = condition1 || condition2;   // true
boolean not = !condition1;               // false

// Conditional operator (ternary)
int max = (a > b) ? a : b;  // Returns a if a > b, otherwise b

// String concatenation
int days = 365;
String output = "There are " + days + " days in a year.";
System.out.println(output);
```

### Operator Precedence
```java
// Precedence matters in complex expressions
int result = 10 + 5 * 2;  // Result: 20 (multiplication first)
int result2 = (10 + 5) * 2;  // Result: 30 (parentheses first)

// Order: * / % before + -
// Use parentheses to clarify intended order
```

## 📝 Identifier Rules

* **Valid Identifiers:**
    * `myVariable`, `_temp`, `$price`, `user1`, `calculateSum`
* **Invalid Identifiers:**
    * `2ndValue` (starts with digit)
    * `my-variable` (contains hyphen)
    * `class` (reserved keyword)
    * `total value` (contains space)
* **Best Practice:** Use descriptive names following camelCase convention for variables and methods.

## 🔤 Literal Types

| Literal Type | Examples | Description |
| :--- | :--- | :--- |
| Integer | `42`, `0`, `-17` | Whole numbers |
| Floating-point | `3.14`, `2.5e3` | Decimal values |
| Boolean | `true`, `false` | Logical constants |
| Character | `'a'`, `'Z'`, `'5'` | Single characters |
| String | `"Hello"`, `"123"` | Text sequences |

## 📚 References

* [java programming basics.pdf](https://drive.google.com/drive/folders/1t3FETkgxUZmwEY09BQUszx0ORuEs4Jvn?usp=sharing) — Original course material