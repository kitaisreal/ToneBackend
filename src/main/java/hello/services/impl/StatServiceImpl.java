package hello.services.impl;

import hello.entities.Stat;
import hello.repository.IStatRepository;
import hello.services.IStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component("StatService")
@Transactional

public class StatServiceImpl implements IStatService {
    private final IStatRepository statRepository;
    @Autowired
    public StatServiceImpl(IStatRepository statRepository){
        this.statRepository = statRepository;
    }

    @Override
    public void createStat(Stat stat) {
        statRepository.save(stat);
    }

    @Override
    public void deleteStat(Long id) {
        statRepository.delete(id);
    }

    @Override
    public void updateStat(Stat stat) {
        statRepository.save(stat);
    }

    @Override
    public List<Stat> getStatsByID(Long id) {
        List<Stat> statsById  = new ArrayList<>();
        for (Stat s: getAllStats()){
            if (s.getSong_id()==id){
                statsById.add(s);
            }
        }
        return statsById;
    }

    @Override
    public List<Stat> getAllStats() {
        return (List<Stat>) statRepository.findAll();
    }
}
