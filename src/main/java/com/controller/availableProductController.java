package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.entity.availableProduct;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.availableProductRequest;
import com.model.availableProductResponse;
import com.service.KafkaService;
import com.service.availableProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class availableProductController {

	@Autowired
	private KafkaService kafkaservise;

	@Autowired
	private availableProductService availableProductService;

	@PostMapping("/add/productForSell")
	public ResponseEntity<?> addProductForSell(@RequestParam("listImage") List<MultipartFile> listImageData,
			@RequestParam("formData") String formData) throws JsonMappingException, JsonProcessingException {
		ObjectMapper object = new ObjectMapper();
		availableProductRequest dat = object.readValue(formData, availableProductRequest.class);
		// int aa = data.size();

		availableProductResponse Response = new availableProductResponse();

		try {

			availableProduct dataProduct = this.availableProductService.addAvailblePoduct(listImageData, dat);
			if (dataProduct == null) {
				throw new NullPointerException("error_NoData");
			}
			Response.setStatus("you product Ready to sell !");
			this.kafkaservise.updateLocation("100");
			return new ResponseEntity<availableProductResponse>(Response, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Response.setStatus("opps ! soory Insert again!");
			return new ResponseEntity<availableProductResponse>(Response, HttpStatus.BAD_GATEWAY);

		}

		// return new ResponseEntity<availableProductRequest>(dat, HttpStatus.OK);
	}

	@GetMapping("/get/allProductSell")
	public ResponseEntity<?> getAllAvailbledata() {
		try {

			List<availableProduct> dataOfProduct = this.availableProductService.fetchAllAvailbleProduct();
//			this.kafkaservise.updateLocation("bhai");
			return new ResponseEntity<List<availableProduct>>(dataOfProduct, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>("bad", HttpStatus.BAD_GATEWAY);
		}
	}

}
