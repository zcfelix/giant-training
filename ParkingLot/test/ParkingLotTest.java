import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingLotTest {

    @Test
    public void should_be_able_to_park_when_not_full() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        assertThat(parkingLot.park(car), is(true));
    }

    @Test
    public void should_not_be_able_to_park_when_full() {
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car();
        assertThat(parkingLot.park(car), is(false));
    }

    @Test
    public void should_be_able_to_unpark_after_parking() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);
        assertThat(parkingLot.unpark(car), is(true));
    }

    @Test
    public void should_not_be_able_to_unpark_without_parking() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        assertThat(parkingLot.unpark(car), is(false));
    }
}
