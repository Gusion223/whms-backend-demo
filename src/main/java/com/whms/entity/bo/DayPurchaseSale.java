package com.whms.entity.bo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DayPurchaseSale implements Serializable {
    private String date;
    private BigDecimal dayCost;
    private BigDecimal daySale;
}
