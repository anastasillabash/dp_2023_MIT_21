package Services;


import Entities.MyEntity;
import Repository.NewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Services {
    private NewRepository repo;

    public List<MyEntity> listAll(){
        return repo.findAll();
    }

    public void save(MyEntity entity){
        repo.save(entity);
    }

    public MyEntity get(int id){
        return repo.findById(id).get();
    }

    public void delete(int id){
        repo.deleteById(id);
    }
}
