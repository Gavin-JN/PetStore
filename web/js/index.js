var turn=1;
window.setInterval(function(){
    var t=$('.turn');
    var n=90*turn;
    t.css('transform','rotateY('+n+'deg)');
    turn++;
},3000)