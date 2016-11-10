import java.util.List;
import java.util.Optional;

public interface ParkingSelector {
    Optional<WithParkingCapability> selectParkingLot(List<WithParkingCapability> withParkingCapabilities);
}
