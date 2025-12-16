# 🔢 Scientific Calculator (CLI) – Java

A **modular, extensible, command-line scientific calculator** built in **Java**, designed using **clean architecture principles**, **OOP**, and **classic compiler techniques** such as **lexical analysis**, **parsing**, and **Reverse Polish Notation (RPN)** evaluation.

This project goes beyond a basic calculator by supporting:
- Operator precedence & associativity
- Variables & assignments
- Mathematical functions
- Robust error handling
- Clean separation of concerns

---

## 📌 Features

✔️ Supports arithmetic expressions like:
5 + 3 * 2
(10 + 2) / 4
2 ^ 3 ^ 2

bash
Copy code

✔️ Scientific functions:
sin(30)
cos(60)
log(10)
sqrt(16)

wasm
Copy code

✔️ Variables and memory:
x = 5
y = x * 2
y + 10

yaml
Copy code

✔️ Correct operator precedence & associativity  
✔️ Fully CLI-based (no GUI dependencies)  
✔️ Extensible design (easy to add new operators/functions)  
✔️ Custom exceptions for clean error reporting  

---

## 🧠 Project Architecture Overview

This calculator follows a **pipeline-based architecture**, similar to how real compilers work:

User Input (String)
↓
Tokenizer (Lexical Analysis)
↓
Parser (Shunting Yard Algorithm)
↓
RPN Expression
↓
Evaluator (Stack-based execution)
↓
Final Result

yaml
Copy code

---

## 🔄 CLI Execution Flow (Step-by-Step)

### 1️⃣ User Input
The user enters an expression in the CLI:
x = 5 + 3 * 2

yaml
Copy code

---

### 2️⃣ Tokenization (Lexical Analysis)
The **Tokenizer** converts the raw string into meaningful tokens:
["x", "=", "5", "+", "3", "*", "2"]

yaml
Copy code

Responsibilities:
- Removes whitespace
- Identifies numbers, operators, functions, variables, and parentheses
- Uses regular expressions

---

### 3️⃣ Parsing (Shunting Yard Algorithm)
The **Parser** converts infix notation to **Reverse Polish Notation (RPN)**.

Example:
Infix: 5 + 3 * 2
RPN: 5 3 2 * +

yaml
Copy code

Responsibilities:
- Enforces operator precedence
- Handles left/right associativity
- Manages parentheses
- Supports functions

---

### 4️⃣ Evaluation (Stack-Based Execution)
The **Evaluator** processes the RPN expression:

Steps:
1. Push numbers onto a stack
2. Pop operands when an operator/function is encountered
3. Apply the operation
4. Push result back to stack

Final stack value = result.

---

### 5️⃣ Variable Storage
If assignment is detected:
x = 10

csharp
Copy code
The value is stored in a **Variable Store**, enabling reuse:
x * 5 → 50

yaml
Copy code

---

## 📂 Package Structure

calculator/
│
├── core/
│ ├── Tokenizer.java
│ ├── Parser.java
│ ├── Evaluator.java
│
├── operators/
│ ├── Operator.java
│ ├── OperatorTable.java
│
├── functions/
│ ├── Function.java
│ ├── FunctionRegistry.java
│
├── model/
│ ├── VariableStore.java
│
├── exception/
│ ├── SyntaxErrorException.java
│ ├── UnknownVariableException.java
│ ├── DivideByZeroException.java
│
└── Main.java

yaml
Copy code

---

## 🧩 Core Components Explained

### 🔹 Tokenizer
**Purpose:** Converts raw input into tokens.

- Uses regex-based matching
- Identifies:
  - Numbers (`12`, `3.14`)
  - Operators (`+ - * / ^`)
  - Functions (`sin`, `cos`)
  - Variables (`x`, `result`)
  - Parentheses (`(`, `)`)

This stage is equivalent to **lexical analysis** in compilers.

---

### 🔹 Parser (Shunting Yard Algorithm)
**Purpose:** Converts infix expressions to RPN.

Why Shunting Yard?
- Handles precedence cleanly
- Avoids recursive parsing
- Ideal for calculators

Handles:
- Operator precedence
- Left vs right associativity
- Function calls
- Parentheses nesting

---

### 🔹 Operator System
Operators are stored in a centralized **OperatorTable**:

Each operator defines:
- Precedence
- Associativity
- Execution logic (via lambda)

This follows a **Strategy Pattern** style design, allowing:
- Easy addition of new operators
- No changes to parser/evaluator logic

---

### 🔹 Function Registry
Mathematical functions (`sin`, `cos`, `log`, etc.) are registered centrally.

Benefits:
- Clean lookup
- Open-Closed Principle compliant
- New functions can be added without touching core logic

---

### 🔹 Evaluator
Executes the RPN expression using a **stack-based approach**.

Responsibilities:
- Applies operators
- Invokes functions
- Fetches variable values
- Throws meaningful runtime errors

---

### 🔹 Exception Handling
Custom exceptions ensure clarity and robustness:

- `SyntaxErrorException` → malformed expressions
- `UnknownVariableException` → undefined variables
- `ArithmeticException` → divide by zero

This prevents silent failures and improves debugging.

---

## 🛠 Design Principles Used

- **Single Responsibility Principle**
- **Open/Closed Principle**
- **Separation of Concerns**
- **Strategy Pattern**
- **Factory-like Registries**
- **Compiler-style processing pipeline**

---

## 🚀 How to Run

### Prerequisites
- Java 8 or above

### Compile
```bash
javac calculator/**/*.java
Run
bash
Copy code
java calculator.Main
🧪 Sample Input / Output
markdown
Copy code
> x = 10
10

> y = x ^ 2
100

> sqrt(y) + 5
15
🔮 Future Enhancements
Unary operators (-5)

Constants (PI, E)

History tracking

Unit conversions

GUI version (JavaFX/Swing)

Expression optimization

🎯 Learning Outcomes
This project demonstrates:

Real-world application of DSA (Stacks, Maps)

Parsing algorithms used in compilers

Clean, extensible Java architecture

Practical use of design patterns

👨‍💻 Author
Team 25
Ayan Roy (2500031529)
Jai Vardhan Singh (2500032483)
Satyam Kumar Kapri (2500031975)
B.Tech CSE Students
Aspiring Software Engineers

⭐ If you like this project, feel free to star the repository!
