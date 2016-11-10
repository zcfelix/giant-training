import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingLotTest {

    @Test
    public void should_be_able_to_park_when_not_full() {
        WithParkingCapability parkingLot = new ParkingLot(1);
        Car car = new Car();
        assertThat(parkingLot.park(car), is(true));
        assertThat(parkingLot.get((u, t)-> t - u), is(0));
    }

    @Test
    public void should_not_be_able_to_park_when_full() {
        WithParkingCapability parkingLot = new ParkingLot(0);
        Car car = new Car();
        assertThat(parkingLot.park(car), is(false));
    }

    @Test
    public void should_be_able_to_unpark_after_parking() {
        WithParkingCapability parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);
        assertThat(parkingLot.get((u, t) -> t -u ), is(0));
        assertThat(parkingLot.unpark(car), is(true));
        assertThat(parkingLot.get((u, t) -> t - u), is(1));
    }

    @Test
    public void should_not_be_able_to_unpark_without_parking() {
        WithParkingCapability parkingLot = new ParkingLot(1);
        Car car = new Car();
        assertThat(parkingLot.unpark(car), is(false));
        assertThat(parkingLot.get((u, t) -> t - u), is(1));
    }

    @Test
    public void should_get_report_without_indent() {
        WithParkingCapability parkingLot = new ParkingLot(3);
        parkingLot.park(new Car());

        String expected = "ParkingLot: 2/3\n";
        String ret = parkingLot.report(new Report());

        System.out.println(ret);
        assertThat(ret, is(expected));
    }

}
