package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;

public class Customers {

    private Customer[] customers;

    // a) Konstruktør
    public Customers(int size) {
        customers = new Customer[size];
    }

    // b) Teller antall kunder
    public int countNonNull() {
        int count = 0;
        for (Customer c : customers) {
            if (c != null) {
                count++;
            }
        }
        return count;
    }

    // c) Hente kunde
    public Customer getCustomer(int customer_id) {
        for (Customer c : customers) {
            if (c != null && c.getCustomerId() == customer_id) {
                return c;
            }
        }
        return null;
    }

    // d) Sette inn kunde
    public boolean addCustomer(Customer c) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                customers[i] = c;
                return true;
            }
        }
        return false;
    }

    // e) Slette kunde
    public Customer removeCustomer(int customer_id) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null && customers[i].getCustomerId() == customer_id) {
                Customer removed = customers[i];
                customers[i] = null;
                return removed;
            }
        }
        return null;
    }

    // f) Kunde referansetabell
    public Customer[] getCustomers() {
        int count = countNonNull();
        Customer[] result = new Customer[count];
        int index = 0;

        for (Customer c : customers) {
            if (c != null) {
                result[index++] = c;
            }
        }
        return result;
    }
}
