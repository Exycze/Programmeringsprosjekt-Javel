package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DayPowerData;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MonthMain {

    private static void printHeader(String title) {
        System.out.println("==============");
        System.out.println(title);
        System.out.println("==============");
        System.out.println();
    }

    public static void main(String[] args) {

        // test data
        double[][] power_prices_month = MonthPowerData.powerprices_month;

        double[][] power_usage_month = MonthPowerData.powerusage_month;

        System.out.println("==============");
        System.out.println("OPPGAVE 2");
        System.out.println("==============");
        System.out.println();

        printHeader("Oppgave a");
        MonthlyPower.print_PowerUsage(power_usage_month);

        printHeader("Oppgave b");
        MonthlyPower.print_PowerPrices(power_prices_month);

        printHeader("Oppgave c");
        MonthlyPower.computePowerUsage(power_usage_month);

        printHeader("Oppgave d");
        //Set threshold
        double thresholdHytte = 1000;
        double thresholdBolig = 5000;

// Check for hytte threshold
        boolean exceededHytte = MonthlyPower.exceedThreshold(power_usage_month, thresholdHytte);
        System.out.println("Threshold for hytte (" + thresholdHytte + " kWh) exceeded: " + exceededHytte);

// Check for bolig threshold
        boolean exceededBolig = MonthlyPower.exceedThreshold(power_usage_month, thresholdBolig);
        System.out.println("Threshold for bolig (" + thresholdBolig + " kWh) exceeded: " + exceededBolig);
    }
}