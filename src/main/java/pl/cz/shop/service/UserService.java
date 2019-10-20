package pl.cz.shop.service;

import org.springframework.stereotype.Service;
import pl.cz.shop.dto.UserDto;
import pl.cz.shop.entity.User;
import pl.cz.shop.enums.UserPriviledgeEnum;
import pl.cz.shop.enums.UserStatus;
import pl.cz.shop.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    //Autowired niepotrzebny
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto saveUser(UserDto userDto) {

        checkForUserEmailExists(userDto.getEmail());

        User user = new User(userDto); //mapper

        user.setStatus(UserStatus.SMS_UNCONFIRMED);
        user.setUserPriviledge(UserPriviledgeEnum.CUSTOMER);

        return  new UserDto(user);
    }

    private void checkForUserEmailExists(String email) {
        if(userRepository.findByEmail(email).isPresent()){
            throw new RuntimeException("email already exists");
        }
    }
}