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
        if (cars.contains(car)) {
            cars.remove(car);
            return true;
        }
        return false;
    }

    public interface Usage<T> {
//        Usage<Integer> remaining = (u, t) -> t -u;

        T get(int used, int total);
    }

    public <T> T get(Usage<T> usage) {
        return usage.get(cars.size(), capacity);
    }

    public int remaningCapacity() {
        return capacity - cars.size();
    }
}
