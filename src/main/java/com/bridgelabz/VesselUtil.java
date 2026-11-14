package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

// uc2: store vessel records using list
public class VesselUtil {
    private List<Vessel> vesselList;

    // method to add vessel
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    // uc3: retrieve vessel by vessel id
    // method to get vessel by vesselId
    public Vessel getVesselById(String vesselId) {
        Iterator<Vessel> iterator = vesselList.iterator();
        while(iterator.hasNext()) {
            Vessel vessel = iterator.next();
            if (vessel.getVesselId().equals(vesselId)) {
                return vessel;
            }
        }
        return null;
    }

    // uc4: identify high-performance vessels
    // method to get high-performance vessels
    public List<Vessel> getHighPerformanceVessels(){
        double maxSpeed = Double.NEGATIVE_INFINITY;
        List<Vessel> highPerformanceVessels = new ArrayList<>();

        // for-each loop finds the maximum speed
        for (Vessel vessel: vesselList) {
            if (vessel.getAverageSpeed() > maxSpeed) {
                maxSpeed = vessel.getAverageSpeed();
            }
        }

        // for-each loop that collects the high performance vessels
        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() == maxSpeed) {
                highPerformanceVessels.add(vessel);
            }
        }

        return highPerformanceVessels;
    }
}
