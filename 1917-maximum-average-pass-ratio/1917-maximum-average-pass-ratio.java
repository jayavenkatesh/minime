class Pair {
    double gain;
    int pass;
    int total;

    Pair(double gain, int pass, int total) {
        this.gain = gain;
        this.pass = pass;
        this.total = total;
    }
}

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> Double.compare(b.gain, a.gain));

        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double gain = gainByAddingOne(pass, total);
            heap.offer(new Pair(gain, pass, total));
        }
        while (extraStudents-- > 0) {
            Pair top = heap.poll();
            top.pass++;
            top.total++;
            top.gain = gainByAddingOne(top.pass, top.total);
            heap.offer(top);
        }
        double totalAverage = 0;
        for (Pair p : heap) {
            totalAverage += (double) p.pass / p.total;
        }
        return totalAverage / classes.length;
    }
    private double gainByAddingOne(int pass, int total) {
        double currentRatio = (double) pass / total;
        double newRatio = (double) (pass + 1) / (total + 1);
        return newRatio - currentRatio;
    }
}
