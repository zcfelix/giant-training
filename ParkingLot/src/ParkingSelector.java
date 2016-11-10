import java.util.List;
import java.util.Optional;

public interface ParkingSelector {
    Optional<ParkingLot> selectParkingLot(List<ParkingLot> parkingLots);
}
