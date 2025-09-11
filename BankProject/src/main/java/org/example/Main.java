package org.example;

import org.example.Accounts.BaseAccount;
import org.example.people.BaseHuman;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{
            BaseHuman baseHuman = new BaseHuman("0000","Jerry", "Berry");
            BaseAccount baseAccount = new BaseAccount("0000",10000000,"154536354", baseHuman);
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }



    }
}