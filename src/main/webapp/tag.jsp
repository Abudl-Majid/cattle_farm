<div>
    <div class="content-view" style="overflow-x:scroll;" ng-if="showForm !== true">
        <table  class="tags table table-bordered">
            <thead>
            <tr>
                <th>Tag Name</th>
                <th>&nbsp</th>
            </tr>
            </thead>
            <tbody>
            <tr  ng-repeat="tag in tags | filter:query | orderBy:orderProp">
                <td>{{tag.tagName}}</td>
                <td>
                    <div class="radio">
                        <label>
                            <input data-ng-model="tag.selected" value="false" type="radio" ng-click="btnClick(tag) "name="optradio" >
                        </label>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
<!--conformation Form Starts Here-->

    <div class="container col-xs-4" ng-if="showForm === true">
        <form class="st" name="myForm" ng-submit="save()">
            <h2>Conformation Form</h2>
            <div class="form-group">
                <label for="tagName">Tag Name</label>
                <input type="hidden" id="tagId" placeholder="tagName" ng-model="tagData.id">
                <input type="text" id="tagName"name="tagName" class="form-control" ng-pattern="/^([a-zA-Z0-9_-]){3,5}$/" placeholder="tagName" ng-model="tagData.tagName" required>
            </div>
            <div  ng-if="showForm == true">
                <button type="submit" class="btn btn-primary" ng-disabled="myForm.$invalid">Save</button>
            </div>
        </form>
    </div>
    <br>
    <div  ng-if="showForm !== true">
        <button type="submit" class="btn btn-primary" ng-click="addtag()">Add tag</button>
        <button type="submit" class="btn btn-primary" ng-click="edittag()">Edit</button>
        <button type="submit" class="btn btn-primary" ng-click="deletetag()">Delete</button>
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