package Lesson26.pawnshop.models;
import Lesson26.pawnshop.enums.OperationStatus;
import sun.nio.ch.SelectorImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Operation {
    private double id;
    private Date startDate;
    private Date endDate;
    private Client client;
    private OperationStatus status;
    private ArrayList<Product> products;
    private double mainSum;
    private double percentSum;
    private int overdueDays;
    private double totalPrice;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public Operation(Date startDate, Date endDate, Client client, ArrayList<Product> products) {
        this.id = Math.random();
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.status = OperationStatus.OPEN;
        this.products = products;
        this.mainSum = 0;
        this.percentSum = 0;
        this.overdueDays = 0;
        this.totalPrice = 0;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getMainSum() {
        return mainSum;
    }

    public void setMainSum(double mainSum) {
        this.mainSum = mainSum;
    }

    public double getPercentSum() {
        return percentSum;
    }

    public void setPercentSum(double percentSum) {
        this.percentSum = percentSum;
    }

    public int getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(int overdueDays) {
        this.overdueDays = overdueDays;
    }

    @Override
    public String toString() {
        return "Операция {\n" +
                "   Клиент {" + client + "}\n" +
                "   Начальная дата: " + simpleDateFormat.format(startDate) +
                        ", Конечная дата: " + simpleDateFormat.format(endDate) +
                        ", Статус: " + status + "\n" +
                            "   Продукты" + products + "\n" +
                            "   Основная сумма: " + mainSum +
                            ", Сумма процентов: " + percentSum +
                            ", Кол-во дней просрочки: " + overdueDays + "\n" +
                            " Итого к оплате: " + totalPrice +
                            "\n}";
    }
}
