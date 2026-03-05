import javax.swing.JButton;

public abstract class Piece {
    protected boolean isWhite;
    protected int x, y;

    public Piece(boolean isWhite, int x, int y) {
        this.isWhite = isWhite;
        this.x = x;
        this.y = y;
    }

    public void display(JButton button) {
        String name = this.getClass().getSimpleName().substring(0, 1);
        button.setText((isWhite ? "W" : "B") + name);
    }

    public void move(int nextX, int nextY) {
        this.x = nextX;
        this.y = nextY;
    }

    public boolean isWhite() { return isWhite; }
    public abstract boolean isValidMove(Board board, int endX, int endY);
}
