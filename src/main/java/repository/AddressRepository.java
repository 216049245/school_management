package repository;

import domain.Address;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AddressRepository implements IAddressRepository {
    private static AddressRepository repository = null;
    private Set<Address> addressDB = null;

    private AddressRepository (){
        addressDB = new HashSet<Address>();
    }

    public static AddressRepository getRepository(){
        if(repository == null) {
            repository = new AddressRepository();
        }
        return repository;
    }

    @Override
    public Address save(Address address) {
        return null;
    }

    @Override
    public Address create(Address address){
        boolean success = addressDB.add(address);
        if(!success) {
            return null;
        }
        return address;
    }

//    @Override
//    public Address read(Address ID) {
//        return null;
//    }

    @Override
    public Optional<Address> read(String addressUN) {
        Optional<Address> address = Optional.ofNullable(addressDB.stream()
                .filter(p -> p.getUnitNumber().equals(addressUN))
                .findAny()
                .orElse(null));
        return address;
    }

//    @Override
//    public void delete(Address address) {
//
//    }

    @Override
    public Address update(Address address) {
        Optional<Address> unit = read(address.getUnitNumber());
        if(unit != null){
            addressDB.remove(unit);
            addressDB.add(address);
            return address;
        }
        return null;

    }

    @Override
    public void delete(Address address) {
        this.addressDB.remove(address);

    }


    @Override
    public Set<Address> getAll() {
        return addressDB;
    }
}
