package hello.repository;


import hello.entities.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends CrudRepository<Song,Long> {
}
