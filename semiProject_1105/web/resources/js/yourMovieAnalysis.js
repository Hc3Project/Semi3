$(function(){
	var list = $('#rec').val();
	var result = list.replace(/\[|\]|\s/g, "")
	console.log(result.split(","));
	
})