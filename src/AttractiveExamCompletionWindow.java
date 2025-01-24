import javax.swing.*;
import java.awt.*;

public class AttractiveExamCompletionWindow {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Exam Completed");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Create a panel with a background color
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(48, 63, 159));  // Dark blue background color
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        frame.add(panel);

        // Create a label with the message
        JLabel messageLabel = new JLabel("You have completed your exam. Your result will be declared soon");
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add the label to the panel
        panel.add(messageLabel);

        frame.setVisible(true);
    }
}
