package pl.cz.shop.service;

import org.springframework.stereotype.Service;
import pl.cz.shop.dto.ProductDto;
import pl.cz.shop.entity.Product;
import pl.cz.shop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
//Czym sie rózni wzorzec MVC od wzorców projektowych GOF ?
    private final ProductRepository productRepository;

    //Autowired niepotrzebny
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getProducts() {

        return productRepository.findAll().stream()
                .map(ProductDto::new) // to samo .map(product -> new ProductDto(product))
                // jako ciekawostka .filter(productDto -> !productDto.getDescription().contains("ku!@#"))
                .collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id){

        //uwaga na optionale findById to optional, get to product
        Product product = productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Product not found by id: "+ id)
        );
        return new ProductDto(product);
    }

    public ProductDto saveProduct(ProductDto productDto){

        Product persistedProduct = productRepository.save(new Product(productDto));
        return new ProductDto(persistedProduct);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("no product found by id (delete): "+id));
        productRepository.delete(product);
        //productRepository.deleteById(id);
    }
}