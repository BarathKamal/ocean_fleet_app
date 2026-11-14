package com.bridgelabz;

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
}
