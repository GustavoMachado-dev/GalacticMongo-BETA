package com.example.tomticketapi1.structure.application.controllers;

import com.example.tomticketapi1.structure.domain.usecases.update_cases.FastUpdateChamadosUseCase;
import com.example.tomticketapi1.structure.domain.usecases.update_cases.UpdateChamadosUseCase;
import com.example.tomticketapi1.structure.domain.usecases.upload_cases.UploadFirstPageOfChamadosUseCase;
import com.example.tomticketapi1.structure.domain.usecases.upload_cases.UploadLastTwoYearsUseCase;
import com.example.tomticketapi1.structure.dto.entitiesDTO.formatsDTO.UploadsResponseDTO;
import com.example.tomticketapi1.structure.logs.logservices.WriteInTxtLoggerDocument;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/chamados")
public class ChamadosControllers {
    /* DECLARACOES DE USE CASES :*/
    private final UploadFirstPageOfChamadosUseCase uploadFirstPageOfChamadosUseCase;
    private final UploadLastTwoYearsUseCase uploadLastTwoYearsUseCase;
    private final UpdateChamadosUseCase updateChamadosUseCase;
    private final FastUpdateChamadosUseCase fastUpdateChamadosUseCase;
    private final WriteInTxtLoggerDocument loggDocument;

    /**
     * Construtor da classe ChamadosControllers:     *
     * Inicializa os casos de uso responsáveis por capturar e atualizar os chamados
     * e o objeto de log para registrar mensagens de operação.
     * O construtor também registra no log a chamada de sua execução.
     *
     * @param uploadFirstPageOfChamadosUseCase Caso de uso responsável por capturar a primeira página de chamados da API.
     * @param uploadLastTwoYearsUseCase Caso de uso responsável por capturar os chamados criados nos últimos 2 anos.
     * @param updateChamadosUseCase Caso de uso responsável por atualizar os chamados armazenados.
     * @param loggDocument Objeto responsável por registrar logs em arquivos de texto.
     */
    public ChamadosControllers (UploadFirstPageOfChamadosUseCase uploadFirstPageOfChamadosUseCase,
                                UploadLastTwoYearsUseCase uploadLastTwoYearsUseCase,
                                UpdateChamadosUseCase updateChamadosUseCase,
                                WriteInTxtLoggerDocument loggDocument, FastUpdateChamadosUseCase fastUpdateChamadosUseCase) {
        this.uploadFirstPageOfChamadosUseCase = uploadFirstPageOfChamadosUseCase;
        this.uploadLastTwoYearsUseCase = uploadLastTwoYearsUseCase;
        this.updateChamadosUseCase = updateChamadosUseCase;
        this.loggDocument = loggDocument;

        loggDocument.logMessage("[CONTROLLER CONSTRUCTOR CALL] : ChamadosControllers() constructor was invoked.");
        this.fastUpdateChamadosUseCase = fastUpdateChamadosUseCase;
    }

    /**
     * Controller que realiza a operação de GET para capturar e armazenar
     * a primeira página de resposta da API.
     * O método registra no log o início e o fim do processo, indicando sucesso ou falha
     * na operação de upload dos dados para o banco MongoDB.
     *
     * @return UploadsResponseDTO contendo os dados capturados da primeira página da API.
     * Retorna null se a operação não retornar dados.
     *
     * @see UploadsResponseDTO
     */
    @Operation(description = "Controller realiza a operação de GET para capturar e armazenar a primeira pagina de resposta da API.")
    @GetMapping("/upload")
    @CrossOrigin(origins="*")
    public UploadsResponseDTO uploadChamados() {
        loggDocument.logMessage("[METHOD CALL] : uploadChamados() method was called.");
        UploadsResponseDTO uploadsResponseDTO = uploadFirstPageOfChamadosUseCase.run();

        if (uploadsResponseDTO != null) {
            loggDocument.logMessage("[SUCCESS] : uploadChamados() method processed successfully. Response returned.");
            loggDocument.logMessage("[END PROCESS - UPLOAD MONGO] : Successfully uploaded data to MongoDB.");
            return uploadsResponseDTO;
        } else {
            loggDocument.logMessage("[FAILURE] : uploadChamados() method failed. No data returned.");
            loggDocument.logMessage("[CLOSING PROCESS] : Upload process terminated with errors.");
            return null;
        }
    }

    /**
     * Controller que realiza a operação de GET para capturar e armazenar
     * todos os chamados criados nos últimos 2 anos na plataforma Tom Ticker via API.
     * O método registra no log o início e o fim do processo, indicando sucesso ou falha
     * na operação de upload dos dados para o banco MongoDB.
     *
     * @return UploadsResponseDTO contendo os dados capturados e armazenados dos chamados.
     * Retorna null se a operação não retornar dados.
     *
     * @see UploadsResponseDTO
     */

    @Operation(description = "Controller realiza a operação de GET para capturar e armazenar os chamados criados nos últimos 2 anos na plataforma Tom Ticker via API.")
    @GetMapping("/upload-data")
    @CrossOrigin(origins="*")
    public UploadsResponseDTO uploadChamadosByData() {
        loggDocument.logMessage("[METHOD CALL] : uploadChamadosByData() method was called.");

        UploadsResponseDTO uploadsResponseDTO = uploadLastTwoYearsUseCase.run();

        if (uploadsResponseDTO != null) {
            loggDocument.logMessage("[SUCCESS] : uploadChamadosByData() method processed successfully. Response returned.");
            loggDocument.logMessage("[END PROCESS - UPLOAD MONGO] : Successfully uploaded data for the last two years.");
            return uploadsResponseDTO;
        } else {
            loggDocument.logMessage("[FAILURE] : uploadChamadosByData() method failed. No data returned.");
            loggDocument.logMessage("[CLOSING PROCESS] : Upload process terminated with errors.");
            return null;
        }
    }

    /**
     * Controller que realiza a operação de GET para capturar, atualizar e armazenar
     * os chamados criados nos últimos 12 meses e que tiveram atualizações.
     * Se o chamado ainda não foi registrado no banco de dados, ele será inserido.
     * O método também registra no log a próxima execução do processo de atualização,
     * que está programada para ocorrer a cada 5 minutos.
     *
     * @return UploadsResponseDTO contendo os dados atualizados dos chamados.
     * Retorna null se não houver dados a serem processados.
     *
     * @see UploadsResponseDTO
     */

    @Operation(description = "Controller realiza a operação de GET para realizar a atualização nos chamados armazenados no banco de dados, inserindo chamados caso ainda não tenham sido registrados.")
    @GetMapping("/update")
    @CrossOrigin("*")
    // @Scheduled(cron = "0 */5 * * * *") // Executa a cada 5 minutos
    public UploadsResponseDTO updateChamados() {
        loggDocument.logMessage("[METHOD CALL] : updateChamados() method was called.");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextExecution = now.plusMinutes(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNextExecution = nextExecution.format(formatter);

        loggDocument.logMessage("[SCHEDULE] : Next update at " + formattedNextExecution);

        UploadsResponseDTO uploadsResponseDTO = updateChamadosUseCase.run();

        if (uploadsResponseDTO != null) {
            loggDocument.logMessage("[SUCCESS] : updateChamados() method processed successfully.");
            return uploadsResponseDTO;
        } else {
            loggDocument.logMessage("[FAILURE] : updateChamados() method failed. No data returned.");
            return null;
        }
    }

    @Operation(description = "Controller realiza a operação de GET para realizar a atualização nos chamados armazenados no banco de dados de forma rápida, o intervalo de atualização é menor, inserindo chamados caso ainda não tenham sido registrados.")
    @GetMapping("/fast-update")
    @CrossOrigin("*")
    // @Scheduled(cron = "0 */5 * * * *") // Executa a cada 5 minutos
    public UploadsResponseDTO fastUpdateChamados() {
        loggDocument.logMessage("[METHOD CALL] : updateChamados() method was called.");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextExecution = now.plusMinutes(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNextExecution = nextExecution.format(formatter);

        loggDocument.logMessage("[SCHEDULE] : Next update at " + formattedNextExecution);

        UploadsResponseDTO uploadsResponseDTO = fastUpdateChamadosUseCase.run();

        if (uploadsResponseDTO != null) {
            loggDocument.logMessage("[SUCCESS] : updateChamados() method processed successfully.");
            return uploadsResponseDTO;
        } else {
            loggDocument.logMessage("[FAILURE] : updateChamados() method failed. No data returned.");
            return null;
        }
    }
}