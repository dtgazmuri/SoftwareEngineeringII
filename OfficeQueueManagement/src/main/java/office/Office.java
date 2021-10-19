package office;

import java.sql.SQLException;
import java.util.*;

import db.DBManager;

public class Office {
	
	public static int CURRENT_TICKET_NUMBER = 1;				//The static ticket number, it starts from 0 at the start of the program and then it will be increased every time a anew ticket is taken

	
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

	public Map<ServiceType, OfficeQueue> getQueueMap() {
		return queueMap;
	}


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
		this.serviceTypesList = dbManager.getServiceType();
		//2) Create the counters
		OfficeCounter c1 = new OfficeCounter(1);
		OfficeCounter c2 = new OfficeCounter(2);
		OfficeCounter c3 = new OfficeCounter(3);
		
		//3) Add them to the list
		this.addCounter(c1);
		this.addCounter(c2);
		this.addCounter(c3);
		
		//4) Set up the service types for the counters
		c1.addServiceType(serviceTypesList.get(1));
		c1.addServiceType(serviceTypesList.get(2));
		c1.addServiceType(serviceTypesList.get(0));
		
		c2.addServiceType(serviceTypesList.get(1));
		c2.addServiceType(serviceTypesList.get(3));
		
		c3.addServiceType(serviceTypesList.get(4));
		c3.addServiceType(serviceTypesList.get(2));
		
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



	/** returns the ticket number and the type of service of the next client for the specified counter.
	 * The next ticket to serve is selected with the following rule:
	 * select the first number from the longest queue among those corresponding to the service types the counter can offer.
	 * If two or more queues have the same length, the queue associated with request type having the lowest service time is selected.
	 *
	 * @param counterId The counter which is free at the moment
	 * @return The ticket to be served at this counter and null if the queues are empty
	 */
	public Ticket notifyThatCounterIsFree(int counterId) {
		OfficeCounter currentCounter = getCounterById(counterId);
		Ticket prevTicket = currentCounter.getCurrentlyServedTicket();

		if (prevTicket != null){
			try {
				dbManager.addTicket(prevTicket,counterId);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		currentCounter.removeCurrentlyServedTicket();

		Ticket t = null;
		List<ServiceType> counterServiceTypes = getCounterById(counterId).getServiceTypeList();
		ArrayList<OfficeQueue> selectedQueues = new ArrayList<>();
		int maxQueueLength = 1;

		for(ServiceType st: counterServiceTypes){
			if (getQueueByServiceType(st).getQueueLength() < maxQueueLength) continue;
			if (getQueueByServiceType(st).getQueueLength() > maxQueueLength){
				selectedQueues.clear();
			}
			// update max-length of queues
			selectedQueues.add(getQueueByServiceType(st));
			maxQueueLength = getQueueByServiceType(st).getQueueLength();
		}
		if(selectedQueues.size() == 1 ){
			t = selectedQueues.get(0).popTicket();
			currentCounter.setCurrentlyServedTicket(t);
			return t;
		}
		else if (selectedQueues.size() > 1 ){
			double minTime = Double.MAX_VALUE;
			Ticket selectedTicket = null;
			for (OfficeQueue q: selectedQueues){
				if( q.getServiceType().getTime() < minTime){
					minTime = q.getServiceType().getTime();
					selectedTicket = q.popTicket();
				}
			}
			currentCounter.setCurrentlyServedTicket(selectedTicket);
			return selectedTicket;
		}
		else return null;
	}
	

	
	public Ticket getNewTicket(ServiceType s) {
		System.out.println("Get Ticket: The service type is " + s.getName());
		int ticketNumber = CURRENT_TICKET_NUMBER;
		System.out.println("Get Ticket: Ticket number: " + CURRENT_TICKET_NUMBER);
		Ticket newTicket = new Ticket(ticketNumber, s);
		
		OfficeCounter selectedCounter = null;
		
		// This for loop checks if there is a free counter that can immediately serve the client with
		// this ticket
		
		for (int i = 0; i < getCounterNumber() ; i++ ) {
			if (getCounterList().get(i).isServicePresent(s.getId())) {
				if (getCounterList().get(i).getCurrentlyServedTicket() == null) {
					selectedCounter = getCounterList().get(i);
					break;
				}
				
			}
		}
		
		// If a free counter was found, the client is immediately served and the ticket doesn't enter
		// the queue. If no free counter is found, the ticket joins the corresponding queue.
		
		if (selectedCounter != null) {
			System.out.println("This ticket will be served right away in Counter " + selectedCounter.getId());
			selectedCounter.setCurrentlyServedTicket(newTicket);
		}
		else {
			System.out.println("All the counters that offer this service are currently busy, so the Ticket will join the queue");
			OfficeQueue queueToPushTo =  getQueueByServiceType(s); // Get queue of service type
			queueToPushTo.pushTicket(newTicket); // Push ticket to queue
		}
		
		CURRENT_TICKET_NUMBER += 1;
		
		return newTicket;
	}
	
	/** Add the latest served ticket to the database of tickets
	 * @param t the ticket;
	 * @param counter the counter who performs the action
	 *
	 * 
	 */
	public void addServedTicketToDB(Ticket t, int counter){
		
		try{
			dbManager.addTicket(t, counter);
		}
		catch(SQLException e){
			System.out.println(e);
		}
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
