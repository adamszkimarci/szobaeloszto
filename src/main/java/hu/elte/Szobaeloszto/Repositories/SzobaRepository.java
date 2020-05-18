package hu.elte.Szobaeloszto.Repositories;

import hu.elte.Szobaeloszto.Entities.Szoba;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SzobaRepository extends CrudRepository<Szoba, Integer> {
    
    @Query("select sz FROM Szoba sz WHERE sz.epuletNev = ?1")
    List<Szoba> findByEpuletNev(String epulet);
    
}