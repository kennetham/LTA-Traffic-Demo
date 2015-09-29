/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataservice;

import properties.CISTraffic;
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
public class CISDataServiceQuery {

    private static final double ONE_KM = 0.0009;
    private static final double NEARBY_TRESHOLD = 1;
    private static UUID _uuid = UUID.randomUUID(); // Generate Random UUID
    //    private static ArrayList<Traffic> _trafficList;
    private static ArrayList<CISTraffic> trafficList;
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

    //    private static LTATrafficSchema _ltaTraffic;
    public ArrayList<CISTraffic> getNearbyCamera(double _latitude, double _longitude) {
//        _trafficList = new ArrayList<Traffic>();
        trafficList = new ArrayList<CISTraffic>();
//        _ltaTraffic = new LTATrafficSchema();

        String filterString = getNearbyFilter(_latitude, _longitude, NEARBY_TRESHOLD);
//        System.out.println(filterString);
//        String filterTest = "$filter=Latitude%20ge%20" + 1.3383658553271742 + "%20and%20Longitude%20ge%20" + 103.64704147467515;

        try {
//            URL _url = new URL("https://lta.projectnimbus.org/ltaodataservice.svc/IncidentSet?" + "Latitude='" + _latitude + "'" + "&&Longitude='" + _longitude + "'");
            URL _url = new URL("https://lta.projectnimbus.org/ltaodataservice.svc/CameraImageSet?" + filterString);
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
//            _ltaTraffic.readEDMX(_strBuilder); // Error: StringBuilder enters argument, return null value.

            String[] IProperties = _strBuilder.toString().split("<m:properties>");

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
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return trafficList;
    }

    public ArrayList<CISTraffic> getCameras() {
        trafficList = new ArrayList<CISTraffic>();

        try {
            URL _url = new URL("https://lta.projectnimbus.org/ltaodataservice.svc/CameraImageSet?");
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
