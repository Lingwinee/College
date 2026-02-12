<aside>

# Summary

</aside>

This document outlines the foundational elements of the Java programming language. It establishes the basic structure of a Java program, including file naming conventions and the `main` method. It details syntax for comments, output statements, and the rules for defining identifiers using specific keywords. The guide categorizes primitive data types (such as integers and Booleans) and literals. Finally, it explains how to declare variables and utilize various operators—mathematical, relational, logical, and conditional—to perform computations and control program flow.

---

<aside>

# Definition

</aside>

- **Java Program:** A set of instructions ending with the `.java` extension, where the filename matches the class name.
- **Identifiers:** Tokens representing names of variables, methods, and classes. They are case-sensitive and must begin with a letter, underscore (`_`), or dollar sign (`$`).
- **Variables:** Data items used to store the state of objects, characterized by a name and a data type.
- **Literals:** Constant tokens that do not change (e.g., `12`, `3.1416`, `'a'`, `"Hello"`).

---

<aside>

## **1. Program Structure**

</aside>

- **File Extension:** A Java program must end with the `.java` extension.
- **Filename:** The filename must match the name of the class defined within it.
- **Main Method:** The entry point for a standard Java program.
    
    ```java
    public static void main(String[] args) {
       // code here
    }
    ```
    

---

<aside>

## **2. Comments**

</aside>

Comments are ignored by the compiler and are used to document code.

- **Single line:** Uses `//`.
- **Multi-line:** Enclosed between `/*` and `*/`.
- **Javadoc:** Enclosed between `/**` and `/`. These are special comments used to generate HTML documentation.

---

<aside>

## **3. Output Statements**

</aside>

Methods used to display text on the screen.

- `System.out.print()`: Prints text without moving to a new line.
- `System.out.println()`: Prints text and moves the cursor to the next line.

---

<aside>

## **4. Identifiers**

</aside>

Identifiers are names given to variables, methods, and classes.

- **Case Sensitivity:** Java identifiers are case-sensitive.
- **Naming Rules:**
    - Must begin with a letter, underscore (`_`), or dollar sign (`$`).
    - Subsequent characters can include numbers 0-9.
    - **Restrictions:** Identifiers cannot use reserved Java keywords (e.g., `class`, `public`, `void`, `int`).

---

<aside>

## **5. Literals**

</aside>

Literals are constant values that do not change.

- **Integer:** Whole numbers (e.g., `12`, `5000`).
- **Floating-point:** Decimals (e.g., `3.1416`, `5.8347e2`).
- **Boolean:** Logical values (`true` or `false`).
- **Character:** Single characters enclosed in quotes (e.g., `'a'`).
- **String:** Text enclosed in double quotes (e.g., `"Hello World"`).

---

<aside>

## **6. Primitive Data Types**

</aside>

Java defines specific types for storing data, each with a set size.

- `boolean`: Logical values.
- `char`: Textual characters.
- `byte`: 8 bits.
- `short`: 16 bits.
- `int`: 32 bits.
- `long`: 64 bits.
- `float`: 32 bits.
- `double`: 64 bits.

---

<aside>

## **7. Variables**

</aside>

A variable is an item of data used to store the state of objects.

- **Components:** A variable has a name and a data type.
- **Syntax:**`<data type> <name> [= initial value];`
    
    *(Values in brackets `[]` are optional)*.
    

---

<aside>

## **8. Operators**

</aside>

<aside>

### **Mathematical Operators**

Used for basic arithmetic. Precedence: `* / %` is higher than `+ -`.

| Operator  | Operation  |
| --- | --- |
| `+`  | Addition  |
| `-`  | Subtraction  |
| `*`  | Multiplication  |
| `/`  | Division  |
| `%`  | Modulo (Remainder) |
</aside>

<aside>

### **Shorthand Operators**

Combine an operation with assignment.

- `+=` (e.g., `number += 50` is `number = number + 50`).
- `-=`, `+=`, `/=`, `%=`.
</aside>

<aside>

### **Increment/Decrement**

- `++`: Increment by 1.
- `--`: Decrement by 1.
</aside>

<aside>

### **Relational Operators**

Used for comparison.

- `<` (Less than), `<=` (Less than or equal).
- `>` (Greater than), `>=` (Greater than or equal).
- `==` (Equal), `!=` (Not equal).
</aside>

<aside>

### **Logical Operators**

Used to combine Boolean expressions.

- `&&`: And.
- `!`: Not.
- `||`: Or.
</aside>

<aside>

### **Conditional & String Operators**

- **Conditional Expression:** `<condition> ? <expr1> : <expr2>`.
- **String Concatenation:** Uses `+` to join strings.
    - *Example:* `"There are " + days + " days..."`.
</aside>

---

<aside>

# References

</aside>

[java programming basics.pdf](https://drive.google.com/drive/folders/1t3FETkgxUZmwEY09BQUszx0ORuEs4Jvn?usp=sharing)

---