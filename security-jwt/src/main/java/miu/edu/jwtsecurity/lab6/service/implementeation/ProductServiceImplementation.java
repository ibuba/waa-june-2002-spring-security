package com.edu.miu.service.implementeation;

import com.edu.miu.dto.ProductDTO;
import com.edu.miu.Domain.Product;
import com.edu.miu.repository.ProductRepository;
import com.edu.miu.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Service
@Transactional
public class ProductServiceImplementation implements ProductService {
    private ModelMapper mapper;
    private ProductRepository repository;


    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> dtos=new ArrayList<>();
        repository.findAll().forEach(product -> dtos.add(mapper.map(product,ProductDTO.class)));
        return dtos;
    }

    @Override
    public void saveProduct(ProductDTO dto) {
        repository.save(mapper.map(dto, Product.class));
    }
}
