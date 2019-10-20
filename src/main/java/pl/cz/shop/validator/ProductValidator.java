package pl.cz.shop.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.cz.shop.dto.ProductDto;
import pl.cz.shop.dto.UserDto;
import pl.cz.shop.repository.UserRepository;

@Component
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {

        return ProductDto.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        ProductDto productDto = (ProductDto) object;

        if(productDto.getTitle().trim().length() < 3){
            errors.rejectValue("title", null, "title should be at least 3 characters");
        }
        if(productDto.getPrice().matches("^[0-9,;]+$")){
            errors.rejectValue("price", null, "invalid price");
        }
        if(productDto.getUnit() != null){
            errors.rejectValue("unit", null, "unit should not be empty");
        }











    }

}
