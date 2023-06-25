package Entity;

import java.io.Serializable;

public class MyEntity implements Serializable {

    private int id;
    private String name;
    private String places;
    private String price;

    public MyEntity(int id, String name, String places, String price) {
        this.id = id;
        this.name = name;
        this.places = places;
        this.price = price;
    }

    public MyEntity(){

    }

    public int getId(){return id;}
    public void setId(int id) {this.id = id;}


    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id +"{\"name\": \""+name+"\", \"places\":\""+places+"\", \"price\": \""+price+"}";
    }
}
