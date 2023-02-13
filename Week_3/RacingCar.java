package Week_3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RacingCar extends JFrame {
  private int x, y;
  private Timer timer;
  private JButton btnPauseResume;
  private JLabel speedLabel;

  public RacingCar() {
    super("Racing Car");
    setLayout(new BorderLayout());
    
    x = 0;
    y = 50;
    timer = new Timer(50, new TimerListener());
    timer.start();

    JPanel controlPanel = new JPanel();
    controlPanel.setLayout(new FlowLayout());

    btnPauseResume = new JButton("Pause");
    btnPauseResume.addActionListener(new ButtonListener());
    controlPanel.add(btnPauseResume);

    speedLabel = new JLabel("Speed: 50");
    controlPanel.add(speedLabel);

    add(controlPanel, BorderLayout.NORTH);
    add(new DrawCanvas(), BorderLayout.CENTER);

    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
          int delay = timer.getDelay();
          if (delay > 10) {
            timer.setDelay(delay - 10);
            speedLabel.setText("Speed: " + (delay - 10));
          }
        } else if (key == KeyEvent.VK_DOWN) {
          int delay = timer.getDelay();
          timer.setDelay(delay + 10);
          speedLabel.setText("Speed: " + (delay + 10));
        }
      }
    });

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 300);
    setVisible(true);
  }

  private class TimerListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      x += 10;
      if (x > getWidth()) {
        x = 0;
      }
      repaint();
    }
  }

  private class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (timer.isRunning()) {
        timer.stop();
        btnPauseResume.setText("Resume");
      } else {
        timer.start();
        btnPauseResume.setText("Pause");
      }
    }
  }

  private class DrawCanvas extends JComponent {
    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.BLUE);
      g.fillRect(x, y, 50, 30);
    }
  }

  public static void main(String[] args) {
    new RacingCar();
  }
}
