<%@ include file="../common/top.jsp"%>

<div id="BackLink">
    <a href="tomain">Return to Main Menu</a>
</div>

<div id="Catalog">

    <h1>${sessionScope.category.name}</h1>

<%--    <table>--%>
<%--        <tr>--%>
<%--            <th>Product ID</th>--%>
<%--            <th>Name</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="product" items="${sessionScope.productList}">--%>
<%--            <tr>--%>
<%--                <td>--%>
<%--                    <a href="productForm?productId=${product.productId}">${product.productId}</a>--%>
<%--                </td>--%>
<%--                <td>${product.name}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
    <ul id="CatalogList">
        <c:forEach var="product" items="${sessionScope.productList}">
            <li>
                <div class="product-description">${product.description}</div>
                <div class="product-name"><b>${product.name}</b></div>
                <a href="productForm?productId=${product.productId}" class="product-id">${product.productId}</a>
            </li>
        </c:forEach>
    </ul>

</div>

<%@ include file="../common/bottom.jsp"%>
