import java.io.Serializable;

public class Response implements Serializable {

    private int count;

    public int getCount() {
        return count;
    }

    public Response(int count) {
        this.count = count;
    }
}
