package Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "entity")
public class MyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price;
    private String img;

    public MyEntity(Integer id, String name, Integer price, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public MyEntity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "{\"id\":" +id+",\"name\":" +name+",\"price\":"+price+",\"img\":"+img+"}";
    }
}
