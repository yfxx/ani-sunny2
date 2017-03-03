<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="zh-CN" ng-app="sunny">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>
        <fmt:bundle basename="messages/messages">
            <fmt:message key="system.index.title"/>
        </fmt:bundle>
    </title>

    <link rel="shortcut icon" type="image/icon"
          href="${pageContext.request.contextPath}/public/images/logo/favicon.ico">

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/public/bower_components/bootstrap/dist/css/sunny_bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/public/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/public/bower_components/bootstrap-switch/dist/css/bootstrap3/bootstrap-switch.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/public/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/public/bower_components/material-design-iconic-font/dist/css/material-design-iconic-font.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/public/bower_components/ng-dialog/css/ngDialog.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/public/bower_components/ng-dialog/css/ngDialog-theme-default.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/public/bower_components/ng-dialog/css/ngDialog-theme-plain.min.css" rel="stylesheet">

    <!-- Sunny css -->
    <link href="${pageContext.request.contextPath}/public/src/css/app.min.css" rel="stylesheet">

    <!--websocket-->
    <script src="${pageContext.request.contextPath}/public/bower_components/sockjs/sockjs.min.js"></script>

    <!-- jquery -->
    <script src="${pageContext.request.contextPath}/public/bower_components/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/public/bower_components/jquery-md5/jquery.md5.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/public/bower_components/js-md5/src/md5.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/public/bower_components/jquery.cookie/jquery.cookie.js" type="text/javascript"></script>

    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/public/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/public/bower_components/bootstrap-switch/dist/js/bootstrap-switch.min.js"></script>

    <!-- angularjs -->
    <script src="${pageContext.request.contextPath}/public/bower_components/angular/angular.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/public/bower_components/angular-route/angular-route.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/public/bower_components/angular-cookies/angular-cookies.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/public/bower_components/angular-translate/angular-translate.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/public/bower_components/angular-ui-router/release/angular-ui-router.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/public/bower_components/angular-bootstrap/ui-bootstrap-tpls.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/public/bower_components/ng-dialog/js/ngDialog.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/public/bower_components/moment/min/moment-with-locales.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/public/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>


    <script src="${pageContext.request.contextPath}/public/src/js/app.min.js" type="text/javascript"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/public/lib/js/html5shiv.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/public/lib/js/respond.min.js" type="text/javascript"></script>
    <![endif]-->
</head>

<body class="layout-fixed"  ng-class="{'aside-collapsed':isAsideCollapsed}" ng-controller="MainCtrl">
    <div data-ui-view="" data-autoscroll="false" class="wrapper" >
    </div>
</body>
</html>

