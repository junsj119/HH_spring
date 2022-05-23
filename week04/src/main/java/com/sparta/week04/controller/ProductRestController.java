package com.sparta.week04.controller;

import com.sparta.week04.domain.Product;
import com.sparta.week04.domain.ProductMypriceRequestDto;
import com.sparta.week04.domain.ProductRepository;
import com.sparta.week04.domain.ProductRequestDto;
import com.sparta.week04.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/api/products")        //다 보여주기
    public List<Product> readProducts(){
        return productRepository.findAll();
    }

    @PostMapping("/api/products")           //입력받은 값들을 Product생성자를 통해 넣어주고 그 객체?를 레포지토리에 넣어서 저장한다.
    public Product createProduct(@RequestBody ProductRequestDto requestDto){
        Product product = new Product(requestDto);  //비영속상태
        return productRepository.save(product);
    }

    @PutMapping("/api/products/{id}")
    public void mypriceSet(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto){
        productService.Mypriceupdate(id, requestDto);
    }

}
