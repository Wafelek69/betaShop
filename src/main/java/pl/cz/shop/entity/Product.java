package pl.cz.shop.entity;

import pl.cz.shop.dto.ProductDto;
import pl.cz.shop.enums.ProductUnitEnum;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double price;
    @Enumerated(EnumType.STRING)
    private ProductUnitEnum unit;
    @Column(name = "main_photo")
    private String mainPhoto;
    @OneToMany(mappedBy="product")
    private List<Commentary> commentaryList;

    public Product(ProductDto productDto) {
        this.id = productDto.getId();
        this.title = productDto.getTitle();
        this.description = productDto.getDescription();
        this.price = Double.parseDouble(productDto.getPrice()); // troche słabe to jest
        this.unit = productDto.getUnit();
        this.mainPhoto = productDto.getMainPhoto();
    }

    public Product() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public List<Commentary> getCommentaryList() {
        return commentaryList;
    }

    public void setCommentaryList(List<Commentary> commentaryList) {
        this.commentaryList = commentaryList;
    }
}
