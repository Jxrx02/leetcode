package BinarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BinarySearch {
  //Input: nums = [-1,0,3,5,9,12], target = 9
  //Output: 4

  //Input: nums = [-1,0,3,5,9,12], target = 2
  //Output: -1

  public static void main(String[] args) {
    System.out.println(search(new int[]{-1,0,3,5,9,12 },9));

  }
  public static int search(int[] nums, int target) {
    return binary(nums, target, 0, nums.length-1);
  }
  public static int binary(int a[], int x, int s, int e){
    while(s <= e){
      int m = s + (e-s)/2;
      if(a[m] == x){
        return m;
      }
      if(x < a[m]){
        e = m-1;
      }
      else {
        s = m+1;
      }
    }
    return -1;
  }

}
