package com.example.nedvy.fsm.model.fsm;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.nedvy.fsm.model.ActionBody;
import com.example.nedvy.fsm.model.enums.Action;
import com.example.nedvy.fsm.model.enums.State;

import java.util.List;
import java.util.Map;

public class FSM {

    @SuppressWarnings("unused")
    private static final String TAG = FSM.class.getName();

    @NonNull
    private static State state;

    @NonNull
    private Map<State, List<ActionBody>> config;

    public FSM(@NonNull Map<State, List<ActionBody>> config) {
        this.state = State.AlarmDisarmed_AllUnLocked;
        this.config = config;
    }

    public State changeState(@NonNull Action action) {
        for (Map.Entry<State, List<ActionBody>> entry : config.entrySet()) {
            if (entry.getKey().equals(state)) {
                switch (action) {
                    case LOCK:
                        return state = entry.getValue().get(0).getLOCK();
                    case UNLOCK:
                        return state = entry.getValue().get(0).getUNLOCK();
                    case LOCK_2:
                        return state = entry.getValue().get(0).getLOCK_2();
                    case UNLOCK_2:
                        return state = entry.getValue().get(0).getUNLOCK_2();
                }
            }
        }
        Log.i(TAG, "----->" + state);
        return state;
    }
}
