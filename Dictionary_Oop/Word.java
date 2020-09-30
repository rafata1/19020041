package Dictionary_Oop;

public class Word {
    // cai nay la properties
    private String wordTarget;
    private String wordExpain;

    //constructor
    public Word()
    {
        this.wordTarget="";
        this.wordExpain="";
    }
    public Word(String wordTarget,String wordExplain)
    {
        this.wordTarget = wordTarget;
        this.wordExpain = wordExplain;
    }

    //getter setter cua properties
    public String getwordTarget()
    {
        return this.wordTarget;
    }
    public void setwordTarget(String wordTarget)
    {
        this.wordTarget = wordTarget;
    }
    public String getwordExplain()
    {
        return this.wordExpain;
    }
    public void setwordExplain(String wordExplain)
    {
        this.wordExpain = wordExplain;
    }

    public static void main(String[] args) {
        Word abc = new Word("Hello","Xin chao");
        System.out.println(abc.getwordTarget()+" "+abc.getwordExplain());

    }

}
