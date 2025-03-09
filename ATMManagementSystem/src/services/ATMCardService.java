package services;

import models.ATMCard;
import models.Account;
import models.Transaction;
import repositories.ATMCardImpl;
import repositories.AccountImpl;
import repositories.TransactionImpl;

public class ATMCardService {
    private static ATMCardImpl atmImpl=new ATMCardImpl();
    private static AccountImpl accImpl=new AccountImpl();
    private  static TransactionImpl transactionImpl=new TransactionImpl();
    private static AccountService accountService=new AccountService();

    public boolean addATMcard(long atmNo,int password,int accountId){
        return atmImpl.addATM(new ATMCard(atmNo,password,accountId));
    }

    public void getAllAtmCard(){
        atmImpl.getAllAtmCard();
    }
    public boolean authenticateATMCard(long atmNo,int password){
        ATMCard atm=atmImpl.getATMByATMNO(atmNo);
        if(atm!=null&&atm.getPasssword()==password){
            return true;
        }
        return  false;
    }

    public ATMCard getATMCardByNum(long atmNo){
        return  atmImpl.getATMByATMNO(atmNo);
    }

    public void getAllTransaction(){
        transactionImpl.getAllTransaction();
    }



}
