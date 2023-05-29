package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class contatoDAO {
    private Connection con;

    public contatoDAO() {
        con = new conectar().conectar();
    }

    public ArrayList<Livro> listar() {
        String sql = "SELECT * FROM livraria";
        ArrayList<Livro> livraria;
        livraria = new ArrayList<Livro>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Livro l = new Livro();
                l.setId(rs.getInt("id"));
                l.setAutor(rs.getString("autor"));
                l.setNomeLivro(rs.getString("nomelivro"));
                l.setRegistro(rs.getString("registro"));
                livraria.add(l);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return livraria;
    }

    public void inserir(Livro l) {
        String sql = "INSERT INTO livraria(autor,nomeLivro,registro) VALUE(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(2, l.getNomeLivro());
            ps.setString(1, l.getAutor());
            ps.setString(3, l.getRegistro());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizar(Livro l) {
        String sql = "UPDATE contato SET nome=?,email=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, l.getId());
            ps.setString(2, l.getNomeLivro());
            ps.setString(3, l.getAutor());
            ps.setString(4, l.getRegistro());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Contato atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void excluir(Livro l) {
        String sql = "DELETE FROM contato WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, l.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Contato excluido com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
