/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class SavingAccount {
    String accountID;
    int balance;

    public SavingAccount(String accountID, int balance) {
        this.accountID = accountID;
        this.balance = balance;
    }
    public boolean savingWithdraw(int money){
        if (money>0 && balance>money) {
            balance=balance-money;
            return true;
        } else {
            return false;
        }        
    }
    public boolean savingDeposit(int money){
        if (money>0) {
            balance+=money;
            return true;
        } else {
            return false;
        }        
    }
    public int getMoney(){
        return balance;
    }
}
