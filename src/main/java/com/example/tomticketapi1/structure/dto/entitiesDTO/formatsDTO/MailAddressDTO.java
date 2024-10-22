package com.example.tomticketapi1.structure.dto.entitiesDTO.formatsDTO;


import lombok.Getter;
import lombok.Setter;

/**
 * A classe MailAddressDTO representa um endereço de e-mail e as informações associadas para envio de mensagens.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class MailAddressDTO {
    private String emailAddress; // O endereço de e-mail
    private String subject; // O assunto do e-mail
    private String message; // O corpo da mensagem do e-mail

    /**
     * Construtor padrão que inicializa um MailAddressDTO vazio.
     */
    public MailAddressDTO() {}

    /**
     * Construtor que inicializa um MailAddressDTO com os parâmetros fornecidos.
     *
     * @param emailAdress O endereço de e-mail.
     * @param subject O assunto do e-mail.
     * @param message O corpo da mensagem do e-mail.
     */
    public MailAddressDTO(String emailAdress, String subject, String message) {
        this.emailAddress = emailAdress;
        this.subject = subject;
        this.message = message;
    }

    /**
     * Reseta os campos do MailAddressDTO para seus valores padrão.
     */
    public void defaulMailBody () {
        this.emailAddress = "";
        this.subject = "";
        this.message = "";
    }
}