

$(function() {
  
  $("#signed-in").show();
  
	var smirkIndex = 10;
	var offset = -139;
	
	function showSix() {
		if (Smirk.smirks) {				
			for (var i=0; i<6; i++) {	
				
				var indx = Math.floor(Math.random() * (Smirk.smirks.length-1))
				var s = Smirk.smirks[indx];
				var indx = i+1;
				var b = s.blerb.length > 1 ? s.blerb : "";
				
				var flashvarz = { blerb: b, iurl: s.uri, href: "/" + s.uname, loop: 1 };
				var params = {allowScriptAccess: "always", wmode: "transparent"};
				var attributes = { id: "smirk-" + indx, name: "smirk-" + indx, "class": "icon" };
					
				swfobject.embedSWF("/swf/smirk.swf", "smirk-" + indx, 120, 120, "9.0.0", "/swf/express_install.swf", flashvarz, params, attributes);
				
			}
		
		}
	
	}
	
	//$.getJSON("gimmie_latest_jax.php", function(d) {
	
	//	Smirk.smirks = d;
	//	showSix();			
	
	//});
	
	$("#btn-refresh").click(function() {
	
		//showSix();
	
	});
	
	
	if ($.cookie('is_lg')) //OR try to REMEMBER cookied users
	{
		
		// console.log("user is cookied");

		$("#im-new").hide();
		$("#smirk-login-form").hide();
		$("#signed-in").show();
		$("#accnt").empty().append($.cookie('is_lg'))
		$("#btn-create-mine").attr("href", $.cookie('is_lg'))
	  $("#tiny-nav").show();
	  
	}
	else
	{	
		
		// console.log("user isn't cookied");

		$("#im-new").show();
		$("#smirk-login-form").show();
		//$("#signed-in").hide();
		$("#tiny-nav").hide();
	}
	
	
	// wire up the my icons link:
	$("#my-icons").attr("href", "/"+$.cookie('is_lg'));
	

});
