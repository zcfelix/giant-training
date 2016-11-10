import java.util.List;
import java.util.Optional;

public class MaxRemainingSelector implements ParkingSelector {

    @Override
    public Optional<ParkingLot> selectParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().sorted((a, b) -> a.remaningCapacity() > b.remaningCapacity() ? -1 : 1).findFirst();
    }
}
