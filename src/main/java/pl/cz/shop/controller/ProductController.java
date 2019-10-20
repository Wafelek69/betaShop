package pl.cz.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.cz.shop.dto.ProductDto;
import pl.cz.shop.enums.ProductUnitEnum;
import pl.cz.shop.service.ProductService;
import pl.cz.shop.validator.ProductValidator;

//@Controller @Service @Repository @Component @Configuration @Bean

@Controller
public class ProductController {

    // Czeste pytanie podczas rozmowy jak są wstrykiwane zaleznosci w Springu
    // Odp: Przez pole, konstruktor i metode

    private final ProductService productService;
    private final ProductValidator productValidator;

    //@Autowired nie jest to potrzebne
    public ProductController(ProductService productService, ProductValidator productValidator) {
        this.productService = productService;
        this.productValidator = productValidator;
    }

    @GetMapping("/products")
    private String getProductList(Model model) {

        model.addAttribute("naszaListaProduktow", productService.getProducts());
        return "product_list";

    }

    @GetMapping("/products/{id}")
    private String getProductById(@PathVariable("id") Long id, Model model) {

        model.addAttribute("product", productService.getProductById(id));

        return "product_details";
       // propozycja :  model.addAttribute("imageList", imageService.getImagesByProductId);
    }

    @GetMapping("/products/form/create")
    private String getProductForm(Model model){

        model.addAttribute("product", new ProductDto());
        model.addAttribute("unitEnums", ProductUnitEnum.values());
        return "product_form_create";
    }

    @GetMapping("/products/form/{id}")
    private String updateProduct(@PathVariable("id") Long id, Model model){

        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("unitEnums", ProductUnitEnum.values());

        return "product_form_update";
    }

    @PostMapping("/products")
    private String saveProduct(@ModelAttribute("product") ProductDto productDto,
            Model model, BindingResult result) {
        if (productDto != null) {
            productValidator.validate(productDto, result);
        }

        if (result.hasErrors()) {
            return "product_form_create";
        }
        productService.saveProduct(productDto);
        model.addAttribute("naszaListaProduktow", productService.getProducts());
        return "product_list";

    }

    @GetMapping("products-delete/{id}")
    private String deleteProduct(@PathVariable("id") Long id, Model model){

        productService.deleteProduct(id);
        model.addAttribute("naszaListaProduktow", productService.getProducts());
        return "product_list";
    }
}
