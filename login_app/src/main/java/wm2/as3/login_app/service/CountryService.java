package wm2.as3.login_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wm2.as3.login_app.entity.Country;
import wm2.as3.login_app.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountryList(){
        List<Country> countries = (List<Country>) countryRepository.findAll();

        return countries;
    }

    public Country getById(Long id){
        Optional<Country> country1 = countryRepository.findById(id);

        if(country1.isPresent())
            return country1.get();

        return new Country("no", "data");
    }

    public Country save(Country country){
        return countryRepository.save(country);
    }

    public void deleteById(Long id) {

        countryRepository.deleteById(id);
    }

    public boolean existingCountry(Long id){
        Optional<Country> country = countryRepository.findById(id);

        return country.isPresent();
    }
}
