package mx.com.conversorDeMonedas.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6650588039976056234L;
	private JPanel panelPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Challenge Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JButton btnConversorT = new JButton("");
		btnConversorT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConversorTemperaturas conversorTemperaturas = new ConversorTemperaturas();
				conversorTemperaturas.setVisible(true); 
				dispose();
			}
		});
		
		btnConversorT.setIcon(new ImageIcon(Menu.class.getResource("/mx/com/conversorDeMonedas/GUI/TermometroEscala.png")));
		btnConversorT.setBounds(244, 81, 120, 120);
		panelPrincipal.add(btnConversorT);
		
		JButton btnConversorM = new JButton("");
		btnConversorM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConversorMonedas conversorMonedas = new ConversorMonedas();
				conversorMonedas.setVisible(true); 
				dispose();
			}
		});
		btnConversorM.setIcon(new ImageIcon(Menu.class.getResource("/mx/com/conversorDeMonedas/GUI/MonedasEscala.png")));
		btnConversorM.setBounds(66, 81, 120, 120);
		panelPrincipal.add(btnConversorM);
		
		JLabel lblTitulo = new JLabel("Seleccione una opción: ");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(10, 11, 414, 42);
		panelPrincipal.add(lblTitulo);
		
		JLabel lblConvMond = new JLabel("Conversor de Monedas");
		lblConvMond.setHorizontalAlignment(SwingConstants.CENTER);
		lblConvMond.setBounds(66, 212, 120, 23);
		panelPrincipal.add(lblConvMond);
		
		JLabel lblConversorDeTemperatura = new JLabel("Conversor de Temperatura");
		lblConversorDeTemperatura.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversorDeTemperatura.setBounds(244, 212, 130, 23);
		panelPrincipal.add(lblConversorDeTemperatura);
	}

}
