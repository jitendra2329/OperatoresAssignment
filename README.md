# OperatorsAssignment

This code defines several operators and their corresponding functions for a calculator. The operators are defined as objects and have a common interface of validate, validateAndExecute, and execute functions. The validate function checks whether the operands are valid for that particular operator, and the execute function performs the operation on the operands.

The validateAndExecute function is a convenience function that first checks the validity of the operands using the validate function and then performs the operation using the execute function.

The Operator trait defines the common interface for all operators, and the CalculatorException class is a user-defined exception that is thrown when there is an error in the calculation.

The operators defined in this code are:

    Addition: performs addition of two numbers.
    Subtraction: performs subtraction of two numbers.
    Multiplication: performs multiplication of two numbers.
    Division: performs division of two numbers.
    Power: calculates the power of a number to another number.
    SquareRoot: calculates the square root of a number.
    Factorial: calculates the factorial of a number.
    Summation: calculates the sum of a list of numbers.
    GetOddOperands: filters odd numbers from a list of numbers.
    GetEvenOperands: filters even numbers from a list of numbers.

All the operators have a validate function that checks the validity of the operands for that operator. Some of them also have a validateAndExecute function, which is a convenience function that first checks the validity of the operands using the validate function and then performs the operation using the execute function. The execute function performs the actual operation on the operands and returns the result as a sequence.

The Factorial operator uses tail recursion to calculate the factorial of a number. The GetOddOperands and GetEvenOperands operators use the filter function to filter odd and even numbers from a list of numbers, respectively.

The code uses the Scala logging library to log information about the validation of operands.

This code also hold three more funcationalities -> SquareOfExpression, FindNumbers and FindAverageAfterChangingOperations

    => SquareOfExpression 
       -> This is for comparing whether (a + b)^2 = a^2 + b^2 + 2ab or not 
    
    => FindNumbers
      -> This is for getting all those numbers of a sequence whose factorail is greater than 6^number
     
    => FindAverageAfterChangingOperations
      -> This is for for getting average by performing some operations like-
          1. getting odd values from sequence 
          2. then add those values 
          3. then find average of them
   
