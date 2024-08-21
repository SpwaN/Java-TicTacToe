import java.awt.EventQueue;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Start {

	private JFrame form;
	public static GameScreen gamescreen;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Start window = new Start();
					window.form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		form = new JFrame();
		form.setTitle("Tic-Tac-Toe");
		form.setBounds(100, 100, 275, 300);
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon icon = new ImageIcon("src/logo.png");
		form.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel(icon);
		logo.setForeground(UIManager.getColor("Button.disabledForeground"));
		logo.setBackground(UIManager.getColor("Button.disabledForeground"));
		logo.setBounds(0, 0, 260, 180);
		logo.setText("");
		form.getContentPane().add(logo);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setToolTipText("Starts the Tic-Tac-Toe Game");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamescreen.main(null);
				form.setVisible(false);
				
			}
		});
		btnPlay.setBounds(30, 225, 65, 30);
		form.getContentPane().add(btnPlay);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setToolTipText("Exits the Game");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(160, 225, 65, 30);
		form.getContentPane().add(btnExit);
		
		JLabel lblCredits = new JLabel("A game by Joel Löfberg & Kevin Berling");
		lblCredits.setBounds(30, 185, 240, 30);
		form.getContentPane().add(lblCredits);
	}

}
