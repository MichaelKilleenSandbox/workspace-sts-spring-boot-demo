package com.example.demo.persist;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.persist.Reservation;

/**
 * 
 * @author Michael
 *
 */
@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
	Collection<Reservation> findByReservationName(@Param(value = "rn") String rn );
	
}
