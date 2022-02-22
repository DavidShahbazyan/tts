package am.davsoft.test.texttospeech;

//import com.sun.speech.freetts.*;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;
import java.util.Arrays;
import java.util.List;
//import javax.speech.Central;
//import javax.speech.synthesis.Synthesizer;
//import javax.speech.synthesis.SynthesizerModeDesc;

public class Main {
    static List<String> strings = Arrays.asList(
            "This book consists of six chapters, plus supplementary information: a glossary, this introduction, three appendices, and the assessment test after the introduction. You might have noticed that there are more than six exam objectives. We split up what you need to know to make it easy to learn and remember. Each chapter begins with a list of the objectives that are covered in that chapter.",
            "The chapters are organized as follows:",
            "■ Chapter 1, \"Java Building Blocks,\" covers the basics of Java such as scoping variables and how to run a program. It also includes calling methods and types of variables.",
            "■ Chapter 2, \"Operators and Statements,\" focuses on the core logical constructs such as conditionals and loops. It also talks about the meaning and precedence of operators.",
            "■ Chapter 3, \"Core Java APIs,\" introduces you to array, ArrayList, String, StringBuilder, and various date classes.",
            "■ Chapter 4, \"Methods and Encapsulation,\" explains how to write methods, including access modifiers. It also shows how to call lambdas.",
            "■ Chapter 5, \"Class Design,\" adds interfaces and superclasses. It also includes casting and polymorphism.",
            "■ Chapter 6, \"Exceptions,\" shows the different types of exception classes and how to use them.",
            "At the end of each chapter, you’ll fi nd a few elements you can use to prepare for the exam:",
            "Summary This section reviews the most important topics that were covered in the chapter and serves as a good review."
    );

//    public static void main(String[] args) {
//        try {
//            // set property as Kevin Dictionary
//            System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
//
//            // Register Engine
//            Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
//
//            // Create a Synthesizer
//            Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
//
//            // Allocate synthesizer
//            synthesizer.allocate();
//
//            // Resume Synthesizer
//            synthesizer.resume();
//
//
//
//            // speaks the given text until queue is empty.
//            for (String s : strings) {
//                synthesizer.speakPlainText(s, null);
//            }
//            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
//
//            // Deallocate the Synthesizer.
//            synthesizer.deallocate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) throws Exception {
//        Voice v = VoiceManager.getInstance().getVoice("kevin16");
//        v.allocate();
//        v.setPitch(150.0F); //Optional – set pitch for the voice
//        v.setVolume(1.0F); //Optional – set volume of output 0 to 1
//        v.setRate(160.0F); // Optional – set words spoken per minute
//        String s = "Hello " + System.getProperty("user.name") +" !\n "+" I am kevin speaking at 16 kHz !\nWill you take me as your friend ? ";
//        v.speak(s);
//
//        System.exit(0);


        SynthesizerModeDesc desc = new SynthesizerModeDesc();
        desc.setModeName("general");
        desc.setLocale(java.util.Locale.US);

        Synthesizer reader = Central.createSynthesizer(desc);

        reader.allocate();
        reader.resume();

        Voice v = new Voice();
        v.setName("kevin16");

        reader.getSynthesizerProperties().setVoice(v);

        reader.getSynthesizerProperties().setPitch(150.0F);

        reader.getSynthesizerProperties().setVolume(1.0F);

        reader.getSynthesizerProperties().setSpeakingRate(160.0F);

        String s = "Hello " + System.getProperty("user.name") + "!\nI am kevin speaking at 16 kHz!\nWill you take me as your friend?";

        reader.speakPlainText(s, null);

        reader.waitEngineState(Synthesizer.QUEUE_EMPTY);

        System.exit(0);

    }

//    public static void main(String[] args) {
//        Voice voice;
//        VoiceManager voiceManager = VoiceManager.getInstance();
//        voice = voiceManager.getVoice("kevin16");
//        voice.allocate();
//        for (String s : strings) {
//            voice.speak(s);
//        }
//    }
}
