package com.example.projeto_integrado;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;



import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();

        // Definir o tamanho da tela, cor e titulo
        root.setStyle("-fx-background-color: #F0D49B;");
        stage.setWidth(1440);
        stage.setHeight(1024);
        stage.setResizable(false);
        stage.setTitle("Estacionamento");

        // Definir a função de sair
        stage.setOnCloseRequest(click -> {
            fechar();
            click.consume();
        });

        // Titulo do stage
        VBox headerTitulo = new VBox();
        Label titulo = new Label("Valor a ser pago");
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

        // GridPane data e horário, valor do estacionamento
        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER);

        grid.add(dataHorarioTitulo, 0, 0);
        grid.add(dataHorarioTextField, 1, 0);

        grid.add(valorDoEstacionamentoTitulo, 0, 1);
        grid.add(valorDoEstacionamentoTextField, 1, 1);

        VBox.setVgrow(grid, javafx.scene.layout.Priority.ALWAYS);

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
            // Chamar função
        });

        // Criar botões
        Button btnDeSaida = new Button("Voltar");
        btnDeSaida.setPrefWidth(200);
        btnDeSaida.setPrefHeight(100);
        btnDeSaida.setStyle("-fx-background-color: #FF8989; -fx-font-size: 16px; -fx-background-radius: 12; -fx-font-weight: Bold;");
        btnDeSaida.setFont(Font.font("arial", 16));

        DropShadow shadow2 = new DropShadow();
        shadow2.setRadius(8);
        btnDeSaida.setOnMouseEntered(passarMouse -> btnDeSaida.setEffect(shadow2));
        btnDeSaida.setOnMouseExited(mouseJaPassou -> btnDeSaida.setEffect(null));
        btnDeSaida.setOnMousePressed(clickIn -> {
            btnDeSaida.setScaleX(0.92);
            btnDeSaida.setScaleY(0.92);
        });
        btnDeSaida.setOnMouseReleased(clickOut -> {
            btnDeSaida.setScaleX(1);
            btnDeSaida.setScaleY(1);
        });

        btnDeSaida.setOnAction(e -> {
            // Chamar função
        });

        HBox boxBotoes = new HBox(100);
        boxBotoes.setAlignment(Pos.BOTTOM_CENTER);
        boxBotoes.getChildren().addAll(btnDeEntrada, btnDeSaida);
        VBox.setMargin(boxBotoes, new Insets(30, 0, 50, 0));

        // Filhos do stage
        root.getChildren().addAll(headerTitulo, grid, boxBotoes);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        }

        // Configurando o botão de fechar
        public void fechar(){
        Alert alertaFechar = new Alert(
                Alert.AlertType.CONFIRMATION, "Tem certeza que deseja sair?",
                ButtonType.YES,
                ButtonType.NO
        );
        Optional<ButtonType> resposta = alertaFechar.showAndWait();
        if (resposta.isPresent() && resposta.get() == ButtonType.YES){
            System.exit(0);
        }
    }
}
