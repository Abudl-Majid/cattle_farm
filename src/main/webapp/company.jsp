<div>
    <div class="container" style="overflow-x:scroll;" ng-if="showForm !== true">
    <table  class="companys table table-bordered">
        <thead>
        <tr>
            <th>Company Id</th>
            <th>Company Name</th>
            <th>&nbsp</th>
        </tr>
        </thead>
        <tbody>
        <tr  ng-repeat="company in companys | filter:query | orderBy:orderProp">
            <td>{{company.id}}</td>
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
        <h1>Conformation Form</h1>
        <form>
            <div class="form-group">
                <label for="CompanyId">Company Id</label>
               <!-- <input type="hidden" id="CompanyId" placeholder="companyName" ng-model="companyData.id">-->
                <input type="text" id="CompanyId" class="form-control"  placeholder="CompanyId" ng-model="companyData.id">
            </div>

            <div class="form-group">
                <label for="CompanyName">Company Name</label>
                <input type="text" id="CompanyName" class="form-control"  placeholder="Password" ng-model="companyData.companyName">
            </div>

            <div  ng-if="showForm == true">
                <button type="submit" class="btn btn-primary" ng-click="save()">Save</button>
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

