package com.vytrack.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void establishConnection(DBType dbType)  {

        try {

            switch (dbType) {
                case ORACLE:
                    connection = DriverManager.getConnection(ConfigurationReader.getProperty("oracleDbURL"),
                            ConfigurationReader.getProperty("oracleDbUsername"),
                            ConfigurationReader.getProperty("oracleDbPassword"));
                    break;
                case h2:
                    connection = DriverManager.getConnection(ConfigurationReader.getProperty("spartanDbURL"),
                            ConfigurationReader.getProperty("spartanDbUsername"),
                            ConfigurationReader.getProperty("spartanDbPassword"));
                    break;
                case vytrack:
                    connection = DriverManager.getConnection(ConfigurationReader.getProperty("VyTrackDbURL"),
                            ConfigurationReader.getProperty("VyTrackDbUsername"),
                            ConfigurationReader.getProperty("VyTrackDbPassword"));
                    break;
                    default:
                    connection = null;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void establishConnection(String dbType)  {

        try {

            switch (dbType) {
                case "ORACLE":
                    connection = DriverManager.getConnection(ConfigurationReader.getProperty("oracleDbURL"),
                            ConfigurationReader.getProperty("oracleDbUsername"),
                            ConfigurationReader.getProperty("oracleDbPassword"));
                    break;
                case "H2":
                    connection = DriverManager.getConnection(ConfigurationReader.getProperty("spartanDbURL"),
                            ConfigurationReader.getProperty("spartanDbUsername"),
                            ConfigurationReader.getProperty("spartanDbPassword"));
                    break;
                case "VYTRACK":
                    connection = DriverManager.getConnection(ConfigurationReader.getProperty("VyTrackDbURL"),
                            ConfigurationReader.getProperty("VyTrackDbUsername"),
                            ConfigurationReader.getProperty("VyTrackDbPassword"));
                    break;
                default:
                    connection = null;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }



public static List<Map<String ,Object>> runSQLQuery(String query) {

    try {

        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData;

        resultSetMetaData = resultSet.getMetaData();

        List<Map<String, Object>> list = new ArrayList<>();




        while (resultSet.next()) {
            Map<String, Object> rowMap = new HashMap<>();
            for (int col = 1; col <= resultSetMetaData.getColumnCount(); col++) {
                rowMap.put(resultSetMetaData.getColumnName(col), resultSet.getString(col));
            }
            list.add(rowMap);
        }
        return list;
    } catch (Exception e) {
        e.printStackTrace();
    }
return null;
}

    public static void closeConnections(){

            try {
                if(resultSet!=null) resultSet.close();
                if(statement!=null) statement.close();
                if(connection!=null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }



    }

    public static int getRowsCount(String query) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query);
            resultSet.last();
            return resultSet.getRow();
        }catch (Exception e){
            e.printStackTrace();
        }
    return 0;
    }








}
