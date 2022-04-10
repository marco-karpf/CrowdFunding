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
	@RequestMapping(value = {"/", "adddonation"}, method = RequestMethod.GET)
	public String showCrowdfounding(ModelMap model) {
		System.out.println("ViewController.showCrowdfounding");
		model.addAttribute("donation", new Donation());
		model.addAttribute("donations", list.getDonations());
		System.out.println(list.getAmount());
		model.addAttribute("list", list);
		return "crowdfounding";
	}

	@PostMapping("/adddonation")
	@RequestMapping(value = {"adddonation"}, method = RequestMethod.POST)
	public String addSpende( Donation donation, ModelMap model) {
		System.out.println("ViewController.addSpende");
		list.getDonations().add(donation);
		model.addAttribute("donations", list.getDonations());
		model.addAttribute("list", list);
		return "crowdfounding";
	}
	// create mapping to remove last donation from list
	@GetMapping("/remove")
	@RequestMapping(value = {"remove"}, method = RequestMethod.GET)
	public String removeSpende(ModelMap model) {
		model.addAttribute("donation", new Donation());
		System.out.println("ViewController.removeSpende");
		System.out.println(list.getDonations().size());
		list.removeLastDonation();
		model.addAttribute("donations", list.getDonations());
		model.addAttribute("list", list);
		return "crowdfounding";
	}

	@GetMapping("/delete/{id}")
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteDonation(@PathVariable("id") int id, Model model) {
		System.out.println("ViewController.deleteDonation");
		list.getDonations().remove(id);
		model.addAttribute("donations", list.getDonations());
		model.addAttribute("list", list);
		return "crowdfounding";
	}
}


