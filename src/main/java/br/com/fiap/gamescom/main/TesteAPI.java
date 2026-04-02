package br.com.fiap.gamescom.main;

import br.com.fiap.gamescom.api.InfoJogo;
import br.com.fiap.gamescom.api.Jogo;
import br.com.fiap.gamescom.services.ConsumoAPIService;

import javax.swing.JOptionPane;

public class TesteAPI {

    public static void main(String[] args) {
        ConsumoAPIService consumoAPIService = new ConsumoAPIService();
        String id = JOptionPane.showInputDialog("Informe o ID do jogo para teste de API (Ex: 146)");

        try {
            InfoJogo informacaoJogo = consumoAPIService.buscaJogo(id);

            if (informacaoJogo != null && informacaoJogo.getInfo() != null) {
                Jogo jogo = new Jogo(informacaoJogo.getInfo().getTitle(), informacaoJogo.getInfo().getThumb());
                System.out.println("Resultado da API:");
                System.out.println(jogo);
            } else {
                System.out.println("Nenhum jogo encontrado para o ID informado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar informações do jogo.");
        }
    }
}
