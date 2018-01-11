package com.example.demo;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.persist.Address;
import com.example.demo.persist.AddressRepository;
import com.example.demo.persist.Person;
import com.example.demo.persist.PersonRepository;
import com.example.demo.persist.Reservation;
import com.example.demo.persist.ReservationRepository;

/**
 * 
 * @author Michael
 *
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(ReservationRepository rr, PersonRepository pr, AddressRepository ar) {
		Random random = new Random();
		return (args)-> {
			Arrays.asList("Mike,Wendy,Matt,Alex,Missy,Dewey,Denver".split(","))
				.forEach(n->rr.save(new Reservation(n)));
			
			rr.findAll().forEach(System.out::println);
			
			rr.findByReservationName("Alex").forEach(System.out::println);

			Arrays.asList("Mike,Wendy,Matt,Alex,Missy,Dewey,Denver".split(","))
			.forEach(n-> {
				
				Address address = new Address(String.valueOf(1 + random.nextInt(100)) + " Clark Street", "North Babylon", "NY", "11704");
				pr.save(new Person(n, address));
			});
			
			
		};
	}
}

/**
 * 
 * @author Michael
 *
 */
//@RestController
//class ReservationRestController {
//	
//	@Autowired
//	private ReservationRepository reservationRepository;
//	
//	@RequestMapping("/reservations")
//	Collection<Reservation> reservations() {
//		return this.reservationRepository.findAll();
//	}
//}

@Controller
class ReservationMvcController {
	@Autowired
	private ReservationRepository reservationRepository;

	@RequestMapping("/reservations.php")
	String reservations(Model model) {
		model.addAttribute("reservations",this.reservationRepository.findAll());
		return "reservations";
	}
}



	
