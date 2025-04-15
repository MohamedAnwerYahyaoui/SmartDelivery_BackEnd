package tn.esprit.Fournisseur.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.Fournisseur.Entity.Fournisseur;
import tn.esprit.Fournisseur.Repository.FournisseurRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FournisseurService {
    private final FournisseurRepository fr;
    private final JavaMailSender mailSender;

    public FournisseurService(FournisseurRepository fr, JavaMailSender mailSender) {
        this.fr = fr;
        this.mailSender = mailSender;
    }

    public Fournisseur ajouterFournisseur(Fournisseur fournisseur) {
        Fournisseur savedFournisseur = fr.save(fournisseur);
        sendConfirmationEmail(savedFournisseur);
        return savedFournisseur;
    }

    private void sendConfirmationEmail(Fournisseur fournisseur) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(fournisseur.getEmail());
            message.setSubject("Confirmation de création de compte fournisseur");

            String emailContent = "Bonjour " + fournisseur.getNomFournisseur() + ",\n\n" +
                    "Votre compte fournisseur a été créé avec succès.\n\n" +
                    "Détails du compte :\n" +
                    "Nom: " + fournisseur.getNomFournisseur() + "\n" +
                    "Adresse: " + fournisseur.getAdresse() + "\n" +
                    "Téléphone: " + fournisseur.getNumtel() + "\n\n" +
                    "Cordialement,\nL'équipe de support";

            message.setText(emailContent);

            mailSender.send(message);

            System.out.println("\n=== EMAIL ENVOYÉ AVEC SUCCÈS ===");
            System.out.println("À: " + fournisseur.getEmail());
            System.out.println("Sujet: Confirmation de création de compte fournisseur");
            System.out.println("Contenu:\n" + emailContent);
            System.out.println("===============================\n");
        } catch (Exception e) {
            System.err.println("\n!!! ERREUR D'ENVOI D'EMAIL !!!");
            System.err.println("À: " + fournisseur.getEmail());
            System.err.println("Erreur: " + e.getMessage());
            System.err.println("===============================\n");
        }
    }

    public ResponseEntity<byte[]> generateFournisseurPdf(long id) {
        try {
            Optional<Fournisseur> fournisseurOpt = fr.findById(id);
            if (fournisseurOpt.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            Fournisseur fournisseur = fournisseurOpt.get();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, baos);

            document.open();
            document.add(new Paragraph("Fiche Fournisseur"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Nom: " + fournisseur.getNomFournisseur()));
            document.add(new Paragraph("Adresse: " + fournisseur.getAdresse()));
            document.add(new Paragraph("Email: " + fournisseur.getEmail()));
            document.add(new Paragraph("Téléphone: " + fournisseur.getNumtel()));
            document.close();

            System.out.println("PDF généré avec succès pour le fournisseur ID: " + id);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=fournisseur_" + id + ".pdf")
                    .body(baos.toByteArray());
        } catch (Exception e) {
            System.err.println("Erreur lors de la génération du PDF: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    public List<Fournisseur> findAll() {
        return fr.findAll();
    }

    public Fournisseur updateFournisseur(long id, Fournisseur newFournisseur) {
        if (fr.findById(id).isPresent()) {
            Fournisseur fournisseur = fr.findById(id).get();
            fournisseur.setNomFournisseur(newFournisseur.getNomFournisseur());
            fournisseur.setAdresse(newFournisseur.getAdresse());
            fournisseur.setNumtel(newFournisseur.getNumtel());
            return fr.save(fournisseur);
        } else {
            return null;
        }
    }

    public String deleteFournisseur(long id) {
        if (fr.findById(id).isPresent()) {
            fr.deleteById(id);
            return "Fournisseur supprimé";
        } else {
            return "Fournisseur non supprimé";
        }
    }
    public ResponseEntity<byte[]> generateFournisseurExcel(long id) {
        try {
            Optional<Fournisseur> fournisseurOpt = fr.findById(id);
            if (fournisseurOpt.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            Fournisseur fournisseur = fournisseurOpt.get();
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Fournisseur");

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Champ");
            headerRow.createCell(1).setCellValue("Valeur");

            // Add data rows
            String[][] data = {
                    {"Nom", fournisseur.getNomFournisseur()},
                    {"Adresse", fournisseur.getAdresse()},
                    {"Email", fournisseur.getEmail()},
                    {"Téléphone", String.valueOf(fournisseur.getNumtel())} // Conversion en String
            };

            for (int i = 0; i < data.length; i++) {
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(data[i][0]);
                row.createCell(1).setCellValue(data[i][1]);
            }

            // Auto-size columns
            for (int i = 0; i < 2; i++) {
                sheet.autoSizeColumn(i);
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            workbook.write(baos);
            workbook.close();

            System.out.println("Excel généré avec succès pour le fournisseur ID: " + id);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=fournisseur_" + id + ".xlsx")
                    .body(baos.toByteArray());
        } catch (IOException e) {
            System.err.println("Erreur lors de la génération du Excel: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
    public Map<String, Object> getStatistiques() {
        Map<String, Object> stats = new HashMap<>();

        // Nombre total de fournisseurs
        long totalFournisseurs = fr.count();
        stats.put("totalFournisseurs", totalFournisseurs);

        // Répartition par région (supposons que l'adresse contient la région)
        List<Object[]> repartition = fr.countByRegion(); // Requête custom à implémenter

        Map<String, Long> repartitionMap = new HashMap<>();
        for (Object[] result : repartition) {
            repartitionMap.put((String) result[0], (Long) result[1]);
        }
        stats.put("repartitionParRegion", repartitionMap);

        System.out.println("Statistiques générées: " + stats);
        return stats;
    }
    public ResponseEntity<byte[]> generateFournisseurQRCode(long id) {
        try {
            Optional<Fournisseur> fournisseurOpt = fr.findById(id);
            if (fournisseurOpt.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            Fournisseur fournisseur = fournisseurOpt.get();
            String qrContent = String.format(
                    "Fournisseur: %s\nAdresse: %s\nEmail: %s\nTéléphone: %s",
                    fournisseur.getNomFournisseur(),
                    fournisseur.getAdresse(),
                    fournisseur.getEmail(),
                    fournisseur.getNumtel()
            );

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.MARGIN, 2);
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

            BitMatrix matrix = new QRCodeWriter().encode(
                    qrContent,
                    BarcodeFormat.QR_CODE,
                    200, 200, hints);

            MatrixToImageWriter.writeToStream(matrix, "PNG", baos);

            System.out.println("QR Code généré avec succès pour le fournisseur ID: " + id);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=fournisseur_qrcode_" + id + ".png")
                    .body(baos.toByteArray());

        } catch (Exception e) {
            System.err.println("Erreur génération QR Code: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}