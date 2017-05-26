<div>
    <div class="content-view" style="overflow-y:scroll;" ng-if="showForm !== true">
        <table  class="animals table table-bordered">
            <thead>
            <tr>
                <th>Animal Name</th>
                <th>Animal Initial Price</th>
                <th>Animal Birth Date</th>
                <th>Animal Birth Weight</th>
                <th>Animal Farm</th>
                <th>Animal Tag</th>
                <th>Initial Purchase</th>
                <th>&nbsp</th>
            </tr>
            </thead>
            <tbody>
            <tr  ng-repeat="animal in animals | filter:query | orderBy:orderProp">
                <td>{{animal.animalName}}</td>
                <td>{{animal.animalInitialPrice}}</td>
                <td>{{animal.birthDate}}</td>
                <td>{{animal.birthWeight}}</td>
                <td>{{animal.farm.farmName}}</td>
                <td>{{animal.tag.tagName}}</td>
                <td>{{animal.initialPurchase.purchaseDate}}</td>
                <td>
                    <div class="radio">
                        <label>
                            <input data-ng-model="animal.selected" value="false" type="radio" ng-click="btnClick(animal) "name="optradio" >
                        </label>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <!--Conformation form Starts Here-->
    <div class="container col-xs-4 content-view" ng-if="showForm === true">
        <form name="myForm" ng-submit="save(myForm.$valid)">
            <div class="st">
            <h2>Conformation Form</h2>
            <div class="form-group">
            <div>
                <label for="animalName">Animal Name</label>
                <input type="hidden" id="animalId"  placeholder="animalName" ng-model="animalData.id">
                <input type="text" id="animalName" class="form-control" maxlength="10" ng-keypress="ValidateAlpha($event)" placeholder="animalName" ng-model="animalData.animalName" required>
            </div>
            <div class="form-group">
                <label for="initialPrice">Animal Initila Price</label>
                <input type="text" id="initialPrice" class="form-control" ng-keypress="isNumber($event)" maxlength="10" placeholder="initialPrice" ng-model="animalData.animalInitialPrice"  required>
            </div>
            <div class="form-group">
                <label for="birthDate">Animal Birth Date</label>
                <input type="date" id="birthDate" class="form-control" placeholder="birthDate" ng-model="animalData.birthDate" required>
            </div>
            <div class="form-group ">
                <label for="birthWeight">Animal Birth Weight</label>
                <input type="text" id="birthWeight" class="form-control" ng-keypress="isNumber($event)" maxlength="10" placeholder="birthWeight" ng-model="animalData.birthWeight" required >
            </div>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" required>
                    {{ animalData.farm.farmName || 'Select Farm' }} <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li ng-repeat="farm   in farms"><a ng-click="animalData.farm = farm">{{farm.farmName}}</a></li>
                </ul>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" required>
                    {{ animalData.tag.tagName || 'Select Tag' }} <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li ng-repeat="tag  in tags"><a ng-click="animalData.tag = tag">{{tag.tagName}}</a></li>
                </ul>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" required>
                    {{ animalData.initialPurchase.purchaseDate || 'Select Purchase Date' }} <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li ng-repeat="purchase  in purchases"><a ng-click="animalData.initialPurchase = purchase">{{purchase.purchaseDate}}</a></li>
                </ul>
            </div>
            </div>
            <div  ng-if="showForm == true">
                <button type="submit" ng-disabled="myForm.$invalid" class="btn btn-primary">Save</button>
            </div>
        </form>
    </div>
    <br>
    <div  ng-if="showForm !== true">
        <button type="submit" class="btn btn-primary" ng-click="addanimal()">Add Animal</button>
        <button type="submit" class="btn btn-primary" ng-click="editanimal()">Edit</button>
        <button type="submit" class="btn btn-primary" ng-click="deleteanimal()">Delete</button>

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