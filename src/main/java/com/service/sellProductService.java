package com.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.entity.sellProduct;
import com.model.ProductListResponse;
import com.repository.sellProductRepository;

@Service
public class sellProductService {

	@Autowired
	private sellProductRepository sellProductRepo;

	public sellProduct AddSellProduct(MultipartFile Image, String ProductName) {

		UUID uuid = UUID.randomUUID();

		try {
			sellProduct ProductData = new sellProduct();
			ProductData.setProductId(uuid.toString());
			ProductData.setProductImage(Image.getBytes());
			ProductData.setProductName(ProductName);
			return this.sellProductRepo.save(ProductData);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public List<ProductListResponse> AllSellProductAvailble() {
		List<sellProduct> sellProduct = this.sellProductRepo.findAll();

		List<ProductListResponse> data = new ArrayList<>();

		for (sellProduct product : sellProduct) {
			ProductListResponse ProductResponse = new ProductListResponse();
			ProductResponse.setProductId(product.getProductId());
			ProductResponse.setProductName(product.getProductName());
			ProductResponse.setProductImage(byteImageToBase64(product.getProductImage()));
			data.add(ProductResponse);
		}
		return data;

	}

	public static String byteImageToBase64(byte[] imageBytes) {
		// Encode the byte array to Base64
		String base64String = Base64.getEncoder().encodeToString(imageBytes);
		return base64String;
	}

	public ProductListResponse getSingleSellProduct(String productId) {
		Optional<sellProduct> data = this.sellProductRepo.findById(productId);
		ProductListResponse Response = new ProductListResponse();
		Response.setProductId(data.get().getProductId());
		Response.setProductName(data.get().getProductName());
		Response.setProductImage(byteImageToBase64(data.get().getProductImage()));
		return Response;
	}

}
