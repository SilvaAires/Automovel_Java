package automovel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;



public class AutomovelDao {
     
	private Connection conexao;
	
	public AutomovelDao() {
		this.conexao = Conexao.getConexao();
	}
	
	public void adicionar(Automovel automovel) {
		String sql = "insert into automovel (marca, modelo, ano) values (?,?,?)";
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1, automovel.getMarca());
			stmt.setString(2, automovel.getModelo());
			stmt.setInt(3, automovel.getAno());
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*public LinkedList<Automovel> listar(String marca) {
		String sql = "select * from automovel where marca like ?";
		
		try {
			
			LinkedList<Automovel> automoveis = new LinkedList<Automovel>();
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1, '%' + marca + '%');
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {				
				Automovel automovel = new Automovel(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"));
				automovel.setId(rs.getInt("id"));
				automoveis.add(automovel);
			}
			
			rs.close();
			stmt.close();
			return automoveis;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/
	
	public LinkedList<String> listarMarcas() {
		String sql = "select marca from automovel";
		try {
			LinkedList<String> marcas = new LinkedList<String>();
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				marcas.add(rs.getString("marca"));				
			}
			rs.close();
			stmt.close();
			return marcas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	public LinkedList<String> listarAnos() {
		String sql = "select ano from automovel";
		try {
			LinkedList<String> marcas = new LinkedList<String>();
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				marcas.add(rs.getString("ano"));				
			}
			rs.close();
			stmt.close();
			return marcas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}

	public LinkedList<String> listarModelos() {
		String sql = "select modelo from automovel";
		try {
			LinkedList<String> marcas = new LinkedList<String>();
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				marcas.add(rs.getString("modelo"));				
			}
			rs.close();
			stmt.close();
			return marcas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	public LinkedList<Automovel> listar() {
		String sql = "select * from automovel";
		
		try {
			LinkedList<Automovel> funcionarios = new LinkedList<Automovel>();
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto Funcionario
				Automovel a = new Automovel(rs.getString("Marca"), rs.getString("Modelo"), rs.getInt("Ano"));
				a.setId(rs.getInt("id"));				

				// Adicionando o objeto � lista
				funcionarios.add(a);
			}
			rs.close();
			stmt.close();
			return funcionarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

	public LinkedList<Automovel> procurarMarca(String marca) {
		String sql = "select * from automovel where marca = ?";	
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1,  marca);
			ResultSet rs = stmt.executeQuery();
			LinkedList<Automovel> lista = new LinkedList<Automovel>();
			Automovel automovel = null;
			while(rs.next()) {
				
				automovel = new Automovel(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"));
				automovel.setId(rs.getInt("id"));
				lista.add(automovel);
				
			}
			rs.close();
			stmt.close();
			return lista;			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public LinkedList<Automovel> procurarModelo(String modelo) {
		String sql = "select * from automovel where modelo like ?";	
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1,  modelo);
			ResultSet rs = stmt.executeQuery();
			LinkedList<Automovel> lista = new LinkedList<Automovel>();
			Automovel automovel = null;
			if(rs.next()) {
				automovel = new Automovel(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"));
				automovel.setId(rs.getInt("id"));
				lista.add(automovel);
			}
			rs.close();
			stmt.close();
			return lista;			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public LinkedList<Automovel> procurarAno(int ano) {
		String sql = "select * from automovel where ano = ?";	
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1,  ano);
			ResultSet rs = stmt.executeQuery();
			LinkedList<Automovel> lista = new LinkedList<Automovel>();
			Automovel automovel = null;
			if(rs.next()) {
				automovel = new Automovel(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"));
				automovel.setId(rs.getInt("id"));
				lista.add(automovel);
			}
			rs.close();
			stmt.close();
			return lista;			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}































