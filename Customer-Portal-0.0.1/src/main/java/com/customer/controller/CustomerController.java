package com.customer.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.customer.datamodel.Customer;
import com.customer.datamodel.ImageFile;
import com.customer.datamodel.Project;
import com.customer.repository.CustomerRepository;
import com.customer.repository.ImageFileRepository;
import com.customer.repository.ProjectRepository;
import com.customer.service.ImageFileService;
import com.customer.urlconstant.URLConstants;
import org.springframework.validation.FieldError;

@RestController
public class CustomerController {

	@Autowired
	private ProjectRepository projectService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ImageFileService imageService;
	
	@Autowired
	private ImageFileRepository imageRepo;
	
	@RequestMapping(value=URLConstants.REST_SAVE_CUSTOMER_RECORDS, method = RequestMethod.POST)
	public ResponseEntity<?> getCustomer(BindingResult result)
	{
		if(result.hasErrors())
			return new ResponseEntity<List<FieldError>>(result.getFieldErrors(),HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(customerRepository.findAll(),HttpStatus.CREATED);
	}
	
	@RequestMapping(value=URLConstants.REST_GET_CUSTOMER_DETAILS, method = RequestMethod.GET)
	public ResponseEntity<?> saveCustomer(@Valid @RequestBody Customer customer, BindingResult result)
	{
		if(result.hasErrors())
			return new ResponseEntity<List<FieldError>>(result.getFieldErrors(),HttpStatus.BAD_REQUEST);
	
		customerRepository.save(customer);	
		return new ResponseEntity<>(customer,HttpStatus.CREATED);
	}
	

	
	@RequestMapping(value=URLConstants.REST_SAVE_PROJECT_DETAILS, method = RequestMethod.POST)
	public ResponseEntity<?> saveProject(@Valid @RequestBody Project project,BindingResult result)
	{
		if(result.hasErrors())
			return new ResponseEntity<Object>(result.getFieldError(),HttpStatus.BAD_REQUEST);
		projectService.save(project);	
		return new ResponseEntity<>(project,HttpStatus.CREATED);
	}
	
	@RequestMapping(value=URLConstants.REST_SAVE_IMAGE_FILE, method = RequestMethod.POST)
	public String uploadImage(@RequestParam MultipartFile multipartFile) throws Exception
	{
		imageService.storeFile(multipartFile);
		return "Image Save Successfully";
	}
	
	@RequestMapping(value = URLConstants.REST_GET_IMAGE_FILE, method = RequestMethod.GET)
   public Optional<ImageFile> downloadImage(@RequestParam Long id) throws Exception {
        return imageRepo.findById(id);
    }
}
