<%-- 
    Document   : TCSFilter
    Created on : 2010/03/13, 11:46:33
    Author     : kenneth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project Nimbus - LTA Traffic Service</title><script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js" type="text/javascript"></script>
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
                            border:1px solid #d4ca9a; width:200px;}
            .dropdown dt a span {cursor:pointer; display:block; padding:5px;}
            .dropdown dd ul { background:#e4dfcb none repeat scroll 0 0; border:1px solid #d4ca9a; color:#C5C0B0; display:none;
                              left:0px; padding:5px 0px; position:absolute; top:2px; width:auto; min-width:200px; list-style:none;}
            .dropdown span.value { display:none;}
            .dropdown dd ul li a { padding:5px; display:block;}
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
    <body>
        <dl id="location" class="dropdown">
            <dt><a href="#"><span>-- Please select a Category --</span></a></dt>
            <dd>
                <ul>
                    <li><a href="index.jsp">Home<span class="value">Home</span></a></li>
                    <li><a href="gmapselect.jsp">Go Back (Map Service)<span class="value">Map Service</span></a></li>
                    <li><a href="#"><span class="value"></span></a></li>
                    <li><a href="CategoryA">Category A<span class="value">Category A</span></a></li>
                    <li><a href="CategoryB">Category B<span class="value">Category B</span></a></li>
                    <li><a href="CategoryC">Category C<span class="value">Category C</span></a></li>
                </ul>
            </dd>
        </dl>
        <span id="result"></span>
        <p align="center" style="position: absolute; bottom: 0; left: 0; width: 100%; text-align: center;" /><a rel="license" href="http://creativecommons.org/licenses/by/3.0/sg/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by/3.0/sg/88x31.png" /></a>
        <a href="http://sg.linkedin.com/in/kennetham"><img src="http://www.linkedin.com/img/webpromo/btn_myprofile_160x33.png" width="160" height="33" border="0" alt="View Kenneth Ham's profile on LinkedIn">
        </a><br /><span xmlns:dc="http://purl.org/dc/elements/1.1/" href="http://purl.org/dc/dcmitype/InteractiveResource" property="dc:title" rel="dc:type">Project Nimbus, LTA Demo Application</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://bit.ly/nimbuslta" property="cc:attributionName" rel="cc:attributionURL">Kenneth Ham Gao Jie</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/3.0/sg/">Creative Commons Attribution 3.0 Singapore License</a>.<br />Based on <a xmlns:dc="http://purl.org/dc/elements/1.1/" href="http://projectnimbus.org/" rel="dc:source">Project Nimbus</a>.
    </body>
</html>
