package wm2.as3.login_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wm2.as3.login_app.entity.Country;

import java.util.Optional;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
    Optional<Country> findById(Long id);

    void deleteById(Long id);
}
