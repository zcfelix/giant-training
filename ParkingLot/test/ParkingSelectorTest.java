import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingSelectorTest {

    @Test
    public void should_default_selector_return_first_nonempty_lot() {
        ParkingSelector defaultSelector = new DefaultSelector();
        ParkingLot target = new ParkingLot(1);
        ParkingLot other = new ParkingLot(2);
        List<ParkingLot> parkingLots = Arrays.asList(target, other);

        ParkingLot selected = defaultSelector.selectParkingLot(parkingLots).get();
        assertThat(selected, is(target));
    }

    @Test
    public void should_default_selector_return_null_when_all_parking_lots_are_full() {
        ParkingSelector defaultSelector = new DefaultSelector();
        ParkingLot empty1 = new ParkingLot(0);
        ParkingLot empty2 = new ParkingLot(0);
        List<ParkingLot> parkingLots = Arrays.asList(empty1, empty2);

        Optional<ParkingLot> selected = defaultSelector.selectParkingLot(parkingLots);
        assertThat(selected.isPresent(), is(false));
    }

    @Test
    public void should_max_remaining_selector_return_max_remaining_capacity_parking_lot() {
        ParkingSelector defaultSelector = new MaxRemainingSelector();
        ParkingLot target = new ParkingLot(2);
        ParkingLot other = new ParkingLot(1);
        List<ParkingLot> parkingLots = Arrays.asList(other, target);

        ParkingLot selected = defaultSelector.selectParkingLot(parkingLots).get();
        assertThat(selected, is(target));
    }
}
