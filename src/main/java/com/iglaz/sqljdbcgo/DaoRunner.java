package com.iglaz.sqljdbcgo;

import com.iglaz.sqljdbcgo.dao.TicketDao;
import com.iglaz.sqljdbcgo.entity.TicketEntity;

import java.math.BigDecimal;
import java.sql.SQLException;

public class DaoRunner {
    public static void main(String[] args) throws SQLException {
        TicketEntity ticket = TicketEntity.builder()
                .passengerNo("2323423")
                .passengerName("Ivan")
                .flingId(2L)
                .seatNo("A333")
                .cost(BigDecimal.valueOf(45.00))
                .build();
        save(ticket);
    }

    private static void save(TicketEntity ticket) throws SQLException {
        TicketDao dao = TicketDao.getInstance();

        System.out.println(dao.save(ticket));
    }

    private static void deleteEntity(Long id) {
        TicketDao dao = TicketDao.getInstance();

        System.out.println(dao.delete(id));
    }
}
