package com.workers;

import com.workers.guys.Worker;

import java.util.ArrayList;
import java.util.List;

public class WokerCo {

    private List<Worker> workers;
    private Worker currentSecretary;
    private int bruttoIncome;
    private double totalNettoProfit;

    public WokerCo() {
        this.workers = new ArrayList<>();
        this.bruttoIncome = 0;
        this.totalNettoProfit = 0;
    }

    public double calculateMonthlyProfit(){
        return bruttoIncome - calculateExpense();
    }

    public double getTotalNettoProfit() {
        return totalNettoProfit;
    }

    public void setTotalNettoProfit() {
        this.totalNettoProfit += calculateMonthlyProfit();
    }

    public int calculateExpense(){
        return workers.stream().mapToInt(Worker::getToolPrice).sum();
    }

    public void resetBruttoIncome(){bruttoIncome = 0;}



    public void hireWorker(Worker worker){
        workers.add(worker);
    }

    public void hireWorker(List<Worker> workers){
        this.workers.addAll(workers);
    }

    public void fireWorker(Worker worker){
        workers.forEach(worker1 -> {
            if (worker1.equals(worker))workers.remove(worker1);
        });
    }
    public List<Worker> getWorkers() {
        return workers;
    }

    public Worker getCurrentSecretary() {
        return currentSecretary;
    }

    public void setCurrentSecretary(Worker worker) {
        currentSecretary = worker;
        workers.forEach(employee -> employee.setCurrentSecretaryName(worker.getName()));
    }

    public void addTodayIncome(){
        workers.forEach(worker -> {
            bruttoIncome += (1.0-worker.getWorkingExperience().getValue())* worker.getDailyFee();
        });
    }

    public int getBruttoIncome() {
        return bruttoIncome;
    }
}
