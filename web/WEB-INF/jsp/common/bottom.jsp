</div>

<div id="Footer">

    <div id="PoweredBy">&nbsp<a href="http://www.csu.edu.cn">www.csu.edu.cn</a>
    </div>

    <div id="Banner">
     <c:if test="${sessionScope.user!=null}">
        ${sessionScope.favImage}
     </c:if>
    </div>

</div>
<script src="js/jquery-3.7.1.min.js"></script>
<script src="js/top.js?v=1.6"></script>
</body>
</html>
