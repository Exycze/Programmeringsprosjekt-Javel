package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;
import no.hvl.dat100.javel.oppgave2.MonthPowerData;

public class InvoiceMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 5");
        System.out.println("==============");
        System.out.println();

        Customer c1 = new Customer(1003, "Charlie Rose", "charlie@example.com", PowerAgreementType.POWERSUPPORT);
        Customer c2 = new Customer(1004, "Diana Prince", "diana@example.com", PowerAgreementType.NORGESPRICE);
        Customer c3 = new Customer(1005, "Ethan Hunt", "ethan@example.com", PowerAgreementType.SPOTPRICE);

        // Example test data (3 days × 2 hours)
        double[][] usage = {
                {1.1, 1.2},
                {1.0, 0.9},
                {1.3, 1.1}
        };
        double[][] prices = {
                {2.0, 2.1},
                {2.2, 2.3},
                {2.1, 2.0}
        };

        Invoice[] invoices = {
                new Invoice(c1, "January", usage, prices),
                new Invoice(c2, "January", usage, prices),
                new Invoice(c3, "January", usage, prices)
        };

        Invoices.processInvoices(invoices);
    }
}