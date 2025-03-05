class Solution {
    public double[] convertTemperature(double c) {
        double a=c+273.15;
        double b=c*1.80+32.00;
        return new double[]{a,b};
    }
}