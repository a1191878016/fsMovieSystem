 function elseSch(obj,filmId,todayOrTomorrow){
	$('.active').removeClass("active");
	$(obj).addClass("active");
	$('.filmLi').removeClass("filmLi");
	$(obj).find("p").addClass("filmLi");
	var url = addPresentTime('/wap/alipay/filmSchedule/elseSch?filmScheduleQueryVO.todayOrTomorrow=' + todayOrTomorrow + '&filmScheduleQueryVO.filmId=' + filmId);// 防止缓存
	$.ajax({
		url:		url,
		type:		"POST",
		dataType:	"html",
		timeout:30000,
		async: false,
		beforeSend:	function(){},
		error: function(XMLHttpRequest, textStatus, thrownError){
	},
	
	success: function(data, textStatus){
		$('#elseSch_dl').html(data);
	},
	complete:	function(XMLHttpRequest, textStatus){
	}
	});
}	
 function elseSchWechat(obj,filmId,todayOrTomorrow){
		$('.active').removeClass("active");
		$(obj).addClass("active");
		$('.filmLi').removeClass("filmLi");
		$(obj).find("p").addClass("filmLi");
		var url = addPresentTime('/wap/wechat/filmSchedule/elseSch?filmScheduleQueryVO.todayOrTomorrow=' + todayOrTomorrow + '&filmScheduleQueryVO.filmId=' + filmId);// 防止缓存
		$.ajax({
			url:		url,
			type:		"POST",
			dataType:	"html",
			timeout:30000,
			async: false,
			beforeSend:	function(){},
			error: function(XMLHttpRequest, textStatus, thrownError){
		},
		
		success: function(data, textStatus){
			$('#elseSch_dl').html(data);
		},
		complete:	function(XMLHttpRequest, textStatus){
		}
		});
	}	

 function elseSchApp(obj,filmId,todayOrTomorrow){
		$('.active').removeClass("active");
		$(obj).addClass("active");
		$('.filmLi').removeClass("filmLi");
		$(obj).find("p").addClass("filmLi");
		var url = addPresentTime('/wap/app/filmSchedule/elseSch?filmScheduleQueryVO.todayOrTomorrow=' + todayOrTomorrow + '&filmScheduleQueryVO.filmId=' + filmId);// 防止缓存
		$.ajax({
			url:		url,
			type:		"POST",
			dataType:	"html",
			timeout:30000,
			async: false,
			beforeSend:	function(){},
			error: function(XMLHttpRequest, textStatus, thrownError){
		},
		
		success: function(data, textStatus){
			$('#elseSch_dl').html(data);
		},
		complete:	function(XMLHttpRequest, textStatus){
		}
		});
	}	
/**
 * 实时获取座位图
 * @param seqNO
 * @param hallId
 * @return
 */
function reloadSeatMap(seqNO, cinemaCode) {
	
	var url = addPresentTime('/order/ajaxLoadSeat?order.seqNO=' + seqNO + '&order.cinemaCode=' + cinemaCode);// 防止缓存
	var result = '';
	$.ajax({
		url:		url,
		type:		"POST",
		dataType:	"html",
		async: false,
		beforeSend:	function(){
		},
		error: function(XMLHttpRequest, textStatus, thrownError){
		},

		success: function(data, textStatus){

			$('#div_table_seat_list').html(data);
		},
		complete:	function(XMLHttpRequest, textStatus){
		}
	});
}
function inputInteger(obj) {
	
	$(obj).val($(obj).val().replace(/\D/g,''));
}
function test100( num )
{
var r = /^[1-9]\d*00$/;
 return r.test( num );
}
/**
 * 实时获取座位图
 * @param seqNO
 * @param hallId
 * @return
 */
function reloadAlipaySeatMap(seqNO, hallId) {
	
	var url = addPresentTime('/wap/alipay/order/ajaxLoadSeat?order.seqNO=' + seqNO + '&order.hallId=' + hallId);// 防止缓存
	var result = '';
	$.ajax({
		url:		url,
		type:		"POST",
		dataType:	"html",
		async: false,
		beforeSend:	function(){
		},
		error: function(XMLHttpRequest, textStatus, thrownError){
		},

		success: function(data, textStatus){

			$('#more_sits').html(data);
		},
		complete:	function(XMLHttpRequest, textStatus){
		}
	});
}
/**
 * 实时获取座位图
 * @param seqNO
 * @param hallId
 * @return
 */
function reloadWechatSeatMap(seqNO, hallId) {
	
	var url = addPresentTime('/wap/wechat/order/ajaxLoadSeat?order.seqNO=' + seqNO + '&order.hallId=' + hallId);// 防止缓存
	var result = '';
	$.ajax({
		url:		url,
		type:		"POST",
		dataType:	"html",
		async: false,
		beforeSend:	function(){
		},
		error: function(XMLHttpRequest, textStatus, thrownError){
		},

		success: function(data, textStatus){

			$('#more_sits').html(data);
		},
		complete:	function(XMLHttpRequest, textStatus){
		}
	});
}

/**
 * ajax提交表单并返回
 * 
 * @param formName
 * @param url
 * @return
 */

function ajaxForm(formName,url, fn ,errorfn){
	
	var url = addPresentTime(url);// 防止缓存
	$("#" + formName).attr('action',url);
	var options = {
		dataType: 'json',
		type: 'POST',
		// action: url,
		beforeSubmit: function(formArray, jqForm) {
		},
		error: function(XMLHttpRequest, textStatus, thrownError){
			if (errorfn != undefined) {
				errorfn();
			}
		},
		success: function(data){
			
			if (fn != undefined) {
				fn(data);
			}
		}
	};

	$("#" + formName).ajaxSubmit(options);
}
function load(url) {
	var url = addPresentTime(url);// 防止缓存
	var result = '';
	$.ajax({
		url:		url,
		type:		"POST",
		dataType:	"json",
		async: false,
		beforeSend:	function(){
		},
		error: function(XMLHttpRequest, textStatus, thrownError){
		},

		success: function(data, textStatus){
			result = data;
		},
		complete:	function(XMLHttpRequest, textStatus){
		}
	});
	return result;
}
function inputFilmNameEn(obj) {

	$(obj).val($(obj).val().replace(/[^\a-zA-z0-9\\,， 、\/·]/g,''));
	
}

function inputpassword(obj) {
	$(obj).val($(obj).val().replace(/^\s+|\s+$/g,''));
	
}
String.prototype.trim=function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");
};

function isNull(val) {
	
	var o = val.trim();
	
	return (o == null || o == '' || o.length == 0);
}
function fadeWarning(str,url)
{
	var oWarning=document.getElementById('warning');
	var oBox=oWarning.getElementsByClassName('box')[0];

	oWarning.style.display='block';

	oBox.innerHTML=str;

	setTimeout(function()
	{
		oWarning.style.opacity='1';

	}, 0);

	setTimeout(function()
	{
		oWarning.style.opacity='0';

		setTimeout(function()
		{
			oWarning.style.display='none';

		}, 2000);

	}, 1000);
	if(url){
		setInterval(function(){
			
			window.location.href=url;
		}, 3000);
		
	}
}