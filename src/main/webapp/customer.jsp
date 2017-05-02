<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

    <style>
        body{background-color: rgb(255,150,50);}
        p.center.large.double {
            color:darkgreen;
            text-align: center;
            font-size: 200%;
            border:6px solid darkgreen;
            border-radius: 12px;
        }
        div.container {
            /*border: 1px solid red;*/
            margin-left: 100px;
        }
        table,tr,td{
            border: 1px single black;
        }
        #myTable{
            border-spacing:20px;
            -webkit-animation:mymove 5s infinite;
            animation:mymove 5s infinite;
        }
        @-webkit-keyframes mymove {
            50%{border-spacing: 20px;}
        }
        @keyframes mymove {
            50%{border-spacing:20px;}

        }
        th{vertical-align: middle;
        height: 50px;}
        tr:hover{background-color: #3e8f3e;}
        table{border-collapse: separate}
        span{display:flex;}


       /* p.large{font-size: 200%;}*/
    </style>
</head>
<body>
    <span>jkshdjsadhkjdhksadkahdkljahdkajdhksaljdhdjkadla</span>
    <h1>This Is  only  a Customer Page </h1>
    <p class="center large double">It is bieng used for css training</p>
    <i class="fa fa-cloud"></i>
    <i class="fa fa-heart"></i>
    <i class="fa fa-car"></i>
    <i class="fa fa-file"></i>
    <i class="fa fa-bars"></i>
    <br>
    <i class="glyphicon glyphicon-cloud"></i>
    <i class="glyphicon glyphicon-remove"></i>
    <i class="glyphicon glyphicon-user"></i>
    <i class="glyphicon glyphicon-envelope"></i>
    <i class="glyphicon glyphicon-thumbs-up"></i>
    <br>
    <i class="material-icons">cloud</i>
    <i class="material-icons">favorite</i>
    <i class="material-icons">attachment</i>
    <i class="material-icons">computer</i>
    <i class="material-icons">traffic</i>
    <table id="myTable">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <tr>
            <td>Abdul</td>
            <td>Majid</td>
        </tr>
        <tr>
            <td>Abdul</td>
            <td>Aziz</td>
        </tr>
    </table>

</body>
</html>


