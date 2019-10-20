package pl.cz.shop.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.cz.shop.dto.UserDto;
import pl.cz.shop.entity.User;
import pl.cz.shop.repository.UserRepository;

import java.util.Optional;

@Component
public class UserValidatorMK implements Validator {

    private final UserRepository userRepository;

    //Autowired
    public UserValidatorMK(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        UserDto userDto = (UserDto) object;

        if(userDto.getEmail() == null || userDto.getEmail().isEmpty()){
            errors.rejectValue("email", null, "email should not be empty");
        }
        //prawidlowy email
        else if(!userDto.getEmail().contains("@") || !userDto.getEmail().contains(".")){
            errors.rejectValue("email", null, "invalid email");
        }


        //haslo (min 3 znakow)
        if(userDto.getPassword().trim().length() < 3){
            errors.rejectValue("password", null, "password should be at least 3 characters");
        }
        //haslo == powtorzone haslo
        if(!userDto.getPassword().equals(userDto.getRepeatPassword())) {
            errors.rejectValue("password", null, "password should be the same");
        }

        if(userDto.getTelephone().trim().length() < 9){
            errors.rejectValue("telephone", null, "telephone should be at least 9 characters");
        }

        if(userDto.getAddress().trim().length() < 11){
            errors.rejectValue("address", null, "address should be at least 11 characters");
        }


   //2 nowe ify jeden telefon min 9 znakow uzyc trim()
        // address trim() min 11 znakow


    }
}
