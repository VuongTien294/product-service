package tien.baseproject.productservice.mapper.impl;

import org.springframework.stereotype.Component;
import tien.baseproject.productservice.dto.response.ProductResponse;
import tien.baseproject.productservice.entity.Product;
import tien.baseproject.productservice.mapper.ProductMapper;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
