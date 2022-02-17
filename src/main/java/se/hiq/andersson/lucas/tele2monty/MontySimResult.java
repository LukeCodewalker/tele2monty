package se.hiq.andersson.lucas.tele2monty;

public class MontySimResult {
    private final int wins;
    private final int losses;
    private final long winRate;
    private final boolean sticky;

    public MontySimResult(boolean sticky, int wins, int losses) {
        this.sticky = sticky;
        this.wins = wins;
        this.losses = losses;
        this.winRate = Math.round(((double) wins / (double) (wins + losses)) * 100);
    }

    public boolean isSticky() {
        return sticky;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public long getWinRate() {
        return winRate;
    }

    public String toString() {
        return String.format("sticky: %s, wins: %s, losses: %s, winRate: %s", sticky, wins, losses, winRate);
    }
}
