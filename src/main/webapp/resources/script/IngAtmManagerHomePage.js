$(document).ready(function(){
	ingatmmanager.navigator.navigate();
	ingatmmanager.createIngAtms.pageActions();
	ingatmmanager.ingAtmHome.pageActions();
});

var ingatmmanager = ingatmmanager ||{};

ingatmmanager.ingAtmHome ={
		
		pageActions : function(){
			ingatmmanager.ingAtmHome.getIngAtmDetails();
		},
		
		
		getIngAtmDetails:function(){
			var servUrl=window.location.protocol+"//"+window.location.host+"/ingatmmanager/api/getAllAtmDetails";
			$.ajax({
				url :servUrl,
				headers: { 
			        'Accept': 'application/json',
			        'Content-Type': 'application/json' 
			    },
				type : "GET",
				dataType : "json",
				success : function (data){
					ingatmmanager.ingAtmHome.formTheTabel(data);
				},
				error :function(jqXHR, textStatus) {
					  alert( "Service Request failed: " + textStatus );
			}
			});
		
		},
		
		formTheTabel : function(data){
			$(".ing_atmsList_content #ing_atms_tabel").dataTable( {
			       
				"aaData": data,
		        "aoColumns": [
		            { "mData": "address.street" },
		            { "mData": "address.housenumber" },
		            { "mData": "address.postalcode" },
		            { "mData": "address.city" },
		            { "mData": "type" },
		            { "mData": "address.geoLocation.lat" },
		            { "mData": "address.geoLocation.lng" },
		        ]
		    } );
		}
		
		
}