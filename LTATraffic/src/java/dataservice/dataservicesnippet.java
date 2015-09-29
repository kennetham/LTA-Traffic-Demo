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
 * @author ケネス
 */
public class dataservicesnippet {

    private static UUID _uuid = UUID.randomUUID(); // Generate Random UUID
    private static ArrayList<CISTraffic> trafficList;
    private String myGuid = _uuid.toString();

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

    public ArrayList<CISTraffic> getWeather(String accountKey, String uniqueId) {
        trafficList = new ArrayList<CISTraffic>();

        try {
            URL _url = new URL("https://nea.projectnimbus.org/neaodataservice.svc/NowcastSet?");
            URLConnection _urlConn = _url.openConnection();

            _urlConn.setRequestProperty("accept", "*/*");
            _urlConn.addRequestProperty("AccountKey", accountKey);
            _urlConn.addRequestProperty("UniqueUserID", uniqueId);

            BufferedReader br = new BufferedReader(new InputStreamReader(_urlConn.getInputStream()));

            String line = null;
            StringBuilder strBuilder = new StringBuilder();

            while ((line = br.readLine()) != null) {
                strBuilder.append(line);
                System.out.println(line);
            }

            String[] IProperties = strBuilder.toString().split("<m:properties>");

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
