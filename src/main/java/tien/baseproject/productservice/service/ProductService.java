package tien.baseproject.productservice.service;

import tien.baseproject.productservice.dto.request.ProductRequest;
import tien.baseproject.productservice.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
