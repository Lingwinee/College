<aside>

# Summary

</aside>

- These documents provide a foundational overview of Object-Oriented Programming (OOP) principles, specifically focusing on the definitions of classes and objects. They further detail the technical syntax for implementing classes in Java, including the use of attributes, methods, access modifiers, and constructors.

---

<aside>

# Definition

</aside>

- **Object-Orientation:** A technological framework based on objects and classes designed for developing complex, large-scale systems.
- **Class:** A template, blueprint, or prototype that defines variables and methods common to all objects of a certain kind.
- **Object:** A tangible or intangible entity that possesses both **state** (data) and **behavior** (methods).

---

<aside>

## Primary Properties of an OO System

</aside>

- **Encapsulation:** The process of packing data and methods into a single component and protecting that data from outside access.
- **Inheritance:** A concept where classes exist in a parent-child relationship, allowing for hierarchical structures (e.g., a "Car" is a child of "Vehicle").
- **Polymorphism:** The ability of an object to assume many different forms, such as different shapes (Line, Circle) sharing a common "Draw" method.

---

<aside>

## Defining Classes and Attributes

</aside>

### Class Syntax

```java
<modifier> class <class_name> {
    <attribute declaration>
    <method declaration>
}
```

### Declaring Attributes

Attributes (properties) represent the data held by a class. The syntax is:

```java
<modifier> <type> <name> [=default_value];
```

### **Instance Variables vs. Static Variables**

| **Feature** | **Instance Variable** | **Static Variable** |
| --- | --- | --- |
| **Ownership** | Belongs to a specific object | Belongs to the class itself |
| **Value** | Unique to each object | Shared across all objects |
| **Example** | Car color, speed | Total car count |

---

<aside>

## Access Modifiers

</aside>

Access modifiers determine the visibility of classes, variables, and methods.

- **public:** Least restrictive; visible everywhere.
- **protected:** Visible to the same class, same package, and subclasses in different packages.
- **default:** (No keyword used) Visible only to the same class and same package.
- **private:** Most restrictive; visible only within the same class.

### **Standard Rule of Thumb:**

- Classes, constructors, and getters/setters should generally be **public**.
- Fields (attributes) should generally be **private**.

---

<aside>

## Methods

</aside>

Methods define the behaviors of the class.

- **Syntax:** `<modifier> <return_type> <name> ([parameter_list]) { <statements>; }`
- **Getter (Accessor):** Used to read values from variables; they return a value and take no arguments.
- **Setter (Mutator):** Used to change variable values; they take an argument and return `void`.
- **The `this` Keyword:** Refers to the current instance of the class, often used in setters to distinguish between local parameters and class attributes.

---

<aside>

## Objects and Constructors

</aside>

### Instantiation

An object is created using the `new` keyword.

- *Example:* `Account myAccount = new Account();`

### Constructors

A constructor is a special-purpose method used to initialize objects during instantiation.

- **Name:** Must match the class name exactly.
- **Return Type:** Does not have any return type (not even `void`).
- **Invocation:** Cannot be called directly; only triggered via the `new` keyword.
- **Default Constructor:** If no constructor is written, the system provides one with no arguments and an empty body.

---

<aside>

# References

</aside>

[introduction to oop.pdf](https://drive.google.com/file/d/1gX-0gKWjqGXvSr_qltkrQH5RT4cKCtRW/view?usp=drive_link)

[creating classes.pdf](https://drive.google.com/file/d/1dyesEo5pb3fQQ7LkDjq8NeuuDKQwnxUl/view?usp=drive_link)

---