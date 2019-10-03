package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.Spitter;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemorySpitterRepository implements SpitterRepository {

    private static Long counter = 1000L;

    private List<Spitter> spitters = new ArrayList<>();

    @Override
    public Spitter save(Spitter spitter) {
        long id = InMemorySpitterRepository.counter++;
        spitter.setId(id);
        spitters.add(spitter);
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        return spitters.stream().filter(s -> s.getUsername().equals(username)).findFirst().get();
    }
}
