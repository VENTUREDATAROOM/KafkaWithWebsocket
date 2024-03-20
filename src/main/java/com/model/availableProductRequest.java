package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class availableProductRequest {

	private String address;
	private String mandiName;
	private String quality;
	private String quantity;
	private String price;
	private String distanceFromMandi;
	// private LocalDateTime harvestDate;

}
