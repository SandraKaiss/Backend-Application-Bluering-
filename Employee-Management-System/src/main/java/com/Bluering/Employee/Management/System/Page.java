package com.Bluering.Employee.Management.System;


import java.awt.*;

public class Page<T> {
    private final List content;
    private final int pageNumber;
    private final int totalPages;
    private final long totalElements;

    public Page(List content, int pageNumber, int totalPages, long totalElements) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    // getters and setters
}
