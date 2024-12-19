<!doctype html>
<%@page import="com.bank.dto.Customer"%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PS Bank</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="Dashboard.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">


</head>

<body>
<%Customer c = (Customer) session.getAttribute("success"); %>
    <nav class="navbar navbar-expand-lg bg-body-tertiary" class="navbar bg-primary" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#"><b>PSB</b></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="Dashboard.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contact Us</a>
                    </li>

                </ul>
	
				<%if(c!=null){%>
				<form action="Logout" method="post">
                <button type="submit" class="btn btn-outline-danger me-2" name="logout" value="Logout" >Logout</button>
                </form>
                <%}else{ %>
                <a href="SignUp.jsp"><button type="button" class="btn btn-outline-success me-2">Sign Up</button></a>
                <a href="Login.jsp"> <button type="button" class="btn btn-outline-success me-2" >Login</button></a>
				<%} %>
            </div>
        </div>
    </nav>

	<%if(c!=null){%>
	
    <div class="container-fluid " style="background-color: #84939d;">
    	<%if(c.getAccNo()==1100110011){%>
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link" href="Accounts.jsp">Get All Accounts Data</a>
            </li>
            
             <li class="nav-item">
                <a class="nav-link" href="Remove.jsp">Remove Customers </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="TransactionDetails.jsp">Get All Transactions Data </a>
            </li>
            
            
		         <div class="btn-group" >
					  <button class="btn btn-secondary dropdown-toggle" style="background-color: #84939d; font-size:17px; type="button" data-bs-toggle="dropdown" aria-expanded="false">
					    Access your Account
					  </button>
					  <ul class="dropdown-menu">
					    <li><a class="dropdown-item" href="Deposite.jsp">Deposite</a></li>
					    <li><a class="dropdown-item" href="Transfer.jsp">Transfer Amount</a></li>
					    <li><a class="dropdown-item" href="Balance.jsp">Check Balance</a></li>
					    <li><a class="dropdown-item" href="Passbook.jsp">Passboook</a></li>
					    <li><a class="dropdown-item" href="Update.jsp">Update your account</a></li>
					    <li><a class="dropdown-item" href="Reset.jsp">Reset pin</a></li>
					  </ul>
				</div>
				

			
        
       
       
       
       
       	 	<li class="nav-item ms-auto">
            	<div class="welcome" style="padding: 8px 15px;">
                	Welcome Admin  <%= c.getName() %>
            	</div>
       		</li>
        </ul>
        
        <%}else{ %>
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link" href="Deposite.jsp">Deposite</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="Transfer.jsp">Transfer Amount</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="Balance.jsp">Check Balance</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="Passbook.jsp">Passboook</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="Update.jsp">Update your account</a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link" href="Reset.jsp">Reset pin</a>
            </li>
       
        	<li class="nav-item ms-auto">
            	<div class="welcome" style="padding: 8px 15px;">
                Welcome <%= c.getName() %>
            	</div>
        	</li>
        </ul>
        
        <%} %>
       


        
    </div>
	<%} %>

    <div id="carouselExampleCaptions" class="carousel slide carousel-fade" data-bs-ride="carousel" data-bs-interval="2000">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="1.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Welcoome to PSBank</h5>
                    <p>India's No.1 Bank.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="2.jpg" class="d-block w-100 " alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Most trusted Bank</h5>
                    <p>Your money in trustfull hands.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="3.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Loan for lowest intrest</h5> 
                    <p>Making life easier.</p>
                </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
            data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
            data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <div class="container-fluid" id="footer">
        <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
            <div class="col-md-4 d-flex align-items-center">
                <a href="/" class="mb-3 me-2 mb-md-0 text-body-secondary text-decoration-none lh-1">
                    <svg class="bi" width="30" height="24">
                        <use xlink:href="#bootstrap"></use>
                    </svg>
                </a>
                <p>© 2024 Company, Inc</p>
            </div>

            <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
                <li class="ms-3"><a class="text-body-secondary" href="#"><i class="bi bi-twitter"></i></a></li>
                <li class="ms-3"><a class="text-body-secondary" href="#"><i class="bi bi-instagram"></i></a></li>
                <li class="ms-3"><a class="text-body-secondary" href="#"><i class="bi bi-facebook"></i></a></li>
            </ul>
        </footer>
    </div>
    <div class="b-example-divider"></div>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>
</body>

</html>