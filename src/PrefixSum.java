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

    public int[] evenPrefixSum(int[] arr)
    {
        int n = arr.length;
        int[] pfe = new int[n];
        pfe[0] = arr[0];
        for(int i = 1; i < n; i++)
        {
            if(i%2 == 0)
            {
                pfe[i] = arr[i] + pfe[i-1];
            }
            else
            {
                pfe[i] = pfe[i-1];
            }
        }
        return pfe;
    }

    public int[] oddPrefixSum(int[] arr)
    {
        int n = arr.length;
        int[] pfo = new int[n];
        pfo[0] = 0;
        for(int i = 1; i < n; i++)
        {
            if(i%2 != 0)
            {
                pfo[i] = arr[i] + pfo[i-1];
            }
            else
            {
                pfo[i] = pfo[i-1];
            }
        }
        return pfo;
    }
}
