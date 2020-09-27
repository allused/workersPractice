package com.workers;

import com.workers.guys.*;

import java.util.Arrays;
import java.util.List;

public class Simulate {
    //Right now there is fix 3 workers, one from every type of worker in this simulation,
    //TODO extend with: -name generator   -optional number of workers  -set daily fee  -workers experience level improve after a year
    public static void simulate(int daysToSimulate){

        List<Worker>workersList = Arrays.asList(new Electrican("Robert", WorkType.MEDIUM),
                new GasFilter("Gida", WorkType.BEGINNER), new Plumber("Peter", WorkType.EXPERT));

        WokerCo guysCo = new WokerCo();

        guysCo.hireWorker(workersList);

        for (int i = 0; i < daysToSimulate; i++) {
            System.out.println("Day " + i +"\n");
           guysCo.setCurrentSecretary(RandomUtil.getRandomWorker(workersList));
                    guysCo.getWorkers().forEach(worker -> {
                    worker.resetDailyFee();
               if (worker.canWork()){
                   worker.addDay();
                   worker.setDailyFee(RandomUtil.randomNumRange(20000,40000));

               }else if(worker.equals(guysCo.getCurrentSecretary())) {
                   worker.addDay();
               }
               System.out.println(worker.getName() + " today income: " + worker.calculateTodayProfit()+"\n");
           });
           guysCo.addTodayIncome();
            System.out.println("Guys Co. today brutto income was: "+guysCo.getBruttoIncome()+ "\n Today secretary was: "+ guysCo.getCurrentSecretary().getName()+"\n");

            if (i == 29){
                guysCo.setTotalNettoProfit();
                System.out.println("End of one month!\nThis month Guys Co. netto income was: "+ guysCo.getTotalNettoProfit());
                guysCo.resetBruttoIncome();
                guysCo.getWorkers().forEach(Worker::resetWorkedDays);
            }
        }


    }
}
