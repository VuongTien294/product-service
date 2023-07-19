package tien.baseproject.productservice.mapper;

import tien.baseproject.productservice.dto.response.ProductResponse;
import tien.baseproject.productservice.entity.Product;

public interface ProductMapper {
    ProductResponse mapToProductResponse(Product product);
}
