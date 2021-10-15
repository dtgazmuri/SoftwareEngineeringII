package gui;

//java generic imports
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.*;

//custom classes imports
import office.OfficeCounter;
import office.ServiceType;
import office.Ticket;


public class Gui {
	private List<ServiceType> serviceList;
	private List<OfficeCounter> counterList;
	private JFrame frame;
	private String[] serviceNames;
	private String selectedServiceName;
	private final int FRAME_WIDTH = 1280;
	private final int FRAME_HEIGHT = 720;
	
	
	public Gui (List<ServiceType> services, List<OfficeCounter> counterList) {
		this.serviceList = services;
		this.frame = new JFrame("OfficeQueueManager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        //creating a tabbed pane for customer, officers and manager
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        
        //right panel, with the screen having information for clients
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(FRAME_WIDTH*2/5, FRAME_HEIGHT));;

        //getting the serviceNames from the List<ServiceTypes>
        serviceNames = new String[services.size()];
        int i = 0;
        for(ServiceType tmp : services) {
        	serviceNames[i] = tmp.getName();
        	i++;
        }
        
        //CUSTOMER VIEW
        JPanel customerPanel = new JPanel();
        JLabel serviceLabel = new JLabel("Select the desired type of service: ");
        customerPanel.add(serviceLabel);
        JComboBox serviceTypeSelection = new JComboBox(serviceNames);
        customerPanel.add(serviceTypeSelection);
        
        //GET A TICKET BUTTON
        JButton pickTicket = new JButton("Get a ticket for the selected type of service");
        
        //action listener for getting a ticket
        ActionListener actionListener = new ActionListener() {
        	 public void actionPerformed(ActionEvent actionEvent) {
        		 System.out.println(serviceTypeSelection.getSelectedItem());
        	 }
    	 };
        pickTicket.addActionListener(actionListener);
        customerPanel.add(pickTicket);
         
        
        
        //OFFICER VIEW
        JPanel officerPanel = new JPanel(new GridLayout(counterList.size(), 1, 0, 10));
        for (OfficeCounter tmp : counterList) {
        	JPanel singleCounter = new JPanel(new GridLayout(1, 2, 10, 0));
        	JLabel counterName = new JLabel("Counter "+tmp.getId());
        	singleCounter.add(counterName);
        	JPanel ticketAndDone = new JPanel(new GridLayout(2, 1, 0, 10));
        	JLabel ticket;
        	if(tmp.getCurrentlyServedTicket() != null)
        		ticket = new JLabel("Ticket being served: "+tmp.getCurrentlyServedTicket().getId());
        	else 
        		ticket = new JLabel("Ticket being served: free");
        	JButton done = new JButton("Done");
        	ticketAndDone.add(ticket);
        	ticketAndDone.add(done);
        	singleCounter.add(ticketAndDone);
        	officerPanel.add(singleCounter);
        }
        
        
        
        
        
        //OTHER VIEWS (Officer, Manager)
        JTextArea jt3 = new JTextArea("Manager view is still in development, sorry");

        tabbedPane.addTab("Customer", null, customerPanel, "See the customer view");
        tabbedPane.addTab("Officer", null, officerPanel, "See the officer view");
        tabbedPane.addTab("Manager", null, jt3, "See the manager view");
        
        
        

        
        
        //Right screen with the information on tickets currently served
        System.out.println(counterList.size()+2);
        JPanel display = new JPanel(new GridLayout(counterList.size()+2, 1, 0, 10));
    	JLabel label = new JLabel("Counters info");
    	display.add(label);
    	label = new JLabel("Which is the last ticket picked from queue?");
    	display.add(label);
    	
        //creating a label for each counter
        for(OfficeCounter tmp : counterList) {
        	if(tmp.getCurrentlyServedTicket() != null)
        		label = new JLabel("Counter "+tmp.getId()+" is serving ticket number "+tmp.getCurrentlyServedTicket().getId());
        	else 
        		label = new JLabel("Counter "+tmp.getId()+" isn't serving any ticket");
        	display.add(label);
        }
        rightPanel.add(display);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.CENTER, tabbedPane);
        frame.getContentPane().add(BorderLayout.EAST, rightPanel);
     	}

	public void show() {
        frame.setVisible(true);		
	}

}
