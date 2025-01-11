<%--
  Created by IntelliJ IDEA.
  User: mao19
  Date: 2024/10/30
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<div class="turnShow con">
    <div class="turn">
        <div class="f"></div>
        <div class="s"></div>
        <div class="t"></div>
        <div class="four"></div>
    </div>
</div>
<div class="head">
    <img src="images/head.png" alt="head">
</div>
<div class="main con">
    <ul>
        <li><div class="content">
            <div class="img1">
                <img src="images/dogCon.jpg" alt="dog">
            </div>
            <div class="p1">
                <p>
                    Pets hold a special place in the hearts of millions around the world. This bond between pets and people is
                    a relationship built on love, trust, and mutual understanding.
                </p>
                <br>
                <p>
                    Do you wanner get one ? take a look at our PetStore!
                </p>
            </div>
        </div></li>
        <li><div class="content">
            <div class="img2">
                <img src="images/healthAn.jpg" alt="healthAnimal">
            </div>
            <div class="p2">
                <p>
                    Our store features a wide range of products tailored for cats, dogs, birds, fish, and small animals. We also offer expert advice from our knowledgeable staff to ensure your pets lead happy, healthy lives.
                </p>
            </div>
        </div></li>
        <li><div class="content">
            <div class="img3">
                <img src="images/favAn.png" alt="fav">
            </div>
            <div class="p3">
                We offer personalized services, providing tailored recommendations to suit your pet's unique needs.
            </div>
        </div></li>
        <li><div class="content">
            <div class="img4">
                <img src="images/deliver.jpg" alt="deliver">
            </div>
            <div class="p4">
                <p>At PetStore, we understand that life can get busy, and making time to shop for your pet’s essentials isn’t always easy. That’s why we’re excited to offer fast, reliable delivery services to bring everything your pet needs right to your doorstep!</p>
            </div>
        </div></li>
    </ul>
    <div class="getit">
        <a href="tomain">Get it</a>
    </div>
</div>
</body>
<style>
    body{
        background-color: #f2f3f5;
    }
    *{
        margin: 0;
        padding: 0;
    }
    li{
        list-style: none;
    }
    .con{
        margin: 0 auto;
        width: 1200px;
    }
    .turnShow{
        height: 450px;
        /* background-color: aqua; */
        text-align: center;
        margin-bottom: 108px;
        perspective: 3600px;
    }
    .turnShow .turn{
        width: 840px;
        height: 400px;
        position: relative;
        margin-left: 200px;
        top: 21px;
        transform-style: preserve-3d;
        transition: all 3s;
    }

    .turn div{
        display: block;
        position: absolute;
        left: 0;
        top: 0;
    }
    .f{
        width: 840px;
        height: 400px;
        background-image: url("images/dogshow.jpg");
        background-size: cover;
        transform: translateZ(420px);
    }
    .s{
        width: 840px;
        height: 400px;
        background-image: url("images/catshow.jpg");
        background-size: cover;
        transform: translateX(420px) rotateY(90deg) ;
    }
    .t{
        width: 840px;
        height: 400px;
        background-image: url("images/birdshow.jpg");
        background-size: cover;
        transform: translateZ(-420px)  rotateY(180deg) ;

    }
    .four{
        width: 840px;
        height: 400px;
        background-image: url("images/fishshow.jpg");
        background-size: cover;
        transform: translateX(-420px) rotateY(-90deg);
    }
    .head{
        width: 1200px;
        height: 66px;
        background-color: white;
        margin: 0 auto;
    }
    .head img{
        margin-top: -219px;
        margin-left: 100px;
        width: 1000px;
        height: 332px;
    }
    .main{
        height: 1700px;
        /* background-color: aquamarine; */
        background-color:white;
        position: relative;
    }
    .content{
        /* border: 1px solid #000; */
        height: 360px;
        background-color:white;
        position: relative;
    }
    .content .img1{
        position: absolute;
        background-color: pink;
        width: 320px;
        height: 240px;
        top: 60px;
        left: 100px;
        border-radius: 4px;
    }
    .img1 img{
        width: 320px;
        height: 240px;
        border-radius: 4px;
    }
    .content .p1{
        position: absolute;
        top: 100px;
        left: 480px;
        width: 560px;
        height: 200px;
        /* background-color: rebeccapurple; */
        font-size: 22px;
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    }

    .content p:nth-child(3){
        font-size: 34px;
    }

    .content .img2{
        position: absolute;
        left: 700px;
    }

    .img2 img{
        width: 440px;
        height: 320px;
        border-radius: 4px;
    }

    .content .p2{
        position: absolute;
        width: 500px;
        left: 120px;
        top: 70px;
        font-size: 26px;
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    }

    .content .img3{
        position: absolute;
        width: 340px;
        height: 300px;
        left: 30px;
    }

    .img3 img{
        width: 380px;
        height: 260px;
    }

    .content .p3{
        position: absolute;
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        font-size: 30px;
        width: 400px;
        top: 60px;
        left: 500px;
    }

    .content .p4{
        position: absolute;
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        font-size: 32px;
        width: 600px;
        left: 30px;
        top: 60px;
    }

    .content .img4{
        position: absolute;
        left: 700px;

    }
    .img4 img{
        width: 450px;
        height: 380px;
    }

    .getit{
        margin: 100px auto;
        width: 180px;
        height: 60px;
        border-radius: 28px;
        background-color: black;
    }
    .getit a{
        display: block;
        text-decoration: none;
        width: 180px;
        height: 60px;
        text-align: center;
        border-radius: 28px;
        font-size: 34px;
        font-weight: 700;
        color: aliceblue;
        font-family:"songti";
        line-height: 60px;

    }
</style>
<script src="js/jquery-3.7.1.min.js" type="text/javascript" charset="UTF-8"></script>
<script>
    var turn=1;
    window.setInterval(function(){
        var t=$('.turn');
        var n=90*turn;
        t.css('transform','rotateY('+n+'deg)');
        turn++;
    },3000)
</script>
</html>

