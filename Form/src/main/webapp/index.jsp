<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forms Index</title>
    <style>
    /* General Body Styling */
    body {
        font-family: 'Roboto', Arial, sans-serif;
        background-color: #121212; /* Dark theme */
        margin: 0;
        padding: 0;
        color: #ffffff;
    }

    /* Container Styling */
    .container {
        max-width: 600px;
        margin: 40px auto;
        background: #1e1e1e; /* Dark gray for card background */
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.6);
    }

    /* Header Styling */
    h2 {
        text-align: center;
        color: #ff4500; /* Bright orange */
        margin-bottom: 30px;
        font-size: 2.5rem;
        font-weight: bold;
    }

    /* List Group Styling */
    .list-group {
        list-style-type: none;
        padding: 0;
        margin: 0;
    }

    .list-group-item {
        background: #2a2a2a; /* Slightly lighter gray */
        border: 1px solid #444;
        margin-bottom: 10px;
        border-radius: 8px;
        transition: background-color 0.3s ease, transform 0.2s ease;
        overflow: hidden;
    }

    .list-group-item:hover {
        background-color: #333;
        transform: scale(1.03);
        box-shadow: 0 4px 8px rgba(255, 69, 0, 0.4);
    }

    /* Link Styling */
    .list-group-item a {
        text-decoration: none;
        font-weight: 600;
        font-size: 1.2rem;
        color: #ff4500; /* Bright orange */
        display: block;
        padding: 15px 20px;
        border-radius: 8px;
        transition: color 0.3s ease, text-decoration 0.3s ease;
    }

    .list-group-item a:hover {
        color: #ff6347; /* Tomato red for hover */
        text-decoration: underline;
    }

    /* Responsive Design */
    @media (max-width: 768px) {
        .container {
            padding: 20px;
            margin: 20px;
        }

        h2 {
            font-size: 2rem;
        }

        .list-group-item a {
            font-size: 1rem;
        }
    }

    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script>
    document.addEventListener("DOMContentLoaded", function () {
        const links = document.querySelectorAll(".list-group-item a");

        links.forEach(link => {
            link.addEventListener("click", function (event) {
                const href = this.getAttribute("href");
                if (!href || href === "#") {
                    event.preventDefault();
                    alert("This form link is not active or unavailable.");
                }
            });
        });
    });

    </script>
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center" style="color:skyblue"><b>FORM LIST</b></h2>
        <ul class="list-group">
            <li class="list-group-item"><a href="MilkForm.jsp" class="btn btn-link">Milk Form</a></li>
            <li class="list-group-item"><a href="SweetForm.jsp" class="btn btn-link">Sweet Form</a></li>
            <li class="list-group-item"><a href="MusuemTicketForm.jsp" class="btn btn-link">Museum Ticket Form</a></li>
            <li class="list-group-item"><a href="CricketTournament.jsp" class="btn btn-link">Cricket Tournament Form</a></li>
        </ul>
    </div>
</body>
</html>
