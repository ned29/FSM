package com.example.nedvy.fsm.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.nedvy.fsm.FSMUseCase;
import com.example.nedvy.fsm.model.ActionBody;
import com.example.nedvy.fsm.model.enums.Action;
import com.example.nedvy.fsm.model.enums.State;
import com.example.nedvy.fsm.model.fsm.FSM;
import com.example.nedvy.fsm.model.parser.JsonParser;

import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class FSMPresenter implements FSMUseCase.Presenter {

    @Nullable
    private FSMUseCase.View view;

    @NonNull
    private static Map<State, List<ActionBody>> config;

    @NonNull
    private FSM fsm;

    public FSMPresenter(@NonNull FSMUseCase.View view) {
        this.view = view;
    }

    @Override
    public void lock() {
        if (view != null)
            view.showState(fsm.changeState(Action.LOCK));
    }

    @Override
    public void unlock() {
        if (view != null)
            view.showState(fsm.changeState(Action.UNLOCK));
    }

    @Override
    public void lock2() {
        if (view != null)
            view.showState(fsm.changeState(Action.LOCK_2));
    }

    @Override
    public void unlock2() {
        if (view != null)
            view.showState(fsm.changeState(Action.UNLOCK_2));

    }

    @Override
    public void parse(@NonNull Context context) {
        if (view != null) {
            config = JsonParser.fsmParser(context);
            fsm = new FSM(config);
        }
    }
}
