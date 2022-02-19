//#============================================================================#
//#                       interface configuration database                     #
//#============================================================================#
package database;

/**
 *
 * @author Mh.El3basy
 */

public interface DBConfig {
    
    static final String DB_SERVER_PORT = "80";
    static final String DB_NAME = "tictactoedb" ;
    static final String DB_SCHEME = "mysql" ;
    static final String DB_PORT = "3306" ;
    static final String DB_IP = "localhost" ;
    static final String DB_USER = "root";
    static final String DB_PASSWD = "5159528";
    
    static final String DB_SERVER_URL = "http://"+DB_IP+":"+DB_SERVER_PORT+"/phpmyadmin/db_structure.php?server=1&db="+DB_NAME;
    
    static final String DB_URL = "jdbc:"+DB_SCHEME+"://"+DB_IP+":"+DB_PORT+"/"+DB_NAME;
    static final String DB_DRV = "com.mysql.cj.jdbc.Driver";

}
