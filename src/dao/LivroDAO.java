package dao;

import model.Livro;
import util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    public void create(Livro l) throws SQLException {
        String sql = "INSERT INTO livro (titulo, ano_publicacao, qtd_disponivel) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, l.getTitulo());
            stmt.setInt(2, l.getAnoPublicacao());
            stmt.setInt(3, l.getQtdDisponivel());
            stmt.executeUpdate();
        }
    }

    public List<Livro> read() throws SQLException {
        String sql = "SELECT * FROM livro";
        List<Livro> livros = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                livros.add(new Livro(
                    rs.getInt("id_livro"),
                    rs.getString("titulo"),
                    rs.getInt("ano_publicacao"),
                    rs.getInt("qtd_disponivel")
                ));
            }
        }
        return livros;
    }

    public void update(Livro l) throws SQLException {
        String sql = "UPDATE livro SET titulo=?, ano_publicacao=?, qtd_disponivel=? WHERE id_livro=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, l.getTitulo());
            stmt.setInt(2, l.getAnoPublicacao());
            stmt.setInt(3, l.getQtdDisponivel());
            stmt.setInt(4, l.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM livro WHERE id_livro=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
