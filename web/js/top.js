$('#search_text').on('input',(function(){
    $('#SearchContent ul').css('display','block');
    const keyword = $('#search_text').val().trim().toLowerCase();
    $.ajax({
        type:'get',
        url:'xml/inform.xml',
        success:function(data){
            var list;
            var xmldata=$(data);
            xmldata.find('track').each(function(){
                var j=$(this);
                if(j.find('name').text().toLowerCase().includes(keyword)){
                    if(list==undefined)
                    {
                        list='<li><a href="productForm?productId='+j.find('productId').text()+'">'+j.find('name').text()+'</a></li>';
                    }
                    else{
                        list=list+'<li><a href="productForm?productId='+j.find('productId').text()+'">'+j.find('name').text()+'</a></li>';
                    }
                }
            })
            $('#SearchContent ul').empty().append(list);
        }
    })
}))


$('#SearchContent').on('mouseleave',function(){
    $('#SearchContent ul').css('display','none');
})

$(document).ready(function(){
    if($('#num').text()!=""&&$('#num').text()!="0"){
        $('.tips').css('display','inline-block');
    }
    else{
        $('.tips').css('display','none');
    }
})