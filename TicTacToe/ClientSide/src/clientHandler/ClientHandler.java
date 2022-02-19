/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientHandler;

import controllers.DashboardController;
import controllers.HomePageController;
import controllers.LoginController;
import controllers.MultiplePlayerController;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import Actions.AppControl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import controllers.LoginController;
import controllers.DashboardController;
import controllers.InviteController;
import clientHandler.GameHandler;
import controllers.InvitationController;
import controllers.LoadGameController;

/**
 *
 * @author ahmed
 */
public class ClientHandler {

    private static Socket clientSocket;
    private static DataInputStream ds;
    private static Stage window;
    private static Player player;
    private static String currentScene;
    private static DataOutputStream ps;
    private static LoginController loginctrl;
    private static HomePageController homePage;
    private static DashboardController dashboard;
    private static LoadGameController loadGame;
    private static InviteController invite;
//    private static PlayingModeFXMLController Playmodectrl;
    private static InvitationController invitation;
    private static MultiplePlayerController multiGame;
    private static ObservableList<String> nameList = FXCollections.observableArrayList();
    private static ObservableList<String> statusList = FXCollections.observableArrayList();
    private static ObservableList<String> scoreList = FXCollections.observableArrayList();
    private static ObservableList<String> games = FXCollections.observableArrayList();
    private static String invitingUsername;
    private static boolean gameAccepted = false;
    private static boolean replay = false;
    private static JSONArray gamesFullInfo;
    private static char[][] gameBoard = new char[3][3];
    private static char nextMove;
    private static boolean isLoaded = false;
    private static String nextPlayer;
    private static boolean clientDropped = false;
    private static boolean isConnected;

      public static void setLoginCtrl(LoginController ctrl) {
        loginctrl=ctrl;
    }
    public static void setDashboardCtrl(DashboardController ctrl) {
        dashboard = ctrl;
    }

    public static void setNewgameCtrl(HomePageController ctrl) {
        homePage = ctrl;
    }

    public static void setLoadgameCtrl(LoadGameController ctrl) {
        loadGame = ctrl;
    }

    public static void setInviteCtrl(InviteController ctrl) {
        invite = ctrl;
    }
//    public static void setPlaymodeCtrl(PlayingModeController ctrl){
//       Playmodectrl=ctrl;
//    }

    public static void setInvitationCtrl(InvitationController ctrl) {
        invitation = ctrl;
    }

    public static void setMultigameCtrl(MultiplePlayerController ctrl) {
        multiGame = ctrl;
    }
 public static void setWindow(Stage stage) {
        window = stage;
    }
    public static Stage getWindow() {
        return window;
    }
     @FXML
    public static void changeScene(String newScene)
    {   
        setCurrentScene(newScene);
        Platform.runLater(() -> {   
            try {
                //err=> ClientHandler.class
                Parent root = FXMLLoader.load(ClientHandler.class.getResource("./fxml"+newScene+".fxml"));
                Scene scene = new Scene(root);
                window.setScene(scene);
                window.setResizable(false);
                window.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
    
    public static boolean connectToServer() {
        boolean result = true;
        try {
            clientSocket = new Socket("127.0.0.1", 7777);
            ds = new DataInputStream(clientSocket.getInputStream());
            ps = new DataOutputStream(clientSocket.getOutputStream());

        } catch (IOException ex) {
            result = false;
        }
        System.out.println(result);
        return result;
    }

    public static void closeCon() {
        try {
            ps.close();
            ds.close();
            clientSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void sendRequest(JSONObject jsonMsg) {
        try {
//            connectToServer();
//            System.out.println(ps);
   
            ps.writeUTF(jsonMsg.toJSONString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static class recieveRespone implements Runnable {

        boolean running = true;
        String response;

        @Override
        public void run() {
            while (running) {
                try {
                    response = ds.readUTF();
                    if (response != null) {
                        handleResponse(response);
                    }
                } catch (IOException ex) {
                    running = false;
                    try {
                        
                        AppControl.moveTo("ConnProblem");
                    } catch (IOException ex1) {
                        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        }
    }

    private static void handleResponse(String response) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonMsg = (JSONObject) parser.parse(response);
            switch (jsonMsg.get("type").toString()) {
                case "signin":
                    login(jsonMsg);
                    break;
                case "signup":
                    signUp(jsonMsg);
                    break;
                case "updateStatus":
                    updateStatus(jsonMsg);
                    break;
                case "updateList":
                    updateList(jsonMsg);
                    break;
                case "invitation":
                    invitationRequest(jsonMsg);
                    break;
                case "sendMove":
                    getMoveReponse(jsonMsg);
                    break;
                case "gameStarted":
                    GameStartedResponse(jsonMsg);
                    break;
//                case "sendChat":
//                    //sendChatResponse(jsonMsg);
//                    break;
                case "gameEnded":
                    gameEndedResponse(jsonMsg);
                    break;
                case "getGames":
                    displayGamesList(jsonMsg);
                    break;
                case "loadGame":
                    loadGameResponse(jsonMsg);
                    break;
                case "invitationResponse":
                    getInvitationResponse(jsonMsg);
                    break;
                case "saveGame":
                    saveGameResponse(jsonMsg);
                    break;
                case "gameQuit":
                    gameQuitResponse(jsonMsg);
                    break;
            }
        } catch (ParseException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setCurrentScene(String scene) {
        currentScene = scene;
    }

    public static String getCurrentScene() {
        return currentScene;
    }

    public static boolean getGameAccepted() {
        return gameAccepted;
    }

    public static void setReplay(boolean replay) {
        ClientHandler.replay = replay;
    }

    public static boolean getReplay() {
        return replay;
    }

    public static JSONArray getGames() {
        return gamesFullInfo;
    }

    public static ObservableList<String> getNameList() {
        return nameList;
    }

    public static ObservableList<String> getStatusList() {
        return statusList;
    }

    public static ObservableList<String> getScoreList() {
        return scoreList;
    }

    public static char[][] getBoard() {
        return gameBoard;
    }

    public static void setIsLoaded(boolean isloaded) {
        isLoaded = isloaded;
    }

    public static boolean getIsLoaded() {
        return isLoaded;
    }

    public static char getNextMove() {
        return nextMove;
    }

    public static String getNextPlayer() {
        return nextPlayer;
    }

    public static boolean getClientDropped() {
        return clientDropped;
    }

    public static void setPlayer(Player p) {
        player = p;
    }

    public static Player getPlayer() {
        return player;
    }

    private static void getData(JSONObject response) {
        player.setScore(Integer.parseInt(response.get("score").toString()));
        player.setUsername(response.get("username").toString());
        player.setStatus(response.get("status").toString());
        try {
            AppControl.moveTo("Welcome");
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void login(JSONObject response) {
        String request = response.get("type").toString();
        String resStatus = response.get("responseStatus").toString();
        if (resStatus.equals("true")) {
//            getData(response);
        player.setScore(Integer.parseInt(response.get("score").toString()));
        player.setUsername(response.get("username").toString());
        player.setStatus(response.get("status").toString());
            try {
                AppControl.moveTo("Welcome");
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            String error = response.get("errorMsg").toString();
            String warning;
            if (request.equals("signin") && error.equals("signedin")) {
                warning = ("You are already signed in.");
            } else if (request.equals("signin") && error.equals("fail")) {
                warning = "Wrong user name or password";
            } else {
                warning = "unexpected";
            }
             Platform.runLater(() -> {loginctrl.getWarning().setText(warning);});
            
        }
    }

    private static void signUp(JSONObject response) {
        String request = response.get("type").toString();
        String resStatus = response.get("responseStatus").toString();
        if (resStatus.equals("true")) {
            getData(response);
        } else {
            String error = response.get("errorMsg").toString();
            String warning;
            if (request.equals("signup") && error.equals("fail")) {
                warning = "Username already exists.";
            } else {
                warning = "unexpected";
            }
           Platform.runLater(() -> {loginctrl.getWarning().setText(warning);});
        }
    }

    private static void updateStatus(JSONObject response) {
        String resStatus = response.get("responseStatus").toString();
    }

    private static void updateList(JSONObject response) {
        JSONObject JSONplayer;
        JSONParser parser = new JSONParser();
        JSONArray list = (JSONArray) response.get("list");
        nameList = FXCollections.observableArrayList();
        statusList = FXCollections.observableArrayList();
        scoreList = FXCollections.observableArrayList();
        for (int i = 0; i < list.size(); i++) {
            try {
                JSONplayer = (JSONObject) parser.parse(list.get(i).toString());
                nameList.add(JSONplayer.get("username").toString());
                scoreList.add(JSONplayer.get("score").toString());
                statusList.add(JSONplayer.get("status").toString());
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        switch (currentScene) {
            case "Dashboard":
                Platform.runLater(() -> {
                    dashboard.updateTable(nameList, scoreList, statusList);
                });
                break;
            case "Multiple":
                Platform.runLater(() -> {
                    invite.updateTable(nameList, scoreList, statusList);
                });
                break;
            case "LoadGame":
                Platform.runLater(() -> {
                    loadGame.updateTable(nameList, scoreList, statusList);
                });
                break;
            default:
                break;
        }
    }

    public static void invitePlayerRequest(String invitedPlayerUsername) {
        JSONObject inviteRequest = new JSONObject();
        inviteRequest.put("type", "invitePlayer");
        inviteRequest.put("username", invitedPlayerUsername);
        inviteRequest.put("newGame", true);
        ClientHandler.sendRequest(inviteRequest);
    }

    private static void getInvitationResponse(JSONObject response) {

        String resStatus = response.get("responseStatus").toString();
        String inviteStatus = response.get("invitationStatus").toString();
        String username = response.get("username").toString();
        String newGame = response.get("newGame").toString();

        if (resStatus.equals("true")) {
            if (newGame.equals("true")) {
                newGameInviteHandler(username, inviteStatus);
            } else if (newGame.equals("false")) {
                replayGameInviteHandler(username, inviteStatus);
            }
        }
    }

    private static void newGameInviteHandler(String username, String inviteStatus) {
        if (inviteStatus.equals("true")) {
            player.setInvited(false);
            player.setOpponent(username);
            gameAccepted = true;
            if (replay) {
                Platform.runLater(() -> {
                    multiGame.getWaitingLbl().setText(username + " accepted your invitation, Waiting for game to start.");
                });
            } else {
                Platform.runLater(() -> {
                    invite.getWaitingLbl().setText(username + " accepted your invitation, Waiting for game to start.");
                });
            }
        } else {
            gameAccepted = false;
            if (replay) {
                Platform.runLater(() -> {
                    multiGame.getWaitingLbl().setText(username + " declined your invitation.");
                    multiGame.getOkBtn().setDisable(false);
                });
            } else {
                Platform.runLater(() -> {
                    invite.getWaitingLbl().setText(username + " declined your invitation.");
                    invite.getOkBtn().setDisable(false);
                });
            }
        }
    }

    private static void replayGameInviteHandler(String username, String inviteStatus) {
        if (inviteStatus.equals("false")) {
            Platform.runLater(() -> {
                loadGame.getwaitingLbl().setText("Player rejected your request");
                loadGame.requestRejectionHandler();
            });
        }
        if (inviteStatus.equals("true")) {
            player.setOpponent(username);
        }
    }

    private static void invitationRequest(JSONObject request) {
        String username = request.get("username").toString();
        String newGame = request.get("newGame").toString();
        invitingUsername = username;
        try {
            AppControl.moveTo("Invitation");
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        Platform.runLater(() -> {
            if (newGame.equals("false")) {
                String date = request.get("date").toString();
                invitation.getInvitationLabel().setText("Player " + username + " is inviting you to replay an old game.\n Date: [" + date + "]\n Do you accept?");
            } else {
                invitation.getInvitationLabel().setText("Player " + username + " is inviting you to a new game.\n Do you accept?");
            }
        });
    }

    public static void invitationResponse(String response) {
        JSONObject inviteResponse = new JSONObject();
        inviteResponse.put("type", "invitation");
        inviteResponse.put("invitationStatus", response);
        ClientHandler.sendRequest(inviteResponse);
        if (response == "true") {
            player.setOpponent(invitingUsername);
        }
    }

    private static void GameStartedResponse(JSONObject response) {
        String resStatus = response.get("responseStatus").toString();
        if (resStatus.equals("true")) {
            if (replay) {
                if (player.getInvited()) {
                    try {
                        Platform.runLater(() -> {
                            invitation.getWaitingLbl().setText("Game established, Start Playing!");
                            invitation.getStartBtn().setDisable(false);
                        });
                        AppControl.moveTo("Multiple");
                    } catch (IOException ex) {
                        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Platform.runLater(() -> {
                        multiGame.getWaitingLbl().setText("Game established, Start Playing!");
                        multiGame.getOkBtn().setDisable(false);
                    });
                }
            } else {
                if (player.getInvited()) {
                    Platform.runLater(() -> {
                        invitation.getWaitingLbl().setText("Game established, Start Playing!");
                        invitation.getStartBtn().setDisable(false);
                    });
                } else {
                    Platform.runLater(() -> {
                        invite.getWaitingLbl().setText("Game established, Start Playing!");
                        invite.getOkBtn().setDisable(false);
                    });
                }
                try {
                    AppControl.moveTo("Multiple");
                } catch (IOException ex) {
                    Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void gameEndedRequest(String winner, boolean isDraw, String errorMsg) {
        JSONObject gameEnded = new JSONObject();
        gameEnded.put("type", "gameEnded");
        gameEnded.put("responseStatus", "true");
        gameEnded.put("username", winner);
        gameEnded.put("isDraw", isDraw);
        gameEnded.put("errorMsg", errorMsg);
        ClientHandler.sendRequest(gameEnded);

        isLoaded = false;
    }

    private static void gameQuitResponse(JSONObject response) {

        String resStatus = response.get("responseStatus").toString();
        if (resStatus.equals("true")) {
            gameAccepted = false;
            Platform.runLater(() -> {
                multiGame.getWaitingSubscene().setVisible(true);
                multiGame.getOkBtn().setDisable(false);
                multiGame.getWaitingLbl().setText("Client has dropped from the game");
            });
        }
    }

    private static void gameEndedResponse(JSONObject response) {
        String errormsg = response.get("errorMsg").toString();
        if (errormsg.equals("")) {
            String newScore = response.get("score").toString();
            player.setScore(Integer.parseInt(newScore));
        } else if (errormsg.equals("clientDropped")) {
            gameAccepted = false;
            Platform.runLater(() -> {
                multiGame.getWaitingSubscene().setVisible(true);
                multiGame.getWaitingLbl().setText("Client has dropped from the game");
            });
        }
        isLoaded = false;
    }

    public static void sendMoveRequest(int row, int col) {
        JSONObject sendMoveRequest = new JSONObject();
        sendMoveRequest.put("type", "sendMove");
        sendMoveRequest.put("row", (Integer) row);
        sendMoveRequest.put("col", (Integer) col);
        ClientHandler.sendRequest(sendMoveRequest);
    }

    private static void getMoveReponse(JSONObject response) {
        int row = Integer.parseInt(response.get("row").toString());
        int col = Integer.parseInt(response.get("col").toString());
        GameHandler.btnPosition move = new GameHandler.btnPosition(row, col);
        GameHandler.setMoveOfNextPlayer(move);
        Platform.runLater(() -> {
            multiGame.secondPlayerMove();
        });
    }

    public static void saveGameRequest(String nextMove) {
        JSONObject saveGame = new JSONObject();
        saveGame.put("type", "saveGame");
        saveGame.put("nextMove", nextMove);
        ClientHandler.sendRequest(saveGame);
        Platform.runLater(() -> {
            multiGame.getSavingSubscene().setVisible(true);
        });
    }

    private static void saveGameResponse(JSONObject response) {
        String resStatus = response.get("responseStatus").toString();
        if (resStatus.equals("true")) {
            Platform.runLater(() -> {
                multiGame.getSavingSubscene().setVisible(true);
                multiGame.getSavingLbl().setText("Game saved successfully.");
                multiGame.getHomtBtn().setDisable(false);
            });
        }
    }

    public static void loadGameRequest(String invitedPlayerUsername, Long gameId) {
        JSONObject loadGameReq = new JSONObject();
        loadGameReq.put("type", "invitePlayer");
        loadGameReq.put("username", invitedPlayerUsername);
        loadGameReq.put("newGame", false);
        loadGameReq.put("gameId", gameId);
        sendRequest(loadGameReq);
    }

    private static void loadGameResponse(JSONObject response) {
        String resStatus = response.get("responseStatus").toString();
        JSONParser parser = new JSONParser();
        if (resStatus.equals("true")) {
            JSONArray board = (JSONArray) response.get("gameboard");
            nextMove = response.get("nextMove").toString().charAt(0);

            String xPlayer = response.get("xPlayer").toString();
            String oPlayer = response.get("oPlayer").toString();
            char[] board1D = new char[9];
            if (nextMove == 'X') {
                nextPlayer = xPlayer;
            } else if (nextMove == 'O') {
                nextPlayer = oPlayer;
            }
            for (int i = 0; i < board.size(); i++) {
                board1D[i] = board.get(i).toString().charAt(0);
            }
            gameBoard = GameHandler.convertToTwoDimension(board1D);
            isLoaded = true;
            if (player.getInvited()) {
                Platform.runLater(() -> {
                    try {
                        AppControl.moveTo("MultiPlayer");
                    } catch (IOException ex) {
                        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            } else {
                Platform.runLater(() -> {
                    try {
                        AppControl.moveTo("MultiPlayer");
                    } catch (IOException ex) {
                        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
        }
    }

    private static void displayGamesList(JSONObject response) {

        games = FXCollections.observableArrayList();
        JSONParser parser = new JSONParser();
        gamesFullInfo = (JSONArray) response.get("gamesList");
        JSONObject game = new JSONObject();

        for (int i = 0; i < gamesFullInfo.size(); i++) {

            try {
                game = (JSONObject) parser.parse(gamesFullInfo.get(i).toString());
                games.add((i + 1) + ". [" + game.get("date").toString() + "] with " + game.get("player").toString());
            } catch (ParseException ex) {
            }
        }
        Platform.runLater(() -> {
            loadGame.displayGames(games);
        });
    }
}