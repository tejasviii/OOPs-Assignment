package org.example;

import java.util.ArrayList;
import java.util.List;

class Car {
    private String type;
    private List<String> serviceCodes;

    public Car(String type) {
        this.type = type;
        this.serviceCodes = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void addServiceCode(String serviceCode) {
        serviceCodes.add(serviceCode);
    }

    public List<String> getServiceCodes() {
        return serviceCodes;
    }
}

class Service {
    private String code;
    private String name;
    private int hatchbackPrice;
    private int sedanPrice;
    private int suvPrice;

    public Service(String code, String name, int hatchbackPrice, int sedanPrice, int suvPrice) {
        this.code = code;
        this.name = name;
        this.hatchbackPrice = hatchbackPrice;
        this.sedanPrice = sedanPrice;
        this.suvPrice = suvPrice;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice(String carType) {
        switch (carType) {
            case "Hatchback":
                return hatchbackPrice;
            case "Sedan":
                return sedanPrice;
            case "SUV":
                return suvPrice;
            default:
                return 0;
        }
    }
}

class Bill {
    private Car car;
    private List<Service> services;

    public Bill(Car car, List<Service> services) {
        this.car = car;
        this.services = services;
    }

    public void generateBill() {
        int totalBill = 0;

        System.out.println("Type of Car: " + car.getType());
        System.out.println("Service Details:");

        for (Service service : services) {
            if (car.getServiceCodes().contains(service.getCode())) {
                int price = service.getPrice(car.getType());
                totalBill += price;
                System.out.println("- " + service.getName() + ": ₹ " + price);
            }
        }

        System.out.println("Total Bill: ₹ " + totalBill);

        if (totalBill > 10000) {
            System.out.println("Complimentary cleaning provided.");
        }
    }
}

public class CarServiceStation {
    public static void main(String[] args) {
        // Create car object
        Car car = new Car("Hatchback");
        car.addServiceCode("BS01");
        car.addServiceCode("EF01");

        // Create service objects
        Service basicService = new Service("BS01", "Basic Servicing", 2000, 4000, 5000);
        Service engineFixing = new Service("EF01", "Engine Fixing", 5000, 8000, 10000);
        Service clutchFixing = new Service("CF01", "Clutch Fixing", 2000, 4000, 6000);
        Service brakeFixing = new Service("BF01", "Brake Fixing", 1000, 1500, 2500);
        Service gearFixing = new Service("GF01", "Gear Fixing", 3000, 6000, 8000);

        // Create list of services
        List<Service> services = new ArrayList<>();
        services.add(basicService);
        services.add(engineFixing);
        services.add(clutchFixing);
        services.add(brakeFixing);
        services.add(gearFixing);

        // Generate bill
        Bill bill = new Bill(car, services);
        bill.generateBill();
    }
}
