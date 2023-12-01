package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {
    private Collection<Delicacy> mdelicacies;

    public DelicacyRepositoryImpl() {
        this.mdelicacies = new ArrayList<>();
    }

    @Override
    public Collection<Delicacy> getAll() {
        return Collections.unmodifiableCollection(mdelicacies);
    }

    @Override
    public void add(Delicacy delicacy) {
        mdelicacies.add(delicacy);
    }

    @Override
    public Delicacy getByName(String name) {
        return mdelicacies.stream().filter(delicacy -> delicacy.getName().equals(name)).findFirst().orElse(null);
    }
}
