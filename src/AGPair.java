public class AGPair {
    String str = "bcaggaag";
    int n = str.length();

    //SC: O(1)
    //TC: O(N)
    //Here we are iterating from back
    public void optimisedApproach()
    {
        int gCount = 0;
        int agPairCount = 0;
        char chr;

        for(int i = n-1; i >=0; i--)
        {
            chr = str.charAt(i);
            if(chr == 'g')
            {
                gCount++;
            }
            else if(chr == 'a')
            {
                agPairCount += gCount;
            }
        }
        System.out.print("ag pair count: "+ agPairCount);
    }

    //TC: O(N^2)
    //SC: O(1)
    //Here we are iterating from front
    public void bruteforceApproach()
    {
        int agPairCount = 0;
        for(int i = 0; i < n; i++)
        {
            char chr = str.charAt(i);
            if(chr == 'a')
            {
                for(int j = i+1; j < n; j++)
                {
                    chr = str.charAt(j);
                    if(chr == 'g')
                    {
                        agPairCount++;
                    }
                }
            }
        }
        System.out.print("ag pair count: "+ agPairCount);
    }
}