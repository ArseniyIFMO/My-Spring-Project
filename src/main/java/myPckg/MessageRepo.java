package myPckg;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MessageRepo extends CrudRepository<Notes, Integer> {
    List<Notes> findByName(String name);

    @Query("select e from Notes e where e.id > :id")
    List<Notes> findNotesWithIdMoreThanX(@Param("id") int id);

    List<Notes>  findById(int id);
}
