package org.example.Helper_classes.Other.Cron_classes;

import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Singleton
public class CronService {
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    List<CronScheduledTask> cronTasks;

    private static class CronScheduledTask {
        final CronTask task;
        long nextRunTime;

        CronScheduledTask(CronTask task) {
            this.task = task;
            this.nextRunTime = System.currentTimeMillis() + task.getInterval().toMillis();
        }

        void reset() {
            nextRunTime = System.currentTimeMillis() + task.getInterval().toMillis();
        }
    }

    public CronService() {
        cronTasks = new ArrayList<>();
    }

    public void addCronTask(CronTask cronTask) {
        cronTasks.add(new CronScheduledTask(cronTask));    }

    public void start() {
        scheduler.scheduleAtFixedRate(this::tick, 0, 500, TimeUnit.MILLISECONDS);
    }

    private void tick() {
        long now = System.currentTimeMillis();
        for (CronScheduledTask cronTask : cronTasks) {
            System.out.println("bezi");
            if (now >= cronTask.nextRunTime) {
                try {
                    cronTask.task.doSomething();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cronTask.reset();
            }
        }
    }

    public void stop() {
        scheduler.shutdownNow();
    }

}
