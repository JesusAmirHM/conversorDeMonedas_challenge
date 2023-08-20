package mx.com.conversorDeMonedas.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.ImageIcon;

import mx.com.conversorDeMonedas.modelo.ConversorDeTemperatura;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;

import javax.swing.DefaultComboBoxModel;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ConversorTemperaturas extends JFrame {

	/**
	 * Declaraciones
	 */
	private static final long serialVersionUID = -8194037834102682582L;
	private JPanel panelPrincipal;
	private JTextField textValor;
	private JLabel lblResultado1;
	private JLabel lblResultado2;
	private JLabel lblResultado3;
	private JTextArea textResultado1;
	private JTextArea textResultado2;
	private JTextArea textResultado3;
	private JComboBox<String> comboBox;
	
	public String[] escalas = {
			"Celsius (C)",
			"Kelvin (K)",
			"Fahrenheith(F)",
			"Rankine (R)"
			};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorTemperaturas frame = new ConversorTemperaturas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConversorTemperaturas() {
		setTitle("Conversor de Temperaturas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 394);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Temperaturas");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblTitulo.setBounds(186, 11, 347, 33);
		panelPrincipal.add(lblTitulo);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<>(escalas));
		comboBox.setBounds(175, 82, 312, 22);
		panelPrincipal.add(comboBox);
		
		
		textValor = new JTextField();
		textValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE && c != '-') {
					e.consume();
					JOptionPane.showMessageDialog(null, "Valor inválido");
				}
				if (c == '.' && textValor.getText().contains(".")) {
					e.consume();
					JOptionPane.showMessageDialog(null, "Valor inválido");
				}
			}
		});
		
		textValor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textValor.setBounds(175, 147, 207, 26);
		panelPrincipal.add(textValor);
		textValor.setColumns(10);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				convertir();
			}
		});
		btnConvertir.setBounds(392, 148, 95, 26);
		panelPrincipal.add(btnConvertir);
		
		JLabel lblTemp1 = new JLabel("Inserte temperatura:");
		lblTemp1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTemp1.setBounds(175, 111, 315, 26);
		panelPrincipal.add(lblTemp1);
		
		JLabel lblEscalas = new JLabel("¿Qué desea convertir?");
		lblEscalas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEscalas.setBounds(176, 55, 311, 27);
		panelPrincipal.add(lblEscalas);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(3, 0, 164, 355);
		panelPrincipal.add(panel);
		
		JLabel lblImagenTemp = new JLabel("");
		lblImagenTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenTemp.setBounds(0, 78, 164, 191);
		ImageIcon ico = new ImageIcon(getClass().getResource("/mx/com/conversorDeMonedas/GUI/Termometro.png"));
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblImagenTemp.getWidth(), lblImagenTemp.getHeight(), Image.SCALE_SMOOTH));
		panel.setLayout(null);
		lblImagenTemp.setIcon(img);
		panel.add(lblImagenTemp);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true); 
				dispose();
			}
		});
		btnHome.setIcon(new ImageIcon(ConversorTemperaturas.class.getResource("/mx/com/conversorDeMonedas/GUI/home.png")));
		btnHome.setBounds(10, 11, 23, 23);
		panel.add(btnHome);
		
		lblResultado1 = new JLabel("Conversión 1");
		lblResultado1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResultado1.setBounds(335, 221, 152, 27);
		panelPrincipal.add(lblResultado1);
		
		lblResultado2 = new JLabel("Conversión 2");
		lblResultado2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResultado2.setBounds(335, 257, 152, 27);
		panelPrincipal.add(lblResultado2);
		
		lblResultado3 = new JLabel("Conversión 3");
		lblResultado3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResultado3.setBounds(335, 295, 152, 27);
		panelPrincipal.add(lblResultado3);
		
		textResultado1 = new JTextArea();
		textResultado1.setBounds(184, 224, 141, 22);
		panelPrincipal.add(textResultado1);
		
		textResultado2 = new JTextArea();
		textResultado2.setBounds(184, 260, 141, 22);
		panelPrincipal.add(textResultado2);
		
		textResultado3 = new JTextArea();
		textResultado3.setBounds(184, 298, 141, 22);
		panelPrincipal.add(textResultado3);
		
	}

	/**
	 * Formato de los resultados
	 * @param valor
	 * @return
	 */
	public String redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.000000");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}
	
	
	/**
	 * Metodo Convertir: Seleccionar el tipo de resultado deseado y lee el textFiled
	 *  para posteriormente calcular su conversión en las diversas escalas de temperatura
	 */
	public void convertir() {
		Integer escala = comboBox.getSelectedIndex();
		double temperatura = Double.parseDouble(textValor.getText());
		ConversorDeTemperatura conversor = new ConversorDeTemperatura();
		
		switch (escala) {
		case 0: 
			double ctk = conversor.celsiusToKelvin(temperatura);
			textResultado1.setText(String.valueOf(redondear(ctk)));
			lblResultado1.setText(" K");
			
			double ctf = conversor.celsiusToFahrenheith(temperatura);
			textResultado2.setText(String.valueOf(redondear(ctf)));
			lblResultado2.setText(" F");
			
			double ctr = conversor.celsiusToRankine(temperatura);
			textResultado3.setText(String.valueOf(redondear(ctr)));
			lblResultado3.setText(" R");
			break;
		case 1: 
			double ktc = conversor.kelvinToCelsius(temperatura);
			textResultado1.setText(String.valueOf(redondear(ktc)));
			lblResultado1.setText(" C");
			
			double ktf = conversor.kelvinToFahrenheit(temperatura);
			textResultado2.setText(String.valueOf(redondear(ktf)));
			lblResultado2.setText(" F");
			
			double ktr = conversor.kelvinToRankine(temperatura);
			textResultado3.setText(String.valueOf(redondear(ktr)));
			lblResultado3.setText(" R");
			break;
		case 2: 
			double ftc = conversor.fahrenheitToCelsius(temperatura);
			textResultado1.setText(String.valueOf(redondear(ftc)));
			lblResultado1.setText(" C");
			
			double ftk = conversor.fahrenheitToKelvin(temperatura);
			textResultado2.setText(String.valueOf(redondear(ftk)));
			lblResultado2.setText(" K");
			
			double ftr = conversor.fahrenheitToRankine(temperatura);
			textResultado3.setText(String.valueOf(redondear(ftr)));
			lblResultado3.setText(" R");
			break;
		case 3: 
			double rtc = conversor.rankineToCelsius(temperatura);
			textResultado1.setText(String.valueOf(redondear(rtc)));
			lblResultado1.setText(" C");
			
			double rtk = conversor.rankineToKelvin(temperatura);
			textResultado2.setText(String.valueOf(redondear(rtk)));
			lblResultado2.setText(" K");
			
			double rtf = conversor.rankineToFahrenheit(temperatura);
			textResultado3.setText(String.valueOf(redondear(rtf)));
			lblResultado3.setText(" F");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + escala);
		}
	}
}
