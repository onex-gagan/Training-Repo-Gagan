# 🚀 Java OOP – Advanced Concepts


## 1. Core Advanced OOP Topics

### 1.1 Abstract Classes & Methods

* **Abstract Class** → Cannot be instantiated; can have both abstract and concrete methods.
* **Abstract Method** → Declared without implementation, must be overridden by subclasses.

```java
abstract class Shape {
    abstract void draw();
    void info() {
        System.out.println("This is a shape.");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing a Circle.");
    }
}
```

---

### 1.2 Interfaces

* Define contracts that classes must follow.
* Support multiple inheritance in Java.
* Can include default and static methods (Java 8+).

```java
interface Drivable {
    void drive();
}

class Car implements Drivable {
    public void drive() {
        System.out.println("Car is driving.");
    }
}
```

---

### 1.3 Method Overloading vs Overriding

* **Overloading** → Same method name, different parameters (compile-time).
* **Overriding** → Subclass provides its own implementation of a superclass method (runtime).

---

### 1.4 Inheritance Depth & `super` Keyword

* Use `super` to call superclass methods or constructors.
* Avoid very deep inheritance chains — they reduce readability.

---

### 1.5 Composition over Inheritance

* Prefer combining objects over extending classes to keep designs flexible.

---

### 1.6 Inner & Nested Classes

* **Static Nested Classes** → Belong to the outer class, no outer instance required.
* **Inner Classes** → Require an outer class instance.

---

### 1.7 Anonymous Classes & Lambda Expressions

* **Anonymous Class** → Create a one-off subclass or implementation inline.
* **Lambda Expressions** → Compact syntax for functional interfaces.

```java
Runnable r = () -> System.out.println("Running in a thread!");
new Thread(r).start();
```

---

### 1.8 Sealed Classes (Java 17+)

* Restrict which classes can extend or implement them.
* Useful for controlling inheritance in large projects.

---

### 1.9 Generics

* Enable type-safe code without casting.
* Used heavily in collections and APIs.

```java
List<String> names = new ArrayList<>();
names.add("Alice"); // only Strings allowed
```

---