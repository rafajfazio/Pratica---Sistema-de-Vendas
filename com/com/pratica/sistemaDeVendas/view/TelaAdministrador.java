/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemadevendas.view;

import com.pratica.sistemadevendas.controller.UsuarioController;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author emart
 */
public class TelaAdministrador {

    private Button botaoFilmes;
    private Button botaoLoja;
    private Button botaoUsuarios;
    private Button botaoSair;
    private HBox caixaDeBotoes = new HBox(40);
    private HBox caixaSair = new HBox();
    private VBox paneADM = new VBox();
    private Scene cenaADM;



    private UsuarioController usuarioController;


    private Aplicacao aplicacao;

    public TelaAdministrador(Aplicacao aplicacao) {
        /*String bilheteria = "C:\\PraticaProjeto\\bilheteria.png";
        String engrenagem = "C:\\PraticaProjeto\\engrenagem.png";
        String pipoca = "C:\\PraticaProjeto\\pipoca.png";*/
        this.botaoFilmes = new Button("Bilheteria");
        this.botaoLoja = new Button("Loja");
        this.botaoUsuarios = new Button("Usuarios");
        this.botaoSair = new Button("Sair");
        this.aplicacao = aplicacao;

        botaoUsuarios.setOnAction(e ->          
            irParaTelaDeUsuariosCRUD()
        );

        botaoLoja.setOnAction(e -> irParaTelaDeLanchoneteCLUD());

        botaoFilmes.setOnAction(e -> irParaFilmeCLUD());
        
        botaoSair.setOnAction(e -> sair());

        caixaDeBotoes.getChildren().addAll(botaoFilmes, botaoLoja, botaoUsuarios);
        caixaSair.getChildren().addAll(botaoSair);

        paneADM.getChildren().addAll(caixaDeBotoes, caixaSair);
        paneADM.setStyle("-fx-background-color: red;");
        cenaADM = new Scene(paneADM, 600, 220);
        

    }

    public void irParaFilmeCLUD(){
        this.aplicacao.mudaCena(this.aplicacao.getTelaOperacoesFilme().telaOperacoesFilme());
    }

    public void irParaTelaDeUsuariosCRUD(){
        
        this.aplicacao.mudaCena(this.aplicacao.getTelaOperacoesUsuario().telaOperaCoesUsuario());

    }

    public void irParaTelaDeLanchoneteCLUD(){
        this.aplicacao.mudaCena(this.aplicacao.getTelaOperacoesLanchonete().telaOperacoesLanchonete());
    }
    
    public void sair() {
        //this.usuarioController.sair();
        this.aplicacao.estagioAtual().close();
    }

    public Scene telaMenuAdministrador() {

        
        
        
        //caixaDeBotoes.setAlignment(Pos.CENTER);

        
        
        //caixaSair.setAlignment(Pos.BOTTOM_LEFT);
        //alteracao

        
        

        
        return cenaADM;
    }
    
    public Button criarBotaoComImagem(String caminhoDaImagem){
        
        Button botao = new Button();
        
        Image imagem = new Image(getClass().getResourceAsStream(caminhoDaImagem));
        
        ImageView imageView = new ImageView(imagem);
        
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        
        botao.setGraphic(imageView);
        
        botao.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        
        return botao;
        
    }

    
    
    
    

    
    

}
