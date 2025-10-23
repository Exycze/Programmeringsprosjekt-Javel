package no.hvl.dat100.javel.oppgave1;

import no.hvl.dat100.javel.oppgave2.MonthlyPower;

public class DayMain {

    private static void printHeader(String title)  {
        System.out.println();
        System.out.println(title);
        System.out.println();
    }


    public static void main(String[] args) {

        // test data
        double[] powerusage_day = DayPowerData.powerusage_day;

        double[] powerprices_day = DayPowerData.powerprices_day;

        System.out.println("==============");
        System.out.println("OPPGAVE 1");
        System.out.println("==============");

        printHeader("Oppgave a");

        DailyPower.printPowerPrices(powerprices_day);

        printHeader("Oppgave b");

        DailyPower.printPowerUsage(powerusage_day);

        printHeader("Oppgave c");

        double totalUsage = DailyPower.computePowerUsage(powerusage_day);
        System.out.println("Total Power Usage: " + totalUsage + " kWh");

        printHeader("Oppgave d");

        double spotPrice = DailyPower.computeSpotPrice(powerusage_day, powerprices_day);
        System.out.printf("Spot Price: %.2f NOK/kWh%n", spotPrice);

        printHeader("Oppgave e");

        double powerSupport = DailyPower.computePowerSupport(powerusage_day, powerprices_day);
        System.out.printf("Power Support: %.2f NOK/kWh%n", powerSupport);

        printHeader("Oppgave f");

        double norgesPris = DailyPower.computeNorgesPrice(powerusage_day);
        System.out.println("Norgespris: " + norgesPris + " NOK");

        printHeader("Oppgave g");

        double peakUsage = DailyPower.findPeakUsage(powerusage_day);
        System.out.println("Peak Usage: " + peakUsage + " kWh");

        double averageUsage = DailyPower.findAvgPower(powerusage_day);
        System.out.printf("Average Usage: %.2f NOK/kWh%n", averageUsage);

    }
}
