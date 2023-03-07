package daos.impl;

public class StatementGenerator {
    public static String getStatement(String statementType) {
        String statement = "";
        switch (statementType) {
            case "createDB":
                statement = "DROP TABLE IF EXISTS medicamentos ; " +
                    "CREATE TABLE medicamentos (" +
                    "codigoNumerico BIGINT PRIMARY KEY, " +
                    "nombre VARCHAR(255), " +
                    "laboratorio VARCHAR(255)," +
                    "cantidad BIGINT, " +
                    "precio DOUBLE)";
                break;
            case "insert":
                statement = "" +
                    "INSERT INTO medicamentos (codigoNumerico, nombre, laboratorio, cantidad,precio) " +
                    "VALUES (?, ?, ?, ?, ?)";
                break;
            case "selectWhereNombre":
                statement = "SELECT * FROM medicamentos WHERE nombre = ?";
                break;
            case "selectWhereCodNum":
                statement = "SELECT * FROM medicamentos WHERE codigoNumerico = ?";
                break;
        }
        return statement;
    }
}
