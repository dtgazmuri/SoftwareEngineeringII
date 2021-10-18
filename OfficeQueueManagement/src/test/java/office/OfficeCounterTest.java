package office;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class OfficeCounterTest {

    private static final OfficeCounter counter = new OfficeCounter(1);

    @After
    public void tearDown() throws Exception {
        counter.getServiceTypeList().clear();
        counter.removeCurrentlyServedTicket();
    }

    @Test
    public void testSetCurrentlyServedTicket() {
        Ticket ticket = new Ticket(1, new ServiceType(1,"Accounting", 1.8));
        counter.setCurrentlyServedTicket(ticket);
        assertEquals(ticket, counter.getCurrentlyServedTicket());
    }

    @Test
    public void testRemoveCurrentlyServedTicket() {
        counter.removeCurrentlyServedTicket();
        assertNull(counter.getCurrentlyServedTicket());
    }

    @Test
    public void testIsServingTicket() {
        assertFalse(counter.isServingTicket());
        Ticket ticket = new Ticket(1, new ServiceType(1,"Accounting", 1.8));
        counter.setCurrentlyServedTicket(ticket);
        assertTrue(counter.isServingTicket());
    }

    @Test
    public void testAddServiceType() {
        ServiceType st = new ServiceType(2,"Bill Payment", 3.4);
        counter.addServiceType(st);
        assertEquals(st, counter.getServiceTypeById(2));
    }

    @Test
    public void testIsServicePresent() {
        assertFalse(counter.isServicePresent(10));
        ServiceType st = new ServiceType(2,"Bill Payment", 3.4);
        counter.addServiceType(st);
        assertTrue(counter.isServicePresent(2));
    }

    @Test
    public void testRemoveServiceType() {
        ServiceType st = new ServiceType(2,"Bill Payment", 3.4);
        counter.addServiceType(st);
        counter.removeServiceType(2);
        assertFalse(counter.isServicePresent(2));
    }
}