package Data;

import Entity.MyEntity;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<MyEntity> data = new ArrayList<>();

    public Data() {
        this.data.add(new MyEntity(1, "NDF-12", "25 places", "65$"));
        this.data.add(new MyEntity(2, "DK-65", "10 places", "45$"));
        this.data.add(new MyEntity(3, "MNB-R", "20 places", "60$"));
    }

    public List<MyEntity> getData(){
        return data;
    }

    public void setData(List<MyEntity> data) {
        this.data = data;
    }
}
