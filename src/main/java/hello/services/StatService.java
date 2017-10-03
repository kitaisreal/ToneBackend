package hello.services;

import hello.models.Stat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatService {
    void createStat(Stat stat);
    void deleteStat(Long id);
    void updateStat(Stat stat);
    List<Stat> getStatsByID(Long id);
    List<Stat> getAllStats();
}
