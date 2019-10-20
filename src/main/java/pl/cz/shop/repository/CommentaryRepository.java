package pl.cz.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cz.shop.entity.Commentary;
import pl.cz.shop.entity.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface CommentaryRepository extends JpaRepository<Commentary, Long> {

    List<Commentary> getCommentaryByProductId(Long id);
}
