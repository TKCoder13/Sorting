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
            numOfPairs--;
            swappedElements = false;
            for (int i = 0; i <= numOfPairs; i++) {
                count++;
                if (list[i] > list[i + 1]) {
                    int temp = list[i+1];
                    list[i+1] = list[i];
                    list[i] = temp;
                    swappedElements = true;
                }
            }
        }
    }

    public static void modifiedBubbleSort(int[] list, int N) {
        int numOfPairs = N - 1;
        count = 0;
        boolean swappedElements = true;
        int isOdd = 1;
        int evenI = 0;

        while (swappedElements) {
            numOfPairs--;
            swappedElements = false;
            for (int i = 0; i <= numOfPairs; i++) {
                count++;
                if (isOdd % 2 == 1) {
                    if (list[i] > list[i + 1]) {
                        int temp = list[i+1];
                        list[i+1] = list[i];
                        list[i] = temp;
                        swappedElements = true;
                        isOdd++;
                    }
                } else {
                    evenI = numOfPairs;
                    if (list[evenI] > list[evenI-1]) {
                        int temp = list[evenI-1];
                        list[evenI-1] = list[evenI];
                        list[evenI] = temp;
                        swappedElements = true;
                        isOdd++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // int maxExp = 16;
        // System.out.println("Size\tCount");

        // for (int i = 0; i <= maxExp; i++) {
        //     int size = (int) Math.pow(2, i);
        //     int[] list = new int[size];
            
        //     for (int j = 0; j < size; j++) {
        //         list[j] = j;
        //     }

        //     shuffle(list);
        //     bubbleSort(list, size);
            
        //     System.out.println(size + "\t" + count);
        // }
        
        int[] example = {6,2,4,7,1,3,8,5};
        int exampleSize = example.length;
        modifiedBubbleSort(example, exampleSize);
        for (int i = 0; i < exampleSize; i++) {
            System.out.println(example[i]);
        }
    }
}