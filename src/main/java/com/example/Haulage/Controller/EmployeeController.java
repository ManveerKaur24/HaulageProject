package com.example.Haulage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Haulage.Entity.Employee;
import com.example.Haulage.Service.CountryService;
import com.example.Haulage.Service.DistrictService;
import com.example.Haulage.Service.EmployeeService;
import com.example.Haulage.Service.StateService;


@Controller
//@RequestMapping("addemployee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeservice;

	@Autowired
	CountryService countryservice;
	
	@Autowired
	StateService stateservice;
	
	@Autowired
	DistrictService districtservice;
	
	
	@GetMapping("employee")
	public String addemplyeeform(Model model) {
		model.addAttribute("countrylist",countryservice.getAll());
		model.addAttribute("statelist",stateservice.getAll());
		model.addAttribute("districtlist",districtservice.getAll());

		List<Employee> emplist = employeeservice.getAll();
		model.addAttribute("emplist", emplist);
		model.addAttribute("employee", new Employee());
		
		return "Employee";
	}
	

	@PostMapping("addemployee")
	public String save(@ModelAttribute("employee") Employee employee) {
		System.out.println("Emp ID: "+ employee.getId());
		
		
		employeeservice.saveEmployee(employee);
			
        return "redirect:employee";
    }
	
	
	@GetMapping("update")
	public String update(Model model, @ModelAttribute("id") Long id) {
		
		model.addAttribute("countrylist",countryservice.getAll());
		model.addAttribute("statelist",stateservice.getAll());
		model.addAttribute("districtlist",districtservice.getAll());
		
		List<Employee> emplist = employeeservice.getAll();
		model.addAttribute("emplist", emplist);

		Employee employee = employeeservice.update(id);
		model.addAttribute("employee", employee);
		return "Employee";

	}
	@GetMapping("delete")
	public String delete(Long id) {

		employeeservice.delete(id);
		return "redirect:employee";
	}
	
}