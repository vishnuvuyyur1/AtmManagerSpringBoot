var ingatmmanager = ingatmmanager ||{};

ingatmmanager.navigator = {
		
		navigate : function(){
			ingatmmanager.navigator.performNavigation();
		},

        performNavigation:function(){
        	
        	$('.ing_mainpage_nav_secondtab').click(function(){
        		ingatmmanager.createIngAtms.navigate();
        		
        	});
        	
        	$('.ing_mainpage_nav_firsttab').click(function(){
        		
        		$('.ing_createingatm_content').addClass('hidden');
        		$('.ing_atmsList_content').addClass('hidden');
        		$('.ing_welcome_content').removeClass('hidden');
        	});
        	
        	$("#ing_welcome_viewatms_button").click(function(){
        		$('.ing_createingatm_content').addClass('hidden');
        		$('.ing_welcome_content').addClass('hidden');
        		$('.ing_atmsList_content').removeClass('hidden');
			});
        }
}