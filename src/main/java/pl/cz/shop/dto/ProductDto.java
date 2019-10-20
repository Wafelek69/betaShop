package pl.cz.shop.dto;

import pl.cz.shop.entity.Product;
import pl.cz.shop.enums.ProductUnitEnum;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDto {

    private Long id;
    private String title;
    private String description;
    private String price;
    private ProductUnitEnum unit;
    private String mainPhoto;
    private List<CommentaryDto> commentaryList;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.description = product.getDescription();
        this.price = product.getPrice().toString();
        this.unit = product.getUnit();
        this.mainPhoto = product.getMainPhoto();
        this.commentaryList = product.getCommentaryList().stream()
                .map(commentary -> new CommentaryDto(commentary))
                .collect(Collectors.toList());

    }

    public ProductDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public ProductUnitEnum getUnit() {
        return unit;
    }

    public void setUnit(ProductUnitEnum unit) {
        this.unit = unit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<CommentaryDto> getCommentaryList() {
        return commentaryList;
    }

    public void setCommentaryList(List<CommentaryDto> commentaryList) {
        this.commentaryList = commentaryList;
    }
}
