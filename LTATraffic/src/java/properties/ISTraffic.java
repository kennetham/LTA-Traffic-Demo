/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package properties;

/**
 *
 * @author kenneth
 */
public class ISTraffic {

    private String IncidentID, IMessage, ILatitude, ILongitude, IType, ISummary, ICreateDate, IDistance;

    /**
     * @return the IncidentID
     */
    public String getIncidentID() {
        return IncidentID;
    }

    /**
     * @param IncidentID the IncidentID to set
     */
    public void setIncidentID(String IncidentID) {
        this.IncidentID = IncidentID;
    }

    /**
     * @return the IMessage
     */
    public String getIMessage() {
        return IMessage;
    }

    /**
     * @param IMessage the IMessage to set
     */
    public void setIMessage(String IMessage) {
        this.IMessage = IMessage;
    }

    /**
     * @return the ILatitude
     */
    public String getILatitude() {
        return ILatitude;
    }

    /**
     * @param ILatitude the ILatitude to set
     */
    public void setILatitude(String ILatitude) {
        this.ILatitude = ILatitude;
    }

    /**
     * @return the ILongitude
     */
    public String getILongitude() {
        return ILongitude;
    }

    /**
     * @param ILongitude the ILongitude to set
     */
    public void setILongitude(String ILongitude) {
        this.ILongitude = ILongitude;
    }

    /**
     * @return the IType
     */
    public String getIType() {
        return IType;
    }

    /**
     * @param IType the IType to set
     */
    public void setIType(String IType) {
        this.IType = IType;
    }

    /**
     * @return the ISummary
     */
    public String getISummary() {
        return ISummary;
    }

    /**
     * @param ISummary the ISummary to set
     */
    public void setISummary(String ISummary) {
        this.ISummary = ISummary;
    }

    /**
     * @return the ICreateDate
     */
    public String getICreateDate() {
        return ICreateDate;
    }

    /**
     * @param ICreateDate the ICreateDate to set
     */
    public void setICreateDate(String ICreateDate) {
        this.ICreateDate = ICreateDate;
    }

    /**
     * @return the IDistance
     */
    public String getIDistance() {
        return IDistance;
    }

    /**
     * @param IDistance the IDistance to set
     */
    public void setIDistance(String IDistance) {
        this.IDistance = IDistance;
    }

    /**
     * @param Override: IncidentSet Data Override
     */
    @Override
    public String toString() {
        return "{IncidentID: " + getIncidentID()
                + "\nMessage: " + getIMessage()
                + "\nLatitude: " + getILatitude()
                + "\nLongitude: " + getILongitude()
                + "\nType: " + getIType()
                + "\nSummary: " + getISummary()
                + "\nCreate Date: " + getICreateDate()
                + "\nDistance: " + getIDistance() + "}";
    }
}
