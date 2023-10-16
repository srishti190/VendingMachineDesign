package com.vedingMachine.States;

import com.vedingMachine.Inventory.Inventory;
import com.vedingMachine.Inventory.Product;
import com.vedingMachine.VendingMachine.VendingMachine;

public class CoinInsertedState implements State{

    VendingMachine vendingMachine;

    public CoinInsertedState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        vendingMachine.setAmount(amount + vendingMachine.getAmount());
    }

    @Override
    //this state is for validation and further setting VM state to dispense
    public void pressButton(int aisleNumber) {
        //get inventory from vending machine -> collection of available products
        Inventory inventory = vendingMachine.getInventory();

        // get the product from inventory for that aisleNumber
        Product product = inventory.getProductAt(aisleNumber);

        //check if vending machine has sufficient amount to buy that product
        if(!vendingMachine.hasSufficientAmount(product.getPrice())){
            throw new IllegalStateException("Sorry, Insufficient amount to buy this product");
        }

        //check if product is available in the inventory
        if(!inventory.checkIfProductAvailable(product.getId())){
            throw new IllegalStateException("Sorry, product is unavailable");
        }

        //set vending machine state to DispenseState
        vendingMachine.setCurrVendingMachineState(vendingMachine.getDispenseState());
    }

    @Override
    public void dispense(int aisleNumber) {
        throw new IllegalStateException("Product not chosen");
    }
}
