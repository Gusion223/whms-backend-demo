package com.whms.common;

import lombok.Data;

import java.util.HashMap;

@Data
public class QueryParam {
    static private int Page_Size = 10;
    static private int Page_Index = 1;

    private int pageSize = Page_Size;
    private int pageIndex = Page_Index;
    private HashMap params;
}
