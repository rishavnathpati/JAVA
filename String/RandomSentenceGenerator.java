// Write  an  application  that  uses  random-number  generation  to  create  sentences.  Use  four  arrays  of 
// strings called article, noun, verb and preposition. Create a sentence by selecting a word at random from 
// each  array  in  the  following  order:  article,  noun,  verb,  preposition,  article  and  noun.  As  each  word  is 
// picked, concatenate it to the previous words in the sentence. The words should be separated by spaces. 
// When  the  final  sentence  is  output,  it  should  start  with  a  capital  letter  and  end  with  a  period.  The 
// application should generate and display 20 sentences. 
// The article array should contain the articles "the", "a", "one", "some" and "any"; the noun array should 
// contain  the  nouns  "boy",  "girl",  "dog",  "town"  and  "car";  the  verb  array  should  contain  the  verbs 
// "drove", "jumped", "ran", "walked" and "skipped"; the preposition array should contain the prepositions 
// "to", "from", "over", "under" and "on"
package String;

import java.util.Random;

public class RandomSentenceGenerator {
    public static void main(String[] args) {
        // Define the arrays of words
        String[] articles = { "the", "a", "one", "some", "any" };
        String[] nouns = { "boy", "girl", "dog", "town", "car" };
        String[] verbs = { "drove", "jumped", "ran", "walked", "skipped" };
        String[] prepositions = { "to", "from", "over", "under", "on" };

        // Create a random number generator
        Random rand = new Random();

        // Generate and display 20 sentences
        for (int i = 0; i < 20; i++) {
            // Select a random word from each array
            String article = articles[rand.nextInt(articles.length)];
            String noun1 = nouns[rand.nextInt(nouns.length)];
            String verb = verbs[rand.nextInt(verbs.length)];
            String preposition = prepositions[rand.nextInt(prepositions.length)];
            String article2 = articles[rand.nextInt(articles.length)];
            String noun2 = nouns[rand.nextInt(nouns.length)];

            // Construct the sentence
            String sentence = article + " " + noun1 + " " + verb + " " + preposition + " " + article2 + " " + noun2
                    + ".";
            sentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1);

            // Display the sentence
            System.out.println(sentence);
        }
    }
}
