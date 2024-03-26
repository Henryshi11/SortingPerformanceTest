import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import algorithms.*;

public class SortTester {
    // private static final String DATA_DIR = System.getProperty("user.dir") + File.separator
    //  + "SortingPerformanceTest" + File.separator + "data";//get data dir using windows jvm
    
    // private static final String RESULT_DIR = System.getProperty("user.dir") + File.separator
    //  + "SortingPerformanceTest" + File.separator + "result"; //get result dir using windows jvm

     private static final String DATA_DIR = System.getProperty("user.dir") + File.separator
     + ".." + File.separator + "data";//get data dir using linux command line
    
    private static final String RESULT_DIR = System.getProperty("user.dir") + File.separator
     + ".." + File.separator + "result"; //get result dir using linux command line

    public static void testSortPerformance(int sortAlgorithm) throws IOException {
        String algorithmName = "";
        File dir = new File(DATA_DIR);
        File[] files = dir.listFiles(); //get all files from data

        if (files == null) {
            System.out.println("The directory is empty or it does not exist: " + DATA_DIR);
            return;
        } else {
            System.out.println("Found " + files.length + " items in the directory.");
            for (File file : files) {
                System.out.println("Item: " + file.getName());
            }
        }

        for (File file : files) {
            if (!file.isFile() || !file.getName().endsWith(".txt")) {
                continue; // Skip non-txt files
            }

            ArrayList<Integer> numbers = readNumbersFromFile(file.getPath());
            long startTime = System.currentTimeMillis();

            switch (sortAlgorithm) {
                case 1:
                    InsertionSort.sort(numbers);
                    algorithmName = "InsertionSort";
                    break;
                case 2:
                    BubbleSort.sort(numbers);
                    algorithmName = "BubbleSort";
                    break;
                case 3:
                    QuickSort.sort(numbers, 0, numbers.size() - 1);
                    algorithmName = "QuickSort";
                    break;
                case 4:
                    MergeSort.sort(numbers, 0, numbers.size() - 1);
                    algorithmName = "MergeSort";
                    break;
                default:
                    System.out.println("Invalid sort algorithm choice.");
                    return;
            }

            long endTime = System.currentTimeMillis();
            writeNumbersToFile(numbers, RESULT_DIR + "/" + file.getName());

            String timeLog = String.format("%s using %s: %d ms\n", file.getName(), algorithmName, (endTime - startTime));
            Files.write(Paths.get(RESULT_DIR, "sorting_times.txt"), timeLog.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
    }

    private static ArrayList<Integer> readNumbersFromFile(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return Arrays.stream(content.trim().split("\\s+"))
                     .map(Integer::parseInt)
                     .collect(Collectors.toCollection(ArrayList::new));
    }

    private static void writeNumbersToFile(ArrayList<Integer> numbers, String filePath) throws IOException {
        List<String> lines = numbers.stream()
                                    .map(String::valueOf)
                                    .collect(Collectors.toList());
        Files.write(Paths.get(filePath), lines);
    }
}
