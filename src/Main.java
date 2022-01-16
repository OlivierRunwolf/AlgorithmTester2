import java.io.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] listN = {10, 100, 1000, 10000};
        String file = null;
        String addToFile = "";
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter("pqtestrun.txt");
            for (int i = 0; i < listN.length; i++) {
                switch (listN[i]) {
                    case 10, 100, 1000, 10000 -> file = "src/elements_test_file1.txt";
                }
                MyPQUnsortedArray<Integer, String> test = new MyPQUnsortedArray<>();
                MyPQSortedArray<Integer, String> test2 = new MyPQSortedArray<>();
                MyPQUnsortedList<Integer, String> test3 = new MyPQUnsortedList<>();
                MyPQSortedList<Integer, String> test4 = new MyPQSortedList<>();
                try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
                    //loop over list N
                    String line = reader.readLine();
                    Random r = new Random();
                    System.out.println("\n----------------------------------------------------------------------------------------------------------");
                    System.out.println("\n|   N = " + listN[i] + "                   4Insert(k, v) (ms)              4removeMin(k,v) (ms)                    |");
                    addToFile += "\n----------------------------------------------------------------------------------------------------------";
                    addToFile += "\n|   N = " + listN[i] + "                   4Insert(k, v) (ms)              4removeMin(k,v) (ms)                    |";
                    long startTime = System.currentTimeMillis();
                    for (int j1 = 0; j1 < listN[i]; j1++) {
                        test.insert(r.nextInt(listN[i] - 1) + 1, line);
                        line = reader.readLine();
                    }
                    long endTime = System.currentTimeMillis();
                    long timeElapsedInsert = endTime - startTime;
                    startTime = System.currentTimeMillis();
                    for (int j1 = 0; j1 < listN[i]; j1++) {
                        test.removeMin();
                    }
                    endTime = System.currentTimeMillis();
                    long timeElapsedRemove = endTime - startTime;
                    System.out.println("\n|   MyPQUnsortedArray                           " + timeElapsedInsert + "         " + timeElapsedRemove + "                                              |");
                    addToFile += "\n|   MyPQUnsortedArray                           " + timeElapsedInsert + "         " + timeElapsedRemove + "                                              |";

                    startTime = System.currentTimeMillis();
                    for (int j1 = 0; j1 < listN[i]; j1++) {
                        test2.insert(r.nextInt(listN[i] - 1) + 1, line);
                        line = reader.readLine();
                    }
                    endTime = System.currentTimeMillis();
                    timeElapsedInsert = endTime - startTime;
                    startTime = System.currentTimeMillis();
                    for (int j1 = 0; j1 < listN[i]; j1++) {
                        test2.removeMin();
                    }
                    endTime = System.currentTimeMillis();
                    timeElapsedRemove = endTime - startTime;
                    System.out.println("\n|   MyPQSortedArray                           " + timeElapsedInsert + "         " + timeElapsedRemove + "                                              |");
                    addToFile += "\n|   MyPQSortedArray                           " + timeElapsedInsert + "         " + timeElapsedRemove + "                                              |";

                    startTime = System.currentTimeMillis();
                    for (int j1 = 0; j1 < listN[i]; j1++) {
                        test3.insert(r.nextInt(listN[i] - 1) + 1, line);
                        line = reader.readLine();
                    }
                    endTime = System.currentTimeMillis();
                    timeElapsedInsert = endTime - startTime;
                    startTime = System.currentTimeMillis();
                    for (int j1 = 0; j1 < listN[i]; j1++) {
                        test3.removeMin();
                    }
                    endTime = System.currentTimeMillis();
                    timeElapsedRemove = endTime - startTime;
                    System.out.println("\n|   MyPQUnsortedList                         " + timeElapsedInsert + "         " + timeElapsedRemove + "                                              |");
                    addToFile += "\n|   MyPQUnsortedList                         " + timeElapsedInsert + "         " + timeElapsedRemove + "                                              |";

                    startTime = System.currentTimeMillis();
                    for (int j1 = 0; j1 < listN[i]; j1++) {
                        test4.insert(r.nextInt(listN[i] - 1) + 1, line);
                        line = reader.readLine();
                    }
                    endTime = System.currentTimeMillis();
                    timeElapsedInsert = endTime - startTime;
                    startTime = System.currentTimeMillis();
                    for (int j1 = 0; j1 < listN[i]; j1++) {
                        test4.removeMin();
                    }
                    endTime = System.currentTimeMillis();
                    timeElapsedRemove = endTime - startTime;
                    System.out.println("\n|   MyPQSortedList                         " + timeElapsedInsert + "         " + timeElapsedRemove + "                                              |");
                    addToFile += "\n|   MyPQSortedList                         " + timeElapsedInsert + "         " + timeElapsedRemove + "                                              |";

                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("\n|_____________________________________________________________________________________________________|");
                addToFile += "\n|_____________________________________________________________________________________________________|";
            }
            myWriter.write(addToFile);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
