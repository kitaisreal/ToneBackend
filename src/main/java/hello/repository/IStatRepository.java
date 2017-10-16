package hello.repository;


import hello.entities.Stat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatRepository extends CrudRepository<Stat,Long> {
}
