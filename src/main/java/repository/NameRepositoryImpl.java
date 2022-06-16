package repository;

import domain.Name;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/*
 * Siphiwe Edson Chauque -219084777
 * Application Development Practice 3
 * Due Date: 18 June 2022
 * ***Name*** entity
 */
public class NameRepositoryImpl extends NameRepository {
    private final Set<Name> Names;
    private static NameRepository repository = null;

    public NameRepositoryImpl() {
        this.Names = new HashSet<>();
    }

    public static NameRepository getRepository() {
        if (repository == null) repository = new NameRepositoryImpl();
        return repository;
    }

    @Override
    public Name create(Name name) {
        this.Names.add(name);
        return name;
    }

    @Override
    public Name update(Name name) {
        Optional<Name> read = read(name.getFirstName());
        if (read.isPresent()) {
            this.Names.remove(name);
            this.Names.add(name);
            return name;
        }
        return null;
    }


    @Override
    public NameRepository delete(Name t) {

        return null;
    }

    @Override
    public Optional<Name> read(String s) {
        for (Name nam : this.Names) {
            if (nam.equals(nam));
            return Optional.of(nam);
        }
        return null;
    }

    @Override
    public Set<Name> getAll() {
        return this.Names;
    }



    @Override
    public Set<Name> getall() {
        return this.Names;
    }

    @Override
    public Set<Name> getall(Name nam) {
        return null;
    }


}

