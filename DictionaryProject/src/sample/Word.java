package sample;

public class Word {
    // cai nay la properties
    private String wordTarget;
    private String wordExplain;
    private String wordPronunciation;

    //constructor
    public Word()
    {
        this.wordTarget="";
        this.wordExplain="";
        this.wordPronunciation="";
    }
    public Word(String wordTarget,String wordExplain, String wordPronunciation)
    {
        this.wordTarget = wordTarget;
        this.wordExplain = wordExplain;
        this.wordPronunciation = wordPronunciation;
    }

    //getter setter cua properties
    public String getWordTarget()
    {
        return this.wordTarget;
    }
    public void setWordTarget(String wordTarget)
    {
        this.wordTarget = wordTarget;
    }
    public String getWordExplain()
    {
        return this.wordExplain;
    }
    public void setWordExplain(String wordExplain)
    {
        this.wordExplain = wordExplain;
    }

    public String getWordPronunciation() {
        return wordPronunciation;
    }

    public void setWordPronunciation(String wordPronunciation) {
        this.wordPronunciation = wordPronunciation;
    }
}
