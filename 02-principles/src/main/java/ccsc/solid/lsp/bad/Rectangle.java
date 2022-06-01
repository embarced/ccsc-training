package ccsc.solid.lsp.bad;

public class Rectangle {
    protected final int a, b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int area() {
        return a * b;
    }
}
