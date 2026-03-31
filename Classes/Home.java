
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
        setSize(600, 800); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(darkBg);

        JPanel header = new JPanel(new GridBagLayout());
        header.setOpaque(false);
        GridBagConstraints hGbc = new GridBagConstraints();
        hGbc.gridx = 0;

        JLabel titleLabel = new JLabel("CHESS", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 110)); 
        titleLabel.setForeground(Color.WHITE);
        hGbc.gridy = 0;
        hGbc.insets = new Insets(40, 0, 0, 0);
        header.add(titleLabel, hGbc);
        
        JLabel subtitle = new JLabel("♚ ♛ ♜ ♝ ♞ ♟", SwingConstants.CENTER);
        subtitle.setFont(new Font("Serif", Font.PLAIN, 85)); 
        subtitle.setForeground(accentGreen);
        hGbc.gridy = 1;
        hGbc.insets = new Insets(10, 0, 50, 0); 
        header.add(subtitle, hGbc);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 0, 15, 0);

        JButton playBtn = createStyledButton("START GAME", accentGreen);
        playBtn.addActionListener(e -> {
            this.dispose();
            new Board();
        });

        JButton quitBtn = createStyledButton("EXIT GAME", new Color(150, 50, 50));
        quitBtn.addActionListener(e -> System.exit(0));

        gbc.gridy = 0;
        buttonPanel.add(playBtn, gbc);
        gbc.gridy = 1;
        buttonPanel.add(quitBtn, gbc);

        add(header, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null); 
        setVisible(true);
    }

    private JButton createStyledButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 22));
        btn.setForeground(Color.WHITE);
        btn.setBackground(color);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { btn.setBackground(color.brighter()); }
            public void mouseExited(MouseEvent e) { btn.setBackground(color); }
        });
        
        return btn;
    }
}
