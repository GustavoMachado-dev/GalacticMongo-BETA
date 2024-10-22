package com.example.tomticketapi1.structure.logs.logservices;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * O serviço SendTxtLogsToEmail é responsável por enviar e-mails com
 * arquivos de log em anexo. Os arquivos são coletados do diretório
 * histórico e enviados para o destinatário especificado.
 */
@Service
public class SendTxtLogsToEmail {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    private static final String HISTORY_DIRECTORY = Paths.get(System.getProperty("user.dir"), "TomTicket-api1", "src", "main", "java", "com", "example", "tomticketapi1", "structure", "logs", "logdocuments", "historico").toString();

    /**
     * Construtor que inicializa o JavaMailSender.
     *
     * @param javaMailSender o JavaMailSender a ser usado para enviar e-mails.
     */
    public SendTxtLogsToEmail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * Envia um e-mail com logs anexados.
     *
     * @param destiny o e-mail do destinatário.
     * @param subject o assunto do e-mail.
     * @param message a mensagem do e-mail.
     * @return uma String informando o resultado do envio do e-mail.
     */
    public String sendMailWithLogs(String destiny, String subject, String message) {
        try {
            // Cria a mensagem com suporte a anexos
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom(from);  // E-mail do remetente
            helper.setTo(destiny);
            helper.setSubject(subject);
            helper.setText(message);

            // Adiciona os arquivos da pasta "histórico" como anexos
            File historyDir = new File(HISTORY_DIRECTORY);
            if (historyDir.exists() && historyDir.isDirectory()) {
                File[] logFiles = historyDir.listFiles((dir, name) -> name.endsWith(".txt"));

                if (logFiles != null && logFiles.length > 0) {
                    for (File logFile : Objects.requireNonNull(logFiles)) {
                        helper.addAttachment(logFile.getName(), logFile);
                    }
                } else {
                    return "Nenhum arquivo de log foi encontrado na pasta de histórico.";
                }
            } else {
                return "O diretório de histórico não existe ou não é um diretório válido.";
            }

            // Envia o e-mail com os anexos
            javaMailSender.send(mimeMessage);

            // Após o envio bem-sucedido, exclui os arquivos da pasta histórico
            for (File logFile : Objects.requireNonNull(historyDir.listFiles((dir, name) -> name.endsWith(".txt")))) {
                if (!logFile.delete()) {
                    return "E-mail enviado, mas houve um erro ao excluir o arquivo: " + logFile.getName();
                }
            }

            return "E-mail enviado com sucesso para " + destiny;
        } catch (Exception e) {
            return "Erro ao enviar mensagem: " + e.getLocalizedMessage();
        }
    }
}