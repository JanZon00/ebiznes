package main

import (
	"net/http"
	"strconv"

	"github.com/labstack/echo/v4"
)

type Product struct {
	ID   int    `json:"id"`
	Name string `json:"name"`
}

var (
	products = map[int]*Product{}
	seq      = 1
)

func CreateProduct(c echo.Context) error {
	p := &Product{
		ID: seq,
	}
	if err := c.Bind(p); err != nil {
		return err
	}

	products[p.ID] = p
	seq++
	return c.JSON(http.StatusCreated, p)
}

func GetProduct(c echo.Context) error {
	id := c.Param("id")
	if product, ok := products[toInt(id)]; ok {
		return c.JSON(http.StatusOK, product)
	}
	return c.NoContent(http.StatusNotFound)
}

func UpdateProduct(c echo.Context) error {
	p := new(Product)
	if err := c.Bind(p); err != nil {
		return err
	}

	id := c.Param("id")
	if _, ok := products[toInt(id)]; ok {
		p.ID = toInt(id)
		products[p.ID] = p
		return c.JSON(http.StatusOK, p)
	}
	return c.NoContent(http.StatusNotFound)
}

func DeleteProduct(c echo.Context) error {
	id := c.Param("id")
	if _, ok := products[toInt(id)]; ok {
		delete(products, toInt(id))
		return c.NoContent(http.StatusNoContent)
	}
	return c.NoContent(http.StatusNotFound)
}

func main() {
	e := echo.New()

	e.POST("/products", CreateProduct)
	e.GET("/products/:id", GetProduct)
	e.PUT("/products/:id", UpdateProduct)
	e.DELETE("/products/:id", DeleteProduct)

	e.Logger.Fatal(e.Start(":8080"))
}

func toInt(s string) int {
	id, _ := strconv.Atoi(s)
	return id
}
