package Lesson26.pawnshop.services.impl;

import Lesson21.DaysBetweenTwoDate;
import Lesson26.pawnshop.enums.OperationStatus;
import Lesson26.pawnshop.models.Client;
import Lesson26.pawnshop.models.Operation;
import Lesson26.pawnshop.models.Product;
import Lesson26.pawnshop.services.OperationService;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class OperationServiceImpl implements OperationService {
    ArrayList<Operation> operations = new ArrayList<>();

    @Override
    public void createOperation(Date startDate, Date endDate, Client client, ArrayList<Product> products) {
        Operation operation = new Operation(startDate, endDate, client, products);
        operation.setMainSum(mainSum(products));
        operation.setPercentSum(percentSum(startDate, endDate, operation.getMainSum()));
        operation.setTotalPrice(operation.getMainSum() + operation.getPercentSum());
        operations.add(operation);
    }

    private double mainSum(ArrayList<Product> products) {
        double totalSum = 0;
        for (Product prd : products) {
            totalSum += prd.getPrice();
        }
        return totalSum;
    }

    private double percentSum(Date startDate, Date endDate, double mainSum){
        int days = (int) TimeUnit.MILLISECONDS.toDays(endDate.getTime()-startDate.getTime());
        return ((mainSum / 100) * days);
    }


    @Override
    public void closeOperation(String idCardClient, Date curDate, double sum) {
        Operation operation = null;
        for (Operation oper : operations) {
            if (oper.getClient().getIdCard().equals(idCardClient)){
                operation = oper;
            }
        }
        operation.setOverdueDays((int) TimeUnit.MILLISECONDS.toDays(curDate.getTime() - operation.getEndDate().getTime()));
        operation.setTotalPrice(operation.getTotalPrice() + (((operation.getMainSum() * 2) / 100) * operation.getOverdueDays()) - sum);

        if (operation.getTotalPrice() <= 0) {
            operation.setStatus(OperationStatus.CLOSED);
        }
    }

    @Override
    public void getAllOperations() {
        for (Operation opr : operations) {
            System.out.println(opr);
        }
    }


}
