package hello.services;

import hello.entities.Stat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStatService {
    void createStat(Stat stat);
    void deleteStat(Long id);
    void updateStat(Stat stat);
    List<Stat> getStatsByID(Long id);
    List<Stat> getAllStats();
}
