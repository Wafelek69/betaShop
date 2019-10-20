package pl.cz.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cz.shop.entity.Product;
import pl.cz.shop.entity.User;
import pl.cz.shop.enums.UserPriviledgeEnum;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
