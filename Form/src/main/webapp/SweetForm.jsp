<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sweet Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script>
          function validateSweetForm() {
              const shopName = document.getElementById("shopName").value;
              const sweetName = document.getElementById("sweetName").value;
              const weight = document.querySelector('select[name="weight"]').value;
              const quantity = document.getElementById("quantity").value;

              if (shopName === "select") {
                  alert("Please select a valid shop name.");
                  return false;
              }

              if (sweetName === "select") {
                  alert("Please select a valid sweet name.");
                  return false;
              }

              if (weight === "select") {
                  alert("Please select a valid weight.");
                  return false;
              }

              if (quantity <= 0 || quantity > 100) {
                  alert("Quantity must be a positive number and not exceed 100.");
                  return false;
              }

              return true;
          }

          function clearForm() {
              document.getElementById("sweetForm").reset();
          }
        </script>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f9f9f9;
                margin: 0;
                padding: 0;
            }

            .container {
                max-width: 600px;
                margin: 30px auto;
                background: #ffffff;
                padding: 25px;
                border-radius: 10px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
            }

            h2 {
                text-align: center;
                color: #dc3545;
                margin-bottom: 20px;
            }

            label {
                font-weight: bold;
                color: #495057;
            }

            select, input {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ced4da;
                border-radius: 5px;
            }

            select:focus, input:focus {
                border-color: #007bff;
                box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
            }

            .btn-primary {
                background-color: #007bff;
                border: none;
            }

            .btn-primary:hover {
                background-color: #0056b3;
            }

            .btn-secondary {
                background-color: #6c757d;
            }

            .btn-secondary:hover {
                background-color: #5a6268;
            }

            .form-check {
                margin-left: 0px;
            }

            @media (max-width: 768px) {
                .container {
                    padding: 20px;
                }

                h2 {
                    font-size: 1.5rem;
                }
            }
 form .btn-secondary {
        background-color:  #FF0000;
        color: #212529;
    }

    form .btn-secondary:hover {
        background-color:  #FF0000;
        transform: translateY(-2px);
    }
        </style>
</head>
<body>

<p style="color:green;"><center>
    ${message}
   </center>
</p>
    <div class="container mt-5">
        <h2 style="color:red;"><center><b>SWEET FORM</b></center></h2>


        <form action="SweetFormServlet" method="post" id="sweetForm" onsubmit="return validateSweetForm();" class="border p-4">
            <div class="form-group">
                <label for="shopName">Shop Name:</label>
                <select id="shopName" name="shopName" class="form-control">
                    <option value="select">Select</option>
                    <option value="Sweet House">Sweet House</option>
                    <option value="Baker's Delight">Bakers Delight</option>
                    <option value="Nandini Sweets">Nandini Sweets</option>
                    <option value="Mithai Mandir">Mithai Mandir</option>
                    <option value="Kanti Sweets">Kanti Sweets</option>
                    <option value="Bharat Sweets">Bharat Sweets</option>
                    <option value="Shiv Sagar Sweets">Shiv Sagar Sweets</option>
                </select>
            </div>
            <div class="form-group">
                <label for="sweetName">Sweet Name:</label>
                <select id="sweetName" name="sweetName" class="form-control">
                    <option value="select">Select</option>
                    <option value="Kaju katli">Kaju katli</option>
                    <option value="Barfi">Barfi</option>
                    <option value="Gulab Jamun">Gulab Jamun</option>
                    <option value="Rasgulla">Rasgulla</option>
                    <option value="Soan Papdi">Soan Papdi</option>
                    <option value="Rasmalai">Rasmalai</option>
                    <option value="Modak">Modak</option>
                    <option value="Boondi">Boondi</option>
                    <option value="Jeelebi">Jeelebi</option>
                    <option value="Shrikhand">Shrikhand</option>
                    <option value="Kalakand">Kalakand</option>
                </select>
            </div>
            <div class="form-group">
                <label>Weight:</label>
                <select name="weight">
                     <option>select</option>
                     <option value="0.5">0.5 KG</option>
                     <option value="1">1 KG</option>
                     <option value="1.5">1.5 KG</option>
                     <option value="2">2 KG</option>
                </select><br><br>
            </diV>

            <div class="form-group">
                <label>Special:</label>
                <div class="form-check">
                    <input type="checkbox" id="special" name="special" class="form-check-input" value="true">
                </div>
            </div>
            <div class="form-group">
                <label for="quantity">Quantity:</label>
                <input type="number" id="quantity" name="quantity" class="form-control" min="1" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="button" class="btn btn-secondary" onclick="clearForm();">Clear</button>
        </form>
    </div>



</body>
</html>
