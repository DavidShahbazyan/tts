package am.davsoft.test.texttospeech;

import com.sun.speech.freetts.FreeTTSSpeakableImpl;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.io.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Test {
    static VoiceManager freettsVM;
    static Voice freettsVoice;

    public static void main(String[] args) throws Exception {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        demonstrateFreeTTS();
        demonstrateVoice();
    }

    static void sayWords(String words) {
        // Make her speak!
        freettsVoice.speak(words);
    }

    public static void demonstrateFreeTTS() throws Exception {
        VoiceManager vm = VoiceManager.getInstance();
        freettsVoice = vm.getVoice("kevin16");
        freettsVoice.allocate();

//        freettsVoice.speak(new FreeTTSSpeakableImpl(new FileInputStream("./test_files/text.txt")));

//        final FileReader fileReader = new FileReader("./test_files/text.txt");
//        BufferedReader reader = new BufferedReader(fileReader);
//        String s;
//        while ((s = reader.readLine()) != null) {
//            sayWords(s);
//        }
//        reader.close();
//        fileReader.close();

        sayWords(PdfUtils.pdfToText("./test_files/pdf-test.pdf"));

//        sayWords("Hi Grigori, how are you?");
//        BufferedReader br = new BufferedReader(new FileReader("./test_files/text.txt"));
//        br.lines().forEach(Test::sayWords);

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
