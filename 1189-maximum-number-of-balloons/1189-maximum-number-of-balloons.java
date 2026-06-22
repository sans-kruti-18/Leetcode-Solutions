class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> mp= new HashMap<>();

        for(char ch : text.toCharArray())
        {
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }

       
        int b = mp.getOrDefault('b', 0);
        int a = mp.getOrDefault('a', 0);
        int l = mp.getOrDefault('l', 0) / 2; 
        int o = mp.getOrDefault('o', 0) / 2;
        int n = mp.getOrDefault('n', 0);

        
        return Math.min(Math.min(Math.min(b, a), Math.min(l, o)), n);

        
    }
}