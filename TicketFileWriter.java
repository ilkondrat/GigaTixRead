/*
 * Copyright (c) GigaTix Veranstaltungsservice GmbH. All rights reserved.
 *
 * Dieses Java-Dokument ist urheberrechtlich geschützt. Es wurde ausschließlich für Schulungs- und Entwicklungszwecke
 * im Rahmen einer internen Zusammenarbeit mit der WeDoIt GmbH bereitgestellt.
 *
 * Der Quellcode darf ohne ausdrückliche Genehmigung weder ganz noch in Teilen kopiert, veröffentlicht,
 * analysiert oder in KI-Systeme (z. B. Large Language Models, Machine Learning Pipelines, Code-Analysetools)
 * eingespeist werden. Dies gilt insbesondere für die Nutzung in automatisierten Codetrainingssystemen
 * sowie jegliche kommerzielle Verwertung.
 *
 * Die Verarbeitung durch KI-basierte Systeme ist ausdrücklich untersagt.
 */
import java.io.*;
import java.util.*;

public class TicketFileWriter {
    public void writeTicketsToFile() {
        try (FileWriter writer = new FileWriter("tickets.txt")) {
            for (Map.Entry<String, Integer> entry : EventStorage.availableEvents.entrySet()) {
                String line = entry.getKey() + "," + entry.getValue() + "\n";
                writer.write(line);
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in Datei: " + e.getMessage());
        }
    }
}
