package Office;

import java.util.ArrayList;
import java.util.List;

public class OfficeCounter {
	
	private int counterId;								//The unique id of the counter
	private List<ServiceType> servedServiceTypes;		//The list containing all the service types a counter can serve
	
	private Ticket ticketCurrentlyServed;				//The ticket the counter is actually serving (initally it's equal to null)
	
	
	
	//I need functions that searches the service type, get the service type list and so on so that you can easily get the queue referred to that type
	//I need to check if the map in the office object can be accessed like map.get(ServiceType obj) and that works!
	
	
	/** The function creates a new OfficeCounter object.
	 *  
	 * @param id The unique id of the counter
	 */
	public OfficeCounter(int id) {
		this.counterId = id;
		
		//Set up the other two
		this.ticketCurrentlyServed = null;
		this.servedServiceTypes = new ArrayList<ServiceType>();
	}
	
	
	//### GETTER ###//
	
	public int getId() {
		return this.counterId;
	}
	
	
	//### MANAGE TICKET ###//
	
	public void setCurrentlyServedTicket(Ticket t) {
		this.ticketCurrentlyServed = t;
	}
	
	public Ticket getCurrentlyServedTicket() {
		return this.ticketCurrentlyServed;
	}
	
	/** This function sets the ticket Currently Served by this counter to the default value of null.
	 * 
	 */
	public void removeCurrentlyServedTicket() {
		this.setCurrentlyServedTicket(null);
	}
	
	
	//### SERVICE TYPES MANAGEMENT ###//
	
	public int getServiceTypeNumber() {
		return this.servedServiceTypes.size();
	}
	
	/** The function adds a new ServiceType to the counter.
	 * 
	 * @param t The ServiceType to be added at the counter
	 */
	public void addServiceType(ServiceType t) {
		this.servedServiceTypes.add(t);
	}
	
	/** This function returns the list of all ServiceTypes served by this counter.
	 * 
	 * @return The list of all ServiceTypes served by this counter
	 */
	public List<ServiceType> getServiceTypeList() {
		return this.servedServiceTypes;
	}
	
	
	/** The function returns if the counter can serve a ServiceType given its id.
	 * 
	 * @param serviceId The id of the ServiceType to search for
	 * @return true if a ServiceType with that id can be managed by this counter, false otherwise
	 */
	public boolean isServicePresent(int serviceId) {
		
		int i;
		for (i = 0; i < this.servedServiceTypes.size(); i++) {
			if (this.servedServiceTypes.get(i).getId() == serviceId) {
				return true;
			}
		}
		
		return false;
		
	}
	
	/** The function searches if a ServiceType with that id is managed by this counter. If it's founded, the ServiceType is returned.
	 * 
	 * @param serviceId The id of the ServiceType to search for 
	 * @return the ServiceType object with that id or null if not present
	 */
	public ServiceType getServiceTypeById(int serviceId) {
		int i;
		for (i = 0; i < this.servedServiceTypes.size(); i++) {
			if (this.servedServiceTypes.get(i).getId() == serviceId) {
				return this.servedServiceTypes.get(i);
			}
		}
		
		return null;
	}
	
	
	
	/** The function removes a service type from the counter given its id. If no service with that id is present, it returns false. Otherwise, it returns true.
	 * 
	 * @param serviceId The id of the ServiceType to remove
	 * @return true if a ServiceType with that name is removed, false otherwise
	 */
	public boolean removeServiceType(int serviceId) {
		
		int i;
		for (i = 0; i < this.servedServiceTypes.size(); i++) {
			if (this.servedServiceTypes.get(i).getId() == serviceId) {
				this.servedServiceTypes.remove(i);
				return true;
			}
		}
		
		return false;
		
	}
	
	
	//### OVERRIDE ###//
	
	@Override
	public String toString() {
		return "[OfficeCounter] : " + "(office counter id = " + this.counterId + ", currently served ticket object = " + this.getCurrentlyServedTicket() + ", list of ServiceType object it can manage = " + this.servedServiceTypes + ")";
	}
	
	
	
	
	
	
}
