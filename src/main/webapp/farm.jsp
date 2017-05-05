<div>

    <div class="container" style="overflow-y:scroll;" ng-if="showForm !== true">
        <table  class="farms table table-bordered">
            <thead>
            <tr>
                <th>Farm Id</th>
                <th>Farm Name</th>
                <th>Company</th>
                <th>&nbsp</th>
            </tr>
            </thead>
            <tbody>
            <tr  ng-repeat="farm in farms | filter:query | orderBy:orderProp">
                <td>{{farm.id}}</td>
                <td>{{farm.farmName}}</td>
                <td>{{farm.company.companyName}}</td>
                <td>
                    <div class="radio">
                        <label>
                            <input data-ng-model="farm.selected" value="false" type="radio" ng-click="btnClick(farm) "name="optradio" >
                        </label>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

        <!--conformation form starts here-->
    <div class="container col-xs-4" ng-if="showForm === true">
        <h1>Conformation Form</h1>
        <form>
            <div class="form-group">
                <label for="farmName">Farm Name</label>
                <!--<input type="hidden" id="farmId" placeholder="farmName" ng-model="farmData.id">-->
                <input type="text" id="farmName" class="form-control"  placeholder="farmName" ng-model="farmData.farmName">
            </div>


            <div class="form-group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    {{ farmData.company.companyName || 'Select Company' }} <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li ng-repeat="company  in companys"><a ng-click="farmData.company = company">{{company.companyName}}</a></li>
                </ul>
            </div>

            <div  ng-if="showForm == true" class="align-center" >
                <button type="submit" class="btn btn-primary" ng-click="save()">Save</button>
            </div>
        </form>
    </div>
    <br>
    <div  ng-if="showForm !== true">
        <button type="submit" class="btn btn-primary" ng-click="addfarm()">Add farm</button>
        <button type="submit" class="btn btn-primary" ng-click="editfarm()">Edit</button>
        <button type="submit" class="btn btn-primary" ng-click="deletefarm()">Delete</button>

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
    .align-center{
        margin-top: 10em;
        margin-left: 35em;
    }

</style>