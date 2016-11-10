import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager {
    private List<ParkingLot> parkingLots;

    public Manager(ParkingLot... lots) {
        parkingLots = new ArrayList<>();
        parkingLots = Arrays.asList(lots);
    }

    public boolean park(Car car) {
        return parkingLots.stream().map(parkingLot -> parkingLot.park(car)).anyMatch(b -> b);
    }

    public boolean unpark(Car car) {
        return parkingLots.stream().map(parkingLot -> parkingLot.unpark(car)).anyMatch(b -> b);
    }
}
