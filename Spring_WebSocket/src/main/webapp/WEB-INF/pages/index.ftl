<!DOCTYPE html>
<html>
<head lang="zh">
    <meta charset="UTF-8">
    <title>WebSocket/SockJS示例</title>
    <style type="text/css">
        #connect-container {
            float: left;
            width: 400px
        }

        #connect-container div {
            padding: 5px;
        }

        #console-container {
            float:       left;
            margin-left: 15px;
            width:       400px;
        }

        #console {
            border:              1px solid #CCCCCC;
            border-right-color:  #999999;
            border-bottom-color: #999999;
            height:              170px;
            overflow-y:          scroll;
            padding:             5px;
            width:               100%;
        }

        #console p {
            padding: 0;
            margin:  0;
        }
    </style>
    <script src="/resources/js/jquery-1.10.2-min.js" type="text/javascript"></script>
    <script src="/resources/js/sockjs.min.js" type="text/javascript"></script>
</head>
<body>
<div id="msgContainer"></div>

<script type="text/javascript">
    $(document).ready(function () {
        var websocket;
        if ('WebSocket' in window) {
            websocket = new WebSocket("ws://localhost/webSocketServer");
        } else if ('MozWebSocket' in window) {
            websocket = new MozWebSocket("ws://localhost/webSocketServer");
        } else {
            websocket = new SockJS("http://localhost/sockjs/webSocketServer");
        }
        websocket.onopen = function (evnt) {
        };
        websocket.onmessage = function (evnt) {
            var msgContainer = $("#msgContainer");
            var html = msgContainer.html();
            html += "<div style='color: red;'>" + evnt.data + "</div>"
            msgContainer.html(html);
        };
        websocket.onerror = function (evnt) {
        };
        websocket.onclose = function (evnt) {
        }
    });
</script>
</body>
</html>