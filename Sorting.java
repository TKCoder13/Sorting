

public class Sorting {

    public static long counter;

    public static void insertionSort(int[] list, int N) {
        //N = number of elements in list
        counter = 0;
        for (int i = 2; i < N; i++) {
            int newElement = list[i];
            int location = i - 1;
            while (location >= 1 && list[location] > newElement) {
                list[location + 1] = list[location];
                location = location - 1;
            }
            list[location + 1] = newElement;
        }
    }

    public static void swap(int a, int b) {

    }

    public static void bubbleSort(int[] list, int N) {
        int numOfPairs = N;
        counter = 0;
        boolean swappedElements = true;
        
        while (swappedElements) {
            numOfPairs = numOfPairs - 1;
            swappedElements = false;
            for (int i = 1; ; i++) {
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
        // Fisher-Yates algorithm to shuffle list[]
        
        insertionSort(list, len);
        System.out.println(counter);
        
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