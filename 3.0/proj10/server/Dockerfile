FROM golang:1.18 AS build

WORKDIR /app

COPY go.mod go.sum ./
RUN go mod download

COPY . .

RUN go build -o myapp

FROM golang:1.18

COPY --from=build /app/myapp /app/myapp

EXPOSE 8000

WORKDIR /app
CMD ["./myapp"]
