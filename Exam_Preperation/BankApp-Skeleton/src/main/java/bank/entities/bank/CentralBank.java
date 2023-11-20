package bank.entities.bank;

import bank.entities.client.Client;

import java.util.Collection;

public class CentralBank extends BaseBank {

    private final static int CAPACITY = 50;
    public CentralBank(String name) {
        super(name, CAPACITY);
    }
}
