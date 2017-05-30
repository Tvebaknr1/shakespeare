package Shakespeare;

import Exercise1.Algorithms;
import Exercise1.Stopwatch;
import Exercise2.ArraySymbolTable;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author LouiseB
 */
public class Shakespeare {

    int limit = 70;
    String[] words = null;
    public String[] shakeSpeareWords = new String[limit];
    ArraySymbolTable arraySimpleTable = new ArraySymbolTable();

    public static void main(String[] args) {
        Shakespeare shakespeare = new Shakespeare();

        Stopwatch stopwatchForSelectionSort = new Stopwatch();
        Algorithms selectionSortShakeSpeareWords = new Algorithms(shakespeare.ShakeSpeareTextFile());

        selectionSortShakeSpeareWords.selectionSort();

        double elapsedTimeForSelectionSort = stopwatchForSelectionSort.elapsedTime();

        System.out.println("Selection sort: " + selectionSortShakeSpeareWords.arrayToString());
        System.out.println("It took: " + elapsedTimeForSelectionSort);

        Stopwatch stopwatchForInsertionSort = new Stopwatch();
        Algorithms insertionSortShakeSpeareWords = new Algorithms(shakespeare.ShakeSpeareTextFile());

        insertionSortShakeSpeareWords.insertionSort();

        double elapsedTimeForInsertionSort = stopwatchForInsertionSort.elapsedTime();

        System.out.println("Insertion sort: " + insertionSortShakeSpeareWords.arrayToString());
        System.out.println("It took: " + elapsedTimeForInsertionSort);

        Stopwatch stopwatchForMerge = new Stopwatch();
        Algorithms mergeShakeSpeareWords = new Algorithms(shakespeare.ShakeSpeareTextFile());

        mergeShakeSpeareWords.sort();

        double elapsedTimeForMerge = stopwatchForMerge.elapsedTime();

        System.out.println("Merge: " + mergeShakeSpeareWords.arrayToString());
        System.out.println("It took: " + elapsedTimeForMerge);

        //------------------------------- OPGAVE 2 ----------------------------------\\
        shakespeare.ShakeSpeareTextFile();
        shakespeare.increaseOrNotIncreaseValue();
        shakespeare.print();

    }

    public String[] ShakeSpeareTextFile() {
        try {
            words = FileUtility.toStringArray("C:\\Users\\LouiseB\\OneDrive\\Cphbusiness\\4.semester\\Datastruktur og algoritmer\\Shakespeare\\src\\shakespeare\\Shakespeare.txt", "[^A-Za-z]");
            shakeSpeareWords = Arrays.copyOfRange(words, 0, limit);
        } catch (IOException ex) {
            ex.toString();
        }
        return shakeSpeareWords;
    }

    public void increaseOrNotIncreaseValue() {

        for (String text : shakeSpeareWords) {
            Integer oldValue = arraySimpleTable.get(text); //hvor mange gange står orden 'this' inde i arraySimpleTable. 
            //Første gang er oldValue null. Arrayet er tomt første gang
            int value = oldValue == null ? 1 : oldValue + 1; //første gang vil 'this''s value null og derfor er value 1.
            arraySimpleTable.put(text, value); //put 'this', 1 første gang ned i arraySimpleTable - det gør put funktionen
        }
    }

    private void print() {
        arraySimpleTable.print();
    }
}
