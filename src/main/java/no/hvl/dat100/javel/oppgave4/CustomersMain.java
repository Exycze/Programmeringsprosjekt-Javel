package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class CustomersMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 4");
        System.out.println("==============");
        System.out.println();

        Customers customerList = new Customers(10);

        customerList.addCustomer(new Customer(1002, "Bob Johnson", "bob@example.com", PowerAgreementType.NORGESPRICE));
        customerList.addCustomer(new Customer(1003, "Charlie Rose", "charlie@example.com", PowerAgreementType.POWERSUPPORT));
        customerList.addCustomer(new Customer(1004, "Diana Prince", "diana@example.com", PowerAgreementType.NORGESPRICE));
        customerList.addCustomer(new Customer(1005, "Ethan Hunt", "ethan@example.com", PowerAgreementType.POWERSUPPORT));

        System.out.println("Customers in list: " + customerList.countNonNull());

        Customer c = customerList.getCustomer(1003);
        System.out.println("\nFound customer:\n" + c);

        customerList.removeCustomer(1003);
        System.out.println("\nAfter removal:");
        for (Customer cust : customerList.getCustomers()) {
            System.out.println(cust + "\n");
        }
    }
}