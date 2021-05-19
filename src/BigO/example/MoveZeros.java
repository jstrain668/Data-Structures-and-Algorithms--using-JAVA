package BigO.example;

public class MoveZeros {

    public static void main(String[] args) {
        //Input: nums = [0,1,0,3,12]
        //Output: [1,3,12,0,0]
        int[] nums = {0, 1, 0, 3, 12};

        MoveZeros moveZeros = new MoveZeros();
        int[] movedZerosArray = moveZeros.moveZerosToEnd(nums);

        for (int i : movedZerosArray) {
            System.out.print(i + ", ");
        }
    }

    private int[] moveZerosToEnd(int[] nums){

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == j && nums[i] != 0)
                j += 1;
            else if (nums[i] != 0) {
                nums[j++] = nums[i];
                nums[i] = 0;
            }

            for (int k : nums) {
                System.out.print(k + ", ");
            }
            System.out.println();
        }

        return nums;
    }
}
