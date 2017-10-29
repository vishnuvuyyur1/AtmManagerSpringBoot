var ingatmmanager = ingatmmanager ||{};

ingatmmanager.createIngAtms ={
		
		pageActions : function(){
			
			ingatmmanager.createIngAtms.performButtonActions();
		},
		
		performButtonActions:function(){
			
			$(".ing_addatm_button").click(function(){
				ingatmmanager.createIngAtms.hideAllSections();
				$('.ing_city_form').removeClass('hidden');
				$(".ing_atmlist_form").removeClass('hidden');
			});
			
			$("#ing_parent_city").on("change paste keyup", function() {
				$('.ing_mainpage_content #ing_atmlist_city').val($('#ing_parent_city').val());
			});
			
			$('#ing_atmlist_addmore').click(function(){
				ingatmmanager.createIngAtms.hideAllSections();
				$(".ing_atmlist_form").removeClass('hidden');
				$('.ingviewatm_content').removeClass('hidden');
				$('.ing_mainpage_content .ing_atmlist_form').trigger('reset');
				$('.ing_mainpage_content #ing_atmlist_city').val($('#ing_parent_city_hidden').val());
			});
			
			$('#ing_atmlist_save').click(function(){
				ingatmmanager.createIngAtms.hideAllSections();
				var addressList=[];
				var address=ingatmmanager.createIngAtms.getAtmDetails();
				var atmDetailsForCity= new Object();
				atmDetailsForCity.city=$('#ing_parent_city').val();
				$('#ing_parent_city_hidden').val($('#ing_parent_city').val());
				addressList.push(address);
				atmDetailsForCity.address=addressList;
				ingatmmanager.createIngAtms.saveAtmDetailsForCity(atmDetailsForCity);
				$('.ing_mainpage_content .ing_atmlist_form').trigger('reset');
				
			});
		},
		
			
		
		getAtmDetails:function(){
			var address= new Object();
			var geoLocation = new Object();
			address.street=$('#ing_atmlist_street').val();
			address.housenumber=$('#ing_atmlist_housenum').val();
			address.postalcode=$('#ing_atmlist_postalCde').val();
			address.city=$('#ing_atmlist_city').val();
			geoLocation.lat=$('#ing_atmlist_latitude').val();
			geoLocation.lng=$('#ing_atmlist_longitude').val();
			address.geoLocation=geoLocation;
			return address;
		},
		
		saveAtmDetailsForCity : function(atmDetailsForCity){
			var json=JSON.stringify(atmDetailsForCity);
			var servUrl=window.location.protocol+"//"+window.location.host+"/ingatmmanager/api/createAtmDetailForCity";
			$.ajax({
				url :servUrl,
				headers: { 
			        'Accept': 'application/json',
			        'Content-Type': 'application/json' 
			    },
				type : "POST",
				dataType : "json",
				data : JSON.stringify(atmDetailsForCity),
				success : function (data){
					ingatmmanager.createIngAtms.showAtmDetailsForCity(data)
				},
			error :function(jqXHR, textStatus) {
				  alert( "Service Request failed: " + textStatus );
			}
			});
		},
		
		showAtmDetailsForCity : function(atmDetailsForCity){
			$('#ing_parent_city_text').text(atmDetailsForCity.city)
			
			var trHTML = '';
            $.each(atmDetailsForCity.address, function (i,atmData) {
            
            	 trHTML += '<tr><td>' 
            		    + atmData.street 
            		    + '</td><td>' 
            		    + atmData.housenumber 
            		    + '</td><td>' 
            		    + atmData.postalcode
            		    + '</td><td>'
            		    + atmData.city
            		    + '</td><td>'
            		    + atmData.geoLocation.lat
            		    + '</td><td>'
            		    + atmData.geoLocation.lng
            		    + '</td></tr>';
            	       
                        
            });
            $('.ingviewatm_content #ing_cityatms_tabel_body').append(trHTML);
            $('.ingviewatm_content').removeClass('hidden');
		},
		
		resetForm:function(){
			$('.ing_mainpage_content .ing_atmlist_form').trigger('reset');
			$('.ing_mainpage_content .ing_city_form').trigger('reset');
		},
		
		navigate: function(){
			ingatmmanager.createIngAtms.hideAllSections();
			ingatmmanager.createIngAtms.cleanAndHideTabel();
			$('.ing_mainpage_content .ing_createingatm_content').removeClass('hidden');
    		$('.ing_welcome_content').addClass('hidden');
    		$('.ing_atmsList_content').addClass('hidden');
    		$('.ing_city_form').removeClass('hidden');
    		$('#ing_addatm_button').removeClass('hidden');
    		ingatmmanager.createIngAtms.resetForm();
		},
		
		hideAllSections : function(){
			$('.atmcontent').addClass('hidden');
		},
		
		cleanAndHideTabel : function(){
			$('#ing_cityatms_tabel tr').slice(1).remove()
		}
}







