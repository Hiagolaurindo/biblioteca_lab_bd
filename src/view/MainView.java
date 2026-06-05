package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    public MainView() {
        setTitle("Sistema de Gerenciamento de Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnUsuarios = new JButton("Gerenciar Usuários");
        JButton btnLivros = new JButton("Gerenciar Livros");
        JLabel lblStatus = new JLabel("Bem-vindo ao Sistema da Biblioteca", SwingConstants.CENTER);

        btnUsuarios.addActionListener(e -> new UsuarioView().setVisible(true));
        btnLivros.addActionListener(e -> new LivroView().setVisible(true));

        add(lblStatus);
        add(btnUsuarios);
        add(btnLivros);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainView().setVisible(true));
    }
}
