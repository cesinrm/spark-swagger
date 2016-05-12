package me.serol.spark_swagger.route;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import me.serol.spark_swagger.model.ApiError;
import me.serol.spark_swagger.model.User;
import spark.Request;
import spark.Response;
import spark.Route;

@Api
@Path("/user")
@Produces("application/json")
public class CreateUserRoute implements Route {

	@POST
	@ApiOperation(value = "Creates a new user", nickname="CreateUserRoute")
	@ApiImplicitParams({ //
			@ApiImplicitParam(required = true, dataType="string", name="auth", paramType = "header"), //
			@ApiImplicitParam(required = true, dataType = "me.serol.spark_swagger.route.request.CreateUserRequest", paramType = "body") //
	}) //
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success", response=User.class), //
			@ApiResponse(code = 400, message = "Invalid input data", response=ApiError.class), //
			@ApiResponse(code = 401, message = "Unauthorized", response=ApiError.class), //
			@ApiResponse(code = 404, message = "User not found", response=ApiError.class) //
	})
	public User handle(@ApiParam(hidden=true) Request request, @ApiParam(hidden=true)Response response) throws Exception {
		return new User();
	}

}
