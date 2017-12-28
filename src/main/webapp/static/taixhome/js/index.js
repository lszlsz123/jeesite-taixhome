

//mg.js
$('ul.yl_chose').on('click','li',function(){

	if($(this).html()=='办理指南'){ //如果点击的当前li的内容为 办理指南  则模态框里 添加办理指南的内容（即将办理指南的内容显示==》将其no-see类去掉  办理进度的内容隐藏==》加上no-see类）

		if($(".mg_dd").hasClass("no-see")){ //如果办理指南有no-see类
			$(".mg_dd").removeClass("no-see"); //就去掉
			$(".mg_pp").addClass("no-see"); //办理进度 加上no-see类
		}

	}else if($(this).html()=='办理进度'){//如果点击的当前li的内容为 办理进度  则模态框里 添加办理进度的内容  同理

		if($(".mg_pp").hasClass("no-see")){ //如果办理指南有no-see类
			$(".mg_pp").removeClass("no-see"); //就去掉
			$(".mg_dd").addClass("no-see"); //办理进度 加上no-see类
		}
	}
});


$(".mg").click(function(){
	$(".mg").addClass("change1");
	$(".mg").removeClass("change2");
	$(".pp").removeClass("change1");
});
$(".pp").click(function(){
	$(".pp").addClass("change1");
	$(".mg").addClass("change2");
});



//checkbox选择  
//第三者责任险 玻璃单独破碎险 车身划痕险
$('span.dk').click(function(){
	$(this).find('span.xk').addClass('xh');
	$(this).parent().siblings().find('span.xh').removeClass('xh');
});


//获得第三方责任险的选项   
// 找到下方被选择的span   $('td.ic_xx').find('span.xh')
// 找到下方被选择的span 的父亲 dk span   在找到他的兄弟input  $('').find('span.xh').parent().siblings('input')
//得到input的value的值
//var a=$('td.ic_zerenxian').find('span.xh').parent().siblings('input').val();

//获得玻璃单独破碎险的选项  
// 找到下方被选择的span   $('td.ic_xx').find('span.xh')
// 找到下方被选择的span 的父亲 dk span   在找到他的兄弟input  $('').find('span.xh').parent().siblings('input')
//得到input的value的值
//var b=$('td.ic_molixian').find('span.xh').parent().siblings('input').val();


//获得车身划痕险的选项  
// 找到下方被选择的span   $('td.ic_xx').find('span.xh')
// 找到下方被选择的span 的父亲 dk span   在找到他的兄弟input  $('').find('span.xh').parent().siblings('input')
//得到input的value的值
//var c=$('td.ic_cheshenxian').find('span.xh').parent().siblings('input').val();