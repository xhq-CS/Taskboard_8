# Homework 8 - Security and Final Enhancements

## Description

For Homework 8 I added the final backend improvements to the Campus Task Board API, it being security and final enhancements. The final version now includes Spring Security, CORS configuration, API versioning, Swagger/OpenAPI documentation, integration tests, and custom priority validation.

## New Features

- Spring Security configuration
- CORS setup
- API versioning with `/api/v1/tasks`
- Swagger/OpenAPI documentation
- Integration tests with MockMvc
- Custom priority validation
- Actuator health endpoint

## Security

The TaskBoard project now uses `SecurityConfig` to control endpoint access.

Endpoints:

```text
/api/tasks/
/api/v1/tasks/
/h2-console/
/actuator/
/swagger-ui/
/swagger-ui.html
/v3/api-docs/
```


## Complete API Documentation

The project uses Swagger/OpenAPI for API documentation.

Swagger UI:

http://localhost:8080/swagger-ui.html

Alternative Swagger URL:

http://localhost:8080/swagger-ui/index.html

Swagger shows:
- All available endpoints
- HTTP methods
- Request formats
- Response formats
- API schemas
- Error responses

## Main API Endpoints

### Task Endpoints

GET /api/tasks  
- Returns all active tasks.

POST /api/tasks  
- Creates a new task.

GET /api/tasks/{id}  
- Returns one task by ID.

PUT /api/tasks/{id}  
- Updates a task by ID.

DELETE /api/tasks/{id}  
- Soft deletes a task.

PUT /api/tasks/{id}/restore  
- Restores a soft-deleted task.

### Versioned API Endpoints

GET /api/v1/tasks  
- Returns all active tasks using v1 of the API.

POST /api/v1/tasks  
- Creates a task using v1 of the API.

GET /api/v1/tasks/{id}  
- Returns one task by ID using v1.

PUT /api/v1/tasks/{id}  
- Updates a task using v1.

DELETE /api/v1/tasks/{id}  
- Soft deletes a task using v1.

PUT /api/v1/tasks/{id}/restore  
- Restores a task using v1.

### Other Endpoints

GET /api/tasks/completed  
- Returns completed tasks.

GET /api/tasks/incomplete  
- Returns incomplete tasks.

GET /api/tasks/priority/{priority}  
- Returns tasks by priority.

GET /api/tasks/search?keyword={keyword}  
- Searches tasks by title or description.

GET /api/tasks/paginated?page=0&size=5&sortBy=title  
- Returns paginated and sorted tasks.

GET /actuator/health  
- Shows application health status.

## Error Responses

### 404 Not Found

GET /api/tasks/999

  "message": "Task with ID 999 not found",


### 400 Validation Error

POST /api/tasks

Response:

  "message": "Input validation failed",

## Deliverable Questions

How Spring Security works and how I implemented security (CORS, endpoint protection):
- Spring Security is responsible for determining which endpoints can be accessed without having to authenticate. In my case, I allowed endpoints such as task endpoints, versioned task endpoints, H2 Console, actuator health endpoint, Swagger UI, and OpenAPI documentation endpoints.
- I also disabled CSRF because this is a REST API being tested with Postman and Swagger. CORS is configured to allow requests from localhost:3000 and localhost:8080.

How API versioning works:
- The updated taskboard endpoints are /api/v1/tasks. Versioning an API is helpful because it allows adding more versions of the same API without affecting old routes. In this case, I am able to hit GET /api/v1/tasks, which gives me my tasks list.

One challenge you faced while working on the homework 8 project:
- Another issue that occurred was making sure Swagger worked correctly after including Spring Security. In this case, some routes in Swagger were blocked, and thus the documentation site wouldn't open. To fix this problem, I updated SecurityConfig to include Swagger UI and OpenAPI docs routes. 
- The takeaway from this experience is that whenever I add security to my application, I should keep in mind that each route used in the project should be allowed through. Security is helpful, yet it can prevent access to other necessary features.

One thing you learned about securing APIs and why it matters:
- One thing I learned about API security is that it doesn’t mean locking out users but regulating whether or not certain routes are supposed to be public or private. This matters because an API can include sensitive endpoints, development utilities, as well as database management consoles.
- If security is too permissive, the application will end up disclosing what it shouldn’t. But on the other hand, if security is too tight, it can lock out useful components such as Swagger UI, H2 Database Console, or even entry to the documentation.

Overall reflection on the homework series:
- Overall, the most useful thing I learned was how the different layers interacted and the responsibility of each layer. The taskcontroller receives requests, the taskservice performs operations on those taskrequests, the repository connects with the database, and the model defines the model. The only thing I wish to do differently while completing this assignment is doing tests for all the features earlier and updating the README file in each homework instead of leaving it last on my plate.
