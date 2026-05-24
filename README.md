# Homework 8 - Security and Final Enhancements

## Description

Homework 8 adds final backend improvements to the Campus Task Board API.  
This version includes Spring Security, CORS configuration, API versioning, Swagger/OpenAPI documentation, integration tests, and custom priority validation.

## New Features

- Spring Security configuration
- CORS setup
- API versioning with `/api/v1/tasks`
- Swagger/OpenAPI documentation
- Integration tests with MockMvc
- Custom priority validation
- Actuator health endpoint

## Security

The project uses `SecurityConfig` to control endpoint access.

Allowed endpoints:

```text
/api/tasks/**
/api/v1/tasks/**
/h2-console/**
/actuator/**
/swagger-ui/**
/swagger-ui.html
/v3/api-docs/**