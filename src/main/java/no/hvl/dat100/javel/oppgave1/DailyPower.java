package no.hvl.dat100.javel.oppgave1;

public class DailyPower {

    // a) print power prices during a day
    public static void printPowerPrices(double[] prices) {
        for (double price : prices) {
            System.out.print(price + " NOK, ");
        }
        System.out.println();
    }

    // b) print power usage during a day
    public static void printPowerUsage(double[] usage) {
        for (double power : usage) {
            System.out.print(power + " kWh, ");
        }
        System.out.println();
    }

    // c) compute power usage for a single day
    public static double computePowerUsage(double[] usage) {

        double sum = 0;

        for (double power : usage) {
            sum += power;
        }

        return sum;
    }

    // d) compute spot price for a single day
    public static double computeSpotPrice(double[] usage, double[] prices) {

        double price = 0;

        for (int i = 0; i < usage.length; i++) {
            price += prices[i] * usage[i];
        }

        return price;
    }

    // e) compute power support for a given usage and price
    private static final double THRESHOLD = 0.9375;
    private static final double PERCENTAGE = 0.9;

    private static double getSupport(double usage, double price) {

        double support = 0;

        if (usage > THRESHOLD) {
            double excess = price - THRESHOLD;
            support = usage * excess * PERCENTAGE;
        }

        return support;
    }

    // f) compute power support for a single day
    public static double computePowerSupport(double[] usage, double[] prices) {

        double support = 0;

        for (int i = 0; i < usage.length; i++) {
            support += getSupport(usage[i], prices[i]);
        }

        return support;
    }

    private static final double NORGESPRIS_KWH = 0.5;

    // g) compute norges pris for a single day
    public static double computeNorgesPrice(double[] usage) {

        return computePowerUsage(usage) * NORGESPRIS_KWH;
    }

    // g) compute peak usage during a single day
    public static double findPeakUsage(double[] usage) {

        double temp_max = 0;

        for (double i : usage)
            if (i > temp_max) {
                temp_max = i;
            }

        return temp_max;
    }

    public static double findAvgPower(double[] usage) {
        return (computePowerUsage(usage) / usage.length);
    }
}