package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Child;

import com.example.demo.Service.ApiService;

@RestController

public class ApiController {

@Autowired //extends another class

ApiService stuService;

@PostMapping("/add")

public Child addInfo(@RequestBody Child st) {

return stuService.saveDetails(st);

}

@GetMapping("/show")

public List<Child>fetchDetails()

{

return stuService.getDetails();

}

@PutMapping("/Update")

public Child UpdateInfo(@RequestBody Child st1)

{

return stuService.UpdateDetails(st1);

}

@DeleteMapping("/Delete/{id}")

public String deleteInfo (@PathVariable("id")int id) {

stuService.deleteDetails(id);

return "Deleted details";

}
@GetMapping("/product/{field}")
public List<Child> getWithSort(@PathVariable String field) {
return stuService.getSorted(field);
		}

// pagination
@GetMapping("/product/{offset}/{pageSize}")
public List<Child> productsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
return stuService.getWithPagination(offset,pageSize);
		}
}