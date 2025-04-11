import nodemailer from "nodemailer"

// Create reusable transporter object using SMTP transport
const createTransporter = () => {
  console.log("Creating email transporter with settings:")
  console.log("Host:", process.env.MAIL_HOST || "smtp.gmail.com")
  console.log("Port:", process.env.MAIL_PORT || 587)

  return nodemailer.createTransport({
    host: process.env.MAIL_HOST || "smtp.gmail.com",
    port: Number.parseInt(process.env.MAIL_PORT || "587"),
    secure: false, // true for 465, false for other ports
    auth: {
      user: process.env.MAIL_USERNAME,
      pass: process.env.MAIL_PASSWORD,
    },
    tls: {
      rejectUnauthorized: false,
    },
  })
}

export const sendReservationEmail = async (to, subject, body) => {
  try {
    const transporter = createTransporter()

    // Send mail with defined transport object
    const info = await transporter.sendMail({
      from: process.env.MAIL_FROM || '"Your Name" <your-email@gmail.com>',
      to,
      subject,
      text: body,
    })

    console.log("Message sent: %s", info.messageId)
    return info
  } catch (error) {
    console.error("Error in sendReservationEmail:", error)
    throw new Error("Erreur lors de l'envoi de l'email: " + error.message)
  }
}
