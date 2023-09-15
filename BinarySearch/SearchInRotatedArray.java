package BinarySearch;

public class SearchInRotatedArray {
  public static void main(String[] args) {
    System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
    //System.out.println(findMin(new int[]{11,13,15,17}));
    //Output - 4
  }

  public static int search(int[] nums, int target) {
    int rotations = 0;
    for (int i = 0; i < nums.length-1; i++) {
      if(nums[i] > nums [i+1]) rotations= i+1;
    }
    nums = rotateArray(nums,rotations);
    return nums[0];
  }

  private static int[] rotateArray(int[] nums, int rotations) {
    for (int j = 0; j <rotations ; j++) {
      for (int i = 0; i <nums.length; i++) {
        if(i+1 < nums.length){
          int tmp = nums[i];
          nums[i] = nums[i+1];
          nums[i+1] = tmp;
        }

      }
    }
    return nums;
  }

}
