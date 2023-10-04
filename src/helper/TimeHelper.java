package helper;

import enums.StatusEnum;

public class TimeHelper {
    public static void timeCounter() throws InterruptedException {
        System.out.println("3");
        Thread.sleep(1000);
        System.out.println("2");
        Thread.sleep(1000);
        System.out.println("1");
        Thread.sleep(1000);
        System.out.println(StatusEnum.EXAM_STARTED);
    }
}
