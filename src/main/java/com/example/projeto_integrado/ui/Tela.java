package com.example.projeto_integrado.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tela extends VBox {

    public Tela(){
        Pgts();
    }

    public void Pgts() {

        // Definir o tamanho da tela, cor e titulo
        this.setStyle("-fx-background-color: #F0D49B;");

        // Titulo do stage
        VBox headerTitulo = new VBox();
        Label titulo = new Label("Inicio");
        titulo.setStyle("-fx-text-fill: black;-fx-font-size: 32; -fx-font-weight: Bold;");
        headerTitulo.getChildren().add(titulo);
        VBox.setMargin(headerTitulo, new Insets(50, 0, 0, 50));

        // Label Data e o horário
        Label dataHorarioTitulo = new Label("Data e horário: ");
        dataHorarioTitulo.setStyle("-fx-text-fill: black;-fx-font-size: 25; ");

        TextField dataHorarioTextField = new TextField();
        dataHorarioTextField.setPromptText("Data/Mês/Ano, Hora:Minutos");
        dataHorarioTextField.setPrefWidth(250);
        dataHorarioTextField.setPrefHeight(50);

        Label valorDoEstacionamentoTitulo = new Label("Valor do estacionamento: ");
        valorDoEstacionamentoTitulo.setStyle("-fx-text-fill: black;-fx-font-size: 25;");

        TextField valorDoEstacionamentoTextField = new TextField();
        valorDoEstacionamentoTextField.setPromptText("R$ 0,00");
        valorDoEstacionamentoTextField.setPrefWidth(250);
        valorDoEstacionamentoTextField.setPrefHeight(50);

        // Hbox do estacionamento
        HBox estacionamentoHbox = new HBox();
        estacionamentoHbox.getChildren().addAll(valorDoEstacionamentoTitulo, valorDoEstacionamentoTextField);

        // Botões de sair e entrada
        Button btnDeEntrada = new Button("Confirmar");
        btnDeEntrada.setPrefWidth(200);
        btnDeEntrada.setPrefHeight(100);
        btnDeEntrada.setStyle("-fx-background-color: #93E681; -fx-font-size: 16px; -fx-background-radius: 12; -fx-font-weight: Bold;");

        DropShadow shadow = new DropShadow();    //Adicionar uma sombra por traz do objeto ao passar o mouse
        shadow.setRadius(8);                     //Tamanho da sombra adicionada

        btnDeEntrada.setOnMouseEntered(passarMouse -> btnDeEntrada.setEffect(shadow));       //Aplicar o efeito escuro quando passa o mouse
        btnDeEntrada.setOnMouseExited(mouseJaPassou -> btnDeEntrada.setEffect(null));        //Retirar o efeito escuro quando o mouse já passou

        btnDeEntrada.setOnMousePressed(clickIn -> {
            btnDeEntrada.setScaleX(0.92);      //Reduzir o tamanho do botão ao clicar no mesmo
            btnDeEntrada.setScaleY(0.92);
        });

        btnDeEntrada.setOnMouseReleased(clickOut -> {
            btnDeEntrada.setScaleX(1);        //O tamanho volta ao normal após o clickOut do mouse
            btnDeEntrada.setScaleY(1);
        });

        btnDeEntrada.setOnAction(e -> {
            Pagamentos telaDeInicio = new Pagamentos();
            Scene novaCenaEntrada = new Scene(telaDeInicio, 1440, 1024);

            Stage stageExistente = (Stage) btnDeEntrada.getScene().getWindow();
            stageExistente.setScene(novaCenaEntrada);

            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            String dataHoraFixa = agora.format(formatador);

        });

        // Criar botões


        HBox boxBotoes = new HBox(100);
        boxBotoes.setAlignment(Pos.BOTTOM_CENTER);
        boxBotoes.getChildren().addAll(btnDeEntrada);
        VBox.setMargin(boxBotoes, new Insets(30, 0, 50, 0));

        // Filhos do stage
        this.getChildren().addAll(headerTitulo, boxBotoes);
    }
}
