import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HighLevelManagerTest {
    @Test
    public void should_be_able_to_park_when_any_manager_is_available() {
        WithParkingCapability availableManager = new Manager(new ParkingLot(1), new ParkingLot(0));
        WithParkingCapability nonAvailableManager = new Manager(new ParkingLot(0), new ParkingLot(0));
        WithParkingCapability highLevelManager = new Manager(availableManager, nonAvailableManager);
        assertThat(highLevelManager.park(new Car()), is(true));
    }

    @Test
    public void should_not_be_able_to_park_when_all_managers_are_not_available() {
        WithParkingCapability availableManager = new Manager(new ParkingLot(0), new ParkingLot(0));
        WithParkingCapability nonAvailableManager = new Manager(new ParkingLot(0), new ParkingLot(0));
        WithParkingCapability highLevelManager = new Manager(availableManager, nonAvailableManager);
        assertThat(highLevelManager.park(new Car()), is(false));
    }

    @Test
    public void should_be_able_to_unpark_after_parking() {
        WithParkingCapability availableManager = new Manager(new ParkingLot(1), new ParkingLot(0));
        WithParkingCapability nonAvailableManager = new Manager(new ParkingLot(0), new ParkingLot(0));
        WithParkingCapability highLevelManager = new Manager(availableManager, nonAvailableManager);
        Car car = new Car();
        assertThat(highLevelManager.park(car), is(true));
        assertThat(highLevelManager.unpark(car), is(true));
    }

    @Test
    public void should_not_be_able_to_unpark_after_parking() {
        WithParkingCapability availableManager = new Manager(new ParkingLot(1), new ParkingLot(0));
        WithParkingCapability nonAvailableManager = new Manager(new ParkingLot(0), new ParkingLot(0));
        WithParkingCapability highLevelManager = new Manager(availableManager, nonAvailableManager);
        Car car = new Car();
        assertThat(highLevelManager.unpark(car), is(false));
    }

}
