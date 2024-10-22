package com.example.tomticketapi1.structure.domain.usecases.usecases_configs;

import com.example.tomticketapi1.structure.infraestructure.config.TomToken;

/**
 * A classe ConfigAcess é responsável por gerenciar o acesso ao token da API.
 * Ela encapsula a lógica para obter a chave de acesso necessária para interagir com a API.
 */
@SuppressWarnings("unused")
public class ConfigAcess {
    private final TomToken acessToken = new TomToken();

    /**
     * Construtor da classe ConfigAcess.
     * Inicializa uma nova instância de TomToken para gerenciar o acesso.
     */
    public ConfigAcess() { }

    /**
     * Obtém a chave de acesso da API.
     *
     * @return A chave de acesso como uma String.
     */
    public String getAcess() {
        return acessToken.getApiKey();
    }
}