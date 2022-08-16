package com.project.agency.repositories;

import com.project.agency.entities.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface CabinRepository extends JpaRepository<Cabin, Long> {

    @Transactional
    @Modifying
    @Query("SELECT C from Cabin C WHERE C.availability = 'AVAILABLE' OR C.endDate <= :X")
    List<Cabin> findCabins(Date X);
}
