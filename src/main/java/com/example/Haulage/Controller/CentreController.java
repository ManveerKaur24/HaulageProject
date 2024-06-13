package com.example.Haulage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Haulage.Entity.Centre;
import com.example.Haulage.Service.CentreService;
import com.example.Haulage.Service.CountryService;
import com.example.Haulage.Service.DistrictService;
import com.example.Haulage.Service.StateService;

import jakarta.validation.Valid;

@Controller
public class CentreController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@Autowired
	private DistrictService districtService;

	@Autowired
	private CentreService cService;

	@GetMapping("Centre")
	public String Service(Model model) {

		List<Centre> CList = cService.getAll();
		model.addAttribute("CList", CList);
		model.addAttribute("countrylist", countryService.getAll());

		model.addAttribute("statelist", stateService.getAll());

		model.addAttribute("districtlist", districtService.getAll());
		model.addAttribute("centre", new Centre());
		return "Centre";
	}

	@PostMapping("saveCentre")
	public String saveService(@Valid @ModelAttribute("centre") Centre centre, BindingResult bindingResult,
			Model model) {
		cService.saveDetails(centre);
		model.addAttribute("successMessage", "Haulage Centre saved successfully!");
		return "redirect:Centre";
	}

	@GetMapping("updateCentre")
	public String update(Model model, @ModelAttribute("id") Long id) {

		model.addAttribute("countrylist", countryService.getAll());

		model.addAttribute("statelist", stateService.getAll());

		model.addAttribute("districtlist", districtService.getAll());
		
		List<Centre> CList = cService.getAll();
		model.addAttribute("CList", CList);
		Centre centre = cService.update(id);
		model.addAttribute("centre", centre);
		return "Centre";

	}

}
