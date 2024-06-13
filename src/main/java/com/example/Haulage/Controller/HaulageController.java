package com.example.Haulage.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Haulage.Entity.Consignment;
import com.example.Haulage.Entity.Haulage;
import com.example.Haulage.Entity.HaulageItems;
import com.example.Haulage.Entity.HaulageService;
import com.example.Haulage.Service.CountryService;
import com.example.Haulage.Service.DistrictService;
import com.example.Haulage.Service.ServiceHaulageService;
import com.example.Haulage.Service.StateService;
import com.example.Haulage.Service.haulageService;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("organization")
public class HaulageController {

	@Autowired
	private haulageService haulService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@Autowired
	private DistrictService districtService;

	@Autowired
	private ServiceHaulageService hService;

	@GetMapping("organizationForm")
	public String organizationForm(Model model) {

		model.addAttribute("countrylist", countryService.getAll());

		model.addAttribute("statelist", stateService.getAll());

		model.addAttribute("districtlist", districtService.getAll());

		model.addAttribute("HSLsit", hService.getAll());

		Haulage haulage = new Haulage();
		haulage.getHaulageItem().add(new HaulageItems());
		model.addAttribute("haulage", haulage);

		HaulageItems haulageitem = new HaulageItems();
		model.addAttribute("HaulageItem", haulageitem);

		return "GUR";
	}

	@PostMapping("saveHaulage")
	public String saveHaulage(@Valid @ModelAttribute("haulage") Haulage haulage, BindingResult bindingResult,
			Model model ) {

		if (haulage.getSender_District().getState().getCountry().getId() == null) {

			bindingResult.rejectValue("sender_District.state.country.id", null, "please select country ");
		}
		if (haulage.getSender_District().getState().getId() == null) {

			bindingResult.rejectValue("sender_District.state.id", null, "please select state ");
		}
		if (haulage.getSender_District().getId() == null) {

			bindingResult.rejectValue("sender_District.id", null, "please select district ");
		}

		// for receiver

		if (haulage.getReciever_District().getState().getCountry().getId() == null) {

			bindingResult.rejectValue("reciever_District.state.country.id", null, "please select country ");
		}
		if (haulage.getReciever_District().getState().getId() == null) {

			bindingResult.rejectValue("reciever_District.state.id", null, "please select state ");
		}
		if (haulage.getReciever_District().getId() == null) {

			bindingResult.rejectValue("reciever_District.id", null, "please select district ");
		}

		System.out.println("bindingResult : " + bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("This is service id :"+haulage.getHaulageService().getId());
			System.out.println("in if");
			return "GUR";
		} else {
			for (int i = 0; i < haulage.getHaulageItem().size(); i++) {
				haulage.getHaulageItem().get(i).setHaulage(haulage);
			}

			System.out.println("in else");
			haulService.saveDetails(haulage);
			return "redirect:organizationForm";
		}

	}

	@GetMapping("haulagemanage")
	public String HaulageManageForm(Model model,
			@RequestParam(value = "Client_mobile", required = false) String Clientmobile,
			@RequestParam(value = "client-name", required = false) String clientName,
			@RequestParam(value = "tracking_code", required = false) String tracking_code,
			@RequestParam(value = "Booking_date", required = false) String bookingdate,
			@RequestParam(value = "status", required = false) String status) {

		List<Haulage> haulagelist = new ArrayList<Haulage>();

		if (clientName != null) {
			haulagelist = haulService.getByClientName(clientName);

		} else if (Clientmobile != null) {

			haulagelist = haulService.getByClient_mobile(Clientmobile);
		} else if (tracking_code != null) {
			haulagelist = haulService.getByTrackingCode(tracking_code);

		} else if (bookingdate != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate parsedDate = LocalDate.parse(bookingdate, formatter);
			haulagelist = haulService.getByBooking_date(parsedDate);

		} else if (status != null) {
			haulagelist = haulService.getByStatus(status);

		}

		else

		{
			haulagelist = haulService.getAll();
		}
		model.addAttribute("haulagelist", haulagelist);

		return "HaulageManage";
	}

	@GetMapping("view")
	public String ViewDetailForm(@RequestParam("id") Long id, Model model) {
		List<Haulage> List = haulService.getAll();
		model.addAttribute("List", List);

		Haulage haulage = haulService.getById(id);
		model.addAttribute("haulage", haulage);
		return "Viewdetails";
	}

	@GetMapping("haulagecancel")
	public String cancelHaulage(@RequestParam("id") Long id) {
		System.out.println("Hello : " + id);
		haulService.updateCourierStatus(id);
		return "redirect:haulagemanage";

	}

	@PostMapping("saveService")
	public String saveService(@Valid @ModelAttribute("haulage") HaulageService haulage, Model model) {
		hService.saveDetails(haulage);
		model.addAttribute("successMessage", "Haulage Service saved successfully!");
		return "redirect:haulageService";
	}

	@GetMapping("haulageService")
	public String Service(Model model) {

		List<HaulageService> HSLsit = hService.getAll();
		model.addAttribute("HSLsit", HSLsit);
		model.addAttribute("haulage", new HaulageService());
		return "HaulageService";

	}

	@GetMapping("updateService")
	public String update(Model model, @ModelAttribute("id") Long id) {

		List<HaulageService> HSLsit = hService.getAll();
		model.addAttribute("HSLsit", HSLsit);
		HaulageService haulageService = hService.update(id);
		model.addAttribute("haulage", haulageService);
		return "HaulageService";

	}
	
	@GetMapping("Drivers")
	public String ShowForm(Model model) {
//		List<Consignment> consignmentlist = consignmentService.getAll();
//		model.addAttribute("consignmentlist", consignmentlist);
//		model.addAttribute("consignment", new Consignment());
		return "Drivers";
	
	}

}
