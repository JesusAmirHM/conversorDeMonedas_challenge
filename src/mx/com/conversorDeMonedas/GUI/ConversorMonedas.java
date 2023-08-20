package mx.com.conversorDeMonedas.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mx.com.conversorDeMonedas.modelo.ConversorDeMonedas;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class ConversorMonedas extends JFrame {

	/**
	 * Declaraciones
	 */
	private static final long serialVersionUID = -2040510370118377413L;
	private JPanel panelInicial;
	private JTextField textValor;
	private JComboBox<String> comboBox;
	private JTextField textResultado;
	private JLabel lblResultado;
	
	public String[] cambios = {
			"Peso Mexicano (MXN) a Dólar Estadounidense (USD)",
			"Peso Mexicano (MXN) a Euro (EUR)",
			"Peso Mexicano (MXN) a Libra Esterlina (GBP)",
			"Peso Mexicano (MXN) a Yen Japones (JPY)",
			"Peso Mexicano (MXN) a Won Sur Coreano (KRW)",
			"Dólar Estadounidense (USD) a Peso Mexicano (MXN)",
			"Euro (EUR) a Peso Mexicano (MXN)",
			"Libra Esterlina (GBP) a Peso Mexicano (MXN)",
			"Yen Japones (JPY) a Peso Mexicano (MXN)", 
			"Won Sur Coreano (KRW) a Peso Mexicano (MXN)"
			};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorMonedas frame = new ConversorMonedas();
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
	public ConversorMonedas() {
		setTitle("Conversor de Monedas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 394);
		panelInicial = new JPanel();
		panelInicial.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelInicial);
		panelInicial.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Monedas");
		lblTitulo.setBounds(186, 11, 347, 33);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 24));
		panelInicial.add(lblTitulo);
		
		
		comboBox = new JComboBox<String>(cambios);
		comboBox.setBounds(175, 81, 312, 22);
		panelInicial.add(comboBox);
		
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
		textValor.setBounds(175, 147, 205, 26);
		panelInicial.add(textValor);
		textValor.setColumns(10);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				convertir();
			}
		});
		btnConvertir.setBounds(390, 148, 97, 26);
		panelInicial.add(btnConvertir);
		
		JLabel lblCantidad = new JLabel("Inserte cantidad:");
		lblCantidad.setBounds(175, 110, 315, 26);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelInicial.add(lblCantidad);
		
		JLabel lblMonedas = new JLabel("¿Qué desea convertir?");
		lblMonedas.setBounds(176, 55, 311, 27);
		lblMonedas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelInicial.add(lblMonedas);
		
		JPanel panel = new JPanel();
		panel.setBounds(3, 0, 164, 355);
		panel.setBackground(new Color(0, 139, 139));
		panelInicial.add(panel);
		
		JLabel lblImagenMonedas = new JLabel("");
		lblImagenMonedas.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenMonedas.setBounds(0, 44, 164, 252);
		ImageIcon ico = new ImageIcon(getClass().getResource("/mx/com/conversorDeMonedas/GUI/MonedasConversor.png"));
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblImagenMonedas.getWidth(), lblImagenMonedas.getHeight(), Image.SCALE_SMOOTH));
		panel.setLayout(null);
		lblImagenMonedas.setIcon(img);
		panel.add(lblImagenMonedas);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true); 
				dispose();
			}
		});
		btnHome.setIcon(new ImageIcon(ConversorMonedas.class.getResource("/mx/com/conversorDeMonedas/GUI/home.png")));
		btnHome.setBounds(10, 11, 23, 23);
		panel.add(btnHome);
		
		lblResultado = new JLabel("Conversión");
		lblResultado.setHorizontalAlignment(SwingConstants.LEFT);
		lblResultado.setBounds(391, 216, 152, 27);
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelInicial.add(lblResultado);
		
		textResultado = new JTextField();
		textResultado.setBounds(175, 220, 205, 22);
		panelInicial.add(textResultado);
		textResultado.setColumns(10);
		
	}
	
	/**
	 * Formato de los resultados
	 * @param valor
	 * @return
	 */
	public String redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.000");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}
	
	/**
	 * Metodo Convertir: Seleccionar el tipo de resultado deseado y lee el textFiled
	 *  para posteriormente calcular su conversión en las diversas escalas de temperatura
	 */
	public void convertir() {
		Integer monedas = comboBox.getSelectedIndex();
		double cantidadDinero = Double.parseDouble(textValor.getText());
		ConversorDeMonedas conversor = new ConversorDeMonedas();
		
		switch (monedas) {
		case 0: 
			double pesosDolar = conversor.pesosMexADolarUS(cantidadDinero);
			textResultado.setText(String.valueOf(redondear(pesosDolar)));
			lblResultado.setText(" USD");
			break;
		case 1: 
			double pesosEuro  = conversor.pesosMexAEuro(cantidadDinero);
			textResultado.setText(String.valueOf(redondear(pesosEuro)));
			lblResultado.setText(" EUR");
			break;
		case 2: 
			double pesosLibrasE = conversor.pesosMexALibrasE(cantidadDinero);
			textResultado.setText(String.valueOf(redondear(pesosLibrasE)));
			lblResultado.setText(" GBP");
			break;
		case 3: 
			double pesosYen = conversor.pesosMexAYen(cantidadDinero);
			textResultado.setText(String.valueOf(redondear(pesosYen)));
			lblResultado.setText(" JPY");
			break;
		case 4: 
			double  pesosWon= conversor.pesosMexAWon(cantidadDinero);
			textResultado.setText(String.valueOf(redondear(pesosWon)));
			lblResultado.setText(" KRW");
			break;
		case 5: 
			double  dolarPesos= conversor.dolarUSAPesosMex(cantidadDinero);
			textResultado.setText(String.valueOf(redondear(dolarPesos)));
			lblResultado.setText(" MXN");
			break;
		case 6: 
			double  euroPesos= conversor.euroAPesosMex(cantidadDinero);
			textResultado.setText(String.valueOf(redondear(euroPesos)));
			lblResultado.setText(" MXN");
			break;
		case 7: 
			double librasPesos = conversor.libraEAPesosMex(cantidadDinero);
			textResultado.setText(String.valueOf(redondear(librasPesos)));
			lblResultado.setText(" MXN");
			break;
		case 8: 
			double yenPesos = conversor.yenAPesosMex(cantidadDinero);
			textResultado.setText(String.valueOf(redondear(yenPesos)));
			lblResultado.setText(" MXN");
			break;
		case 9: 
			double wonPesos = conversor.wonAPesosMex(cantidadDinero);
			textResultado.setText(String.valueOf(redondear(wonPesos)));
			lblResultado.setText(" MXN");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + monedas);
		}
	}
	
}
