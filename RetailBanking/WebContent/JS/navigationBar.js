document.querySelector("header").innerHTML=`<nav>
			<ul>
				<label class="logo">Coders Bank</label>
				<li><a href="Welcome.jsp">Home</a></li>
				<li onclick="myFunction(0)" id="btn">Customer Management
					<div id="myDropdown0" class="dropdown-content">
						<a href="CustomerCreate.jsp">Create Customer</a> 
						<a href="SearchCustomer_Update.jsp">Update Customer</a> 
						<a href="SearchCustomer_Delete.jsp">Delete Customer</a>
					</div>
				</li>
				<li onclick="myFunction(1)" id="btn">Account Management
					<div id="myDropdown1" class="dropdown-content">
						<a href="AccountCreate.jsp">Create Account</a> 
						<a href="SearchAccount_Delete.jsp">Delete Account</a>
					</div>
				</li>
				<li onclick="myFunction(2)" id="btn">Status Details
					<div id="myDropdown2" class="dropdown-content">
						<a href="Status_Account.jsp">Account Status</a> 
						<a href="CustomerStatus.jsp">Customer Status</a>
					</div>
				</li>
				<li onclick="myFunction(3)" id="btn">Account Operations
					<div id="myDropdown3" class="dropdown-content">
						<a href="Search_Deposit.jsp">Deposit</a> 
						<a href="Search_Withdraw.jsp">Withdraw</a> 
						<a href="Search_Transfer.jsp">Transfer</a>
						<a href="ExportTransactions.jsp">Account Statement</a>
					</div>
				</li>
				<li><a href="Logout.jsp">logout</a></li>
			</ul>
		</nav>`;