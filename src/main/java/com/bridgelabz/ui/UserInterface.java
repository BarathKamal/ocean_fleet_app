package com.bridgelabz.ui;

import com.bridgelabz.model.Vessel;
import com.bridgelabz.utility.VesselUtil;

import java.util.List;
import java.util.Scanner;

//uc6: refactor using oops
public class UserInterface {
    // method to add vessels
    public static void addVessels(Scanner scanner) {

        System.out.print("Enter total number of vessels: ");
        int totalVessels = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < totalVessels; i++) {
            System.out.println("Enter the vessel " + (i + 1) + " details:");
            String vesselDetail = scanner.nextLine();

            String vesselDetailParts[] = vesselDetail.split(":");

            Vessel vessel = new Vessel(vesselDetailParts[0],
                    vesselDetailParts[1],
                    Double.parseDouble(vesselDetailParts[2]),
                    vesselDetailParts[3]
            );

            VesselUtil.addVesselPerformance(vessel);
        }
    }

    // ui method to retrieve vessel
    public static void retrieveVessel(Scanner scanner) {
        System.out.print("Enter the vessel Id: ");
        String vesselId = scanner.nextLine();

        Vessel vessel = VesselUtil.getVesselById(vesselId);
        if (vessel != null) {
            VesselUtil.displayVesselDetails(vessel);
        }
        else {
            System.out.println("No Vessel with id (" + vesselId + ") exists!");
        }
    }

    // ui method to get high performance vessels
    public static void getHighPerformanceVessels() {
        List<Vessel> highPerformanceVessels = VesselUtil.getHighPerformanceVessels();
        for(Vessel vessel: highPerformanceVessels) {
            VesselUtil.displayVesselDetails(vessel);
        }
    }

    public static void main(String[] args) {

        // uc5: integrate user interaction
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("OceanFleet App: ");
            System.out.println("1. Add Vessels");
            System.out.println("2. Retrieve Vessel");
            System.out.println("3. Display High-Performance Vessel");
            System.out.println("4. Exit");

            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addVessels(scanner);
                case 2 -> retrieveVessel(scanner);
                case 3 -> getHighPerformanceVessels();
                case 4 -> {return; }
                default -> System.out.println("Enter a valid choice!!");
            }
        } while (true);
    }
}
