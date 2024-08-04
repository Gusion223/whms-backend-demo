package com.whms.entity.bo;

import com.whms.entity.SaleDetail;
import com.whms.entity.SaleOrder;
import lombok.Data;

import java.util.List;

@Data
public class SaleOrderWithDetail {
    SaleOrder order;
    List<SaleDetail> list;
}
