import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements WithParkingCapability {
    private int capacity;
    private List<Car> cars;
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        cars = new ArrayList<>();
    }

    @Override
    public boolean park(Car car) {
        int remainRoom = capacity - cars.size();
        if (remainRoom > 0) {
            cars.add(car);
            return true;
        }
        return false;
    }

    @Override
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

    @Override
    public <T> T get(Usage<T> usage) {
        return usage.get(cars.size(), capacity);
    }

    @Override
    public String report(int indent) {
        String ret = "";
        String indentString = new String(new char[indent]).replace("\0", " ");
        ret = ret + indentString + "ParkingLot: " + (capacity - cars.size()) + "/" + capacity + "\n";
        return ret;
    }

}
