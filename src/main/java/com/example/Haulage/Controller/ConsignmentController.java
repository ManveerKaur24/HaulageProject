package com.example.Haulage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Haulage.Entity.Consignment;
import com.example.Haulage.Service.ConsignmentService;

@Controller
public class ConsignmentController {

	@Autowired
	ConsignmentService consignmentService;
	
@GetMapping("/showConsignment")
	public String ShowForm(Model model) {
		List<Consignment> consignmentlist = consignmentService.getAll();
		model.addAttribute("consignmentlist", consignmentlist);
		model.addAttribute("consignment", new Consignment());
		return "Consignment";
	
	}
	
		
@PostMapping("saveConsignment")
	public String save(@ModelAttribute("consignment") Consignment consignment) {
		
	consignmentService.saveConsignment(consignment);
			
        return "redirect:showConsignment";
    
  }
 
 @GetMapping("/updateConsignment")
    public String update(@ModelAttribute("id") Long id, Model model) {

	 List<Consignment> consignmentlist = consignmentService.getAll();
     model.addAttribute("consignmentlist", consignmentlist);

	
		Consignment consignment = consignmentService.updateConsignment(id);
		model.addAttribute("consignment", consignment);
		
	      
     	return  "Consignment";

 }

}
