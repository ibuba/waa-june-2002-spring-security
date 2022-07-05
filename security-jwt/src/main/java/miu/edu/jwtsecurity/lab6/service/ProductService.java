package com.edu.miu.service;

import com.edu.miu.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> findAll();
    public void saveProduct(ProductDTO dto);
}
