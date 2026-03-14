# Creating Your Own Class in Java

## 📋 Summary
* **Core Concept:** Classes are blueprints for creating objects in Java. They encapsulate data (attributes/fields) and behavior (methods) into a single unit, implementing the object-oriented programming paradigm.

> **Takeaways:** A class defines the structure and behavior of objects. Instance variables belong to individual objects, while static variables are shared across all objects. Access modifiers control visibility and enforce encapsulation. Constructors initialize objects when they are created. Getter and setter methods provide controlled access to private fields.

---

## 📖 Definition

* **Class:** A blueprint or template that defines the structure and behavior of objects.

* **Object:** An instance of a class created using the `new` keyword.

* **Attribute (Field/Property):** A variable declared inside a class that represents the state or data of an object.

* **Instance Variable:** A variable that belongs to an object. Each object has its own copy with potentially different values.

* **Static Variable:** A variable that belongs to the class itself. All objects share the same value.

* **Method:** A function defined inside a class that represents the behavior or actions an object can perform.

* **Constructor:** A special method used to initialize objects when they are created. It has the same name as the class and no return type.

* **Access Modifier:** A keyword that controls the visibility and accessibility of classes, fields, and methods.

* **Encapsulation:** The practice of hiding internal details and providing controlled access through public methods.

* **Getter Method (Accessor):** A method that returns the value of a private field.

* **Setter Method (Mutator):** A method that changes the value of a private field.

* **`this` Keyword:** A reference to the current object instance.

---

## 📊 Class Components Overview

| Component | Purpose | Syntax Example | Access Level |
| :--- | :--- | :--- | :--- |
| Instance Variable | Store object-specific data | `private int age;` | Usually private |
| Static Variable | Store class-level data | `private static int count;` | Usually private |
| Constructor | Initialize new objects | `public ClassName() { }` | Usually public |
| Getter Method | Read private field values | `public int getAge()` | Usually public |
| Setter Method | Modify private field values | `public void setAge(int age)` | Usually public |
| Regular Method | Define object behavior | `public void doSomething()` | Varies |

---

## 🔒 Access Modifiers

### Access Levels Comparison

| Modifier | Same Class | Same Package | Different Package (Subclass) | Different Package (Non-subclass) |
| :--- | :---: | :---: | :---: | :---: |
| `public` | ✓ | ✓ | ✓ | ✓ |
| `protected` | ✓ | ✓ | ✓ | ✗ |
| default (no keyword) | ✓ | ✓ | ✗ | ✗ |
| `private` | ✓ | ✗ | ✗ | ✗ |

### Best Practices (Rule of Thumb)

* **Classes:** `public`
* **Fields:** `private`
* **Constructors:** `public`
* **Getters and Setters:** `public`
* **Other methods:** Decide case-by-case based on requirements

*Note: These rules can be violated when there is a valid reason.*

---

## 📝 Class Definition Syntax

### Basic Class Structure

```java
<modifier> class <class_name> {
    // Attributes (fields)
    <modifier> <type> <name> [= default_value];
    
    // Constructor
    <modifier> <class_name>([parameter_list]) {
        // Initialization code
    }
    
    // Methods
    <modifier> <return_type> <method_name>([parameter_list]) {
        // Method body
    }
}
```

### Complete Example: Account Class

```java
public class Account {
    // Instance variables (private)
    private int acctNum;
    private String acctName;
    private float acctBal;
    
    // Static variable (shared by all Account objects)
    private static int accountCount = 0;
    
    // Constructor
    public Account() {
        acctNum = 100;
        acctName = "Mike Rowe";
        acctBal = 20000F;
        accountCount++;  // Increment count when new account created
    }
    
    // Parameterized constructor
    public Account(int num, String name, float bal) {
        this.acctNum = num;
        this.acctName = name;
        this.acctBal = bal;
        accountCount++;
    }
    
    // Getter methods
    public int getAcctNum() {
        return acctNum;
    }
    
    public String getAcctName() {
        return acctName;
    }
    
    public float getAcctBal() {
        return acctBal;
    }
    
    public static int getAccountCount() {
        return accountCount;
    }
    
    // Setter methods
    public void setAcctNum(int acctNum) {
        this.acctNum = acctNum;
    }
    
    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }
    
    public void setAcctBal(float acctBal) {
        this.acctBal = acctBal;
    }
    
    // Regular methods
    public void deposit(float amt) {
        if (amt > 0) {
            acctBal += amt;
        }
    }
    
    public void withdraw(float amt) {
        if (amt > 0 && amt <= acctBal) {
            acctBal -= amt;
        }
    }
    
    public void displayInfo() {
        System.out.println("Account Number: " + acctNum);
        System.out.println("Account Name: " + acctName);
        System.out.println("Account Balance: " + acctBal);
    }
}
```

---

## 🆚 Instance Variables vs. Static Variables

### Visual Comparison

```
Class: Car
┌─────────────────────────────────────────────────────┐
│ Static Variable (shared by all Car objects)        │
│ count = 2                                           │
└─────────────────────────────────────────────────────┘

Object: Car A                    Object: Car B
┌──────────────────────┐         ┌──────────────────────┐
│ plateNum: "ABC 111"  │         │ plateNum: "XYZ 123"  │
│ color: "blue"        │         │ color: "red"         │
│ brand: "Mitsubishi"  │         │ brand: "Toyota"      │
│ speed: 75 km/hr      │         │ speed: 100 km/hr     │
└──────────────────────┘         └──────────────────────┘
```

### Key Differences

| Aspect | Instance Variable | Static Variable |
| :--- | :--- | :--- |
| Belongs to | Individual object | Entire class |
| Memory allocation | When object is created | When class is loaded |
| Value | Different for each object | Same for all objects |
| Access | `object.variable` | `ClassName.variable` |
| Example use case | Account balance | Count of all accounts |

---

## 💻 Practical Examples

### Example 1: Basic Class with Instance Variables
```java
// Define the Student class
public class Student {
    // Instance variables
    private String name;
    private int id;
    private double gpa;
    
    // Constructor
    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    // Setter methods
    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        }
    }
    
    // Method to display student info
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("GPA: " + gpa);
    }
}

// Using the Student class
public class StudentTest {
    public static void main(String[] args) {
        // Create student object
        Student student1 = new Student("Alice", 12345, 3.8);
        
        // Display information
        student1.displayInfo();
        
        // Modify GPA using setter
        student1.setGpa(3.9);
        System.out.println("\nAfter updating GPA:");
        student1.displayInfo();
    }
}
```

**Output:**
```
Name: Alice
ID: 12345
GPA: 3.8

After updating GPA:
Name: Alice
ID: 12345
GPA: 3.9
```

### Example 2: Static Variables - Tracking Object Count
```java
public class Car {
    // Instance variables
    private String plateNum;
    private String color;
    private String brand;
    private int speed;
    
    // Static variable - shared by all Car objects
    private static int carCount = 0;
    
    // Constructor
    public Car(String plateNum, String color, String brand) {
        this.plateNum = plateNum;
        this.color = color;
        this.brand = brand;
        this.speed = 0;
        carCount++;  // Increment count when new car is created
    }
    
    // Static method to get car count
    public static int getCarCount() {
        return carCount;
    }
    
    // Instance methods
    public void accelerate(int increase) {
        speed += increase;
        System.out.println(brand + " accelerated to " + speed + " km/hr");
    }
    
    public void displayInfo() {
        System.out.println("Plate: " + plateNum + ", Color: " + color + 
                           ", Brand: " + brand + ", Speed: " + speed + " km/hr");
    }
}

// Test the Car class
public class CarTest {
    public static void main(String[] args) {
        System.out.println("Initial car count: " + Car.getCarCount());
        
        Car car1 = new Car("ABC 111", "blue", "Mitsubishi");
        System.out.println("After creating car1: " + Car.getCarCount());
        
        Car car2 = new Car("XYZ 123", "red", "Toyota");
        System.out.println("After creating car2: " + Car.getCarCount());
        
        car1.accelerate(75);
        car2.accelerate(100);
        
        System.out.println("\nCar 1 Info:");
        car1.displayInfo();
        System.out.println("\nCar 2 Info:");
        car2.displayInfo();
        
        System.out.println("\nTotal cars created: " + Car.getCarCount());
    }
}
```

**Output:**
```
Initial car count: 0
After creating car1: 1
After creating car2: 2
Mitsubishi accelerated to 75 km/hr
Toyota accelerated to 100 km/hr

Car 1 Info:
Plate: ABC 111, Color: blue, Brand: Mitsubishi, Speed: 75 km/hr

Car 2 Info:
Plate: XYZ 123, Color: red, Brand: Toyota, Speed: 100 km/hr

Total cars created: 2
```

### Example 3: Access Modifiers in Action
```java
// Package: packageA
public class ClassA {
    public int pubX = 1;
    protected int protX = 2;
    int defX = 3;  // default access
    private int privX = 4;
    
    public void showAccess() {
        // All variables are accessible within the same class
        System.out.println("pubX: " + pubX);
        System.out.println("protX: " + protX);
        System.out.println("defX: " + defX);
        System.out.println("privX: " + privX);
    }
}

// Package: packageA (same package)
public class ClassAA {
    public void testAccess() {
        ClassA obj = new ClassA();
        System.out.println("pubX: " + obj.pubX);     // OK
        System.out.println("protX: " + obj.protX);   // OK
        System.out.println("defX: " + obj.defX);     // OK
        // System.out.println("privX: " + obj.privX); // ERROR: private
    }
}

// Package: packageB (different package, subclass)
public class SubclassA2 extends ClassA {
    public void testAccess() {
        System.out.println("pubX: " + pubX);      // OK
        System.out.println("protX: " + protX);    // OK
        // System.out.println("defX: " + defX);    // ERROR: default
        // System.out.println("privX: " + privX);  // ERROR: private
    }
}

// Package: packageB (different package, non-subclass)
public class ClassB {
    public void testAccess() {
        ClassA obj = new ClassA();
        System.out.println("pubX: " + obj.pubX);     // OK
        // System.out.println("protX: " + obj.protX); // ERROR: protected
        // System.out.println("defX: " + obj.defX);   // ERROR: default
        // System.out.println("privX: " + obj.privX); // ERROR: private
    }
}
```

### Example 4: Constructor Overloading
```java
public class Rectangle {
    private double width;
    private double height;
    
    // Default constructor
    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
        System.out.println("Default constructor called");
    }
    
    // Parameterized constructor (square)
    public Rectangle(double side) {
        this.width = side;
        this.height = side;
        System.out.println("Square constructor called");
    }
    
    // Parameterized constructor (rectangle)
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        System.out.println("Rectangle constructor called");
    }
    
    public double getArea() {
        return width * height;
    }
    
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    public void displayInfo() {
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}

// Test constructor overloading
public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle();
        System.out.println("Rectangle 1:");
        rect1.displayInfo();
        
        System.out.println("\n---");
        
        Rectangle rect2 = new Rectangle(5.0);
        System.out.println("\nRectangle 2 (Square):");
        rect2.displayInfo();
        
        System.out.println("\n---");
        
        Rectangle rect3 = new Rectangle(4.0, 6.0);
        System.out.println("\nRectangle 3:");
        rect3.displayInfo();
    }
}
```

**Output:**
```
Default constructor called
Rectangle 1:
Width: 1.0
Height: 1.0
Area: 1.0
Perimeter: 4.0

---
Square constructor called

Rectangle 2 (Square):
Width: 5.0
Height: 5.0
Area: 25.0
Perimeter: 20.0

---
Rectangle constructor called

Rectangle 3:
Width: 4.0
Height: 6.0
Area: 24.0
Perimeter: 20.0
```

### Example 5: Using `this` Keyword
```java
public class Person {
    private String name;
    private int age;
    
    // Constructor using 'this' to differentiate between parameters and fields
    public Person(String name, int age) {
        this.name = name;  // this.name refers to the instance variable
        this.age = age;    // name and age refer to the parameters
    }
    
    // Setter using 'this'
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    // Method that calls another method using 'this'
    public void introduce() {
        System.out.println("Hi, I'm " + this.name);
        this.showAge();  // Calling another method using 'this'
    }
    
    private void showAge() {
        System.out.println("I am " + this.age + " years old");
    }
    
    // Method that returns 'this' for method chaining
    public Person setNameChain(String name) {
        this.name = name;
        return this;  // Return current object
    }
    
    public Person setAgeChain(int age) {
        this.age = age;
        return this;  // Return current object
    }
    
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Test the Person class
public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("Alice", 25);
        person1.introduce();
        
        System.out.println("\n---");
        
        // Method chaining using 'this'
        Person person2 = new Person("", 0);
        person2.setNameChain("Bob").setAgeChain(30).display();
    }
}
```

**Output:**
```
Hi, I'm Alice
I am 25 years old

---
Name: Bob, Age: 30
```

### Example 6: Complete Banking System Example
```java
public class BankAccount {
    // Instance variables
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    
    // Static variable to track total accounts
    private static int totalAccounts = 0;
    private static double totalBankBalance = 0.0;
    
    // Default constructor
    public BankAccount() {
        this.accountNumber = 0;
        this.accountHolderName = "Unknown";
        this.balance = 0.0;
        totalAccounts++;
    }
    
    // Parameterized constructor
    public BankAccount(int accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        totalAccounts++;
        totalBankBalance += initialBalance;
    }
    
    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    
    public static double getTotalBankBalance() {
        return totalBankBalance;
    }
    
    // Setters
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    
    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            totalBankBalance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            totalBankBalance -= amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("New balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds");
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }
    
    // Transfer method
    public void transfer(BankAccount recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            recipient.deposit(amount);
            System.out.println("Transferred $" + amount + " to " + recipient.getAccountHolderName());
        } else {
            System.out.println("Transfer failed");
        }
    }
    
    // Display account information
    public void displayAccountInfo() {
        System.out.println("=====================================");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
        System.out.println("=====================================");
    }
    
    // Static method to display bank statistics
    public static void displayBankStats() {
        System.out.println("\n===== BANK STATISTICS =====");
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Total Bank Balance: $" + totalBankBalance);
        System.out.println("===========================\n");
    }
}

// Test the banking system
public class BankTest {
    public static void main(String[] args) {
        // Create accounts
        BankAccount account1 = new BankAccount(1001, "Alice Johnson", 5000.0);
        BankAccount account2 = new BankAccount(1002, "Bob Smith", 3000.0);
        
        // Display initial information
        account1.displayAccountInfo();
        account2.displayAccountInfo();
        
        BankAccount.displayBankStats();
        
        // Perform transactions
        System.out.println("\n--- Transaction 1: Alice deposits $1000 ---");
        account1.deposit(1000.0);
        
        System.out.println("\n--- Transaction 2: Bob withdraws $500 ---");
        account2.withdraw(500.0);
        
        System.out.println("\n--- Transaction 3: Alice transfers $2000 to Bob ---");
        account1.transfer(account2, 2000.0);
        
        // Display final information
        System.out.println("\n--- Final Account Status ---");
        account1.displayAccountInfo();
        account2.displayAccountInfo();
        
        BankAccount.displayBankStats();
    }
}
```

**Output:**
```
=====================================
Account Number: 1001
Account Holder: Alice Johnson
Balance: $5000.0
=====================================
=====================================
Account Number: 1002
Account Holder: Bob Smith
Balance: $3000.0
=====================================

===== BANK STATISTICS =====
Total Accounts: 2
Total Bank Balance: $8000.0
===========================

--- Transaction 1: Alice deposits $1000 ---
Deposited: $1000.0
New balance: $6000.0

--- Transaction 2: Bob withdraws $500 ---
Withdrawn: $500.0
New balance: $2500.0

--- Transaction 3: Alice transfers $2000 to Bob ---
Withdrawn: $2000.0
New balance: $4000.0
Deposited: $2000.0
New balance: $4500.0
Transferred $2000.0 to Bob Smith

--- Final Account Status ---
=====================================
Account Number: 1001
Account Holder: Alice Johnson
Balance: $4000.0
=====================================
=====================================
Account Number: 1002
Account Holder: Bob Smith
Balance: $4500.0
=====================================

===== BANK STATISTICS =====
Total Accounts: 2
Total Bank Balance: $8500.0
===========================
```

---

## 🔑 Key Concepts Summary

### Object-Oriented Programming Principles

1. **Encapsulation:** Hide internal details and provide controlled access through methods
2. **Information Hiding:** Use private fields and public getters/setters
3. **Single Responsibility:** Each class should have one clear purpose
4. **Cohesion:** Related data and methods should be grouped together

### Constructor Rules

1. **Name:** Must match the class name exactly (case-sensitive)
2. **Return Type:** None (not even `void`)
3. **Invocation:** Called automatically when using `new` keyword
4. **Default Constructor:** Provided by Java if no constructor is defined
5. **Overloading:** Multiple constructors with different parameters are allowed

### Method Naming Conventions

* **Getters:** `get<FieldName>()` - Example: `getName()`
* **Setters:** `set<FieldName>()` - Example: `setName(String name)`
* **Boolean getters:** `is<FieldName>()` - Example: `isEmpty()`
* **Regular methods:** Use verb or verb phrases - Example: `calculateTotal()`

### Common Patterns

**Property Pattern:**
```java
private Type fieldName;

public Type getFieldName() {
    return fieldName;
}

public void setFieldName(Type fieldName) {
    this.fieldName = fieldName;
}
```

**Validation in Setters:**
```java
public void setAge(int age) {
    if (age >= 0 && age <= 150) {
        this.age = age;
    } else {
        System.out.println("Invalid age");
    }
}
```

**Method Chaining:**
```java
public ClassName setProperty(Type value) {
    this.property = value;
    return this;  // Return current object
}
```

---

## 📚 References
* [Creating Classes Presentation](https://drive.google.com/file/d/1dyesEo5pb3fQQ7LkDjq8NeuuDKQwnxUl/view?usp=drive_link) — Drive Link.
* **Java Programming Language Specification**
* **Object-Oriented Programming Concepts**
* **Java Coding Standards and Best Practices**

---

## 💡 Additional Notes

### For Cybersecurity Context

**Security Best Practices:**
* Always validate input in setter methods to prevent injection attacks
* Use private fields to prevent unauthorized access
* Implement proper authentication in methods that modify sensitive data
* Consider using immutable objects for security-critical data

### For AR/VR Applications

**Performance Considerations:**
* Minimize object creation in real-time rendering loops
* Use object pooling patterns for frequently created/destroyed objects
* Keep instance variables lightweight for better memory performance
* Use static variables sparingly to avoid memory overhead

### Study Tips

1. **Practice writing classes from scratch** without looking at examples
2. **Understand the difference** between instance and static members
3. **Memorize access modifier rules** using the visibility table
4. **Always use proper encapsulation** - make fields private, provide public getters/setters
5. **Name constructors exactly as the class name** - common mistake to avoid
6. **Use `this` keyword** when parameter names match field names
7. **Draw UML diagrams** to visualize class structure before coding
8. **Test each class thoroughly** before integrating with other classes

### Common Mistakes to Avoid

1. **Forgetting to use `this`** when parameter names match field names
2. **Making fields public** instead of using getters/setters
3. **Adding return type to constructors** (constructors have no return type)
4. **Confusing static and instance variables**
5. **Not validating input** in setter methods
6. **Creating unnecessary getters/setters** for internal implementation details
7. **Using mutable objects** without proper defensive copying