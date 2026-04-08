class Solution {
    public String largestOddNumber(String num) {
        
        int ind=-1;

        for(int i=num.length()-1;i>=0;i--)
        {
            if((num.charAt(i)-'0')%2==1)
             {
                ind=i;
                break;
             }
        }

        if(ind==-1)
         return "";

        int i=0;
        while(i<=ind && num.charAt(i)=='0')
         i++;

        return num.substring(i,ind+1);
    }
}