package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Category;
import com.Entity.SubCategory;
import com.bean.ResponseBean;
import com.services.SubCategoryService;

@CrossOrigin
@RestController
public class SubCategoryController {

	@Autowired
	SubCategoryService service;
	
	@PostMapping("/addSubCategory")
	public ResponseBean<SubCategory> addUser(@RequestBody SubCategory category)
	{
		ResponseBean<SubCategory> res=new ResponseBean<>();
		service.save(category);
		res.setStatus(200);
		res.setData(category);
		res.setMessage("Sub Category Save");
		//System.out.println(user2.getRole().getRole_id());
		return res;
	}
	
	@GetMapping("/getSubCategory")
	public ResponseBean<List<SubCategory>> getUsers()
	{
		ResponseBean<List<SubCategory>> res=new ResponseBean<>();
		List<SubCategory> list=service.getSubCategory();
		res.setStatus(200);
		res.setMessage("List Of All Sub Categories");
		res.setData(list);
		return res;
	}
	
	@DeleteMapping("/subcategory/{subcategoryId}")
	public ResponseBean<SubCategory> deleteCustomerById(@PathVariable("subcategoryId") Long subcategoryId) {

		ResponseBean<SubCategory> res = new ResponseBean<>();

		Long product = service.delete(subcategoryId);

		if (product == null) {
			res.setData(null);
			res.setMessage("Invalid SubCategory Id");
			res.setStatus(-1);
		} else {
			//res.setData(product);
			res.setMessage("SubCategory Removed");
			res.setStatus(200);
		}
		return res;
	}
}
