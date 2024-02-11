package automovel;


import javax.swing.JPanel;


import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class TelaConsulta extends JPanel {
	private JTable table;
	private JComboBox combotipopesquisa;
	private JComboBox combodados;
	
	private void consultarTipo() {
	    AutomovelDao dao = new AutomovelDao();
	    LinkedList<Automovel> lista = new LinkedList<>();// = dao.listarNomesAtributos();
	    combotipopesquisa.addItem("Selecione um atributo: ");
	    if (!lista.isEmpty()) {
	        Automovel auto = lista.getFirst();
	        combotipopesquisa.addItem(auto.getModelo());
	        combotipopesquisa.addItem(auto.getMarca());
	        combotipopesquisa.addItem(auto.getAno());
	    }
	}
	
	private void acaoSelecionaPesquisa() {
		AutomovelDao dao = new AutomovelDao();		
		LinkedList<String> dadosCombo = null;
		combodados.removeAllItems();
		//combodados.addItem("Selecione: ");
		if((combotipopesquisa.getSelectedItem()+"").equals("Marca")) {
			
			dadosCombo = dao.listarMarcas();
		}else {
			if((combotipopesquisa.getSelectedItem()+"").equals("Modelo")) {
				
				dadosCombo = dao.listarModelos();
			}else {
				
				dadosCombo = dao.listarAnos();
			}
		}		
		
		
		for (String item : dadosCombo) {
			combodados.addItem(item);
		}
		
		
		//combodados.
		
	}
	public void acaoCombo() {
		
		//if(!combodados.getSelectedItem().equals("Selecione: ")) {
		LinkedList<Automovel> selecionados = null;
		AutomovelDao dao = new AutomovelDao();
		
		String dado = combodados.getSelectedItem()+"";
		
		if((combotipopesquisa.getSelectedItem()+"").equals("Marca")) {
			System.out.println(dado);
			selecionados = dao.procurarMarca(dado);
			
		}else {
			if((combotipopesquisa.getSelectedItem()+"").equals("Modelo")) {
			
				selecionados = dao.procurarModelo(dado);
			}else {
				//String[] dados = dado.split("\n");
				//String ano = dado.substring(dado.length()-4, dado.length()-1);
				//System.out.println(dado);
				
				selecionados = dao.procurarAno(Integer.parseInt(dado));
			}
		}		
		
		
		
		if(selecionados != null) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();		
	//if((selecionado).equals()) {
		while(model.getRowCount() > 0) {
			model.removeRow(0);
		}
		for (Automovel automovel : selecionados) {
			model.addRow(automovel.toTabela());	
		}
		}
		//}
			//	selecionado = dao.procurarModelo(combodados.getSelectedItem()+"");
		//	}//else if ((combodados.getSelectedItem()+"").equals(selecionado)){
				
			//}
			
			
				
		}
		
			
		
		
	

	public TelaConsulta() {
		setLayout(new MigLayout("", "[95.00,grow][257.00][393.00][162.00,grow]", "[][][][grow][]"));
		
		JLabel lblescolhertipo = new JLabel("ESCOLHA O TIPO DA PESQUISA:");
		add(lblescolhertipo, "cell 1 1,alignx center");
		
		combotipopesquisa = new JComboBox();
		this.combotipopesquisa.setModel(new DefaultComboBoxModel(new String[] {"Marca", "Modelo", "Ano de Fabrica\u00E7\u00E3o"}));
		combotipopesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoSelecionaPesquisa();
			}
		});
		add(combotipopesquisa, "cell 2 1,growx");
		
		JLabel lbldados = new JLabel("ESCOLHA O DADO:");
		add(lbldados, "cell 1 2,alignx trailing");
		
		combodados = new JComboBox();
		combodados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoCombo();
			}
		});
		add(combodados, "cell 2 2,growx");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 3 2 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ID", "MARCA", "MODELO", "ANO"
			}
		));
		scrollPane.setViewportView(table);
		
		
		acaoSelecionaPesquisa();

	}
	
	

}
