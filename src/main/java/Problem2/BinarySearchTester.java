package Problem2;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BinarySearchTester {

    //array of threads
    public static BinarySearchThread [] threads = new BinarySearchThread[10];

      public static void main(String[] args) {

          Scanner scanner = new Scanner(System.in);
          boolean flag = false;
          int searchKey =0;

          //User input & validation
          System.out.println("Please enter a ID to search: ");
          do{
              if(scanner.hasNextInt()){
                  searchKey = scanner.nextInt();
                  flag = true;
              } else {
                  scanner.next();
                  System.out.println("Please enter a valid ID: ");
              }
          }while(!flag);

          int numOfElements = 10000000;
          int [] idNumbers = GetRandomNumbers(numOfElements);
          int chunckSize = numOfElements/10;

          //pass the parameters for all the threads,
          //we want each of the 10 threads to search 1 million entries
          for(int i =0; i< 10; i++){
              threads[i] = new BinarySearchThread(idNumbers, chunckSize*i, chunckSize*(i+1)-1, searchKey, threads);
          }

          //start all the threads
          for (BinarySearchThread thread: threads) {
              thread.start();
          }
      }

    //Generates random numbers in the range of 1 - 10,000,000. Plus it sorts them.
    public static int[] GetRandomNumbers(int count)
    {
        HashSet<Integer> hashSet = new HashSet<>();
        int [] idNumbers = new int[count];
        System.out.println("Please wait generating 10 million random IDs");
        do{
            //the bounds of the random numbers are 0 - 11 million
            int randomNum = ThreadLocalRandom.current().nextInt(0, 11000000 + 1);
            if(!hashSet.contains(randomNum)){
                hashSet.add(randomNum);
                count--;
            }
        }while (count != 0);
        //not efficient code at all
        List<Integer> list = new ArrayList<Integer>(hashSet);
        for (int i = 0; i < list.size(); i++){
            idNumbers[i] = list.get(i);
        }
        Arrays.sort(idNumbers);
        return idNumbers;
    }

}
