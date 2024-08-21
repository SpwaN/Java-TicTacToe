import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GameScreen {

	private JFrame frame;
	private Logik logik = new Logik();
	private Start start;
	public static JButton button[] = new JButton[10];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GameScreen window = new GameScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		for (int i = 0; i < 10; i++) {
			button[i] = new JButton();
			button[i].setText("   ");
		}

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, -3, 62, 27, 31, 0, 39, 21};
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 28, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[] { 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3 };
		frame.getContentPane().setLayout(gridBagLayout);
		
				JLabel WinCount = new JLabel("Win Counter");
				GridBagConstraints gbc_WinCount = new GridBagConstraints();
				gbc_WinCount.insets = new Insets(10, 40, 5, 5); // Toppen, Vänster, Botten, Höger
				gbc_WinCount.gridx = 2;
				gbc_WinCount.gridy = 1;
				gbc_WinCount.weightx = 0.7;
				gbc_WinCount.weighty = 0.7;
				frame.getContentPane().add(WinCount, gbc_WinCount);
		
				JLabel player1 = new JLabel("Player 1 (X): ");
				GridBagConstraints gbc_label1 = new GridBagConstraints();
				gbc_label1.anchor = GridBagConstraints.EAST;
				gbc_label1.insets = new Insets(10, 40, 5, 5); // Toppen, Vänster, Botten, Höger
				gbc_label1.gridx = 2;
				gbc_label1.gridy = 2;
				frame.getContentPane().add(player1, gbc_label1);
				
				JLabel player2 = new JLabel("Player 2 (O): ");
				GridBagConstraints gbc_label2 = new GridBagConstraints();
				gbc_label2.anchor = GridBagConstraints.EAST;
				gbc_label2.insets = new Insets(0, 40, 5, 5); // Toppen, Vänster, Botten, Höger
				gbc_label2.gridx = 2;
				gbc_label2.gridy = 3;
				frame.getContentPane().add(player2, gbc_label2);
		
				JButton backButton = new JButton("Back");
				backButton.setMaximumSize(new Dimension(70, 23));
				backButton.setPreferredSize(new Dimension(70, 23));
				backButton.setMinimumSize(new Dimension(70, 23));
				backButton.setToolTipText("Takes you back to the Start screen");
				GridBagConstraints gbc_backButton = new GridBagConstraints();
				gbc_backButton.insets = new Insets(0, 0, 5, 5);
				gbc_backButton.gridx = 21;
				gbc_backButton.gridy = 2;
				gbc_backButton.weightx = 1;
				gbc_backButton.weighty = 1;
				frame.getContentPane().add(backButton, gbc_backButton);
				backButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						start.main(null);
						frame.setVisible(false);
					}
				});
				JLabel WinCountX = new JLabel("0");
				GridBagConstraints gbc_WinCountX = new GridBagConstraints();
				gbc_WinCountX.anchor = GridBagConstraints.SOUTHWEST;
				gbc_WinCountX.insets = new Insets(0, 0, 9, 5);
				gbc_WinCountX.gridx = 3;
				gbc_WinCountX.gridy = 2;
				frame.getContentPane().add(WinCountX, gbc_WinCountX);
										
				JLabel WinCountO = new JLabel("0");
				GridBagConstraints gbc_WinCountO = new GridBagConstraints();
				gbc_WinCountO.anchor = GridBagConstraints.LINE_START;
				gbc_WinCountO.insets = new Insets(0, 0, 5, 5);
				gbc_WinCountO.gridx = 3;
				gbc_WinCountO.gridy = 3;
				frame.getContentPane().add(WinCountO, gbc_WinCountO);
				
				JLabel TurnLabel = new JLabel("<html>Turn: <font color='red'>X</font></html>");
				TurnLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
				GridBagConstraints gbc_TurnLabel = new GridBagConstraints();
				gbc_TurnLabel.anchor = GridBagConstraints.EAST;
				gbc_TurnLabel.insets = new Insets(0, 0, 5, 5);
				gbc_TurnLabel.gridx = 2;
				gbc_TurnLabel.gridy = 10;
				frame.getContentPane().add(TurnLabel, gbc_TurnLabel);
				
				JButton ResetButton = new JButton("Reset");
				ResetButton.setToolTipText("Resets the board");
				GridBagConstraints gbc_ResetButton = new GridBagConstraints();
				gbc_ResetButton.insets = new Insets(0, 0, 5, 5);
				gbc_ResetButton.gridx = 21;
				gbc_ResetButton.gridy = 1;
				gbc_ResetButton.weightx = 1;
				gbc_ResetButton.weighty = 1;
				frame.getContentPane().add(ResetButton, gbc_ResetButton);
		
				ResetButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						for (int i = 0; i < 10; i++) {
							button[i].setText("   ");
							button[i].setEnabled(true);
							button[i].setBackground(null);
							TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
							logik.Reset();
						}
					}
				});
				
				
		GridBagConstraints gbc_Box1 = new GridBagConstraints();
		gbc_Box1.insets = new Insets(0, 0, 5, 5);
		gbc_Box1.gridx = 6;
		gbc_Box1.gridy = 7;
		gbc_Box1.weightx = 1;
		gbc_Box1.weighty = 1;
		frame.getContentPane().add(button[0], gbc_Box1);
		
		button[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (logik.alternate % 2 == 0) {
					button[0].setEnabled(false);
					button[0].setBackground(Color.RED);
					button[0].setText("X");
					TurnLabel.setText("<html>Turn: <font color='blue'>O</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				} else {
					button[0].setBackground(Color.BLUE);
					button[0].setText("O");
					button[0].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				}
				if(logik.kollaVinst() == true || logik.likaTest == 144) {
					String str;
					if(logik.likaTest == 144) {
						str = "Draw!";
					} else {
						str = "Game Over!";
					}
					int svar = JOptionPane.showConfirmDialog(null, "Klicka Yes för att starta om, No för att stänga av.", str, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(logik.alternate % 2 == 0) {
						int tmp = Integer.parseInt(WinCountX.getText());
						WinCountX.setText(Integer.toString(tmp+1));		// maby it
					} else if (logik.alternate % 2 != 0 && logik.likaTest != 144){
						int tmp = Integer.parseInt(WinCountO.getText());
						WinCountO.setText(Integer.toString(tmp+1));		// maby it
					}
					//0 = yes, 1=no, 2=cancel
					if (svar == JOptionPane.YES_OPTION) {
						//Reset game
						for (int i = 0; i < 10; i++) {
							button[i].setText("   ");
							button[i].setEnabled(true);
							button[i].setBackground(null);
							TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
							logik.Reset();
						}
					} else if (svar == JOptionPane.NO_OPTION){
						System.exit(svar);
					}
					else {
						System.out.println("Nothing chosen");
					}
				}
			}
		});
		
		GridBagConstraints gbc_Box2 = new GridBagConstraints();
		gbc_Box2.insets = new Insets(0, 0, 5, 5);
		gbc_Box2.gridx = 7;
		gbc_Box2.gridy = 7;
		gbc_Box2.weightx = 1;
		gbc_Box2.weighty = 1;
		frame.getContentPane().add(button[1], gbc_Box2);
		
		button[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (logik.alternate % 2 == 0) {
					button[1].setBackground(Color.RED);
					button[1].setText("X");
					button[1].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='blue'>O</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				} else {
					button[1].setBackground(Color.BLUE);
					button[1].setText("O");
					button[1].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				}
				if(logik.kollaVinst() == true || logik.likaTest == 144) {
					String str;
					if(logik.likaTest == 144) {
						str = "Draw!";
					} else {
						str = "Game Over!";
					}
					int svar = JOptionPane.showConfirmDialog(null, "Klicka Yes för att starta om, No för att stänga av.", str, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(logik.alternate % 2 == 0) {
						int tmp = Integer.parseInt(WinCountX.getText());
						WinCountX.setText(Integer.toString(tmp+1));		// maby it
					} else if (logik.alternate % 2 != 0 && logik.likaTest != 144){
						int tmp = Integer.parseInt(WinCountO.getText());
						WinCountO.setText(Integer.toString(tmp+1));		// maby it
					}
					//0 = yes, 1=no, 2=cancel
					if (svar == JOptionPane.YES_OPTION) {
						//Reset game
						for (int i = 0; i < 10; i++) {
							button[i].setText("   ");
							button[i].setEnabled(true);
							button[i].setBackground(null);
							TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
							logik.Reset();
						}
					} else if (svar == JOptionPane.NO_OPTION){
						System.exit(svar);
					}
					else {
						System.out.println("Nothing chosen");
					}
				}
			}
		});
		
		GridBagConstraints gbc_Box3 = new GridBagConstraints();
		gbc_Box3.insets = new Insets(0, 0, 5, 5);
		gbc_Box3.gridx = 8;
		gbc_Box3.gridy = 7;
		gbc_Box3.weightx = 1;
		gbc_Box3.weighty = 1;
		frame.getContentPane().add(button[2], gbc_Box3);
		
		button[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (logik.alternate % 2 == 0) {
					button[2].setBackground(Color.RED);
					button[2].setText("X");
					button[2].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='blue'>O</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				} else {
					button[2].setBackground(Color.BLUE);
					button[2].setText("O");
					button[2].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				}
				if(logik.kollaVinst() == true || logik.likaTest == 144) {
					String str;
					if(logik.likaTest == 144) {
						str = "Draw!";
					} else {
						str = "Game Over!";
					}
					int svar = JOptionPane.showConfirmDialog(null, "Klicka Yes för att starta om, No för att stänga av.", str, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(logik.alternate % 2 == 0) {
						int tmp = Integer.parseInt(WinCountX.getText());
						WinCountX.setText(Integer.toString(tmp+1));		// maby it
					} else if (logik.alternate % 2 != 0 && logik.likaTest != 144){
						int tmp = Integer.parseInt(WinCountO.getText());
						WinCountO.setText(Integer.toString(tmp+1));		// maby it
					}
					//0 = yes, 1=no, 2=cancel
					if (svar == JOptionPane.YES_OPTION) {
						//Reset game
						for (int i = 0; i < 10; i++) {
							button[i].setText("   ");
							button[i].setEnabled(true);
							button[i].setBackground(null);
							TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
							logik.Reset();
						}
					} else if (svar == JOptionPane.NO_OPTION){
						System.exit(svar);
					}
					else {
						System.out.println("Nothing chosen");
					}
				}
			}
		});
		
		GridBagConstraints gbc_Box4 = new GridBagConstraints();
		gbc_Box4.insets = new Insets(0, 0, 5, 5);
		gbc_Box4.gridx = 6;
		gbc_Box4.gridy = 8;
		gbc_Box4.weightx = 1;
		gbc_Box4.weighty = 1;
		frame.getContentPane().add(button[3], gbc_Box4);
		
		button[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (logik.alternate % 2 == 0) {
					button[3].setBackground(Color.RED);
					button[3].setText("X");
					button[3].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='blue'>O</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				} else {
					button[3].setBackground(Color.BLUE);
					button[3].setText("O");
					button[3].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				}
				if(logik.kollaVinst() == true || logik.likaTest == 144) {
					String str;
					if(logik.likaTest == 144) {
						str = "Draw!";
					} else {
						str = "Game Over!";
					}
					int svar = JOptionPane.showConfirmDialog(null, "Klicka Yes för att starta om, No för att stänga av.", str, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(logik.alternate % 2 == 0) {
						int tmp = Integer.parseInt(WinCountX.getText());
						WinCountX.setText(Integer.toString(tmp+1));
					} else if (logik.alternate % 2 != 0 && logik.likaTest != 144){
						int tmp = Integer.parseInt(WinCountO.getText());
						WinCountO.setText(Integer.toString(tmp+1));
					}
					//0 = yes, 1=no, 2=cancel
					if (svar == JOptionPane.YES_OPTION) {
						//Reset game
						for (int i = 0; i < 10; i++) {
							button[i].setText("   ");
							button[i].setEnabled(true);
							button[i].setBackground(null);
							TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
							logik.Reset();
						}
					} else if (svar == JOptionPane.NO_OPTION){
						System.exit(svar);
					}
					else {
						System.out.println("Nothing chosen");
					}
				}
			}
		});
		
		GridBagConstraints gbc_Box5 = new GridBagConstraints();
		gbc_Box5.insets = new Insets(0, 0, 5, 5);
		gbc_Box5.gridx = 7;
		gbc_Box5.gridy = 8;
		gbc_Box5.weightx = 1;
		gbc_Box5.weighty = 1;
		frame.getContentPane().add(button[4], gbc_Box5);
		
		button[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (logik.alternate % 2 == 0) {
					button[4].setBackground(Color.RED);
					button[4].setText("X");
					button[4].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='blue'>O</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				} else {
					button[4].setBackground(Color.BLUE);
					button[4].setText("O");
					button[4].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				}
				if(logik.kollaVinst() == true || logik.likaTest == 144) {
					String str;
					if(logik.likaTest == 144) {
						str = "Draw!";
					} else {
						str = "Game Over!";
					}
					int svar = JOptionPane.showConfirmDialog(null, "Klicka Yes för att starta om, No för att stänga av.", str, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(logik.alternate % 2 == 0) {
						int tmp = Integer.parseInt(WinCountX.getText());
						WinCountX.setText(Integer.toString(tmp+1));
					} else if (logik.alternate % 2 != 0 && logik.likaTest != 144){
						int tmp = Integer.parseInt(WinCountO.getText());
						WinCountO.setText(Integer.toString(tmp+1));
					}
					//0 = yes, 1=no, 2=cancel
					if (svar == JOptionPane.YES_OPTION) {
						//Reset game
						for (int i = 0; i < 10; i++) {
							button[i].setText("   ");
							button[i].setEnabled(true);
							button[i].setBackground(null);
							TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
							logik.Reset();
						}
					} else if (svar == JOptionPane.NO_OPTION){
						System.exit(svar);
					}
					else {
						System.out.println("Nothing chosen");
					}
				}
			}
		});
		
		GridBagConstraints gbc_Box6 = new GridBagConstraints();
		gbc_Box6.insets = new Insets(0, 0, 5, 5);
		gbc_Box6.gridx = 8;
		gbc_Box6.gridy = 8;
		gbc_Box6.weightx = 1;
		gbc_Box6.weighty = 1;
		frame.getContentPane().add(button[5], gbc_Box6);

		button[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (logik.alternate % 2 == 0) {
					button[5].setBackground(Color.RED);
					button[5].setText("X");
					button[5].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='blue'>O</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				} else {
					button[5].setBackground(Color.BLUE);
					button[5].setText("O");
					button[5].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				}
				if(logik.kollaVinst() == true || logik.likaTest == 144) {
					String str;
					if(logik.likaTest == 144) {
						str = "Draw!";
					} else {
						str = "Game Over!";
					}
					int svar = JOptionPane.showConfirmDialog(null, "Klicka Yes för att starta om, No för att stänga av.", str, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(logik.alternate % 2 == 0) {
						int tmp = Integer.parseInt(WinCountX.getText());
						WinCountX.setText(Integer.toString(tmp+1));
					} else if (logik.alternate % 2 != 0 && logik.likaTest != 144){
						int tmp = Integer.parseInt(WinCountO.getText());
						WinCountO.setText(Integer.toString(tmp+1));
					}
					//0 = yes, 1=no, 2=cancel
					if (svar == JOptionPane.YES_OPTION) {
						//Reset game
						for (int i = 0; i < 10; i++) {
							button[i].setText("   ");
							button[i].setEnabled(true);
							button[i].setBackground(null);
							TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
							logik.Reset();
						}
					} else if (svar == JOptionPane.NO_OPTION){
						System.exit(svar);
					}
					else {
						System.out.println("Nothing chosen");
					}
				}
			}
		});
		
		GridBagConstraints gbc_Box7 = new GridBagConstraints();
		gbc_Box7.insets = new Insets(0, 0, 0, 5);
		gbc_Box7.gridx = 6;
		gbc_Box7.gridy = 9;
		gbc_Box7.weightx = 1;
		gbc_Box7.weighty = 1;
		frame.getContentPane().add(button[6], gbc_Box7);
		
		button[6].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (logik.alternate % 2 == 0) {
					button[6].setBackground(Color.RED);
					button[6].setText("X");
					button[6].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='blue'>O</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				} else {
					button[6].setBackground(Color.BLUE);
					button[6].setText("O");
					button[6].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				}
				if(logik.kollaVinst() == true || logik.likaTest == 144) {
					String str;
					if(logik.likaTest == 144) {
						str = "Draw!";
					} else {
						str = "Game Over!";
					}
					int svar = JOptionPane.showConfirmDialog(null, "Klicka Yes för att starta om, No för att stänga av.", str, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(logik.alternate % 2 == 0) {
						int tmp = Integer.parseInt(WinCountX.getText());
						WinCountX.setText(Integer.toString(tmp+1));
					} else if (logik.alternate % 2 != 0 && logik.likaTest != 144){
						int tmp = Integer.parseInt(WinCountO.getText());
						WinCountO.setText(Integer.toString(tmp+1));
					}
					//0 = yes, 1=no, 2=cancel
					if (svar == JOptionPane.YES_OPTION) {
						//Reset game
						for (int i = 0; i < 10; i++) {
							button[i].setText("   ");
							button[i].setEnabled(true);
							button[i].setBackground(null);
							TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
							logik.Reset();
						}
					} else if (svar == JOptionPane.NO_OPTION){
						System.exit(svar);
					}
					else {
						System.out.println("Nothing chosen");
					}
				}
			}
		});
		
		GridBagConstraints gbc_Box8 = new GridBagConstraints();
		gbc_Box8.insets = new Insets(0, 0, 0, 5);
		gbc_Box8.gridx = 7;
		gbc_Box8.gridy = 9;
		gbc_Box8.weightx = 1;
		gbc_Box8.weighty = 1;
		frame.getContentPane().add(button[7], gbc_Box8);
		
		button[7].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (logik.alternate % 2 == 0) {
					button[7].setBackground(Color.RED);
					button[7].setText("X");
					button[7].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='blue'>O</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				} else {
					button[7].setBackground(Color.BLUE);
					button[7].setText("O");
					button[7].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				}
				if(logik.kollaVinst() == true || logik.likaTest == 144) {
					String str;
					if(logik.likaTest == 144) {
						str = "Draw!";
					} else {
						str = "Game Over!";
					}
					int svar = JOptionPane.showConfirmDialog(null, "Klicka Yes för att starta om, No för att stänga av.", str, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(logik.alternate % 2 == 0) {
						int tmp = Integer.parseInt(WinCountX.getText());
						WinCountX.setText(Integer.toString(tmp+1));
					} else if (logik.alternate % 2 != 0 && logik.likaTest != 144){
						int tmp = Integer.parseInt(WinCountO.getText());
						WinCountO.setText(Integer.toString(tmp+1));
					}
					//0 = yes, 1=no, 2=cancel
					if (svar == JOptionPane.YES_OPTION) {
						//Reset game
						for (int i = 0; i < 10; i++) {
							button[i].setText("   ");
							button[i].setEnabled(true);
							button[i].setBackground(null);
							TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
							logik.Reset();
						}
					} else if (svar == JOptionPane.NO_OPTION){
						System.exit(svar);
					}
					else {
						System.out.println("Nothing chosen");
					}
				}
			}
		});
		
		GridBagConstraints gbc_Box9 = new GridBagConstraints();
		gbc_Box9.insets = new Insets(0, 0, 0, 5);
		gbc_Box9.gridx = 8;
		gbc_Box9.gridy = 9;
		gbc_Box9.weightx = 1;
		gbc_Box9.weighty = 1;
		frame.getContentPane().add(button[8], gbc_Box9);
		button[8].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (logik.alternate % 2 == 0) {
					button[8].setBackground(Color.RED);
					button[8].setText("X");
					button[8].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='blue'>O</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				} else {
					button[8].setBackground(Color.BLUE);
					button[8].setText("O");
					button[8].setEnabled(false);
					TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
					if(!logik.kollaVinst())
					logik.AndraTur();
				}
				if(logik.kollaVinst() == true || logik.likaTest == 144) {
					String str;
					if(logik.likaTest == 144) {
						str = "Draw!";
					} else {
						str = "Game Over!";
					}
					int svar = JOptionPane.showConfirmDialog(null, "Klicka Yes för att starta om, No för att stänga av.", str, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(logik.alternate % 2 == 0 && logik.likaTest != 144) {
						int tmp = Integer.parseInt(WinCountX.getText());
						WinCountX.setText(Integer.toString(tmp+1));
					} else if (logik.alternate % 2 != 0 && logik.likaTest != 144){
						int tmp = Integer.parseInt(WinCountO.getText());
						WinCountO.setText(Integer.toString(tmp+1));
					}
					//0 = yes, 1=no, 2=cancel
					if (svar == JOptionPane.YES_OPTION) {
						//Reset game
						for (int i = 0; i < 10; i++) {
							button[i].setText("   ");
							button[i].setEnabled(true);
							button[i].setBackground(null);
							TurnLabel.setText("<html>Turn: <font color='red'>X</font></html>");
							logik.Reset();
						}
					} else if (svar == JOptionPane.NO_OPTION){
						System.exit(svar);
					}
					else {
						System.out.println("Nothing chosen");
					}
				}
			}
		});
	}
}
