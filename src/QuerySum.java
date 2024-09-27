public class QuerySum {
    int[] arr = {-3, 6, 2, 4, 5, 2, 8, -9, 3, 1};
    int[][] queries = {{4, 8}, {3, 7}, {1, 3}, {0, 4}, {7, 7}};
    int q_len = queries.length;

    public void bruteforce_approach()
    {
        //TC : O(q_len * arr_len)
        //SC : O(N)
        int[] res_arr = new int[q_len];
        for(int i = 0; i < q_len; i++)
        {
            int l = queries[i][0];
            int r = queries[i][1];
            int res = 0;


            //Sum from l to r of arr and it will be added to res_arr
            for(int idx = l; idx <= r; idx++)
            {
                res += arr[idx];
            }
            res_arr[i] = res;
        }

        //Printing result array
        print_result(res_arr, q_len);
    }

    public void optimised_approach()
    {
        var obj = new PrefixSum();
        int[] prefix_arr = obj.prefixSum(arr);
        int[] res_arr = new int[q_len];

        for(int i = 0; i < q_len; i++)
        {
            int l = queries[i][0];
            int r = queries[i][1];

            if(l == 0)
            {
                res_arr[i] = prefix_arr[r];
            }
            else
            {
                res_arr[i] = prefix_arr[r] - prefix_arr[l - 1];
            }
        }

        //Printing result array
        print_result(res_arr, q_len);
    }

    public static void print_result(int[] res_arr, int q_len)
    {
        for(int i = 0; i < q_len; i++)
        {
            System.out.print(res_arr[i] + " ");
        }
        System.out.println();
    }
}
