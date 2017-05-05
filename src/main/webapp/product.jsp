<div>

    <div class="container" style="overflow-x:scroll;" ng-if="showForm !== true">
        <table  class="products table table-bordered">
            <thead>
            <tr>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>&nbsp</th>
            </tr>
            </thead>
            <tbody>
            <tr  ng-repeat="product in products | filter:query | orderBy:orderProp">
                <td>{{product.productName}}</td>
                <td>{{product.productPrice}}</td>
                <td>
                    <div class="radio">
                        <label>
                            <input data-ng-model="product.selected" value="false" type="radio" ng-click="btnClick(product) "name="optradio" >
                        </label>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <!--CONFORMATION fORM sTARTS hERE-->

    <div class="container col-xs-4" ng-if="showForm === true">
        <h1>Conformation Form</h1>
        <form>
            <div class="form-group">
                <label for="productName">Product Name</label>
                <input type="hidden" id="productId" placeholder="productName" ng-model="productData.id">
                <input type="text" id="productName" class="form-control"  placeholder="productName" ng-model="productData.productName">
            </div>

            <div class="form-group">
                <label for="productPrice">Product Price</label>
                <input type="text" id="productPrice" class="form-control"  placeholder="productPrice" ng-model="productData.productPrice">
            </div>
            <div  ng-if="showForm == true">
                <button type="submit" class="btn btn-primary" ng-click="save()">Save</button>
            </div>
        </form>
    </div>
    <br>
    <div  ng-if="showForm !== true">
        <button type="submit" class="btn btn-primary" ng-click="addproduct()">Add product</button>
        <button type="submit" class="btn btn-primary" ng-click="editproduct()">Edit</button>
        <button type="submit" class="btn btn-primary" ng-click="deleteproduct()">Delete</button>

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