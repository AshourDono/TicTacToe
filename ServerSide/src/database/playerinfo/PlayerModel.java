//#============================================================================#
//#               interface handle the plyaer table in database                #
//#============================================================================#
package database.playerinfo;

import database.DatabaseDriver;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Mh.El3basy
 */
public interface PlayerModel {

    static final DatabaseDriver db = new DatabaseDriver();
//use
    static String selectUserWhereId(Long _pid) {

        try {
            db.startConnection();
            if (db.getConnection() == null) {
                return null;
            }
            db.setStatement(db.getConnection().createStatement());
            db.setQuerystr("select username from players where pid= " + _pid);
            db.setResultSet(db.getStatement().executeQuery(db.getQuerystr()));

            if (db.getResultSet().next() == false) {
                db.endResultSet();
                db.endStatConnection();

                return " ";
            } else {
                String username = db.getResultSet().getString("username");
                db.endResultSet();
                db.endStatConnection();
                return username;
            }
        } catch (SQLException ex) {
            System.out.println("Error in player mode selectUserWhereId : " + ex.getMessage());
            return null;
        }
    }
//use
    static boolean insertRecord(String _username, String _passwd, String _status, long _score) {
        try {
            db.startConnection();
            if (db.getConnection() == null) {
                return false;
            }
            db.setStatement(db.getConnection().createStatement());

            int checkNew = db.getStatement().executeUpdate("INSERT INTO players ( username, passwd, status, score) VALUES( '" + _username + "', '" + _passwd + "', '" +  _status + "', " + _score + "' )");
            db.endStatConnection();
            if (checkNew >= 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error in player mode insertRecord : " + ex.getMessage());
            return false;
        }
    }

//    // update DML  update record [ id or user or user,pass]  and Field score or status [ user or user,pass ]
//    static boolean updateIdRecord(long _pid, String _username, String _passwd, String _email, String _status, long _score, String _avatar) {
//        try {
//            db.startConnection();
//            if (db.getConnection() == null) {
//                return false;
//            }
//            db.setStatement(db.getConnection().createStatement());
//
//            int checkUpdate = db.getStatement().executeUpdate("UPDATE players SET username= '" + _username + "' , passwd= '" + _passwd + "' , email= '" + _email + "' , status='" + _status + "' , score= " + _score + " ,avatar= '" + _avatar + "' WHERE pid = " + _pid);
//            db.endStatConnection();
//            if (checkUpdate >= 1) {
//                return true;
//            } else {
//                return false;
//            }
//            //db.endStatConnection();
//        } catch (SQLException ex) {
//            System.out.println("Error in player mode updateIdRecord : " + ex.getMessage());
//            return false;
//        }
//    }

//    static boolean updateUsrRecord(String _username, String _passwd, String _email, String _status, long _score, String _avatar) {
//        try {
//            db.startConnection();
//            if (db.getConnection() == null) {
//                return false;
//            }
//            db.setStatement(db.getConnection().createStatement());
//
//            int checkUpdate = db.getStatement().executeUpdate("UPDATE players SET passwd= '" + _passwd + "' , email= '" + _email + "' , status='" + _status + "' , score= " + _score + " ,avatar= '" + _avatar + "' WHERE username = '" + _username + "'");
//            db.endStatConnection();
//            if (checkUpdate >= 1) {
//                return true;
//            } else {
//                return false;
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Error in player mode updateUsrRecord : " + ex.getMessage());
//            return false;
//        }
//    }
//use
    static boolean updateUsrFieldStatus(String _username, String _status) {
        try {
            db.startConnection();
            if (db.getConnection() == null) {
                return false;
            }
            db.setStatement(db.getConnection().createStatement());

            int checkUpdate = db.getStatement().executeUpdate("UPDATE players SET status='" + _status + "' WHERE username = '" + _username + "'");
            db.endStatConnection();
            if (checkUpdate >= 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error in player mode updateUsrFieldStatus : " + ex.getMessage());
            return false;
        }
    }
//use
    static boolean updateFieldStatus(String _status) {
        try {
            db.startConnection();
            if (db.getConnection() == null) {
                return false;
            }
            db.setStatement(db.getConnection().createStatement());

            int checkUpdate = db.getStatement().executeUpdate("UPDATE players SET status='" + _status + "'");
            db.endStatConnection();
            if (checkUpdate >= 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error in player mode updateFieldStatus : " + ex.getMessage());
            return false;
        }
    }
//use
    static boolean updateUsrFieldScore(String _username, long _score) {
        try {
            db.startConnection();
            if (db.getConnection() == null) {
                return false;
            }
            db.setStatement(db.getConnection().createStatement());

            int checkUpdate = db.getStatement().executeUpdate("UPDATE players SET score=" + _score + " WHERE username = '" + _username + "'");
            db.endStatConnection();
            if (checkUpdate >= 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Error in player mode updateUsrFieldScore : " + ex.getMessage());
            return false;
        }
    }

//    static boolean updateUsrPassRecord(String _username, String _passwd, String _email, String _status, long _score, String _avatar) {
//        try {
//            db.startConnection();
//            if (db.getConnection() == null) {
//                return false;
//            }
//            db.setStatement(db.getConnection().createStatement());
//
//            int checkUpdate = db.getStatement().executeUpdate("UPDATE players SET email= '" + _email + "' , status='" + _status + "' , score= " + _score + " ,avatar= '" + _avatar + "' WHERE username = '" + _username + "' and passwd= '" + _passwd + "'");
//            db.endStatConnection();
//            if (checkUpdate >= 1) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error in player mode updateUsrPassRecord : " + ex.getMessage());
//            return false;
//        }
//    }

//    static boolean updateUsrPassFieldStatus(String _username, String _passwd, String _status) {
//        try {
//            db.startConnection();
//            if (db.getConnection() == null) {
//                return false;
//            }
//            db.setStatement(db.getConnection().createStatement());
//
//            int checkUpdate = db.getStatement().executeUpdate("UPDATE players SET status='" + _status + "' WHERE username = '" + _username + "' and passwd= '" + _passwd + "'");
//            db.endStatConnection();
//            if (checkUpdate >= 1) {
//                return true;
//            } else {
//                return false;
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Error in player mode updateUsrPassFieldStatus : " + ex.getMessage());
//            return false;
//        }
//    }

//    static boolean updateUsrPassFieldScore(String _username, String _passwd, long _score) {
//        try {
//            db.startConnection();
//            if (db.getConnection() == null) {
//                return false;
//            }
//            db.setStatement(db.getConnection().createStatement());
//
//            int checkUpdate = db.getStatement().executeUpdate("UPDATE players SET score='" + _score + "' WHERE username = '" + _username + "' and passwd= '" + _passwd + "'");
//            db.endStatConnection();
//            if (checkUpdate >= 1) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error in player mode updateUsrPassFieldScore : " + ex.getMessage());
//            return false;
//        }
//    }

    // delete DML  with id or username or mail or user,pass or mail,pass
//    static boolean deleteIdRecord(long _pid) {
//        try {
//            db.startConnection();
//            if (db.getConnection() == null) {
//                return false;
//            }
//            db.setStatement(db.getConnection().createStatement());
//
//            int checkDelete = db.getStatement().executeUpdate("DELETE FROM players WHERE pid=" + _pid);
//            db.endStatConnection();  // for statment with no resultset
//            if (checkDelete >= 1) {
//                return true;
//
//            } else {
//                return false;
//            }
//            //db.endStatConnection();
//        } catch (SQLException ex) {
//            System.out.println("Error in player mode deleteIdRecord : " + ex.getMessage());
//            return false;
//        }
//    }

//    static boolean deleteUsrRecord(String _username) {
//        try {
//            db.startConnection();
//            if (db.getConnection() == null) {
//                return false;
//            }
//            db.setStatement(db.getConnection().createStatement());
//            int checkDelete = db.getStatement().executeUpdate("DELETE FROM players WHERE username= '" + _username + "'");
//            db.endStatConnection();  // for statment with no resultset
//            if (checkDelete >= 1) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error in player mode deleteUsrRecord : " + ex.getMessage());
//            return false;
//        }
//    }

//    static boolean deleteMailRecord(String _email) {
//        try {
//            db.startConnection();
//            if (db.getConnection() == null) {
//                return false;
//            }
//            db.setStatement(db.getConnection().createStatement());
//            int checkDelete = db.getStatement().executeUpdate("DELETE FROM players WHERE email= '" + _email + "'");
//            db.endStatConnection();  // for statment with no resultset
//            if (checkDelete >= 1) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error in player mode deleteMailRecord : " + ex.getMessage());
//            return false;
//        }
//    }

//    static boolean deleteMailPassRecord(String _email, String _passwd) {
//        try {
//            db.startConnection();
//            if (db.getConnection() == null) {
//                return false;
//            }
//            db.setStatement(db.getConnection().createStatement());
//            int checkDelete = db.getStatement().executeUpdate("DELETE FROM players WHERE email= '" + _email + "' and passwd= '" + _passwd + "'");
//            db.endStatConnection();  // for statment with no resultset
//            if (checkDelete >= 1) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error in player mode deleteMailPassRecord : " + ex.getMessage());
//            return false;
//        }
//    }

//    static boolean deleteUsrPassRecord(String _username, String _passwd) {
//        try {
//            db.startConnection();
//            if (db.getConnection() == null) {
//                return false;
//            }
//            db.setStatement(db.getConnection().createStatement());
//            int checkDelete = db.getStatement().executeUpdate("DELETE FROM players WHERE email= '" + _username + "' and passwd= '" + _passwd + "'");
//            db.endStatConnection();  // for statment with no resultset
//            if (checkDelete >= 1) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error in player mode deleteUsrPassRecord : " + ex.getMessage());
//            return false;
//        }
//    }
//use
    // DML Select
    static Long selectScoreWhereUsr(String _username) {
        try {
            db.startConnection();
            if (db.getConnection() == null) {
                return null;
            }
            db.setStatement(db.getConnection().createStatement());
            db.setQuerystr("select score from players where username= '" + _username + "'");
            db.setResultSet(db.getStatement().executeQuery(db.getQuerystr()));

            //boolean checkFirst = TestDB2.this.rs.first() ;
            if (db.getResultSet().next() == false) {
                db.endResultSet();
                db.endStatConnection();
                return null;
            } else {
                Long tmpScore = db.getResultSet().getLong("score");
                db.endResultSet();
                db.endStatConnection();
                return tmpScore;
            }
        } catch (SQLException ex) {
            System.out.println("Error in player mode selectScoreWhereUsr : " + ex.getMessage());

            return null;
        }
    }
//use
    static Long selectIdWhereUsr(String _username) {
        try {
            db.startConnection();
            if (db.getConnection() == null) {
                return null;
            }
            db.setStatement(db.getConnection().createStatement());
            db.setQuerystr("select pid from players where username= '" + _username + "'");
            db.setResultSet(db.getStatement().executeQuery(db.getQuerystr()));

            if (db.getResultSet().next() == false) {
                db.endResultSet();
                db.endStatConnection();
                return null;
            } else {
                Long tmpPid = db.getResultSet().getLong("pid");
                db.endResultSet();
                db.endStatConnection();
                return tmpPid;
            }
        } catch (SQLException ex) {
            System.out.println("Error in player mode selectIdWhereUsr : " + ex.getMessage());
            return null;
        }
    }
//use
    static String selectStatusWhereUsr(String _username) {
        try {
            db.startConnection();
            if (db.getConnection() == null) {
                return null;
            }
            db.setStatement(db.getConnection().createStatement());
            db.setQuerystr("select status from players where username= '" + _username + "'");
            db.setResultSet(db.getStatement().executeQuery(db.getQuerystr()));

            if (db.getResultSet().next() == false) {
                db.endResultSet();
                db.endStatConnection();
                //System.err.println("false select");
                return null;
            } else {
                String tmpStatus = db.getResultSet().getString("status");
                db.endResultSet();
                db.endStatConnection();
                return tmpStatus;
            }
        } catch (SQLException ex) {
            System.out.println("Error in player mode selectStatusWhereUsr : " + ex.getMessage());

            return null;
        }
    }

    static String selectPassWhereUsr(String _username) {
        try {
            db.startConnection();
            if (db.getConnection() == null) {
                return null;
            }
            db.setStatement(db.getConnection().createStatement());
            db.setQuerystr("select passwd from players where username= '" + _username + "'");
            db.setResultSet(db.getStatement().executeQuery(db.getQuerystr()));

            if (db.getResultSet().next() == false) {
                db.endResultSet();
                db.endStatConnection();
                return null;
            } else {
                String tmpPasswd = db.getResultSet().getString("passwd");
                db.endResultSet();
                db.endStatConnection();
                return tmpPasswd;
            }
        } catch (SQLException ex) {
            System.out.println("Error in player mode selectPassWhereUsr : " + ex.getMessage());

            return null;
        }
    }
//use
    // check 
    static boolean selectWhereUsrPass(String _username, String _passwd) {
        try {
            db.startConnection();
            if (db.getConnection() == null) {
                return false;
            }
            db.setStatement(db.getConnection().createStatement());
            db.setQuerystr("select * from players where username= '" + _username + "' and passwd = '" + _passwd + "'");
            db.setResultSet(db.getStatement().executeQuery(db.getQuerystr()));

            if (db.getResultSet().next() == false) {
                db.endResultSet();
                db.endStatConnection();
                return false;
            } else {
                db.endResultSet();
                db.endStatConnection();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error in player mode selectWhereUsrPass : " + ex.getMessage());

            return false;
        }
    }
//use
    static Player selectPlayerWhereUsrPass(String _username, String _passwd) {
        try {
            db.startConnection();
            if (db.getConnection() == null) {
                return null;
            }
            db.setStatement(db.getConnection().createStatement());
            db.setQuerystr("select * from players where username= '" + _username + "' and passwd = '" + _passwd + "'");
            db.setResultSet(db.getStatement().executeQuery(db.getQuerystr()));

            if (db.getResultSet().next() == false) {

                db.endResultSet();
                db.endStatConnection();

                return null;
            } else {
                Player p = Player.createPlayer(db.getResultSet());

                db.endResultSet();
                db.endStatConnection();
                return p;
            }
        } catch (SQLException ex) {
            System.out.println("Error in player mode selectPlayerWhereUsrPass : " + ex.getMessage());

            return null;
        }
    }

//    static String selectMailWhereUsr(String _username) {
//        try {
//            db.startConnection();
//            if (db.getConnection() == null) {
//                return null;
//            }
//            db.setStatement(db.getConnection().createStatement());
//            db.setQuerystr("select email from players where username= '" + _username + "'");
//            db.setResultSet(db.getStatement().executeQuery(db.getQuerystr()));
//
//            if (db.getResultSet().next() == false) {
//                db.endResultSet();
//                db.endStatConnection();
//                return null;
//            } else {
//                String tmpEmail = db.getResultSet().getString("email");
//                db.endResultSet();
//                db.endStatConnection();
//                return tmpEmail;
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error in player mode selectMailWhereUsr : " + ex.getMessage());
//
//            return null;
//        }
//    }

//    static Long selectScoreWhereUsrPass(String _username, String _passwd) {
//        try {
//            db.startConnection();
//            if (db.getConnection() == null) {
//                return null;
//            }
//            db.setStatement(db.getConnection().createStatement());
//            db.setQuerystr("select score from players where username= '" + _username + "' and passwd='" + _passwd + "'");
//            db.setResultSet(db.getStatement().executeQuery(db.getQuerystr()));
//
//            if (db.getResultSet().next() == false) {
//                db.endResultSet();
//                db.endStatConnection();
//
//                return null;
//            } else {
//                Long tmpScore = db.getResultSet().getLong("score");
//
//                db.endResultSet();
//                db.endStatConnection();
//                return tmpScore;
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error in player mode selectScoreWhereUsrPass : " + ex.getMessage());
//
//            return null;
//        }
//    }

//    static String selectStatusWhereUsrPass(String _username, String _passwd) {
//        try {
//            db.startConnection();
//            if (db.getConnection() == null) {
//                return null;
//            }
//            db.setStatement(db.getConnection().createStatement());
//            db.setQuerystr("select status from players where username= '" + _username + "' and passwd='" + _passwd + "'");
//
//            db.setResultSet(db.getStatement().executeQuery(db.getQuerystr()));
//
//            if (db.getResultSet().next() == false) {
//                db.endResultSet();
//                db.endStatConnection();
//                return null;
//            } else {
//                String tmpStatus = db.getResultSet().getString("status");
//                db.endResultSet();
//                db.endStatConnection();
//                return tmpStatus;
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error in player mode selectStatusWhereUsrPass : " + ex.getMessage());
//
//            return null;
//        }
//    }
//use
    static Vector<Player> selectAllWhereStatus(String _status) {
        try {
            db.startConnection();
            if (db.getConnection() == null) {
                return null;
            }
            db.setStatement(db.getConnection().createStatement());
            db.setQuerystr("select * from players where status= '" + _status + "'");

            db.setResultSet(db.getStatement().executeQuery(db.getQuerystr()));

            if (db.getResultSet().next() == false) {
                db.endResultSet();
                db.endStatConnection();
                return null;
            } else {

                Vector<Player> tmpUsrs = new Vector<Player>();
                tmpUsrs.add(Player.createPlayer(db.getResultSet()));
                while (db.getResultSet().next()) {
                    tmpUsrs.add(Player.createPlayer(db.getResultSet()));
                }
                db.endResultSet();
                db.endStatConnection();
                return tmpUsrs;
            }
        } catch (SQLException ex) {
            System.out.println("Error in player mode selectAllWhereStatus : " + ex.getMessage());

            return null;
        }
    }
    // check 
//use
    static Vector<Player> selectAllPlayers() {
        try {
            db.startConnection();
            if (db.getConnection() == null) {
                return null;
            }
            db.setStatement(db.getConnection().createStatement());
            db.setQuerystr("select * from players ");

            db.setResultSet(db.getStatement().executeQuery(db.getQuerystr()));

            if (db.getResultSet().isBeforeFirst() == false) {
                db.endResultSet();
                db.endStatConnection();
                return null;
            } else {
                Vector<Player> tmpUsrs = new Vector<Player>();
                while (db.getResultSet().next()) {
                    tmpUsrs.add(Player.createPlayer(db.getResultSet()));
                }
                db.endResultSet();
                db.endStatConnection();
                return tmpUsrs;
            }
        } catch (SQLException ex) {
            System.out.println("Error in player mode selectAllPlayers : " + ex.getMessage());

            return null;
        }
    }
//use
    static Vector<Player> selectAllPlayersOrderByDESC(String colName) {
        try {
            db.startConnection();
            if (db.getConnection() == null) {
                return null;
            }
            db.setStatement(db.getConnection().createStatement());
            db.setQuerystr("select * from players ORDER BY " + colName + " DESC ");

            db.setResultSet(db.getStatement().executeQuery(db.getQuerystr()));

            if (db.getResultSet().isBeforeFirst() == false) {
                db.endResultSet();
                db.endStatConnection();

                return null;
            } else {
                Vector<Player> tmpUsrs = new Vector<Player>();
                while (db.getResultSet().next()) {
                    tmpUsrs.add(Player.createPlayer(db.getResultSet()));
                }
                db.endResultSet();
                db.endStatConnection();
                return tmpUsrs;
            }
        } catch (SQLException ex) {
            System.out.println("Error in player mode selectAllPlayersOrderByDESC : " + ex.getMessage());

            return null;
        }
    }
//use
    static Vector<Player> selectAllPlayersOrderByASC(String colName) {
        try {
            db.startConnection();
            if (db.getConnection() == null) {
                return null;
            }
            db.setStatement(db.getConnection().createStatement());
            db.setQuerystr("select * from players ORDER BY " + colName + " ASC ");

            db.setResultSet(db.getStatement().executeQuery(db.getQuerystr()));

            if (db.getResultSet().isBeforeFirst() == false) {
                db.endResultSet();
                db.endStatConnection();
                return null;
            } else {
                Vector<Player> tmpUsrs = new Vector<Player>();
                while (db.getResultSet().next()) {
                    tmpUsrs.add(Player.createPlayer(db.getResultSet()));
                }
                db.endResultSet();
                db.endStatConnection();
                return tmpUsrs;
            }
        } catch (SQLException ex) {
            System.out.println("Error in player mode selectAllPlayersOrderByASC : " + ex.getMessage());
            return null;
        }
    }
}
