/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package properties;

/**
 *
 * @author kenneth
 */
public class TCSTraffic {

    private String TrafficConditionID, TLinkID, TRoadName, TRoadCategory, TSpeed, TLocation, TSummary, TCreateDate;

    /**
     * @return the TrafficConditionID
     */
    public String getTrafficConditionID() {
        return TrafficConditionID;
    }

    /**
     * @param TrafficConditionID the TrafficConditionID to set
     */
    public void setTrafficConditionID(String TrafficConditionID) {
        this.TrafficConditionID = TrafficConditionID;
    }

    /**
     * @return the TLinkID
     */
    public String getTLinkID() {
        return TLinkID;
    }

    /**
     * @param TLinkID the TLinkID to set
     */
    public void setTLinkID(String TLinkID) {
        this.TLinkID = TLinkID;
    }

    /**
     * @return the TRoadName
     */
    public String getTRoadName() {
        return TRoadName;
    }

    /**
     * @param TRoadName the TRoadName to set
     */
    public void setTRoadName(String TRoadName) {
        this.TRoadName = TRoadName;
    }

    /**
     * @return the TRoadCategory
     */
    public String getTRoadCategory() {
        return TRoadCategory;
    }

    /**
     * @param TRoadCategory the TRoadCategory to set
     */
    public void setTRoadCategory(String TRoadCategory) {
        this.TRoadCategory = TRoadCategory;
    }

    /**
     * @return the TSpeed
     */
    public String getTSpeed() {
        return TSpeed;
    }

    /**
     * @param TSpeed the TSpeed to set
     */
    public void setTSpeed(String TSpeed) {
        this.TSpeed = TSpeed;
    }

    /**
     * @return the TLocation
     */
    public String getTLocation() {
        return TLocation;
    }

    /**
     * @param TLocation the TLocation to set
     */
    public void setTLocation(String TLocation) {
        this.TLocation = TLocation;
    }

    /**
     * @return the TSummary
     */
    public String getTSummary() {
        return TSummary;
    }

    /**
     * @param TSummary the TSummary to set
     */
    public void setTSummary(String TSummary) {
        this.TSummary = TSummary;
    }

    /**
     * @return the TCreateDate
     */
    public String getTCreateDate() {
        return TCreateDate;
    }

    /**
     * @param TCreateDate the TCreateDate to set
     */
    public void setTCreateDate(String TCreateDate) {
        this.TCreateDate = TCreateDate;
    }

    /**
     * @param Override: TrafficConditionSet Data Override
     */
    @Override
    public String toString() {
        return "{Traffic Condition ID: " + getTrafficConditionID()
                + "\nLink ID: " + getTLinkID()
                + "\nRoad Name: " + getTRoadName()
                + "\nRoad Category: " + getTRoadCategory()
                + "\nSpeed: " + getTSpeed()
                + "\nLocation: " + getTLocation()
                + "\nSummary: " + getTSummary()
                + "\nCreate Date: " + getTCreateDate() + "}";
    }
}
