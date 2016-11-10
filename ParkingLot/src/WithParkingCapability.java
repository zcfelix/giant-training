public interface WithParkingCapability {
    boolean park(Car car);

    boolean unpark(Car car);

    <T> T get(ParkingLot.Usage<T> usage);

    String report(int indent);
}
