package Lesson26.pawnshop;


import Lesson26.pawnshop.services.ClientService;
import Lesson26.pawnshop.services.OperationService;
import Lesson26.pawnshop.services.ProductService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        ClientService clientService = ClientService.INSTANCE;
        ProductService productService = ProductService.INSTANCE;
        OperationService operationService = OperationService.INSTANCE;


        productService.createProduct("TV", 100);
        productService.createProduct("Phone", 50);
        productService.createProduct("NoteBook", 150);
        productService.createProduct("Mouse", 20);
        productService.createProduct("Printer", 70);
        productService.createProduct("Scanner", 80);


        clientService.createClient("Atai", "id111");
        clientService.createClient("Alman", "id222");

        clientService.blockClient("id222");

        try {
            operationService.createOperation(format.parse("01.09.2022"), format.parse("11.09.2022"),
                    clientService.findClient("id111"),
                    new ArrayList<>(Arrays.asList(
                            productService.findProduct("TV"),
                            productService.findProduct("Phone"),
                            productService.findProduct("Scanner")
                    )));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        operationService.getAllOperations();

        try {
            operationService.closeOperation("id111", format.parse("13.09.2022"), 100);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        operationService.getAllOperations();
    }

}
