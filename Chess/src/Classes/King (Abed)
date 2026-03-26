public class King extends Piece {
    public King(boolean isWhite, int x, int y) { super(isWhite, x, y); }
    @Override
    public boolean isValidMove(Board board, int endX, int endY) {
        int xDiff = Math.abs(endX - this.x);
        int yDiff = Math.abs(endY - this.y);
        if (xDiff <= 1 && yDiff <= 1 && !(xDiff == 0 && yDiff == 0)) {
            Piece target = board.getPieceAt(endX, endY);
            return target == null || target.isWhite() != this.isWhite;
        }
        return false;
    }
    
    @Override
    public void display(javax.swing.JButton button) {
        button.setText(isWhite ? "♔" : "♚");
    }
}
