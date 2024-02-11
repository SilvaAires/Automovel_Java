package automovel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 */
	
	private void irTelacadastro() {
		this.setContentPane(new TelaCadastro());
		this.setVisible(true);
	}
	
	private void irTelaconsulta() {
		this.setContentPane(new TelaConsulta());
		this.setVisible(true);
	}
	
	private void irTelaaltera() {
		this.setContentPane(new TelaAltera());
		this.setVisible(true);
	}
	
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("A\u00C7\u00D5ES");
		menuBar.add(mnNewMenu);
		
		JMenuItem menucadastro = new JMenuItem("CADASTRAR");
		menucadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irTelacadastro();
			}

		
		});
		mnNewMenu.add(menucadastro);
		
		JMenuItem menuconsulta = new JMenuItem("CONSULTAR");
		menuconsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irTelaconsulta();
			}
		});
		mnNewMenu.add(menuconsulta);
		
		JMenuItem menualterar = new JMenuItem("ALTERAR/EXCLUIR");
		menualterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irTelaaltera();
			}
		});
		mnNewMenu.add(menualterar);
	}

}
