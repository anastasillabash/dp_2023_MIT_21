package Entity;

import java.io.Serializable;

public class MyEntity implements Serializable {
    private String name;
    private String places;
    private String price;

    public MyEntity(String name, String places, String price) {
        this.name = name;
        this.places = places;
        this.price = price;
    }

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
        return "{\"name\": \""+name+"\", \"places\":\""+places+"\", \"price\": \""+price+"}";
    }
}
