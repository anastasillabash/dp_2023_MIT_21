package Crud;

import Entity.MyEntity;
import FileIO.FileIO;
import FileIO.FileIOInterface;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class FileCrud implements CrudInterface{

    FileIOInterface fio;

    public FileCrud(){
        this.fio = new FileIO();
    }

    @Override
    public MyEntity readEntity() {
        return (MyEntity) fio.loadFromFile();
    }

    @Override
    public void updateEntity(MyEntity entity) {
        fio.saveToFile(entity);

    }

    public JsonElement bodyParse(HttpServletRequest req){
        JsonElement jsonElement = null;

        try {
            jsonElement = JsonParser.parseReader(req.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException e){
            e.printStackTrace();
        }

        return jsonElement;
    }

    @Override
    public MyEntity watchParse(HttpServletRequest req) {
        MyEntity watch = new MyEntity();
        JsonElement jsonElement = bodyParse(req);
        watch.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        watch.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        watch.setPlaces(jsonElement.getAsJsonObject().get("places").getAsString());
        watch.setPrice(jsonElement.getAsJsonObject().get("price").getAsString());
        return watch;
    }

    @Override
    public int getIndexByWatchId(int id, List<MyEntity> list) {
        int listId = id;
        Iterator<MyEntity> iterator = list.iterator();
        while(iterator.hasNext()){
            MyEntity temp = iterator.next();
            if(temp.getId() == listId){
                listId=list.indexOf(temp);
                break;
            }
        }
        return listId;

    }

    @Override
    public int getNextId(List<MyEntity> list) {
        int maxId = 0;

        Iterator<MyEntity> iterator = list.iterator();
        while(iterator.hasNext()){
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }
}
