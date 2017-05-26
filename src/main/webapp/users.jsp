<div>

    <div class="content-view"style="overflow-x:scroll;" ng-if="showForm !== true">
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
    <div class="container col-xs-4 " ng-if="showForm === true">
        <form class="st" name="myForm" ng-submi="save(myFrom.$valid)">
            <h2>Conformation Form</h2>
            <div class="form-group">
                <label for="UserName">User Name</label>
                <input type="hidden" id="userId" placeholder="UserName" ng-model="userData.id">
                <input type="text" id="UserName" class="form-control" maxlength="10" ng-keypress="ValidateAlpha($event)" placeholder="UserName" ng-model="userData.username" required>
            </div>

            <div class="form-group">
                <label for="Password">User Paasword</label>
                <input type="password" id="Password" class="form-control" ng-pattern="/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/" placeholder="Password" ng-model="userData.password">
            </div>

            <div class="form-group">
                <label for="Name">Name</label>
                <input type="text" id="Name" class="form-control" ng-keypress="ValidateAlpha($event)"  placeholder="Name" ng-model="userData.name" required>
            </div>

            <div class="form-group ">
                <label for="Email">User Email</label>
                <input type="email" id="Email" class="form-control"  placeholder="Email" ng-model="userData.email" required>
            </div>
            <div  ng-if="showForm == true">
                <button type="submit" class="btn btn-primary" ng-disabled="myForm.$invalid" ng-click="save()">Save</button>
            </div>
        </form>
    </div>
    <br>
    <div  ng-if="showForm !== true">
        <button type="submit" class="btn btn-primary" ng-click="addUser()">Add User</button>
        <button type="submit" class="btn btn-primary" ng-click="editUser()">Edit</button>
        <button type="submit" class="btn btn-primary" ng-click="deleteUser()">Delete</button>

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