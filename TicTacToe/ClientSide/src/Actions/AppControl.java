///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package actions;
//
//
//import clientHandler.ClientHandler;
//import java.io.IOException;
//import javafx.application.Application;
//import static javafx.application.Application.launch;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//import org.json.simple.JSONObject;
//
//public class AppControl extends Application {
//
//    private static Scene scene;
//
////    @Override
////    public void start(Stage stage) throws IOException {
////        scene = new Scene(loadFXML("Login"));
////        stage.setScene(scene);
//////        stage.setFullScreen(true);
//////        stage.setMaximized(true);
////        stage.setTitle("Tic-Tac-ToeFX");
////        AppControl.setWindow(stage);
////
////        stage.setOnCloseRequest(e -> {
////            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
////            alert.setTitle("Wanna leave");
////            alert.setHeaderText("Are you sure you want to leave?!");
//////                    Optional<ButtonType> result = alert.showAndWait();
////            if (alert.showAndWait().get() == ButtonType.OK) {
////                stage.close();
////            }
////
////        });
////        stage.show();
////
////    }
////
////    static void setRoot(String fxml) throws IOException {
////        scene.setRoot(loadFXML(fxml));
////    }
////
////    private static Parent loadFXML(String fxml) throws IOException {
////        FXMLLoader fxmlLoader = new FXMLLoader(AppControl.class.getResource("/fxml/" + fxml + ".fxml"));
////        return fxmlLoader.load();
////    }
//private static Stage window;
////    private static Stage popUpWindow;
//
////    public static void setWindow(Stage stage) {
////        window = stage;
////    }
////
////    public static Stage getWindow() {
////        return window;
////    }
//
////    public static void setPopUpWindow(Stage stage) {
////        popUpWindow = stage;
////    }
////
////    public static Stage getPopUpWindow() {
////        return popUpWindow;
////    }
////#============================================================================#
////#                    handel move from page to another page                   #
////#============================================================================#
//
//    public static void moveTo(String targetFXML) throws IOException {
////        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
//        Parent root = FXMLLoader.load(AppControl.class.getResource("/fxml/" + targetFXML + ".fxml"));
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add("../Styles/Styles.css");
//        window.setScene(scene);
//        window.setResizable(false);
////        window.setMaximized(true);
////        window.setFullScreen(true);
//        window.show();
//    }
////#============================================================================#
////#                       handel create popup window                           #
////#============================================================================#
//
////    public static void createPopup(String targetFXML, String title) throws IOException {
////        FXMLLoader fxmlLoader = new FXMLLoader(AppControl.class.getResource("/customPopupsFXML/" + targetFXML + ".fxml"));
////        Parent root = (Parent) fxmlLoader.load();
////        Stage stage = new Stage();
////        stage.setScene(new Scene(root));
////        stage.setTitle(title);
////        popUpWindow = stage;
//////        stage.setAlwaysOnTop(true);
////        stage.initModality(Modality.APPLICATION_MODAL);
////        stage.showAndWait();
////    }
//    
//     boolean connected = false;
//    Thread readerThread;
//    Parent root;
//    
//    @Override
//    public void init()
//    {
//        connected = ClientHandler.connectToServer();
//    }
//    
//    @Override
//    public void start(Stage stage) throws Exception {
//        if (connected){
//
//            root = FXMLLoader.load(getClass().getResource("Login.fxml"));
//            
//            readerThread = new Thread(new ClientHandler.recieveRespone());
//            readerThread.start();
//        }
//        else{
//
//            root = FXMLLoader.load(getClass().getResource("ConnProblem.fxml"));
//        }
//
//        Scene scene = new Scene(root);
//        ClientHandler.setWindow(stage);
//        stage.resizableProperty().setValue(false);
//        stage.setScene(scene);
//        stage.show();
//    }
//    
//    @Override
//    public void stop(){
//        
//        if(connected){
//            JSONObject msg = new JSONObject();
//            if(ClientHandler.getCurrentScene().equals("Multiple")){
//                msg.put("type","gameQuit");
//                msg.put("errorMsg", "clientDropped");
//                ClientHandler.sendRequest(msg);
//            }
//            msg = new JSONObject();
//            msg.put("type","signout");
//            ClientHandler.sendRequest(msg);
//            
//            ClientHandler.closeCon();
//            readerThread.stop();
//        }
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}


//import clientHandler.ClientHandler;
//import java.io.IOException;
//import javafx.application.Application;
//import static javafx.application.Application.launch;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//import org.json.simple.JSONObject;
//
//public class AppControl  {
//
//
//    private static Stage window;
//    private static Stage popUpWindow;
//
//    public static void setWindow(Stage stage) {
//        window = stage;
//    }
//
//    public static Stage getWindow() {
//        return window;
//    }
//
//    public static void setPopUpWindow(Stage stage) {
//        popUpWindow = stage;
//    }
//
//    public static Stage getPopUpWindow() {
//        return popUpWindow;
//    }
////#============================================================================#
////#                    handel move from page to another page                   #
////#============================================================================#
//
//    public static void moveTo(String targetFXML) throws IOException {
////        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
//        Parent root = FXMLLoader.load(AppControl.class.getResource("/fxml/" + targetFXML + ".fxml"));
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add("../Styles/Styles.css");
//        window.setScene(scene);
//        window.setResizable(false);
////        window.setMaximized(true);
////        window.setFullScreen(true);
//        window.show();
//    }
//}
////#============================================================================#
////#                       handel create popup window                           #
////#============================================================================#
//
////    public static void createPopup(String targetFXML, String title) throws IOException {
////        FXMLLoader fxmlLoader = new FXMLLoader(AppControl.class.getResource("/customPopupsFXML/" + targetFXML + ".fxml"));
////        Parent root = (Parent) fxmlLoader.load();
////        Stage stage = new Stage();
////        stage.setScene(new Scene(root));
////        stage.setTitle(title);
////        popUpWindow = stage;
//////        stage.setAlwaysOnTop(true);
////        stage.initModality(Modality.APPLICATION_MODAL);
////        stage.showAndWait();
////    }
////}
////    
//
//
