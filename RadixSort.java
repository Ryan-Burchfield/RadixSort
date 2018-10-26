
package radixsort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RadixSort {
    
    static int max(Queue q, int numofnums){//method to find the largest nubmer so the max number of digits can be found
        int max =(int) q.peek();
        for (int i = 1; i < numofnums; i++) {
            int temp = (int) q.poll();
            if(temp>max){
                max = temp;
            }
            q.add(temp);
        }
        return max;
    }
    static int numlength(int max){//method to find the length of the longest number
        String len = Integer.toString(max);
        int length = len.length();
        return length;
    }
    static void Radix(Queue toSort,int numLen,int numofnums){
        int curDigit = 1;//integer to keep how many number places we have sorted
        int exp = 1;//we will multiply this by 10 after each place is sorted
        Queue<Integer> container0 = new LinkedList<>();//buckets for sorting each digit and returning to the original queue
        Queue<Integer> container1 = new LinkedList<>();
        Queue<Integer> container2 = new LinkedList<>();
        Queue<Integer> container3 = new LinkedList<>();
        Queue<Integer> container4 = new LinkedList<>();
        Queue<Integer> container5 = new LinkedList<>();
        Queue<Integer> container6 = new LinkedList<>();
        Queue<Integer> container7 = new LinkedList<>();
        Queue<Integer> container8 = new LinkedList<>();
        Queue<Integer> container9 = new LinkedList<>();
        
        while(curDigit<=numLen){//once curdigit is increased above the nubmer of digits in our largest nubmer, it will break the while loop
            for (int i = 0; i < numofnums; i++) {// loops through all 10 numbers for each digit of our largest number
                int tobucket = (int) toSort.poll();//pulls out each number in the order in which it was stored while converting from an object to an Int
                int bucketPlace = (int) Math.floor((tobucket/exp)%10);//The number produced by this will determine which bucket to insert each number into
                if(bucketPlace == 0){//placing numbers into each bucket by that numbers bucketPlace value
                    container0.add(tobucket);
                }
                if(bucketPlace == 1){
                    container1.add(tobucket);
                }
                if(bucketPlace == 2){
                    container2.add(tobucket);
                }
                if(bucketPlace == 3){
                    container3.add(tobucket);
                }
                if(bucketPlace == 4){
                    container4.add(tobucket);
                }
                if(bucketPlace == 5){
                    container5.add(tobucket);
                }
                if(bucketPlace == 6){
                    container6.add(tobucket);
                }
                if(bucketPlace == 7){
                    container7.add(tobucket);
                }
                if(bucketPlace == 8){
                    container8.add(tobucket);
                }
                if(bucketPlace == 9){
                    container9.add(tobucket);
                }
            }
            while(!container0.isEmpty()){//series of whiles to put the numbers back into the original in a digit sorted order
                toSort.add((int) container0.poll());
            }
            while(!container1.isEmpty()){
                toSort.add((int) container1.poll());
            }
            while(!container2.isEmpty()){
                toSort.add((int) container2.poll());
            }
            while(!container3.isEmpty()){
                toSort.add((int) container3.poll());
            }
            while(!container4.isEmpty()){
                toSort.add((int) container4.poll());
            }
            while(!container5.isEmpty()){
                toSort.add((int) container5.poll());
            }
            while(!container6.isEmpty()){
                toSort.add((int) container6.poll());
            }
            while(!container7.isEmpty()){
                toSort.add((int) container7.poll());
            }
            while(!container8.isEmpty()){
                toSort.add((int) container8.poll());
            }
            while(!container9.isEmpty()){
                toSort.add((int) container9.poll());
            }
            curDigit+=1;//increasing curdigit to get closer to maxlen
            exp*=10;//multiplying exp by 10 so we are alwways working with the correct digit of our numbers (ex. when exp==100, 
                    //we will be putting numbers into the buckets by what is in their hundereds place).
            
        }
                
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> toSort = new LinkedList<>();
        System.out.println("Please enter how many integers you would like to sort");
            int numofnums = in.nextInt();
        System.out.println("Please enter integers to sort pressing enter between each number");
        for (int i = 0; i < numofnums; i++) {
            toSort.add(in.nextInt());//adding numbers to be sorted to the queue
            
        }
        System.out.println("Original Order of Numbers");
        System.out.println("-------------------------");
        for (int i = 0; i < numofnums; i++) {
            int test = (int) toSort.poll();
            System.out.println(test);
            toSort.add(test);
        }
        int maxNum = max(toSort, numofnums);
        int length = numlength(maxNum);
        Radix(toSort, length, numofnums);
        System.out.println("Sorted numbers");
        System.out.println("-------------------------");
        for(int i = 0;i<numofnums;i++){
            int printnums = toSort.poll();
            System.out.println(printnums);
            toSort.add(printnums);
        }
    }
    
}
