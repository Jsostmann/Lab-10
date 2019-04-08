/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg10;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

/**
 *
 * @author jamesostmann
 */
public class CircleButton extends StackPane {
    
    private Label value;
    private Circle circle; 
    
    public CircleButton(String value) {
        
        this.setPrefSize(100.0,100.0);
        this.value = new Label(value);
        this.value.setTextFill(Color.WHITE);
        this.value.setFont(new Font(35.0));
        
        this.circle = new Circle();
        this.circle.setRadius(30.0);
        this.circle.setFill(Color.GOLD); 
        this.circle.setStroke(Color.BLACK); 
        this.circle.setStrokeWidth(2.0);
         
        
        this.getChildren().addAll(this.circle,this.value);
        
        
    }
    
    public CircleButton() {
        this(null);
    }
    
    public void setColor(Paint color) {
    
        this.circle.setFill(color);
        
    }
    public Paint getColor() {
        
        return this.circle.getFill();
    }
    
    public String getValue() {
        return this.value.getText();
    }
    
    
}
