package repository;

import domain.Address;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AddressRepository implements IAddressRepository {
    private static AddressRepository repository = null;
    private Set<Address> addressDB = null;

    private AddressRepository (){addressDB = new HashSet<Address>(); }

    public static AddressRepository getRepository(){
        if(repository == null) {
            repository = new AddressRepository();
        }
        return repository;
    }


    //@Override :commented out by Monehi Tuoane
    public Address read(Address ID) {
        return null;
    }

    @Override
    public Optional<Address> read(String addressUN) {
        Address address = addressDB.stream()
                .filter(p -> p.getUnitNumber().equals(addressUN))
                .findAny()
                .orElse(null);
        //Changed to Optional By Monehi Tuoane
        return Optional.ofNullable(address);
    }

    @Override
    public void delete(Address address) {

    }

    @Override
    public Address update(Address address) {
        //Changed to Optional By Monehi Tuoane
        Optional<Address> unit = read(address.getUnitNumber());
        if(unit != null){
            addressDB.remove(unit);
            addressDB.add(address);
            return address;
        }
        return null;

    }

    //@Override ://commented out by Monehi Tuoane
    public void delete(String addressUN) {
        //Changed to Optional By Monehi Tuoane
        Optional<Address> deleteAddress = read(addressUN);
        if (deleteAddress == null) {
            System.out.println("Address is null.");
        }
        addressDB.remove(deleteAddress);
        System.out.println("Address removed.");

    }

    @Override
    public Set<Address> getAll() {
        return addressDB;
    }



    //Added by Monehi Tuoane
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
}
