package repository;

import domain.Address;

import java.util.Set;

public interface IAddressRepository extends IRepository<Address, String>{
    Address read(String addressUN);

    public Set<Address> getAll();
}
