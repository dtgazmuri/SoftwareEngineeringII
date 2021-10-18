package office;

import org.junit.Test;

import static org.junit.Assert.*;

public class OfficeTest {
    private static Office o;

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
    public void testNotifyThatCounterIsFree() {
        assertNull("there is no client in the queue", o.notifyThatCounterIsFree(3));

        o.getQueueMap().get(o.getServiceTypeList().get(3)).pushTicket(new Ticket(10,o.getServiceTypeList().get(3)));
        o.getQueueMap().get(o.getServiceTypeList().get(3)).pushTicket(new Ticket(20,o.getServiceTypeList().get(3)));
        o.getQueueMap().get(o.getServiceTypeList().get(3)).pushTicket(new Ticket(30,o.getServiceTypeList().get(3)));

        o.getQueueMap().get(o.getServiceTypeList().get(1)).pushTicket(new Ticket(15,o.getServiceTypeList().get(1)));
        o.getQueueMap().get(o.getServiceTypeList().get(1)).pushTicket(new Ticket(5,o.getServiceTypeList().get(1)));

        assertTrue("the first ticket from the longest queue is selected",
                o.notifyThatCounterIsFree(2).getId() == 10);
        o.initialize();

        o.getQueueMap().get(o.getServiceTypeList().get(3)).pushTicket(new Ticket(10,o.getServiceTypeList().get(3)));
        o.getQueueMap().get(o.getServiceTypeList().get(3)).pushTicket(new Ticket(20,o.getServiceTypeList().get(3)));

        o.getQueueMap().get(o.getServiceTypeList().get(1)).pushTicket(new Ticket(15,o.getServiceTypeList().get(1)));
        o.getQueueMap().get(o.getServiceTypeList().get(1)).pushTicket(new Ticket(5,o.getServiceTypeList().get(1)));

        assertTrue(", the queue associated with request type having the lowest service time is selected",
                o.notifyThatCounterIsFree(2).getId() == 10);

    }

    @Test
    public void testIsCounterPresent() {
        assertFalse(o.isCounterPresent(4));
        OfficeCounter counter = new OfficeCounter(4);
        o.addCounter(counter);
        assertTrue(o.isCounterPresent(4));
    }

    @Test
    public void testIsServiceTypePresent() {
        assertFalse(o.isServiceTypePresent(6));
        ServiceType st = new ServiceType(6,"Bill Payment", 3.4);
        o.addServiceType(st);
        assertTrue(o.isServiceTypePresent(6));
    }

    @Test
    public void testAddServiceType() {
        ServiceType st = new ServiceType(7,"Bill Payment", 3.4);
        o.addServiceType(st);
        assertTrue(o.isServiceTypePresent(7));
    }

    @Test
    public void testAddCounter() {
        OfficeCounter counter = new OfficeCounter(4);
        o.addCounter(counter);
        assertTrue(o.isCounterPresent(4));
    }

    @Test
    public void testAddQueue() {
        OfficeQueue officeQueue = new OfficeQueue(new ServiceType(8,"Accounting", 1.8));
        o.addQueue(officeQueue);
        assertTrue(o.getQueueMap().containsValue(officeQueue));
    }

    @Test
    public void testGetNewTicket() {
        ServiceType st = new ServiceType(2,"Bill Payment", 3.4);
        assertEquals(1 ,o.getNewTicket(st).getId());
        assertEquals(2 ,o.getNewTicket(st).getId());
        assertEquals("All the counters that offer this service are currently busy, so the Ticket will join the queue",
                3 ,o.getNewTicket(st).getId());

    }
}