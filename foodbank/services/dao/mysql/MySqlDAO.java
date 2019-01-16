package foodbank.services.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import foodbank.exceptions.DataAccessException;

public class MySqlDAO {

	private String host;
	private String port;
	private String database;
	private String user;
	private String password;

	private Logger LOGGER = LoggerFactory.getLogger(getClass());

	public MySqlDAO(String host, String port, String database, String user, String password) {
		this.database = database;
		this.host = host;
		this.port = port;
		this.user = user;
		this.password = password;
	}

	public int executeUpdate(String statementString, Object... parameters) {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
		} catch (Exception e) {
			LOGGER.error("JDBC Connection Issue", e);
			throw new DataAccessException("Cannot connect to database " + database, e);
		}
		LOGGER.info("Connection to {}:{} {} established successfully for proid {}", host, port, database, user);
		try (PreparedStatement statement = connection.prepareStatement(statementString)) {
			int index = 1;
			for (Object parameter : parameters) {
				if (parameter instanceof Date) {
					statement.setDate(index++, (Date) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index++, (Integer) parameter);
				} else if (parameter instanceof LocalDateTime) {
					statement.setTimestamp(index++, Timestamp.valueOf((LocalDateTime) parameter));
				} else {
					statement.setString(index++, parameter.toString());
				}
			}
			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Failed running update - " + statementString , e);
		}
	}

	public ResultSet executeQuery(String statementString, Object... parameters) {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
		} catch (Exception e) {
			LOGGER.error("JDBC Connection Issue", e);
			throw new DataAccessException("Cannot connect to database " + database, e);
		}
		LOGGER.info("Connection to {}:{} {} established successfully for proid {}", host, port, database, user);
		try {
			PreparedStatement statement = connection.prepareStatement(statementString);
			int index = 1;
			for (Object parameter : parameters) {
				if (parameter instanceof Date) {
					statement.setDate(index++, (Date) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index++, (Integer) parameter);
				} else {
					statement.setString(index++, parameter.toString());
				}
			}
			return statement.executeQuery();
		} catch (SQLException e) {
			throw new DataAccessException("Failed running select - " + statementString , e);
		}
	}
}
