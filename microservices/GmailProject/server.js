import express from "express"
import dotenv from "dotenv"
import emailRoutes from "./routes/emailRoutes.js"
import { Eureka } from "eureka-js-client"

// Load environment variables
dotenv.config()

// Set environment variables manually if they're not loaded from .env
if (!process.env.MAIL_USERNAME) {
  process.env.PORT = "8094"
  process.env.MAIL_HOST = "smtp.gmail.com"
  process.env.MAIL_PORT = "587"
  process.env.MAIL_USERNAME = "atefmannai22@gmail.com"
  process.env.MAIL_PASSWORD = "dpik vqhx lpjl tntu"
  process.env.MAIL_FROM = "atefmannai22@gmail.com"
}

// Define PORT early
const PORT = process.env.PORT || 8094

// Debug env
console.log("Environment variables:")
console.log("PORT:", PORT)
console.log("MAIL_HOST:", process.env.MAIL_HOST)
console.log("MAIL_USERNAME:", process.env.MAIL_USERNAME ? "Set (hidden)" : "Not set")
console.log("MAIL_PASSWORD:", process.env.MAIL_PASSWORD ? "Set (hidden)" : "Not set")

const app = express()

// Middleware
app.use(express.json())

// Routes
app.use("/mail", emailRoutes)

// Health check route for Eureka
app.get("/info", (req, res) => {
  res.status(200).json({ status: "UP" })
})

// Eureka client config
const client = new Eureka({
  instance: {
    app: 'email-service',
    hostName: 'localhost',
    ipAddr: '127.0.0.1',
    port: {
      $: parseInt(PORT),
      '@enabled': true,
    },
    vipAddress: 'email-service',
    statusPageUrl: `http://localhost:${PORT}/info`,
    dataCenterInfo: {
      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
      name: 'MyOwn',
    },
  },
  eureka: {
    host: 'localhost',
    port: 8076,
    servicePath: '/eureka/apps/',
  },
})

// Start server and register with Eureka
app.listen(PORT, () => {
  console.log(`✅ Server running on port ${PORT}`)

  client.start((error) => {
    if (error) {
      console.error("❌ Eureka registration error:", error)
    } else {
      console.log("✅ Successfully registered with Eureka!")
    }
  })
})
