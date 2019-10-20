package pl.cz.shop.dto;

import pl.cz.shop.entity.Commentary;
import pl.cz.shop.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;

public class CommentaryDto {

    private Long id;
    private String text;
    private LocalDateTime publishDate;
    private User user;

    public CommentaryDto(Commentary commentary) {
        this.id = commentary.getId();
        this.text = commentary.getText();
        this.publishDate = commentary.getPublishDate();
    }

    public CommentaryDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
