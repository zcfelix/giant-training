import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MaxRemainingSelector implements ParkingSelector {

    @Override
    public Optional<WithParkingCapability> selectParkingLot(List<WithParkingCapability> withParkingCapabilities) {
        return withParkingCapabilities.stream().sorted(Comparator.comparing((java.util.function.Function<WithParkingCapability, Integer>) (parkingLot) -> parkingLot.get(((used, total) -> total-used))).reversed()).findFirst();

    }
}
