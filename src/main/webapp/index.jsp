<!DOCTYPE html>
<html ng-app="myApp">

<head>
   <script>document.write('<base href="' + document.location + '" />');</script>
    <script src="resources/js/jquery/dist/jquery.js"> </script>
    <script src="resources/js/myJs/angular.min.js" data-semver="1.4.9"></script>
    <script src="resources/js/myJs/angular-route.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src="resources/app/app.js"></script>
    <script src="resources/app/app.route.js"></script>
    <script src="resources/app/UserListCtrl.js"></script>
    <script src="resources/app/MainCtrl.js"></script>
    <script src="resources/app/CustomerCtrl.js"></script>
    <script src="resources/app/companyCtrl.js"></script>
    <script src="resources/app/farmCtrl.js"></script>
    <script src="resources/app/productCtrl.js"></script>
    <script src="resources/app/purchaseTypeCtrl.js"></script>




</head>
    <!--width="100%" border="1"style="border-collapse: collapse"

<body>
   <!-- <div>
        <h1><center>Vroozi Labs</center></h1>
    </div>-

<div class="container-fluid text-center" >
   <div class="row">
      <div class="col-sm-12" style="background-color: #777777;height:100px" >
       <h1>Vroozi Labs</h1>
      </div>
   </div>
   <div class="row">
     <div class="col-xs-1">
      <ul class="nav nav-pills nav-stacked">
       <li class="active"><a href="#/main">Home</a></li>
       <li><a href="#/users">Users</a></li>
       <li><a href="#/customer">Customers</a></li>
      </ul>
     </div>
   <div class="col-sm-11" ng-view></div>
   </div>
</div>

</body>
    -->

   <!-- <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-3.2.1.js"> </script>
        <script src="js/bootstrap.js"> </script>
-->
        <style>
            .container{
                width:100%;
            }
            .body-content{
                margin-left:14em;
                margin-top:1.5em;
                width:85%;
                transition: margin-left 0.4s linear;
                -moz-transition: margin-left 0.4s linear;
                -webkit-transition: margin-left 0.4s linear;

            }
            header{
                padding: 0.7em;
                background-color:gray;
                color: white;
                font-size:large;
            }
            header a{
                background-color:gray;
                color:white;
                text-decoration: none;
            }
            header a:hover{
                text-decoration: none;
            }
            .my-nav-wrapper{
                position:absolute;
                top:4.2em;
                left:0em;
                height:100%;
                width:13em;
                background-color:black;
                transition:left 0.4s linear;
                -moz-transition:left 0.4s linear;
                -webkit-transition:left 0.4s linear;
            }
            .my-nav-wrapper ul{
                width:11em;
                list-style:none;
                margin-left:2em;
                margin-right:1em;
                padding:0em;
            }.my-nav-wrapper ul li{
                 margin-top:1em;
                 margin-bottom:0.5em;

             }
            .my-nav-wrapper ul li a{
                color:#999999;
                text-decoration: none;
                padding:0.5em;
            }
            .my-nav-wrapper ul li a:hover{
                text-decoration: none;
                color:#fff;
            }
            .my-nav-wrapper ul li a:active,
            .my-nav-wrapper ul li a:focus{
                text-decoration:none;
                color:red;
                outline:none;
            }
            .my-nav-wrapper ul .my-nav-brand{
                margin-left:-0.5em;
                font-size:large;
                color:white;
            }
            .my-nav-wrapper ul .my-nav-brand a{
                color:white;
            }
            .my-nav-wrapper ul .my-nav-brand a:hover{
                color:light-blue;
                background:none;
            }
            .c1{background-image:url("resources/web-images/theRock.jpg");
            display-size:cover;
            }
            @media all and (max-width:768px){
                .my-nav-wrapper{
                    left:-10em;
                }
                .body-content{
                    margin-left:5em;
                }
                .my-nav-wrapper ul li a i{
                    margin-top:-1em;
                    margin-bottom:-1em;
                    padding-left: 9em;
                }


            }
            .my-nav-wrapper ul li a span{
                margin-top:-1em;
                margin-bottom:-1em;
                margin-left: 1em;
                margin-right:1em;
                padding-top: -1em;
                padding-bottom: -1em;
            }
            .my-nav-wrapper ul li ul{
                list-style: none;
                margin-left: 1em;
                margin-right: 1em;
            }



        </style>
    </head>
<body>
<div class="container">
    <div class="row">
        <header>
            <a href="index3.html">My Cattle Farm</a>
        </header>
        <nav class="my-nav-wrapper" id="sideNavParent">
            <ul>
                <li class="my-nav-brand">
                    <a href="index3.html" class="visible-sm visible-md visible-lg">Music</a>
                </li>
                <li>
                    <a href="#/main">
                        <span class="visible-sm visible-md visible-lg">Home</span>
                        <i class="glyphicon glyphicon-home visible-xs"></i>
                    </a>
                </li>
                <li>
                    <a href="#/users">
                        <span class="visible-sm visible-md visible-lg">Users</span>
                        <i class="glyphicon glyphicon-user visible-xs"></i>
                    </a>
                </li>
                <li>
                    <a href="#/customer">
                        <span class="visible-sm visible-md visible-lg">Customers</span>
                        <i class="glyphicon glyphicon-list-alt visible-xs"></i>
                    </a>
                </li>
                <li>
                    <a href="#/company">
                        <span class="visible-sm visible-md visible-lg">Company</span>
                        <i class="glyphicon glyphicon-music visible-xs"></i>
                    </a>
                </li>
                <li>
                    <a href="#/farm">
                        <span class="visible-sm visible-md visible-lg">Farms</span>
                        <i class="glyphicon glyphicon-download visible-xs"></i>
                    </a>
                </li>
                <li>
                    <a href="#/product">
                        <span class="visible-sm visible-md visible-lg">Products</span>
                        <i class="glyphicon glyphicon-download visible-xs"></i>
                    </a>
                </li>
                <li>
                    <a href="#/purchaseType">
                        <span class="visible-sm visible-md visible-lg">Purchase Type</span>
                        <i class="glyphicon glyphicon-download visible-xs"></i>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<div class="container body-content">
    <div class="row">
        <div class="col-xs-10 col-lg-12 ng-view">
            <h1>MY CATTLE FARM</h1>
            <p>This is where you get all of your "BULLZ"</p>

        </div>
    </div>

</div>

</body>
</html>
