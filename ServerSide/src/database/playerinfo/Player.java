//#============================================================================#
//#                              represents a player                           #
//#============================================================================#
package database.playerinfo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mh.El3basy
 */
public class Player {

    public static enum statusType {
        offline, online, busy, none
    }

    public static enum orderType {
        ASC, DESC
    }
    private static orderType order;

    public static orderType getOrder() {
        return Player.order;
    }

    public static void setOrder(orderType _order) {
        Player.order = _order;
    }

    private Long pid;
    private Long score;
    private String username;
    private String passwd;
    private statusType status;

    public Long getPid() {
        return pid;
    }

    public Long getScore() {
        return score;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswd() {
        return passwd;
    }

    public statusType getStatus() {
        return status;
    }

    public void setPid(Long _pid) {
        this.pid = _pid;
    }

    public void setScore(Long _score) {
        this.score = _score;
    }

    public void setUsername(String _username) {
        this.username = _username;
    }

    public void setPasswd(String _passwd) {
        this.passwd = _passwd;
    }

    public void setStatus(statusType _status) {
        this.status = _status;
    }

    public Player(Long score, String username, String passwd, statusType status) {
        this.score = score;
        this.username = username;
        this.passwd = passwd;
        this.status = status;
    }


    public Player(String username, String passwd) {
        this.username = username;
        this.passwd = passwd;
    }

    public Player(Long pid, String username, String passwd) {
        this.pid = pid;
        this.username = username;
        this.passwd = passwd;
    }

    public static Player createPlayer(ResultSet _rs) {
        Player p;
        try {
            p = new Player(_rs.getLong("pid"),
                    _rs.getString("username"), _rs.getString("passwd"));
            p.setStatus(Player.statusType.valueOf(_rs.getString("status")));
            p.setScore(_rs.getLong("score"));

        } catch (SQLException ex) {
            System.out.println("Error in Player createPlayer : " + ex.getMessage());
            return null;
        }
        return p;
    }

}
