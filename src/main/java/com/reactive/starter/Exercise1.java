package com.reactive.starter;

import io.reactivex.Observable;

/**
 * Created by nasir on 25/2/17.
 */
public class Exercise1 {
    public static void main(String[] args) {

        Observable<String> hello = Observable.just("Howdy!");
        hello.subscribe(System.out::println);

        Observable.just("Howdy Again!!!!")
                .subscribe(System.out::println);
    }
}
