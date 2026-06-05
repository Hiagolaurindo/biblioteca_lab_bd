package model;

public class Livro {
    private int id;
    private String titulo;
    private int anoPublicacao;
    private int qtdDisponivel;

    public Livro() {}

    public Livro(int id, String titulo, int anoPublicacao, int qtdDisponivel) {
        this.id = id;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.qtdDisponivel = qtdDisponivel;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public int getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }
    public int getQtdDisponivel() { return qtdDisponivel; }
    public void setQtdDisponivel(int qtdDisponivel) { this.qtdDisponivel = qtdDisponivel; }
}
