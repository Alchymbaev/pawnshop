package Lesson26.pawnshop.services.impl;

import Lesson26.pawnshop.exeptions.MyExepcions;
import Lesson26.pawnshop.models.Client;
import Lesson26.pawnshop.services.ClientService;

import java.util.ArrayList;

public class ClientServiceImpl implements ClientService {
    ArrayList<Client> clients = new ArrayList<>();

    @Override
    public Client findClient(String idCard) {
        for (Client clt : clients) {
            if (clt.getIdCard().equals(idCard)){
                return clt;
            }
        }
        throw new MyExepcions("Клиент не найден");
    }

    @Override
    public void blockClient(String idCard) {
        Client client = findClient(idCard);
        client.setBlocked(true);
    }

    @Override
    public void createClient(String idCard, String name) {
        Client client = new Client(idCard, name);
        clients.add(client);
    }

    @Override
    public void getClients() {
        for (Client clt : clients) {
            System.out.println(clt);
        }
    }
}
