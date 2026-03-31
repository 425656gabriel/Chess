public class Bishop extends Piece {
    public Bishop(boolean isWhite, int x, int y) {
        super(isWhite, x, y);
    }

    @Override
    public boolean isValidMove(Board board, int endX, int endY) {
        int xDiff = Math.abs(endX - this.x);
        int yDiff = Math.abs(endY - this.y);

        // Bishops must move diagonally: horizontal change == vertical change
        if (xDiff != yDiff || (this.x == endX && this.y == endY)) {
            return false;
        }

        // Path Checking
        int xDir = Integer.compare(endX, this.x);
        int yDir = Integer.compare(endY, this.y);
        int curX = this.x + xDir;
        int curY = this.y + yDir;

        while (curX != endX || curY != endY) {
            if (board.getPieceAt(curX, curY) != null) return false;
            curX += xDir; curY += yDir;
        }

        Piece target = board.getPieceAt(endX, endY);
        return target == null || target.isWhite() != this.isWhite;
    }

    @Override
    public void display(javax.swing.JButton button) {
        button.setText(isWhite ? "♗" : "♝");
    }
}
