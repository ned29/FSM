package com.example.nedvy.fsm.view;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.nedvy.fsm.model.enums.State;

public interface FSMActivityUseCase {

    interface View {

        void showState(@NonNull State state);
    }

    interface Presenter {

        void lock();

        void unlock();

        void lock2();

        void unlock2();

        void parse(@NonNull Context context);
    }
}
