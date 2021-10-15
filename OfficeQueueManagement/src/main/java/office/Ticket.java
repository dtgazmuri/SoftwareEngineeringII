package office;

public class Ticket {
	
	static final double BASE_ESTIMATED_TIME = 0.0;	//The base estimated time set in the constructor of the class
	
	private int ticketId;					//The unique id of the ticket (that's the ticket number basically)
	private double estimatedWaitingTime;	//The estimated waiting time printed on the ticket; It needs to be set later with the proper function
	private ServiceType ticketServiceType;	//The service type linked to the ticket
	
	/** The function creates a new Ticket object.
	 * 
	 * @param id The unique id of the ticket
	 * @param s The service type associated with the ticket
	 */
	public Ticket(int id, ServiceType s) {
		this.ticketId = id;
		this.ticketServiceType = s;
		
		this.estimatedWaitingTime = Ticket.BASE_ESTIMATED_TIME;
	}
	
	
	//### GETTER ###//
	
	public int getId() {
		return this.ticketId;
	}
	
	public ServiceType getServiceType() {
		return this.ticketServiceType;
	}
	
	public double getEstimatedWaitingTime() {
		return this.estimatedWaitingTime;
	}
	
	
	
	
	//### SETTER ###//
	
	public void setId(int id) {
		this.ticketId = id;
	}
	
	public void setServiceType(ServiceType s) {
		this.ticketServiceType = s;
	}
	
	/** The function set up the estimated waiting time of the ticket. Normally at the creation is set to the Ticket.BASE_ESTIMATED_TIME constant.
	 * 
	 * @param t The waiting time to be set
	 */
	public void setEstimatedWaitingTime(double t) {
		this.estimatedWaitingTime = t;
	}
	
	
	
	
	
	//### Overrides ###//
	
	@Override
	public String toString() {
		return "[Ticket] : (ticket id = " + this.ticketId + ", estimated waiting time = " + this.estimatedWaitingTime + ", ServiceType object associated = " + this.ticketServiceType.toString() + ")";
	}

}
