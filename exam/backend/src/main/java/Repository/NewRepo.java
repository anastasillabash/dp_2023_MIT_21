package Repository;


import Entities.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "granats", path = "granats")
public interface NewRepo extends JpaRepository<MyEntity, Long> {
}
