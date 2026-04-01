# Authentication System (Login & Register)
## Overview

This is a full-stack authentication project featuring a login and user registration system, built with:

Front-end: React
Back-end: Spring Boot (REST API)
Authentication: HTTP Basic (Spring Security)

The goal of this project is to demonstrate a complete authentication flow, including data validation and client-server integration.

## Architecture
# Front-end (React)
- Single-page interface containing:
- Login form
- Register form
- State management using useState
- API communication via HTTP requests (fetch)

## Features
- Toggle between login and register forms
- Custom password validation component
- Displays password strength (strength meter)
- Visual feedback for API errors
- Loading state handling during requests
  
## Back-end (Spring Boot)
# General Setup
- RESTful API
- Layered architecture:
- Database integration (PostgreSQL)
  
# Security
- Implemented using Spring Security
- Authentication via HTTP Basic
- Secured endpoints
### Custom configuration for:
- UserDetailsService
- PasswordEncoder (BCrypt)

# Validation
- Back-end (Bean Validation)
- Annotations used
- Custom validations (if applicable)
- Global exception handling
- Standardized error responses (HTTP 400)
- Password validation handled on the client side:
- Minimum length
- Special characters
- Strength indicator

# Authentication Flow
- User registers an account
- Data is sent to the API
- Back-end validates and stores the user
- Credentials are sent via HTTP Basic
- Spring Security authenticates and grants access to protected endpoints

# API Endpoints (Example)
- Method	Endpoint	Description
- POST	/users/register	Register new user
- POST	/users/auth	Authenticate user
- GET	/users	Protected resource

# Error Handling
- 400 Bad Request → Validation errors
- 401 Unauthorized → Invalid credentials
- 409 Conflict → User already exists

## Tech Stack
# Front-end
- React
- JavaScript (ES6+)
- CSS / Styled Components (optional)
# Back-end
- Spring Boot
- Spring Security
- Bean Validation (Jakarta Validation)
- JPA / Hibernate
