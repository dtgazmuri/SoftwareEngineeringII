package office;

import org.junit.Test;

import static org.junit.Assert.*;

public class TicketTest {
    private static final Ticket ticket = new Ticket(1, new ServiceType(1,"Accounting", 1.8));

    @Test
    public void testSetId() {
        ticket.setId(2);
        assertEquals(2, ticket.getId());
    }

    @Test
    public void testSetServiceType() {
        ServiceType st = new ServiceType(2,"Bill Payment", 3.4);
        ticket.setServiceType(st);
        assertEquals(st, ticket.getServiceType());
    }

    @Test
    public void testSetEstimatedWaitingTime() {
        ticket.setEstimatedWaitingTime(7.9);
        assertEquals(7.9, ticket.getEstimatedWaitingTime(), 1);
    }
}