class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2) return false;
        if (s1.equals(s2)) return true;
        int i = 0;
        int j = 0;
        int f = 0;
        for (int k = 0; k < n1; k++) {
            char ch1 = s1.charAt(k);
            char ch2 = s2.charAt(k);
            if (ch1 != ch2) {
                f++;
                if (f > 2) return false;
                else if (f == 1) i = k;
                else j = k;
            }
        }
        if (s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i)) return true;
        return false;
    }
}