package myPckg;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MessageRepo extends CrudRepository<Notes, Integer> {
    List<Notes> findByName(String name);
}
