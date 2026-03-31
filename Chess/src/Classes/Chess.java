import javax.swing.SwingUtilities;

public class Chess {
    public static void main(String[] args) {
        // This launches the Home screen on the proper UI thread
        SwingUtilities.invokeLater(() -> {
            // This is the link to your homepage
            new Home(); 
        });
    }
}
