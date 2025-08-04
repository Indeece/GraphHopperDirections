# 🚗 GraphHopper Directions Microservice

A simple Spring Boot microservice that interacts with the [GraphHopper Routing API](https://graphhopper.com/) to calculate routes based on a list of points (latitude, longitude), with optional parameters like profile, locale, and elevation.

## 📦 Features

- Calculates distance and estimated travel time between multiple points
- Supports different travel profiles: `car`, `bike`, `foot`, etc.
- Optional settings: language (locale), elevation data

## 🔧 Requirements

- Java 17 or newer
- Maven
- A [GraphHopper API key](https://graphhopper.com/#signup)
- Internet access (to call the GraphHopper API)

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/graphhopper-directions.git
cd graphhopper-directions
```

### 2. Setup .env File
Create a .env file in the project root:

```bash
GRAPHOPPER_API_KEY=your_actual_graphhopper_api_key
```

### 3. Build and Run the Application

```bash
./mvnw spring-boot:run
```

### API Usage

Endpoint
POST /api/route

Request Body

```bash
{
  "points": [
    { "latitude": "52.5170365", "longitude": "13.3888599" },
    { "latitude": "52.529407", "longitude": "13.397634" }
  ],
  "profile": "car",
  "locale": "en",
  "elevation": "false"
}
```

Response

```bash
{
  "distance": 1987.3,
  "time": 234000
}
```

distance: in meters

time: in milliseconds

### Tech Stack
- Java 21
- Spring Boot
- OkHttp
- GraphHopper Routing API
- dotenv-java (for API key loading)

### Example Use Cases
- Delivery routing
- Navigation assistants
- Distance estimations in booking apps
- Route analysis tools
