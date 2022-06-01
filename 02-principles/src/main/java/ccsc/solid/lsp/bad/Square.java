package ccsc.solid.lsp.bad;

public class Square extends Rectangle {
    public Square(int a) {
        super(a, a);
    }

    @Override
    public int area() {
        // return a * a;
        return super.area();
    }
}
