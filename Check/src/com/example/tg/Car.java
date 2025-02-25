package com.example.tg;

public class Car {
    int maxFuel; // 10
    int fuelLeft; // 5
    int fuelPerKilometer; //0.2

    public Car(int maxFuel, int fuelPerKilometer){
        this.maxFuel = maxFuel;
        this.fuelPerKilometer = fuelPerKilometer;
    }

    int refuel(int liters){ //2
        if(maxFuel<(fuelLeft +liters)){
            fuelLeft = fuelLeft +liters;
            return maxFuel - fuelLeft;
        }
        return -1;
    }

    int getFuelLeft(){
        return fuelLeft;
    }

    void drive(int kilometers){ //5
        if(! (fuelLeft -(kilometers*fuelPerKilometer) <=0)){
            fuelLeft = fuelLeft -(kilometers*fuelPerKilometer);
        }
        else{
            System.out.println("You cannot drive that much");
        }
    }
}
