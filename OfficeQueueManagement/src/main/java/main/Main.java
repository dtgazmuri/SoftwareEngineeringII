package main;

import office.*;

import java.util.List;

import gui.*;



public class Main {

	public static void main(String[] args) {
		
		//Initialize the Office Object
		Office o;
		o = new Office();
		o.initialize();
		
		//Print it for debug
		System.out.println(o.toString());
		
		//istanziate the gui
		Gui window = new Gui(o.getServiceTypeList(), o.getCounterList(), o);
		window.show();
		
		
		/*
		ServiceType st = o.getServiceTypeById(1);
		Ticket t = new Ticket(Office.CURRENT_TICKET_NUMBER, st);
		
		o.getQueueByServiceType(o.getServiceTypeById(1)).pushTicket(t);
		
		
		System.out.println(o.toString());
		
		System.out.println(o.getQueueByServiceType(o.getServiceTypeById(1)).popTicket());
		System.out.println(o.toString());
		
		Ticket b = o.getQueueByServiceType(o.getServiceTypeById(1)).popTicket();
		System.out.println(b);
		*/
		
		//Test ALL
		/*
		//Create the service types
		ServiceType st1 = new ServiceType(1, "Accounting", 5.4);
		ServiceType st2 = new ServiceType(2, "Delivery and Mailing", 10.1);
		ServiceType st3 = new ServiceType(3, "Money Withdrawal", 1.8);
		
		//Show them
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
		
		
		
		//Create the tickets
		Ticket t1 = new Ticket(34, st3);
		t1.setEstimatedWaitingTime(14.3);
		
		Ticket t2 = new Ticket(45, st1);
		Ticket t3 = new Ticket(55, st2);
		
		System.out.println(t1);
		System.out.println(t2);
		
		
		
		//Create the counter
		OfficeCounter c1 = new OfficeCounter(1);
		
		//Set the services
		System.out.println(c1);
		
		c1.addServiceType(st1);
		c1.addServiceType(st2);
		
		System.out.println(c1);
		
		//Check up the functions
		boolean flag;
		
		flag = c1.isServicePresent(1);
		System.out.println(flag);
		
		flag = c1.isServicePresent(13);
		System.out.println(flag);
		
		
		flag = c1.removeServiceType(1);
		System.out.println(flag);
		System.out.println(c1);
		
		
		System.out.println(c1.getServiceTypeList());
		
		c1.setCurrentlyServedTicket(t2);
		System.out.println(c1.getCurrentlyServedTicket().toString());
		
		
		
		
		//Test 2
		Office o1 = new Office();
		o1.initialize();
		
		//Get it
		ServiceType st = o1.getServiceTypeById(4);
		
		//Get the queues
		OfficeQueue oq = o1.getQueueByServiceType(st);
		oq.pushTicket(t2);
		oq.pushTicket(t1);
		oq.pushTicket(t3);
		
		System.out.println(oq.toString());
		
		//pop the tickets
		Ticket fistTicket = oq.popTicket();
		System.out.println(oq.toString());
		System.out.println(fistTicket.toString());
		
		//pop all
		
		while(oq.getQueueLength() > 0) {
			oq.popTicket();
		}
		
		
		System.out.println(oq.toString());
		
		
		//Testing!!
		System.out.println("ServiceType number : " + o.getServiceTypesNumber());
		System.out.println("Counter number : " + o.getCounterNumber());
		System.out.println("Queue number : " + o.getQueueNumber());
		
		//Test counters
		if (o.isCounterPresent(2)) {
			OfficeCounter c = o1.getCounterById(2);
			System.out.println("Counter fonded : " + c.toString());
		}
		else {
			System.out.println("Counter not fonded!");
		}
		
		
		
		System.out.println("");
		System.out.println(o.toString());
		*/
		
		
	}

}
