package homework.algorithms.dynamicprogramming;

public class HouseRobbery {

    public int maxLoot(int[] hval, int n){

        if (n==0)
            return 0;
        if (n==1)
            return hval[0];
        if (n==2)
            return Math.max(hval[0],hval[1]);

        // dp[i] represent the maximum value stolen
        // so far after reaching house i.
        int[] dp = new int[n];

        // Initialize the dp[0] and dp[1]
        dp[0] = hval[0];
        dp[1] = Math.max(hval[0], hval[1]);

        // Fill remaining positions
        for (int i = 2; i<n; i++)
            dp[i] = Math.max(hval[i]+dp[i-2], dp[i-1]);

        return dp[n-1];
    }

    public static void main (String[] args)
    {
        //int[] hval = {6, 7, 1, 3, 8, 2, 4};
        int[] hval = {3,1,2,5,4,2};
        int n = hval.length;
        HouseRobbery hr = new HouseRobbery();
        System.out.println("Maximum loot value : " + hr.maxLoot(hval, n));
    }
}
