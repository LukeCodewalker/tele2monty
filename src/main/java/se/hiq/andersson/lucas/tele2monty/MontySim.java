package se.hiq.andersson.lucas.tele2monty;

import java.util.List;
import java.util.Random;

public class MontySim {
    /**
     * @param runs number of simulation runs to conduct
     * @param sticky dictates whether the guest sticks to their initial pick
     */
    public MontySimResult run(int runs, boolean sticky) {
        int wins = 0;

        for(int i = 0; i < runs; i++) {
            if (run(sticky)) {
                wins++;
            }
        }

        return new MontySimResult(sticky, wins, runs - wins);
    }

    /**
     * @return returns true if the guest won, otherwise false
     */
    private boolean run(boolean sticky) {
        // Create three empty boxes
        List<MontySimBox> boxes = List.of(new MontySimBox(), new MontySimBox(), new MontySimBox());
        Random random = new Random();

        // Fill a random box with money
        int moneyIndex = random.nextInt(0, boxes.size());
        boxes.get(moneyIndex).setContainsMoney(true);

        // Guest makes their initial pick
        int guestIndex = random.nextInt(0, boxes.size());

        List<MontySimBox> emptyBoxes = boxes.stream()
                .filter(b -> !b.containsMoney())
                .toList();

        // Host opens a random empty box
        int emptyBoxIndex = random.nextInt(0, boxes.size() - 1);
        MontySimBox emptyBox = emptyBoxes.get(emptyBoxIndex);
        int hostIndex = boxes.indexOf(emptyBox);

        MontySimBox remainingBox = boxes.stream()
                .filter(b -> boxes.indexOf(b) != guestIndex && boxes.indexOf(b) != hostIndex)
                .toList()
                .get(0);

        // Guest makes their final pick
        return sticky ? boxes.get(guestIndex).containsMoney()
                : boxes.get(boxes.indexOf(remainingBox)).containsMoney();
    }
}
