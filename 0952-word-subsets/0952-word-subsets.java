class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] primary = new int[26]; 
        for (String w : words2) {
            int[] temp = new int[26];
            for (char c : w.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                primary[i] = Math.max(primary[i], temp[i]);
            }
        }
        List<String> list = new ArrayList<>();
        for (String w : words1) {
            int[] freq = new int[26];
            for (char c : w.toCharArray()) {
                freq[c - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < primary[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(w);
            }
        }
        
        return list;
    }
}
