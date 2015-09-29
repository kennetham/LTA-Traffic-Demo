package properties;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kenneth
 */
public class Traffic {

    private CISTraffic _cisTraffic;
    private ISTraffic _isTraffic;
    private TCSTraffic _tcsTraffic;

    /**
     * @return the _cisTraffic
     */
    public CISTraffic getCisTraffic() {
        return _cisTraffic;
    }

    /**
     * @param cisTraffic the _cisTraffic to set
     */
    public void setCisTraffic(CISTraffic cisTraffic) {
        this._cisTraffic = cisTraffic;
    }

    /**
     * @return the _isTraffic
     */
    public ISTraffic getIsTraffic() {
        return _isTraffic;
    }

    /**
     * @param isTraffic the _isTraffic to set
     */
    public void setIsTraffic(ISTraffic isTraffic) {
        this._isTraffic = isTraffic;
    }

    /**
     * @return the _tcsTraffic
     */
    public TCSTraffic getTcsTraffic() {
        return _tcsTraffic;
    }

    /**
     * @param tcsTraffic the _tcsTraffic to set
     */
    public void setTcsTraffic(TCSTraffic tcsTraffic) {
        this._tcsTraffic = tcsTraffic;
    }

    @Override
    public String toString() {
        return "Camera Image Set Traffic: " + getCisTraffic()
                + "\nIncident Set Traffic: " + getIsTraffic()
                + "\nTraffic Condition Set Traffic: " + getTcsTraffic() + "}";
    }
}
