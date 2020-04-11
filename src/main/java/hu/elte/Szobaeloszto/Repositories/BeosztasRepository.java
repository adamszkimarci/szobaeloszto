
package hu.elte.Szobaeloszto.Repositories;

import hu.elte.Szobaeloszto.Entities.Beosztas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeosztasRepository extends CrudRepository<Beosztas, Integer> { 
}