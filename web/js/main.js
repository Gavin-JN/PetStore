$('#MainImageContent area').on('mouseover', function() {
    $('#flotwindow').css('display', 'block');
    var category=this.getAttribute("alt").toUpperCase();
    $.ajax({
        type: 'GET',
        url: "flotwindow?category="+category,
        success: function(data) {
            $('#flotwindow>p').text(category);
            $('#flotwindow ul').empty().append(data);
        }
    })
})

$('#MainImageContent area').on('mouseleave',function(){
    $('#flotwindow').css('display','none');
})