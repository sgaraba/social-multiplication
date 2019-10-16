package microservices.book.testutils.beans;

public class ScoreResponse {
    private long userId;
    private int score;

    public ScoreResponse() {
    }

    public ScoreResponse(final int score) {
        this.score = score;
    }

    public long getUserId() {
        return userId;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "ScoreResponse{" +
                "userId=" + userId +
                ", score=" + score +
                '}';
    }
}
