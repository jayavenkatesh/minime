class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length()) {
            char ch = sb.charAt(i);
            if (Character.isDigit(ch)) {
                sb.deleteCharAt(i);
                if (i > 0) {
                    sb.deleteCharAt(i - 1);
                    i--;
                }
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
