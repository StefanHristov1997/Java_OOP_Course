package bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BankTests {

    private final static int BANK_CAPACITY = 5;
    private final static int INVALID_BANK_CAPACITY = -1;
    private final static String BANK_NAME = "DSKBank";
    private final static String INVALID_BANK_NAME = " ";
    private final static Client FIRST_CLIENT = new Client("Stefan");
    private final static Client INVALID_CLIENT = new Client("Gosho");
    private final static Client SECOND_CLIENT = new Client("Pesho");

    public final static Collection<Client> CLIENTS = List.of(FIRST_CLIENT, SECOND_CLIENT);
    private Bank bank;

    @Before
    public void setBank() {
        this.bank = new Bank(BANK_NAME, BANK_CAPACITY);
    }

    @Test
    public void testConstructorCreateACorrectObject() {
        Assert.assertEquals(BANK_CAPACITY, bank.getCapacity());
        Assert.assertEquals(BANK_NAME, bank.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetMethodThrowExceptionOnInvalidName() {
        bank = new Bank(INVALID_BANK_NAME, BANK_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityMethodThrowExceptionOnInvalidInput() {
        bank = new Bank(BANK_NAME, INVALID_BANK_CAPACITY);
    }

    @Test
    public void testGetCountMethodReturnClientsSize() {
        bank.addClient(FIRST_CLIENT);
        bank.addClient(SECOND_CLIENT);
        Assert.assertEquals(2, bank.getCount());
    }

    @Test
    public void testAddClientMethodSuccessfullyAddClient() {
        bank.addClient(FIRST_CLIENT);
        Assert.assertEquals(1, bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodThrowExceptionOnFullCapacity() {
        for (int i = 0; i < BANK_CAPACITY + 1; i++) {
            bank.addClient(INVALID_CLIENT);
        }
    }

    @Test
    public void testRemoveClientMethodSuccessfullyRemoveClient() {
        bank.addClient(FIRST_CLIENT);
        bank.addClient(SECOND_CLIENT);

        bank.removeClient(FIRST_CLIENT.getName());

        Assert.assertEquals(1, bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMethodThrowExceptionOnInvalidClient() {
        bank.addClient(FIRST_CLIENT);
        bank.addClient(SECOND_CLIENT);
        bank.removeClient(INVALID_CLIENT.getName());
    }

    @Test
    public void testLoanWithdrawalMethodSuccessfullySetApproval() {
        bank.addClient(FIRST_CLIENT);
        Assert.assertEquals(FIRST_CLIENT, bank.loanWithdrawal(FIRST_CLIENT.getName()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoanWithdrawalMethodThrowExceptionOnInvalidClient() {
        bank.addClient(FIRST_CLIENT);
        Assert.assertEquals(FIRST_CLIENT, bank.loanWithdrawal(SECOND_CLIENT.getName()));
    }

    @Test
    public void testStatisticsMethodSuccessfullyReturnValue() {
        bank.addClient(FIRST_CLIENT);
        bank.addClient(SECOND_CLIENT);

        String names = CLIENTS.stream().map(Client::getName).collect(Collectors.joining(", "));
        String expectedResult = String.format("The client %s is at the %s bank!", names, bank.getName());

        Assert.assertEquals(expectedResult, bank.statistics());
    }

    @Test
    public void testIsApprovedMethodSuccessfullyReturnValue() {
        FIRST_CLIENT.setApprovedForLoan(true);
        boolean isApproved = FIRST_CLIENT.isApprovedForLoan();

        Assert.assertTrue(isApproved);
    }
}
