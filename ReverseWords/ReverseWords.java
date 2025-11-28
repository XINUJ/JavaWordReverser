import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReverseWords{

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Word Reverser");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 220);
            frame.setLocationRelativeTo(null);

            JPanel root = new JPanel(new BorderLayout(8, 8));
            root.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JTextField inputField = new JTextField();
            inputField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
            root.add(new JLabel("Input:"), BorderLayout.NORTH);
            root.add(inputField, BorderLayout.CENTER);

            JPanel bottom = new JPanel(new BorderLayout(6, 6));
            JButton reverseButton = new JButton("Reverse Words");
            JTextArea outputArea = new JTextArea(3, 40);
            outputArea.setEditable(false);
            outputArea.setLineWrap(true);
            outputArea.setWrapStyleWord(true);

            reverseButton.addActionListener(e -> {
                String input = inputField.getText();
                if (input == null || input.isEmpty()) {
                    outputArea.setText("");
                    return;
                }
                String[] words = input.split(" ", -1); 
                StringBuilder result = new StringBuilder();
                for (String word : words) {
                    result.append(new StringBuilder(word).reverse());
                    result.append(" ");
                }
                outputArea.setText(result.toString().trim());
            });

            bottom.add(reverseButton, BorderLayout.WEST);
            bottom.add(new JScrollPane(outputArea), BorderLayout.CENTER);

            root.add(bottom, BorderLayout.SOUTH);

            frame.setContentPane(root);
            frame.setVisible(true);
        });
    }
}
