<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Museum Ticket Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script>
       function validateMuseumForm() {
           const customerName = document.getElementById("customerName").value.trim();
           const adults = parseInt(document.getElementById("adults").value);
           const children = parseInt(document.getElementById("children").value);
           const mobile = document.getElementById("mobile").value.trim();
           const email = document.getElementById("email").value.trim();
           const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

           // Customer name validation
           if (customerName.length < 3 || customerName.length > 30) {
               alert("Customer name must be between 3 and 30 characters.");
               return false;
           }

           // Adult and child validation
           if (isNaN(adults) || adults <= 0) {
               alert("Adult members must be a positive number.");
               return false;
           }
           if (isNaN(children) || children < 0) {
               alert("Child members cannot be negative.");
               return false;
           }

           // Mobile number validation
           if (!/^\d{10}$/.test(mobile)) {
               alert("Mobile number must be a valid 10-digit number.");
               return false;
           }

           // Email validation
           if (!emailRegex.test(email)) {
               alert("Please enter a valid email address.");
               return false;
           }

           return true;
       }

       function clearForm() {
           document.getElementById("museumForm").reset();
       }

    </script>
    <style>
    /* General Styling */
    body {
        font-family: 'Roboto', sans-serif;
        background-color: #f4f4f9;
        color: #343a40;
        margin: 0;
        padding: 0;
    }

    /* Container Styling */
    .container {
        max-width: 700px;
        margin: 40px auto;
        background: #ffffff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    }

    /* Header Styling */
    h2 {
        font-size: 2rem;
        text-align: center;
        color: #dc3545;
        margin-bottom: 20px;
        font-weight: bold;
    }

    /* Form Group Styling */
    .form-group {
        margin-bottom: 20px;
    }

    /* Label Styling */
    label {
        font-size: 1rem;
        font-weight: 500;
        color: #495057;
        margin-bottom: 5px;
        display: block;
    }

    /* Input and Select Fields */
    input, select {
        width: 100%;
        padding: 12px;
        font-size: 1rem;
        border: 1px solid #ced4da;
        border-radius: 6px;
        transition: all 0.3s ease;
    }

    /* Input Focus State */
    input:focus, select:focus {
        border-color: #007bff;
        outline: none;
        box-shadow: 0 0 6px rgba(0, 123, 255, 0.5);
    }

    /* Button Styling */
    button {
        padding: 12px 20px;
        font-size: 1rem;
        border: none;
        border-radius: 6px;
        transition: all 0.3s ease;
        margin-right: 10px;
        cursor: pointer;
    }

    .btn-primary {
        background-color: #007bff;
        color: #fff;
    }

    .btn-primary:hover {
        background-color: #0056b3;
        transform: translateY(-2px);
        box-shadow: 0 4px 8px rgba(0, 91, 187, 0.2);
    }

    .btn-secondary {
        background-color: #6c757d;
        color: #fff;
    }

    .btn-secondary:hover {
        background-color: #5a6268;
        transform: translateY(-2px);
        box-shadow: 0 4px 8px rgba(90, 98, 104, 0.2);
    }

    /* Success Message Styling */
    p {
        font-size: 1rem;
        font-weight: bold;
        margin-top: 20px;
        color: #17a2b8;
    }

    /* Responsive Design */
    @media (max-width: 768px) {
        .container {
            padding: 20px;
        }

        h2 {
            font-size: 1.6rem;
        }

        button {
            font-size: 0.9rem;
            padding: 10px 15px;
        }
    }
    /* Success Message */
        .text-success {
            font-size: 1rem;
            font-weight: bold;
            text-align: center;
            margin-top: 20px;
            color: #28a745;
        }

    </style>
</head>
<body>

    <p class="text-success mt-3">
        ${message}
    </p>

    <div class="container mt-5">
        <h2 style="color:red"><center><b>MUSEUM TICKET FORM</b></center></h2>

        <form action="MuseumTicketServlet" method="post" id="museumForm" onsubmit="return validateMuseumForm();" class="border p-4">
            <div class="form-group">
                <label for="customerName">Customer Name:</label>
                <input type="text" id="customerName" name="customerName" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="adults">Total Adult Members:</label>
                <input type="number" id="adults" name="adults" class="form-control" min="1" required>
            </div>
            <div class="form-group">
                <label for="children">Total Child Members:</label>
                <input type="number" id="children" name="children" class="form-control" min="0" required>
            </div>
            <div class="form-group">
                <label for="mobile">Mobile Number:</label>
                <input type="text" id="mobile" name="mobile" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="button" class="btn btn-secondary" onclick="clearForm();">Clear</button>
        </form>
    </div>

</body>
</html>

