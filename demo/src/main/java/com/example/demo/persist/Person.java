package com.example.demo.persist;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Person {

   @Id
   @GeneratedValue
   private Long id;
   private String name;
   @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   private List<Address> addressList;

   /**

    *
    */
   public Person() {
   }

   /**
    *
    * @param name
    */
   public Person( final String name) {
      this.name = name;
      if(this.addressList == null) {
         this.addressList = new ArrayList<Address>(  );
      }
   }

   public Person( final String name, final Address address) {
      this.name = name;
      if(this.addressList == null) {
         this.addressList = new ArrayList<Address>(  );
      }
      this.addressList.add( address );
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
   public String getName() {
      return name;
   }

   /**
    *
    * @return
    */
   public List<Address> getAddressList() {
      return new ArrayList<Address>( addressList );
   }


   /**
    * 
    */
   @Override public String toString() {
     final StringBuilder sb = new StringBuilder( "Person{" );
      sb.append( "id=" ).append( id );
      sb.append( ", name='" ).append( name ).append( '\'' );
      sb.append( ", addressList=" ).append( addressList );
      sb.append( '}' );
      return sb.toString();
   }
}
