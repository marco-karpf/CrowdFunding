package ch.bbw.pr.crowdfounding;

import ch.bbw.pr.crowdfounding.model.Donation;
import ch.bbw.pr.crowdfounding.model.DonationList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.View;

/**
 * ViewController
 *
 * @author Marco KArpf
 * @version 05.04.2022
 */
@Controller
public class ViewController {
    @Autowired
    private DonationList list;

    @Autowired
    public ViewController(DonationList list) {
        this.list = list;
    }

    @GetMapping("/")
    public String showCrowdfounding(ModelMap model) {
        System.out.println("ViewController.showCrowdfounding");
        model.addAttribute("donation", new Donation());
        model.addAttribute("donations", list.getDonations());
        model.addAttribute("list", list);
        return "crowdfounding";
    }

    @PostMapping("/adddonation")
    public String addSpende(Donation donation, ModelMap model) {
        System.out.println("ViewController.addSpende");
        list.getDonations().add(donation);
        model.addAttribute("donations", list.getDonations());
        model.addAttribute("list", list);
        return "crowdfounding";
    }

    // create mapping to remove last donation from list
    @GetMapping("/remove")
    public String removeSpende(ModelMap model) {
        model.addAttribute("donation", new Donation());
        System.out.println("ViewController.removeSpende");
        list.removeLastDonation();
        model.addAttribute("donations", list.getDonations());
        model.addAttribute("list", list);
        return "crowdfounding";
    }

    @GetMapping("/delete/{id}")
    public String deleteDonation(@PathVariable("id") int id, Model model) {
        model.addAttribute("donation", new Donation());
        System.out.println("ViewController.deleteDonationById");
        list.getDonations().remove(id);
        model.addAttribute("donations", list.getDonations());
        model.addAttribute("list", list);
        return "crowdfounding";
    }

    //add mapping for updating a donation
    @PostMapping("/update/{id}")
    public String updateDonation(@PathVariable("id") int id, Model model, Donation donation) {
        model.addAttribute("donation", new Donation());
        System.out.println("ViewController.updateDonation");
        model.addAttribute("donations", list.getDonations());
        model.addAttribute("list", list);
        list.updateDonation(donation, id);
        return "crowdfounding";
    }

    @GetMapping("/edit/{id}")
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editDonation(@PathVariable("id") int id, Model model) {
        for (Donation donation : list.getDonations()) {
            if (donation.getId() == id) {
                System.out.println("ViewController.editDonation");
                model.addAttribute("donation", donation);

            }
        }
        return "crowdfounding-edit";
    }
}


