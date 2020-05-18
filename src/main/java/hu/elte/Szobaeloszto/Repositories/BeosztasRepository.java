
package hu.elte.Szobaeloszto.Repositories;

import hu.elte.Szobaeloszto.Entities.Beosztas;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeosztasRepository extends CrudRepository<Beosztas, Integer> { 
    
    @Query("select sz FROM Beosztas sz WHERE sz.neptunKod = ?1")
    List<Beosztas> findByNeptunKod(String neptunkod);
    
}