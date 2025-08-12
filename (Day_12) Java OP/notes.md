# 📚 Java OOP Learning Resources

## 1. Core OOP Concepts in Java

Before diving into resources, make sure you’re familiar with the **four pillars of OOP**:

1. **Encapsulation** → Wrapping data and methods into a single unit (class).
2. **Inheritance** → Reusing properties and methods from existing classes.
3. **Polymorphism** → Same interface, different implementations.
4. **Abstraction** → Hiding implementation details, showing only the essentials.

---

## 2. Official Documentation

* **[Java SE Documentation](https://docs.oracle.com/javase/8/docs/)** – The official and most authoritative reference.
* **[Java Tutorials by Oracle](https://docs.oracle.com/javase/tutorial/java/concepts/)** – Clear explanations of OOP basics and beyond.

---

## 3. Beginner-Friendly Guides

* **[W3Schools Java OOP Tutorial](https://www.w3schools.com/java/java_oop.asp)** – Quick and interactive.
* **[Programiz Java OOP Guide](https://www.programiz.com/java-programming/object-oriented-programming)** – Examples with step-by-step explanations.
* **[GeeksforGeeks Java OOP Series](https://www.geeksforgeeks.org/object-oriented-programming-oops-concept-in-java/)** – Covers theory with plenty of code snippets.

---

## 4. Sample OOP Code

```java
public class Car {
    private String brand;
    private int year;

    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void startEngine() {
        System.out.println(brand + " engine started!");
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", 2022);
        car.startEngine();
    }
}
```