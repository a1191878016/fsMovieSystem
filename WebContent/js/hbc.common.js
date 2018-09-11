
//筛选条件区域的参展或收缩
function termsBtn(txt){
	
	$('#termsbtn').click(function(){
			
			if($('#termsbtn').attr('href').indexOf('#open') != -1){
				
				$('#terms_con').slideDown(function(){
					
					$('#termsbtn').removeClass().addClass('up');
					$('#termsbtn').text('收起');
					$('#termsbtn').attr('href','#close');
				});
				
			}else{
				$('#terms_con').slideUp(function(){
					
					$('#termsbtn').removeClass().addClass('down');
					if(txt){
						$('#termsbtn').text(txt);
					}else{
						$('#termsbtn').text('展开');
					}
					$('#termsbtn').attr('href','#open');
				});
				
			}
	});
	
}
				
				
/*在影片列表查看排期*/
function bufferArrangementPage(id,url,isKill){//fn is callback function

	
	var con = $('#item_'+id + ' .arrangement_layer_con').html();
	
	if(con.indexOf('<table') != -1){
		openArrangementLayer(id,isKill);
		return;
	}
	
	var url = addPresentTime(url);//防止缓存
	
	$.ajax({
		url:		url,
		type:		"POST",
		dataType:	"html",
		beforeSend:	function(){
			
			initArrangementLayers(id,isKill);

		},
		error:		function(XMLHttpRequest, textStatus, thrownError){
			
			$(".ico_close").click(closeArrangementLayer(id,isKill));
		},

		success:	function(data, textStatus){
			
			setTimeout(function(){
			
				$('#item_'+id + ' .arrangement_layer_con').html(data);
				resetSessionListHieght(id);
				
			},
			500
			
			);
			

		},
		complete:	function(XMLHttpRequest, textStatus){
			
					

		}
	});
	
}

				
function initArrangementLayers(id,isKill){
	
	
	$('.arrangement_layer_con').each(function(){
		
		var isTrue = $(this).is(":visible");
		if(isTrue){
			var findID = $(this).parent().parent().attr('id');
			if(findID != ('item_'+id)){
				$('#'+findID +' .arrangement_layer_con').hide();
				var trgt = $('#'+findID).next('.movie_list_item').find('a.arrange_link');
				$(trgt).show();
			}
		}
		
	});
	
	$('#item_'+id +' .arrangement_layer_con').show();
		if(isKill){
			var trgt = $('#item_'+id).next('.movie_list_item').find('a.arrange_link');
		}
		$(trgt).hide();
		//为关闭按钮和esc键 注册事件
		$(document).keydown(function(event){
			var e;
			if (event.which !="") { e = event.which; }
			else if (event.charCode != "") { e = event.charCode; }
			else if (event.keyCode != "") { e = event.keyCode; }
			if(e == 27){
				closeArrangementLayer(id,isKill);
			}
		});
}
		
function openArrangementLayer(id,isKill){

	var isTrue = $('#item_'+id +' .arrangement_layer_con').is(":visible");
	if(!isTrue){
		initArrangementLayers(id,isKill);
	}
	
	setTimeout(function(){
		resetSessionListHieght(id);
		
	},100);
	
}

function closeArrangementLayer(){

	$('.arrangement_layer_con').hide();
	$('a.arrange_link').show();

}


//防止缓存页面
function addPresentTime(URL){
	var dynamicTime = new Date();
	dynamicTime = dynamicTime.getTime();
	
	//对已经有次参数的地址，不继续追加！
	if(URL.indexOf("newtime=") != -1){
		URL = URL.replace(/(\?|\&)newtime=\d*/,'')
	}	
	var n = (URL.indexOf("?") == -1) ? "?" : "&";
	URL = URL + n + "newtime=" + dynamicTime;
	return URL;
}



/*绑定会员卡第一步：选择影院所在城市 ，*/

function initCityOption (){
	$('.city_list label').mousedown(function(){
		$(this).addClass('highlight');
	}).mouseup(function(){
		$('.city_list label').each(function(){
			$(this).removeClass('current');
		})
		$(this).removeClass('highlight');
		$(this).addClass('current');
		//document.title =$('input[name="city"]:checked').val();//调试是否获取当前radio 的value值 
	});
	
}


/*切换场次*/

function sessionSwitch(index,obj){
	//alert(i+"|"+$(obj).index());
	if($(obj).hasClass('cur')) return false;
	
	$(obj).parent().prev('.limit_div').children('.arrangement_table').each(function(){
		$(this).hide();
	});
	
	$(obj).parent().prev('.limit_div').children('.arrangement_table').eq(index).show();
	
	
	$(obj).parent().children('http://www.hbcinemas.com.cn/js/a.cur').removeClass('cur');
	$(obj).addClass('cur');
	

	var ID = $(obj).parent().parent().parent().parent().attr('id');
	ID = ID.split('_');
	ID = ID[1];
	ID = parseInt(ID);
	resetSessionListHieght(ID);

}


function resetSessionListHieght(ID){
  	//alert("limitH:"+limitH+"  , curH:"+curH);
 	
	//var limitH  = $('#item_'+ID).height();
	
	var limitH  = $('#item_'+ID + ' .movie_list_item_right').height();
	
	$('#item_'+ID + ' .arrangement_table').each(function(){
		if($(this).is(":visible")){
			var curH = $(this).height();
	
				if(curH >= (limitH)) {
					$('#item_'+ID + ' .limit_div').height(limitH-40).css({overflow:'scroll',overflowX:'hidden'});
					$('#item_'+ID + ' .arrangement_table').css({width:478});
				}else if(curH >150) {
					$('#item_'+ID + ' .limit_div').height(curH+2).css({overflow:'hidden'});
					$('#item_'+ID + ' .arrangement_table').css({width:'100%'});
				}else{
					$('#item_'+ID + ' .limit_div').height(152).css({overflow:'hidden'});
					$('#item_'+ID + ' .arrangement_table').css({width:'100%'});
				}

			
		}
	})
	
	
}

/*首页价格表高亮显示*/
function setFeatured(i,txt){
	
	
	var tcon =		'<div class="featured_table"><table cellpadding="8" cellspacing="0" border="0" width="100%">';
	tcon+=			'<tr><th>' + $('#pricingtable th').eq(i).html() + '</th></tr>';
	tcon+=			'<tr class="highlight"><td><strong>'+txt+'</strong></td></tr>';
	tcon+=			'<tr class="first"><td>' + $('#pricingtable tr.first td').eq(i).html() + '</td></tr>';
	tcon+=			'<tr class="discount"><td>' + $('#pricingtable  tr.discount td').eq(i).html() + '</td></tr>';
	tcon+=			'<tr class="coupon"><td>' + $('#pricingtable  tr.coupon td').eq(i).html() + '</td></tr>';
	tcon+=			'<tr class="score"><td>' + $('#pricingtable  tr.score td').eq(i).html() + '</td></tr>';
	tcon+=			'<tr class="gift"><td>' + $('#pricingtable  tr.gift td').eq(i).html() + '</td></tr>';
	tcon+=			'<tr class="last"><td>' + $('#pricingtable  tr.last td').eq(i).html() + '</td></tr>';
	tcon+=			'</table></div>';
	
	//alert(tcon);
	$('#pricingtable th').eq(i).prepend(tcon);
}

function badNews(msg){
	
	$('#bad_news').html('<a href="#hbc">'+msg+'</a>');
		$('#bad_news').slideDown(500,function(){
		$(this).click(function(){
			
			$(this).slideUp(500);
		})
	});
}

//make ie to enable draw round corner
$(document).ready(function() {
	$(function() {
		if (window.PIE) {
			$('.rounded').each(function() {
				PIE.attach(this);
			});
		}
	});

});


//show loading with mask, when onchange select option befor ajax load

function showArrangementDataMask() {
	
	$('.arrangement_table').each(function(){
		var isTrue = $(this).is(":visible");
		if(isTrue){
			var w = $(this).width()+5;
			var h = $(this).height()+40;
			$('#data_loading_mask').width(w);
			$('#data_loading_mask').height(h);
			$('#data_loading_anim').width(w);
			$('#data_loading_anim').height(h);
			$('#data_loading_mask').show();
			return;

		}
	
	});
	
}
function hideArrangementDataMask() {
	$('#data_loading_mask').hide();
}

setBrowserDetection('我们发现你的浏览器版本过低，为了使您体验最好的服务，建议您升级浏览器，推荐您使用<a href="http://www.google.com/intl/zh-CN/chrome/">谷歌Chrome</a>浏览器，体验流畅在线服务！');

function setBrowserDetection(txt){
	if ($.browser.msie) {
		if( $.browser.version == 7.0 || $.browser.version == 6.0 || $.browser.version == 5.5){
			$('#top_bar').addClass('isIE').html('<img src="../img/icon-ie-alert.png"/*tpa=http://www.hbcinemas.com.cn/img/icon-ie-alert.png*/ />'+txt);
			$('#box_1').hide();
	
		}
	}
}