package com.example.Haulage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Haulage.Entity.*;
import com.example.Haulage.Service.*;


@Controller
@RequestMapping("district")
public class DistrictController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@Autowired
	private DistrictService districtService;

	@GetMapping("district")
	public String getAll(Model model) {

		List<District> districtList = districtService.getAll();
		model.addAttribute("districtList", districtList);
		model.addAttribute("district", new District());

//		List<State> stateList = stateService.getAll();
//		model.addAttribute("stateList", stateList);

		List<Country> countryList = countryService.getAll();
		model.addAttribute("countryList", countryList);

		return "District";

	}

	@PostMapping("saveDistrict")
	public String save(Model model, @ModelAttribute("district") District district, BindingResult bindingResult) {

		List<Country> countryList = countryService.getAll();
//		List<State> stateList = stateService.getAll();s
		List<District> districtList = districtService.getAll();

		if (district.getState().getCountry().getId() == null) {

			bindingResult.rejectValue("state.country.id", null, "please select country ");
		}
		if (district.getState().getId() == null) {

			bindingResult.rejectValue("state.id", null, "please select state ");
		}

		if (bindingResult.hasErrors()) {

			if (district.getState().getCountry().getId() != null) {

				List<State> stateList = stateService.getStateByCountryId(district.getState().getCountry().getId());
				model.addAttribute("stateList", stateList);
			}

			model.addAttribute("districtList", districtList);
			return "District";

		} else {

			districtService.saveDistrict(district);
			model.addAttribute("districtList", districtList);
			return "redirect:district";

		}

	}

	@GetMapping("update")
	public String update(Model model, @ModelAttribute("id") Long id) {

		List<District> districtList = districtService.getAll();
		model.addAttribute("districtList", districtList);

		List<State> stateList = stateService.getAll();
		model.addAttribute("stateList", stateList);

		List<Country> countryList = countryService.getAll();
		model.addAttribute("countryList", countryList);
		
		District district = districtService.update(id);
		model.addAttribute("district", district);

		
		return "District";

	}

	@GetMapping("delete")
	public String delete(Long id) {

		districtService.delete(id);
		return "redirect:district";
	}

	@GetMapping("getStateByCountryId")
	public String getStateByCountryId(@RequestParam("id") Long id, @RequestParam("action") String action, Model model) {

		List<State> stateList = stateService.getStateByCountryId(id);
		model.addAttribute("stateList", stateList);
		model.addAttribute("action",action);
//		System.out.println("Hello :"+stateList.size());
		return "ajax";

	}

}
