package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    public boolean isCompleteCall = false;
    public boolean isFinished = false;
    @Override
    public void execute() {
        if(isCompleteCall) isFinished = true;
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    public void complete() {
        isCompleteCall = true;
    }
}

