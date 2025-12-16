We use the Factory Design Pattern in a scientific calculator to centralize object creation, remove tight coupling, and allow easy addition of new operators or functions without modifying existing code.
In a scientific calculator, there are many operations such as:
Arithmetic operators (+, -, *, /)
Scientific functions (sin, cos, log, sqrt)
Advanced operators (^, %)
Each operation has different logic but follows a common interface.
If we create these objects directly using new everywhere:
Code becomes long and messy 
Adding a new function means changing multiple files 
Violates open closed principle
Centralization of object creation means The factory decides which operator/function object to create based on user input.
Loose Coupling
The calculator:
Does not know the concrete class (Add, Sin, Log)
Only depends on interfaces
Easier maintenance
Easier testing
What is Factory Design Pattern : The Factory Design Pattern is a creational design pattern that provides a way to create objects without exposing the object creation logic to the client.
Instead of using "new" directly, the client asks a factory to give it an object.
What are the factory functions in our project which creates object on its own?
We have a class in the operators package called OperatorTable which uses lambda expressions to evaluate the expressions given to the stack it creates object automatically based on input given by the user for a particular operation.
