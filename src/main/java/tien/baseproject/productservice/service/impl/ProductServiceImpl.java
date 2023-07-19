package tien.baseproject.productservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tien.baseproject.productservice.dto.request.InventoryRequest;
import tien.baseproject.productservice.dto.request.ProductRequest;
import tien.baseproject.productservice.dto.response.ProductResponse;
import tien.baseproject.productservice.entity.Product;
import tien.baseproject.productservice.mapper.ProductMapper;
import tien.baseproject.productservice.repository.ProductRepository;
import tien.baseproject.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Value(value = "${url.create-inventory-url}")
    private String createInventoryEndpoint;

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final RestTemplate restTemplate;

    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        //Gọi sang inventory service để tạo sản phẩm tồn kho
        HttpEntity<InventoryRequest> request = new HttpEntity<>(new InventoryRequest(productRequest.getName(), productRequest.getQuantity()));
        Boolean response = restTemplate.exchange(createInventoryEndpoint, HttpMethod.POST, request, Boolean.class).getBody();
        if(response.equals(true)){
            productRepository.save(product);
            log.info("Product {} is saved", product.getName());
        }else {
            log.info("Product {} is error", product.getName());
        }
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        List<ProductResponse> responses = new ArrayList<>();
        for (Product product: products) {
            responses.add(productMapper.mapToProductResponse(product));
        }

        return responses;
    }

}
