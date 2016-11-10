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
        WithParkingCapability target = new ParkingLot(1);
        WithParkingCapability other = new ParkingLot(2);
        List<WithParkingCapability> withParkingCapabilities = Arrays.asList(target, other);

        WithParkingCapability selected = defaultSelector.selectParkingLot(withParkingCapabilities).get();
        assertThat(selected, is(target));
    }

    @Test
    public void should_default_selector_return_null_when_all_parking_lots_are_full() {
        ParkingSelector defaultSelector = new DefaultSelector();
        WithParkingCapability empty1 = new ParkingLot(0);
        WithParkingCapability empty2 = new ParkingLot(0);
        List<WithParkingCapability> withParkingCapabilities = Arrays.asList(empty1, empty2);

        Optional<WithParkingCapability> selected = defaultSelector.selectParkingLot(withParkingCapabilities);
        assertThat(selected.isPresent(), is(false));
    }

    @Test
    public void should_max_remaining_selector_return_max_remaining_capacity_parking_lot() {
        ParkingSelector defaultSelector = new MaxRemainingSelector();
        WithParkingCapability target = new ParkingLot(2);
        WithParkingCapability other = new ParkingLot(1);
        List<WithParkingCapability> withParkingCapabilities = Arrays.asList(other, target);

        WithParkingCapability selected = defaultSelector.selectParkingLot(withParkingCapabilities).get();
        assertThat(selected, is(target));
    }

    @Test
    public void should_max_remaining_ratio_selector_return_max_remaining_ratio_parking_lot() {
        ParkingSelector maxRemainingRatioSelector = new MaxRemaingRatioSelector();
        WithParkingCapability target = new ParkingLot(1);
        WithParkingCapability other = new ParkingLot(100);
        other.park(new Car());
        List<WithParkingCapability> withParkingCapabilities = Arrays.asList(other, target);

        WithParkingCapability selected = maxRemainingRatioSelector.selectParkingLot(withParkingCapabilities).get();
        assertThat(selected, is(target));
    }
}
