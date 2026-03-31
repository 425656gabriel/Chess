public class Knight extends Piece {
    public Knight(boolean isWhite, int x, int y) {
        super(isWhite, x, y);
    }

    @Override
    public boolean isValidMove(Board board, int endX, int endY) {
        int xDiff = Math.abs(endX - this.x);
        int yDiff = Math.abs(endY - this.y);

        // The "L" shape logic: (2 horizontally + 1 vertically) OR (1 horizontally + 2 vertically)
        if ((xDiff == 2 && yDiff == 1) || (xDiff == 1 && yDiff == 2)) {
            Piece target = board.getPieceAt(endX, endY);
            // Knight can jump over pieces, so we only check the destination square
            return target == null || target.isWhite() != this.isWhite;
        }

        return false;
    }

    @Override
    public void display(javax.swing.JButton button) {
        // Using 'N' for Knight because 'K' is reserved for King
        button.setText(isWhite ? "♘" : "♞");
    }
}
