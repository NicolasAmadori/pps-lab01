import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    public static final String USER_NAME = "Mario";
    public static final String USER_SURNAME = "Rossi";
    public static final int USER_ID = 1;
    public static final int WRONG_USER_ID = 2;

    public static final int INITIAL_AMOUNT_0 = 0;
    public static final int AMOUNT_1 = 100;
    public static final int AMOUNT_2 = 50;
    public static final int AMOUNT_3 = 70;

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder(USER_NAME, USER_SURNAME, USER_ID);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_AMOUNT_0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_AMOUNT_0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), AMOUNT_1);
        assertEquals(AMOUNT_1, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), AMOUNT_1);
        bankAccount.deposit(WRONG_USER_ID, AMOUNT_2);
        assertEquals(AMOUNT_1, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), AMOUNT_1);
        bankAccount.withdraw(accountHolder.getId(), AMOUNT_3);
        assertEquals(AMOUNT_1 - AMOUNT_3, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), AMOUNT_1);
        bankAccount.withdraw(WRONG_USER_ID, AMOUNT_3);
        assertEquals(AMOUNT_1, bankAccount.getBalance());
    }
}
