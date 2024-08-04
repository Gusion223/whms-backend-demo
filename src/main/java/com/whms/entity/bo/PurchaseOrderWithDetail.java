package com.whms.entity.bo;

import com.whms.entity.PurchaseDetail;
import com.whms.entity.PurchaseOrder;
import lombok.Data;

import java.util.List;

@Data
public class PurchaseOrderWithDetail {
    private PurchaseOrder order;
    private List<PurchaseDetail> list;

}
