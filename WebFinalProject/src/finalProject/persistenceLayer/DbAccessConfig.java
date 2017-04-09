package finalProject.persistenceLayer;


/*********************************************************************************
 * @file    AssociationManagerImpl.java
 * @author  John Miller
 * @see     LICENSE (MIT style license file)
 * @version 0.8
 * @date    Fri Jun 25 18:00:51 EDT 2010
 */


/*********************************************************************************
 * This class defines configuration parameters for accessing a database using JDBC.
 */
public abstract class DbAccessConfig
{
    /** The fully qualified name of the JDBC driver.
     */
    static final String DB_DRIVE_NAME  = "com.mysql.jdbc.Driver";
    
    /** The database name
     */
    static final String DB_NAME        = "WebProject";
    
    /** The database server name for the connection pool
     */
    static final String DB_SERVER_NAME = "localhost";

    /** The JDBC connection string/URL.
     */
    static final String DB_CONNECTION_URL = "jdbc:mysql://localhost/WebProject";

    /** The database user name.
     */
    static  String DB_CONNECTION_USERNAME = "root";

    /** The password for the database user.
     */
    static  String DB_CONNECTION_PWD = "Jc20586442";

}
