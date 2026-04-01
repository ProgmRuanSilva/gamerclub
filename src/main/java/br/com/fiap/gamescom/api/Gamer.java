package br.com.fiap.gamescom.api;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {
    private String nome;
    private String email;
    private String dataNascimento;
    private String idInterno;
    private String usuario;
    private List<Jogo> jogosBuscados = new ArrayList<>();

    public Gamer() {
    }

    public Gamer(String nome, String email) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome esta vazia");
        }
        this.nome = nome;
        this.email = validarEmail(email);
    }

    public Gamer(String nome, String email, String dataNascimento, String usuario) {
        this(nome, email);
        this.dataNascimento = dataNascimento;
        this.usuario = usuario;
        criarIdInterno();
    }

    private void criarIdInterno() {
        Random random = new Random();
        int numero = random.nextInt(10000);
        String tag = String.format("%04d", numero);
        this.idInterno = this.usuario + "#" + tag;
    }

    private String validarEmail(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        if (email.matches(regex)) {
            return email;
        } else {
            throw new IllegalArgumentException("Email inválido");
        }
    }

    public static Gamer criarGamer() {
        while (true) {
            try {
                String nome = JOptionPane.showInputDialog("Boas vindas ao Gamer Club!\nDigite seu nome: ");
                String email = JOptionPane.showInputDialog("Digite seu e-mail:");
                String opcao = JOptionPane
                        .showInputDialog("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)");

                if (opcao != null && opcao.equalsIgnoreCase("s")) {
                    String nascimento = JOptionPane.showInputDialog("Digite sua data de nascimento(DD/MM/AAAA):");
                    String usuario = JOptionPane.showInputDialog("Digite seu nome de usuário:");
                    return new Gamer(nome, email, nascimento, usuario);
                } else {
                    return new Gamer(nome, email);
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = validarEmail(email);
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getIdInterno() {
        return idInterno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
        if (this.idInterno == null || this.idInterno.trim().isEmpty()) {
            criarIdInterno();
        }
    }

    public List<Jogo> getJogosBuscados() {
        return jogosBuscados;
    }

    public void setJogosBuscados(List<Jogo> jogosBuscados) {
        this.jogosBuscados = jogosBuscados;
    }

    @Override
    public String toString() {
        return "Gamer(nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento + ", usuario=" + usuario
                + ", idInterno=" + idInterno + ")";
    }
}
