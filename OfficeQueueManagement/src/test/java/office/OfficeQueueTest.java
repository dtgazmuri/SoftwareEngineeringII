package office;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class OfficeQueueTest {
    private static final OfficeQueue officeQueue = new OfficeQueue(new ServiceType(1,"Accounting", 1.8));

    @After
    public void tearDown() throws Exception {
        officeQueue.getTicketQueue().clear();
    }

    @Test
    public void testSetServiceType() {
        ServiceType st = new ServiceType(1,"Bill Payment", 3.4);
        officeQueue.setServiceType(st);
        assertEquals(st, officeQueue.getServiceType());
    }

    @Test
    public void testPushTicket() {
        Ticket ticket = new Ticket(1, new ServiceType(1,"Accounting", 1.8));
        officeQueue.pushTicket(ticket);
        assertEquals(ticket, officeQueue.getTicketQueue().get(0));
    }

    @Test
    public void testPopTicket() {
        Ticket ticket = new Ticket(1, new ServiceType(1,"Accounting", 1.8));
        officeQueue.pushTicket(ticket);
        assertEquals(ticket, officeQueue.popTicket());
    }
}