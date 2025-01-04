class Solution {
    class pair {
        char m;
        char b;

        pair(char c, char d) {
            this.m = c;
            this.b = d;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            pair other = (pair) obj;
            return m == other.m && b == other.b;
        }

        @Override
        public int hashCode() {
            return 31 * m + b;
        }
    }

    public int countPalindromicSubsequence(String s) {
        HashSet<pair> main = new HashSet<>();
        int ans = 0;
        HashSet<Character> hm = new HashSet<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        hm.add(s.charAt(0));
        for (int i = 2; i < s.length(); i++) {
            hm2.put(s.charAt(i), hm2.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 1; i < s.length() - 1; i++) {
            for (Map.Entry<Character, Integer> map : hm2.entrySet()) {
                char currentMiddle = s.charAt(i);
                char currentSuffix = map.getKey();

                if (!main.contains(new pair(currentMiddle, currentSuffix)) && hm.contains(currentSuffix)) {
                    main.add(new pair(currentMiddle, currentSuffix));
                    ans++;
                }
            }
            char nextChar = s.charAt(i + 1);
            if (hm2.get(nextChar) == 1) {
                hm2.remove(nextChar);
            } else {
                hm2.put(nextChar, hm2.get(nextChar) - 1);
            }
            hm.add(s.charAt(i));
        }

        return ans;
    }
}
