package Crud;

import Entity.MyEntity;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CrudInterface {

    public MyEntity readEntity();
    public void updateEntity(MyEntity entity);
    public MyEntity watchParse(HttpServletRequest req);
    int getIndexByWatchId(int id, List<MyEntity> li);
    int getNextId(List<MyEntity> li);
}
