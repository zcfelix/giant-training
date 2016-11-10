import java.util.List;
import java.util.Optional;

public class DefaultSelector implements ParkingSelector {

    public DefaultSelector() {
    }

    @Override
    public Optional<ParkingLot> selectParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().filter((parkingLot) -> parkingLot.get((a, b) -> b - a > 0)).findFirst();
    }
}
