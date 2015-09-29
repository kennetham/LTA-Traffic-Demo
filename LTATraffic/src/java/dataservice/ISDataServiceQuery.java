/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dataservice;

import properties.ISTraffic;
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
public class ISDataServiceQuery {

    private static final double ONE_KM = 0.0009;
    private static final double NEARBY_TRESHOLD = 1;
    private static UUID _uuid = UUID.randomUUID(); // Generate Random UUID
    //    private static ArrayList<Traffic> _trafficList;
    private static ArrayList<ISTraffic> trafficList;
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

//    private static LTATrafficSchema _ltaTraffic;

    /**
     * @param myGuid the myGuid to set
     */
    public void setMyGuid(String myGuid) {
        this.myGuid = myGuid;
    }

    public ArrayList<ISTraffic> getNearbyIncidents(double _latitude, double _longitude) {
        trafficList = new ArrayList<ISTraffic>();

        String filterString = getNearbyFilter(_latitude, _longitude, NEARBY_TRESHOLD);

        try {
            URL _url = new URL("https://lta.projectnimbus.org/ltaodataservice.svc/IncidentSet?" + filterString);
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

    public ArrayList<ISTraffic> getIncidents() {
        trafficList = new ArrayList<ISTraffic>();

        try {
            URL _url = new URL("https://lta.projectnimbus.org/ltaodataservice.svc/IncidentSet?");
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
}
