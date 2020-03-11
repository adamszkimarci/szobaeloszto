package hu.elte.Szobaeloszto.Repositories;

import hu.elte.Szobaeloszto.Entities.Diak;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiakRepository extends CrudRepository<Diak, Integer> {
}