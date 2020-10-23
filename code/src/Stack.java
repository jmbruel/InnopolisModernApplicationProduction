import java.util.ArrayList;

public class Stack<T> {

    private ArrayList<T> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    public Stack(ArrayList<T> a) {
        this.stack = a;
    }

    public int size() {
        return stack.size();
    }

}
