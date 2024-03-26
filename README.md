
# Sorting Performance Test

This project includes a Java application designed to test and compare the performance of different sorting algorithms on datasets of varying sizes.

## Available Sorting Algorithms
- Insertion Sort
- Bubble Sort
- Quick Sort
- Merge Sort


## Running the Program
1. **Compile the Java files.** Navigate to the `src` directory and compile the Java files using the `javac` command. For example:
   ```shell
   javac Main.java SortTester.java algorithms/*.java
   ```

2. **Run the program.** After compilation, run the program using the `java` command from the root directory of the project. You will be prompted to choose a sorting algorithm:
   ```shell
   java Main
   ```
   Follow the instructions to select an algorithm and start the performance test.
   **using windows JVM may need to edit the path of looking DIR for data and result under SortTester.java**
3. **View the results.** After the program has finished running, check the `result` directory for the sorted output files and sorting time used logs.

## Adding New Datasets
To test the sorting algorithms with different datasets, add new `.txt` files to the `data` directory. Each file should contain a list of integers, separated by spaces.

## Extending the Program
To add new sorting algorithms, implement them in the `algorithms` package and update `SortTester.java` to include your new algorithm in the selection menu.
