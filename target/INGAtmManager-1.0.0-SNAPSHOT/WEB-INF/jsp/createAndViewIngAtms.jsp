<div class="ing_createingatm">
<div class="ing_createingatm_form">	

<input type="hidden" id="ing_parent_city_hidden"></input>
	<form class="ing_city_form atmcontent">
	<div class="form-group row">
				<div class="col-sm-2">
						<label for="ing_parent_city" id="ing_parent_city_label">Enter City :</label>
					</div>
					<div class="col-sm-4">
						<input type="text" class="form-control fields" id="ing_parent_city">
					</div>
				</div>
			<button type="button" class="btn btn-primary atmcontent ing_addatm_button" id="ing_addatm_button">Add ATM Details</button>	
	</form>
	
		</div>
		
		<div class="atmcontent container ingviewatm_content hidden">
		<div class="row ing_city_inputlabel">
				<div class="col-sm-2">
						<label> City: </label>
					</div>
					<div class="col-sm-2">
						<strong id="ing_parent_city_text"></strong>
					</div>
				</div>
		<jsp:include
			page="/WEB-INF/jsp/cityAtmsDisplay.jsp" />
			<button type="button" class="btn btn-primary pull-left" id="ing_atmlist_addmore">Add More ATM Details</button>	
	    </div>
	    
	    	<div class="container ">
			<form class="ing_atmlist_form atmcontent hidden">
				<div class="form-group row">
				<div class="col-sm-2">
						<label class="control-label" for="ing_atmlist_street">Street:</label>
					</div>
					<div class="col-sm-4">
						<input type="text" class="form-control fields" id="ing_atmlist_street">
					</div>
				</div>
					<div class="form-group row">
				<div class="col-sm-2">
						<label class="control-label" for="ing_atmlist_housenum">House Number:</label>
					</div>
					<div class="col-sm-4">
						<input type="text" class="form-control fields" id="ing_atmlist_housenum">
					</div>
				</div>
					<div class="form-group row">
				<div class="col-sm-2">
						<label class="control-label" for="ing_atmlist_postalCde">Postal Code:</label>
					</div>
					<div class="col-sm-4">
						<input type="text" class="form-control fields" id="ing_atmlist_postalCde">
					</div>
				</div>
					<div class="form-group row">
				<div class="col-sm-2">
						<label class="control-label" for="ing_atmlist_city" >City</label>
					</div>
					<div class="col-sm-4">
						<input type="text" class="form-control fields" id="ing_atmlist_city" disabled>
					</div>
				</div>
				<div class="form-group row">
				<div class="col-sm-2">
						<label class="control-label" for="ing_atmlist_latitude">Latitude:</label>
					</div>
					<div class="col-sm-4">
						<input type="text" placeholder="Numbers Only" class="form-control fields" id="ing_atmlist_latitude">
					</div>
				</div>
					<div class="form-group row">
				<div class="col-sm-2">
						<label class="control-label" for="ing_atmlist_longitude">Longitude:</label>
					</div>
					<div class="col-sm-4">
						<input type="text" placeholder="Numbers Only" class="form-control fields" id="ing_atmlist_longitude">
					</div>
				</div>
				<div class="ing_createingatm_form_buttons">
				<button type="button" class="btn btn-primary" id="ing_atmlist_save">Save</button>	
			</div>
			</form>

		</div>

	</div>