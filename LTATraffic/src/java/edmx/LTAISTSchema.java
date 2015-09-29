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
public class LTAISTSchema {

    private StringBuilder result;
//    private ArrayList<Traffic> _trafficList;
    private ArrayList<ISTraffic> trafficList;
//    private SimpleDateFormat _simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public LTAISTSchema() {
        result = new StringBuilder();
    }

    public ArrayList<ISTraffic> readEDMX(StringBuilder _str) {
//        _trafficList = new ArrayList<Traffic>();
        trafficList = new ArrayList<ISTraffic>();

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
