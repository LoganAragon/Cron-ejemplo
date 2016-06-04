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

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * <p>
 * This is just a simple job that says "Hello" to the world.
 * </p>
 * 
 * @author Bill Kratzer
 */
public class HelloJob implements Job {

    private static Logger _log = LoggerFactory.getLogger(HelloJob.class);

    /**
     * <p>
     * Empty constructor for job initilization
     * </p>
     * <p>
     * Quartz requires a public empty constructor so that the
     * scheduler can instantiate the class whenever it needs.
     * </p>
     */
    public HelloJob() {
    }

    /**
     * <p>
     * Called by the <code>{@link org.quartz.Scheduler}</code> when a
     * <code>{@link org.quartz.Trigger}</code> fires that is associated with
     * the <code>Job</code>.
     * </p>
     * 
     * @throws JobExecutionException
     *             if there is an exception while executing the job.
     */
    public void execute(JobExecutionContext context)
        throws JobExecutionException {

        
            try {
                main();
            } catch (IOException ex) {
               System.out.println("error al ejecutar la funcion main");
            }
    }

     private static final String[] CATEGORIES = new String[]{"abstract","animals","business","cats","city","food","nightlife","fashion","people","nature","sports","technics","transport"};
    private static final Random sRandom = new Random();

    public static String random(int width, int height) {
        return "http://lorempixel.com/"+width+"/"+height+"/"+CATEGORIES[sRandom.nextInt(CATEGORIES.length)]+"/"+(1+sRandom.nextInt(10));
    }
    
    public static void main() throws IOException{
        
        String ruta = "C:\\xampp\\htdocs\\index.html";
        File archivo = new File(ruta);
       
       String cadena = "<!DOCTYPE html>\n" +
"<html lang='en'>\n" +
"<head>\n" +
"   <meta charset='UTF-8'>\n" +
"   <title>Principal</title>\n" +
"</head>\n" +
"<body>\n" +
"   <h1>Imagenes</h1>\n" +
"   <img src='";
       
       String cadena1 =
               "' alt=''>\n" +
"</body>\n" +
"</html>"; 
      
      String url = random(240,320);
      
      cadena = cadena +url+cadena1;
      
      
      
 
      
      System.out.println(cadena);
      
        BufferedWriter  bw = new BufferedWriter(new FileWriter(archivo));
        bw.write(cadena);
        bw.close();
      
        
        
    
    }



}
