package office;

import static org.junit.Assert.*;

public class OfficeTest {
    static Office o;

    @org.junit.Before
    public void setUp() throws Exception {
        //Initialize the Office Object

        o = new Office();
        o.initialize();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void notifyThatCounterIsFree() {
        assertNull("there is no client in the queue", o.notifyThatCounterIsFree(3));

        o.getQueueMap().get(o.getServiceTypeList().get(3)).pushTicket(new Ticket(10,o.getServiceTypeList().get(3)));
        o.getQueueMap().get(o.getServiceTypeList().get(3)).pushTicket(new Ticket(20,o.getServiceTypeList().get(3)));
        o.getQueueMap().get(o.getServiceTypeList().get(3)).pushTicket(new Ticket(30,o.getServiceTypeList().get(3)));

        o.getQueueMap().get(o.getServiceTypeList().get(1)).pushTicket(new Ticket(15,o.getServiceTypeList().get(1)));
        o.getQueueMap().get(o.getServiceTypeList().get(1)).pushTicket(new Ticket(5,o.getServiceTypeList().get(1)));

        assertTrue("the first ticket from the longest queue is selected",
                o.notifyThatCounterIsFree(3).getId() == 10);

        o.getQueueMap().get(o.getServiceTypeList().get(3)).pushTicket(new Ticket(10,o.getServiceTypeList().get(3)));
        o.getQueueMap().get(o.getServiceTypeList().get(3)).pushTicket(new Ticket(20,o.getServiceTypeList().get(3)));

        o.getQueueMap().get(o.getServiceTypeList().get(1)).pushTicket(new Ticket(15,o.getServiceTypeList().get(1)));
        o.getQueueMap().get(o.getServiceTypeList().get(1)).pushTicket(new Ticket(5,o.getServiceTypeList().get(1)));

        assertTrue(", the queue associated with request type having the lowest service time is selected",
                o.notifyThatCounterIsFree(3).getId() == 10);

    }
}