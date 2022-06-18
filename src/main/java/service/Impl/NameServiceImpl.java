package service.Impl;

import domain.Name;
import repository.NameRepository;
import repository.NameRepositoryImpl;
import service.NameService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/*
 * Siphiwe Edson Chauque -219084777
 * Application Development Practice 3
 * Due Date: 18 June 2022
 * ***Name*** entity
 */

public class NameServiceImpl implements NameService {
    private final NameRepository repository;
    private static NameService service = null;

    private NameServiceImpl() {
        this.repository = NameRepositoryImpl.getRepository();
    }

    public static NameService getService() {
        if (service == null) service = new NameServiceImpl();
        return service;
    }

    @Override
    public Name save(Name name) {
        return (Name) this.repository.getall();
    }
    @Override
    public <ID> Optional<Name> read(ID id) {
        return Optional.empty();
    }

    @Override
    public Name delete(Name name) {
        repository.delete(name);
        return name;
    }

    @Override
    public Name create(Name name) {
        return this.repository.create(name);
    }

    @Override
    public Name update(Name name) {
        return this.repository.update(name);
    }

    @Override
    public Optional<Name> read(String s) {
        return this.repository.read(s);
    }


    @Override
    public Name delete(String s) {
        repository.delete(s);
        return null;
    }

    @Override
    public Set<Name> getall() {
        return null;
    }


    @Override
    public Set<Name> getAll() {
        return this.repository.getall();
    }

    @Override
    public Set<Name> getWithLastName(String lastName) {
        Set<Name> names = getAll();
        Set<Name> result = new HashSet<>();
        for(Name name : names) {
            if (name.getLastName().equalsIgnoreCase(lastName)) {
                result.add(name);
            }
        }
        return result;
    }
}

