<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="./base.jsp"%>
</head>
<body>
	<div class="container mt-3 ">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Fill the product detail</h1>
				<form action="handle-product" method="post">
					<div class="form-group">
						<label for="name">Product Name</label> <input name="name"
							type="text" class="form-control" id="name"
							aria-describedby="emailHelp"
							placeholder="Enter the product name here">
					</div>
					<div class="form-group ">
						<label for="description">Product Description</label>
						<textarea name="description" class="form-control" id="description"
							rows="5" placeholder="Enter the product description"></textarea>
					</div>
					<div class="form-group ">
						<label for="price">Product Price</label> <input name="price"
							type="text" class="form-control" id="price"
							aria-describedby="emailHelp" placeholder="Enter Product Price">
					</div>
					<div class="container text-center">
						<a href="${pageContext.request.contextPath }/"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-primary">Add</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>