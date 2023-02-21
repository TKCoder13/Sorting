import java.util.Random;

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
        for (int i = 0; i < N; i++) {
            int newElement = list[i];
            int location = i - 1;
            count++;
            while (location >= 1 && list[location] > newElement) {
                list[location + 1] = list[location];
                location = location - 1;
            }
            list[location + 1] = newElement;
        }
    }

    

    public static void bubbleSort(int[] list, int N) {
        int numOfPairs = N;
        count = 0;
        boolean swappedElements = true;
        
        while (swappedElements) {
            numOfPairs = numOfPairs - 1;
            swappedElements = false;
            for (int i = 1; ; i++) {
                count++;
                if (list[i] > list[i + 1]) {
                    //swap()
                    swappedElements = true;
                }
            }
        }
    }

    public static void modifiedBubbleSort(int[] list, int N) {
        
    }

    public static void main(String[] args) {
        int len = 100;
        int[] list = new int[len];
        for (int i = 0; i < len; i++) {
            list[i] = i;
        }

        shuffle(list);
        System.out.println("test");
        insertionSort(list, len);
        for (int i = 0; i < len; i++) {
            System.out.println(i + ": " + list[i]);
        }
        System.out.println("count " + count);
        // System.out.println(count);
        
        // test list that was provided
        /*  
         * int[] testList = {6,2,4,7,1,3,8,5};
         * // insertionSort(testList, testList.length);
         * // bubbleSort(testList, testList.length);
         * // modifiedBubbleSort(testList, testList.length);
         * System.out.println(counter);
        */
        
    }
}