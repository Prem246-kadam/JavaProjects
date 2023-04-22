import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class AlarmClock {
    static Timer timer = new Timer();
    static int seconds;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of seconds to set the alarm: ");
        seconds = input.nextInt();

        timer.schedule(new RemindTask(), seconds * 1000);

        System.out.println("Alarm set for " + seconds + " seconds.");

    }

    static class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            timer.cancel();
        }
    }
}
