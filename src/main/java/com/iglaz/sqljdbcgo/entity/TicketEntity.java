package com.iglaz.sqljdbcgo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketEntity {
    private Long id;
    private String passengerNo;
    private String passengerName;
    private Long flingId;
    private String seatNo;
    private BigDecimal cost;
}
