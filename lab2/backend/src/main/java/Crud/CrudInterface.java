package Crud;

import Entity.MyEntity;

public interface CrudInterface {

    public MyEntity readEntity();
    public void updateEntity(MyEntity entity);
}
