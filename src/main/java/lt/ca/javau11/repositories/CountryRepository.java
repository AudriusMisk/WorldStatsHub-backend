package lt.ca.javau11.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lt.ca.javau11.entities.Country;
import lt.ca.javau11.entities.Region;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long>{

	 List<Country> findByRegion(Region region);
}
