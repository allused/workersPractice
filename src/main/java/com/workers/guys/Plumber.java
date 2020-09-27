package com.workers.guys;

import com.workers.RandomUtil;

public class Plumber extends Worker {

    public Plumber(String name, WorkType workingExperience) {
        super(name, workingExperience);
    }

    @Override
    public boolean canWork() {
        if (onHoliday()){
            return false;
        }
        if (getCurrentSecretaryName().equals(this.getName())) {
            return false;
        } else {
            int chance = RandomUtil.randomNumRange(0, 100);
            return chance <= 80;
        }

    }
    @Override
    public boolean onHoliday() {
        return false;
    }


}

