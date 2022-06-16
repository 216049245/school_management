package repository;

import domain.Address;

import java.util.Optional;
import java.util.Set;

public interface IAddressRepository extends IRepository<Address, String>{
    Optional<Address> read(String addressUN);

    public Set<Address> getAll();
}
