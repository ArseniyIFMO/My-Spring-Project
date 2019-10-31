package myPckg;

import org.springframework.data.repository.CrudRepository;


public interface MessageRepo extends CrudRepository<User, Integer> {
}
