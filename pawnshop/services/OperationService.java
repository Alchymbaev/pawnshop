package Lesson26.pawnshop.services;

import Lesson26.pawnshop.models.Client;
import Lesson26.pawnshop.models.Product;
import Lesson26.pawnshop.services.impl.OperationServiceImpl;

import java.util.ArrayList;
import java.util.Date;

public interface OperationService {
    OperationService INSTANCE = new OperationServiceImpl();

    void createOperation (Date startDate, Date endDate, Client client, ArrayList<Product> products);

    void closeOperation(String idCardClient, Date curDate, double sum);

    void getAllOperations();
}
