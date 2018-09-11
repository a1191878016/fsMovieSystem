

var showCaseIncomingFlag = false;
var showCaseRecent=false;
var showCaseIndex = 0;
function initUser(){
	$.getJSON("/film/indexUser", function(data) {
		data = eval('(' + data.msg + ')');
		var userLoginObj = TrimPath.parseDOMTemplate("userLogin");
		var userResult = userLoginObj.process(data);
		$('#menu_right').html(userResult);
	});
}
function initCityData(){
	$.getJSON("/film/indexCity", function(data) {
		data = eval('(' + data.msg + ')');
		var cinemaObj=TrimPath.parseDOMTemplate("cinema");
		var cinemaResult = cinemaObj.process(data);
		$('#cities_list').html(cinemaResult);
		initCities();
	});
}
var isRecentCompleted = false;
function recentFilm() {
	$.getJSON("/film/index?index=1", function(data) {
		data = eval('(' + data.msg + ')');
		for(var d in data.flist){
			//data.flist[d].u = data.flist[d].u.replace('img0','img1');
			data.flist[d].u = data.flist[d].u;
		}
		var myTemplateObj = TrimPath.parseDOMTemplate("lzsy");
		var result = myTemplateObj.process(data);
		$('#hbc_showcase_1').html(result);
		$('#hbc_showcase_1').bxSlider({
			infiniteLoop: true,  
			slideWidth: 302,
			minSlides: 3,
			maxSlides: 3,
			slideMargin: 8,
			preloadImages:'all',
			onSliderLoad:function(){
			}
		});
		initShowcaseRegister();
		showCaseRecent=true;
		setTimeout(function(){isRecentCompleted = true;},1000);
		
	});

}
var incomingcnt=0;
function incomingFilm() {

	
	$.getJSON("/film/index?index=2", function(data) {
		
		data = eval('(' + data.msg + ')');
		for(var d in data.flist){
			data.flist[d].u = data.flist[d].u;
		}
		var myTemplateObj = TrimPath.parseDOMTemplate("jjsy");
		var result = myTemplateObj.process(data);
		$('#hbc_showcase_2').html(result);
		$('#hbc_showcase_2').bxSlider({
			infiniteLoop: true,  
			slideWidth: 302,
			minSlides: 3,
			maxSlides: 3,
			slideMargin: 8,
			preloadImages:'all',
			onSliderLoad:function(){
			}
		});
		
	});
	
}
	
function showcaseTabInit(obj){
		var cur = $(obj).index();//获取将点击的下标

		if(cur == 1){
			if(!isRecentCompleted) return false;
			//判断即将上映未加载且未打开状态
			if(!showCaseIncomingFlag && showCaseIndex!=1){
				incomingFilm();
				showCaseIncomingFlag = true;
				showCaseIndex=1;
				showcaseSwitcher(obj,1);
			}else if(showCaseIncomingFlag &&  showCaseIndex!=1){//已加载未打开状态
				showCaseIndex=1;
				showcaseSwitcher(obj,1);
				showCaseIncomingFlag = true;
			}else{
				
				return;
			}

		}else if(cur == 0){
			//判断即将上映未加载且未打开状态
			if(!showCaseRecent && showCaseIndex == 0){
				return;
			}else if(showCaseRecent &&  showCaseIndex!=0){//已加载未打开状态
				showCaseIndex=0;
				showcaseSwitcher(obj,0);
			}else{
				return;
			}			

		}
		


		

}


function showcaseSwitcher(obj,cur){


	$('.hbc_showcase_box').each(function(){
		$(this).hide();
		$(this).removeClass("cur");
		
	});
	$('#hbc_showcase_tab a').each(function(){
		$(this).removeClass("cur");
		
	});
	$(obj).addClass("cur");
	$('#box_' + cur).fadeIn();
	$(obj).blur();
	
  return false;
	
}




function initCities(){
	$('#cities_list dl').mouseover(function(){
		$('#cities_list dl').each(function(){
			$(this).removeClass('cur');
		});
		$(this).addClass('cur').fadeIn();
	});
}

function initBanner(){
	/* $.getJSON("/film/indexBanner", function(data) {
		data = eval('(' + data.msg + ')');
		data.act.bn = data.act.bn;
		data.act.bnr=data.act.bn.substring(0,data.act.bn.lastIndexOf("."))+"r"+data.act.bn.substring(data.act.bn.lastIndexOf("."),data.act.bn.length);
		data.act.bnl=data.act.bn.substring(0,data.act.bn.lastIndexOf("."))+"l"+data.act.bn.substring(data.act.bn.lastIndexOf("."),data.act.bn.length);
		var bannerObj = TrimPath.parseDOMTemplate("bannerImg");
		var bannerResult = bannerObj.process(data);
		$("#hbc_home_header").prepend(bannerResult);
	});
	*/
	$.getJSON("/film/indexBanner", function(data) {
		var result = data.msg ;
		$('#hbc_showcase_3').html('') ;
		var html = '' ;
		$(eval(result)).each(function(i, obj){
			html += '<li><a href="http://www.hbcinemas.com.cn/activity-detail-' + obj.k + '.html"><img src="' + obj.bn + '" alt="' + obj.an + '" /></a></li>'
		}) ;
		$('#hbc_showcase_3').append(html) ;
		$('#hbc_showcase_3').bxSlider({
			slideWidth: 900,
		 	auto:true,
			pause: 3000,
			controls:false,
			touchEnabled: true,
		});
	});
}
function initShowcaseRegister(){
	$('.poster_thumb').mouseover(function(){
			$(this).children('.poster_thumb_mask').show();
			$(this).children('.btn_red_s').show();
		}).mouseout(function(){
			$(this).children('.poster_thumb_mask').hide();
			$(this).children('.btn_red_s').hide();
		});

}