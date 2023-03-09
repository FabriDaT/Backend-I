package main.com.company.dao.impl;

public class StatementGenerator {

    public static String getStatement(String statementType) {

        String statement = "";

        switch (statementType) {

            case "insertInOdont":
                statement = "" +
                        "INSERT INTO odontologos (id, apellido, nombre, matricula) " +
                        "VALUES (?, ?, ?, ?)";
                break;
            case "selectWhereNombre":
                statement = "SELECT * FROM odontologos WHERE nombre = ?";
                break;
            case "selectWhereId":
                statement = "SELECT * FROM odontologos WHERE id = ?";
                break;

            case "selectAllOdont":
                statement = "SELECT * FROM odontologos";
                break;
        }
        return statement;
    }
}

