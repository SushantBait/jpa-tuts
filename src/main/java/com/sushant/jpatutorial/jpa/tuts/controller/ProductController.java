package com.sushant.jpatutorial.jpa.tuts.controller;

import com.sushant.jpatutorial.jpa.tuts.dto.ProductDto;
import com.sushant.jpatutorial.jpa.tuts.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path ="/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDto>> getProduct(){
        //When we are mark @RequestParam it's an optional data but need to do with @RequestParam(required = false)
//        return ResponseEntity.ok(productService.getProductByTitleAndOrderByPrice());
        return ResponseEntity.ok(productService.getAllProductOrderByPrice());
    }
}
