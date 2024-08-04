package com.whms.entity.bo;

import com.whms.entity.TransferDetail;
import com.whms.entity.TransferOrder;
import lombok.Data;

import java.util.List;

@Data
public class TransferOrderWithDetail {
    TransferOrder order;
    List<TransferDetail> list;
}
