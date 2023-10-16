package com.vedingMachine;


import com.vedingMachine.Inventory.Product;
import com.vedingMachine.VendingMachine.VendingMachine;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        VendingMachine vendingMachine = new VendingMachine();

        Product chocolate = new Product("Hershey's", 1, 5.0);

        for(int i=1; i <= 3; i++){
            vendingMachine.addProduct(chocolate);
        }

        Product biscuit = new Product("Bourbon", 2, 2.0);

        for(int i=1; i <= 3; i++){
            vendingMachine.addProduct(biscuit);
        }

        vendingMachine.insertCoin(5.0);
        vendingMachine.insertCoin(5.0);
        vendingMachine.pressButton(1);

        vendingMachine.insertCoin(5.0);
        vendingMachine.pressButton(1);

        vendingMachine.insertCoin(7.0);
        vendingMachine.pressButton(2);
    }
}
