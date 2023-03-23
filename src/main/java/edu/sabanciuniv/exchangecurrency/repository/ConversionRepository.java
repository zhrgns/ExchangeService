package edu.sabanciuniv.exchangecurrencyservice.repository;

import edu.sabanciuniv.exchangecurrency.model.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion,Long> {
}
