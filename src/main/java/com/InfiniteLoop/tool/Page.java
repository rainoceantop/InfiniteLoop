package com.InfiniteLoop.tool;

import org.springframework.stereotype.Service;

@Service
public class Page {
    //总共多少条记录
    private int records;
    //每页显示多少条记录
    private int recordsPerPage = 20;
    //总共有多少页
    private int pages;
    //当前页
    private int currentPage = 1;
    //上一页
    private int prePage;
    //下一页
    private int nextPage;
    //索引开始下标
    private int beginIndex = 0;

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public int getRecordsPerPage() {
        return recordsPerPage;
    }

    public void setRecordsPerPage(int recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }

    public int getPages() {
        return (records + recordsPerPage - 1) / recordsPerPage > 1 ? (records + recordsPerPage - 1) / recordsPerPage : 1;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCurrentPage() {
        return currentPage > 0 ? currentPage : 1;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPrePage() {
        return currentPage > 1 ? currentPage - 1 : 1;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return currentPage < getPages() ? currentPage + 1 : getPages();
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getBeginIndex() {
        return recordsPerPage * (currentPage - 1);
    }

    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }
}
