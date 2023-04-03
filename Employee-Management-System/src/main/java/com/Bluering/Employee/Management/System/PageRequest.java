package com.Bluering.Employee.Management.System;


import org.hibernate.mapping.List;
import org.springframework.data.domain.Sort;

public class PageRequest {
    private final int pageNumber;
    private final int pageSize;
    private final List sortOrders;

    public PageRequest(int pageNumber, int pageSize, List sortOrders) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sortOrders = sortOrders;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<Sort.Order> getSortOrders() {
        return sortOrders;
    }
}
