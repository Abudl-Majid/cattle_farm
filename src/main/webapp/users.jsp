<div>
    <div class="container" style="overflow-x:scroll;">
        <table  class="users table table-bordered">
            <thead>
            <tr>
                <th>User Name</th>
                <th>Password</th>
                <th>Name</th>
                <th>User Email</th>
                <th>&nbsp</th>
            </tr>
            </thead>
            <tbody>
            <tr  ng-repeat="user in users | filter:query | orderBy:orderProp">
                <td>{{user.username}}</td>
                <td>{{user.password}}</td>
                <td>{{user.name}}</td>
                <td>{{user.email}}</td>
                <td>
                    <div class="radio">
                        <label>
                            <input data-ng-model="user.selected" value="false" type="radio" ng-click="btnClick(user) "name="optradio" >
                        </label>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
        <!--<form ng-click="onClickOption()" >
            User Name:<input type="text" ng-model="UserName"> <br />
            Password:<input type="text" ng-model="Password"><br />
            Name:<input type="text" ng-model="Name"><br />
            User Email:<input type="text" ng-model="Email"><br />
            <input type="submit" class="btn btn-success"></input>
        </form>
        -->
    </div>


    <div class="container col-xs-4" ng-if="showForm === true">
        <h1>Conformation Form</h1>
        <form>
            <div class="form-group">
                <label for="UserName">User Name</label>
                <input type="text" id="UserName" class="form-control"  placeholder="UserName" ng-model="userData.UserName">
            </div>

            <div class="form-group">
                <label for="Password">User Paasword</label>
                <input type="text" id="Password" class="form-control"  placeholder="Password" ng-model="userData.Password">
            </div>

            <div class="form-group">
                <label for="Name">Name</label>
                <input type="text" id="Name" class="form-control"  placeholder="Name" ng-model="userData.Name">
            </div>

            <div class="form-group ">
                <label for="Email">User Email</label>
                <input type="text" id="Email" class="form-control"  placeholder="Email" ng-model="userData.Email">
            </div>

            <button type="submit" class="btn btn-success" ng-click="onClickOption()">Submit</button>
            <button type="submit" class="btn btn-primary" ng-click="addUser()">Add User</button>
            <button type="submit" class="btn btn-success" ng-click="upDateUser()">Submit</button>
            <button type="submit" class="btn btn-info" ng-click="onClickOption()">Info</button>
            <button type="submit" class="btn btn-danger" ng-click="deleteUser()">Delete</button>

        </form>
    </div>
    <br>
    <div  ng-if="showForm !== true">
        <button type="submit" class="btn btn-primary" ng-click="editUser()">Edit</button>
    </div>
</div>
<style>
    div.xyz *{
        margin:100px;
    }
    th{
        text-align:center;
        height:50px;
        background-color:seagreen;
        color: whitesmoke;
    }
    tr:hover{background-color: lightgray}

</style>