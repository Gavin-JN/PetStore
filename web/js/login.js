
function errFunction()
{
    var pass=document.getElementById("passwordId").value;
    var user=document.getElementById("usernameId").value;

    var x=document.getElementById("errOfusername");
    var y=document.getElementById("errOfpassword");
    var ifRun=true;
    if (user === "") {
    x.innerText = "Please input username!";
    ifRun=false;
}
    if (pass === "") {
    y.innerText = "Please input password!";
    ifRun=false;
}
    return ifRun;
}