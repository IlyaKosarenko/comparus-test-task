package comparus.test.task.endpoint;

import comparus.test.task.entity.User;
import comparus.test.task.service.UserOrmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserEndpoint {

    private final UserOrmService userOrmService;

    public UserEndpoint(UserOrmService userOrmService) {
        this.userOrmService = userOrmService;
    }

    @Operation(summary = "Get users from DBs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found users from DBs",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) })}
           )
    @GetMapping("/users")
    public List<User> getUsers() {
        return userOrmService.getAllUsers();
    }
}
