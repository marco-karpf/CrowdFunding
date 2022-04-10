package ch.bbw.pr.crowdfounding.model;

/**
 * Donation
 *
 * @author Marco Karpf
 * @version 04.04.2022
 */
public class Donation {
    private int id;
    private String donator = "none";
    private String value = "12.0";
    private String email = "none@gmail.com";

    public Donation() {
        super();
    }

    public Donation(int id, String donator, String value, String email) {
        this.donator = donator;
        this.value = value;
        this.email = email;
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDonator() {
        return donator;
    }

    public void setDonator(String donator) {
        this.donator = donator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "donator='" + donator + '\'' +
                ", value='" + value + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
