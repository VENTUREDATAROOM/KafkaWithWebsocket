package com.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "availableProduct")
public class availableProduct {

	@Id
	private String id;
	private String productId;
	private String address;
	private String mandiName;
	private String quality;
	private String quantity;
	private String price;
	private String distanceFromMandi;
	private String userCode;
	private LocalDateTime harvestDate;
	private List<byte[]> productImage;

}
