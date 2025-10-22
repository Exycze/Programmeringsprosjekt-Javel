package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class Invoice {

    private Customer c;       // Customer for this invoice
    private String month;     // Month covered
    private double[][] usage; // Power usage per day/hour
    private double[][] prices;// Power prices per day/hour
    private double amount;    // Total amount (to compute)

    // a) Constructor
    public Invoice(Customer c, String month, double[][] usage, double[][] power_prices) {
        this.c = c;
        this.month = month;
        this.usage = usage;
        this.prices = power_prices;
        this.amount = 0.0;
    }

    // b) Compute total amount based on usage, prices, and agreement type
    public void computeAmount() {
        double totalUsage = 0.0;
        double totalCost = 0.0;

        for (int i = 0; i < usage.length; i++) {
            for (int j = 0; j < usage[i].length; j++) {
                double used = usage[i][j];
                double price = prices[i][j];
                totalUsage += used;
                totalCost += used * price;
            }
        }

        // Adjust based on agreement type
        switch (c.getAgreement()) {
            case SPOTPRICE:
                amount = totalCost; // direct
                break;
            case POWERSUPPORT:
                amount = totalCost * 0.9; // 10% support
                break;
            case NORGESPRICE:
                amount = totalCost * 0.5; // 50% subsidized
                break;
            default:
                amount = totalCost;
        }
    }

    // c) Print invoice details
    public void printInvoice() {
        double totalUsage = 0.0;
        for (int i = 0; i < usage.length; i++) {
            for (int j = 0; j < usage[i].length; j++) {
                totalUsage += usage[i][j];
            }
        }

        System.out.println("Customer number " + c.getCustomerId());
        System.out.println("Name  " + c.getName());
        System.out.println("Email " + c.getEmail());
        System.out.println("Agreement " + c.getAgreement());
        System.out.println();
        System.out.println("Month: " + month);
        System.out.printf("Usage:  %10.2f kWh%n", totalUsage);
        System.out.printf("Amount: %10.2f NOK%n", amount);
    }
}
