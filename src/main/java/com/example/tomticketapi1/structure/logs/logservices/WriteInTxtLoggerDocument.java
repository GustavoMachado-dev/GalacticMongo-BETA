package com.example.tomticketapi1.structure.logs.logservices;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Getter
@Setter
@Component
public class WriteInTxtLoggerDocument {
    /**
     * O objeto {@code writer} é responsável por escrever as mensagens no arquivo de log.
     * Ele é instanciado dentro do método {@code createLogFile()} e utilizado no método
     * {@code logMessage()} para registrar as mensagens de log.
     * Através do {@code FileWriter}, o conteúdo é escrito diretamente no arquivo de texto,
     * com a opção de append para não sobrescrever o arquivo existente.
     */
    private FileWriter writer;

    /**
     * A variável {@code fileName} armazena o nome do arquivo de log atual. O nome do arquivo
     * é gerado dinamicamente no método {@code createLogFile()} com base na data atual, no
     * formato "log_dd-MM-yyyy.txt". Esse nome é utilizado tanto para criar quanto para abrir
     * o arquivo de log correspondente ao dia.
     */
    private String fileName;

    /**
     * A variável {@code currentDate} armazena a data atual no formato {@code LocalDate}.
     * Ela é usada para verificar quando o dia muda, e assim garantir que um novo arquivo
     * de log seja criado para cada dia, evitando que logs de diferentes dias sejam
     * registrados no mesmo arquivo.
     */
    private LocalDate currentDate;

    /**
     * A constante {@code LOG_DIRECTORY} define o diretório onde os arquivos de log serão salvos.
     * O caminho é construído dinamicamente com base no diretório de execução atual da aplicação,
     * combinado com os subdiretórios específicos da estrutura do projeto. Esse caminho é utilizado
     * pelo método {@code createLogFile()} para criar os arquivos de log no local correto.
     * O uso do {@code Paths.get()} permite uma montagem de caminho adequada ao sistema operacional.
     */
    private static final String LOG_DIRECTORY = Paths.get(System.getProperty("user.dir"), "TomTicket-api1", "src", "main", "java", "com", "example", "tomticketapi1", "structure", "logs", "logdocuments").toString();

    /**
     * A constante {@code HISTORY_DIRECTORY} define o diretório de histórico, onde os arquivos de log
     * de dias anteriores são movidos. O caminho é construído adicionando o subdiretório "historico"
     * ao caminho base do diretório de logs. Os arquivos são movidos para este diretório quando o dia muda,
     * preservando o histórico dos logs anteriores.
     */
    private static final String HISTORY_DIRECTORY = LOG_DIRECTORY + "\\historico";

    /**
     * O objeto {@code formatter} é um formatador de datas utilizado para converter as datas no formato
     * "dd-MM-yyyy", tanto para gerar o nome do arquivo de log quanto para comparar as datas dos arquivos
     * já existentes. Ele garante que as datas sejam formatadas corretamente para uso nos métodos de
     * criação e verificação de arquivos de log.
     */
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /**
     * Construtor padrão da classe {@code WriteInTxtLoggerDocument}.
     * Este construtor é responsável por:
     *     Inicializar a data atual utilizando {@link LocalDate#now()}.</li>
     *     Verificar se existem arquivos de log do dia anterior, movendo-os para o diretório de histórico,
     *     através do método {@link #moveOldLogsToHistory()}.</li>
     *     Criar o arquivo de log inicial do dia, utilizando o método {@link #createLogFile()}.
     * O arquivo de log será criado no diretório padrão, que é definido pela implementação da classe.
     */
    public WriteInTxtLoggerDocument() {
        this.currentDate = LocalDate.now(); // Define a data atual
        moveOldLogsToHistory(); // verifica se existe arquivos de log para mover para o histórico
        createLogFile(); // Cria o arquivo de log inicial
    }

    /**
     * Cria um novo arquivo de log no diretório especificado.
     * O nome do arquivo de log será gerado com base na data atual no formato "dd-MM-yyyy",
     * precedido por "log_", e salvo no diretório padrão de logs. O arquivo é criado no modo
     * de adição (append), ou seja, novos conteúdos serão adicionados ao arquivo existente,
     * sem sobrescrever os dados anteriores.
     * Em caso de falha na criação do arquivo, uma mensagem de erro será exibida no console.
     *
     * @see FileWriter
     */
    private void createLogFile() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        fileName = "log_" + currentDate.format(formatter) + ".txt";

        String fullPath = LOG_DIRECTORY + File.separator + fileName;
        try {
            writer = new FileWriter(fullPath, true); // 'true' para adicionar conteúdo sem sobrescrever
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo de log: " + e.getMessage());
        }
    }

    /**
     * Move todos os arquivos de log com datas anteriores à data atual para o diretório de histórico.
     * Este método verifica os arquivos no diretório de logs cujo nome segue o padrão "log_dd-MM-yyyy.txt".
     * Se a data no nome do arquivo for anterior à data atual, o arquivo será movido para o diretório de
     * histórico. Caso ocorra um erro ao interpretar a data ou mover o arquivo, mensagens de erro serão
     * exibidas no console.
     * Exemplo de nome de arquivo: {@code log_01-10-2024.txt}
     *
     * Exceções possíveis:
     * {@link DateTimeParseException} - Se a data extraída do nome do arquivo não puder ser interpretada.
     *   <li>{@link IOException} - Se houver um erro de I/O ao mover o arquivo.
     */
    public void moveOldLogsToHistory() {
        File logDir = new File(LOG_DIRECTORY);
        File[] files = logDir.listFiles((dir, name) -> name.startsWith("log_") && name.endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                // Extraímos a data do nome do arquivo
                String fileName = file.getName();
                String fileDatePart = fileName.substring(4, 14); // "log_dd-MM-yyyy.txt"

                try {
                    LocalDate fileDate = LocalDate.parse(fileDatePart, formatter);
                    LocalDate currentDate = LocalDate.now();

                    // Se a data do arquivo for diferente da data atual, movemos o arquivo
                    if (!fileDate.equals(currentDate)) {
                        Path sourcePath = file.toPath();
                        Path targetPath = Paths.get(HISTORY_DIRECTORY, fileName);
                        // Move o arquivo para o diretório de histórico
                        Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Arquivo movido para o histórico: " + fileName);
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Erro ao interpretar a data do arquivo: " + fileName + " - " + e.getMessage());
                } catch (IOException e) {
                    System.out.println("Erro ao mover o arquivo: " + fileName + " - " + e.getMessage());
                }
            }
        }
    }

    /**
     * Escreve uma mensagem no arquivo de log.
     * Antes de escrever a mensagem, o método verifica se o dia mudou. Caso o dia tenha
     * mudado, o arquivo de log atual é fechado e um novo arquivo de log para o dia atual
     * é criado. A mensagem é gravada no formato "dd-MM-yyyy_HH:mm:ss : mensagem".
     * O método garante que a mensagem seja gravada imediatamente no arquivo usando o
     * método {@code flush()}.
     * Em caso de falha na escrita, uma mensagem de erro é exibida no console.
     * @param message A mensagem que será gravada no arquivo de log.
     */
    public void logMessage(String message) {
        // Verifica se o dia mudou antes de escrever
        if (!LocalDate.now().equals(currentDate)) {
            closeLogger(); // Fecha o arquivo atual
            currentDate = LocalDate.now(); // Atualiza a data atual
            createLogFile(); // Cria um novo arquivo de log
        }

        // Formatação personalizada para data e hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm:ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);

        try {
            writer.write(formattedDateTime + " : " + message + "\n");
            writer.flush(); // Garante que a mensagem seja gravada imediatamente
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    /**
     * Fecha o {@code FileWriter} associado ao arquivo de log.
     * <p>
     * Este método verifica se o objeto {@code writer} não é nulo e tenta fechá-lo,
     * liberando os recursos associados ao arquivo de log. Esse processo é necessário
     * para garantir que todas as alterações sejam corretamente salvas e que o arquivo
     * não permaneça aberto, evitando possíveis problemas de corrupção ou uso de recursos.
     * <p>
     * Caso ocorra uma falha ao tentar fechar o arquivo, uma mensagem de erro será exibida
     * no console, indicando o motivo do erro.
     *
     * @see FileWriter#close()
     */
    public void closeLogger() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Erro ao fechar o arquivo de log: " + e.getMessage());
        }
    }
}
