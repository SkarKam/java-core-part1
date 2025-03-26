package org.griddynamics.tasks;

import java.util.Arrays;
import java.util.Optional;

public class Task4 {
    /*
    * Testing if everything works as it should.
    * */
    public static void main(String[] args){
        User user1 = new User(1,"Adam","Los");
        User user2= new User(2,"Ada","Kos");
        User user3 = new User(3,"Adam","Los");

        Account account1 = new Account(1, 2000, user1);
        Account account2 = new Account(2, 1000, user2);
        Account account3 = new Account(3, 3000, user3);

        Account[] accounts = {account1, account2, account3};
        //Testing methods

        AccountServiceImpl service = new AccountServiceImpl(accounts);

        System.out.println(service.findAccountByOwnerId(2));
        System.out.println(service.countAccountsWithBalanceGreaterThan(1001));
    }

}

interface AccountService {
    /**
     * It finds an account by owner id
     * @param id owner unique identifier
     * @return account or null
     */
    Account findAccountByOwnerId(long id);
    /**
     * It count the number of account with balance > the given value
     * @param value
     * @return the number of accounts
     */
    long countAccountsWithBalanceGreaterThan(long value);
}

class AccountServiceImpl implements AccountService {

    private Account[] accounts;

    public AccountServiceImpl(Account[] accounts) {
        this.accounts=accounts;
    }


    @Override
    public Account findAccountByOwnerId(long id) {
        Optional<Account> optional = Arrays.stream(accounts)
                                            .filter(account -> account.getId()==id)
                                            .findFirst();
        return optional.orElse(null);
    }

    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {
        return Arrays.stream(accounts)
                .filter((account) -> account.getBalance()>value)
                .count();
    }
}
// Declare and implement your AccountServiceImpl here

class Account {

    private long id;
    private long balance;
    private User owner;

    public Account(long id, long balance, User owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", owner=" + owner +
                '}';
    }
}

class User {

    private long id;
    private String firstName;
    private String lastName;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
