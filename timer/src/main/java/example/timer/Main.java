package example.timer;

import java.util.Timer;


public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println(Main.class + " starting...");

        // create arguments for timer
        Object argument = new Integer(22);

        // create timer object
        // set it as a daemon so the JVM doesn't wait for it when quitting
        Timer timer = new Timer(/*isDaemon*/ true);

        // create timer task object
        MyTimerTask myTimerTask = new MyTimerTask(argument);

        timer.schedule(myTimerTask, /*delay*/ 0 * 1000, /*period*/ 3 * 1000);
        // sleep 10 seconds, then finish
        Thread.sleep(10 * 1000);

        System.out.println(Main.class + " finished.");
    }

}
