class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        List<Character> list = new ArrayList<>(hm.keySet());
        Collections.sort(list, (a, b) -> hm.get(b) - hm.get(a));
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(String.valueOf(c).repeat(hm.get(c)));
        }
        return sb.toString();
    }
}