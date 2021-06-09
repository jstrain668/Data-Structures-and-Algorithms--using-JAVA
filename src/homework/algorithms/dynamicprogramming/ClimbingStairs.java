package homework.algorithms.dynamicprogramming;

public class ClimbingStairs {

    // Time complexity : O(2^n)
    // Size of recursion tree will be 2^n
    // Space complexity : O(n). The depth of the recursion tree can go upto n.
    public int bfClimbStairs(int stepIndex, int nSteps){

        //Base case for exiting recursive calls. stepIndex can exceed nSteps because of 2 step increment
        if (stepIndex > nSteps)
            return 0;

        //Base case for exiting recursive calls.
        if (stepIndex == nSteps)
            return 1;

        return bfClimbStairs(stepIndex+1,nSteps) + bfClimbStairs(stepIndex+2,nSteps);
    }

    public int memoizedClimbStairs(int stepIndex, int nSteps, int[] memoArray){

        //Base case for exiting recursive calls. stepIndex can exceed nSteps because of 2 step increment
        if (stepIndex > nSteps)
            return 0;

        //Base case for exiting recursive calls.
        if (stepIndex == nSteps)
            return 1;

        if (memoArray[stepIndex] > 0)
            return memoArray[stepIndex];

        memoArray[stepIndex] = memoizedClimbStairs(stepIndex+1,nSteps,memoArray) + memoizedClimbStairs(stepIndex+2,nSteps,memoArray);

        return memoArray[stepIndex];
    }

    public int dpClimbStairs(int nSteps){

        if (nSteps ==1)
            return 1;

        int[] dp = new int[nSteps+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i <= nSteps; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[nSteps];
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        int nSteps = 10;
        int[] memoArray = new int[nSteps+1];
        System.out.println("Number of possible steps to climb "+nSteps+" is: "+cs.bfClimbStairs(0,nSteps));
        System.out.println("Number of possible steps to climb "+nSteps+" is: "+cs.memoizedClimbStairs(0,nSteps,memoArray));
        System.out.println("Number of possible steps to climb "+nSteps+" is: "+cs.dpClimbStairs(nSteps));
    }
}
