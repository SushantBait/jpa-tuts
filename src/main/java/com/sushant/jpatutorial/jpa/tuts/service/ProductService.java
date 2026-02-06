package com.sushant.jpatutorial.jpa.tuts.service;

import com.sushant.jpatutorial.jpa.tuts.dto.ProductDto;
import com.sushant.jpatutorial.jpa.tuts.entites.ProductEntity;
import com.sushant.jpatutorial.jpa.tuts.repositoty.ProductRepository;
import org.apache.catalina.mapper.Mapper;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final int PAGE_SIZE = 5;

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getProductByTitleAndOrderByPrice() {
            List<ProductEntity> productEntityList = productRepository.findByTitleOrderByPrice("Sprite");
        ModelMapper modelMapper= new ModelMapper();

        return productEntityList
                .stream()
                .map(productEntity -> modelMapper.map(productEntity, ProductDto.class))
                .collect(Collectors.toList());
    }

    public  List<ProductDto> getAllProductOrderByPrice() {

        List<ProductEntity> productEntityList = productRepository.findAllByOrderByPriceAsc();
        ModelMapper modelMapper= new ModelMapper();

        return productEntityList
                .stream()
                .map(productEntity -> modelMapper.map(productEntity, ProductDto.class))
                .collect(Collectors.toList());
    }

    public List<ProductEntity> findByTitleContainingIgnoreCase(String title, String sortBy, Integer pageNumber) {


        return productRepository.findByTitleContainingIgnoreCase(
                title,
                PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy))
        );
    }
}
