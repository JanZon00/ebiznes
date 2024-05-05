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

	if err := router.Run(":8000"); err != nil {
		panic(err)
	}
}
