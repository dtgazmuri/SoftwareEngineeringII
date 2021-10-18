
import junit.framework.Test;
import junit.framework.TestSuite;
import office.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({OfficeCounterTest.class, OfficeQueueTest.class, OfficeTest.class, TicketTest.class})
public class TestOfficeQueueManagement {

        public static void main(String[] args) {
            suite();
        }

        public static Test suite() {
            TestSuite suite = new TestSuite("EZShop Test");
            return suite;
        }


}
