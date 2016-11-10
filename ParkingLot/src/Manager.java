import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager {
    private List<ParkingLot> parkingLots;
    private ParkingSelector parkingSelector;

    public Manager(ParkingLot... lots) {
        parkingLots = new ArrayList<>();
        parkingLots = Arrays.asList(lots);
        parkingSelector = new DefaultSelector();
    }

    public Manager(ParkingSelector selector, ParkingLot... lots) {
        parkingLots = new ArrayList<>();
        parkingLots = Arrays.asList(lots);
        parkingSelector = selector;
    }

    public boolean park(Car car) {
        return parkingSelector.selectParkingLot(parkingLots).map(parkingLot -> parkingLot.park(car)).orElse(false);
    }

    public boolean unpark(Car car) {
        return parkingLots.stream().map(parkingLot -> parkingLot.unpark(car)).anyMatch(b -> b);
    }
}
