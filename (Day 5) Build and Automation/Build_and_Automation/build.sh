#!/bin/bash

# Step 1: Clean previous builds
echo "🔄 Cleaning project..."
mvn clean

# Step 2: Run tests
echo "🧪 Running tests..."
mvn test
if [ $? -ne 0 ]; then
  echo "❌ Tests failed. Build stopped."
  exit 1
fi

# Step 3: Compile and package
echo "📦 Packaging project..."
mvn package

# Step 4: Run the application
echo "🚀 Running the application..."
java -cp target/Build_and_Automation-1.0-SNAPSHOT.jar org.example.build_n_automation.Main