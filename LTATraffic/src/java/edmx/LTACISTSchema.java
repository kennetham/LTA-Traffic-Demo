/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edmx;

import properties.*;
import java.util.*;

/**
 *
 * @author kenneth
 */
public class LTACISTSchema {

    private StringBuilder result;
//    private ArrayList<Traffic> _trafficList;
    private ArrayList<CISTraffic> trafficList;
//    private SimpleDateFormat _simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public LTACISTSchema() {
        result = new StringBuilder();
    }

    public ArrayList<CISTraffic> readEDMX(StringBuilder _str) {
//        _trafficList = new ArrayList<Traffic>();
        trafficList = new ArrayList<CISTraffic>();

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

                trafficList.add(traffic);
//                _trafficList.add(_traffic);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return trafficList;
    }

    public String getResult() {
        return result.toString();
    }
}
