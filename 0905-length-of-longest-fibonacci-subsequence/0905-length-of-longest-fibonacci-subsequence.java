import java.util.HashSet;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashSet<Integer> hs = new HashSet<>();
        for (int i : arr) hs.add(i); 
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i], b = arr[j];
                int length = 2;
                while (hs.contains(a + b)) {
                    int temp = a + b;
                    a = b;
                    b = temp;
                    length++;
                }
                ans = Math.max(ans, length);
            }
        }
        return ans >= 3 ? ans : 0;
    }
}
