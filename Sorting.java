import java.util.Random;
import java.lang.Math;

public class Sorting {

    public static long count;

    //@https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/
    public static void shuffle(int[] array) { // Fisher-Yates Shuffle Algorithm
        Random r = new Random();
        int j;
        int temp;
        for (int i = array.length - 1; i > 0; i--) {
            j = r.nextInt(i+1);
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void insertionSort(int[] list, int N) {
        //N = number of elements in list
        count = 0;
        int newElement;
        int location;
        for (int i = 1; i < N; i++) {
            newElement = list[i];
            location = i - 1;
            count++;
            while (location >= 0 && list[location] > newElement) {
                list[location + 1] = list[location];
                location = location - 1;
                count++;
            }
            list[location + 1] = newElement;
        }
    }

    

    public static void bubbleSort(int[] list, int N) {
        int numOfPairs = N - 1;
        count = 0;
        boolean swappedElements = true;
        
        while (swappedElements) {
            
            swappedElements = false;
            for (int i = 0; i < numOfPairs; i++) {
                count++;
                if (list[i] > list[i + 1]) {
                    int temp = list[i+1];
                    list[i+1] = list[i];
                    list[i] = temp;
                    swappedElements = true;
                }
            }
            numOfPairs--;
        }
    }

    public static void modBubbleSort(int[] list, int N) {
        int numOfPairs = N - 1;
        count = 0;
        boolean swappedElements = true;
        

        while (swappedElements) {
            swappedElements = false;
            int evenI = numOfPairs;
            for (int i = 0; i < numOfPairs; i++) {
                count++;

                if (numOfPairs % 2 == 1) {
                    if (list[i] > list[i + 1]) {
                        int temp = list[i+1];
                        list[i+1] = list[i];
                        list[i] = temp;
                        swappedElements = true;
                    }
                } else {
                    if (numOfPairs >= 1) {
                        if (list[evenI] < list[evenI-1]) {
                            int temp = list[evenI-1];
                            list[evenI-1] = list[evenI];
                            list[evenI] = temp;
                            swappedElements = true;
                        }
                        evenI--;
                    }
                    
                }
            }
            numOfPairs--;
        }
    }

    public static void main(String[] args) {
        
        int[] example = {6,2,4,7,1,3,8,5};
        int exSize = example.length;
        System.out.print("Example Array:  ");
        for (int i = 0; i < exSize; i++) {
            System.out.print(example[i] + " ");
        }
        System.out.println();

        // Example array sorted with Insertion Sort
        System.out.print("Insertion Sort:\t");
        int[] exampleInsertion = example;
        int exampleInsertionSize = exampleInsertion.length;

        insertionSort(exampleInsertion, exampleInsertionSize);
        for (int i = 0; i < exampleInsertionSize; i++) {
            System.out.print(exampleInsertion[i] + " ");
        }
        System.out.println();

        // Example array sorted with Bubble Sort I
        System.out.print("Bubble Sort I:\t");
        int[] exampleBubble = example;
        int exampleBubbleSize = exampleBubble.length;

        bubbleSort(exampleBubble, exampleBubbleSize);
        for (int i = 0; i < exampleBubbleSize; i++) {
            System.out.print(exampleBubble[i]  + " ");
        }
        System.out.println();

        // Example array sorted with Bubble Sort II
        System.out.print("Bubble Sort II:\t");
        int[] exampleBubbleII = example;
        int exampleBubbleIISize = exampleInsertion.length;

        modBubbleSort(exampleBubbleII, exampleBubbleIISize);
        for (int i = 0; i < exampleBubbleIISize; i++) {
            System.out.print(exampleBubbleII[i] + " ");
        }
        System.out.print("\n\n\n");

        int maxExp = 16;
        // Insertion Sort w/ Proper Sample Size
        System.out.println("Insertion Sort\n");
        System.out.println("Sample Size\t\tAscending\t\tRandom\t\t\tDescending");

        for (int i = 0; i <= maxExp; i++) {
            int size = (int) Math.pow(2, i);
            int[] list = new int[size];

            // Ascending
            for (int j = 0; j < size; j++) {
                list[j] = j;
            }
            insertionSort(list, size);
            System.out.print(size + "\t\t\t" + count + "\t\t\t");

            //Random
            shuffle(list);
            insertionSort(list, size);
            if (i < 13) {
                System.out.print(count + "\t\t\t");
            } else {
                System.out.print(count + "\t\t");
            }


            // Descending
            for (int j = size - 1; j >= 0; j--) {
                list[size - j - 1] = j;
            }
            insertionSort(list, size);
            System.out.println(count);
        }
        System.out.print("\n\n");


        // Bubble Sort I w/ Proper Sample Size
        System.out.println("Bubble Sort I\n");
        System.out.println("Sample Size\t\tAscending\t\tRandom\t\t\tDescending");

        for (int i = 0; i <= maxExp; i++) {
            int size = (int) Math.pow(2, i);
            int[] list = new int[size];

            // Ascending
            for (int j = 0; j < size; j++) {
                list[j] = j;
            }
            bubbleSort(list, size);
            System.out.print(size + "\t\t\t" + count + "\t\t\t");

            //Random
            shuffle(list);
            bubbleSort(list, size);
            if (i < 13) {
                System.out.print(count + "\t\t\t");
            } else {
                System.out.print(count + "\t\t");
            }

            // Descending
            for (int j = size - 1; j >= 0; j--) {
                list[size - j - 1] = j;
            }
            bubbleSort(list, size);
            System.out.println(count);
        }
        System.out.print("\n\n");


        // Bubble Sort II w/ Proper Sample Size
        System.out.println("Bubble Sort II\n");
        System.out.println("Sample Size\t\tAscending\t\tRandom\t\t\tDescending");

        for (int i = 0; i <= maxExp; i++) {
            int size = (int) Math.pow(2, i);
            int[] list = new int[size];

            // Ascending
            for (int j = 0; j < size; j++) {
                list[j] = j;
            }
            modBubbleSort(list, size);
            System.out.print(size + "\t\t\t" + count + "\t\t\t");

            //Random
            shuffle(list);
            modBubbleSort(list, size);
            if (i < 13) {
                System.out.print(count + "\t\t\t");
            } else {
                System.out.print(count + "\t\t");
            }

            // Descending
            for (int j = size - 1; j >= 0; j--) {
                list[size - j - 1] = j;
            }
            modBubbleSort(list, size);
            System.out.println(count);
        }
    }
}