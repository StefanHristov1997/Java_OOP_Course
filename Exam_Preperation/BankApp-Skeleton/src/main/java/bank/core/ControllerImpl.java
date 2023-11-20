package bank.core;

import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;
import bank.repositories.LoanRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static bank.common.ConstantMessages.*;
import static bank.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private final LoanRepository loans;
    private final Collection<Bank> banks;

    public ControllerImpl() {
        this.loans = new LoanRepository();
        this.banks = new ArrayList<>();
    }

    @Override
    public String addBank(String type, String name) {
        switch (type) {
            case "CentralBank":
                Bank centralBank = new CentralBank(name);
                banks.add(centralBank);
                break;
            case "BranchBank":
                Bank branchBank = new BranchBank(name);
                banks.add(branchBank);
                break;
            default:
                throw new IllegalArgumentException(INVALID_BANK_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {
        switch (type) {
            case "StudentLoan":
                Loan studentLoan = new StudentLoan();
                loans.addLoan(studentLoan);
                break;
            case "MortgageLoan":
                Loan mortgageLoan = new MortgageLoan();
                loans.addLoan(mortgageLoan);
                break;
            default:
                throw new IllegalArgumentException(INVALID_LOAN_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Loan loan = loans.findFirst(loanType);
        if (loan == null) {
            throw new IllegalArgumentException(String.format(NO_LOAN_FOUND, loanType));
        }
        Bank bank = banks.stream().filter(b ->
                b.getName().equals(bankName)).findFirst().get();
        bank.addLoan(loan);
        this.loans.removeLoan(loan);
        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {

        if (!clientType.equals("Student") && !clientType.equals("Adult")) {
            throw new IllegalArgumentException(INVALID_CLIENT_TYPE);
        }

        Bank bank = banks.stream().filter(b ->
                b.getName().equals(bankName)).findFirst().get();

        if (bank.getClass().getSimpleName().equals("CentralBank") && clientType.equals("Adult")) {
            Client adult = new Adult(clientName, clientID, income);
            bank.addClient(adult);
        } else if (bank.getClass().getSimpleName().equals("BranchBank") && clientType.equals("Student")) {
            Client student = new Student(clientName, clientID, income);
            bank.addClient(student);
        } else {
            return UNSUITABLE_BANK;
        }
        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
    }

    @Override
    public String finalCalculation(String bankName) {

        Bank bank = banks.stream().filter(b ->
                b.getName().equals(bankName)).findFirst().get();

        double sumIncomeOfClients = bank.getClients().stream().mapToDouble(Client::getIncome).sum();
        double sumAmountOfLoans = bank.getLoans().stream().mapToDouble(Loan::getAmount).sum();
        double fund = sumAmountOfLoans + sumIncomeOfClients;

        return String.format(FUNDS_BANK, bankName, fund);
    }

    @Override
    public String getStatistics() {
        return this.banks.stream()
                .map(Bank::getStatistics)
                .collect(Collectors.joining(System.lineSeparator())).trim();
    }
}
