<div>

    <div class="content-view" style="overflow-x:scroll;" ng-if="showForm !== true">
        <table  class="purchases table table-bordered">
            <thead>
            <tr>
                <th>Purchase Date</th>
                <th>&nbsp</th>
            </tr>
            </thead>
            <tbody>
            <tr  ng-repeat="purchase in purchases | filter:query | orderBy:orderProp">
                <td>{{purchase.purchaseDate}}</td>
                <td>
                    <div class="radio">
                        <label>
                            <input data-ng-model="purchase.selected" value="false" type="radio" ng-click="btnClick(purchase) "name="optradio" >
                        </label>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>

    </div>

    <!--Conformation Form Starts Here-->
    <div class="container col-xs-4 " ng-if="showForm === true">
        <h2>Conformation Form</h2>
        <form class="st"name="myForm">
            <div class="form-group">
                <label for="purchaseDate">Purchase Date</label>
                <input type="hidden" id="purchaseId" placeholder="purchaseName" ng-model="purchaseData.id">
                <input type="date" id="purchaseDate" class="form-control"  placeholder="purchaseDte" ng-model="purchaseData.purchaseDate" required>
            </div>


            <div  ng-if="showForm == true">
                <button type="submit" class="btn btn-primary" ng-disabled="myForm.$invalid" ng-click="save()">Save</button>
            </div>
        </form>
    </div>
    <br>
    <div  ng-if="showForm !== true">
        <button type="submit" class="btn btn-primary" ng-click="addpurchase()">Add PurchaseDate</button>
        <button type="submit" class="btn btn-primary" ng-click="editpurchase()">Edit</button>
        <button type="submit" class="btn btn-primary" ng-click="deletepurchase()">Delete</button>

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