package com.example.weblab3.beans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class UserRequest implements java.io.Serializable {
    private boolean neg4;
    private boolean neg3;
    private boolean neg2;
    private boolean neg1;
    private boolean zero;
    private boolean pos1;
    private boolean pos2;
    private boolean pos3;
    private boolean pos4;

    private double y;
    private double r;

    public UserRequest() {
        neg4 = false;
        neg3 = false;
        neg2 = false;
        neg1 = false;
        zero = false;
        pos1 = false;
        pos2 = false;
        pos3 = false;
        pos4 = false;
        y = 0;
        r = 0.1;
    }

    public boolean isNeg4() {
        return neg4;
    }

    public void setNeg4(boolean neg4) {
        this.neg4 = neg4;
    }

    public boolean isNeg3() {
        return neg3;
    }

    public void setNeg3(boolean neg3) {
        this.neg3 = neg3;
    }

    public boolean isNeg2() {
        return neg2;
    }

    public void setNeg2(boolean neg2) {
        this.neg2 = neg2;
    }

    public boolean isNeg1() {
        return neg1;
    }

    public void setNeg1(boolean neg1) {
        this.neg1 = neg1;
    }

    public boolean isZero() {
        return zero;
    }

    public void setZero(boolean zero) {
        this.zero = zero;
    }

    public boolean isPos1() {
        return pos1;
    }

    public void setPos1(boolean pos1) {
        this.pos1 = pos1;
    }

    public boolean isPos2() {
        return pos2;
    }

    public void setPos2(boolean pos2) {
        this.pos2 = pos2;
    }

    public boolean isPos3() {
        return pos3;
    }

    public void setPos3(boolean pos3) {
        this.pos3 = pos3;
    }

    public boolean isPos4() {
        return pos4;
    }

    public void setPos4(boolean pos4) {
        this.pos4 = pos4;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

}
