import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class AttractiveFullScreenForm {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Exam Completion Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true); // Removes window decorations (title bar, close button, etc.)

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
        messageLabel.setFont(getLargeFont());
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add the label to the panel
        panel.add(messageLabel);

        // Create and customize form components
        JTextField nameField = new JTextField(20);
        nameField.setFont(getLargeFont());
        JTextField emailField = new JTextField(20);
        emailField.setFont(getLargeFont());

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(getLargeFont());
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle form submission here
                JOptionPane.showMessageDialog(frame, "Form submitted successfully!");
            }
        });

        // Create a form panel and add components
        JPanel formPanel = new JPanel();
        formPanel.setOpaque(false);
        formPanel.setLayout(new GridLayout(3, 2, 10, 10));
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(new JPanel()); // Spacer
        formPanel.add(submitButton);

        // Add the form panel to the main panel
        panel.add(formPanel);

        frame.setVisible(true);
    }

    private static Font getLargeFont() {
        Font baseFont = new Font("Arial", Font.PLAIN, 24);
        Map<TextAttribute, Object> attributes = new HashMap<>();
        attributes.put(TextAttribute.SIZE, 36.0);
        return baseFont.deriveFont(attributes);
    }
}
