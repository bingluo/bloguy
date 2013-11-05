String.prototype.replaceAll  = function(s1,s2){ 
return this.replace(new RegExp(s1,"gm"),s2); 
}

KindEditor.lang({
	incode : '请插入程序代码'
});

KindEditor.plugin('incode', function(K) {
	var self = this, name = 'incode';
	self.clickToolbar(name, function() {
		var dialog = K.dialog({
			width : 590,
			height : 400,
			title : "请插入程序代码",
			body : "<table border='0' cellpadding='0' cellspacing='0'><tr><td style='padding:0px;border-width:0px'>\
				<select id='lan_select' name='lang'>\
                    <option value=''>----选择编程语言----</option>\
            		<option value='cpp'>C/C++/Objective-C</option>\
                	<option value='java'>Java</option>\
            		<option value='c#'>C#</option>\
            		<option value='php'>PHP</option>\
            		<option value='python'>Python</option>\
            		<option value='perl'>Perl</option>\
            		<option value='ruby'>Ruby</option>\
            		<option value='pascal'>Delphi/Pascal</option>\
            		<option value='asp'>ASP/Basic</option>\
            		<option value='js'>JavaScript</option>\
            		<option value='html'>HTML</option>\
            		<option value='xml'>XML</option>\
            		<option value='css'>CSS</option>\
            		<option value='scala'>Scala</option>\
            		<option value='groovy'>Groovy</option>\
            		<option value='sql'>SQL</option>\
            		<option value='sliverlight'>WPF/SliverLight</option>\
            		<option value='lua'>Lua</option>\
            		<option value='as3'>ActionScript</option>\
            		<option value='shell'>Bash/Shell</option>\
            	</select></td></tr><tr><td style='padding:0px;border-width:0px'><textarea name='source' id='source_area' style='width:540px;height:265px;font-size:9pt;font-family:Courier New,Arial'></textarea></td></tr></table>",
			closeBtn : {
				name : '关闭',
					click : function(e) {
					dialog.remove();
				}
			},
			yesBtn : {
				name : '确定',
				click : function(e) {
					var selectObj = document.getElementById('lan_select');
					var sourceArea = document.getElementById('source_area');
					var lan = selectObj.value;
					var source = sourceArea.value;
					if(lan==""){
						alert("请选择程序语言");
						return false;
					}else if(source==""){
						alert("请插入程序代码");
						return false;
					}
					source = source.replaceAll("<","&lt;");
					source = source.replaceAll(">","&gt;");
					var html = '<pre class="brush:'+lan+';toolbar: true; auto-links: false;">';
					html+=source;
					html+='</pre>';
					
					editor.insertHtml(html);
					dialog.remove();
				}
			},
			noBtn : {
				name : '取消',
				click : function(e) {
					dialog.remove();
				}
			}
		});
	});
});