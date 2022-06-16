package repository;

import domain.Name;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Siphiwe Edson Chauque -219084777
 * Application Development Practice 3
 * Due Date: 18 June 2022
 * ***Name*** entity
 */

public abstract class NameRepository implements iNameRepository<Name> {
    private static List<Name> nameList;
    private static NameRepository NIRepo = null;

//    Constructor
NameRepository() {
        nameList = new ArrayList<>();
    }

    public static NameRepository repository(){
        if(NIRepo == nameList){
            NIRepo = new NameRepository() {

                @Override
                public Name create(Name name) {
                    return null;
                }

                @Override
                public Name update(Name name) {
                    return this.update(name);
                }

                @Override
                public Set<Name> getAll() {
                    return this.getAll();
                }

                @Override
                public Set<Name> getall() {
                    return null;
                }

                @Override
                public Set<Name> getall(Name nam) {
                    return null;
                }


            };
        }
        return NIRepo;
    }

    public boolean delete(String firstName) {
        return false;
    }

    public Name save(Name name) {
        Optional<Name> read = read(name.getFirstName());

        if (read.isPresent()) {
            delete(read.get());
        }

        this.nameList.add(name);
        return name;
    }

    @Override
    public <ID> Optional<Name> read(ID id) {
        return Optional.empty();
    }


    public abstract Name create(Name name);

    //this method creates a person and add it to the repo
    public abstract Name update(Name name);

    @Override
    public Optional<Name> read(String identity) {
        return this.nameList
                .stream()
                .filter(g -> g.getFirstName().equalsIgnoreCase(identity))
                .filter(g -> g.getMiddleName().equalsIgnoreCase(identity))
                .filter(g-> g.getLastName().equalsIgnoreCase(identity))
                .findFirst();
    }

    public NameRepository delete(Name name){
        this.nameList.remove(name);
        return this;
    }

    public List<Name> findByFirstName(Name name){
        return this.nameList
                .stream()
                .filter(g -> g.getFirstName().equalsIgnoreCase(name.getFirstName()))
                .collect(Collectors.toList());
    }


    public abstract Set<Name> getAll();

    public abstract Set<Name> getall();

    public abstract Set<Name> getall(Name nam);
}
