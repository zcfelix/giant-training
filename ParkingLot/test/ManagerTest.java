import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ManagerTest {
    @Test
    public void should_be_able_to_park_when_any_parking_lot_is_available() {
        Manager manager = new Manager(new ParkingLot(0), new ParkingLot(1));
        Car car = new Car();
        assertThat(manager.park(car), is(true));
    }

    @Test
    public void should_not_be_able_to_park_when_all_parking_lots_are_unavailable() {
        Manager manager = new Manager(new ParkingLot(0), new ParkingLot(0));
        Car car = new Car();
        assertThat(manager.park(car), is(false));
    }

    @Test
    public void should_be_able_to_unpark_after_parking() {
        Manager manager = new Manager(new ParkingLot(0), new ParkingLot(1));
        Car car = new Car();
        assertThat(manager.park(car), is(true));
        assertThat(manager.unpark(car), is(true));
    }

    @Test
    public void should_not_be_able_to_unpark_without_parking() {
        Manager manager = new Manager(new ParkingLot(0), new ParkingLot(1));
        Car car = new Car();
        assertThat(manager.unpark(car), is(false));
    }
}
