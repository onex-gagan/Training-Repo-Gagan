# 🛠️ Build & Automation Exercise – Java + Maven

## 📌 Objective

This exercise demonstrates how to:
- Write a simple Java project
- Write unit tests using **JUnit 5**
- Build and run the project using **Maven**
- Automate the build, test, and run process using a **custom Bash script**



### ✅ A simple `Person` Class to simulate the build script
- Constructor to initialize name
- Getter and setter to access and update the name


### 🧾 What `build.sh` Does

The `build.sh` script automates the following steps in our Java Maven project:

1. **Cleans the project** using `mvn clean`  
   → Deletes previously compiled files to ensure a fresh build.

2. **Runs unit tests** using `mvn test`  
   → Executes all JUnit test cases. If any test fails, the script stops here.

3. **Packages the project** using `mvn package`  
   → Compiles the source code and creates a `.jar` file inside the `target/` directory.

4. **Runs the application** using `java -cp`  
   → Launches the `Main` class from the generated `.jar` file.
