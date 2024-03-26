import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select the sorting algorithm:");
        System.out.println("1: InsertionSort\n2: BubbleSort\n3: QuickSort\n4: MergeSort");

        try {
            System.out.print("Enter your choice (1-4): ");
            int sortAlgorithm = Integer.parseInt(reader.readLine());
            SortTester.testSortPerformance(sortAlgorithm);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (IOException e) {
            System.out.println("program exit with errors");
        }
    }
}
