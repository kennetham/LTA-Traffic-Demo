<%-- 
    Document   : googlemap
    Created on : 2010/03/17, 15:59:22
    Author     : kenneth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%-- <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> --%>
<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
        <title>${title}</title>
        <!-- <script type="text/javascript" src="http://maps.google.com/maps?file=api&amp;v=2&amp;sensor=false&amp;key=ABQIAAAA1XbMiDxx_BTCY2_FkPh06RRaGTYH6UMl8mADNa0YKuWNNa8VNxQEerTAUcfkyrr6OwBovxn7TDAH5Q"></script> -->
        <!--<script src="http://maps.google.com/maps/api/staticmap?center=1.29531332000899,103.871145993977&zoom=12&size=500x400&maptype=satellite&sensor=true_or_false"> -->
        <script type="text/javascript">
            var map;
            var myPano;
            var panoClient;
            var nextPanoId;
            var lat=${clat};
            var lon=${clon};

            function initialize() {
                var pie = new GLatLng(lat,lon);
                //var piePOV = {yaw:370.64659986187695,pitch:-20};

                panoClient = new GStreetviewClient();

                map = new GMap2(document.getElementById("map_canvas"));
                map.setCenter(pie, 16);
                GEvent.addListener(map, "click", function(overlay,latlng) {
                    panoClient.getNearestPanorama(latlng, showPanoData);
                });

                myPano = new GStreetviewPanorama(document.getElementById("pano"));
                //myPano.setLocationAndPOV(pie, piePOV);
                myPano.setLocationAndPOV(pie);
                GEvent.addListener(myPano, "error", handleNoFlash);
                panoClient.getNearestPanorama(pie, showPanoData);
                map.setMapType(G_HYBRID_MAP);
            }

            function showPanoData(panoData) {
                if (panoData.code != 200) {
                    GLog.write('showPanoData: Server rejected with code: ' + panoData.code);
                    return;
                }
                nextPanoId = panoData.links[0].panoId;
                var displayString = [
                    "Panorama ID: " + panoData.location.panoId,
                    "LatLng: " + panoData.location.latlng,
                    "Description: " + panoData.location.description
                    //"Next Pano ID: " + panoData.links[0].panoId
                ].join("<br/>");
                map.openInfoWindowHtml(panoData.location.latlng, displayString);
            }

            function next() {
                // Get the next panoId
                // Note that this is not sophisticated. At the end of the block, it will get stuck
                panoClient.getPanoramaById(nextPanoId, showPanoData);
            }

            function handleNoFlash(errorCode) {
                if (errorCode == 603) {
                    alert("Error: Flash doesn't appear to be supported by your browser");
                    return;
                }
            }
        </script>

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js" type="text/javascript"></script>
        <style type="text/css">
            body { font-family:Arial, Helvetica, Sans-Serif; font-size:0.75em; color:#000;}
            .desc { color:#6b6b6b;}
            .desc a {color:#0092dd;}

            .dropdown dd, .dropdown dt, .dropdown ul { margin:0px; padding:0px; }
            .dropdown dd { position:relative; }
            .dropdown a, .dropdown a:visited { color:#816c5b; text-decoration:none; outline:none;}
            .dropdown a:hover { color:#5d4617;}
            .dropdown dt a:hover { color:#5d4617; border: 1px solid #d0c9af;}
            .dropdown dt a {background:#e4dfcb url(images/arrow.png) no-repeat scroll right center; display:block; padding-right:20px;
                            border:1px solid #d4ca9a; width:210px;}
            .dropdown dt a span {cursor:pointer; display:block; padding:4px;}
            .dropdown dd ul { background:#e4dfcb none repeat scroll 0 0; border:1px solid #d4ca9a; color:#C5C0B0; display:none;
                              left:0px; padding:4px 0px; position:absolute; top:2px; width:auto; min-width:215px; list-style:none;}
            .dropdown span.value { display:none;}
            .dropdown dd ul li a { padding:4px; display:block;}
            .dropdown dd ul li a:hover { background-color:#d0c9af;}
        </style>

        <script type="text/javascript">
            $(document).ready(function() {
                $(".dropdown dt a").click(function() {
                    $(".dropdown dd ul").toggle();
                });

                $(".dropdown dd ul li a").click(function() {
                    var text = $(this).html();
                    $(".dropdown dt a span").html(text);
                    $(".dropdown dd ul").hide();
                });

                $(document).bind('click', function(e) {
                    var $clicked = $(e.target);
                    if (! $clicked.parents().hasClass("dropdown"))
                        $(".dropdown dd ul").hide();
                });
            });
        </script>
    </head>
    <body style="font-family: Arial;border: 0 none;">
        <%-- <form method="POST" action="gmapselect.jsp">
            <input type="submit" value="Back" name="Back" />
        </form> --%>
        <dl id="location" class="dropdown">
            <dt><a href="#"><span>-- Please select an Expressway --</span></a></dt>
            <dd>
                <ul>
                    <li><a href="index.jsp">Home<span class="value">Home</span></a></li>
                    <li><a href="gmapselect.jsp">Go Back (Map Service)<span class="value">Map Service</span></a></li>
                    <li><a href="#"><span class="value"></span></a></li>
                    <li><a href="KPETPEECPCC">KPE(TPE) - ECP(Changi) - ECP(City)<span class="value">1001</span></a></li>
                    <li><a href="KPEECPPIETC">KPE(ECP) - PIE(Tuas) - PIE(Changi)<span class="value">1002</span></a></li>
                    <li><a href="PIECKPETPEECP">PIE(Changi) - KPE(TPE) - KPE(ECP)<span class="value">1003</span></a></li>
                    <li><a href="PIETKPEECP">PIE(Tuas) - KPE(ECP)<span class="value">1004</span></a></li>
                    <li><a href="KPEECPTPE">KPE(ECP) - KPE(TPE)<span class="value">1005</span></a></li>
                    <li><a href="KPEECPTPE2">KPE(ECP) - KPE(TPE) Opposite<span class="value">1006</span></a></li>
                    <li><a href="AYESLE">AYE - SLE<span class="value">1701</span></a></li>
                    <li><a href="SLECITY">SLE - CITY<span class="value">1702</span></a></li>
                    <li><a href="SLEAYE">SLE - AYE<span class="value">1703</span></a></li>
                    <li><a href="CITYSLE">CITY - SLE<span class="value">1705</span></a></li>
                    <li><a href="JOHORWOODLANDS">JOHOR - WOODLANDS<span class="value">2701</span></a></li>
                    <li><a href="BKECAUSEWAY">BKE - CAUSEWAY<span class="value">2702</span></a></li>
                    <li><a href="JURONGCHANGI">JURONG - CHANGI<span class="value">2703</span></a></li>
                    <li><a href="WOODLANDS">WOODLANDS<span class="value">2704</span></a></li>
                    <li><a href="PIEWOODLANDS">PIE - WOODLANDS<span class="value">2705</span></a></li>
                    <li><a href="CHANGI">CHANGI<span class="value">3793</span></a></li>
                    <li><a href="AYE_CITY">AYE / CITY<span class="value">3795</span></a></li>
                    <li><a href="CHANGI2">CHANGI 02<span class="value">3796</span></a></li>
                    <li><a href="CITYCHANGI">CITY - CHANGI<span class="value">3797</span></a></li>
                    <li><a href="CHANGICITY">CHANGI - CITY<span class="value">3798</span></a></li>
                    <li><a href="AYE">AYE<span class="value">3799</span></a></li>
                    <li><a href="CITYJURONG">CITY - JURONG<span class="value">4701</span></a></li>
                    <li><a href="JURONGCHANGI2">JURONG - CHANGI 02<span class="value">4702</span></a></li>
                    <li><a href="JOHORTUAS">JOHOR - TUAS<span class="value">4703</span></a></li>
                    <li><a href="ECPCTE">ECP - CTE<span class="value">4704</span></a></li>
                    <li><a href="JURONG">JURONG<span class="value">4706</span></a></li>
                    <li><a href="CITY">CITY<span class="value">4708</span></a></li>
                    <li><a href="TUASCHANGI">TUAS - CHANGI<span class="value">4710</span></a></li>
                    <li><a href="JOHOR">JOHOR<span class="value">4712</span></a></li>
                    <li><a href="AYE2NDLINK">AYE - 2ND LINK<span class="value">4713</span></a></li>
                    <li><a href="JURONGCHANGI3">JURONG - CHANGI 03<span class="value">5794</span></a></li>
                    <li><a href="CHANGIJURONG">CHANGI - JURONG<span class="value">5795</span></a></li>
                    <li><a href="JURONGCHANGI4">JURONG - CHANGI 04<span class="value">5797</span></a></li>
                    <li><a href="KPEJURONGCHANGI">KPE - JURONG - CHANGI<span class="value">5798</span></a></li>
                    <li><a href="JURONGCHANGI5">JURONG - CHANGI 05<span class="value">5799</span></a></li>
                    <li><a href="CHANGIJURONG2">CHANGI - JURONG 02<span class="value">6701</span></a></li>
                    <li><a href="JURONGCHANGI6">JURONG - CHANGI 06<span class="value">6703</span></a></li>
                    <li><a href="JURONGCHANGI7">JURONG - CHANGI 07<span class="value">6704</span></a></li>
                    <li><a href="JURONGCHANGI8">JURONG - CHANGI 08<span class="value">6705</span></a></li>
                    <li><a href="CHANGI3">CHANGI 03<span class="value">6706</span></a></li>
                    <li><a href="TUASCHANGI2">TUAS - CHANGI 02<span class="value">6708</span></a></li>
                    <li><a href="SLEPIECHANGIJURONG">SLE - PIE(CHANGI) - PIE(JURONG)<span class="value">7791</span></a></li>
                    <li><a href="SLEPIE">SLE - PIE<span class="value">7796</span></a></li>
                    <li><a href="BKETPE">BKE - TPE<span class="value">7798</span></a></li>
                    <li><a href="PIEBKE">PIE - BKE<span class="value">8701</span></a></li>
                    <li><a href="TPEBKE">TPE - BKE<span class="value">9701</span></a></li>
                    <li><a href="WOODLANDSPIE">WOODLANDS - PIE<span class="value">9703</span></a></li>
                </ul>
            </dd>
        </dl>
        <span id="result"></span>
        <!-- <div id="map_canvas" style="width: 500px; height: 400px"></div> -->
        <img alt="${title}" border="0" src="http://maps.google.com/maps/api/staticmap?center=${clat},${clon}&zoom=16&markers=size:mid|color:red|${clat},${clon}&maptype=hybrid&size=400x300&sensor=false" /><img alt="${title}" src="${imgLink}" title="${title}">&nbsp;
        <%-- <div name="pano" id="pano" style="width: 500px; height: 300px"></div>
        <input type="button" onclick="next()" value="Next"/> --%>
        <!-- <p align="center" style="position: absolute; bottom: 0; left: 0; width: 100%; text-align: center;" /><a rel="license" href="http://creativecommons.org/licenses/by/3.0/sg/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by/3.0/sg/88x31.png" /></a>
    <a href="http://sg.linkedin.com/in/kennetham"><img src="http://www.linkedin.com/img/webpromo/btn_myprofile_160x33.png" width="160" height="33" border="0" alt="View Kenneth Ham's profile on LinkedIn">
    </a><br /><span xmlns:dc="http://purl.org/dc/elements/1.1/" href="http://purl.org/dc/dcmitype/InteractiveResource" property="dc:title" rel="dc:type">Project Nimbus, LTA Demo Application</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://bit.ly/nimbuslta" property="cc:attributionName" rel="cc:attributionURL">Kenneth Ham Gao Jie</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/3.0/sg/">Creative Commons Attribution 3.0 Singapore License</a>.<br />Based on <a xmlns:dc="http://purl.org/dc/elements/1.1/" href="http://projectnimbus.org/" rel="dc:source">Project Nimbus</a>. -->
    </body>
</html>
