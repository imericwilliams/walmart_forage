
// Power of Two Max Heap Data Structure
import java.util.Arrays;
import java.util.Scanner;

// Requirements for Power of two max heap

// Requirements:
// - heap must satisfy heap property
// - every parent node in the heap must have 2^x children
// - value of x must be a parameter of the heap's constructor
// - heap must implement an insert method
// - heap must implement a pop max method
// - heap must be implemented in Java (requirement already filled!)
// - heap must be performant
// - use a more descriptive variable name than x in the implementation

public class PowerOfTwoMaxHeap {
    // Array for the heap
    int[] arr;

    // Number of items in the
    // max heap
    int heapSize;

    // Determines the max number
    // of children allowed for a
    // parent
    int capSizeOfChildren;

    // Keeps track of current size
    // of children per parent node
    int currNumOfChildren;

    // Maximum possible size of
    // the max heap
    int maxSize = (int) Math.pow(2, capSizeOfChildren) * 2;

    // Constructor
    public PowerOfTwoMaxHeap(int capSizeOfChildren) {
        this.capSizeOfChildren = capSizeOfChildren;
        arr = new int[maxSize];
        heapSize = 0;
    }

    public void insert(int item) {
        // Check if space in heap
        if (heapSize == maxSize) {
            System.out.println("\nOverflow: Could not insert item. No space in heap.");
            return;
        }

        // New item is inserted at the
        // of arr.
        heapSize++;
        int i = heapSize - 1;
        arr[i] = item;
    }

    public void popMax(int item) {

    }

    public static void main(String[] args) {
        // System.out.println("Hello World");
        // PowerOfTwoMaxHeap heap = new PowerOfTwoMaxHeap();
    }
}