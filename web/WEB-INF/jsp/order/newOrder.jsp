<%@include file="../common/top.jsp"%>

<html>
<head>
    <title>Order</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="order-container">
    <table class="order-table">
        <tbody>
        <tr>
            <td class="label">Name:</td>
            <td class="value">${sessionScope.currentUser.getFirstName()} ${sessionScope.currentUser.getLastName()}</td>
            <td class="label">Phone:</td>
            <td class="value">${sessionScope.currentUser.getPhone()}</td>
        </tr>
        <tr>
            <td class="label">Address:</td>
            <td colspan="3" class="value">${sessionScope.currentUser.getAddress()}</td>
        </tr>
        <tr class="header-row">
            <td>Pet Name</td>
            <td>Product ID</td>
            <td>Pet Price</td>
            <td>Quantity</td>
        </tr>
        <c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
            <tr>
                <td>${cartItem.item.product.name}</td>
                <td>${cartItem.item.itemId}</td>
                <td>${cartItem.item.listPrice}</td>
                <td>${cartItem.quantity}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4" class="total">Total: ${sessionScope.cart.subTotal}</td>
        </tr>
        <tr>
            <td colspan="4" class="pay-button-cell">
                <input type="submit" value="Pay" class="pay-button">
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>

<%@include file="../common/bottom.jsp"%>

<style>
    /* Global Styles */
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f0f0f0;
        color: #333;
    }

    /* Order Container */
    .order-container {
        width: 60%;
        margin: 4% auto;
        background-color: #ffffff;
        border-radius: 8px;
        padding: 20px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    /* Table Styles */
    .order-table {
        width: 100%;
        border-collapse: collapse;
        font-size: 16px;
    }

    .order-table td, .order-table th {
        padding: 12px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    .order-table .header-row {
        background-color: #f4f4f4;
        font-weight: bold;
    }

    .order-table .label {
        font-weight: bold;
        color: #2E3A47;
    }

    .order-table .value {
        color: #555;
    }

    .order-table .total {
        background-color: #F8E5CB;
        font-weight: bold;
        font-size: 18px;
        color: #2E3A47;
    }

    /* Button Styles */
    .pay-button {
        width: 200px;
        height: 40px;
        background-color: #D8A272;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 18px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    .pay-button:hover {
        background-color: #F4C28E;
    }

    .pay-button-cell {
        text-align: center;
    }
</style>
