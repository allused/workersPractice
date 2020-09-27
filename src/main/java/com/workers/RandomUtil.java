package com.workers;

import com.workers.guys.Worker;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

    public static int randomNumRange(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static Worker getRandomWorker(List<Worker> workerList){
            Random rand = new Random();
            Worker randomWorker = workerList.get(rand.nextInt(workerList.size()));
            while (randomWorker.onHoliday()){
                randomWorker = workerList.get(rand.nextInt(workerList.size()));
            }
            return randomWorker;


    }
}
