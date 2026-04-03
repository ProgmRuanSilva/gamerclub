package br.com.fiap.gamescom.main;

import br.com.fiap.gamescom.api.Gamer;
import br.com.fiap.gamescom.api.InfoJogo;
import br.com.fiap.gamescom.api.Jogo;
import br.com.fiap.gamescom.services.ConsumoAPIService;

import javax.swing.JOptionPane;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TesteGamer {

    public static void main(String[] args) {
        Gamer gamer = Gamer.criarGamer();

        String resposta;
        ConsumoAPIService consumoAPIService = new ConsumoAPIService();

        do {
            String id = JOptionPane.showInputDialog("Digite o id do jogo que você procura: ");

            try {
                InfoJogo informacaoJogo = consumoAPIService.buscaJogo(id);

                if (informacaoJogo != null && informacaoJogo.getInfo() != null) {
                    Jogo meuJogo = new Jogo(informacaoJogo.getInfo().getTitle(), informacaoJogo.getInfo().getThumb());
                    System.out.println(meuJogo);

                    String opcao = JOptionPane.showInputDialog("Você quer adicionar uma descrição? (S/N)");

                    if (opcao != null && opcao.equalsIgnoreCase("s")) {
                        String descricao = JOptionPane.showInputDialog("Insira a descrição: ");
                        meuJogo.setDescricao(descricao);
                    } else {
                        meuJogo.setDescricao(meuJogo.getTitulo());
                    }
                    System.out.println(meuJogo);

                    gamer.getJogosBuscados().add(meuJogo);
                } else {
                    System.out.println("Jogo não achado");
                }
            } catch (Exception e) {
                System.out.println("Jogo não achado");
            }

            resposta = JOptionPane.showInputDialog("Você quer buscar um novo jogo? (S/N)");

        } while (resposta != null && resposta.equalsIgnoreCase("s"));

        System.out.println("Jogos achados: ");
        System.out.println(gamer.getJogosBuscados());

        System.out.println("Jogos ordenados por titulo: ");
        gamer.getJogosBuscados().sort(Comparator.comparing(Jogo::getTitulo));
        gamer.getJogosBuscados().forEach(j -> System.out.println("Titulo: " + j.getTitulo()));

        String termoBusca = JOptionPane.showInputDialog("Digite um termo para filtrar jogos (ex: Batman):");
        List<Jogo> jogosFiltrados = gamer.getJogosBuscados().stream()
                .filter(j -> j.getTitulo().toLowerCase().contains(termoBusca != null ? termoBusca.toLowerCase() : ""))
                .collect(Collectors.toList());

        System.out.println("\n Jogos filtrados: ");
        jogosFiltrados.forEach(j -> System.out.println(j.getTitulo()));

        String excluirOpcao = JOptionPane.showInputDialog("Deseja excluir algum jogo? (S/N)");

        if (excluirOpcao != null && excluirOpcao.equalsIgnoreCase("s")) {
            String posicaoStr = JOptionPane.showInputDialog("Insira o indice do jogo: ");
            try {
                int posicao = Integer.parseInt(posicaoStr);
                gamer.getJogosBuscados().remove(posicao);
                System.out.println("Lista atualizada com sucesso!");
                System.out.println(gamer.getJogosBuscados());
            } catch (Exception e) {
                System.out.println("Posição inválida.");
            }
        }

        System.out.println("Processo finalizado com sucesso!!!");
    }
}
