package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
     SavingAccount savingAccount1 = new SavingAccount(1000, 0, 2000, 15);
     SavingAccount savingAccount2 = new SavingAccount(1000, 0, 2000, 15);
     SavingAccount savingAccount3 = new SavingAccount(2000, 0, 2000, 15);
     SavingAccount savingAccount4 = new SavingAccount(500, 0, 2000, 15);
     CreditAccount creditAccount1 = new CreditAccount(1000, 0, 15);
     CreditAccount creditAccount2 = new CreditAccount(1000, 0, 15);
     Bank bank = new Bank();

     @Test
     public void shouldAddBalanceCreditAccount() {
          bank.transfer(creditAccount1,creditAccount2, 1000);

          int actual = creditAccount2.getBalance();
          int expected = 2000;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldPayBalanceCreditAccount() {
          bank.transfer(creditAccount1,creditAccount2, 1000);

          int actual = creditAccount1.getBalance();
          int expected = 0;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldAddBalanceCreditAccountAboveCreditLimit() {
          bank.transfer(creditAccount1,creditAccount2, 2000);

          int actual = creditAccount2.getBalance();
          int expected = 1000;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldPayBalanceCreditAccountAboveCreditLimit() {
          bank.transfer(creditAccount1,creditAccount2, 2000);

          int actual = creditAccount1.getBalance();
          int expected = 1000;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldAddBalanceSavingAccount() {
          bank.transfer(savingAccount1,savingAccount2, 1000);

          int actual = savingAccount2.getBalance();
          int expected = 2000;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldPayBalanceSavingAccount() {
          bank.transfer(savingAccount1,savingAccount2, 1000);

          int actual = savingAccount1.getBalance();
          int expected = 0;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldAddBalanceSavingAccountAboveMaxBalance() {
          bank.transfer(savingAccount3,savingAccount1, 2000);

          int actual = savingAccount1.getBalance();
          int expected = 1000;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldPayBalanceSavingAccountAboveMaxBalance() {
          bank.transfer(savingAccount3,savingAccount1, 2000);

          int actual = savingAccount3.getBalance();
          int expected = 2000;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldAddBalanceSavingAccountBelowMinBalance() {
          bank.transfer(savingAccount4,savingAccount1, 600);

          int actual = savingAccount1.getBalance();
          int expected = 1000;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldPayBalanceSavingAccountBelowMinBalance() {
          bank.transfer(savingAccount4,savingAccount1, 600);

          int actual = savingAccount4.getBalance();
          int expected = 500;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldAddBalanceCreditAccountAndSavingAccount() {
          bank.transfer(creditAccount1,savingAccount1, 500);

          int actual = savingAccount1.getBalance();
          int expected = 1500;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldPayBalanceCreditAccountAndSavingAccount() {
          bank.transfer(creditAccount1,savingAccount1, 500);

          int actual = creditAccount1.getBalance();
          int expected = 500;
          Assertions.assertEquals(expected, actual);
     }
     @Test
     public void shouldAddBalanceCreditAccountAndSavingAccountAboveMaxBalance() {
          bank.transfer(creditAccount1,savingAccount1, 1000);

          int actual = savingAccount1.getBalance();
          int expected = 2000;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldPayBalanceCreditAccountAndSavingAccountAboveMaxBalance() {
          bank.transfer(creditAccount1,savingAccount1, 1000);

          int actual = creditAccount1.getBalance();
          int expected = 0;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldAddBalanceCreditAccountAndSavingAccountAboveCreditLimit() {
          bank.transfer(creditAccount1,savingAccount4, 1200);

          int actual = savingAccount4.getBalance();
          int expected = 500;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldPayBalanceCreditAccountAndSavingAccountAboveCreditLimit() {
          bank.transfer(creditAccount1,savingAccount4, 1200);

          int actual = creditAccount1.getBalance();
          int expected = 1000;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldAddBalanceSavingAccountAndCreditAccount() {
          bank.transfer(savingAccount1,creditAccount1, 500);

          int actual = creditAccount1.getBalance();
          int expected = 1500;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldPayBalanceSavingAccountAndCreditAccount() {
          bank.transfer(savingAccount1,creditAccount1, 500);

          int actual = savingAccount1.getBalance();
          int expected = 500;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldAddBalanceSavingAccountAndCreditAccountBelowMinBalance() {
          bank.transfer(savingAccount4,creditAccount1, 600);

          int actual = creditAccount1.getBalance();
          int expected = 1000;
          Assertions.assertEquals(expected, actual);
     }

     @Test
     public void shouldPayBalanceCreditAccountAndSavingAccountBelowMinBalance() {
          bank.transfer(savingAccount4,creditAccount1, 600);

          int actual = savingAccount4.getBalance();
          int expected = 500;
          Assertions.assertEquals(expected, actual);
     }


}
