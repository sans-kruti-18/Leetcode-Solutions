class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        StringBuilder comb=new StringBuilder();

        Map<Character,String> mp=new HashMap<>();
        mp.put('2',"abc");
        mp.put('3',"def");
        mp.put('4',"ghi");
        mp.put('5',"jkl");
        mp.put('6',"mno");
        mp.put('7',"pqrs");
        mp.put('8',"tuv");
        mp.put('9',"wxyz");

        combinations(digits,mp,0,comb,res);
        return res;
    }

    public void combinations(String digits,Map<Character,String> mp,int ind,StringBuilder comb,List<String> res)
    {
        if(ind==digits.length())
        {
            res.add(comb.toString());
            return;
        }

        String letters=mp.get(digits.charAt(ind));

        for(char letter:letters.toCharArray())
        {
            comb.append(letter);
            combinations(digits,mp,ind+1,comb,res);

            comb.deleteCharAt(comb.length()-1);

        }
    }
}