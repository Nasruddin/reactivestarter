package com.reactive.starter;

import io.reactivex.Observable;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by nasir on 25/2/17.
 */
public class Exercise3 {
    public static void main(String[] args) {

        Observable<Long> fast = Observable.interval(1, TimeUnit.SECONDS);
        Observable<Long> slow = Observable.interval(3, TimeUnit.SECONDS);

        Observable<Long> clock = Observable.merge(
                slow.filter(tick-> isSlowTickTime()),
                fast.filter(tick-> !isSlowTickTime())
        );

        clock.subscribe(tick-> System.out.println(new Date()));
    }

    /*private static boolean isSlowTickTime() {
        return LocalDate.now().getDayOfWeek() == DayOfWeek.SATURDAY ||
                LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY;
    }*/

    private static long start = System.currentTimeMillis();
    public static Boolean isSlowTickTime() {
        return (System.currentTimeMillis() - start) % 30_000 >= 15_000;
    }
}
