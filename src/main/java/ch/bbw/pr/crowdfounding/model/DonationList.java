package ch.bbw.pr.crowdfounding.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Service with list of Donations
 *
 * @author Marco KArpf
 * @version 05.04.2022
 */
@Service
public class DonationList {

    private List<Donation> donations = new ArrayList<>(Arrays.asList(
            new Donation(0, "Captain America", "120.0", "captain.america@gmal.com", new Date()),
            new Donation(1, "Spiderman", "240.90", "spider.man@gmail.com", new Date())
    ));
    public Double amount;

    public List<Donation> getDonations() {
        if (donations.isEmpty()) {
            return null;
        }
        return donations;
    }

    public void addDonation(Donation value) {
        donations.add(value);
    }

    public String getAmount() {
        this.amount = 0.0;
        for (Donation donation : donations) {
            amount += Double.parseDouble(donation.getValue());
        }
        return String.valueOf(amount);
    }

    public void removeLastDonation() {
        donations.remove(donations.size() - 1);
    }

    public void updateDonation(Donation donation, int id) {
        System.out.println("updating donation");
        for (Donation d : donations) {
            if (d.getId() == id) {
                System.out.println("found id " + d.getId());
                donations.set(d.getId(), donation);
            }
        }
    }
}
