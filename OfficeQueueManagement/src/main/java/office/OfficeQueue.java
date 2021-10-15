package office;

import java.util.ArrayList;
import java.util.List;

public class OfficeQueue {
	
	private ServiceType queueServiceType;		//The service type associated with the queue
	private List<Ticket> ticketQueue;			//The list of all the tickets associated with the queue
	
	
	/** The function creates a new OfficeQueue object.
	 * 
	 * @param s The ServiceType associated with the queue
	 */
	public OfficeQueue(ServiceType s) {
		this.queueServiceType = s;
		
		//Initialize the queue
		this.ticketQueue = new ArrayList<Ticket>();
	}
	
	
	
	
	//### GETTER ###//
	
	public ServiceType getServiceType() {
		return this.queueServiceType;
	}
	
	//### SETTER ###//
	
	public void setServiceType(ServiceType s) {
		this.queueServiceType = s;
	}
	
	
	
	//### MANAGE THE QUEUE ###//
	
	/** The functions return the actual length of the queue.
	 * 
	 * @return The actual length of the queue
	 */
	public int getQueueLength() {
		return this.ticketQueue.size();
	}
	
	/** The function push a new ticket at the end of the queue.
	 * 
	 * @param t The ticket to be pushed
	 */
	public void pushTicket(Ticket t) {
		
		//Say warning
		if (t.getServiceType().compareTo(this.getServiceType()) != 0) {
			System.out.println("[OfficeQueue.pushTicket] : WARNING! THE SERVICE TYPE OF THE TICKET PUSHES IS NOT EQUAL TO THE SERVICE TYPE OF THE QUEUE!");
		}
		
		this.ticketQueue.add(t);
	}
	
	/** The function removes the first element of the list and returns it. 
	 * First that calling it, you SHOLUD check the queue length with the getQueueLength() function.
	 * 
	 * @return The ticket popped put the queue. If the queue is empty, it returns null
	 */
	public Ticket popTicket() {
		
		//Check the length
		if (this.getQueueLength() > 0) {
			
			//Get the first ticket from the array
			Ticket t;
			t = this.ticketQueue.get(0);
			
			//Remove it from the queue
			this.ticketQueue.remove(0);
			
			//Return it
			return t;
			
		}
		else {
			return null;
		}
	}
	
	
	
	//### OVERRIDES ###//
	
	@Override
	public String toString() {
		return "[OfficeQueue] : " + "(ServiceType object associated = " + this.queueServiceType.toString() + ", ticket queue = " + this.ticketQueue.toString() + ")";
	}
	
}
