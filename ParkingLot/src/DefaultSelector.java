import java.util.List;
import java.util.Optional;

public class DefaultSelector implements ParkingSelector {

    public DefaultSelector() {
    }

    @Override
    public Optional<WithParkingCapability> selectParkingLot(List<WithParkingCapability> withParkingCapabilities) {
        return withParkingCapabilities.stream().filter((parkingLot) -> parkingLot.get((a, b) -> b - a > 0)).findFirst();
    }
}
