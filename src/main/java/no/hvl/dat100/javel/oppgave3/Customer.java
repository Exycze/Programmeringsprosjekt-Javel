package no.hvl.dat100.javel.oppgave3;

public class Customer {

    // a) Objektvariable
    private String name;
    private String email;
    private int customer_id;
    private PowerAgreementType agreement;

    // b) Konstruktør
    public Customer(int customer_id, String name, String email, PowerAgreementType agreement) {
        this.customer_id = customer_id;
        this.name = name;
        this.email = email;
        this.agreement = agreement;
    }

    // c) Get / Set metoder
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }

    public PowerAgreementType getAgreement() {
        return agreement;
    }

    public void setAgreement(PowerAgreementType agreement) {
        this.agreement = agreement;
    }

    // d) toString-metode
    @Override
    public String toString() {
        return "Customer number " + customer_id + "\n"
                + "Name  " + name + "\n"
                + "Email " + email + "\n"
                + "Agreement " + agreement;
    }
}
