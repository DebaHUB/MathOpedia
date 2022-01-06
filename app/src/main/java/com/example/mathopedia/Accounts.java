package com.example.mathopedia;

public class Accounts {
    private String username;
    private String accName;
    private String accId;
    private String email;
    private String accMobile;

    public Accounts(String accId,String accName,String username,String accMobile,String email) {
        this.username = username;
        this.accName = accName;
        this.accId = accId;
        this.email = email;
        this.accMobile = accMobile;
    }

    public String getUsername() {
        return username;
    }

    public String getAccName() {
        return accName;
    }

    public String getAccId() {
        return accId;
    }

    public String getEmail() {
        return email;
    }

    public String getAccMobile() {
        return accMobile;
    }
}
