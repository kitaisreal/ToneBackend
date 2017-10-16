package hello.repository;


import hello.entities.AppArtist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArtistRepository extends CrudRepository<AppArtist,Long> {
}


