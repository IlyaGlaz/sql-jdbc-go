package com.iglaz.sqljdbcgo;

import com.iglaz.sqljdbcgo.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        Long flightId = 2L;
        List<Long> list = getTicketByFlightId(flightId);

        System.out.println(list);
    }

    public static List<Long> getTicketByFlightId(Long flightId) throws SQLException {
        String sql = """
                SELECT id
                FROM ticket
                WHERE flight_id = ?
                """;

        List<Long> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            System.out.println(preparedStatement);

            preparedStatement.setLong(1, flightId);

            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(resultSet.getObject("id", Long.class));
            }
        }

        return result;
    }
}
