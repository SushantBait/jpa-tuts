package com.sushant.jpatutorial.jpa.tuts;

import com.sushant.jpatutorial.jpa.tuts.entites.ProductEntity;
import com.sushant.jpatutorial.jpa.tuts.repositoty.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialApplicationTests {

    @Autowired
    ProductRepository productRepository;


	@Test
	void contextLoads() {
	}

//    @Test
//    void TestRepository(){
//
//        ProductEntity productEntity= ProductEntity.builder()
//                .sku("nestle123")
//                .title("Nestle chocalate")
//                .price(BigDecimal.valueOf(123.45))
//                .quantity(12)
//                .build();
//        ProductEntity savedProductEntity = productRepository.save(productEntity);
//                System.out.println(savedProductEntity);
//    }

    @Test
    void getRepository(){
        List<ProductEntity> entities= productRepository.findAll();
        System.out.println(entities);
    }

//    @Test
//    void getRepositoryByTitle(){
//        List<ProductEntity> entities= productRepository.findByTitle("pepsi");
//        System.out.println(entities);
//    }
//
//
//    @Test
//    void getRepositoryAtAfter(){
//        List<ProductEntity> entities= productRepository.findByCreatedAtAfter(LocalDateTime.of(2024, 1, 2, 0,0,0));
//        System.out.println(entities);
//    }
//
//    @Test
//    void getRepositoryByQuantityGraterThanAndPriceLessThan(){
//        List<ProductEntity> entities= productRepository.findByQuantityGraterThanAndPriceLessThan(4, BigDecimal.valueOf(23.45));
//        System.out.println(entities);
//    }

    @Test
    void getRepositoryByTitleLike(){
        List<ProductEntity> entities= productRepository.findByTitleLike("%choc%");
        System.out.println(entities);
    }

    @Test
    void getRepositoryByTitleContaining(){
        List<ProductEntity> entities= productRepository.findByTitleContaining("choc");
        System.out.println(entities);
    }

    @Test
    void getSingleFromRepository(){
        Optional<ProductEntity> productEntity= productRepository.findByTitleAndPrice("coke",BigDecimal.valueOf(34.40));
        productEntity.ifPresent(System.out::println);
    }

}
