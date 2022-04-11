package ch.bbw.pr.crowdfounding.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date = new Date();

    public Donation() {
        super();
    }

    public Donation(int id, String donator, String value, String email, Date date ) {
        this.donator = donator;
        this.value = value;
        this.email = email;
        this.id = id;
        this.date = date;
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

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "donator='" + donator + '\'' +
                ", value='" + value + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }
}
