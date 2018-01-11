package com.example.demo.persist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

   @Id
   @GeneratedValue
   private Long id;
   private String street;
   private String city;
   private String state;
   private String zipCode;

   public Address() {
   }

   /**
    *
    * @param street
    * @param city
    * @param state
    * @param zipCode
    */
   public Address( final String street, final String city, final String state, final String zipCode ) {
      this.street = street;
      this.city = city;
      this.state = state;
      this.zipCode = zipCode;
   }

   /**
    *
    * @return
    */
   public Long getId() {
      return id;
   }

   /**
    *
    * @return
    */
   public String getStreet() {
      return street;
   }

   /**
    *
    * @return
    */
   public String getCity() {
      return city;
   }

   /**
    *
    * @return
    */
   public String getState() {
      return state;
   }

   /**
    *
    * @return
    */
   public String getZipCode() {
      return zipCode;
   }

   /**
    *
    * @return
    */
   @Override public String toString() {
      final StringBuilder sb = new StringBuilder( "Address{" );
      sb.append( "id=" ).append( id );
      sb.append( ", street='" ).append( street ).append( '\'' );
      sb.append( ", city='" ).append( city ).append( '\'' );
      sb.append( ", state='" ).append( state ).append( '\'' );
      sb.append( ", zipCode='" ).append( zipCode ).append( '\'' );
      sb.append( '}' );
      return sb.toString();
   }
}