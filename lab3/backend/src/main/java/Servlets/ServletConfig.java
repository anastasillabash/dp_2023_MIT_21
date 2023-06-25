package Servlets;

import Crud.CrudInterface;
import Crud.FileCrud;


public class ServletConfig implements ServletConfigInterface{

    CrudInterface crudInterface;

    public ServletConfig(){
        this.crudInterface = new FileCrud();
    }


    public void setCrudInterface(CrudInterface crudInterface) {
        this.crudInterface = crudInterface;
    }

    public CrudInterface getCrud(){
        return crudInterface;
    }
}
