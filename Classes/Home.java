package Chess;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {
    // Professional Chess Theme Colors
    private final Color darkBg = new Color(49, 46, 43); 
    private final Color accentGreen = new Color(119, 148, 85); 
    private final Color textGold = new Color(215, 185, 130);

    public Home() {
        setTitle("Java Chess - Main Menu");
        // Increased size to fit the bigger logos
        setSize(600, 800); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(darkBg);

        // --- Header Section (Title and Big Logos) ---
        JPanel header = new JPanel(new GridBagLayout());
        header.setOpaque(false);
        GridBagConstraints hGbc = new GridBagConstraints();
        hGbc.gridx = 0;

        // 1. The Main Text Title
        JLabel titleLabel = new JLabel("CHESS", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 110)); 
        titleLabel.setForeground(Color.WHITE);
        hGbc.gridy = 0;
        hGbc.insets = new Insets(40, 0, 0, 0);
        header.add(titleLabel, hGbc);
        
        // 2. THE CHESS LOGOS (Huge Version)
        JLabel subtitle = new JLabel("♚ ♛ ♜ ♝ ♞ ♟", SwingConstants.CENTER);
        // Set to 80 for a massive, cinematic look
        subtitle.setFont(new Font("Serif", Font.PLAIN, 85)); 
        subtitle.setForeground(accentGreen);
        hGbc.gridy = 1;
        hGbc.insets = new Insets(10, 0, 50, 0); 
        header.add(subtitle, hGbc);

        // --- Button Section ---
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 0, 15, 0);

        // Play Button
        JButton playBtn = createStyledButton("START GAME", accentGreen);
        playBtn.addActionListener(e -> {
            this.dispose(); // Close Menu
            new Board();    // Open Game
        });
        
        // Quit Button
        JButton quitBtn = createStyledButton("EXIT GAME", new Color(150, 50, 50));
        quitBtn.addActionListener(e -> System.exit(0));

        gbc.gridy = 0;
        buttonPanel.add(playBtn, gbc);
        gbc.gridy = 1;
        buttonPanel.add(quitBtn, gbc);

        // Add components to the frame
        add(header, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Center on screen
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    // Helper method for the "Fancy" buttons
    private JButton createStyledButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 22)); // Bigger text for buttons
        btn.setForeground(Color.WHITE);
        btn.setBackground(color);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover Effect: Makes the button brighten when you mouse over it
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { btn.setBackground(color.brighter()); }
            public void mouseExited(MouseEvent e) { btn.setBackground(color); }
        });
        
        return btn;
    }
}
    }
}
