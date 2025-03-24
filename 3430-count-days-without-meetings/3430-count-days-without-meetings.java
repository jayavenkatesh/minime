class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->a[0]-b[0]);

        List<int[]> l = new ArrayList<>();
        for (int[] m : meetings) {
            if (l.isEmpty() || m[0] > l.get(l.size() - 1)[1]) {
                l.add(m);
            } else {
                l.get(l.size() - 1)[1] = 
                    Math.max(l.get(l.size() - 1)[1], m[1]);
            }
        }

        int meetingDaysCount = 0;
        for (int[] m : l) {
            meetingDaysCount += (m[1] - m[0] + 1);
        }

        return days - meetingDaysCount;
    }
}