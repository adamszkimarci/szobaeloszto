package hu.elte.Szobaeloszto.Repositories;

import hu.elte.Szobaeloszto.Entities.Epulet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpuletRepository extends CrudRepository<Epulet, Integer> {
}