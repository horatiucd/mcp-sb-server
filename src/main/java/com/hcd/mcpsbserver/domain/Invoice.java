package com.hcd.mcpsbserver.domain;

public class Invoice {

    private int id;
    private String number;
    private String date;
    private String vendor;
    private String service;
    private String status;
    private double amount;

    public Invoice(int id,
                   String number,
                   String date,
                   String vendor,
                   String service,
                   String status,
                   double amount) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.vendor = vendor;
        this.service = service;
        this.status = status;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
