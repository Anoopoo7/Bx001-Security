<h1 align="center">
  <img src="https://i.ibb.co/tmD6cTV/bx001-logo.png" alt="Your Project Logo" width="200">
  <br>
  Bx001 Security System
</h1>

<p align="center">
  <a href="https://github.com/Anoopoo7/Bx001-Security">
    <img src="https://img.shields.io/github/stars/Anoopoo7/Bx001-Security?style=for-the-badge" alt="GitHub stars">
  </a>
  <a href="https://github.com/Anoopoo7/Bx001-Security/issues">
    <img src="https://img.shields.io/github/issues/Anoopoo7/Bx001-Security?style=for-the-badge" alt="GitHub issues">
  </a>
  <a href="https://github.com/Anoopoo7/Bx001-Security/network">
    <img src="https://img.shields.io/github/forks/Anoopoo7/Bx001-Security?style=for-the-badge" alt="GitHub forks">
  </a>
  <a href="https://github.com/Anoopoo7/Bx001-Security/LICENSE">
    <img src="https://img.shields.io/github/license/Anoopoo7/Bx001-Security?style=for-the-badge" alt="GitHub license">
  </a>
</p>

<p align="center">
  <strong>Fast, Secure, and Minimalist Web Security System.</strong>
  <br>
  Experience robust web security with our Java Spring Boot-based system. Utilizing bearer token authentication, our system ensures data security without storing sensitive information. It's a blazing-fast, easy-to-use, and microservices-based solution for safeguarding your web applications.
</p>

---

<p align="center">
  <img src="https://i.ibb.co/5WCqC6B/bx001-image.png" alt="Project Screenshot">
</p>

---

## Features

- <b>Bearer Token Authentication </b>: Enhancing security by ensuring that only authorized users with valid tokens can access protected     resources. This authentication method offers robust protection against unauthorized access.<br/><br/>
- <b>No Data Storage</b>: Unlike traditional systems, our solution does not store sensitive user data, providing an additional layer of privacy and security. User data is validated and processed in real-time, minimizing the risk of data breaches and ensuring compliance with data protection regulations.<br/><br/>
- <b>High Performance Microservices</b>: Built on a microservices architecture, our system delivers exceptional performance and scalability. Each microservice is designed for a specific function, enabling rapid response times and efficient resource utilization. This architecture ensures your web applications can handle increasing workloads with ease.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

1. Clone the repository:
```bash
git clone https://github.com/Anoopoo7/Bx001-Security.git
```
2. Install dependencies:
```bash
 mvn clean install
```
3. Start the application:
```bash
 java -jar target/bx001-security.jar
```

## Configuration

Open the `application.yml` file located in the `src/main/resources` directory.

Configure the application by modifying the properties in the `application.yml` file as needed. Here's an explanation of the key properties:

- `server.port`: The port on which the application will run.
- `custom.baseUrl`: The base URL for external services or APIs.
- `custom.verifyUser`: The path for verifying user data.
- `custom.anonymusUser`: The path for anonymous user data.
- `custom.token.fields`: Fields required for token validation.
- `custom.token.secret`: The secret key for token generation and validation.
- `custom.token.refreshInterval`: The token refresh interval in seconds.
- `custom.token.accessInterval`: The token access interval in seconds.

## Usage

- Create an API for fetching logged and Anonymus User information by unique fields and that end point can be used as <b>verifyUser</b> end point.<br/>
It should be functional for feching user data. Token will be generated with this API response.
- Token fields should be configured in <b>fields</b>.
- For more information https://crosscodeblogs.netlify.app/blog/bx001

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

- Hat tip to anyone whose code was used.
- Inspiration.
- etc.

---

<p align="center">
  <a href="https://github.com/Anoopoo7">
    <img src="https://img.shields.io/badge/Visit%20My%20GitHub-Anoopoo7-333?style=for-the-badge&logo=github" alt="GitHub profile">
  </a>
</p>
