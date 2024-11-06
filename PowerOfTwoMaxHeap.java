
// Power of Two Max Heap Data Structure

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
    double maxSize;

    // Constructor
    public PowerOfTwoMaxHeap(int capSizeOfChildren) {
        this.capSizeOfChildren = capSizeOfChildren;
        maxSize = Math.pow(2, capSizeOfChildren) * 2;
        arr = new int[(int) maxSize];
        heapSize = 0;
    }

    public int parentItem(int index) {
        return (index - 1) / (int) Math.pow(2, capSizeOfChildren);
    }

    public void insert(int item) {
        // Check if space in heap
        if (heapSize == maxSize) {
            System.out.println("\nOverflow: Could not insert item. No space in heap.");
            return;
        }

        // New item is inserted at the
        // end of arr.
        heapSize++;
        int i = heapSize - 1;
        arr[i] = item;

        // Verify max heap property
        // order of arr
        while (i != 0 && arr[parentItem(i)] < arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parentItem(i)];
            arr[parentItem(i)] = temp;
            i = parentItem(i);
        }
    }

    public int popMax() {
        // Check the heap is not empty
        if (heapSize == 0) {
            System.out.println("\nError: Cannot remove from heap because it is empty.");
            return Integer.MIN_VALUE;
        }
        // Only one item in the heap
        if (heapSize == 1) {
            heapSize--;
            return arr[0];
        }

        // Store the max itm of heap
        // and decrement the index of
        // the remaining items in heap
        int maxItem = arr[0];
        for (int i = 1; i < heapSize; i++) {
            arr[i - 1] = arr[i];
            if (i == heapSize - 1) {
                arr[i] = 0;
            }
        }
        heapSize--;

        return maxItem;
    }

    public static void main(String[] args) {
        // Insert new items to max heap
        PowerOfTwoMaxHeap heap = new PowerOfTwoMaxHeap(2);
        heap.insert(40);
        heap.insert(59);
        heap.insert(10);
        heap.insert(2);
        heap.insert(13);
        heap.insert(12);
        heap.insert(28);
        heap.insert(52);

        System.out.print("\nMax Heap: ");

        for (int num : heap.arr) {
            System.out.print(num + " ");
        }

        System.out.println("\nHeap Size: " + heap.heapSize);

        // Remote the max from max heap
        System.out.println("Previous Root of Max heap: " + heap.popMax());

        System.out.print("Max Heap: ");

        for (int num : heap.arr) {
            System.out.print(num + " ");
        }

        System.out.println("\nHeap Size: " + heap.heapSize);
    }
}