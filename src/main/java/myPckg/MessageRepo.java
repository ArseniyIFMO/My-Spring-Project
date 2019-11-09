package myPckg;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Integer> {
   List<Message> findByAuthor(User x);
   List<Message> findByAuthorAndAndText(User x, String y);
}
