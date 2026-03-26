import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    private JButton[][] buttons = new JButton[8][8];
    private Piece[][] logicBoard = new Piece[8][8]; 
    private Piece selectedPiece = null;
    private boolean whiteTurn = true;

    private final Color lightSquare = new Color(235, 235, 208);
    private final Color darkSquare = new Color(119, 148, 85);

    public Board() {
        setTitle("Chess - White's Turn");
        setSize(750, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel grid = new JPanel(new GridLayout(8, 8));
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                buttons[r][c] = new JButton();
                buttons[r][c].setOpaque(true);
                buttons[r][c].setBorderPainted(false);
                buttons[r][c].setFont(new Font("Serif", Font.BOLD, 45));

                if ((r + c) % 2 == 0) buttons[r][c].setBackground(lightSquare);
                else buttons[r][c].setBackground(darkSquare);
                
                final int finalR = r, finalC = c;
                buttons[r][c].addActionListener(e -> handleInput(finalR, finalC));
                grid.add(buttons[r][c]);
            }
        }

        JPanel controlPanel = new JPanel();
        JButton restartBtn = new JButton("Restart Game");
        restartBtn.setFont(new Font("Arial", Font.BOLD, 16));
        restartBtn.addActionListener(e -> restartGame());
        controlPanel.add(restartBtn);

        add(grid, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        
        setupInitialPieces();
        updateUI();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void restartGame() {
        whiteTurn = true;
        selectedPiece = null;
        setupInitialPieces();
        updateUI();
        setTitle("Chess - White's Turn");
    }

    private void setupInitialPieces() {
        for(int i=0; i<8; i++) for(int j=0; j<8; j++) logicBoard[i][j] = null;

        // BLACK
        logicBoard[0][0] = new Rook(false, 0, 0); logicBoard[0][7] = new Rook(false, 0, 7);
        logicBoard[0][1] = new Knight(false, 0, 1); logicBoard[0][6] = new Knight(false, 0, 6);
        logicBoard[0][2] = new Bishop(false, 0, 2); logicBoard[0][5] = new Bishop(false, 0, 5);
        logicBoard[0][3] = new Queen(false, 0, 3); logicBoard[0][4] = new King(false, 0, 4);
        for (int i = 0; i < 8; i++) logicBoard[1][i] = new Pawn(false, 1, i);

        // WHITE
        logicBoard[7][0] = new Rook(true, 7, 0); logicBoard[7][7] = new Rook(true, 7, 7);
        logicBoard[7][1] = new Knight(true, 7, 1); logicBoard[7][6] = new Knight(true, 7, 6);
        logicBoard[7][2] = new Bishop(true, 7, 2); logicBoard[7][5] = new Bishop(true, 7, 5);
        logicBoard[7][3] = new Queen(true, 7, 3); logicBoard[7][4] = new King(true, 7, 4);
        for (int i = 0; i < 8; i++) logicBoard[6][i] = new Pawn(true, 6, i);
    }

    private void handleInput(int r, int c) {
        Piece clickedPiece = logicBoard[r][c];

        if (selectedPiece == null) {
            if (clickedPiece != null && clickedPiece.isWhite() == whiteTurn) {
                selectedPiece = clickedPiece;
                buttons[r][c].setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
                buttons[r][c].setBorderPainted(true);
            }
        } else {
            if (selectedPiece.isValidMove(this, r, c) && !willBeInCheck(selectedPiece, r, c)) {
                // Execute Logic Move
                logicBoard[selectedPiece.x][selectedPiece.y] = null;
                selectedPiece.move(r, c); 
                logicBoard[r][c] = selectedPiece;

                if (selectedPiece instanceof Pawn && (r == 0 || r == 7)) {
                    logicBoard[r][c] = new Queen(selectedPiece.isWhite(), r, c);
                }

                whiteTurn = !whiteTurn;
                selectedPiece = null;
                updateUI();

                // Check for Checkmate after move
                if (isCheckmate(whiteTurn)) {
                    JOptionPane.showMessageDialog(this, "CHECKMATE! " + (whiteTurn ? "Black" : "White") + " Wins!");
                    restartGame();
                }
            } else {
                if (clickedPiece != null && clickedPiece.isWhite() == whiteTurn) {
                    updateUI();
                    selectedPiece = clickedPiece;
                    buttons[r][c].setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
                    buttons[r][c].setBorderPainted(true);
                } else {
                    selectedPiece = null;
                    updateUI();
                }
            }
        }
        setTitle("Chess - " + (whiteTurn ? "White's Turn" : "Black's Turn"));
    }

    // --- CHECKMATE LOGIC ---

    public boolean isCheckmate(boolean white) {
        if (!isKingInCheck(white)) return false;

        // Try every possible move for every piece of this color
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Piece p = logicBoard[r][c];
                if (p != null && p.isWhite() == white) {
                    for (int tr = 0; tr < 8; tr++) {
                        for (int tc = 0; tc < 8; tc++) {
                            if (p.isValidMove(this, tr, tc) && !willBeInCheck(p, tr, tc)) {
                                return false; // Found at least one legal move!
                            }
                        }
                    }
                }
            }
        }
        return true; // No legal moves found
    }

    public boolean isKingInCheck(boolean white) {
        int kr = -1, kc = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (logicBoard[i][j] instanceof King && logicBoard[i][j].isWhite() == white) {
                    kr = i; kc = j; break;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece enemy = logicBoard[i][j];
                if (enemy != null && enemy.isWhite() != white) {
                    if (enemy.isValidMove(this, kr, kc)) return true;
                }
            }
        }
        return false;
    }

    public boolean willBeInCheck(Piece p, int targetR, int targetC) {
        int startR = p.x; int startC = p.y;
        Piece targetBackup = logicBoard[targetR][targetC];

        logicBoard[startR][startC] = null;
        logicBoard[targetR][targetC] = p;
        int oldX = p.x; int oldY = p.y;
        p.x = targetR; p.y = targetC;

        boolean inDanger = isKingInCheck(p.isWhite());

        p.x = oldX; p.y = oldY;
        logicBoard[startR][startC] = p;
        logicBoard[targetR][targetC] = targetBackup;
        return inDanger;
    }

    private void updateUI() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setBorderPainted(false); 
                if (logicBoard[i][j] != null) logicBoard[i][j].display(buttons[i][j]);
            }
        }
    }

    public Piece getPieceAt(int r, int c) {
        if (r < 0 || r >= 8 || c < 0 || c >= 8) return null;
        return logicBoard[r][c];
    }
}
