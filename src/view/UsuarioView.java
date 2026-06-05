package view;

import dao.UsuarioDAO;
import model.Usuario;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class UsuarioView extends JFrame {
    private UsuarioDAO dao = new UsuarioDAO();
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtNome, txtCpf, txtEmail, txtTelefone;

    public UsuarioView() {
        setTitle("Gerenciar Usuários");
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Painel de entrada
        JPanel pnlInput = new JPanel(new GridLayout(5, 2));
        pnlInput.add(new JLabel("Nome:"));
        txtNome = new JTextField(); pnlInput.add(txtNome);
        pnlInput.add(new JLabel("CPF:"));
        txtCpf = new JTextField(); pnlInput.add(txtCpf);
        pnlInput.add(new JLabel("Email:"));
        txtEmail = new JTextField(); pnlInput.add(txtEmail);
        pnlInput.add(new JLabel("Telefone:"));
        txtTelefone = new JTextField(); pnlInput.add(txtTelefone);

        JButton btnAdd = new JButton("Adicionar");
        btnAdd.addActionListener(e -> adicionar());
        pnlInput.add(btnAdd);

        JButton btnRefresh = new JButton("Atualizar Lista");
        btnRefresh.addActionListener(e -> carregarDados());
        pnlInput.add(btnRefresh);

        add(pnlInput, BorderLayout.NORTH);

        // Tabela
        model = new DefaultTableModel(new Object[]{"ID", "Nome", "CPF", "Email", "Telefone"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        carregarDados();
    }

    private void carregarDados() {
        try {
            model.setRowCount(0);
            List<Usuario> usuarios = dao.read();
            for (Usuario u : usuarios) {
                model.addRow(new Object[]{u.getId(), u.getNome(), u.getCpf(), u.getEmail(), u.getTelefone()});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar: " + e.getMessage());
        }
    }

    private void adicionar() {
        try {
            Usuario u = new Usuario();
            u.setNome(txtNome.getText());
            u.setCpf(txtCpf.getText());
            u.setEmail(txtEmail.getText());
            u.setTelefone(txtTelefone.getText());
            dao.create(u);
            carregarDados();
            limparCampos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage());
        }
    }

    private void limparCampos() {
        txtNome.setText(""); txtCpf.setText(""); txtEmail.setText(""); txtTelefone.setText("");
    }
}
