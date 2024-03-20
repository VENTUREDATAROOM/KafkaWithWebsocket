package com.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.entity.availableProduct;
import com.model.availableProductRequest;
import com.repository.availableProductRepository;

@Service
public class availableProductService {

	@Autowired
	private availableProductRepository availableProductRepo;

	public availableProduct addAvailblePoduct(List<MultipartFile> productImageData, availableProductRequest productData)
			throws IOException {

		List<byte[]> byteList = new ArrayList<>();
		for (MultipartFile Image : productImageData) {
			byteList.add(Image.getBytes());
		}

		availableProduct availableProductData = new availableProduct();

		availableProductData.setAddress(productData.getAddress());
		availableProductData.setMandiName(productData.getMandiName());
		availableProductData.setQuantity(productData.getQuantity());
		availableProductData.setQuality(productData.getQuality());
		availableProductData.setPrice(productData.getPrice());
		availableProductData.setDistanceFromMandi(productData.getDistanceFromMandi());

		LocalDateTime currentDateTime = LocalDateTime.now();
		availableProductData.setHarvestDate(currentDateTime);

		UUID uuid1 = UUID.randomUUID();
		availableProductData.setId(uuid1.toString());

		UUID uuid2 = UUID.randomUUID();
		availableProductData.setProductId(uuid2.toString());

		availableProductData.setProductImage(byteList);

		try {

			availableProduct ResponseData = this.availableProductRepo.save(availableProductData);

			if (ResponseData == null) {
				return null;
			}
			return ResponseData;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<availableProduct> fetchAllAvailbleProduct() {
		return this.availableProductRepo.findAll();
	}

}
