package org.example.Helper_classes.Other.Cron_classes;

import java.time.Duration;

public interface CronTask {
     void doSomething();
     Duration getInterval();
     void assingToService(CronService cronService);
}
