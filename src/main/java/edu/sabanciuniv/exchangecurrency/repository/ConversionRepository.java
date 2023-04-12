package edu.sabanciuniv.exchangecurrency.repository;

import edu.sabanciuniv.exchangecurrency.model.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion,Long> {

    Conversion findByTransactionId(String id);

    List<Conversion> findByTransactionDate(LocalDateTime transactionDate);
}
