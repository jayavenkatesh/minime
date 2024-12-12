class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> anss = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        ans(nums, p, used, anss);
        return anss;
    }

    private void ans(int[] nums, List<Integer> p, boolean[] used, List<List<Integer>> anss) {
        if (p.size() == nums.length) {
            if(!anss.contains(p)){
                anss.add(new ArrayList<>(p));
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                p.add(nums[i]);
                ans(nums, p, used, anss);
                p.remove(p.size() - 1);
                used[i] = false;
            }
        }
    }
}