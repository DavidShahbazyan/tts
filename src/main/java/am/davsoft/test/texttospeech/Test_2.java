package am.davsoft.test.texttospeech;

import com.sun.speech.freetts.Age;
import com.sun.speech.freetts.Gender;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.en.us.CMULexicon;
import de.dfki.lt.freetts.en.us.MbrolaVoice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class Test_2 {
    static VoiceManager freettsVM;
    static Voice freettsVoice;

    public static void main(String[] args) throws IOException {
        // Most important part!
//        System.setProperty("freetts.voices", "de.dfki.lt.freetts.en.us.MbrolaVoiceDirectory");
        System.setProperty("mbrola.base", "C:/Users/davitsh/projects/test_projects/texttospeech/mbrola");
        freettsVM = VoiceManager.getInstance();

        // Simply change to MBROLA voice
//        freettsVoice = freettsVM.getVoice("mbrola_en1");
//        CMULexicon lexicon = new CMULexicon("cmulex");
        CMULexicon lexicon = new CMULexicon("cmudict04");

//        Voice mbrola1 = new MbrolaVoice("us1", "us1", 150.0F, 180.0F, 22.0F, "mbrola_us1", Gender.FEMALE, Age.YOUNGER_ADULT, "MBROLA Voice us1", Locale.US, "general", "mbrola", lexicon);
//        Voice mbrola2 = new MbrolaVoice("us2", "us2", 150.0F, 115.0F, 12.0F, "mbrola_us2", Gender.MALE, Age.YOUNGER_ADULT, "MBROLA Voice us2", Locale.US, "general", "mbrola", lexicon);
//        Voice mbrola3 = new MbrolaVoice("us3", "us3", 150.0F, 125.0F, 12.0F, "mbrola_us3", Gender.MALE, Age.YOUNGER_ADULT, "MBROLA Voice us3", Locale.US, "general", "mbrola", lexicon);
        Voice mbrola4 = new MbrolaVoice("us1", "us1", 150.0F, 190.0F, 70.0F, "mbrola_us1", Gender.FEMALE, Age.YOUNGER_ADULT, "MBROLA Voice en1", Locale.US, "general", "mbrola", lexicon);

        freettsVoice = mbrola4;

        // Allocate your chosen voice
        freettsVoice.allocate();
//        strings.forEach(Test::sayWords);

        BufferedReader br = new BufferedReader(new FileReader("./text.txt"));
        br.lines().forEach(Test_2::sayWords);
    }

    static void sayWords(String words) {
        // Make her speak!
        freettsVoice.speak(words);
    }
}
