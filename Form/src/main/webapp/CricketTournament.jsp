<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cricket Tournament Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script>
        function validateCricketForm() {
            const playerName = document.getElementById("playerName").value.trim();
            const age = document.getElementById("age").value;
            const teamName = document.getElementById("teamName").value.trim();
            const contactNumber = document.getElementById("contactNumber").value.trim();
            const email = document.getElementById("email").value.trim();
            const numPlayers = document.getElementById("numPlayers").value;
            const coachName = document.getElementById("coachName").value.trim();
            const homeGround = document.getElementById("homeGround").value.trim();
            const sponsorsName = document.getElementById("sponsorsName").value.trim();

            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            const phoneRegex = /^\d{10}$/;

            // Validations
            if (playerName.length < 3 || playerName.length > 30) {
                alert("Player name must be between 3 and 30 characters.");
                return false;
            }
            if (age <= 0 || isNaN(age)) {
                alert("Age must be a positive number.");
                return false;
            }
            if (teamName.length < 3 || teamName.length > 30) {
                alert("Team name must be between 3 and 30 characters.");
                return false;
            }
            if (!phoneRegex.test(contactNumber)) {
                alert("Contact number must be a 10-digit positive number.");
                return false;
            }
            if (!emailRegex.test(email)) {
                alert("Please enter a valid email address.");
                return false;
            }
            if (numPlayers < 11) {
                alert("Number of players must be at least 11.");
                return false;
            }
            if (coachName.length < 3 || coachName.length > 30) {
                alert("Coach name must be between 3 and 30 characters.");
                return false;
            }
            if (homeGround.length < 3 || homeGround.length > 30) {
                alert("Home ground must be between 3 and 30 characters.");
                return false;
            }
            if (sponsorsName.length < 3 || sponsorsName.length > 30) {
                alert("Sponsor's name must be between 3 and 30 characters.");
                return false;
            }
            return true;
        }

        function clearForm() {
            document.getElementById("cricketForm").reset();
        }

    </script>
    <style>
    /* General Styling */
    body {
        font-family: 'Roboto', sans-serif;
        background-color: #f4f4f9;
        color: #212529;
        margin: 0;
        padding: 0;
    }

    /* Container Styling */
    .container {
        max-width: 800px;
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
        color: #007bff;
        margin-bottom: 20px;
        font-weight: 600;
    }

    /* Form Group Styling */
    .form-group {
        margin-bottom: 20px;
    }

    /* Label Styling */
    label {
        font-weight: 500;
        font-size: 1rem;
        color: #495057;
        margin-bottom: 5px;
        display: block;
    }

    /* Input and Select Styling */
    input, select {
        width: 100%;
        padding: 12px;
        font-size: 1rem;
        border: 1px solid #ced4da;
        border-radius: 6px;
        transition: all 0.3s ease;
    }

    /* Focus State for Input and Select */
    input:focus, select:focus {
        border-color: #007bff;
        box-shadow: 0 0 5px rgba(0, 123, 255, 0.3);
        outline: none;
    }

    /* Button Styling */
    button {
        padding: 12px 20px;
        font-size: 1rem;
        border: none;
        border-radius: 6px;
        transition: all 0.3s ease;
        margin-right: 10px;
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

    /* Error Message Styling */
    input:invalid {
        border-color: #dc3545;
    }

    input:invalid:focus {
        box-shadow: 0 0 5px rgba(220, 53, 69, 0.5);
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
    </style>
</head>
<body>
    <p style="color: green;"><center>
                ${message}
            </center></h2>
    <div class="container mt-5">

        <h2 style="color:red"><center><b>CRICKET TOURNAMENT REGISTRATION FORM</b></center></h2>

        <form id="cricketForm" action="CricketTournamentServlet" method="post" onsubmit="return validateCricketForm();" class="border p-4" border="2">

            <div class="form-group">
                <label for="teamName">Team Name:</label>
                <input type="text" id="teamName" name="teamName" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="captainName"> Captain Name:</label>
                <input type="text" id="captainName" name="captainName" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="contactNumber">Contact Number:</label>
                <input type="text" id="contactNumber" name="contactNumber" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="numPlayers">Number of Players:</label>
                <input type="number" id="numPlayers" name="numPlayers" class="form-control" min="11" required>
            </div>
            <div class="form-group">
                <label for="coachName">Coach Name:</label>
                <input type="text" id="coachName" name="coachName" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="homeGround">Home Ground:</label>
                <input type="text" id="homeGround" name="homeGround" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="sponsorsName">Sponsor's Name:</label>
                <input type="text" id="sponsorsName" name="sponsorsName" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
            <button type="button" class="btn btn-secondary" onclick="clearForm();">Clear</button>
        </form>
    </div>




</body>
</html>
