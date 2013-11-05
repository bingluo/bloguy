$(document).ready(function(){
	$(".comment-reply-link").click(function(){
		var li = $(this).closest("li");
		var toId = li.attr("id");
		var author = li.find(".commentAuthor").html();
		$("#replyForm #toType").val("1");
		$("#replyForm #toId").val(toId);
		$("#msgLabel").next("span").remove();
		$("#msgLabel").after("<span> 回复给 "+author+": &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"<input class='button' id='cancel' type='button' value=' 取消 '/></span>");

		$("#cancel").click(function(){
			$(this).parent().remove();
			$("#replyForm #toType").val("0");
			$("#replyForm #toId").val($("#blogId").val());
		})
	})
})