<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sweet Form Result</title>
</head>
<body>
    <h2>Order Details</h2>
    <p>Shop Name: ${sweetForm.shopName}</p>
    <p>Sweet Name: ${sweetForm.sweetName}</p>
    <p>Weight: ${sweetForm.weight} KG</p>
    <p>Quantity: ${sweetForm.quantity}</p>
    <p>Special: ${sweetForm.price > 300 * sweetForm.weight * sweetForm.quantity ? "Yes" : "No"}</p>
    <p>Total Price: ${sweetForm.price}</p>
</body>
</html>
