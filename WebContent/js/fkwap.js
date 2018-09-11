 var browser_class = navigator.userAgent;
 var browser_class_name1 = browser_class.match("Mobile");
 var browser_class_name2 = browser_class.match("mobile");
 var location_url = window.location.href;

 if (browser_class_name1 != null || browser_class_name2 != null){
	 if (location_url.match("wap") == null){
	 window.location.href="http://m.hbcinemas.com/wap/app/cinema/list";
	 }
 } 