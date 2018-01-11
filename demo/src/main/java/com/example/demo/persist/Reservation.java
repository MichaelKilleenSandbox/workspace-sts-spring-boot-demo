package com.example.demo.persist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author Michael
 *
 */
@Entity
public class Reservation {

	@Id
	@GeneratedValue
	private Long id;
	
	private String reservationName;
	
	/**
	 * 
	 */
	public Reservation() {
		
	}
	
	/**
	 * 
	 * @param reservationName
	 */
	public Reservation(String reservationName) {
		this.reservationName = reservationName;
	}
	
	/**
	 * 
	 * @return
	 */
	public Long getId() {
		return this.id;
	}
	
	public String getReservationName() {
		return this.reservationName;
	}
	
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", reservationName=" + reservationName + "]";
	}
}
