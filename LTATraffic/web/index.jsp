<%-- 
    Document   : index
    Created on : 2010/03/04, 11:31:27
    Author     : kenneth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Project Nimbus - LTA Traffic</title>
    <script type="text/javascript" src="jquery/jquery-1.4.2.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".menu2 a").append("<em></em>");
            $(".menu2 a").hover(function() {
                $(this).find("em").animate({opacity: "show", top: "-75"}, "slow");
                var hoverText = $(this).attr("title");
                $(this).find("em").text(hoverText);
            }, function() {
                $(this).find("em").animate({opacity: "hide", top: "-85"}, "fast");
            });
        });
    </script> 

    <style type="text/css">
        body {
            margin: 10px auto;
            width: 700px; <%-- default: 570px --%>
            font: 80%/120% Arial, Helvetica, sans-serif;
        }
        .menu2 {
            margin: 100px 0 0;
            padding: 0;
            list-style: none;
        }
        .menu2 li {
            padding: 0;
            margin: 0 2px;
            float: left;
            position: relative;
            text-align: center;
        }
        .menu2 a {
            padding: 14px 10px;
            display: block;
            color: #000000;
            width: 144px;
            text-decoration: none;
            font-weight: bold;
            background: url(images/button.gif) no-repeat center center;
        }
        .menu2 li em {
            font-weight: normal;
            background: url(images/hover.png) no-repeat;
            width: 180px;
            height: 45px;
            position: absolute;
            top: -85px;
            left: -15px;
            text-align: center;
            padding: 20px 12px 10px;
            font-style: normal;
            z-index: 2;
            display: none;
        }
    </style>
</head>

<body>
    <!-- <a href="http://www.microsoft.com/en/sg/default.aspx" title="Microsoft Singapore"><p align="center" /><img src="images/microsoft.png" align="center" border="0"/></a> -->

    <h1><p align="center" /><a style="text-decoration:none" href="http://projectnimbus.org/" title="Project Nimbus"><font color="#FFA500">Project Nimbus</font></a> - Demo Application</h1>
    <ul class="menu2">
        <li>
            <a href="TCSFilter.jsp" title="Location of Traffic Conditions in Singapore">Traffic Service</a>
        </li>
        <li>
            <a href="CISTrafficServlet" title="Location of Traffic Cameras in Singapore">Camera Service</a>
        </li>
        <li>
            <a href="ISTrafficServlet" title="Location of Traffic Incidents in Singapore">Incident Service</a>
        </li>
        <li>
            <a href="gmapselect.jsp" title="Google Map Service">Map Service</a>
        </li>
    </ul>
    <p align="center" style="position: absolute; bottom: 0; left: 0; width: 100%; text-align: center;" /><a rel="license" href="http://creativecommons.org/licenses/by/3.0/sg/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by/3.0/sg/88x31.png" /></a>
    <a href="http://sg.linkedin.com/in/kennetham"><img src="http://www.linkedin.com/img/webpromo/btn_myprofile_160x33.png" width="160" height="33" border="0" alt="View Kenneth Ham's profile on LinkedIn">
    </a><br /><span xmlns:dc="http://purl.org/dc/elements/1.1/" href="http://purl.org/dc/dcmitype/InteractiveResource" property="dc:title" rel="dc:type">Project Nimbus, LTA Demo Application</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://bit.ly/nimbuslta" property="cc:attributionName" rel="cc:attributionURL">Kenneth Ham Gao Jie</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/3.0/sg/">Creative Commons Attribution 3.0 Singapore License</a>.<br />Based on <a xmlns:dc="http://purl.org/dc/elements/1.1/" href="http://projectnimbus.org/" rel="dc:source">Project Nimbus</a>.
</body>
</html>
