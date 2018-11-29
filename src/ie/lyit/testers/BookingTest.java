package ie.lyit.testers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ie.lyit.flight.Booking;
import ie.lyit.flight.Flight;
import ie.lyit.flight.Passenger;
//https://www.baeldung.com/junit-assertions
public class BookingTest {
	private Flight f1=new Flight("BR215","Derry", "Stanstead", 25, 12, 2018, 12, 40, 16.99); 
	private Flight f2=new Flight("BR521","Stanstead", "Derry", 31, 12, 2018, 11, 45, 26.99);
	private Flight f3=new Flight("BR735","Belfast", "Gatwick", 5, 12, 2018, 12, 40, 20.99); 
	private Flight f4=new Flight("BR156","Gatwick", "Derry", 1, 1, 2019, 11, 45, 32.99);
	private Passenger p1=new Passenger("Mr", "Joe", "Doe", 25, 12, 1985, 2, true);
	private Passenger p2=new Passenger("Mrs", "Joeleen", "Doeleen", 12, 4, 1989, 1, false);
	private Passenger p3=new Passenger("Mr", "Loedeen", "Loejeen", 12, 2, 1988, 2, false);
	private ArrayList<Passenger> pp= new ArrayList<Passenger>();
	private ArrayList<Passenger> pp2= new ArrayList<Passenger>();
	private Booking b1;
	private Booking b2;
	@Before
	public void setUp() throws Exception {
		//ArrayList<Passenger> pp = null;
		pp.add(p1);
		pp2.add(p1);
		pp.add(p2);
		pp2.add(p2);
		pp2.add(p3);
		b1 = new Booking(f1,f2,pp);
		
		b2 = new Booking(f1,f2,pp2);
	}

	@Test
	public void testBookingFlightFlightArrayListOfPassenger() {
		//fail("Not yet implemented");
//		b1 = new Booking(f1,f2,pp);
//		b2 = new Booking(f1,f2,pp);
		b1 = new Booking(f1,f2,pp);
		assertNotSame(b1, b2);
		b1=b2;
		assertSame(b1, b2);
		b1 = new Booking(f1,f2,pp2);
		assertNotSame(b1, b2);
	}

	@Test
	public void testFindPassenger() {
		//fail("Not yet implemented");
		//assertNotSame(pp.get(0), pp.get(1));
		assertTrue(b1.findPassenger(p1));
		assertTrue(b1.findPassenger(p2));
		assertFalse(b1.findPassenger(p3));
		assertTrue(b2.findPassenger(p3));

	}

	@Test
	public void testCalculatePrice() {
		//fail("Not yet implemented");
		//System.out.print(b2.calculatePrice());
		assertTrue(b1.calculatePrice()==87.96);
		assertFalse(b1.calculatePrice()==131.94);
		assertTrue(b2.calculatePrice()==131.94);
		assertFalse(b2.calculatePrice()==87.86);
	}

	@Test
	public void testSetOutbound() {
		//fail("Not yet implemented");
		assertTrue(b1.getOutbound()==f1);
		assertFalse(b1.getOutbound()==f3);
		b1.setOutbound(f3);
		assertTrue(b1.getOutbound()==f3);
	}

	@Test
	public void testSetInbound() {
		//fail("Not yet implemented");
		assertTrue(b1.getInbound()==f2);
		assertFalse(b1.getInbound()==f4);
		b1.setInbound(f4);
		assertTrue(b1.getInbound()==f4);
	}

	@Test
	public void testSetPassengers() {
		//fail("Not yet implemented");
		assertTrue(b1.getPassengers()==pp);
		assertFalse(b1.getPassengers()==pp2);
		b1.setPassengers(pp2);
		assertFalse(b1.getPassengers()==pp);
		assertTrue(b1.getPassengers()==pp2);
	}

	@Test
	public void testSetTotalPrice() {
		//fail("Not yet implemented");
		assertTrue(b1.calculatePrice()==87.96);
		b1.setPassengers(pp2);
		b1.setTotalPrice();
		assertTrue(b1.calculatePrice()==131.94);
	}

	@Test
	public void testToString() {
		//fail("Not yet implemented");
		assertTrue(b1.toString().equals("Outbound flight: FLIGHT BR215 ==> Derry to Stanstead 25/12/2018 12:40 hours. Inbound flight: FLIGHT BR521 ==> Stanstead to Derry 31/12/2018 11:45 hours. 2 passengers. Total price: 87.96"));
		assertFalse(b1.toString().equals("Outbound flight: FLIGHT BR215 ==> Derry to Stanstead 25/12/2018 12:40 hours. Inbound flight: FLIGHT BR521 ==> Stanstead to Derry 31/12/2018 11:45 hours. 3 passengers. Total price: 131.94"));
		assertFalse(b2.toString().equals("Outbound flight: FLIGHT BR215 ==> Derry to Stanstead 25/12/2018 12:40 hours. Inbound flight: FLIGHT BR521 ==> Stanstead to Derry 31/12/2018 11:45 hours. 2 passengers. Total price: 87.96"));
		assertTrue(b2.toString().equals("Outbound flight: FLIGHT BR215 ==> Derry to Stanstead 25/12/2018 12:40 hours. Inbound flight: FLIGHT BR521 ==> Stanstead to Derry 31/12/2018 11:45 hours. 3 passengers. Total price: 131.94"));
	}

}
