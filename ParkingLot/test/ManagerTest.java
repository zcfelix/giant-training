import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ManagerTest {

    @Test
    public void should_be_able_to_park_when_any_parking_lot_is_available() {
        WithParkingCapability empty = new ParkingLot(0);
        WithParkingCapability target = new ParkingLot(1);
        WithParkingCapability withParkingCapability = new Manager(empty, target);
        Car car = new Car();
        assertThat(withParkingCapability.park(car), is(true));
    }

    @Test
    public void should_not_be_able_to_park_when_all_parking_lots_are_unavailable() {
        WithParkingCapability empty1 = new ParkingLot(0);
        WithParkingCapability empty2 = new ParkingLot(0);
        WithParkingCapability withParkingCapability = new Manager(empty1, empty2);
        Car car = new Car();
        assertThat(withParkingCapability.park(car), is(false));
    }

    @Test
    public void should_be_able_to_unpark_after_parking() {
        WithParkingCapability withParkingCapability = new Manager(new ParkingLot(0), new ParkingLot(1));
        Car car = new Car();
        assertThat(withParkingCapability.park(car), is(true));
        assertThat(withParkingCapability.unpark(car), is(true));
    }

    @Test
    public void should_not_be_able_to_unpark_without_parking() {
        WithParkingCapability withParkingCapability = new Manager(new ParkingLot(0), new ParkingLot(1));
        Car car = new Car();
        assertThat(withParkingCapability.unpark(car), is(false));
    }

    @Test
    public void should_be_able_to_park_with_max_remaining_selector() {
        WithParkingCapability other = new ParkingLot(1);
        WithParkingCapability target = new ParkingLot(2);
        WithParkingCapability withParkingCapability = new Manager(new MaxRemainingSelector(), other, target);
        assertThat(withParkingCapability.park(new Car()), is(true));
    }
}
