package com.example.nedvy.fsm.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nedvy.fsm.FSMUseCase;
import com.example.nedvy.fsm.R;
import com.example.nedvy.fsm.model.enums.State;
import com.example.nedvy.fsm.presenter.FSMPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements FSMUseCase.View {

    @Nullable
    FSMUseCase.Presenter presenter;

    @BindView(R.id.relative)
    RelativeLayout relativeLayout;

    @BindView(R.id.state)
    TextView textState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new FSMPresenter(this);
        presenter.parse(this);
    }

    @OnClick(R.id.lock)
    void lock() {
        if (presenter != null)
            presenter.lock();
    }

    @OnClick(R.id.lockx2)
    void lock2() {
        if (presenter != null)
            presenter.lock2();
    }

    @OnClick(R.id.unlock)
    void unlock() {
        if (presenter != null)
            presenter.unlock();
    }

    @OnClick(R.id.unlockx2)
    void unlock2() {
        if (presenter != null)
            presenter.unlock2();
    }

    @Override
    public void showState(@NonNull State state) {
        Toast toast = Toast.makeText(getApplicationContext(), state.toString(), Toast.LENGTH_SHORT);
        toast.show();
        if (state == State.AlarmArmed_AllLocked){
            relativeLayout.setBackgroundColor(Color.RED);
            textState.setText("ARMED");
        }
        else {
            relativeLayout.setBackgroundColor(Color.GREEN);
            textState.setText("DISARMED");
        }
    }
}
