/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataservice;

import properties.TCSTraffic;
import properties.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author kenneth
 */
public class TCSDataServiceQuery {

    private static final double ONE_KM = 0.0009;
    private static final double NEARBY_TRESHOLD = 1;
    private static UUID _uuid = UUID.randomUUID(); // Generate Random UUID
    //    private static ArrayList<Traffic> _trafficList;
    private static ArrayList<TCSTraffic> trafficList;
    private String myGuid = _uuid.toString();

    public static String getNearbyFilter(double _latitude, double _longitude, double distanceInKM) {
        String ret = "$filter=";

        //Top Right
        double _latitude1 = _latitude + ONE_KM * distanceInKM, _longitude1 = _longitude + ONE_KM * distanceInKM;
        ret += "Latitude%20le%20" + _latitude1 + "%20and%20Longitude%20le%20" + _longitude1;
        //Bottom Left
        double _latitude2 = _latitude - ONE_KM * distanceInKM, _longitude2 = _longitude - ONE_KM * distanceInKM;
        ret += "%20and%20Latitude%20ge%20" + _latitude2 + "%20and%20Longitude%20ge%20" + _longitude2;
        //Bottom Right
        double _latitude3 = _latitude + ONE_KM * distanceInKM, _longitude3 = _longitude - ONE_KM * distanceInKM;
        ret += "%20and%20Latitude%20le%20" + _latitude3 + "%20and%20Longitude%20ge%20" + _longitude3;
        //Top Left
        double _latitude4 = _latitude - ONE_KM * distanceInKM, _longitude4 = _longitude + ONE_KM * distanceInKM;
        ret += "%20and%20Latitude%20ge%20" + _latitude4 + "%20and%20Longitude%20le%20" + _longitude4;

        return ret;
    }

    /**
     * @return the myGuid
     */
    public String getMyGuid() {
        return myGuid;
    }

    /**
     * @param myGuid the myGuid to set
     */
    public void setMyGuid(String myGuid) {
        this.myGuid = myGuid;
    }

    public ArrayList<TCSTraffic> getNearbyTrafficConditionsA() {
        trafficList = new ArrayList<TCSTraffic>();

        String filterCondition = "$filter=RoadCategory%20eq%20'A'";

        try {
            URL _url = new URL("https://lta.projectnimbus.org/ltaodataservice.svc/TrafficConditionSet?" + filterCondition);
            URLConnection _urlConn = _url.openConnection();
            _urlConn.setRequestProperty("accept", "*/*");
            _urlConn.addRequestProperty("AccountKey", "mAnf12J0x9V6vnql2kbePuoWUJs=");
            _urlConn.addRequestProperty("UniqueUserID", getMyGuid());

            BufferedReader _bufferedReader = new BufferedReader(new InputStreamReader(_urlConn.getInputStream()));

            String line = null;
            StringBuilder _strBuilder = new StringBuilder();

            while ((line = _bufferedReader.readLine()) != null) {
                _strBuilder.append(line);
                System.out.println(line);
            }

            String[] IProperties = _strBuilder.toString().split("<m:properties>");

            for (String str : IProperties) {
                TCSTraffic traffic = new TCSTraffic();

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
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return trafficList;
    }

    public ArrayList<TCSTraffic> getNearbyTrafficConditionsB() {
        trafficList = new ArrayList<TCSTraffic>();

        String filterCondition = "$filter=RoadCategory%20eq%20'B'";

        try {
            URL _url = new URL("https://lta.projectnimbus.org/ltaodataservice.svc/TrafficConditionSet?" + filterCondition);
            URLConnection _urlConn = _url.openConnection();
            _urlConn.setRequestProperty("accept", "*/*");
            _urlConn.addRequestProperty("AccountKey", "mAnf12J0x9V6vnql2kbePuoWUJs=");
            _urlConn.addRequestProperty("UniqueUserID", getMyGuid());

            BufferedReader _bufferedReader = new BufferedReader(new InputStreamReader(_urlConn.getInputStream()));

            String line = null;
            StringBuilder _strBuilder = new StringBuilder();

            while ((line = _bufferedReader.readLine()) != null) {
                _strBuilder.append(line);
                System.out.println(line);
            }

            String[] IProperties = _strBuilder.toString().split("<m:properties>");

            for (String str : IProperties) {
                TCSTraffic traffic = new TCSTraffic();

                traffic.setTrafficConditionID(Utils.getStringBetween(str, "<d:TrafficConditionID m:type=\"Edm.Int32\">", "</d:TrafficConditionID>"));
                traffic.setTLinkID(Utils.getStringBetween(str, "<d:LinkID m:type=\"Edm.Int32\">", "</d:LinkID>"));
                traffic.setTRoadName(Utils.getStringBetween(str, "<d:RoadName xml:space=\"preserve\">", "</d:RoadName>"));
                traffic.setTRoadCategory(Utils.getStringBetween(str, "<d:RoadCategory>", "</d:RoadCategory>"));
                traffic.setTSpeed(Utils.getStringBetween(str, "<d:Speed m:type=\"Edm.Int32\">", "</d:Speed>"));
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
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return trafficList;
    }

    public ArrayList<TCSTraffic> getNearbyTrafficConditionsC() {
        trafficList = new ArrayList<TCSTraffic>();

        String filterCondition = "$filter=RoadCategory%20eq%20'C'";
        try {
            URL _url = new URL("https://lta.projectnimbus.org/ltaodataservice.svc/TrafficConditionSet?" + filterCondition);
            URLConnection _urlConn = _url.openConnection();
            _urlConn.setRequestProperty("accept", "*/*");
            _urlConn.addRequestProperty("AccountKey", "mAnf12J0x9V6vnql2kbePuoWUJs=");
            _urlConn.addRequestProperty("UniqueUserID", getMyGuid());

            BufferedReader _bufferedReader = new BufferedReader(new InputStreamReader(_urlConn.getInputStream()));

            String line = null;
            StringBuilder _strBuilder = new StringBuilder();

            while ((line = _bufferedReader.readLine()) != null) {
                _strBuilder.append(line);
                System.out.println(line);
            }

            String[] IProperties = _strBuilder.toString().split("<m:properties>");

            for (String str : IProperties) {
                TCSTraffic traffic = new TCSTraffic();

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
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return trafficList;
    }

    public ArrayList<TCSTraffic> getTrafficConditionsAll() {
        trafficList = new ArrayList<TCSTraffic>();

        try {
            URL _url = new URL("https://lta.projectnimbus.org/ltaodataservice.svc/TrafficConditionSet?");
            URLConnection _urlConn = _url.openConnection();
            _urlConn.setRequestProperty("accept", "*/*");
            _urlConn.addRequestProperty("AccountKey", "mAnf12J0x9V6vnql2kbePuoWUJs=");
            _urlConn.addRequestProperty("UniqueUserID", getMyGuid());

            BufferedReader _bufferedReader = new BufferedReader(new InputStreamReader(_urlConn.getInputStream()));

            String line = null;
            StringBuilder _strBuilder = new StringBuilder();

            while ((line = _bufferedReader.readLine()) != null) {
                _strBuilder.append(line);
                System.out.println(line);
            }

            String[] IProperties = _strBuilder.toString().split("<m:properties>");

            for (String str : IProperties) {
                TCSTraffic traffic = new TCSTraffic();

                traffic.setTrafficConditionID(Utils.getStringBetween(str, "<d:TrafficConditionID m:type=\"Edm.Int32\">", "</d:TrafficConditionID>"));
                traffic.setTLinkID(Utils.getStringBetween(str, "<d:LinkID m:type=\"Edm.Int32\">", "</d:LinkID>"));
                traffic.setTRoadName(Utils.getStringBetween(str, "<d:RoadName xml:space=\"preserve\">", "</d:RoadName>"));
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
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return trafficList;
    }
}
