<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Milk Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script>
        function validateMilkForm() {
            const brand = document.getElementById("brand").value.trim();
            const type = document.getElementById("type").value;
            const quantity = document.getElementById("quantity").value;

            let isValid = true;

            // Validate Brand Name
            if (brand.length < 3 || brand.length > 30) {
                document.getElementById("brandError").textContent = "Brand name must be between 3 and 30 characters.";
                isValid = false;
            } else {
                document.getElementById("brandError").textContent = "";
            }

            // Validate Milk Type
            if (type === "select") {
                document.getElementById("typeError").textContent = "Please select a valid milk type.";
                isValid = false;
            } else {
                document.getElementById("typeError").textContent = "";
            }

            // Validate Quantity
            if (quantity <= 0 || isNaN(quantity)) {
                document.getElementById("quantityError").textContent = "Quantity must be greater than 0 and a valid number.";
                isValid = false;
            } else {
                document.getElementById("quantityError").textContent = "";
            }

            return isValid;
        }

        function clearForm() {
            document.getElementById("milkForm").reset();
            document.getElementById("brandError").textContent = "";
            document.getElementById("typeError").textContent = "";
            document.getElementById("quantityError").textContent = "";
        }

    </script>
    <style>
    /* General Body Styling */
    body {
        font-family: 'Roboto', Arial, sans-serif;
        background-color: #f8f9fa;
        margin: 0;
        padding: 0;
        color: #212529;
        line-height: 1.5;
    }

    /* Centered Container */
    .container {
        max-width: 600px;
        margin: 40px auto;
        padding: 30px;
        background: #ffffff;
        box-shadow: 0 4px 16px rgba(0, 0, 0, 0.15);
        border-radius: 10px;
    }

    /* Header Styling */
    h2 {
        font-size: 2rem;
        text-align: center;
        color: #007bff;
        margin-bottom: 25px;
        font-weight: 700;
    }

    /* Form Field Styling */
    form .form-group {
        margin-bottom: 20px;
    }

    form label {
        font-weight: 500;
        display: block;
        margin-bottom: 8px;
        color: #495057;
    }

    form input[type="text"],
    form input[type="number"],
    form select {
        width: 100%;
        padding: 12px;
        font-size: 1rem;
        border: 1px solid #ced4da;
        border-radius: 8px;
        transition: border-color 0.3s ease, box-shadow 0.3s ease;
    }

    /* Input and Select Focus State */
    form input:focus,
    form select:focus {
        border-color: #80bdff;
        outline: none;
        box-shadow: 0 0 8px rgba(0, 123, 255, 0.3);
    }

    /* Button Styling */
    form button {
        padding: 12px 20px;
        font-size: 1rem;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease, transform 0.2s ease;
    }

    form .btn-primary {
        background-color: #007bff;
        color: #fff;
    }

    form .btn-primary:hover {
        background-color: #0056b3;
        transform: translateY(-2px);
    }

    form .btn-secondary {
        background-color: #6c757d;
        color: #fff;
    }

    form .btn-secondary:hover {
        background-color: #5a6268;
        transform: translateY(-2px);
    }

    /* Error Message Styling */
    small.text-danger {
        font-size: 0.85rem;
        color: #dc3545;
    }

    /* Success Message */
    .text-success {
        font-size: 1rem;
        font-weight: bold;
        text-align: center;
        margin-top: 20px;
        color: #28a745;
    }

    /* Responsive Design */
    @media (max-width: 768px) {
        .container {
            padding: 20px;
            margin: 20px;
        }

        h2 {
            font-size: 1.8rem;
        }

        form button {
            font-size: 0.9rem;
        }
    }


    </style>
</head>
<body>
<p class="text-success mt-3">
    ${message}
    </p>
    <div class="container mt-5">
        <h2 class="text-center text-danger"><b>MILK FORM</b></h2>

        <form id="milkForm" onsubmit="return validateMilkForm();" class="border p-4" action="MilkFormServlet" method="post">
            <div class="form-group">
                <label for="brand">Brand:</label>
                <input type="text" id="brand" name="brand" class="form-control" required>
                <small id="brandError" class="text-danger"></small>
            </div>
            <div class="form-group">
                <label for="type">Type:</label>
                <select id="type" name="type" class="form-control" required>
                    <option value="select">Select</option>
                    <option value="Special">Special</option>
                    <option value="Ordinary">Ordinary</option>
                    <option value="Good Life">Good Life</option>
                    <option value="Good Life Lite">Good Life Lite</option>
                    <option value="Family">Family</option>
                    <option value="Buffalo">Buffalo</option>
                </select>
                <small id="typeError" class="text-danger"></small>
            </div>
            <div class="form-group">
                <label for="quantity">Quantity:</label>
                <input type="number" id="quantity" name="quantity" class="form-control" min="1" max="100" required>
                <small id="quantityError" class="text-danger"></small>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="button" class="btn btn-secondary" onclick="clearForm();">Clear</button>
        </form>
    </div>


</body>
</html>
