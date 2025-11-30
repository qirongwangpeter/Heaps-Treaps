package heaps;

public class HeapUtilities {
    public static int left(int i ){
        return 2*i+1;
    }
    public static int right(int i){
        return 2*i+2;
    }
    public static int parent(int i){
        return (i - 1)/2;
    }
    public static boolean hasleft(double[] a, int i){
        return left(i) < a.length;
    }
    public static boolean hasright(double[] a, int i){
        return right(i) < a.length;
    }
    public static void swap(double[] a, int i, int j){
        double e = a[i];
        a[i] = a[j];
        a[j] = e;
    }
    //-----basic utilities for Heap-----//

    /**
     * Returns true iff the subtree of a starting at index i is a max-heap.
     * @param a an array representing a mostly-complete tree, possibly a heap
     * @param i an index into that array representing a subtree rooted at i
     * @return true iff the subtree of a starting at index i is a max-heap
     */

    protected static boolean isHeap(double[] a, int i){
        for(int j = i; j< a.length;j++){
            // if(!hasleft(a,j) && hasright(a,j)){ // not impossible case with an array!
            //     return false;
            // }
            if(hasleft(a,j) && a[left(j)] > a[j]){
                return false;
            }
            if(hasright(a,j) && a[right(j)] > a[j]){
                return false;
            }
        }
        return true;
    }

    /**
     * Perform the heap siftdown operation on index i of the array a. 
     * 
     * This method assumes the subtrees of i are already valid max-heaps.
     * 
     * This operation is bounded by n (exclusive)! In a regular heap, 
     * n = a.length, but in some cases (for example, heapsort), you will 
     * want to stop the sifting at a particular position in the array. 
     * siftDown should stop before n, in other words, it should not 
     * sift down into any index great than (n-1).
     * 
     * @param a the array being sifted
     * @param i the index of the element to sift down
     * @param n the bound on the array (that is, where to stop sifting)
     */

    static void siftDown(double[] a, int i, int n){
        int current = i;
        int maxIndex = current;
        if(left(current) >= n){
            return;
        }
        if(a[left(current)] > a[current]){
            maxIndex = left(current);
        }
        if(right(current) < n && a[right(current)] > a[maxIndex]){
            maxIndex = right(current);
        }
        if(current != maxIndex){
            swap(a,current,maxIndex);
            siftDown(a, maxIndex, n);
        }
    }
        

    /**
     * Heapify the array a in-place in linear time as a max-heap.
     * @param a an array of values
     */

    protected static void heapify(double[] a){
        int bound = a.length;
        for(int i = bound/2-1;i >= 0;i--){
            siftDown(a,i,bound);
        }
    }

    /**
     * Heapsort the array a in-place, resulting in the elements of
     * a being in ascending order.
     * @param a
     */

    protected static void heapSort(double[] a){
        heapify(a);
        int bound = a.length-1;
        for(int i = 0;i < a.length - 1;i++){
            swap(a, 0, bound);
            siftDown(a, 0, bound);
            bound--;
        }
    }
}
