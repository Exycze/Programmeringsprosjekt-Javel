package no.hvl.dat100.javel.oppgave2;

public class MonthlyPower {

    // a) print power usage for a month
    public static void print_PowerUsage(double[][] usage) {
        for (int i = 0; i < usage.length; i++) {
            System.out.print("Day " + (i + 1) + ":");
            for (int j = 0; j < usage[i].length; j++) {
                System.out.printf(" %.2f kWh", usage[i][j]);
            }
            System.out.println();
        }

    }

    // b) print power prices for a month
    public static void print_PowerPrices(double[][] prices) {
        for (int i = 0; i < prices.length; i++) {
            System.out.print("Day " + (i + 1) + ":");
            for (int j = 0; j < prices[i].length; j++) {
                System.out.printf(" %.2f", prices[i][j]);
            }
            System.out.println();
        }
    }

    // c) compute total power usage for a month
    public static double computePowerUsage(double[][] usage) {

        double sum = 0;

        for (double[] day : usage) {
            for (double value : day) {
                sum += value;
            }
        }
        return sum;
    }

    // d) determine whether a given threshold in powerusage for the month has been exceeded
    public static boolean exceedThreshold(double[][] powerusage, double threshold) {
        boolean exceeded = false;
        double usage = 0;

        int day = 0;
        while (day < powerusage.length && !exceeded) {
            int hour = 0;
            while (hour < powerusage[day].length && !exceeded) {
                usage += powerusage[day][hour];
                if (usage > threshold) {
                    exceeded = true;
                }
                hour++;
            }
            day++;
        }

        return exceeded;
    }

    // e) compute spot price
    public static double computeSpotPrice(double[][] usage, double[][] prices) {
        double price = 0;

        for (int i = 0; i < usage.length; i++) {
            for (int j = 0; j < usage[i].length; j++) {
                price += usage[i][j] * prices[i][j];
            }
        }
        return price;
    }

    // f) power support for the month
    public static double computePowerSupport(double[][] usage, double[][] prices) {

        double supportLimit = 0.75; // based on
        double supportRate = 0.90;  // https://www.hvakosterstrommen.no/

        double support = 0;

        for (int i = 0; i < usage.length; i++) {
            for (int j = 0; j < usage[i].length; j++) {
                double price = prices[i][j];
                double used = usage[i][j];

                if (price > supportLimit) {
                    support = ((price - supportLimit) * supportRate) * used;

                }
            }
        }

        return support;
    }

    // g) Norgesprice for the month
    public static double computeNorgesPrice(double[][] usage) {
        final double averagePriceNorway = 0.70;
        double price = 0;

        for (double[] day : usage) {
            for (double hour : day) {
                price += hour * averagePriceNorway;
            }
        }
        return price;
    }
}
