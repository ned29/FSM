package com.example.nedvy.fsm.model;

import android.support.annotation.NonNull;

import com.example.nedvy.fsm.model.enums.State;

public class ActionBody{

    @NonNull
    private State LOCK;

    @NonNull
    private State UNLOCK;

    @NonNull
    private State LOCK_2;

    @NonNull
    private State UNLOCK_2;

    public State getLOCK() {
        return LOCK;
    }

    public void setLOCK(State LOCK) {
        this.LOCK = LOCK;
    }

    public State getUNLOCK() {
        return UNLOCK;
    }

    public void setUNLOCK(State UNLOCK) {
        this.UNLOCK = UNLOCK;
    }

    public State getLOCK_2() {
        return LOCK_2;
    }

    public void setLOCK_2(State LOCK_2) {
        this.LOCK_2 = LOCK_2;
    }

    public State getUNLOCK_2() {
        return UNLOCK_2;
    }

    public void setUNLOCK_2(State UNLOCK_2) {
        this.UNLOCK_2 = UNLOCK_2;
    }

    @Override
    public String toString() {
        return  "LOCK=" + LOCK +
                ", UNLOCK=" + UNLOCK +
                ", LOCK_2=" + LOCK_2 +
                ", UNLOCK_2=" + UNLOCK_2;
    }
}
