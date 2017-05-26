<div>
    <div class="content-view"style="overflow-x:scroll;" ng-if="showForm !== true">
        <table  class="animalPrices table table-bordered">
            <thead>
            <tr>
                <th>Animal Price</th>
                <th>Animal Version</th>
                <th>Animal</th>
                <th>&nbsp</th>
            </tr>
            </thead>
            <tbody>
            <tr  ng-repeat="animalPrice in animalPrices | filter:query | orderBy:orderProp">
                <td>{{animalPrice.price}}</td>
                <td>{{animalPrice.version}}</td>
                <td>{{animalPrice.animal.animalName}}</td>
                <td>
                    <div class="radio">
                        <label>
                            <input data-ng-model="animalPrice.selected" value="false" type="radio" ng-click="btnClick(animalPrice) "name="optradio" >
                        </label>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

<!--COnformation Form Starts Here-->
    <div class="container col-xs-4" ng-if="showForm === true">
        <form class="st">
            <h2>Conformation Form</h2>
            <div class="form-group">
                <label for="animalPrice">Animal Price</label>
                <input type="hidden" id="animalPriceId" placeholder="animalPriceName" ng-model="animalPriceData.id">
                <input type="text" id="animalPrice" class="form-control"  placeholder="animalPrice" ng-model="animalPriceData.price">
            </div>
            <div class="form-group">
                <label for="Version">Animal Version</label>
                <input type="text" id="Version" class="form-control"  placeholder="Version" ng-model="animalPriceData.version">
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    {{ animalPriceData.animal.animalName || 'Select Animal' }} <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li ng-repeat="animal in animals"><a ng-click=" animalPriceData.animal = animal">{{animal.animalName}}</a></li>
                </ul>
            </div>
            <div  ng-if="showForm == true">
                <button type="submit" class="btn btn-primary" ng-click="save()">Save</button>
            </div>
        </form>
    </div>
    <br>
    <div  ng-if="showForm !== true">
        <button type="submit" class="btn btn-primary" ng-click="addanimalPrice()">Add animalPrice</button>
        <button type="submit" class="btn btn-primary" ng-click="editanimalPrice()">Edit</button>
        <button type="submit" class="btn btn-primary" ng-click="deleteanimalPrice()">Delete</button>

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