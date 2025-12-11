package com.example.projeto_integrado;


import com.example.projeto_integrado.ui.Pagamentos;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Pagamentos telaDePagamento = new Pagamentos();
        Scene cenaDePagamento = new Scene(telaDePagamento, 1440, 1024);

        stage.setTitle("Estacionamento");
        stage.setScene(cenaDePagamento);
        stage.show();

        // Definir a função de sair
        stage.setOnCloseRequest(click -> {
            fechar();
            click.consume();
        });
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
