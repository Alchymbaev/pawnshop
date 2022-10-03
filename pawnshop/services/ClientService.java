package Lesson26.pawnshop.services;
import Lesson26.pawnshop.models.Client;
import Lesson26.pawnshop.services.impl.ClientServiceImpl;

import java.util.ArrayList;

public interface ClientService {
    ClientService INSTANCE = new ClientServiceImpl();

    void createClient(String idCard, String name);

    Client findClient(String idCard);

    void blockClient(String idCard);

    void getClients();

}
