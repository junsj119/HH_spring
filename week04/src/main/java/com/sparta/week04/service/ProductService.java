package com.sparta.week04.service;

import com.sparta.week04.domain.ItemDto;
import com.sparta.week04.domain.Product;
import com.sparta.week04.domain.ProductMypriceRequestDto;
import com.sparta.week04.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional // DB정보가 업데이트 된다.
    public Long Mypriceupdate(Long id, ProductMypriceRequestDto requestDto){
        Product product = productRepository.findById(id).orElseThrow(
            ()-> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        product.update(requestDto);
        return id;
    }

    @Transactional // DB정보가 업데이트 된다.
    public void updateBySearch(Long id, ItemDto itemDto){
        Product product = productRepository.findById(id).orElseThrow(
                ()->new NullPointerException("아이디가 존재하지 않습니다.")
        );
        product.updateByItemDto(itemDto);
    }


}
