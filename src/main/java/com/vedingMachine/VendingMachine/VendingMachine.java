package com.vedingMachine.VendingMachine;

import com.vedingMachine.Inventory.Inventory;
import com.vedingMachine.Inventory.Product;
import com.vedingMachine.States.CoinInsertedState;
import com.vedingMachine.States.DispenseState;
import com.vedingMachine.States.NoCoinInsertedState;
import com.vedingMachine.States.State;

public class VendingMachine {
    private NoCoinInsertedState noCoinInsertedState;
    private CoinInsertedState coinInsertedState;
    private DispenseState dispenseState;
    private State currVendingMachineState;
    private Inventory inventory;
    private double amount;
    private static final int AISLE_COUNT = 2;

    public VendingMachine(){
        noCoinInsertedState = new NoCoinInsertedState(this);
        coinInsertedState = new CoinInsertedState(this);
        dispenseState = new DispenseState(this);
        currVendingMachineState = noCoinInsertedState;
        amount = 0.0;
        inventory = new Inventory(AISLE_COUNT);
    }

    public boolean hasSufficientAmount(double expectedAmount){
        return expectedAmount <= amount;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public double getAmount(){
        return amount;
    }

    public NoCoinInsertedState getNoCoinInsertedState() {
        return noCoinInsertedState;
    }

    public void setNoCoinInsertedState(NoCoinInsertedState noCoinInsertedState) {
        this.noCoinInsertedState = noCoinInsertedState;
    }

    public CoinInsertedState getCoinInsertedState() {
        return coinInsertedState;
    }

    public void setCoinInsertedState(CoinInsertedState coinInsertedState) {
        this.coinInsertedState = coinInsertedState;
    }

    public DispenseState getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(DispenseState dispenseState) {
        this.dispenseState = dispenseState;
    }

    public State getCurrVendingMachineState(NoCoinInsertedState noCoinInsertedState) {
        return currVendingMachineState;
    }

    public void setCurrVendingMachineState(State currVendingMachineState) {
        this.currVendingMachineState = currVendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void insertCoin(double amount){
        this.currVendingMachineState.insertCoin(amount);
        System.out.println(amount + " coin is inserted");
    }

    public void pressButton(int aisleNumber){
        this.currVendingMachineState.pressButton(aisleNumber);
        this.currVendingMachineState.dispense(aisleNumber);
    }

    public void addProduct(Product product){
        try {
            this.getInventory().addProduct(product);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
