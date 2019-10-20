package pl.cz.shop.service;

import org.springframework.stereotype.Service;
import pl.cz.shop.entity.User;
import pl.cz.shop.enums.UserPriviledgeEnum;
import pl.cz.shop.repository.UserRepository;
import pl.cz.shop.util.EmailUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailService {

    private final UserRepository userRepository;
    private final EmailUtil emailUtil;

    public EmailService(UserRepository userRepository, EmailUtil emailUtil) {
        this.userRepository = userRepository;
        this.emailUtil = emailUtil;
    }

    public void sendSpam() {
        List<User> userList6 = userRepository.findAll();
        List<User> userList = userRepository.findAll()
                .stream()
                .filter(user -> user.getUserPriviledge().equals(UserPriviledgeEnum.CUSTOMER))
                .collect(Collectors.toList());

userList.forEach(user -> emailUtil.sendSpam(user));
    }
}
