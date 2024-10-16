import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Czworokat extends JFrame {
	int margin_left = 10;
	String selected_menu = "kwadrat";
	JPanel main_panel = new JPanel(null);
	JLabel text_a = new JLabel("a:");
	JTextField input_a = new JTextField();
	JLabel text_b = new JLabel("b:");
	JTextField input_b = new JTextField();
	JLabel text_c = new JLabel("c:");
	JTextField input_c = new JTextField();
	JLabel pole_wynik = new JLabel("Pole = ");
	JLabel obwod_wynik = new JLabel("Obwód = ");
	DrawGraphics graphic_panel = new DrawGraphics();
	JMenuBar menu_bar = new JMenuBar();
	JMenu menu = new JMenu("Czworokąt");
	JMenuItem kwadrat,prostokat,romb,rownoleglobok,trapez;
	ActionListener listener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == kwadrat){
				text_b.setVisible(false);
				input_b.setVisible(false);
				text_c.setVisible(false);
				input_c.setVisible(false);
				graphic_panel.typ_figury=1;
				graphic_panel.repaint();
				selected_menu = "kwadrat";
			}
			if(e.getSource() == prostokat){
				text_b.setText("b:");
				text_b.setVisible(true);
				input_b.setVisible(true);
				text_c.setVisible(false);
				input_c.setVisible(false);
				graphic_panel.typ_figury=2;
				graphic_panel.repaint();
				selected_menu = "prostokat";
			}
			if(e.getSource() == romb) {
				text_b.setText("h:");
				text_b.setVisible(true);
				input_b.setVisible(true);
				text_c.setVisible(false);
				input_c.setVisible(false);
				graphic_panel.typ_figury=3;
				graphic_panel.repaint();
				selected_menu = "romb";
			}
			if(e.getSource() == rownoleglobok) {
				text_b.setText("b:");
				text_c.setText("h:");
				text_b.setVisible(true);
				input_b.setVisible(true);
				text_c.setVisible(true);
				input_c.setVisible(true);
				graphic_panel.typ_figury=4;
				graphic_panel.repaint();
				selected_menu = "rownoleglobok";
			}
			if(e.getSource() == trapez){
				text_b.setText("b:");
				text_c.setText("h:");
				text_b.setVisible(true);
				input_b.setVisible(true);
				text_c.setVisible(true);
				input_c.setVisible(true);
				graphic_panel.typ_figury=5;
				graphic_panel.repaint();
				selected_menu = "trapez";
			}
		}
	};
	KeyListener keylistener = new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char character = e.getKeyChar();
			if (!((character >= '0') && (character <= '9') || (character == KeyEvent.VK_BACK_SPACE) || (character == KeyEvent.VK_DELETE) || (character == KeyEvent.VK_PERIOD))) {
				e.consume();
			}
		}
	};
	DocumentListener doc_listener = new DocumentListener() {
		@Override
		public void insertUpdate(DocumentEvent e) {
			if (selected_menu == "kwadrat"){
				countKwadrat(e);
			}
			if (selected_menu == "prostokat"){
				countProstokat(e);
			}
			if (selected_menu == "romb"){
				countRomb(e);
			}
			if (selected_menu == "rownoleglobok"){
				countRownoleglobok(e);
			}
			if (selected_menu == "trapez"){
				countTrapez(e);
			}
		}
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			if (selected_menu == "kwadrat"){
				countKwadrat(e);
			}
			if (selected_menu == "prostokat"){
				countProstokat(e);
			}
			if (selected_menu == "romb"){
				countRomb(e);
			}
			if (selected_menu == "rownoleglobok"){
				countRownoleglobok(e);
			}
			if (selected_menu == "trapez"){
				countTrapez(e);
			}
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			if (selected_menu == "kwadrat"){
				countKwadrat(e);
			}
			if (selected_menu == "prostokat"){
				countProstokat(e);
			}
			if (selected_menu == "romb"){
				countRomb(e);
			}
			if (selected_menu == "rownoleglobok"){
				countRownoleglobok(e);
			}
			if (selected_menu == "trapez"){
				countTrapez(e);
			}
		}
	};
	public Czworokat() {
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(300,200);
		initComponents();
		setContentPane(main_panel);
	}
	
	private void initComponents() {
		main_panel.setBounds(0,0,300,200);
		main_panel.setBackground(Color.LIGHT_GRAY);
		graphic_panel.setLocation(180,20);
		main_panel.add(graphic_panel);
		text_a.setBounds(margin_left,20,20,20);
		text_b.setBounds(margin_left,65,20,20);
		text_c.setBounds(margin_left,110,20,20);
		input_a.setBounds(margin_left+10,20,100,20);
		input_b.setBounds(margin_left+10,65,100,20);
		input_c.setBounds(margin_left+10,110,100,20);
		input_a.addKeyListener(keylistener);
		input_b.addKeyListener(keylistener);
		input_c.addKeyListener(keylistener);
		input_a.getDocument().addDocumentListener(doc_listener);
		input_b.getDocument().addDocumentListener(doc_listener);
		input_c.getDocument().addDocumentListener(doc_listener);
		pole_wynik.setBounds(margin_left+140,90,120,20);
		obwod_wynik.setBounds(margin_left+140,110,120,20);
		text_b.setVisible(false);
		input_b.setVisible(false);
		text_c.setVisible(false);
		input_c.setVisible(false);
		main_panel.add(text_a);
		main_panel.add(text_b);
		main_panel.add(text_c);
		main_panel.add(input_a);
		main_panel.add(input_b);
		main_panel.add(input_c);
		main_panel.add(pole_wynik);
		main_panel.add(obwod_wynik);
		initMenu();
	}
	private void initMenu() {
		kwadrat = new JMenuItem("kwadrat");
		kwadrat.setSelected(true);
		prostokat = new JMenuItem("prostokąt");
		romb = new JMenuItem("romb");
		rownoleglobok = new JMenuItem("równoległobok");
		trapez = new JMenuItem("trapez");
		kwadrat.addActionListener(listener);
		prostokat.addActionListener(listener);
		romb.addActionListener(listener);
		rownoleglobok.addActionListener(listener);
		trapez.addActionListener(listener);
		menu.add(kwadrat);
		menu.add(prostokat);
		menu.add(romb);
		menu.add(rownoleglobok);
		menu.add(trapez);
		menu_bar.add(menu);
		setJMenuBar(menu_bar);
	}
	private void countKwadrat(DocumentEvent e) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				if (!input_a.getText().isEmpty()) {
					float pole = Float.parseFloat(input_a.getText()) * Float.parseFloat(input_a.getText());
					float obwod = Float.parseFloat(input_a.getText()) * 4;
					pole_wynik.setText("Pole = " + String.valueOf(pole));
					obwod_wynik.setText("Obwód = " + String.valueOf(obwod));
				}
			}
		});
	}
	private void countProstokat(DocumentEvent e) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				if (!(input_a.getText().isEmpty() || input_b.getText().isEmpty())) {
					float pole = Float.parseFloat(input_a.getText()) * Float.parseFloat(input_b.getText());
					float obwod = 2 * (Float.parseFloat(input_a.getText()) + Float.parseFloat(input_b.getText()));
					pole_wynik.setText("Pole = " + String.valueOf(pole));
					obwod_wynik.setText("Obwód = " + String.valueOf(obwod));
				}
			}
		});
	}
	private void countRomb(DocumentEvent e) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					if (!(input_a.getText().isEmpty() || input_b.getText().isEmpty())) {
						float pole = Float.parseFloat(input_a.getText()) * Float.parseFloat(input_b.getText());
						float obwod = 4 * Float.parseFloat(input_a.getText());
						pole_wynik.setText("Pole = " + String.valueOf(pole));
						obwod_wynik.setText("Obwód = " + String.valueOf(obwod));
					}
				}
			});
	}
	private void countRownoleglobok(DocumentEvent e) {
				java.awt.EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						if (!(input_a.getText().isEmpty() || input_b.getText().isEmpty() || input_c.getText().isEmpty())) {
							float pole = Float.parseFloat(input_a.getText()) * Float.parseFloat(input_c.getText());
							float obwod = 2 * (Float.parseFloat(input_a.getText()) + Float.parseFloat(input_b.getText()));
							pole_wynik.setText("Pole = " + String.valueOf(pole));
							obwod_wynik.setText("Obwód = " + String.valueOf(obwod));
						}
					}
				});
	}
	private void countTrapez(DocumentEvent e) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				if (!(input_a.getText().isEmpty() || input_b.getText().isEmpty() || input_c.getText().isEmpty())) {
					float pole = ((Float.parseFloat(input_a.getText()) + Float.parseFloat(input_b.getText()))/2)*Float.parseFloat(input_c.getText());
					float obwod = Float.parseFloat(input_a.getText()) + Float.parseFloat(input_b.getText()) + 2*Float.parseFloat(input_c.getText());
					pole_wynik.setText("Pole = " + String.valueOf(pole));
					obwod_wynik.setText("Obwód = " + String.valueOf(obwod));
				}
			}
		});
	}
	public static void main(String[] args) {
		new Czworokat();
	}
}
class DrawGraphics extends JPanel {
	private static int baseX = 5;
	private static int baseY = 5;
	int typ_figury = 1;
	public DrawGraphics() {
		setSize(100,70);
		setBackground(Color.LIGHT_GRAY);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		switch (typ_figury) {
			case 1:
				drawSquare(g2);
				break;
			case 2:
				drawRect(g2);
				break;
			case 3:
				drawRomb(g2);
				break;
			case 4:
				drawRownoleglobok(g2);
				break;
			case 5:
				drawTrapez(g2);
				break;
		}
	}
	private void drawSquare(Graphics2D g){
		g.drawLine(baseX,baseY,baseX+50,baseY);
		g.drawLine(baseX+50,baseY,baseX+50,baseY+50);
		g.drawLine(baseX,baseY+50,baseX+50,baseY+50);
		g.drawLine(baseX,baseY,baseX,baseY+50);
	}
	private void drawRect(Graphics2D g){
		g.drawLine(baseX,baseY,baseX+70,baseY);
		g.drawLine(baseX+70,baseY,baseX+70,baseY+50);
		g.drawLine(baseX,baseY+50,baseX+70,baseY+50);
		g.drawLine(baseX,baseY,baseX,baseY+50);
	}
	private void drawRomb(Graphics2D g){
		g.drawLine(baseX+20,baseY,baseX+70,baseY);
		g.drawLine(baseX+70,baseY,baseX+50,baseY+50);
		g.drawLine(baseX,baseY+50,baseX+50,baseY+50);
		g.drawLine(baseX+20,baseY,baseX,baseY+50);
	}
	private void drawRownoleglobok(Graphics2D g){
		g.drawLine(baseX+20,baseY,baseX+90,baseY);
		g.drawLine(baseX+90,baseY,baseX+70,baseY+50);
		g.drawLine(baseX,baseY+50,baseX+70,baseY+50);
		g.drawLine(baseX+20,baseY,baseX,baseY+50);
	}
	private void drawTrapez(Graphics2D g) {
		g.drawLine(baseX+20,baseY,baseX+70,baseY);
		g.drawLine(baseX+70,baseY,baseX+90,baseY+50);
		g.drawLine(baseX,baseY+50,baseX+90,baseY+50);
		g.drawLine(baseX+20,baseY,baseX,baseY+50);
	}
}