<div>

    <div class="content-view"style="overflow-x:scroll;" ng-if="showForm !== true">
        <table  class="purchaseDetails table table-bordered">
            <thead>
            <tr>
                <th>Purchase ID</th>
                <th>Purchase Date</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Animal</th>
                <th>Product</th>
                <th>Purchase Type</th>
                <th>&nbsp</th>
            </tr>
            </thead>
            <tbody>
            <tr  ng-repeat="purchaseDetail in purchaseDetails | filter:query | orderBy:orderProp">
                <td>{{purchaseDetail.purchase.id}}</td>
                <td>{{purchaseDetail.purchase.purchaseDate}}</td>
                <td>{{purchaseDetail.price}}</td>
                <td>{{purchaseDetail.quantity}}</td>
                <td>{{purchaseDetail.animal.animalName}}</td>
                <td>{{purchaseDetail.product.productName}}</td>
                <td>{{purchaseDetail.purchaseType.purchaseType}}</td>
                <td>
                    <div class="radio">
                        <label>
                            <input data-ng-model="purchaseDetail.selected" value="false" type="radio" ng-click="btnClick(purchaseDetail) "name="optradio" >
                        </label>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
<!--Conformation Form Starts Here-->

    <div class="container col-xs-4" ng-if="showForm === true">
        <form class="st">
            <h2>Conformation Form</h2>
            <div class="form-group">
                <div class="form-group">
                    <label for="purchaseDetail">Purchase Date</label>
                    <input type="hidden" id="purchaseId" placeholder="purchaseName" ng-model="purchaseDetailData.id">
                    <input type="date" id="purchaseDetail" class="form-control"  placeholder="purchaseDate" ng-model="purchaseDetailData.purchase">
                </div>
                <label for="price">Price</label>
                <input type="text" id="price" class="form-control"  placeholder="price" ng-model="purchaseDetailData.price">
            </div>

            <div class="form-group">
                <label for="quantity">Quantity</label>
                <input type="text" id="quantity" class="form-control"  placeholder="quantity" ng-model="purchaseDetailData.quantity">
            </div>

            <div class="form-group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    {{ purchaseDetailData.animal.animalName || 'Select Animal' }} <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li ng-repeat="animal  in animals"><a ng-click="purchaseDetailData.animal = animal">{{animal.animalName}}</a></li>
                </ul>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    {{ purchaseDetailData.purchase.purchaseDate|| 'Select Purchase' }} <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li ng-repeat="purchase  in purchases"><a ng-click="purchaseDetailData.purchase = purchase">{{purchase.purchaseDate}}</a></li>
                </ul>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    {{ purchaseDetailData.product.productName || 'Select Product' }} <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li ng-repeat="product  in products"><a ng-click="purchaseDetailData.product = product">{{product.productName}}</a></li>
                </ul>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    {{ purchaseDetailData.purchaseType.purchaseType || 'Select Purchase Type' }} <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li ng-repeat="purchaseType  in purchaseTypes"><a ng-click="purchaseDetailData.purchaseType = purchaseType">{{purchaseType.purchaseType}}</a></li>
                </ul>
            </div>
            <div  ng-if="showForm == true">
                <button type="submit" class="btn btn-primary" ng-click="save()">Save</button>
            </div>
        </form>
    </div>
    <br>
    <div  ng-if="showForm !== true">
        <button type="submit" class="btn btn-primary" ng-click="addpurchaseDetail()">Add purchaseDetail</button>
        <button type="submit" class="btn btn-primary" ng-click="editpurchaseDetail()">Edit</button>
        <button type="submit" class="btn btn-primary" ng-click="deletepurchaseDetail()">Delete</button>

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