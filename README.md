# StreamCalculator Project

## Overview

The **StreamCalculator** project is a Java application that demonstrates the use of Java Streams for functional programming. It provides a series of utility methods for manipulating lists of integers through various functional operations like filtering, mapping, sorting, and reducing. The project includes both an incomplete implementation (`StreamCalculator.java`) and a fully implemented solution (`StreamCalculator_solution.java`).

---

## Features

### Core Functionality

- **Stream Conversion**
  - `getStream()` - Converts a list of integers into a stream.
  - `getList()` - Retrieves the list of integers.

- **Stream Operations**
  - Sorting: Sort the list in ascending order.
  - Filtering: Filter integers within a specific range.
  - Mapping: Add a constant value to each element of the list.
  - Reduction:
    - `sum()` - Calculates the sum of all integers.
    - `product()` - Calculates the product of all integers.

- **Utility Methods**
  - `print(String separator)` - Prints the list with elements separated by a given delimiter.

- **Composed Operations**
  - `addAndSum(Integer value)` - Adds a constant value to each integer in the list and computes the sum.

### Bonus
- `sumParallel()` - Computes the sum of integers using parallel streams for improved performance with large datasets.

---

## Files

### `StreamCalculator.java`

This is a skeleton implementation of the project, containing placeholders and comments for each required feature. It serves as a template for the assignment.

### `StreamCalculator_solution.java`

This file contains the complete implementation of all required functionalities, including bonus features. It serves as a reference for the expected behavior.

### `.gitignore`

The `.gitignore` file ensures that IDE-specific and temporary files are excluded from version control. It includes configurations for IntelliJ IDEA, Eclipse, NetBeans, VS Code, and common temporary files like `.DS_Store`.

---

## How to Run

1. **Compile the Solution**:
   Ensure you have the Java Development Kit (JDK) installed.
   ```bash
   javac StreamCalculator_solution.java
   ```

2. **Run the Application**:
   ```bash
   java StreamCalculator_solution
   ```

3. The program will:
   - Validate the correctness of methods.
   - Demonstrate the use of filtering, mapping, and reducing operations.
   - Test the `sumParallel` method with a list of 100 randomly generated integers.

---

## Requirements

- **Java Version**: JDK 8 or later (for Stream API support).
- **IDE Support**: Compatible with IntelliJ IDEA, Eclipse, or any Java-capable editor.

---

## Example Usage

### Input

```java
List<Integer> numbers = Arrays.asList(17, 11, 19, 13, 43, 37, 41, 31, 29, 97, 5, 3, 7, 23);
StreamCalculator_solution calc = new StreamCalculator_solution(numbers);
calc.filter(2, 30);
calc.print(", ");
```

### Output

```
17, 11, 19, 13, 29, 5, 3, 7,
```

---

## Contribution

This project is designed for educational purposes, encouraging hands-on learning with Java Streams. If you have ideas for enhancements, feel free to contribute by submitting a pull request.

---

## License

This project is open source and available under the [MIT License](https://opensource.org/licenses/MIT).