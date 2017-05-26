<div>
    <div class="content-view" style="overflow-x:scroll;" ng-if="showForm !== true">
    <table  class="companys table table-bordered">
        <thead>
        <tr>
            <th>Company Name</th>
            <th>&nbsp</th>
        </tr>
        </thead>
        <tbody>
        <tr  ng-repeat="company in companys | filter:query | orderBy:orderProp">
            <td>{{company.companyName}}</td>
            <td>
                <div class="radio">
                    <label>
                        <input data-ng-model="company.selected" value="false" type="radio" ng-click="btnClick(company) "name="optradio" >
                    </label>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
    </div>
    <!--conformation form of company-->
    <div class="container col-xs-4" ng-if="showForm === true">
        <form class="st" name="myForm">
            <h2>Conformation Form</h2>
            <div class="form-group">
                <label for="CompanyName">Company Name</label>
                <input type="text" id="CompanyName" class="form-control" ng-keypress="ValidateAlpha($event)" placeholder="CompanyName" ng-model="companyData.companyName"required>
    </div>
            <div  ng-if="showForm == true">
                <button type="submit" class="btn btn-primary" ng-disabled="myForm.$invalid" ng-click="save()">Save</button>
            </div>
        </form>
    </div>
    <br>
    <div  ng-if="showForm !== true">
        <button type="submit" class="btn btn-primary" ng-click="addcompany()">Add Company</button>
        <button type="submit" class="btn btn-primary" ng-click="editcompany()">Edit</button>
        <button type="submit" class="btn btn-primary" ng-click="deletecompany()">Delete</button>

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

