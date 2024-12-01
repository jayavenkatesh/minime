class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> hs=new HashSet();
        for (int i : arr) {
            if (hs.contains(i * 2)) return true;
            if (i % 2 == 0 && hs.contains(i / 2)) return true;
            hs.add(i);
        }
        return false;
    }
}