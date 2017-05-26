<div>
    <div class="content-view" style="overflow-x:scroll;" ng-if="showForm !== true">
        <table  class="feedUseds table table-bordered">
            <thead>
            <tr>
                <th>Quantity of Feed Used</th>
                <th>Animal</th>
                <th>&nbsp</th>
            </tr>
            </thead>
            <tbody>
            <tr  ng-repeat="feedUsed in feedUseds | filter:query | orderBy:orderProp">
                <td>{{feedUsed.quantity}}</td>
                <td>{{feedUsed.animal.animalName}}</td>
                <td>
                    <div class="radio">
                        <label>
                            <input data-ng-model="feedUsed.selected" value="false" type="radio" ng-click="btnClick(feedUsed) "name="optradio" >
                        </label>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
<!--Conformation Form Starts Here-->

    <div class="container col-xs-4" ng-if="showForm === true">
        <form class="st" name="myForm">
            <h2>Conformation Form</h2>
            <div class="form-group">
                <label for="quantityUSed">Quantity of Feed Used</label>
                <input type="hidden" id="feedUsedId" placeholder="feedUsedName" ng-model="feedUsedData.id">
                <input type="text" id="quantityUSed" class="form-control"ng-keypress="isNumber($event)"  placeholder="quantityUSed" ng-model="feedUsedData.quantity" required>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    {{ feedUsedData.animal.animalName || 'Select Animal' }} <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li ng-repeat="animal  in animals"><a ng-click="feedUsedData.animal = animal">{{animal.animalName}}</a></li>
                </ul>
            </div>
            <div  ng-if="showForm == true">
                <button type="submit" class="btn btn-primary" ng-disabled="myForm.$invalid"  ng-click="save()">Save</button>
            </div>
        </form>
    </div>
    <br>
    <div  ng-if="showForm !== true">
        <button type="submit" class="btn btn-primary" ng-click="addfeedUsed()">Add feedUsed</button>
        <button type="submit" class="btn btn-primary" ng-click="editfeedUsed()">Edit</button>
        <button type="submit" class="btn btn-primary" ng-click="deletefeedUsed()">Delete</button>

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