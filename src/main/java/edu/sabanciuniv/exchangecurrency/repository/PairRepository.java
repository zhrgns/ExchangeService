package edu.sabanciuniv.exchangecurrency.repository;


import edu.sabanciuniv.exchangecurrency.model.Pair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PairRepository extends JpaRepository<Pair,Long> {

    @Query("select p from Pair p where p.source=:source and p.target=:target")
    Pair findPairBySourceAndTarget(String source, String target);
}
