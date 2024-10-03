public class SubArrays {
    int[] arr = {3, 2, 5};
    int n = arr.length;

    //TC : O(N^3) -- This is the optimised approach.
    //SC : O(1)
    public void printSubArrays()
    {
        for(int s = 0; s < n; s++)
        {
            for(int e = s; e < n; e++)
            {
                for(int k = s; k <= e; k++)
                {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    //TC: O(N^2)
    //SC: O(1)
    public void MinSubArrWithMinAndMaxElements()
    {
        int ans = n;
        //TC : O(N)
        //SC : O(1)
        int min = arr[0], max = arr[0];
        for(int i = 1; i < n; i++)
        {
            if(arr[i] < min)
            {
                min = arr[i];
            }
            else if(arr[i] > max)
            {
                max = arr[i];
            }
        }

        //TC: O(N^2)
        //SC: O(1)
        for(int s = 0; s < n; s++)
        {
            boolean hasMin = false, hasMax = false;
            for(int e = s; e < n; e++) {
                if (arr[e] == min) {
                    hasMin = true;
                } else if (arr[e] == max) {
                    hasMax = true;
                }

                if (hasMin && hasMax) {
                    ans = Math.min(ans, (e - s + 1));
                    break;
                }
            }
        }
        System.out.print("length of min sub array with both min and max:"+ ans);
    }

    /* Need to analyse it once
    public void MinMaxSubArrOptimised()
    {
        int min = arr[0], max = arr[0];
        int lastMin = -1, lastMax = -1, ans = n;

        for(int i = 0; i < n; i++)
        {
            if(arr[i] < min)
            {
                min = arr[i];
            }
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }


        for(int i = n-1; i >= 0; i--)
        {
            if(arr[i] == min)
            {
                lastMin = i;
                if(lastMax != -1)
                {
                    ans = Math.min(ans, (lastMin - lastMax)+1);
                }
            }
            if(arr[i] == max)
            {
                lastMax = i;
                if(lastMin != -1)
                {
                    ans = Math.min(ans, (lastMax - lastMin)+1);
                }
            }
        }
        System.out.print("length of min sub array with both min and max:"+ ans);
    }*/

    //TC : O(N^2)
    //SC : O(N) we can make it O(1) by modifying original array.
    public void sumOfSubArrays()
    {
        int totalSum = 0;
        int sum = 0;
        int[] prefix_sum_arr = new int[n];

        PrefixSum ref = new PrefixSum();
        prefix_sum_arr = ref.prefixSum(arr);

        for(int s = 0; s < n; s++)
        {
            for(int e = s; e < n; e++)
            {
                if(s == 0)
                {
                    sum = prefix_sum_arr[e];
                }
                else
                {
                    sum = prefix_sum_arr[e] - prefix_sum_arr[s-1];
                }
                totalSum += sum;
            }
        }
        System.out.println("Total Sum = "+ totalSum);
    }

    //Different approach to calculate sum of sub arrays
    public void sumOfSubArrays1()
    {
        int totalSum = 0;
        for(int s = 0; s < n; s++)
        {
            int sum = 0;
            for(int e = s; e < n; e++)
            {
                sum += arr[e];
                totalSum += sum;
            }
        }
        System.out.print("Sum of all sub arrays: "+ totalSum);
    }

    //Contribution technique to calculate sum of sub arrays
    //This is contribution technique
    /*
    * Scenarios we can use contribution technique
    * All sub-arrays
    * Sum or product of all sub-arrays
    * */
    //TC : O(N)
    //SC : O(1)
    public void sumOfSubArrays2()
    {
        int totalSum = 0;
        for(int s = 0; s < n; s++)
        {
            int contribution = arr[s] * (s + 1) * (n - s);
            totalSum += contribution;
        }
        System.out.print("Sum of all sub arrays: "+ totalSum);
    }
}
