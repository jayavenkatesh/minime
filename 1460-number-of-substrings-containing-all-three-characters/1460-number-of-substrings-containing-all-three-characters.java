class Solution {
    HashSet<Character > set = new HashSet<>();
    public int numberOfSubstrings(String s) {
        set.add('a');
        set.add('b');
        set.add('c');
        return (int) get(s);
    }
    public long get(String s){
        int i = 0;
        int j = 0;
        long ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(i < s.length()){
            char chi =s.charAt(i);
            map.put(chi, map.getOrDefault(chi, 0) + 1);
            while(map.size() == 3){
                ans += (long)(s.length() - i);
                char chj = s.charAt(j);
                if(map.get(chj) == 1) map.remove(chj);
                else map.put(chj, map.get(chj) - 1);
                j++;
            }
            i++;
        }
        return ans;
    }
}