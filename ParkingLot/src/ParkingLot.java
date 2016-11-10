import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int capacity;
    private List<Car> cars;
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        cars = new ArrayList<>();
    }

    public boolean park(Car car) {
        int remainRoom = capacity - cars.size();
        if (remainRoom > 0) {
            cars.add(car);
            return true;
        }
        return false;
    }

    public boolean unpark(Car car) {
        return cars.stream().anyMatch(c -> c == car);
    }

}
