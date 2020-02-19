$(function() {
	$('td').mouseover(function() {
		$(this).attr('title', $(this).text());
	});
});
