class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map=new HashMap<>();

        for(char ch:magazine.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int n=ransomNote.length();

        for(int i=0;i<n;i++)
        {
            char ch=ransomNote.charAt(i);

           
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }

            map.put(ch, map.get(ch) - 1);

        }

        return true;
        
    }
}