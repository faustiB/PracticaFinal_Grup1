package Business;

import java.util.HashMap;

public class Article extends Trial {
    private String articleName;
    private String magazineQuartile;
    private int acceptProbability;
    private int revisionProbability;
    private int denyProbability;

    public Article(String name, int type, String articleName, String magazineQuartile, int acceptProbability,
                   int revisionProbability, int denyProbability) {
        super(name, type);
        this.articleName = articleName;
        this.magazineQuartile = magazineQuartile;
        this.acceptProbability = acceptProbability;
        this.revisionProbability = revisionProbability;
        this.denyProbability = denyProbability;
    }

    @Override
    public HashMap<String, String> getDetails() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Trial", super.name);
        map.put("Journal", this.articleName);
        map.put("% acceptance", String.valueOf(this.acceptProbability));
        map.put("revision", String.valueOf(this.revisionProbability));
        map.put("% rejection", String.valueOf(this.denyProbability));

        return map;
    }

    @Override
    public String[] getArrayDescription(){
        return new String[]{name,articleName,magazineQuartile,String.valueOf(acceptProbability),String.valueOf(revisionProbability),String.valueOf(denyProbability)};
    }
}
