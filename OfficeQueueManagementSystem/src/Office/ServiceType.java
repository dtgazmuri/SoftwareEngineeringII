package Office;

public class ServiceType implements Comparable<ServiceType> {
	
	private int serviceId;			//The numeric id of the service
	private String serviceName;		//The name of the service
	private double serviceTime;		//The service time associated with the service type
	
	/** The function creates a new ServiceType object.
	 * 
	 * @param id The unique id of the service
	 * @param name The name of the service
	 * @param time The service time associated with the service
	 */
	public ServiceType(int id, String name, double time) {
		this.serviceId = id;
		this.serviceName = name;
		this.serviceTime = time;
	}
	
	
	
	//### GETTER ###//
	
	public int getId() {
		return this.serviceId;
	}
	
	public String getName() {
		return this.serviceName;
	}
	
	public double getTime() {
		return this.serviceTime;
	}
	
	
	
	//### Overrides ###//
	
	@Override
	public String toString() {
		return "[ServiceType] : (serviceId = " + this.serviceId + ", serviceName = " + this.serviceName + ", service time = " + this.serviceTime + ")";
	}

	@Override
	public int compareTo(ServiceType o) {
		return this.serviceId - o.serviceId;
	}
	
}
