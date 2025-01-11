<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>Pet Favorites<br>
    Shop for more of your favorite pet here.
</p>
<ul id="coul" style=" padding: 0;
    margin: 0;
    list-style: none;">
    <c:forEach var="product" items="${sessionScope.myList}">
        <li style="box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                background-color: #f9f9f9; " id="coli">
            <a href="productForm?productId=${product.productId}">${product.name}</a>
            (${product.productId})
        </li>
    </c:forEach>
</ul>




