import { sendReservationEmail } from "../services/emailService.js"

export const sendEmail = async (req, res) => {
  try {
    const { to, subject, text } = req.body

    console.log("Received email request:", { to, subject })

    await sendReservationEmail(to, subject, text)

    return res.status(200).json({ message: "Email envoyé avec succès" })
  } catch (error) {
    console.error("Error sending email:", error)
    return res.status(500).json({
      message: "Erreur lors de l'envoi de l'email",
      error: error.message,
    })
  }
}
