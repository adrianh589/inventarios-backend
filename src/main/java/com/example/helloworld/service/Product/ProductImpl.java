package com.example.helloworld.service.Product;

import com.example.helloworld.model.Product;
import com.example.helloworld.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductImpl implements ProductService {

    private final ProductRepository productRepository;

    ProductImpl( ProductRepository productRepository ){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
