package Controller;


import Entities.MyEntity;
import Repository.NewRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("/api/granats")
@Slf4j
public class Controller {

    @Autowired
    NewRepo repo;

    @GetMapping("/get")
    public List<MyEntity> getEntities(){
        List<MyEntity> list;
        log.info("Before GET");
        list = repo.findAll();
        log.info("GET method performed", list.size());
        return list;
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public MyEntity postEntity(@RequestBody MyEntity entity){
        log.info("POST method performed: new granat added ", entity);
        return repo.save(entity);
    }

    @PutMapping("/update/{id}")
    public MyEntity putEntity(@PathVariable long id, @RequestBody MyEntity newEntity){
        MyEntity updatesEntity = repo.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Not found Entity with id: "+id));
        updatesEntity.setName(newEntity.getName());
        updatesEntity.setPrice(newEntity.getPrice());
        updatesEntity.setVaga(newEntity.getVaga());
        log.info("PUT method performed", updatesEntity);
        return repo.save((updatesEntity));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable long id){
        MyEntity deletedEntity = repo.findById(id)
                .orElseThrow(()-> new ResourceAccessException("Not found Entity with id: "+id));
        log.info("DELETE method performed ", deletedEntity);
        repo.deleteById(id);
    }
}
