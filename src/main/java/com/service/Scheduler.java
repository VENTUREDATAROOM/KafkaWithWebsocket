package com.service;

//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.entity.availableProduct;
//import com.repository.availableProductRepository;
//
//@Configuration
//@EnableScheduling
//public class Scheduler {
//
//	@Autowired
//	private KafkaService kafkaservise;
//
//	@Autowired
//	private availableProductRepository availableProductRepo;
//
//	@Autowired
//	private availableProductService availableProductService;
//
//	@Scheduled(fixedRate = 1000)
//	public void scheduler1() {
//
//		availableProduct availableProductData = new availableProduct();
//
//		availableProductData.setAddress("kalavaan pur");
//		availableProductData.setMandiName("ghagha");
//		availableProductData.setQuantity("ghagha");
//		availableProductData.setQuality("ghagha");
//
//		int price = (int) (Math.random() * 1000);
//		String pprice = Integer.toString(price);
//		availableProductData.setPrice(pprice);
//		availableProductData.setDistanceFromMandi("ghagha");
//
//		LocalDateTime currentDateTime = LocalDateTime.now();
//		availableProductData.setHarvestDate(currentDateTime);
//
//		UUID uuid1 = UUID.randomUUID();
//		availableProductData.setId(uuid1.toString());
//		availableProductData.setDistanceFromMandi("10");
//
//		java.util.List<MultipartFile> ProductImage = new java.util.ArrayList<>();
//
//		availableProduct ResponseData = availableProductRepo.save(availableProductData);
//		System.out.print("hhhh");
//		int Avarage = getTotal();
//		String data = Integer.toString(Avarage);
//		this.kafkaservise.updateLocation(data);
//		System.out.print("jj");
//
//	}
//
//	public int getTotal() {
//		List<availableProduct> data = this.availableProductRepo.findAll();
//
//		int total = 0;
//		int var = 0;
//		for (int i = 0; i < data.size(); i++) {
//			String ll = data.get(i).getPrice();
//			int aa = Integer.parseInt(ll);
//			total += aa;
////			if (var == 0) {
////				total += aa;
////				var = 1;
////			} else {
////				total -= aa;
////				var = 0;
////			}
//		}
//		return total / data.size();
//	}
//
//}
