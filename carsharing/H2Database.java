package carsharing;

import java.sql.*;

public class H2Database {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:file:../task/src/carsharing/db/carsharing";
    static Connection connection;

    private H2Database() {}

    /**
     * Establishes a connection to the database
     * and returns an instance of this connection
     *
     * @return         Connection instance
     */
    public static Connection getConnection()  {
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Create database, connect to it
     * and create table in database
     */
    public static void createDB(){
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            connection = getConnection();

            //Execute a query
            stmt = connection.createStatement();
            stmt.executeUpdate(SQLQueries.CREATE_TABLE);

            //Clean-up environment
            stmt.close();
            connection.close();
        } catch(Exception se) {
            se.printStackTrace();
        } //Handle errors for Class.forName
        finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
                se2.printStackTrace();
            } // nothing we can do
            try {
                if(connection!=null) connection.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    /**
     * Add to database a new record about another company
     *
     * @param  compId     company`s identifier (ID_column)
     * @param  compName   company`s name (NAME_column)
     */
    public static void insertRecord(int compId, String compName) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement(SQLQueries.INSERT_INTO);
        preparedStatement.setInt(1, compId);
        preparedStatement.setString(2, compName);
        preparedStatement.executeUpdate();
    }
}
