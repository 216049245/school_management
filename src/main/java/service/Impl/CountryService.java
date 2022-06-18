package service.Impl;

import domain.Country;
import repository.ICountryRepository;
import service.ICountryService;

import java.util.List;
import java.util.Optional;

public class CountryService implements ICountryService {

    private final ICountryRepository repository;

    public CountryService(ICountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Country save(Country country) {
        return repository.save(country);
    }

    @Override
    public List<Country> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Country> read(String countryId) {
        return Optional.empty();
    }

    @Override
    public Country findById(String cityId) {
        return repository.findById(cityId).orElseThrow(
                () -> new IllegalArgumentException("City not found"));
    }

    @Override
    public void deleteById(String cityId) {
        repository.deleteById(cityId);

    }

    @Override
    public Optional<Country> findByCountryId(String countryId) {
        return Optional.empty();
    }
}
