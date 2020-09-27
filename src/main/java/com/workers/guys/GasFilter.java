package com.workers.guys;

import com.workers.RandomUtil;

public class GasFilter extends Worker{

    public GasFilter(String name, WorkType workingExperience) {
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
        int chance = RandomUtil.randomNumRange(0,100);
        return chance <= 65;
    }}
    @Override
    public boolean onHoliday(){
        return this.workedDays > 23;
    }


}
