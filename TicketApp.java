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

import java.util.*;

public class TicketApp {

    public static void main(String[] args) {
        System.out.println("Gigatix Ticket Launcher");

        Scanner scanner = new Scanner(System.in);
        EventInitializer eventInitializer = new EventInitializer();
        eventInitializer.initializeEvents();

        System.out.println("Name des Ereignisses eingeben: ");
        String userEventName = scanner.nextLine();

        System.out.println("Geben Sie die Anzahl der Tickets ein:");
        int requestedTickets = Integer.parseInt(scanner.nextLine());

        boolean success = EventInitializer.checkAndReserveTickets(userEventName, requestedTickets);

        if (success) {
            System.out.println("Tickets erfolgreich reserviert!");
            TicketFileWriter ticketFileWriter = new TicketFileWriter();
            ticketFileWriter.writeTicketsToFile();

            for (Map.Entry<String, Integer> entry : EventStorage.requestedEvents.entrySet()) {
                String line = entry.getKey() + "," + entry.getValue();
                System.out.println("Gebuchte Tickets: "+ line);

            }
        } else {
            System.out.println("Ticket reservation failed.");
            scanner.close();
        }
    }
}
