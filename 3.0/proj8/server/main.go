package main

import (
	"net/http"

	"github.com/gin-contrib/cors"
	"github.com/gin-gonic/gin"
)

type Product struct {
	Fruit string `json:"fruit"`
	Price string `json:"price"`
}

type User struct {
	Username string `json:"username"`
	Password string `json:"password"`
}

var users = []User{
	{Username: "user1", Password: "pass1"},
	{Username: "user2", Password: "pass2"},
}

var products = []Product{
	{Fruit: "Apple", Price: "1.20"},
	{Fruit: "Banana", Price: "0.90"},
	{Fruit: "Peach", Price: "3.50"},
	{Fruit: "Pear", Price: "2.00"},
	{Fruit: "Avocado", Price: "1.50"},
}

var requestData Product

func main() {
	router := gin.Default()

	config := cors.DefaultConfig()
	config.AllowOrigins = []string{"http://localhost:3000"}
	router.Use(cors.New(config))

	router.GET("/api/products", func(c *gin.Context) {
		c.JSON(http.StatusOK, products)
	})

	router.GET("/api/data", func(c *gin.Context) {
		c.JSON(http.StatusOK, requestData)
	})

	router.POST("/api/data", func(c *gin.Context) {
		if err := c.BindJSON(&requestData); err != nil {
			c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
			return
		}

		c.JSON(http.StatusOK, requestData)
	})

	router.POST("/api/login", func(c *gin.Context) {
		var loginData User
		if err := c.BindJSON(&loginData); err != nil {
			c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
			return
		}

		for _, user := range users {
			if user.Username == loginData.Username && user.Password == loginData.Password {
				c.JSON(http.StatusOK, gin.H{"status": "success"})
				return
			}
		}

		c.JSON(http.StatusUnauthorized, gin.H{"status": "failed", "message": "Invalid username or password"})
	})

	router.Run(":8000")
}
