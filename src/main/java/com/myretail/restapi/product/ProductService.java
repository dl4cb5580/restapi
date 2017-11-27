package com.myretail.restapi.product;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/products")
public class ProductService {
	
	private ProductDAO productDAO = null;
	private ProductUtil productUtil = null;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(@PathParam("id") Integer productId) {
		String productName = null;
		productDAO = new ProductDAO();
		try {
			Price productPrice = productDAO.getProductPrice(productId);
			if(productPrice != null) {
				productUtil = new ProductUtil();
				productName = productUtil.getProductName(productId);
			} else {
				return Response.status(500).entity(new CustomMessage("FAILURE","PRODUCT_NOT_FOUND","Product Not Found")).build();
			}
			return Response.status(200).entity(new Product(productId, productName, productPrice)).build();
		} catch(Exception exp) {
			exp.printStackTrace();
			return Response.status(500).entity(new CustomMessage("FAILURE","GET_PRODUCT_ERROR","Error While Fetching Product")).build();
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProduct(@PathParam("id") Integer productId, Product product) {
		try {
			Boolean productPriceUpdated = new ProductDAO().updateProductPrice(productId, product.getCurrent_price());
			if(!productPriceUpdated) {
				return Response.status(500).entity(new CustomMessage("FAILURE","PRODUCT_NOT_EXISTS","Product Not Exists")).build();
			}
			return Response.status(200).entity(product).build();
		} catch(Exception exp) {
			exp.printStackTrace();
			return Response.status(500).entity(new CustomMessage("FAILURE","UPDATE_PRODUCT_ERROR","Error While Updating Product")).build();
		}
	}

}
