package carsharing;

/**
 * The SQLQueries interface is set of prepared SQL queries
 */
public interface SQLQueries {
   String CREATE_TABLE = "CREATE TABLE COMPANY " +
           "(id INTEGER NOT NULL," +
           " name VARCHAR(255) UNIQUE NOT NULL," +
           " PRIMARY KEY (id))";

   String INSERT_INTO = "INSERT INTO Company" +
           "  (id, name) VALUES " +
           " (?, ?);";
}
