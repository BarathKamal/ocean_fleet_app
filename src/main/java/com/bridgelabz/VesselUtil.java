package com.bridgelabz;

import java.util.List;

// uc2: store vessel records using list
public class VesselUtil {
    private List<Vessel> vesselList;

    // method to add vessel
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }
}
