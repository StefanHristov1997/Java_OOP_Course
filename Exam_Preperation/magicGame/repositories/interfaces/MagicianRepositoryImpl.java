package magicGame.repositories.interfaces;

import magicGame.common.ExceptionMessages;
import magicGame.models.magicians.Magician;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {
    private Collection<Magician> data;

    public MagicianRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return Collections.unmodifiableCollection(data);
    }

    @Override
    public void addMagician(Magician magician) {
        if (magician == null){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_REPOSITORY);
        }

        data.add(magician);
    }

    @Override
    public boolean removeMagician(Magician magician) {
        return data.remove(magician);
    }

    @Override
    public Magician findByUsername(String name) {
        return data.stream().filter(magician -> magician.getUsername().equals(name)).findFirst().orElse(null);
    }
}
