package com.example.Haulage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Haulage.Entity.InsuranceCompany;
import com.example.Haulage.Service.CountryService;
import com.example.Haulage.Service.DistrictService;
import com.example.Haulage.Service.InsuranceCompanyService;
import com.example.Haulage.Service.StateService;

import jakarta.validation.Valid;

@Controller

public class InsuranceCompanyController {

	@Autowired
	InsuranceCompanyService insurancecompanyservice;

	@Autowired
	DistrictService districtService;

	@Autowired
	StateService stateService;

	@Autowired
	CountryService countryService;

	@GetMapping("insurance")
	public String insuranceForm(Model model) {
		model.addAttribute("countrylist", countryService.getAll());

		model.addAttribute("statelist", stateService.getAll());

		model.addAttribute("districtlist", districtService.getAll());

		List<InsuranceCompany> insuranceComList = insurancecompanyservice.getAll();
		model.addAttribute("insuranceComList", insuranceComList);
		model.addAttribute("Insurance", new InsuranceCompany());
		return "Insurance_Company";
	}

	@PostMapping("saveInsurance")
	public String saveInsurance(@Valid @ModelAttribute("Insurance") InsuranceCompany ic, BindingResult bindingResult,
			Model model) {
		List<InsuranceCompany> insuranceComList = insurancecompanyservice.getAll();
		System.out.println("bindingRessult : " + bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("in if");
			return "Insurance_Company";
		} else {
			System.out.println("in else");

			insurancecompanyservice.saveInsurance(ic);
			return "redirect:insurance";
		}

	}

	@GetMapping("updateInsurance")
	public String update(Model model, @ModelAttribute("id") Long id) {

		List<InsuranceCompany> emplist = insurancecompanyservice.getAll();
		model.addAttribute("emplist", emplist);

		InsuranceCompany insueCompany = insurancecompanyservice.update(id);
		model.addAttribute("Insurance", insueCompany);
		return "Insurance_Company";

	}

	@GetMapping("deleteInsurance")
	public String delete(Long id) {

		insurancecompanyservice.delete(id);
		return "redirect:insurance";
	}

}
