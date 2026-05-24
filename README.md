# Homework 8 - Security and Final Enhancements

## Description

For Homework 8 I added the final backend improvements to the Campus Task Board API, it being security and final enhancements.  
The final version now includes Spring Security, CORS configuration, API versioning, Swagger/OpenAPI documentation, integration tests, and custom priority validation.

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
