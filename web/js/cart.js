$(document).on('change','.xtotal',function() {
    var emptyRow = '<tr><td colspan="8"><b>Your cart is empty.</b></td></tr>';
    var tableHeader = '<tr>\n' +
        '\t\t\t<th><b>Item ID</b></th>\n' +
        '\t\t\t<th><b>Product ID</b></th>\n' +
        '\t\t\t<th><b>Description</b></th>\n' +
        '\t\t\t<th><b>In Stock?</b></th>\n' +
        '\t\t\t<th><b>Quantity</b></th>\n' +
        '\t\t\t<th><b>List Price</b></th>\n' +
        '\t\t\t<th><b>Total Cost</b></th>\n' +
        '\t\t\t<th>&nbsp;</th>\n' +
        '\t\t</tr>'
    let data={};
    $('.xtotal').each(function() {
        data[$(this).attr('name')]=$(this).val();
    })
    $.ajax({
        type: 'GET',
        url: 'UC',
        data:data,
        success: function (data) {
            const {total, newItems, cartNum} = data;
            let rows = '';
            console.log(newItems.length);

            newItems.forEach(item => {
                rows += `
                    <tr>
                        <td><a href="itemForm?itemId=${item.itemId}">${item.itemId}</a></td>
                        <td>${item.productId}</td>
                        <td>${item.Description}</td>
                        <td>${item.instock}</td>
                        <td><input type="text" name="${item.itemId}" value="${item.quantity}" class="xtotal"></td>
                        <td>${item.listprice.toFixed(2)}</td>
                        <td>${item.totalcost.toFixed(2)}</td>
                        <td><a href="removeCartItem?workingItemId=${item.itemId}" class="Button">Remove</a></td>
                    </tr>`;
            });
            const totalRow = `
                <tr>
                    <td colspan="7" class="alltotal">
                        Sub Total: ${total.toFixed(2)}
                        <input type="submit" value="Update Cart">
                    </td>
                    <td>&nbsp;</td>
                </tr>`;

            const tableContent = cartNum > 0 ? tableHeader + rows + totalRow : tableHeader + emptyRow;
            $('table').empty().append(tableContent);
        },
        error: function () {
            console.error('Failed to fetch cart data.');
        }
    });
});