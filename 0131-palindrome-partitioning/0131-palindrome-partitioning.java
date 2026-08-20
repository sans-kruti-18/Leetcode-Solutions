class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> ds= new ArrayList<>();

        backtrack(0,s,ds,res);
        return res;
    }

    public void backtrack(int ind,String s,List<String> ds,List<List<String>> res)
    {
        if(ind==s.length())
        {
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind;i<s.length();i++)
        {
            if(isPalindrome(s,ind,i))
            {
                ds.add(s.substring(ind,i+1));
                backtrack(i+1,s,ds,res);
                ds.remove(ds.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s,int start,int end)
    {
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
             return false;

            start++;
            end--;
        }
        return true;
    }
}