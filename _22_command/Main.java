package _22_command;

import _22_command.command.*;
import _22_command.drawer.*;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {
    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    private JButton clearButton = new JButton("clear");
    private JButton blueButton = new JButton("BLUE");
    private JButton undoButton = new JButton("←");
    
    public Main(String title) {
        super(title);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Command cmd = new DrawCommand(canvas, e.getPoint());
                history.append(cmd);
                cmd.execute();
            }
        });
        clearButton.addActionListener(this);
        blueButton.addActionListener(this);
        undoButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(blueButton);
        buttonBox.add(undoButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.repaint();
        }
        else if (e.getSource() == blueButton) {
            Command cmd = new ColorCommand(canvas, Color.BLUE);
            history.append(cmd);
            cmd.execute();
        }
        else if (e.getSource() == undoButton) {
            canvas.repaint();
            for (int i = 0; i < 10; i++) {
                history.undo();
            }
            history.execute();
        }
    }
}
