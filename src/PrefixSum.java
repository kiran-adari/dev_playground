public class PrefixSum {
    public int[] prefixSum(int[] arr)
    {
        int n = arr.length;
        int[] prefix_sum = new int[n];
        prefix_sum[0] = arr[0];

        for(int i = 1; i < n; i++)
        {
            prefix_sum[i] = arr[i] + prefix_sum[i-1];
        }

        /*//Prefix Sum result
        for(int i = 0; i < n; i++)
        {
            System.out.print(prefix_sum[i] + " ");
        }
        System.out.println();
         */
        return prefix_sum;
    }
}
