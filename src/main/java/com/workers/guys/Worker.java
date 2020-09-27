package com.workers.guys;


public abstract class Worker {
    private final String name;
    private String currentSecretaryName;
    private WorkType workingExperience;
    private int toolPrice;
    protected double dailyFee;
    protected byte workedDays;


    public Worker(String name, WorkType workingExperience) {
        this.name = name;
        this.workingExperience = workingExperience;
        workedDays = 0;
        setToolPrice(workingExperience);

    }


    public int getToolPrice() {
        return toolPrice;
    }

    public void addDay() {
        workedDays += 1;
    }

    public byte getWorkedDays() {
        return workedDays;
    }

    public void resetWorkedDays() {
        workedDays = 0;
    }

    public void setCurrentSecretaryName(String currentSecretaryName) {
        this.currentSecretaryName = currentSecretaryName;
    }

    public void setWorkingExperience(WorkType workingExperience) {
        this.workingExperience = workingExperience;
    }

    public void setDailyFee(double payment) {
        this.dailyFee = payment;
    }

    public void resetDailyFee(){
        dailyFee = 0;
    }

    public double calculateTodayProfit(){
        return dailyFee * this.getWorkingExperience().getValue();
    }

    public void setToolPrice(WorkType workingExperience) {
        if (workingExperience == WorkType.BEGINNER){
            toolPrice = 50000;
        }else if (workingExperience == WorkType.MEDIUM){
            toolPrice = 35000;
        }else if (workingExperience == WorkType.EXPERT){
            toolPrice = 25000;
        }
    }

    public String getName() {
        return name;
    }

    public String getCurrentSecretaryName() {
        return currentSecretaryName;
    }

    public WorkType getWorkingExperience() {
        return workingExperience;
    }

    public double getDailyFee() {
        return dailyFee;
    }

    public abstract boolean canWork();

    public boolean onHoliday(){
        return false;
    }

}
