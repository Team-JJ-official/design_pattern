package _07_builder;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FrameBuilder extends Builder implements ActionListener {
    private JFrame frame = new JFrame();
    private Box box = new Box(BoxLayout.Y_AXIS);

    public void createTitle(String title) {
        frame.setTitle(title);
    }
    @Override
    public void createString(String str) {
        box.add(new JLabel(str));
    }
    @Override
    public void createItems(String[] items) {
        Box innerBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < items.length; i++) {
            JButton button = new JButton(items[i]);
            button.addActionListener(this);
            innerBox.add(button);
        }
        box.add(innerBox);
    }
    @Override
    public void internalClose() {
        frame.getContentPane().add(box);
        frame.pack();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public JFrame getResult() {
        return frame;
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
