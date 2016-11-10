import java.util.List;

public class Report {
    int indent;

    public Report() {
        this.indent = 0;
    }

    public int getIndent() {
        return indent;
    }

    public void setIndent(int indent) {
        this.indent = indent;
    }

    String managedReport(List<WithParkingCapability> managed) {
        String ret = "";
        String indentString = getIndentString();
        ret = ret + indentString + "Parker:\n";

        setIndent(getIndent() + 2);
        for (WithParkingCapability w : managed) {
            ret += w.report(this);
        }
        setIndent(getIndent() - 2);
        return ret;
    }


    String lotReport(int used, int total) {
        String ret = "";
        String indentString = getIndentString();
        ret = ret + indentString + "ParkingLot: " + (total - used) + "/" + total + "\n";
        return ret;
    }

    private String getIndentString() {
        return new String(new char[getIndent()]).replace("\0", " ");
    }
}
