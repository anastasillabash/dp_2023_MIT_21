package Crud;

import Entity.MyEntity;
import FileIO.FileIO;
import FileIO.FileIOInterface;

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
}
