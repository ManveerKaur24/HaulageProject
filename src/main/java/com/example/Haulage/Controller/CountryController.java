package com.example.Haulage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Haulage.Entity.*;
import com.example.Haulage.Service.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("country")
public class CountryController {
	@Autowired
	private CountryService countryService;

	@GetMapping("country")
	public String showCountryForm(Model model) {
		List<Country> countryList = countryService.getAll();
		model.addAttribute("countryList", countryList);
		model.addAttribute("country", new Country());

		return "Country";
	}

	@PostMapping("saveCountry")
	@Transactional
	public String saveCountry(@Valid @ModelAttribute("country") Country country, BindingResult bindingResult,
			Model model) {
		List<Country> countryList = countryService.getAll();

		System.out.println("bindingResult : "+bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("in if");
			return "Country";		   
		}
		else {
			System.out.println("in else");
			countryService.saveCountry(country);
			return "redirect:country";
		}

	}

	@GetMapping("update")
	public String update(@ModelAttribute("id") Long id, Model model) {
		List<Country> countryList = countryService.getAll();
		model.addAttribute("countryList", countryList);

		Country country = countryService.udpate(id);
		model.addAttribute("country", country);

		return "Country";
	}

	@GetMapping("/delete")
	public String delete(Long id) {
		countryService.delete(id);

		return "redirect:country";
	}

}
