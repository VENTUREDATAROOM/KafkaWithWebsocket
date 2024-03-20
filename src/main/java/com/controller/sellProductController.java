package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.entity.sellProduct;
import com.model.ProductListResponse;
import com.service.sellProductService;

@RestController
@RequestMapping("/product")
public class sellProductController {

	@Autowired
	private sellProductService sellProductService;

	@PostMapping("/add/sellProduct")
	public ResponseEntity<?> addSellProduct(@RequestParam("productImage") MultipartFile ProductImage,
			@RequestParam("productName") String productName) {

		try {
			sellProduct sellData = this.sellProductService.AddSellProduct(ProductImage, productName);
			return new ResponseEntity<sellProduct>(sellData, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>("Bad request", HttpStatus.BAD_GATEWAY);
		}

	}

	@GetMapping("/get/allProduct")
	public ResponseEntity<?> getAllproductForSell() {
		try {
			List<ProductListResponse> AllProduct = this.sellProductService.AllSellProductAvailble();
			return new ResponseEntity<List<ProductListResponse>>(AllProduct, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>("Bad Request", HttpStatus.BAD_GATEWAY);
		}
	}

	@GetMapping("/get/singleProduct/{productId}")
	public ResponseEntity<?> getsingleProduct(@PathVariable("productId") String productId) {
		try {
			ProductListResponse data = this.sellProductService.getSingleSellProduct(productId);
			return new ResponseEntity<ProductListResponse>(data, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>("Bad Request", HttpStatus.BAD_GATEWAY);
		}
	}

	@GetMapping("/gg")
	public String gg() {
		return "gg";
	}

}
