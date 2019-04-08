/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg10;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author jamesostmann
 */
public class SimpleCalc extends Application {

    BorderPane window;
    HBox text, operators;
    GridPane buttons;
    CircleButtonHandler handler;
    OperatorButtonHandler btnHandler;

    @Override
    public void start(Stage stage) {

        window = new BorderPane();
        window.setStyle("-fx-background-color: grey"); 
        
        text = new HBox(new TextField(String.valueOf(0.0))); 
        
        
        operators = new HBox(new Button("√"), new Button("x²"), new Button("CLR"));

        operators.setAlignment(Pos.CENTER);

        buttons = new GridPane();

        handler = new CircleButtonHandler();
        btnHandler = new OperatorButtonHandler();

        initCalculator();

        window.setTop(text);
        window.setBottom(operators);
        window.setCenter(buttons);

        Scene scene = new Scene(window, 300, 300);
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();
    }

    private void initCalculator() {

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {

                double num = y * 3 + x + 1;

                CircleButton tempButton = new CircleButton(num + "");
                tempButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null,null))); 
                tempButton.setOnMousePressed(handler);
                tempButton.setOnMouseReleased(handler);
                buttons.add(tempButton, x, y);

            }

        }

        TextField t = (TextField) text.getChildren().get(0);
        t.setPrefWidth(300);
        t.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null,null))); 
        t.setEditable(false); 
        t.setFocusTraversable(false); 
        t.setStyle("-fx-focus-color: black"); 
        
        
        
        for (int i = 0; i < 3; i++) {

            Button btn = (Button) operators.getChildren().get(i);
            btn.setPrefWidth(100);
            btn.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null,null))); 
            btn.setStyle("-fx-focus-color: black"); 
            btn.setOnAction(btnHandler);
            btn.setFont(new Font(20.0)); 
        }
        
        
        window.setStyle("-fx-background-color: grey"); 
    }

    public static void main(String[] args) {
        launch(args);
    }

    class CircleButtonHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {

            CircleButton button = (CircleButton) event.getSource();
            TextField txt = (TextField) text.getChildren().get(0);

            double oldValue = Double.parseDouble(txt.getText());
            double newValue = Double.parseDouble(button.getValue());
            double total = oldValue + newValue;
            
            if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {

                button.setColor(Color.DARKBLUE);
                System.out.println("Mouse Pressed");

            } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                
                txt.setText(String.valueOf(total)); 
                button.setColor(Color.GOLD);
                System.out.println("Mouse Released");

            }

        }

    }

    class OperatorButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            Button btn = (Button) event.getSource();
            TextField t = (TextField) text.getChildren().get(0);
            
            double val;
       

            if ((Button) operators.getChildren().get(0) == btn) {
                
                val = Double.parseDouble(t.getText());
                val = Math.sqrt(val);
                
                t.setText(String.valueOf(val)); 

            } else if ((Button) operators.getChildren().get(1) == btn) {

                val = Double.parseDouble(t.getText());
                val *= val;
                
                t.setText(String.valueOf(val));
               
                
            } else {

                t.setText(String.valueOf(0.0)); 
                
            }
        }

    }

}
