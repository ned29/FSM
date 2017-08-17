package com.example.nedvy.fsm.model.enums;

import com.google.gson.annotations.SerializedName;

public enum State {

    @SerializedName("AlarmDisarmed_AllUnLocked")
    AlarmDisarmed_AllUnLocked,

    @SerializedName("AlarmDisarmed_DriverUnLocked")
    AlarmDisarmed_DriverUnLocked,

    @SerializedName("AlarmDisarmed_AllLocked")
    AlarmDisarmed_AllLocked,

    @SerializedName("AlarmArmed_AllLocked")
    AlarmArmed_AllLocked;
}
