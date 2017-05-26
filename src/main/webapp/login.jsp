<!DOCTYPE html>
<html ng-app="myApp">
<style>
    /*form {
        border: 3px solid goldenrod;
        background:goldenrod;
        margin: auto;
    }*/
    .st{
        margin: auto;
        width:20%;
        background-color: lightslategray;
        padding:2em;
        border-radius: 5px;
        height: 100%;


    }
    input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    }

    button {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    width: 100%;
    height:35px;
    }


    button:hover {
    opacity: 0.8;
    }

    .cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
    }

    .imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
    }

    img.avatar {
    width: 40%;
    border-radius: 50%;
    }
    .img-circle{

    border-radius:100%;
    width:200px;
    height:200px;
    margin: auto;
    position:20px;
    opacity:2.0;
    }

   /* .container {
    width:50%;
    margin:auto;
    padding: 1em;
    }*/

    span.psw {
    float: right;
    padding: 15px;
    }

    /* Change styles for span and cancel button on extra small screens */
    @media screen and (max-width: 300px) {
        span.psw {
            display: block;
            float: none;
        }

        .cancelbtn {
            width: 50%;
        }

    }
</style>
<!--Login Form Begins Here-->
<body>

    <form ng-controller="loginCtrl">
        <div class="st">
            <div role="alert" ng-show="createFailed" style="color:red">
                "invalid user name or password"
            </div>
            <div class="imgcontainer">
            <img src="resources/web-images/testimonios.png" alt="Avatar" class="img-circle">
            </div>

            <div class="container">
            <label><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="uname" ng-model="userData.username" required>

            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required ng-model="userData.password">

            <button type="button" class="btn btn-success" ng-click="login()">Login</button>
            <input type="checkbox" checked="checked"> Remember me
            </div>

            <div class="container">
            <button type="button" class="cancelbtn">Cancel</button>
            <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </div>

    </form>
    <script src="resources/js/jquery/dist/jquery.js"> </script>
    <script src="resources/js/myJs/angular.min.js" data-semver="1.4.9"></script>
    <script src="resources/js/myJs/angular-route.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script src="resources/app/app.js"></script>
    <script src="resources/app/loginCtrl.js"></script>
</body>
</html>
