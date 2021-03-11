package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.input.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

import javafx.util.Duration;

import java.awt.*;

public class Main extends Application {
    private Scene windowScene;
    private Group windowRoot;

    private TextField groupOneText;
    private Button groupOneActionButton;
    private ComboBox<String> groupOneComboBox;

    private TextField groupTwoText;
    private Button groupTwoActionButton;
    private Button groupTwoSwapButton;

    private TextField groupThreeText;
    private Button groupThreeInputButton;
    private RadioButton groupThreeRadio1;
    private RadioButton groupThreeRadio2;
    private RadioButton groupThreeRadio3;

    private TextField groupFourText;
    private Button groupFourInputButton;
    private CheckBox groupFourCheck1;
    private CheckBox groupFourCheck2;
    private CheckBox groupFourCheck3;

    private TextField groupFiveText;
    private Button groupFiveInputButton;
    private Button groupFiveSwapButton1;
    private Button groupFiveSwapButton2;

    private TableView<String> groupFiveTable;
    private TableColumn firstColumn;
    private TableColumn secondColumn;

    private Timeline displayTimeline = null;


    public void start(Stage primaryStage) throws Exception{
        var height = 275;
        var width = 800;

        windowRoot = new Group();
        windowScene = new Scene(windowRoot, width, height);
        windowScene.setOnKeyPressed(this::handleHotkeys);

        groupOneInit();
        groupTwoInit();
        groupThreeInit();
        groupFourInit();
        groupFiveInit();

        primaryStage.setScene(windowScene);
        primaryStage.show();
    }

    public void groupOneInit() {
        groupOneText = new TextField();
        groupOneText.setPrefSize(200, 50);

        groupOneActionButton = new Button();
        groupOneActionButton.setText("Ввести");
        groupOneActionButton.setPrefSize(200, 50);
        groupOneActionButton.setTranslateX(200);
        groupOneActionButton.setOnAction(e -> groupOneButtonOneAction());

        groupOneComboBox = new ComboBox<String>();
        groupOneComboBox.setPrefSize(200, 50);
        groupOneComboBox.setTranslateX(400);

        windowRoot.getChildren().add(groupOneText);
        windowRoot.getChildren().add(groupOneActionButton);
        windowRoot.getChildren().add(groupOneComboBox);
    }

    public void groupTwoInit() {
        groupTwoText = new TextField();
        groupTwoText.setPrefSize(200, 50);
        groupTwoText.setTranslateY(55);

        groupTwoActionButton = new Button();
        groupTwoActionButton.setText("Ввести");
        groupTwoActionButton.setPrefSize(200, 50);
        groupTwoActionButton.setTranslateY(55);
        groupTwoActionButton.setTranslateX(200);
        groupTwoActionButton.setOnAction(e -> groupTwoInputAction());

        groupTwoSwapButton = new Button();
        groupTwoSwapButton.setText("Поменять");
        groupTwoSwapButton.setPrefSize(200, 50);
        groupTwoSwapButton.setTranslateY(55);
        groupTwoSwapButton.setTranslateX(400);
        groupTwoSwapButton.setOnAction(e -> groupTwoSwapAction());

        windowRoot.getChildren().add(groupTwoText);
        windowRoot.getChildren().add(groupTwoActionButton);
        windowRoot.getChildren().add(groupTwoSwapButton);
    }

    public void groupThreeInit() {
        groupThreeText = new TextField();
        groupThreeText.setPrefSize(200, 50);
        groupThreeText.setTranslateY(110);

        groupThreeInputButton = new Button();
        groupThreeInputButton.setText("Ввести");
        groupThreeInputButton.setPrefSize(200, 50);
        groupThreeInputButton.setTranslateY(110);
        groupThreeInputButton.setTranslateX(200);
        groupThreeInputButton.setOnAction(e -> groupThreeButtonAction());

        groupThreeRadio1 = new RadioButton("1");
        groupThreeRadio1.setTranslateY(125);
        groupThreeRadio1.setTranslateX(450);

        groupThreeRadio2 = new RadioButton("2");
        groupThreeRadio2.setTranslateY(125);
        groupThreeRadio2.setTranslateX(500);

        groupThreeRadio3 = new RadioButton("3");
        groupThreeRadio3.setTranslateY(125);
        groupThreeRadio3.setTranslateX(550);

        windowRoot.getChildren().add(groupThreeText);
        windowRoot.getChildren().add(groupThreeInputButton);
        windowRoot.getChildren().add(groupThreeRadio1);
        windowRoot.getChildren().add(groupThreeRadio2);
        windowRoot.getChildren().add(groupThreeRadio3);
    }

    public void groupFourInit() {
        groupFourText = new TextField();
        groupFourText.setPrefSize(200, 50);
        groupFourText.setTranslateY(165);

        groupFourInputButton = new Button();
        groupFourInputButton.setText("Ввести");
        groupFourInputButton.setPrefSize(200, 50);
        groupFourInputButton.setTranslateY(165);
        groupFourInputButton.setTranslateX(200);
        groupFourInputButton.setOnAction(e -> groupFourButtonAction());

        groupFourCheck1 = new CheckBox("1");
        groupFourCheck1.setTranslateY(180);
        groupFourCheck1.setTranslateX(450);

        groupFourCheck2 = new CheckBox("2");
        groupFourCheck2.setTranslateY(180);
        groupFourCheck2.setTranslateX(500);

        groupFourCheck3 = new CheckBox("3");
        groupFourCheck3.setTranslateY(180);
        groupFourCheck3.setTranslateX(550);

        windowRoot.getChildren().add(groupFourText);
        windowRoot.getChildren().add(groupFourInputButton);
        windowRoot.getChildren().add(groupFourCheck1);
        windowRoot.getChildren().add(groupFourCheck2);
        windowRoot.getChildren().add(groupFourCheck3);

    }

    public void groupFiveInit() {
        groupFiveText = new TextField();
        groupFiveText.setPrefSize(200, 50);
        groupFiveText.setTranslateY(220);

        groupFiveInputButton = new Button();
        groupFiveInputButton.setText("Ввести");
        groupFiveInputButton.setPrefSize(200, 50);
        groupFiveInputButton.setTranslateY(220);
        groupFiveInputButton.setTranslateX(200);
        groupFiveInputButton.setOnAction(e -> groupFiveTableInput());

        groupFiveSwapButton1 = new Button();
        groupFiveSwapButton1.setText("Во вторую колонку");
        groupFiveSwapButton1.setPrefSize(200, 50);
        groupFiveSwapButton1.setTranslateY(220);
        groupFiveSwapButton1.setTranslateX(400);
        groupFiveSwapButton1.setOnAction(e -> groupFiveToRight());

        groupFiveSwapButton2 = new Button();
        groupFiveSwapButton2.setText("В первую колонку");
        groupFiveSwapButton2.setPrefSize(200, 50);
        groupFiveSwapButton2.setTranslateY(220);
        groupFiveSwapButton2.setTranslateX(600);
        groupFiveSwapButton2.setOnAction(e -> groupFiveToLeft());

        groupFiveTable = new TableView<String>();

        firstColumn = new TableColumn("");
        secondColumn = new TableColumn("");

        groupFiveTable.getColumns().addAll(firstColumn, secondColumn);
        groupFiveTable.setPrefSize(160, 210);
        groupFiveTable.setTranslateX(630);

        windowRoot.getChildren().add(groupFiveText);
        windowRoot.getChildren().add(groupFiveInputButton);
        windowRoot.getChildren().add(groupFiveSwapButton1);
        windowRoot.getChildren().add(groupFiveSwapButton2);
        windowRoot.getChildren().add(groupFiveTable);
    }

    private void groupOneButtonOneAction() {
        String inputString = groupOneText.getText();

        if (!groupOneComboBox.getItems().contains(inputString)) {
            groupOneComboBox.getItems().add(inputString);
        }
        else {
            Alert isAlreadyPresent = new Alert(Alert.AlertType.WARNING);
            isAlreadyPresent.initStyle(StageStyle.UTILITY);
            isAlreadyPresent.setTitle("");
            isAlreadyPresent.setHeaderText("Ошибка");
            isAlreadyPresent.setContentText("Элемент уже есть в списке");
            isAlreadyPresent.showAndWait();
        }
    }

    private void groupTwoInputAction() {
        String inputString = groupTwoText.getText();
        groupTwoSwapButton.setText(inputString);
    }

    private void groupTwoSwapAction() {
        String inputButtonString = groupTwoActionButton.getText();
        String swapButtonString = groupTwoSwapButton.getText();

        groupTwoActionButton.setText(swapButtonString);
        groupTwoSwapButton.setText(inputButtonString);
    }

    public void groupThreeButtonAction() {
        String inputString = groupThreeText.getText();

        if (inputString.equals(groupThreeRadio1.getText())) {
            groupThreeRadio1.setSelected(true);
            groupThreeRadio2.setSelected(false);
            groupThreeRadio3.setSelected(false);
        }
        else if (inputString.equals(groupThreeRadio2.getText())) {
            groupThreeRadio1.setSelected(false);
            groupThreeRadio2.setSelected(true);
            groupThreeRadio3.setSelected(false);
        }
        else if (inputString.equals(groupThreeRadio3.getText())) {
            groupThreeRadio1.setSelected(false);
            groupThreeRadio2.setSelected(false);
            groupThreeRadio3.setSelected(true);
        }
        else {
            Alert isAlreadyPresent = new Alert(Alert.AlertType.WARNING);
            isAlreadyPresent.initStyle(StageStyle.UTILITY);
            isAlreadyPresent.setTitle("");
            isAlreadyPresent.setHeaderText("Ошибка");
            isAlreadyPresent.setContentText("Кнопки с таким именем не существует");
            isAlreadyPresent.showAndWait();
        }
    }

    private void groupFourButtonAction() {
        String inputString = groupFourText.getText();

        if (inputString.equals(groupFourCheck1.getText())) {
            var isSelected = groupFourCheck1.isSelected();
            groupFourCheck1.setSelected(!isSelected);
        }
        else if (inputString.equals(groupFourCheck2.getText())) {
            var isSelected = groupFourCheck2.isSelected();
            groupFourCheck2.setSelected(!isSelected);
        }
        else if (inputString.equals(groupFourCheck3.getText())) {
            var isSelected = groupFourCheck3.isSelected();
            groupFourCheck3.setSelected(!isSelected);
        }
        else {
            Alert isAlreadyPresent = new Alert(Alert.AlertType.WARNING);
            isAlreadyPresent.initStyle(StageStyle.UTILITY);
            isAlreadyPresent.setTitle("");
            isAlreadyPresent.setHeaderText("Ошибка");
            isAlreadyPresent.setContentText("Поля с таким именем не существует");
            isAlreadyPresent.showAndWait();
        }
    }

    private void groupFiveTableInput() {
        String inputString = groupFiveText.getText();
        String secondColString = secondColumn.getText();

        if (secondColString.equals("")) {
            firstColumn.setText(inputString);
        }
    }

    private void groupFiveToRight() {
        String firstColString = firstColumn.getText();

        if (!firstColString.equals("")) {
            secondColumn.setText(firstColString);
            firstColumn.setText("");
        }
    }

    private void groupFiveToLeft() {
        String secondColString = secondColumn.getText();

        if (!secondColString.equals("")) {
            firstColumn.setText(secondColString);
            secondColumn.setText("");
        }
    }

    private void transferGroupOne(FlowPane newRoot){
        groupOneText.setTranslateX(0);
        groupOneText.setTranslateY(0);

        groupOneActionButton.setTranslateX(0);
        groupOneActionButton.setTranslateY(0);

        groupOneComboBox.setTranslateX(0);
        groupOneComboBox.setTranslateY(0);

        newRoot.getChildren().add(groupOneText);
        newRoot.getChildren().add(groupOneActionButton);
        newRoot.getChildren().add(groupOneComboBox);
    }

    private void transferGroupTwo(FlowPane newRoot) {
        groupTwoText.setTranslateX(0);
        groupTwoText.setTranslateY(0);

        groupTwoActionButton.setTranslateX(0);
        groupTwoActionButton.setTranslateY(0);

        groupTwoSwapButton.setTranslateX(0);
        groupTwoSwapButton.setTranslateY(0);

        newRoot.getChildren().add(groupTwoText);
        newRoot.getChildren().add(groupTwoActionButton);
        newRoot.getChildren().add(groupTwoSwapButton);
    }

    private void transferGroupThree(FlowPane newRoot) {
        groupThreeText.setTranslateX(0);
        groupThreeText.setTranslateY(0);

        groupThreeInputButton.setTranslateX(0);
        groupThreeInputButton.setTranslateY(0);

        groupThreeRadio1.setTranslateX(0);
        groupThreeRadio1.setTranslateY(0);

        groupThreeRadio2.setTranslateX(0);
        groupThreeRadio2.setTranslateY(0);

        groupThreeRadio3.setTranslateX(0);
        groupThreeRadio3.setTranslateY(0);

        newRoot.getChildren().add(groupThreeText);
        newRoot.getChildren().add(groupThreeInputButton);
        newRoot.getChildren().add(groupThreeRadio1);
        newRoot.getChildren().add(groupThreeRadio2);
        newRoot.getChildren().add(groupThreeRadio3);
    }

    private void transferGroupFour(FlowPane newRoot) {
        groupFourText.setTranslateX(0);
        groupFourText.setTranslateY(0);

        groupFourInputButton.setTranslateX(0);
        groupFourInputButton.setTranslateY(0);

        groupFourCheck1.setTranslateX(0);
        groupFourCheck1.setTranslateY(0);

        groupFourCheck2.setTranslateX(0);
        groupFourCheck2.setTranslateY(0);

        groupFourCheck3.setTranslateX(0);
        groupFourCheck3.setTranslateY(0);

        newRoot.getChildren().add(groupFourText);
        newRoot.getChildren().add(groupFourInputButton);
        newRoot.getChildren().add(groupFourCheck1);
        newRoot.getChildren().add(groupFourCheck2);
        newRoot.getChildren().add(groupFourCheck3);
    }

    private void transferGroupFive(FlowPane newRoot) {
        groupFiveText.setTranslateX(0);
        groupFiveText.setTranslateY(0);

        groupFiveInputButton.setTranslateX(0);
        groupFiveInputButton.setTranslateY(0);

        groupFiveSwapButton1.setTranslateX(0);
        groupFiveSwapButton1.setTranslateY(0);

        groupFiveSwapButton2.setTranslateX(0);
        groupFiveSwapButton2.setTranslateY(0);

        groupFiveTable.setTranslateX(0);
        groupFiveTable.setTranslateY(0);

        newRoot.getChildren().add(groupFiveText);
        newRoot.getChildren().add(groupFiveInputButton);
        newRoot.getChildren().add(groupFiveSwapButton1);
        newRoot.getChildren().add(groupFiveSwapButton2);
        newRoot.getChildren().add(groupFiveTable);
    }

    private void handleHotkeys(KeyEvent keyEvent){
        var startHotkey = new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN);
        var pauseHotKey = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);

        var pauseEventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (pauseHotKey.match(e) && displayTimeline != null) {
                    displayTimeline.pause();
                }
                else if (startHotkey.match(e) && displayTimeline != null) {
                    displayTimeline.play();
                }
            }
        };

        if (startHotkey.match(keyEvent)) {
            if (displayTimeline == null) {
                var groupOneRoot = new FlowPane();
                var groupTwoRoot = new FlowPane();
                var groupThreeRoot = new FlowPane();
                var groupFourRoot = new FlowPane();
                var groupFiveRoot = new FlowPane();

                var groupOneStage = new Stage();
                var groupTwoStage = new Stage();
                var groupThreeStage = new Stage();
                var groupFourStage = new Stage();
                var groupFiveStage = new Stage();

                groupOneRoot.setOnKeyPressed(pauseEventHandler);
                groupTwoRoot.setOnKeyPressed(pauseEventHandler);
                groupThreeRoot.setOnKeyPressed(pauseEventHandler);
                groupFourRoot.setOnKeyPressed(pauseEventHandler);
                groupFiveRoot.setOnKeyPressed(pauseEventHandler);

                groupOneStage.setScene(new Scene(groupOneRoot, 200, 200));
                transferGroupOne(groupOneRoot);

                groupTwoStage.setScene(new Scene(groupTwoRoot, 200, 200));
                transferGroupTwo(groupTwoRoot);

                groupThreeStage.setScene(new Scene(groupThreeRoot, 200, 200));
                transferGroupThree(groupThreeRoot);

                groupFourStage.setScene(new Scene(groupFourRoot, 200, 200));
                transferGroupFour(groupFourRoot);

                groupFiveStage.setScene(new Scene(groupFiveRoot, 200, 200));
                transferGroupFive(groupFiveRoot);

                groupOneStage.setX(300);
                groupOneStage.setY(300);

                groupTwoStage.setX(300);
                groupTwoStage.setY(600);

                groupThreeStage.setX(600);
                groupThreeStage.setY(300);

                groupFourStage.setX(600);
                groupFourStage.setY(600);

                groupFiveStage.setX(900);
                groupFiveStage.setY(300);

                Stage[] stagesArray = {
                        groupOneStage,
                        groupTwoStage,
                        groupThreeStage,
                        groupFourStage,
                        groupFiveStage
                };

                stagesArray[0].show();
                displayTimeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

                    private int i = 1;

                    @Override
                    public void handle(ActionEvent event) {
                        if (i % stagesArray.length == 0) {
                            for (int j = 0; j < stagesArray.length; j++) {
                                stagesArray[j].hide();
                            }
                        }

                        stagesArray[i % stagesArray.length].show();
                        stagesArray[i % stagesArray.length].requestFocus();

                        i++;
                    }
                }));

                displayTimeline.setCycleCount(Animation.INDEFINITE);
                displayTimeline.play();

                windowScene.getWindow().hide();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
