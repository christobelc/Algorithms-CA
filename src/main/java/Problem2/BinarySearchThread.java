package Problem2;

public class BinarySearchThread extends Thread{

    //flag to tell that the result has been found.
    public static boolean result = false;
    private int [] m_arr;
    private int m_l;
    private int m_r;
    private int m_searchKey;
    // Array of threads
    private BinarySearchThread [] m_bst;

    public BinarySearchThread(int[] arr, int l, int r, int searchKey, BinarySearchThread [] bst){
        this.m_arr= arr;
        this.m_l= l;
        this.m_r= r;
        this.m_searchKey = searchKey;
        this.m_bst = bst;
    }

    //Binary Search
    public boolean BinarySearch(int[] arr, int l, int r, int searchKey) {
        //exits on the next pass if the result is found by another thread
        if(this.isInterrupted()){
            System.out.println("Interrupted thread ID: " + this.getId());
            return false;
        }
        // Standard Binary Search implementation from notes
        System.out.println("binarySearch( arr[] " + l + " , " + r + " , "
                + "" + searchKey + ") length of input array =" + (r -l));
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == searchKey){
                System.out.println("Found");
                return true;
            }
            if (arr[mid] > searchKey){
                return BinarySearch(arr, l, mid - 1, searchKey);
            }
            return BinarySearch(arr, mid + 1, r, searchKey);
        }
        System.out.println("Not found");
        return false;
    }

    //Execute the Thread
    public void run(){
        if(BinarySearch(m_arr, m_l, m_r, m_searchKey)){
            //set the flag to true if found
            result = true;
            for (BinarySearchThread thread: m_bst){
                // the result is found we can stop the other threads
                if(thread.isAlive() && thread != this){
                    //interrupt the threads
                    thread.interrupt();
                }
            }
        }

    }

}
