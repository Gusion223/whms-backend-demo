package com.whms.entity.bo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TotalCostSale implements Serializable {
    private BigDecimal totalCost;
    private BigDecimal totalSale;
}
