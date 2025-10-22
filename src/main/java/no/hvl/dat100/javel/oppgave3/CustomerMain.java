package no.hvl.dat100.javel.oppgave3;

import no.hvl.dat100.javel.oppgave4.Customers;

public class CustomerMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 3");
        System.out.println("==============");
        System.out.println();

        Customer c = new Customer(1001, "Alice Smith", "alice@example.com", PowerAgreementType.SPOTPRICE);

        System.out.println(c); // Test toString()

        c.setName("Alice Johnson");
        c.setAgreement(PowerAgreementType.NORGESPRICE);

        System.out.println("\nUpdated info:");
        System.out.println(c);
    }
}