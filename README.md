🎮 Tic Tac Toe Game (Spring Boot)
This is a configurable Tic Tac Toe game implemented with Java Spring Boot.
It supports arbitrary board sizes (e.g. 3×3, 5×5) and exposes a REST API with Swagger for easy testing.

🚀 How to Run

📦 1. Prerequisites

✅ Java 17 or higher
✅ Maven 3.8+

⚙️ 2. Set up and run the project
From the project root folder, open terminal and run:

bash
Copy
Edit
mvn clean spring-boot:run
Or, if you prefer to build first:

bash
Copy
Edit
mvn clean package
java -jar target/tic-tac-toe-1.0.0.jar

🌐 3. Test the API
Once the app is running, open this URL in your browser:
👉 http://localhost:8080/swagger-ui/index.html

You can use the Swagger UI to test the Tic Tac Toe API endpoints, such as:

Create a new game

Make a move

Check game state

📄 Endpoints
Method	    Endpoint	                Description
POST	    /api/game/create?size=3	    Create a new game (size×size)
POST	    /api/game/{gameId}/move	    Make a move
GET	        /api/game/{gameId}	        Get game state

👨‍💻 Notes
✅ The board is configurable — pass the size parameter when creating a game.
✅ Responses include the current board state, current player, and winner (if any).
✅ Swagger UI is enabled by default for easy testing.