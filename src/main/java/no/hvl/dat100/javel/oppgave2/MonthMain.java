package no.hvl.dat100.javel.oppgave2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MonthMain {

    private static void printHeader(String title) {
        System.out.println();
        System.out.println(title + ":");
        System.out.println();
    }

    public static void main(String[] args) {

        // test data
        double[][] power_prices_month = MonthPowerData.powerprices_month;

        double[][] power_usage_month = MonthPowerData.powerusage_month;

        System.out.println("==============");
        System.out.println("Task 2");
        System.out.println("==============");

        printHeader("Task a");
        MonthlyPower.print_PowerUsage(power_usage_month);

        printHeader("Task b");
        MonthlyPower.print_PowerPrices(power_prices_month);

        printHeader("Task c");
        double powerUsage = MonthlyPower.computePowerUsage(power_usage_month);
        System.out.println(powerUsage);


        printHeader("Task d");
        //Set threshold
        double thresholdCabin = 1000;
        double thresholdHousing = 5000;

// Check for cabin threshold
        boolean exceededCabin = MonthlyPower.exceedThreshold(power_usage_month, thresholdCabin);
        System.out.println("Threshold for cabin (" + thresholdCabin + " kWh) exceeded: " + exceededCabin);

// Check for housing threshold
        boolean exceededHousing = MonthlyPower.exceedThreshold(power_usage_month, thresholdHousing);
        System.out.println("Threshold for housing (" + thresholdHousing + " kWh) exceeded: " + exceededHousing);

        printHeader("Task e");
        double spotPrice = MonthlyPower.computeSpotPrice(power_usage_month, power_prices_month);
        System.out.printf("Total spot-price for the month : %.2f kr%n", spotPrice);

        printHeader("Task f");
        double powerSupport = MonthlyPower.computePowerSupport(power_usage_month, power_prices_month);
        System.out.printf("%.2f kr%n", powerSupport);

        printHeader("Task g");
        double norwayPrice = MonthlyPower.computeNorgesPrice(power_usage_month);
        System.out.printf("%.2f kr%n", norwayPrice);

    }
}