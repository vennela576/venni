package com.test.novelvista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.test.novelvista.entity.Customer;
import com.test.novelvista.repo.CustomerRepo;

@Controller
public class CustomerController {

	@Autowired
	CustomerRepo custrepo;

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/add")
	public String insert() {
		return "insert";
	}

	@GetMapping("/delete")
	public String delete() {
		return "delete";
	}

	@GetMapping("/update")
	public String update() {
		return "update";
	}

	@GetMapping("/all")
	public @ResponseBody Iterable<Customer> select() {
		return custrepo.findAll();
	}

	@GetMapping("/added")
	public @ResponseBody String inserted(@RequestParam Long id, String firstname, String lastname) {
		Customer cust = new Customer();
		cust.setId(id);
		cust.setFirstname(firstname);
		cust.setLastname(lastname);
		custrepo.save(cust);
		return "Successfully Operated..";
	}

	@GetMapping(path = "/deleted")
	public @ResponseBody String deleted(@RequestParam Long id) {
		custrepo.deleteById(id);
		return "Successfully Deleted..";
	}
}