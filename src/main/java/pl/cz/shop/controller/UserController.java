package pl.cz.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.cz.shop.dto.UserDto;
import pl.cz.shop.service.UserService;
import pl.cz.shop.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;

    ///@Autowired nie jest potrzebny
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping("/users/form/create")
    public String getUserForm(Model model){

        model.addAttribute("userDto", new UserDto());
        return "user_form_create";
    }

    @PostMapping("/users")
    public String saveUsers(@ModelAttribute("userDto") UserDto userDto, Model model, BindingResult result) {
        // ObjectError oe = new ObjectError();

        if (userDto != null) {
            userValidator.validate(userDto, result);
        }

        if (result.hasErrors()) {
            return "user_form_create";
        }

        UserDto persistedUserDto = userService.saveUser(userDto);
        model.addAttribute("persistedUser", persistedUserDto);
        return "user_create_success";
    }


    @GetMapping("/users/login")
    private String getUserList(HttpServletRequest request, Model model) {

//        String login = request.getParameter("login");
//
//        System.out.println(login);
//        User user = userService.getUserByLogin(login);
//        System.out.println(user.getLogin()+user.getPassword());
//        request.getSession().setAttribute("user",user);
        return "user_list";
    }

}
