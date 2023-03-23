package edu.sabanciuniv.exchangecurrencyservice.repository;


import edu.sabanciuniv.exchangecurrencyservice.model.Pair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PairRepository extends JpaRepository<Pair,Long> {
}
