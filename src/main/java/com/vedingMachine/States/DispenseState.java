package com.vedingMachine.States;

import com.vedingMachine.Inventory.Inventory;
import com.vedingMachine.Inventory.Product;
import com.vedingMachine.VendingMachine.VendingMachine;

public class DispenseState implements State{

    VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }


    @Override
    public void insertCoin(double amount) {
        throw new IllegalStateException("Product getting dispensed!");
    }

    @Override
    public void pressButton(int aisleNumber) {
        throw new IllegalStateException("Product getting dispensed!");
    }

    @Override
    public void dispense(int aisleNumber) {
        //get inventory
        Inventory inventory  =vendingMachine.getInventory();

        //get product from inventory for that aisle number
        Product product = inventory.getProductAt(aisleNumber);

        //deduct product from inventory
        inventory.deductProductCount(aisleNumber);

        //get change
        double change = vendingMachine.getAmount() - product.getPrice();

        //set amount to 0 for vending machine
        vendingMachine.setAmount(0);

        // set current state of VM to No coin inserted state
        vendingMachine.setCurrVendingMachineState(vendingMachine.getNoCoinInsertedState());

        System.out.println("Product with id " + product.getId() + " getting dispensed.");
        if(change > 0)
            System.out.println("Please collect change of " + change);
    }
}
