package Office;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import DB.DBManager;

public class Office {
	
	public static final int CURRENT_TICKET_NUMBER = 1;				//The static ticket number, it starts from 0 at the start of the program and then it will be increased every time a anew ticket is taken

	
	private List<OfficeCounter> counterList;				//The list of counters present in the office
	private List<ServiceType> serviceTypesList;				//The list of all the service types served in the office
	
	private Map<ServiceType, OfficeQueue> queueMap; 		//The map with all the ticket queues
	
	private DBManager dbManager;							//The object that manages the DB (empty for now)
	
	
	/** The function creates a new Office object.
	 * 
	 */
	public Office() {
		//Initialize all
		this.counterList = new ArrayList<OfficeCounter>();
		this.serviceTypesList = new ArrayList<ServiceType>();
		
		this.queueMap = new TreeMap<ServiceType, OfficeQueue>();
		
		
		//Create also the DBManager object (for now it do nothing)
		this.dbManager = new DBManager();
	}
	
	
	//### GET SIZES ###//
	
	/** The function returns the number of counters in the office.
	 * 
	 * @return the number of counters in the office object
	 */
	public int getCounterNumber() {
		return this.counterList.size();
	}
	
	/** The function returns the number of service types in the office.
	 * 
	 * @return the number of service types in the office object
	 */
	public int getServiceTypesNumber() {
		return this.serviceTypesList.size();
	}
	
	/** The function returns the number of queues in the office (it should be the same as the ServiceTypesNumber()).
	 * 
	 * @return the number of queues in the office object
	 */
	public int getQueueNumber() {
		return this.queueMap.keySet().size();
	}
	
	
	//### GETTERS ###//
	
	
	//COUNTERS
	
	public List<OfficeCounter> getCounterList(){
		return this.counterList;
	}
	
	/** The function returns the OfficeCounter with the given id.
	 * 
	 * @param id The id of the OfficeCounter to search for
	 * @return the OfficeCounter object with that id or null if it is not present
	 */
	public OfficeCounter getCounterById(int id) {
		
		int i;
		for (i = 0; i < this.getCounterNumber(); i++) {
			if (this.counterList.get(i).getId() == id) {
				return this.counterList.get(i);
			}
		}
		
		return null;
		
	}
	
	/** The function checks if a counter with the given id is present in this office.
	 * 
	 * @param id The id of the counter to search for
	 * @return True if the counter is present, false otherwise
	 */
	public boolean isCounterPresent(int id) {
		int i;
		for (i = 0; i < this.getCounterNumber(); i++) {
			if (this.counterList.get(i).getId() == id) {
				return true;
			}
		}
		
		return false;
	}
	
	
	//SERVICE TYPES
	
	public List<ServiceType> getServiceTypeList(){
		return this.serviceTypesList;
	}
	
	/** The function returns the ServiceType with the given id.
	 * 
	 * @param id The id of the ServiceType to search for
	 * @return the ServiceType object with that id or null if it is not present
	 */
	public ServiceType getServiceTypeById(int id) {
		
		int i;
		for (i = 0; i < this.getServiceTypesNumber(); i++) {
			if (this.serviceTypesList.get(i).getId() == id) {
				return this.serviceTypesList.get(i);
			}
		}
		
		return null;
		
	}
	
	/** The function checks if a ServiceType with the given id is present in this office.
	 * 
	 * @param id The id of the ServiceType to search for
	 * @return True if the ServiceType is present, false otherwise
	 */
	public boolean isServiceTypePresent(int id) {
		int i;
		for (i = 0; i < this.getServiceTypesNumber(); i++) {
			if (this.serviceTypesList.get(i).getId() == id) {
				return true;
			}
		}
		
		return false;
	}
	
	
	//QUEUES
	
	/** The function returns the queue associated with the given ServiceType. To obtain the ServiceType from its id, please use the getServiceTypeById(int id) function.
	 * 
	 * @param s The ServiceType to search for
	 * @return The OfficeQueue associated with that service, or null if it is not present
	 */
	public OfficeQueue getQueueByServiceType(ServiceType s) {
		return this.queueMap.get(s);
	}
	
	/** The function returns the complete list of all the queue in the office.
	 * 
	 * @return A list of all the OfficeQueue objects
	 */
	public List<OfficeQueue> getQueueList(){
		
		//Create the list
		List<OfficeQueue> list = new ArrayList<OfficeQueue>(this.queueMap.values());
		
		//Return it
		return list;
		
	}
	
	
	
	//### SETTERS ###//
	
	public void addServiceType(ServiceType s) {
		this.serviceTypesList.add(s);
	}
	
	public void addCounter(OfficeCounter c) {
		this.counterList.add(c);
	}
	
	public void addQueue(OfficeQueue o) {
		this.queueMap.put(o.getServiceType(), o);
	}
	
	
	//### INITIALIZE ###//
	
	/** The function initialize the Office object, creating the queues and the counters; and (this part need to be added) set up the connection with the DB through the DBManager object.
	 * 
	 */
	public void initialize() {
		
		//Create all
		
		//0) Create the Service Types
		ServiceType st1 = new ServiceType(1, "Accounting", 5.4);
		ServiceType st2 = new ServiceType(2, "Delivery and Mailing", 10.1);
		ServiceType st3 = new ServiceType(3, "Money Withdrawal", 1.8);
		ServiceType st4 = new ServiceType(4, "Bill Payment", 8.3);
		ServiceType st5 = new ServiceType(5, "Service Complaints", 120.0);
		
		//1) Add them to the list
		this.addServiceType(st1);
		this.addServiceType(st2);
		this.addServiceType(st3);
		this.addServiceType(st4);
		this.addServiceType(st5);
		
		//2) Create the counters
		OfficeCounter c1 = new OfficeCounter(1);
		OfficeCounter c2 = new OfficeCounter(2);
		OfficeCounter c3 = new OfficeCounter(3);
		
		//3) Add them to the list
		this.addCounter(c1);
		this.addCounter(c2);
		this.addCounter(c3);
		
		//4) Set up the service types for the counters
		c1.addServiceType(st1);
		c1.addServiceType(st2);
		
		c2.addServiceType(st1);
		c2.addServiceType(st3);
		
		c3.addServiceType(st4);
		c3.addServiceType(st5);
		c3.addServiceType(st2);
		
		//5) Create the queues
		for (ServiceType st : this.getServiceTypeList()) {
			
			//Create the queue
			OfficeQueue oq = new OfficeQueue(st);
			
			//Add it to the map
			this.addQueue(oq);
		}
		
		//6) Return
		return;
		
	}
	
	
	
	
	
	
	
	//### TO DO ###//
	
	public Ticket getNewTicket() {
		return null;
	}
	
	public void notifyThatCounterIsFree(int counterId) {
		return;
	}
	
	
	
	
	
	
	//### OVERRIDES ###//
	@Override
	public String toString() {
		String s;
		
		s = "Office Content : " + System.lineSeparator();
		
		
		s += "\tService Types (" + this.getServiceTypesNumber() + ") : " + System.lineSeparator();
		
		for (ServiceType st : this.getServiceTypeList()) {
			s += "\t\t" + st.toString() + System.lineSeparator();
		}
		
		
		s += "\tCounters (" + this.getCounterNumber() + ") : " + System.lineSeparator();
		
		for (OfficeCounter oc : this.getCounterList()) {
			s += "\t\t" + oc.toString() + System.lineSeparator();
		}
		
		
		s += "\tQueues (" + this.getQueueNumber() + ") : " + System.lineSeparator();
		
		for (OfficeQueue oq : this.getQueueList()) {
			s += "\t\t" + oq.toString() + System.lineSeparator();
		}
		
		return s;
	}
	
	
	
	
	
	
}
