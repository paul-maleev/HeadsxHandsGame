package com.example.headsxhands;

import com.example.headsxhands.core.Monster;
import com.example.headsxhands.core.Player;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.PrintWriter;
import java.io.StringWriter;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextArea battleLogTextArea;

    @FXML
    private Button startPartyButton;

    @FXML
    private TextField playerAttackTextField;
    @FXML
    private TextField playerDefenceTextField;
    @FXML
    private TextField playerHealthTextField;
    @FXML
    private TextField playerDamageMTextField;
    @FXML
    private TextField playerDamageNTextField;

    @FXML
    private TextField monsterAttackTextField;
    @FXML
    private TextField monsterDefenceTextField;
    @FXML
    private TextField monsterHealthTextField;
    @FXML
    private TextField monsterDamageMTextField;
    @FXML
    private TextField monsterDamageNTextField;


    @FXML
    protected void onStartPartyButtonClick() {
        System.out.println("onStartPartyButtonClick()");
        int playerAttack=1;
        int playerDefence=1;
        int playerHealth=1;
        int playerDamageM=1;
        int playerDamageN=2;
        Player player = null;
        try {
            playerAttack = Integer.parseInt(playerAttackTextField.getText());
            playerDefence = Integer.parseInt(playerDefenceTextField.getText());
            playerHealth = Integer.parseInt(playerHealthTextField.getText());
            playerDamageM = Integer.parseInt(playerDamageMTextField.getText());
            playerDamageN = Integer.parseInt(playerDamageNTextField.getText());
        } catch (NumberFormatException pE) {
            showExceptionWindow(pE);
        }
        int monsterAttack = 0;
        int monsterDefence = 0;
        int monsterHealth = 0;
        int monsterDamageM = 0;
        int monsterDamageN = 0;
        Monster monster = null;
        try {
            monsterAttack = Integer.parseInt(monsterAttackTextField.getText());
            monsterDefence = Integer.parseInt(monsterDefenceTextField.getText());
            monsterHealth = Integer.parseInt(monsterHealthTextField.getText());
            monsterDamageM = Integer.parseInt(monsterDamageMTextField.getText());
            monsterDamageN = Integer.parseInt(monsterDamageNTextField.getText());
        } catch (NumberFormatException mE) {
            showExceptionWindow(mE);
        }

        try {
            player = new Player(playerHealth,playerAttack,playerDefence,playerDamageM,playerDamageN);
        }catch (IllegalArgumentException i) {
            showExceptionWindow(i);
        }

        try {
            monster = new Monster(monsterHealth,monsterAttack,monsterDefence,monsterDamageM,monsterDamageN);
        }catch (IllegalArgumentException i) {
            showExceptionWindow(i);
        }
        if(player!=null && monster!=null) {
            startParty(player,monster);
        }


    }

    private void startParty(Player player, Monster monster) {
        StringBuilder text = new StringBuilder();
        int c=0;
        do {
            c++;
            text.append("round number "+c+"\n");
            battleLogTextArea.setText(text.toString());
            ;
            text.append(player.doHit(monster)+"\n");
            text.append(monster+"\n");
            battleLogTextArea.setText(text.toString());
            text.append(monster.doHit(player)+"\n");
            ;
            text.append(player+"\n");
            battleLogTextArea.setText(text.toString());

            text.append(player.selfHealing()+"\n");
            battleLogTextArea.setText(text.toString());
        }while (!player.isDead() && !monster.isDead());

        if(!player.isDead()) {
            text.append("\n Player has won!"+"\n");
            battleLogTextArea.setText(text.toString());
        }
        if(!monster.isDead()) {
            text.append("\n Monster has won!"+"\n");
            battleLogTextArea.setText(text.toString());
        }

    }

    private void startParty() {
        StringBuilder text = new StringBuilder();
        int playerAttack=1;
        int playerDefence=1;
        int playerHealth=1;
        int playerDamageM=1;
        int playerDamageN=2;
        try {
            playerAttack = Integer.parseInt(playerAttackTextField.getText());
            playerDefence = Integer.parseInt(playerDefenceTextField.getText());
            playerHealth = Integer.parseInt(playerHealthTextField.getText());
            playerDamageM = Integer.parseInt(playerDamageMTextField.getText());
            playerDamageN = Integer.parseInt(playerDamageNTextField.getText());
        } catch (NumberFormatException nfe) {
            showExceptionWindow(nfe);
        }

        int monsterAttack = Integer.parseInt(monsterAttackTextField.getText());
        int monsterDefence = Integer.parseInt(monsterDefenceTextField.getText());
        int monsterHealth = Integer.parseInt(monsterHealthTextField.getText());
        int monsterDamageM = Integer.parseInt(monsterDamageMTextField.getText());
        int monsterDamageN = Integer.parseInt(monsterDamageNTextField.getText());

        Player player = null;

        try {
            player = new Player(playerHealth,playerAttack,playerDefence,playerDamageM,playerDamageN);
        }catch (IllegalArgumentException i) {
            showExceptionWindow(i);
        }

        Monster monster = null;

        try {
            monster = new Monster(monsterHealth,monsterAttack,monsterDefence,monsterDamageM,monsterDamageN);
        }catch (IllegalArgumentException i) {
            showExceptionWindow(i);
        }






        int c=0;
        do {
            c++;
            //System.out.println("round number "+c);
            text.append("round number "+c+"\n");
            battleLogTextArea.setText(text.toString());
            ;
            text.append(player.doHit(monster)+"\n");
            text.append(monster+"\n");
            battleLogTextArea.setText(text.toString());
            text.append(monster.doHit(player)+"\n");
            ;
            text.append(player+"\n");
            battleLogTextArea.setText(text.toString());

            text.append(player.selfHealing()+"\n");
            battleLogTextArea.setText(text.toString());
        }while (!player.isDead() && !monster.isDead());

        if(!player.isDead()) {
            text.append("\n Player has won!"+"\n");
            battleLogTextArea.setText(text.toString());
        }
        if(!monster.isDead()) {
            text.append("\n Monster has won!"+"\n");
            battleLogTextArea.setText(text.toString());
        }
    }

    private void showExceptionWindow(Exception e) {

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String exceptionText = sw.toString();
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Exception Dialog");
        alert.setHeaderText(e.getMessage());

        alert.setContentText(e.getMessage());

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);
        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        alert.getDialogPane().setExpandableContent(expContent);
        alert.showAndWait();
    }





}