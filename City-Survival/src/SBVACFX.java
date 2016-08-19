
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class SBVACFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Board b = new Board();
        b.onLaunch();
        Player p1 = new Player();
        //Rule Scene
                
        Image img2 = new Image("Ahn.jpg");
        ImageView iv2 = new ImageView(img2);
        
        Image img3 = new Image("Tucker.jpg");
        ImageView iv3 = new ImageView(img3);
        
        Image img4 = new Image("song.jpg");
        ImageView iv4 = new ImageView(img4);
        
        Image img5 = new Image("ktm.jpg");
        ImageView iv5 = new ImageView(img5);

        
        Text rules = new Text(" You are alone in enemy territory, kekeroni pepperoni fettucini spaguetti baguetti. \n\n " + 
                    "On your way to the first hackathon at hackBU, you discover that Stony Brook University launched nukes to Binghamton"
                    + " and it is now a war-zone.\n" + "Apparently, Trump got voted president and hell broke loose! The AMS department, furious over Bernie Sanders' loss"
                    + " (Bernie and Alan Tucker are similar\n in that they are both MVPs). Kappa.\n\n" + "You find yourself in a 5x5 grid in 2D space somehow. (Don't worry about it.) Try your best to survive.\n"
                    + "You begin with 5 health, and lose if the number drops to zero. You win if you gather all 7 pieces of the radio "
                    + "and land on the evac tile.\n" + "Reality has suddenly turned into a turn-based game, because LSD. You have four actions available per turn, each usage takes one from"
                    + " your turn total. \nSo, for example, you could spend your turn moving 4 times.\n"
                    + "\n1) Move a tile in any of 4 directions (w/a/s/d); you may not move onto tiles that currently hold enemies"
                    + "\n2) Kill an enemy (w/a/s/d) which can be performed on adjacent tiles"
                    + "\n3) Search the area, only available if there are no enemies on that tile. Searching tiles will yield different results;"
                    + " There is 1 evac tile, 7 radio piece tiles,\n 3 Hospitals (that will heal you for 2), 2 Fake Hospitals (controlled by"
                    + " the enemy; they will decrease your health by 1), 10 equipment tiles, and 2 ambush tiles,\n which decrease your health by one."
                    + "\n4) Use an equipment that you have already collected.\n\n"
                    + "There are 4 types of equipment. 3 nukes, 3 health packs, 3 satellite images, and 1 pack of Monster Energy drinks."
                    + "A nuke allows you to pick any tile and kill \nall enemies on that tile. A health pack will immediately restore 2 health."
                    + "A satellite image will allow you to peek at the \ncontents of any tile; for example, if the Hospital is a fake or not."
                    + "The pack of Monster Energy drinks \nis so OP that it will give you another 5 actions free- one to make up for using the equipment.\n");
        
        Button btn = new Button("Continue");
        
        Image img = new Image("pic.jpg");
        ImageView iv = new ImageView(img);

        
        
        FlowPane p = new FlowPane();
        p.getChildren().addAll(rules, btn);
        p.getChildren().addAll(iv, iv2, iv3, iv4, iv5);
        
        Scene ruleScene = new Scene(p, 1020, 600);
        primaryStage.setTitle("SBVAC");
        primaryStage.setScene(ruleScene);
   
        //Main Scene
        //Center
        ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
        for(int i = 0; i < Board.board.length; i++){
            for(int j = 0; j < Board.board[0].length; j++){
                Rectangle rect = new Rectangle(80,80);
                //if(b.board[i][j] == b.board[2][2])
                //    rect.setFill(Color.BLUE); PLAYER STARTING LOCATION
                rect.setFill(tileTypeInt(b.board[i][j].getType()));
//rect.setFill(tileTypeInt(Board.board[i][j].getType()));//puts int into tileTypeInt
                rects.add(rect);
            }
        }
        int count = 0; 
        for(int i  = 0; i < Board.board.length; i++){
            for(int j = 0; j < Board.board[0].length; j++){
                Board.board[i][j].corRect = count;
                count++;
            }
        }
        
        StackPane player =new StackPane();
        Text pt = new Text("P");
        player.getChildren().addAll(rects.get(Board.board[p1.getX()][p1.getY()].corRect), pt);
            
       int counter = 0;
        HBox hbox1 = new HBox();
        hbox1.setPadding(new Insets(10));
        hbox1.setSpacing(10);
        for(int i = 0; i < 5; i++){
            Text enemies = new Text("" + Board.board[i][0].getEnemyCount());
            StackPane stackPane = new StackPane(); 
            stackPane.getChildren().addAll(rects.get(counter), enemies);
            counter++;
            hbox1.getChildren().add(stackPane);
        }
        HBox hbox2 = new HBox();
        hbox2.setPadding(new Insets(10));
        hbox2.setSpacing(10);
        for(int i = 5; i < 10; i++){
            Text enemies = new Text("" + Board.board[i-5][1].getEnemyCount());
            StackPane stackPane = new StackPane(); 
            stackPane.getChildren().addAll(rects.get(counter), enemies);
            counter++;
            hbox2.getChildren().add(stackPane);
        }
        HBox hbox3 = new HBox();
        hbox3.setSpacing(10);
        hbox3.setPadding(new Insets(10));
        for(int i = 10; i < 15; i++){
            Text enemies = new Text("" + Board.board[i-10][2].getEnemyCount());
            StackPane stackPane = new StackPane(); 
            stackPane.getChildren().addAll(rects.get(counter), enemies, pt);
            counter++;
            hbox3.getChildren().add(stackPane);
        }
        HBox hbox4 = new HBox();
        hbox4.setSpacing(10);
        hbox4.setPadding(new Insets(10));
        for(int i = 15; i < 20; i++){
            Text enemies = new Text("" + Board.board[i-15][3].getEnemyCount());
            StackPane stackPane = new StackPane(); 
            stackPane.getChildren().addAll(rects.get(counter), enemies);
            counter++;
            hbox4.getChildren().add(stackPane);
        }
        HBox hbox5 = new HBox();
        hbox5.setSpacing(10);
        hbox5.setPadding(new Insets(10));
        for(int i = 20; i < 25; i++){
            Text enemies = new Text("" + Board.board[i-20][4].getEnemyCount());
            StackPane stackPane = new StackPane(); 
            stackPane.getChildren().addAll(rects.get(counter), enemies);
            counter++;
            hbox5.getChildren().add(stackPane);
        }
        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5);

        
        BorderPane pane = new BorderPane();
        pane.setCenter(vbox);
        Scene scene = new Scene(pane, 1020, 600);
        
        btn.setOnAction(e -> {
            primaryStage.setScene(scene);
            
        });
       
        primaryStage.show();
        
        //Top Pane
        
        //Bottom Pane
        HBox invent = new HBox();
        for(int i =0; i < p1.inventory.size(); i++){
            Text t = new Text(""+p1.inventory.get(i));
            invent.getChildren().add(t);
        }
        
        //Left Pane
        
        //Right pane
        Text colorKey = new Text(700,50,"EVAC Tile: Green\nPiece Tile: Gold\nAmbush Tile: Black\nCovered Tile: Light Gray\nHospital Tile: Red\nFake Hospital: Black\nPossible Hospital"
                + " Tile: Pink\nPlayer Location: Blue");
        
       //FIGURE OUT HOW TO FIX THIS...
        
        ChoiceBox<String> cb = new ChoiceBox<>();
        cb.getItems().addAll("Move 1 tile","Kill 1 enemy","Search the area","Use equipment");
        cb.getSelectionModel().selectFirst();
        
        Text action = new Text("Actions remaining: " + Board.actions);
        
        ChoiceBox<Character> cb2 = new ChoiceBox<>();
        cb2.getItems().addAll('w','a','s','d');
        cb2.getSelectionModel().selectFirst();
        
        ChoiceBox<String> cb3 = new ChoiceBox<>();
        cb3.getItems().addAll("Nuke","Health Pack","Satellite Image","Extra Actions");
        cb3.getSelectionModel().selectFirst();
        
        
        Text health = new Text("Health: "+p1.getHealth());
        Text drawn = new Text();
        
        Button submit = new Button("Submit Move");
        submit.setOnAction(e -> {
            p1.inventory.add(Equipment.giveEquipment());
            switch(cb.getValue()){
                case "Move 1 tile":
                    p1.movePlayer(cb2.getValue());           
                    break;
                case "Kill 1 enemy":
                    p1.killEnemy(cb2.getValue());
                    break;
                case "Search the area":
                    p1.searchArea(Board.board[p1.getX()][p1.getY()]);
                    break;
                case "Use equipment":       
                    int item = -1;
                    String input = cb3.getValue();
                    if(input.equals("Nuke"))
                        item = Equipment.NUKE;
                    else if(input.equals("Health Pack"))
                        item = Equipment.HEALTH_PACK;
                    else if(input.equals("Satellite Image"))
                        item = Equipment.SATELLITE_IMAGE;
                    else if(input.equals("Extra Actions"))
                        item = Equipment.EXTRA_ACTIONS;
                    p1.useEquip(item);
            }
            action.setText("Actions remaining: " + Board.actions);
            if(Board.actions == 0){
                drawn.setText(""+ b.drawCards(3, p1));
                    
                Board.actions += 4;
                
                
            }
            health.setText("Health: " + p1.getHealth());
            for(int i =0; i < p1.inventory.size(); i++){
                Text t = new Text(""+p1.inventory.get(i));
                invent.getChildren().add(t);
             }
        });
        
        VBox leftVbox = new VBox();
        leftVbox.getChildren().addAll(health, cb, cb2, cb3, submit, action, drawn);
        
       
        pane.getChildren().addAll(colorKey);
        pane.setLeft(leftVbox);
        pane.setBottom(invent);
    
    }

    public Color tileTypeInt(int t){
        if(Tile.HOSPITAL_TILE == t || Tile.FAKE_TILE == t){
            return Color.PINK;
        }
        else {
            return Color.LIGHTGRAY;
        }
    }
    
    public Color colorWhenFlipped(int t){ 
        switch(t){
                case Tile.EVAC_TILE:
                   return Color.GREEN;
                
                case Tile.PIECE_TILE:
                    return Color.GOLD;
                
                case Tile.AMBUSH_TILE:
                    return Color.BLACK;
                    
                case Tile.HOSPITAL_TILE:
                    return Color.TOMATO;
                    
                case Tile.FAKE_TILE:
                    return Color.BLACK;      
        }    
        return null;
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
