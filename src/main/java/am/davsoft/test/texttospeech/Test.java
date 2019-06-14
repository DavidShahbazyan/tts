package am.davsoft.test.texttospeech;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import static java.lang.System.out;

public class Test {
    static VoiceManager freettsVM;
    static Voice freettsVoice;

    public static void main(String[] args) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        demonstrateFreeTTS();
        demonstrateVoice();
    }

    static void sayWords(String words) {
        // Make her speak!
        freettsVoice.speak(words);
    }

    public static void demonstrateFreeTTS() {
        VoiceManager vm = VoiceManager.getInstance();
        Voice voice = vm.getVoice("kevin16");
        voice.allocate();
        voice.speak("Hello World");

        // Voices
        out.println("------Voices-------");
        Voice[] voices = vm.getVoices();
        for (Voice v : voices) {
            out.println(v);
        }

        // Voice information
        out.println();
        out.println("------Voice Information-------");
        out.println(vm.getVoiceInfo());

        out.println();
        out.println("------Alan Voice Information-------");
        Voice v = vm.getVoice("alan");
        out.println(v);
    }

    public static void demonstrateVoice() {
        out.println();
        out.println("------Voice Demonstration-------");

        VoiceManager vm = VoiceManager.getInstance();
        Voice voice = vm.getVoice("kevin16");
        voice.allocate();

        out.println("Name: " + voice.getName());
        out.println("Description: " + voice.getDescription());
        out.println("Organization: " + voice.getOrganization());
        out.println("Age: " + voice.getAge());
        out.println("Gender: " + voice.getGender());
        out.println("Rate: " + voice.getRate());
        out.println("Pitch: " + voice.getPitch());
        out.println("Style: " + voice.getStyle());
        out.println();
    }

}
