<div>

    <div class="container" style="overflow-x:scroll;" ng-if="showForm !== true">
        <table  class="purchaseTypes table table-bordered">
            <thead>
            <tr>
                <th>Purchase Type</th>
                <th>&nbsp</th>
            </tr>
            </thead>
            <tbody>
            <tr  ng-repeat="purchaseType in purchaseTypes | filter:query | orderBy:orderProp">
                <td>{{purchaseType.purchaseType}}</td>
                <td>
                    <div class="radio">
                        <label>
                            <input data-ng-model="purchaseType.selected" value="false" type="radio" ng-click="btnClick(purchaseType) "name="optradio" >
                        </label>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
        
    </div>
    <!--conformation fARNM sTARTS hERE-->


    <div class="container col-xs-4" ng-if="showForm === true">
        <h1>Conformation Form</h1>
        <form>
            <div class="form-group">
                <label for="purchaseType">Purchase Type</label>
                <input type="hidden" id="purchaseTypeId" placeholder="purchaseType" ng-model="purchaseTypeData.id">
                <input type="text" id="purchaseType" class="form-control"  placeholder="purchaseType" ng-model="purchaseTypeData.purchaseType">
            </div>
            <div  ng-if="showForm == true">
                <button type="submit" class="btn btn-primary" ng-click="save()">Save</button>
            </div>
        </form>
    </div>
    <br>
    <div  ng-if="showForm !== true">
        <button type="submit" class="btn btn-primary" ng-click="addpurchaseType()">Add PurchaseType</button>
        <button type="submit" class="btn btn-primary" ng-click="editpurchaseType()">Edit</button>
        <button type="submit" class="btn btn-primary" ng-click="deletepurchaseType()">Delete</button>

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