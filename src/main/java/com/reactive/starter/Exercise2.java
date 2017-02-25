package com.reactive.starter;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nasir on 25/2/17.
 */
public class Exercise2 {
    public static void main(String[] args) {

        List<String> lyrics = Arrays.asList("main", "hoon", "hero", "tera");

        Observable.just(lyrics)
                .subscribe(System.out::println);

        Observable.fromIterable(lyrics)
                .subscribe(System.out::println);

        Observable.range(1, 5)
                .subscribe(System.out::println);

        Observable.fromIterable(lyrics)
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s",count, string))
                .subscribe(System.out::println);

        Observable.fromIterable(lyrics)
                .flatMap(lyric -> Observable.fromArray(lyric.split("")))
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string))
                .subscribe(System.out::println);

        Observable.fromIterable(lyrics)
                .flatMap(lyric -> Observable.fromArray(lyric.split("")))
                .distinct()
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string))
                .subscribe(System.out::println);

        Observable.fromIterable(lyrics)
                .flatMap(lyric -> Observable.fromArray(lyric.split("")))
                .distinct()
                .sorted()
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string))
                .subscribe(System.out::println);
    }
}
