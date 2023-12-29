package com.iglaz.sqljdbcgo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity {
    private Long id;
    private String passengerNo;
    private String passengerName;
    private Long flingId;
    private String seatNo;
    private BigDecimal cost;

    public static TicketEntityBuilder builder() {
        return new TicketEntityBuilder();
    }

    public static class TicketEntityBuilder {
        private Long id;
        private String passengerNo;
        private String passengerName;
        private Long flingId;
        private String seatNo;
        private BigDecimal cost;

        TicketEntityBuilder() {
        }

        public TicketEntityBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public TicketEntityBuilder passengerNo(String passengerNo) {
            this.passengerNo = passengerNo;
            return this;
        }

        public TicketEntityBuilder passengerName(String passengerName) {
            this.passengerName = passengerName;
            return this;
        }

        public TicketEntityBuilder flingId(Long flingId) {
            this.flingId = flingId;
            return this;
        }

        public TicketEntityBuilder seatNo(String seatNo) {
            this.seatNo = seatNo;
            return this;
        }

        public TicketEntityBuilder cost(BigDecimal cost) {
            this.cost = cost;
            return this;
        }

        public TicketEntity build() {
            return new TicketEntity(this.id, this.passengerNo, this.passengerName, this.flingId, this.seatNo, this.cost);
        }

        public String toString() {
            return "TicketEntity.TicketEntityBuilder(id=" + this.id + ", passengerNo=" + this.passengerNo + ", passengerName=" + this.passengerName + ", flingId=" + this.flingId + ", seatNo=" + this.seatNo + ", cost=" + this.cost + ")";
        }
    }
}
