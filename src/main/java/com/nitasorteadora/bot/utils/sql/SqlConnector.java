package com.nitasorteadora.bot.utils.sql;

import com.nitasorteadora.bot.Main;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnector {
    Main plugin;
    public SqlConnector(Main plugin) {
        this.plugin = plugin;
    }
    private Connection connection;
    public void openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectiondata = "jdbc:mysql://" +plugin.sqldataconfig.get("ip")+"/"+plugin.sqldataconfig.get("username") + "?autoReconnect=true";
            connection = DriverManager.getConnection(connectiondata, plugin.sqldataconfig.get("username").toString(), plugin.sqldataconfig.get("password").toString());
            Bukkit.getLogger().info("Conectado a la base de datos!");
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    public void closeConnection() throws SQLException {
        if(connection != null && !connection.isClosed())
            connection.close();
    }
    public Connection getConnection() {
        return connection;
    }
}
