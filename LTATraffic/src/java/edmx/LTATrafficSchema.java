/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edmx;

import java.util.*;
import properties.*;

/**
 *
 * @author kenneth
 */
public class LTATrafficSchema {

    private StringBuilder result;
    private ArrayList<Traffic> _trafficList;
    private ArrayList<CISTraffic> _cisTrafficList;
    private ArrayList<ISTraffic> _isTrafficList;
    private ArrayList<TCSTraffic> _tcsTrafficList;
//    private SimpleDateFormat _simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public LTATrafficSchema() {
        result = new StringBuilder();
    }

    public ArrayList<CISTraffic> readCISEDMX(StringBuilder _str) {
//        _trafficList = new ArrayList<Traffic>();
        _cisTrafficList = new ArrayList<CISTraffic>();

        try {
            String[] IProperties = _str.toString().split("<m:properties>");

            for (String str : IProperties) {
//                Traffic _traffic = new Traffic();
                CISTraffic traffic = new CISTraffic();

                traffic.setCameraImageID(Utils.getStringBetween(str, "<d:CameraImageID m:type=\"Edm.Int32\">", "</d:CameraImageID>"));
                traffic.setCameraID(Utils.getStringBetween(str, "<d:CameraID m:type=\"Edm.Int32\">", "</d:CameraID>"));
                traffic.setCLatitude(Utils.getStringBetween(str, "<d:Latitude m:type=\"Edm.Double\">", "</d:Latitude>"));
                traffic.setCLongitude(Utils.getStringBetween(str, "<d:Longitude m:type=\"Edm.Double\">", "</d:Longitude>"));
                traffic.setCImageURL(Utils.getStringBetween(str, "<d:ImageURL>", "</d:ImageURL>"));
                traffic.setCSummary(Utils.getStringBetween(str, "<d:Summary>", "</d:Summary"));
                traffic.setCCreateDate(Utils.getStringBetween(str, "<d:CreateDate m:type=\"Edm.DateTime\">", "</d:CreateDate>"));
                traffic.setCDistance(Utils.getStringBetween(str, "<d:Distance m:type=\"Edm.Double\">", "</d:Distance>"));
                traffic.setCImage(Utils.getStringBetween(str, "<d:Image m:type=\"Edm.Binary\">", "</d:Image>"));

//                _traffic.getCisTraffic().setCameraImageID(Utils.getStringBetween(str, "<d:CameraImageID m:type=\"Edm.Int32\">", "</d:CameraImageID>"));
//                _traffic.getCisTraffic().setCameraID(Utils.getStringBetween(str, "<d:CameraID m:type=\"Edm.Int32\">", "</d:CameraID>"));
//                _traffic.getCisTraffic().setCLatitude(Utils.getStringBetween(str, "<d:Latitude m:type=\"Edm.Double\">", "</d:Latitude>"));
//                _traffic.getCisTraffic().setCLongitude(Utils.getStringBetween(str, "<d:Longitude m:type=\"Edm.Double\">", "</d:Longitude>"));
//                _traffic.getCisTraffic().setCImageURL(Utils.getStringBetween(str, "<d:ImageURL>", "</d:ImageURL>"));
//                _traffic.getCisTraffic().setCSummary(Utils.getStringBetween(str, "<d:Summary>", "</d:Summary"));
//                _traffic.getCisTraffic().setCCreateDate(Utils.getStringBetween(str, "<d:CreateDate m:type=\"Edm.DateTime\">", "</d:CreateDate>"));
//                _traffic.getCisTraffic().setCDistance(Utils.getStringBetween(str, "<d:Distance m:type=\"Edm.Double\">", "</d:Distance>"));
//                _traffic.getCisTraffic().setCImage(Utils.getStringBetween(str, "<d:Image m:type=\"Edm.Binary\">", "</d:Image>"));

                getCisTrafficList().add(traffic);
//                _trafficList.add(_traffic);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return getCisTrafficList();
    }

    public ArrayList<ISTraffic> readISEDMX(StringBuilder _str) {
//        _trafficList = new ArrayList<Traffic>();
        _isTrafficList = new ArrayList<ISTraffic>();

        try {
            String[] IProperties = _str.toString().split("<m:properties>");

            for (String str : IProperties) {
//                Traffic _traffic = new Traffic();
                ISTraffic traffic = new ISTraffic();

                traffic.setIncidentID(Utils.getStringBetween(str, "<d:IncidentID m:type=\"Edm.Int32\">", "</d:IncidentID>"));
                traffic.setIMessage(Utils.getStringBetween(str, "<d:Message>", "</d:Message>"));
                traffic.setILatitude(Utils.getStringBetween(str, "<d:Latitude m:type=\"Edm.Double\">", "</d:Latitude>"));
                traffic.setILongitude(Utils.getStringBetween(str, "<d:Longitude m:type=\"Edm.Double\">", "</d:Longitude>"));
                traffic.setIType(Utils.getStringBetween(str, "<d:Type>", "</d:Type>"));
                traffic.setISummary(Utils.getStringBetween(str, "<d:Summary>", "</d:Summary"));
                traffic.setICreateDate(Utils.getStringBetween(str, "<d:CreateDate m:type=\"Edm.DateTime\">", "</d:CreateDate>"));
                traffic.setIDistance(Utils.getStringBetween(str, "<d:Distance m:type=\"Edm.Double\">", "</d:Distance>"));

//                _traffic.getIsTraffic().setIncidentID(Utils.getStringBetween(str, "<d:IncidentID m:type=\"Edm.Int32\">", "</d:IncidentID>"));
//                _traffic.getIsTraffic().setIMessage(Utils.getStringBetween(str, "<d:Message>", "</d:Message>"));
//                _traffic.getIsTraffic().setILatitude(Utils.getStringBetween(str, "<d:Latitude m:type=\"Edm.Double\">", "</d:Latitude>"));
//                _traffic.getIsTraffic().setILongitude(Utils.getStringBetween(str, "<d:Longitude m:type=\"Edm.Double\">", "</d:Longitude>"));
//                _traffic.getIsTraffic().setIType(Utils.getStringBetween(str, "<d:Type>", "</d:Type>"));
//                _traffic.getIsTraffic().setISummary(Utils.getStringBetween(str, "<d:Summary>", "</d:Summary"));
//                _traffic.getIsTraffic().setICreateDate(Utils.getStringBetween(str, "<d:CreateDate m:type=\"Edm.DateTime\">", "</d:CreateDate>"));
//                _traffic.getIsTraffic().setIDistance(Utils.getStringBetween(str, "<d:Distance m:type=\"Edm.Double\">", "</d:Distance>"));

                getIsTrafficList().add(traffic);
//                _trafficList.add(_traffic);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return getIsTrafficList();
    }

    public ArrayList<TCSTraffic> readTCSEDMX(StringBuilder _str) {
//        _trafficList = new ArrayList<Traffic>();
        _tcsTrafficList = new ArrayList<TCSTraffic>();

        try {
            String[] IProperties = _str.toString().split("<m:properties>");

            for (String str : IProperties) {
//                Traffic _traffic = new Traffic();
                TCSTraffic traffic = new TCSTraffic();
//
                traffic.setTrafficConditionID(Utils.getStringBetween(str, "<d:TrafficConditionID m:type=\"Edm.Int32\">", "</d:TrafficConditionID>"));
                traffic.setTLinkID(Utils.getStringBetween(str, "<d:LinkID m:type=\"Edm.Int32\">", "</d:LinkID>"));
                traffic.setTRoadName(Utils.getStringBetween(str, "<d:RoadName>", "</d:RoadName>"));
                traffic.setTRoadCategory(Utils.getStringBetween(str, "<d:RoadCategory>", "</d:RoadCategory>"));
                traffic.setTLocation(Utils.getStringBetween(str, "<d:Location>", "</d:Location>"));
                traffic.setTSummary(Utils.getStringBetween(str, "<d:Summary>", "</d:Summary"));
                traffic.setTCreateDate(Utils.getStringBetween(str, "<d:CreateDate m:type=\"Edm.DateTime\">", "</d:CreateDate>"));

//                _traffic.getTcsTraffic().setTrafficConditionID(Utils.getStringBetween(str, "<d:TrafficConditionID m:type=\"Edm.Int32\">", "</d:TrafficConditionID>"));
//                _traffic.getTcsTraffic().setTLinkID(Utils.getStringBetween(str, "<d:LinkID m:type=\"Edm.Int32\">", "</d:LinkID>"));
//                _traffic.getTcsTraffic().setTRoadName(Utils.getStringBetween(str, "<d:RoadName>", "</d:RoadName>"));
//                _traffic.getTcsTraffic().setTRoadCategory(Utils.getStringBetween(str, "<d:RoadCategory>", "</d:RoadCategory>"));
//                _traffic.getTcsTraffic().setTLocation(Utils.getStringBetween(str, "<d:Location>", "</d:Location>"));
//                _traffic.getTcsTraffic().setTSummary(Utils.getStringBetween(str, "<d:Summary>", "</d:Summary"));
//                _traffic.getTcsTraffic().setTCreateDate(Utils.getStringBetween(str, "<d:CreateDate m:type=\"Edm.DateTime\">", "</d:CreateDate>"));

                getTcsTrafficList().add(traffic);
//                _trafficList.add(traffic);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return getTcsTrafficList();
    }

    public String getResult() {
        return result.toString();
    }

    /**
     * @return the _trafficList
     */
    public ArrayList<Traffic> getTrafficList() {
        return _trafficList;
    }

    /**
     * @return the _cisTrafficList
     */
    public ArrayList<CISTraffic> getCisTrafficList() {
        return _cisTrafficList;
    }

    /**
     * @return the _isTrafficList
     */
    public ArrayList<ISTraffic> getIsTrafficList() {
        return _isTrafficList;
    }

    /**
     * @return the _tcsTrafficList
     */
    public ArrayList<TCSTraffic> getTcsTrafficList() {
        return _tcsTrafficList;
    }
}
