$('.Button').on('click', function(){
    var id=$(this).attr('id');
    $.ajax({
        type:'GET',
        url:'addItemToCart?workingItemId='+id,
        success:function(data){
            console.log(data);
            $('#num').text(data);

        }
    })

})
