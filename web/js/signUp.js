function refreshCaptcha() {
    var captchaImage = document.getElementById('captchaImage');
    // 更新图像的src属性，因为是get请求，所以要在后面添加一个时间戳以防止浏览器缓存图像
    captchaImage.src = 'captcha?' + new Date().getTime();
}

function NULLFunction()
{
    var fN=document.getElementById("firstName").value.trim();
    var lN=document.getElementById("lastName").value.trim();
    var uN=document.getElementById("username").value.trim();
    var pW=document.getElementById("password").value.trim();
    var eP=document.getElementById("ensurePassword").value.trim();
    var cN=document.getElementById("country").value.trim();
    var ad=document.getElementById("address").value.trim();
    var eM=document.getElementById("email").value.trim();
    var ag=document.getElementById("age").value.trim();
    var ph=document.getElementById("phone").value.trim();
    var Fc=document.getElementById("favoriteCategory").value.trim();

    if (fN===""||lN===""||uN===""||pW===""||eP===""||eM===""||ag===""||ph===""||ad===""||cN===""||Fc==="")
    {
        var Mass=document.getElementById("emptyMass");
        Mass.innerText="Please fill in all information"
        return false;
    }
    else{
        return true;
    }
}

$('#ensurePassword').on('change',function(){
    // console.log(1);
    if(!($(this).val() === ($('#password').val()))){
        $("#eMass").text('Password not same')
    }
    else{
        $("#eMass").text("");
    }
})

$('#username').on('change',function(){
    $.ajax({
        type:'get',
        url:'ifUserNameExited?uname='+$('#username').val(),
        success:function(data){
            if(data.length!=0){
                $('#ifExid').text(data);
            }
            else{
                $('#ifExid').text("");
            }
        }
    })
})
