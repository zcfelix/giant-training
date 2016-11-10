import java.util.List;

public class Report {
    private int indent;

    public Report(int indent) {
        this.indent = indent;
    }

    public int getIndent() {
        return indent;
    }

    public void setIndent(int indent) {
        this.indent = indent;
    }

    String lotReport(int used, int total) {
        String ret = "";
        String indentString = new String(new char[getIndent()]).replace("\0", " ");
        ret = ret + indentString + "ParkingLot: " + (total - used) + "/" + total + "\n";
        return ret;
    }

    String managerReport(List<WithParkingCapability> managed) {
        String ret = "";
        String indentString = new String(new char[getIndent()]).replace("\0", " ");
        ret = ret + indentString + "Parker:\n";

        setIndent(getIndent() + 2);
        for (WithParkingCapability w : managed) {
            ret += w.report(this);
        }
        setIndent(getIndent() - 2);
        return ret;
    }
}
