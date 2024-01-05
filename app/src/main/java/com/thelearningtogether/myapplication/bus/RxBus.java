package com.thelearningtogether.myapplication.bus;

import rx.Observable;
import rx.subjects.PublishSubject;

public class RxBus {

    private static final PublishSubject<Object> bus = PublishSubject.create();
    public void send(Object o) {
        bus.onNext(o);
    }
    public Observable<Object> toObserverable() {
        return bus;
    }
    public boolean hasObservers() {
        return bus.hasObservers();
    }
    public static RxBus getInstance() {
        return new RxBus();
    }
    private RxBus() {
        // No instances.
    }
}
