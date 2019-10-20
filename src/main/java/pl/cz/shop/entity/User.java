package pl.cz.shop.entity;


import pl.cz.shop.dto.UserDto;
import pl.cz.shop.enums.UserPriviledgeEnum;
import pl.cz.shop.enums.UserStatus;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "shop_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String telephone;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserPriviledgeEnum userPriviledge;//tak dla wiadomosci literowka, powinno byc privilege, szkoda czasu na przerobke kodu

    @OneToMany(mappedBy="user")
    private List<Commentary> commentaryList;

    public User(UserDto userDto) {
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
        this.telephone = userDto.getTelephone();
        this.address = userDto.getAddress();
    }

    public User() { // hibernate wymaga, zobaczcie co sie stanie bez tego konstruktora
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserPriviledgeEnum getUserPriviledge() {
        return userPriviledge;
    }

    public void setUserPriviledge(UserPriviledgeEnum userPriviledge) {
        this.userPriviledge = userPriviledge;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Commentary> getCommentaryList() {
        return commentaryList;
    }

    public void setCommentaryList(List<Commentary> commentaryList) {
        this.commentaryList = commentaryList;
    }
}
