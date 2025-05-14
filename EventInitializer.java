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

public class EventInitializer {

    public void initializeEvents() {
        EventStorage.availableEvents.put("Party", 100);
        EventStorage.availableEvents.put("Tournament", 50);
        EventStorage.availableEvents.put("Fair", 300);
        EventStorage.availableEvents.put("Soccer", 200);
        EventStorage.availableEvents.put("Tennis", 150);
        EventStorage.availableEvents.put("Golf", 200);
        EventStorage.availableEvents.put("Basketball", 120);
    }

    public static boolean checkAndReserveTickets(String eventName, int quantity) {
        for (String key : EventStorage.availableEvents.keySet()) {
            if (key.equalsIgnoreCase(eventName)) {
                int available = EventStorage.availableEvents.get(key);
                if (available >= quantity) {
                    EventStorage.availableEvents.put(key, available - quantity);
                    EventStorage.requestedEvents.put(
                            key,
                            EventStorage.requestedEvents.getOrDefault(key, 0) + quantity
                    );

                    return true;
                } else {
                    System.out.println("Nicht genug Tickets verfügbar!");
                    return false;
                }
            }
        }

        System.out.println("Event nicht gefunden!");
        return false;
    }
}


