import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MaxRemaingRatioSelector implements ParkingSelector {
    @Override
    public Optional<WithParkingCapability> selectParkingLot(List<WithParkingCapability> withParkingCapabilities) {
        return withParkingCapabilities.stream().sorted(Comparator.comparing((java.util.function.Function<WithParkingCapability, Double>) (parkingLot) -> parkingLot.get(((used, total) -> (total-used) * 1.0 / total))).reversed()).findFirst();
    }
}
