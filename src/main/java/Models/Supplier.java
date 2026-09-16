package Models;

import java.math.BigDecimal;

public class Supplier {
    public  String SupplierName, SupplierID, SupplierEmail, SupplierPhone;
    private BigDecimal SupplierCredit, SupplierBalance;

    public Supplier(String supplierID, String supplierName, String SupplierEmail){
        this.SupplierID = supplierID;
        this.SupplierName = supplierName;
        this.SupplierEmail = SupplierEmail;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String supplierID) {
        SupplierID = supplierID;
    }

    public String getSupplierEmail() {
        return SupplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        SupplierEmail = supplierEmail;
    }

    public String getSupplierPhone() {
        return SupplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        SupplierPhone = supplierPhone;
    }

    public BigDecimal getSupplierCredit() {
        return SupplierCredit;
    }

    public void setSupplierCredit(BigDecimal supplierCredit) {
        SupplierCredit = supplierCredit;
    }

    public BigDecimal getSupplierBalance() {
        return SupplierBalance;
    }

    public void setSupplierBalance(BigDecimal supplierBalance) {
        SupplierBalance = supplierBalance;
    }
}
