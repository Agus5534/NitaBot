package com.nitasorteadora.bot.utils.sql;

import java.sql.*;

public class BlacklistManager {
    private Connection connection;
    private long userId;
    public BlacklistManager(Connection connection, long userId) {
        this.connection = connection;
        this.userId = userId;
    }
    public boolean isBlacklisted() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM blacklist WHERE id = ?");
        statement.setLong(1, userId);
        ResultSet rs = statement.executeQuery();
        return rs.next();
    }
    public String getReason() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT reason FROM blacklist WHERE id = ?");
        statement.setLong(1, userId);
        ResultSet rs = statement.executeQuery();
        if(rs.next()) {
            return rs.getString(1);

        } else {
            return null;
        }
    }
    public String getAuthor() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT author FROM blacklist WHERE id = ?");
        statement.setLong(1, userId);
        ResultSet rs = statement.executeQuery();
        if(rs.next()) {
            return rs.getString(1);
        } else {
            return null;
        }
    }
    public Date getDate() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT since FROM blacklist WHERE id = ?");
        statement.setLong(1, userId);
        ResultSet rs = statement.executeQuery();
        if(rs.next()) {
            return rs.getDate(1);
        } else {
            return null;
        }
    }
}
