import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager implements WithParkingCapability {
    private List<WithParkingCapability> withParkingCapabilities;
    private ParkingSelector parkingSelector;

    public Manager(WithParkingCapability... lots) {
        withParkingCapabilities = new ArrayList<>();
        withParkingCapabilities = Arrays.asList(lots);
        parkingSelector = new DefaultSelector();
    }

    public Manager(ParkingSelector selector, WithParkingCapability... lots) {
        withParkingCapabilities = new ArrayList<>();
        withParkingCapabilities = Arrays.asList(lots);
        parkingSelector = selector;
    }

    public boolean park(Car car) {
        return parkingSelector.selectParkingLot(withParkingCapabilities).map(parkingLot -> parkingLot.park(car)).orElse(false);
    }

    public boolean unpark(Car car) {
        return withParkingCapabilities.stream().map(parkingLot -> parkingLot.unpark(car)).anyMatch(b -> b);
    }

    @Override
    public <T> T get(ParkingLot.Usage<T> usage) {
        int total = 0;
        int used = 0;
        for (WithParkingCapability w : withParkingCapabilities) {
            total += w.get((u, t) -> t);
            used += w.get((u, t) -> u);
        }
        return usage.get(used, total);
    }

    @Override
    public String report(Report report) {
        return report.managerReport(withParkingCapabilities);
    }

}
