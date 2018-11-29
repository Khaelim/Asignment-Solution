package ie.lyit.flight;

import java.util.ArrayList;

public class Booking 
{
	private Flight outbound;
	private Flight inbound;
	private ArrayList<Passenger> passengers;
	private double totalPrice;
	private static int count = 0;
	
	public Booking() 
	{
		outbound = null;
		inbound = null;
		passengers = null;
		count =++count;
		this.totalPrice = calculatePrice();
	}
	public Booking(Flight outbound, Flight inbound, ArrayList<Passenger> passengers) 
	{
		this.outbound = outbound;
		this.inbound = inbound;
		this.passengers = passengers;
		this.count =++count;
		this.totalPrice = calculatePrice();
	}
	public boolean findPassenger(Passenger passenger) 
	{
		for(Passenger p:passengers) 
		{
			if(p.equals(passenger))
				return true;
		}
		return false;
	}
	public double calculatePrice() 
	{
		return ((outbound.getPrice()+inbound.getPrice())*passengers.size());
	}
	//setters
	public void setOutbound(Flight outbound) 
	{
		this.outbound=outbound;
	}
	public void setInbound(Flight inbound) 
	{
		this.inbound=inbound;
	}
	public void setPassengers(ArrayList<Passenger> passengers) 
	{
		this.passengers=passengers;
	}
	public void setTotalPrice() 
	{
		totalPrice=calculatePrice() ;
	}
	//getters
	public Flight getOutbound() 
	{
		return outbound;
	}
	public Flight getInbound() 
	{
		return inbound;
	}
	public ArrayList<Passenger> getPassengers() 
	{
		return passengers;
	}
	public double getTotalPrice() 
	{
		return calculatePrice();
	}
	
	public boolean equals(Object obj)
	{
		Booking bObject;
	   	if (obj instanceof Booking)
	   		bObject = (Booking)obj;
	   	else
	   		return false;

	   return this.outbound.equals(bObject.outbound) &&
              this.inbound.equals(bObject.inbound) &&
		      this.passengers.equals(bObject.passengers) &&							
		      this.totalPrice==bObject.totalPrice &&
		      this.count==bObject.count;							
	}
	public String toString()
	{
		return "Outbound flight: "+outbound.toString()+". Inbound flight: "+inbound.toString()+". "+passengers.size()+" passengers. Total price: "+totalPrice;      
	}
	
}
