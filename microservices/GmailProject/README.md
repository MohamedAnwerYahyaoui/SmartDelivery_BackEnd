# Microservice Mailing

Service d'envoi d'emails basé sur Node.js avec intégration SMTP (Gmail) et API RESTful.

## 🌟 Fonctionnalités
- Envoi d'emails via SMTP (Gmail)
- API REST sécurisée


## 🛠 Stack Technique
| Composant          | Technologie           |
|--------------------|-----------------------|
| Runtime            | Node.js 18+           |
| Framework          | Express.js 4.x        |
| SMTP Client        | Nodemailer 6.x        |
| Template Engine    | Handlebars 4.x        |
| Queue System       | Bull 4.x              |
| Base de données    | MongoDB (logs)        |

🔧 Configuration SMTP/Gmail
mailer.config.js :

javascript

module.exports = {
  host: process.env.SMTP_HOST,
  port: process.env.SMTP_PORT,
  secure: false, // true pour le port 465
  auth: {
    user: process.env.SMTP_USER,
    pass: process.env.SMTP_PASS
  },
  tls: {
    rejectUnauthorized: false // Pour les environnements de dev
  }
}
Important : Pour Gmail, vous devez :

Activer "Less secure apps" OU

Utiliser un Mot de passe d'application

Configurer le 2FA si ce n'est pas déjà fait


services:
  mailing-service:
    build: .
    ports:
      - "3000:3000"
    environment:
      - SMTP_HOST=smtp.gmail.com
      - SMTP_USER=${GMAIL_USER}
      - SMTP_PASS=${GMAIL_APP_PASSWORD}
      - REDIS_URL=redis://redis:6379
    depends_on:
      - redis
      - mongo

  redis:
    image: redis:alpine

json

"dependencies": {
  "express": "^4.18.2",
  "nodemailer": "^6.9.1",
  "handlebars": "^4.7.7",
  "bull": "^4.10.2",
  "mongoose": "^7.0.3",
  "dotenv": "^16.0.3",
  "jsonwebtoken": "^9.0.0"
}
🔐 Sécurité
Protection des endpoints :

javascript

const jwt = require('jsonwebtoken');

router.post('/api/emails', (req, res) => {
  const token = req.headers.authorization?.split(' ')[1];
  if (!token) return res.sendStatus(401);
  
  try {
    jwt.verify(token, process.env.JWT_SECRET);
    // Process email...
  } catch (err) {
    res.sendStatus(403);
  }
});
Environment Variables :

env

JWT_SECRET=votre_super_secret
RATE_LIMIT=100 # emails/heure
📊 Suivi des Emails
Middleware de tracking :

javascript

router.get('/track/:id.png', (req, res) => {
  EmailStats.trackOpen(req.params.id);
  res.sendFile('pixel.png', { root: './assets' });
});
⚠ Bonnes Pratiques
Gmail Limitations :

500 emails/jour (compte standard)

24h suspension si limite dépassée

Préférer un service professionnel (SendGrid, Mailgun) en production

Queue Management :

javascript

const emailQueue = new Bull('email', process.env.REDIS_URL);

emailQueue.process(async (job) => {
  await sendEmail(job.data);
});

// Ajouter à la queue
emailQueue.add({
  to: 'client@example.com',
  subject: 'Votre commande',
  html: '<p>Merci !</p>'
});
📄 License
MIT License



Ce README contient :
1. La configuration complète pour Gmail SMTP
2. Un système de templates et file d'attente
3. La sécurisation des endpoints
4. Le suivi des ouvertures
5. La configuration Docker optimisée

Personnalisations possibles :
- Ajouter des webhooks de notification
- Intégrer un service d'email transactionnel professionnel
- Ajouter des tests automatisés