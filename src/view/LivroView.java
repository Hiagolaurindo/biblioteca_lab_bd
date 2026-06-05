package view;

import dao.LivroDAO;
import model.Livro;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class LivroView extends JFrame {
    private LivroDAO dao = new LivroDAO();
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtTitulo, txtAno, txtQtd;

    public LivroView() {
        setTitle("Gerenciar Livros");
        setSize(600, 400);
        setLayout(new BorderLayout());

        JPanel pnlInput = new JPanel(new GridLayout(4, 2));
        pnlInput.add(new JLabel("Título:"));
        txtTitulo = new JTextField(); pnlInput.add(txtTitulo);
        pnlInput.add(new JLabel("Ano:"));
        txtAno = new JTextField(); pnlInput.add(txtAno);
        pnlInput.add(new JLabel("Qtd:"));
        txtQtd = new JTextField(); pnlInput.add(txtQtd);

        JButton btnAdd = new JButton("Adicionar");
        btnAdd.addActionListener(e -> adicionar());
        pnlInput.add(btnAdd);

        JButton btnRefresh = new JButton("Atualizar Lista");
        btnRefresh.addActionListener(e -> carregarDados());
        pnlInput.add(btnRefresh);

        add(pnlInput, BorderLayout.NORTH);

        model = new DefaultTableModel(new Object[]{"ID", "Título", "Ano", "Qtd"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        carregarDados();
    }

    private void carregarDados() {
        try {
            model.setRowCount(0);
            List<Livro> livros = dao.read();
            for (Livro l : livros) {
                model.addRow(new Object[]{l.getId(), l.getTitulo(), l.getAnoPublicacao(), l.getQtdDisponivel()});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar: " + e.getMessage());
        }
    }

    private void adicionar() {
        try {
            Livro l = new Livro();
            l.setTitulo(txtTitulo.getText());
            l.setAnoPublicacao(Integer.parseInt(txtAno.getText()));
            l.setQtdDisponivel(Integer.parseInt(txtQtd.getText()));
            dao.create(l);
            carregarDados();
            limparCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage());
        }
    }

    private void limparCampos() {
        txtTitulo.setText(""); txtAno.setText(""); txtQtd.setText("");
    }
}
