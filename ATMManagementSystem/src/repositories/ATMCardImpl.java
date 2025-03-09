package repositories;

import models.ATMCard;

public class ATMCardImpl {
    private ATMCard[] atms=new ATMCard[100];
    private int countATM=0;

    public boolean addATM(ATMCard atmCard){
        if(countATM<atms.length){
            atms[countATM++]=atmCard;
            return true;
        }
        return  false;
    }

    public void deleteATM(long atmNo){
        for(int i=0;i<atms.length;i++){
            if(atms[i].getAtmNo()==atmNo){
                atms[i]=null;
            }
        }
    }

    public void getAllAtmCard(){
        for(int i=0;i<atms.length;i++){
            System.out.println(atms[i]);
        }
    }

    public ATMCard getATMByATMNO(long atmNo){
        for(int i=0;i<atms.length;i++){
            if(atms[i].getAtmNo()==atmNo){
                return atms[i];
            }
        }
        return null;
    }










}
