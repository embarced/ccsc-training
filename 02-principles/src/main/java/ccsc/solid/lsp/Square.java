package ccsc.solid.lsp;

public class Square extends FourSidedFigure {
    private final int a;

    public Square(int a) {
        this.a = a;
    }

    @Override
    public int area() {
        return a * a;
    }
}
