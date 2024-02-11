package automovel;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JPanel {
	private JTextField txtmarca;
	private JTextField txtmodelo;
	private JTextField txtano;
	
	
	private void cadastro() {
		AutomovelDao dao = new AutomovelDao();
		Automovel automovel = new Automovel();
		automovel.setMarca(txtmarca.getText());
		automovel.setModelo(txtmodelo.getText());
		int ano = Integer.parseInt(txtano.getText());
		automovel.setAno(ano);
		dao.adicionar(automovel);
		
	}
	
	

	public TelaCadastro() {
		setLayout(new MigLayout("", "[grow][grow,center][grow][grow][grow]", "[grow][][grow][][grow][][][grow]"));
		
		JLabel lblmarca = new JLabel("MARCA");
		add(lblmarca, "cell 1 1,alignx center");
		
		txtmarca = new JTextField();
		add(txtmarca, "cell 2 1,growx");
		txtmarca.setColumns(10);
		
		JLabel lblmodelo = new JLabel("MODELO");
		add(lblmodelo, "cell 1 3,alignx center");
		
		txtmodelo = new JTextField();
		add(txtmodelo, "cell 2 3,growx");
		txtmodelo.setColumns(10);
		
		JLabel lblano = new JLabel("ANO");
		add(lblano, "cell 1 5,alignx center");
		
		txtano = new JTextField();
		add(txtano, "cell 2 5,growx");
		txtano.setColumns(10);
		
		JButton btcadastra = new JButton("CADASTRAR");
		btcadastra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastro();
			}
		});
		btcadastra.setBackground(Color.PINK);
		add(btcadastra, "cell 2 7,grow");

	}

}
