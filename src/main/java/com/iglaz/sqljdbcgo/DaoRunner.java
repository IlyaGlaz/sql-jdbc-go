package com.iglaz.sqljdbcgo;

import com.iglaz.sqljdbcgo.dao.TicketDao;
import com.iglaz.sqljdbcgo.entity.TicketEntity;

import java.math.BigDecimal;
import java.sql.SQLException;

public class DaoRunner {
    public static void main(String[] args) throws SQLException {
        TicketDao dao = TicketDao.getInstance();

        TicketEntity ticket = TicketEntity.builder()
                .passengerNo("2323423")
                .passengerName("Vasya")
                .flingId(2L)
                .seatNo("A222")
                .cost(BigDecimal.valueOf(22.00))
                .build();

        System.out.println(dao.save(ticket));
    }

    private static void deleteEntity() {
        TicketDao dao = TicketDao.getInstance();

        System.out.println(dao.delete(2L));
    }
}
