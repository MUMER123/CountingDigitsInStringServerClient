import java.io.Serializable;

public class Request implements Serializable {

    private String str;

    public Request(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
