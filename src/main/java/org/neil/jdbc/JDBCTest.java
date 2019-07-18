package org.neil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author neil
 * @date 2019-07-04
 */
public class JDBCTest {

    /**
     * com.mysql.jdbc.Driver
     *
     * @param driverName
     * @throws ClassNotFoundException
     */
    public void registerDriver(String driverName) throws ClassNotFoundException {
        Class.forName(driverName);// 去加载该类即可  实现中已经调用了DriverManager.registerDriver(new Driver());
    }

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true",
                "root",
                "root1234");
        return connection;
    }

    public void execute(Connection connection, String[] sqls) throws SQLException {
        connection.setAutoCommit(false);
        try {
            for (String sql : sqls) {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.set
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.close();
        }

    }

}
