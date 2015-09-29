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
public class LTATCSTSchema {

    private StringBuilder result;
//    private ArrayList<Traffic> _trafficList;
    private ArrayList<TCSTraffic> trafficList;
//    private SimpleDateFormat _simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public LTATCSTSchema() {
        result = new StringBuilder();
    }

    public ArrayList<TCSTraffic> readEDMX(StringBuilder _str) {
//        _trafficList = new ArrayList<Traffic>();
        trafficList = new ArrayList<TCSTraffic>();

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

                trafficList.add(traffic);
//                _trafficList.add(traffic);
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
