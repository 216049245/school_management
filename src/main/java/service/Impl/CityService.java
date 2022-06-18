package service.Impl;

import domain.City;
import repository.ICityRepository;
import service.ICityService;

import java.util.List;
import java.util.Optional;

public class CityService implements ICityService {

    private final ICityRepository repository;

    public CityService(ICityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City save(City city) {
        return repository.save(city);
    }

    @Override
    public List<City> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<City> read(String s) {
        return Optional.empty();
    }

    @Override
    public City findById(String s) {
        return repository.findById(s).orElseThrow(
                () -> new IllegalArgumentException("City not found"));
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public Optional<City> findByCountryId(String countryId) {
        return repository.findCityNameByCountryId(countryId);
    }
}
