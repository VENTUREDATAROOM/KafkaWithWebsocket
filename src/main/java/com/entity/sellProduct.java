package com.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "productHandler")
public class sellProduct {

	@Id
	private String productId;
	private String productName;
	private byte[] productImage;

}
