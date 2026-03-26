public class Pawn extends Piece {
    public Pawn(boolean isWhite, int x, int y) {
        super(isWhite, x, y);
    }

    @Override
    public boolean isValidMove(Board board, int endX, int endY) {
        int xDiff = endX - this.x; // Row difference
        int yDiff = Math.abs(endY - this.y); // Column difference
        int direction = isWhite ? -1 : 1; // White moves up (-), Black moves down (+)

        // 1. Forward Movement (No capturing)
        if (yDiff == 0) {
            // One square forward
            if (xDiff == direction && board.getPieceAt(endX, endY) == null) {
                return true;
            }
            // Two squares forward (Only on first move)
            int startRow = isWhite ? 6 : 1;
            if (this.x == startRow && xDiff == 2 * direction) {
                // Check intermediate square and target square are both empty
                if (board.getPieceAt(this.x + direction, this.y) == null && 
                    board.getPieceAt(endX, endY) == null) {
                    return true;
                }
            }
        } 
        
        // 2. Diagonal Capturing
        if (yDiff == 1 && xDiff == direction) {
            Piece target = board.getPieceAt(endX, endY);
            if (target != null && target.isWhite() != this.isWhite) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void display(javax.swing.JButton button) {
        button.setText(isWhite ? "♙" : "♟");
    }
}
