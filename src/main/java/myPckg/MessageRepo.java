package myPckg;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MessageRepo extends CrudRepository<User, Integer> {
    List<User> findByName(String name);
}