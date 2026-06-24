package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SavingAccountTest {

    private static final int INITIAL_BALANCE = 2_000;
    private static final int MIN_BALANCE = 1_000;
    private static final int MAX_BALANCE = 10_000;
    private static final int RATE = 5;

    private static final int ADD_AMOUNT = 3_000;
    private static final int PAY_AMOUNT = 1_500;

    @Test
    public void shouldThrowExceptionWhenMinBalanceNegative() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SavingAccount(
                        INITIAL_BALANCE,
                        -MIN_BALANCE,
                        MAX_BALANCE,
                        RATE
                )
        );
    }

    @Test
    public void shouldAddMoneyToBalance() {
        SavingAccount account = new SavingAccount(
                INITIAL_BALANCE,
                MIN_BALANCE,
                MAX_BALANCE,
                RATE
        );

        account.add(ADD_AMOUNT);

        assertEquals(
                INITIAL_BALANCE + ADD_AMOUNT,
                account.getBalance()
        );
    }

    @Test
    public void shouldNotChangeBalanceWhenPaymentRejected() {
        SavingAccount account = new SavingAccount(
                INITIAL_BALANCE,
                MIN_BALANCE,
                MAX_BALANCE,
                RATE
        );

        boolean result = account.pay(PAY_AMOUNT);

        assertFalse(result);
        assertEquals(INITIAL_BALANCE, account.getBalance());
    }

    @Test
    public void shouldPayWhenBalanceRemainsAboveMinBalance() {
        SavingAccount account = new SavingAccount(
                5_000,
                MIN_BALANCE,
                MAX_BALANCE,
                RATE
        );

        boolean result = account.pay(2_000);

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenPayAmountIsZero() {
        SavingAccount account = new SavingAccount(
                INITIAL_BALANCE,
                MIN_BALANCE,
                MAX_BALANCE,
                RATE
        );

        assertFalse(account.pay(0));
    }

    @Test
    public void shouldReturnFalseWhenAddAmountIsZero() {
        SavingAccount account = new SavingAccount(
                INITIAL_BALANCE,
                MIN_BALANCE,
                MAX_BALANCE,
                RATE
        );

        assertFalse(account.add(0));
    }

    @Test
    public void shouldReturnFalseWhenAddExceedsMaxBalance() {
        SavingAccount account = new SavingAccount(
                INITIAL_BALANCE,
                MIN_BALANCE,
                MAX_BALANCE,
                RATE
        );

        assertFalse(account.add(9_000));
    }

    @Test
    public void shouldCalculateYearChange() {
        SavingAccount account = new SavingAccount(
                INITIAL_BALANCE,
                MIN_BALANCE,
                MAX_BALANCE,
                RATE
        );

        assertEquals(100, account.yearChange());
    }
}