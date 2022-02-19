//#============================================================================#
//#                 Abstract send / reterive data from database                #
//#============================================================================#
package database;

import database.gameinfo.*;
import database.playerinfo.*;
import java.util.Vector;
import database.playerinfo.Player.orderType;

/**
 *
 * @author Mh.El3basy
 */
public abstract class DBMethods {
    public static Boolean checkDBConnection() {
        if (GameModel.db.checkConnection()) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean addPlayer(String _username, String _passwd, String _status, long _score) {
        return PlayerModel.insertRecord(_username, _passwd, _status, _score);
    }

    public static boolean updateScore(String _username, long _newScore) {
        return PlayerModel.updateUsrFieldScore(_username, _newScore);
    }
    public static boolean updateStatus(String _username, String _newStatus) {
        return PlayerModel.updateUsrFieldStatus(_username, _newStatus);
    }
    public static boolean updateStatus(String _newStatus) {
        return PlayerModel.updateFieldStatus(_newStatus);
    }

    public static String getStatus(String _username) {
        return PlayerModel.selectStatusWhereUsr(_username);
    }

    public static boolean isRecordExists(String _username, String _passwd) {
        return PlayerModel.selectWhereUsrPass(_username, _passwd);
    }
    public static Player getPlayer(String _username, String _passwd) {
        return PlayerModel.selectPlayerWhereUsrPass(_username, _passwd);
    }
    public static Vector<Player> getAllRecords(String _status) {
        return PlayerModel.selectAllWhereStatus(_status);
    }

    public static Vector<Player> getAllRecords() {
        return PlayerModel.selectAllPlayers();
    }

    public static Vector<Player> getAllOrdered(String colName, orderType _order) {
        if (_order == orderType.ASC) {
            return PlayerModel.selectAllPlayersOrderByASC(colName);
        } else {
            return PlayerModel.selectAllPlayersOrderByDESC(colName);
        }
    }
    public static Vector<Player> getAllOrderedDesc(String colName) {
        return PlayerModel.selectAllPlayersOrderByDESC(colName);
    }
    public static Vector<Player> getAllOrderedAsc(String colName) {
        return PlayerModel.selectAllPlayersOrderByASC(colName);
    }

    public static boolean addNewGame(Game.cellType _turn, Game.cellType[] _board, String _player1, String _player2) {
        return GameModel.insertRecord(_turn, _board, _player1, _player2);
    }
    public static boolean deleteGame(long _gid) {
        return GameModel.deleteIdRecord(_gid);
    }
    public static Game getGame(long _gid) {
        return GameModel.selectGameWhereId(_gid);
    }
    public static Vector<Game> getGameList(String player) {
        return GameModel.selectAllWhereP1OrderedDescDate(player);
    }
}
