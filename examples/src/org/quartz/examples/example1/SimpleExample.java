/* 
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */
 
package org.quartz.examples.example1;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.SchedulerException;
import java.util.Date;

/**
 * This Example will demonstrate how to start and shutdown the Quartz scheduler and how to schedule a job to run in
 * Quartz.
 * 
 * @author Bill Kratzer
 */
public class SimpleExample {

  public void run() throws Exception {
    Logger log = LoggerFactory.getLogger(SimpleExample.class);

    

    // First we must get a reference to a scheduler
    SchedulerFactory sf = new StdSchedulerFactory();
    Scheduler sched = sf.getScheduler();

    

    // computer a time that is on the next round minute
    Date runTime = evenMinuteDate(new Date());

    

    // define the job and tie it to our HelloJob class
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();

    // Trigger the job to run on the next round minute
    Trigger trigger = newTrigger()
                        .withIdentity("primerCron")
                        .startNow()
                        .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(40)
                        .repeatForever())
                        .build();

    // Tell quartz to schedule the job using our trigger
    sched.scheduleJob(job, trigger);
    

    // Start up the scheduler (nothing can actually run until the
    // scheduler has been started)
    sched.start();

    

    // wait long enough so that the scheduler as an opportunity to
    // run the job!
    
   

  
    sched.shutdown(true);
  
  }

  public static void main(String[] args) throws Exception {

    SimpleExample example = new SimpleExample();
    example.run();

  }

}
