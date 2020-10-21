package sample;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextToSpeech {

    private String name;
    private Voice voice;

    public TextToSpeech(String name) {
        this.name = name;
        this.voice = VoiceManager.getInstance().getVoice(this.name);
        this.voice.allocate();
    }

    public void say(String something) {
        this.voice.speak(something);
    }

}
