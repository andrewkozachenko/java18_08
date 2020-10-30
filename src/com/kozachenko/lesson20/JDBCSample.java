package com.kozachenko.lesson20;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCSample {

    public static final String DATABASE_NAME = "lemon_java_18_08";
    public static final String URL = "jdbc:mysql://localhost:3306/"+DATABASE_NAME;

    public static final String ROOT = "root";
    public static final String PASSWORD = "dampill680598";
    public static final String DRIVER = "com.mysql.jdbc.Driver";

    public static void main(String[] args) {
        System.out.println("-------- MySQL JDBC Connection Testing ------------");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver? Include in your library path!");
            e.printStackTrace();
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, ROOT, PASSWORD);
            if (connection == null) {
                System.err.println("Failed to make connection!");
            } else {
                System.out.println("You made it, take control your database now!");
                List<Author> authors = new ArrayList<Author>();
                try
                {

                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM author");
                    while ( rs.next() )
                    {
                        Author author = new Author();
                        author.setId( rs.getInt    ("id"));
                        author.setName(rs.getString("name"));
                        authors.add(author);
                    }
                    rs.close();
                    statement.close();

                }
                catch (SQLException se) {
                    System.err.println(se.getMessage());
                }
                Author [] usersArray = new Author[authors.size()];
                authors.toArray(usersArray);
                System.out.println(authors);
            }


        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e){
                System.err.println("Connection Failed! Check output console");
            }
        }


    }
}
