import express from "express"
import dotenv from "dotenv"
import emailRoutes from "./routes/emailRoutes.js"

// Load environment variables
dotenv.config()

// Set environment variables manually if they're not loaded from .env
if (!process.env.MAIL_USERNAME) {
  process.env.PORT = "8081"
  process.env.MAIL_HOST = "smtp.gmail.com"
  process.env.MAIL_PORT = "587"
  process.env.MAIL_USERNAME = "atefmannai22@gmail.com"
  process.env.MAIL_PASSWORD = "dpik vqhx lpjl tntu"
  process.env.MAIL_FROM = "atefmannai22@gmail.com"
}

// Debug environment variables
console.log("Environment variables:")
console.log("PORT:", process.env.PORT)
console.log("MAIL_HOST:", process.env.MAIL_HOST)
console.log("MAIL_USERNAME:", process.env.MAIL_USERNAME ? "Set (hidden)" : "Not set")
console.log("MAIL_PASSWORD:", process.env.MAIL_PASSWORD ? "Set (hidden)" : "Not set")

const app = express()
const PORT = process.env.PORT || 8081

// Middleware
app.use(express.json())

// Routes
app.use("/mail", emailRoutes)

// Start server
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`)
})
