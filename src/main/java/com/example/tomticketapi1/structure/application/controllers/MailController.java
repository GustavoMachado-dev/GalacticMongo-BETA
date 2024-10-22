package com.example.tomticketapi1.structure.application.controllers;

import com.example.tomticketapi1.structure.dto.entitiesDTO.formatsDTO.MailAddressDTO;
import com.example.tomticketapi1.structure.logs.logservices.WriteInTxtLoggerDocument;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import com.example.tomticketapi1.structure.logs.logservices.SendTxtLogsToEmail;
import org.springframework.beans.factory.annotation.Autowired;

@RestController

@RequestMapping("/mail")
public class MailController {

    private final SendTxtLogsToEmail sendTxtLogsToEmail;
    private final WriteInTxtLoggerDocument loggDocument;

    @Autowired
    public MailController(SendTxtLogsToEmail sendTxtLogsToEmail, WriteInTxtLoggerDocument loggDocument) {
        this.sendTxtLogsToEmail = sendTxtLogsToEmail;
        this.loggDocument = loggDocument;
        loggDocument.logMessage("[CONSTRUCTOR CALL] : Mail Controller constructor was invoked.");
    }

    /**
     * Controller que realiza a operação de POST para enviar logs por e-mail:
     * O método recebe um objeto {@link MailAddressDTO} contendo o endereço de e-mail,
     * o assunto e a mensagem. Caso algum desses campos esteja nulo ou vazio,
     * o método {@code defaulMailBody()} é chamado para definir um conteúdo padrão.
     * O envio dos logs é realizado utilizando o serviço {@code sendTxtLogsToEmail}.
     *
     * @param mailAddressDTO Objeto contendo os dados do e-mail, incluindo endereço, assunto e mensagem.
     * @return String indicando o resultado do envio do e-mail com os logs.
     */
    @PostMapping("/sendLogs")
    @CrossOrigin("*")
    @Operation(description = "Realiza envio de logs gerados para o email informado e deleta o histórico de logs.")
    public String sendLogsEmail(@RequestBody MailAddressDTO mailAddressDTO) {
        // Verificação de nulo e vazio para campos
        if (mailAddressDTO.getEmailAddress() == null || mailAddressDTO.getEmailAddress().isEmpty() ||
                mailAddressDTO.getSubject() == null || mailAddressDTO.getSubject().isEmpty() ||
                mailAddressDTO.getMessage() == null || mailAddressDTO.getMessage().isEmpty()) {
            mailAddressDTO.defaulMailBody(); // Chama o método default se algum campo estiver vazio ou nulo
        }

        loggDocument.logMessage("[SUCESS] : Email was sucefully sent.");
        return sendTxtLogsToEmail.sendMailWithLogs(
                mailAddressDTO.getEmailAddress(),
                mailAddressDTO.getSubject(),
                mailAddressDTO.getMessage()
        );
    }
}
