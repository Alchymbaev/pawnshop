package Lesson26.pawnshop.models;

public class Client {
    private double id;
    private String idCard;
    private String name;
    private boolean isBlocked;

    public Client(String name, String idCard) {
        this.id = Math.random();
        this.idCard = idCard;
        this.name = name;
        this.isBlocked = false;
    }

    public double getId() {
        return id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Паспорт ID: " + idCard + ", Заблокирован: " + isBlocked;
    }
}
