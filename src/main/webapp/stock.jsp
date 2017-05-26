<div>
    <div class="content-view"style="overflow-x:scroll;" ng-if="showForm !== true">
        <table  class="stocks table table-bordered">
            <thead>
            <tr>
                <th>Stock Qty In Hand</th>
                <th>Product</th>
                <th>&nbsp</th>
            </tr>
            </thead>
            <tbody>
            <tr  ng-repeat="stock in stocks | filter:query | orderBy:orderProp">
                <td>{{stock.qtyInHand}}</td>
                <td>{{stock.product.productName}}</td>
                <td>
                    <div class="radio">
                        <label>
                            <input data-ng-model="stock.selected" value="false" type="radio" ng-click="btnClick(stock) "name="optradio" >
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
                <label for="qtyInHand">Qty In Hand</label>
                <input type="hidden" id="stockId" placeholder="stockName" ng-model="stockData.id">
                <input type="text" id="qtyInHand" class="form-control" ng-keypress="isNumber($event)"  placeholder="qtyInHand" ng-model="stockData.qtyInHand" required>
            </div>

            <div class="form-group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    {{ stockData.product.productName || 'Select Product' }} <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li ng-repeat="product in products"><a ng-click="stockData.product = product">{{product.productName}}</a></li>
                </ul>
            </div>
            <div  ng-if="showForm == true">
                <button type="submit" class="btn btn-primary" ng-disabled="myForm.$invalid" ng-click="save()">Save</button>
            </div>
        </form>
    </div>
    <br>
    <div  ng-if="showForm !== true">
        <button type="submit" class="btn btn-primary" ng-click="addstock()">Add stock</button>
        <button type="submit" class="btn btn-primary" ng-click="editstock()">Edit</button>
        <button type="submit" class="btn btn-primary" ng-click="deletestock()">Delete</button>

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