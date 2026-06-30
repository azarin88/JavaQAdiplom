package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldCreditAccountWithNegativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount creditAccount = new CreditAccount(-100,1000, 10);});
    }
    @Test
    public void shouldCreditAccountWithNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount creditAccount = new CreditAccount(100,-1000, 10);});
    }
    @Test
    public void shouldCreditAccountWithNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount creditAccount = new CreditAccount(100,1000, -10);});
    }
    @Test
    public void shouldPayWithAmountAboveNull() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(1);

        Assertions.assertEquals(-1, account.getBalance());
    }
    @Test
    public void shouldPayWithAmountBelowNull() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(-1);

        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void shouldPayWithAmountEqualNull() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(0);

        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void shouldPayWithBalanceAboveCreditLimit() {
        CreditAccount account = new CreditAccount(
                100,
                100,
                15
        );

        account.pay(199);

        Assertions.assertEquals(-99, account.getBalance());
    }
    @Test
    public void shouldPayWithBalanceBelowCreditLimit() {
        CreditAccount account = new CreditAccount(
                100,
                100,
                15
        );

        account.pay(201);

        Assertions.assertEquals(100, account.getBalance());
    }
    @Test
    public void shouldPayWithBalanceEqualCreditLimit() {
        CreditAccount account = new CreditAccount(
                100,
                100,
                15
        );

        account.pay(200);

        Assertions.assertEquals(-100, account.getBalance());
    }
    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3100, account.getBalance());
    }
    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void shouldAddToBalanceEqualNull() {
        CreditAccount account = new CreditAccount(
                1,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(1, account.getBalance());
    }
    @Test
    public void shouldYearChangeWithPositiveBalance() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }
    @Test
    public void shouldYearChangeWithNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(1000);

        Assertions.assertEquals(150, account.yearChange());
    }
    @Test
    public void shouldYearChangeWithBalanceEqualNull() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }
}
