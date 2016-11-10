import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ManagerTest {

    @Test
    public void should_be_able_to_park_when_any_parking_lot_is_available() {
        ParkingLot empty = new ParkingLot(0);
        ParkingLot target = new ParkingLot(1);
        Manager manager = new Manager(empty, target);
        Car car = new Car();
        assertThat(manager.park(car), is(true));
        assertThat(target.remaningCapacity(), is(0));
    }

    @Test
    public void should_not_be_able_to_park_when_all_parking_lots_are_unavailable() {
        ParkingLot empty1 = new ParkingLot(0);
        ParkingLot empty2 = new ParkingLot(0);
        Manager manager = new Manager(empty1, empty2);
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

    @Test
    public void should_be_able_to_park_with_max_remaining_selector() throws Exception {
        ParkingLot other = new ParkingLot(1);
        ParkingLot target = new ParkingLot(2);
        Manager manager = new Manager(new MaxRemainingSelector(), other, target);
        assertThat(manager.park(new Car()), is(true));
        assertThat(target.remaningCapacity(), is(1));
    }
}
