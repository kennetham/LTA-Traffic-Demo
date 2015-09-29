/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package properties;

/**
 *
 * @author kenneth
 */
public class CISTraffic {

    private String CameraImageID, CameraID, CLatitude, CLongitude, CImageURL, CSummary, CCreateDate, CDistance, CImage;

    /**
     * @return the CameraImageID
     */
    public String getCameraImageID() {
        return CameraImageID;
    }

    /**
     * @param CameraImageID the CameraImageID to set
     */
    public void setCameraImageID(String CameraImageID) {
        this.CameraImageID = CameraImageID;
    }

    /**
     * @return the CameraID
     */
    public String getCameraID() {
        return CameraID;
    }

    /**
     * @param CameraID the CameraID to set
     */
    public void setCameraID(String CameraID) {
        this.CameraID = CameraID;
    }

    /**
     * @return the CLatitude
     */
    public String getCLatitude() {
        return CLatitude;
    }

    /**
     * @param CLatitude the CLatitude to set
     */
    public void setCLatitude(String CLatitude) {
        this.CLatitude = CLatitude;
    }

    /**
     * @return the CLongitude
     */
    public String getCLongitude() {
        return CLongitude;
    }

    /**
     * @param CLongitude the CLongitude to set
     */
    public void setCLongitude(String CLongitude) {
        this.CLongitude = CLongitude;
    }

    /**
     * @return the CImageURL
     */
    public String getCImageURL() {
        return CImageURL;
    }

    /**
     * @param CImageURL the CImageURL to set
     */
    public void setCImageURL(String CImageURL) {
        this.CImageURL = CImageURL;
    }

    /**
     * @return the CSummary
     */
    public String getCSummary() {
        return CSummary;
    }

    /**
     * @param CSummary the CSummary to set
     */
    public void setCSummary(String CSummary) {
        this.CSummary = CSummary;
    }

    /**
     * @return the CCreateDate
     */
    public String getCCreateDate() {
        return CCreateDate;
    }

    /**
     * @param CCreateDate the CCreateDate to set
     */
    public void setCCreateDate(String CCreateDate) {
        this.CCreateDate = CCreateDate;
    }

    /**
     * @return the CDistance
     */
    public String getCDistance() {
        return CDistance;
    }

    /**
     * @param CDistance the CDistance to set
     */
    public void setCDistance(String CDistance) {
        this.CDistance = CDistance;
    }

    /**
     * @return the CImage
     */
    public String getCImage() {
        return CImage;
    }

    /**
     * @param CImage the CImage to set
     */
    public void setCImage(String CImage) {
        this.CImage = CImage;
    }

    /**
     * @param Override: CameraImageSet Data Override
     */
    @Override
    public String toString() {
        return "{Camera Image ID: " + getCameraImageID()
                + "\nCamera ID: " + getCameraID()
                + "\nLatitude: " + getCLatitude()
                + "\nLongitude: " + getCLongitude()
                + "\nCamera Image URL: " + getCImageURL()
                + "\nSummary: " + getCSummary()
                + "\nCreate Date: " + getCCreateDate()
                + "\nDistance: " + getCDistance()
                + "\nImage: " + getCImage() + "}";
    }
}
