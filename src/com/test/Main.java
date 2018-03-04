package com.test;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String testString = "abcd9876DCBcbz";

        System.out.println(" encoded Value "+ encode(1000,testString));
        System.out.println(" encoded Value "+ encode(-1000,testString));

    }

    /**
     * Encode String with the given Offset
     * @param offset
     * @param orginalText
     * @return
     */
    public static String encode(final int offset, final String orginalText ) {

        char[] lowerCase = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] upperCase = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        StringBuffer encodedText = new StringBuffer();

        char[] charArray = orginalText.toCharArray();

        for( char character: charArray){

            boolean isAlpha =  encodeStringWithArray(encodedText, character, lowerCase, offset);

            if(!isAlpha) {
                isAlpha = encodeStringWithArray(encodedText, character, upperCase, offset);
            }

            if(!isAlpha) {
                encodedText.append(character);
            }

        }

        return encodedText.toString();

    }


    /**
     * Find the index of the char in the given array
     * @param array
     * @param element
     * @return index of the element, returns -1 if the element is not found.
     */
    private static int findIndex(final char[] array, final char element){

        for(int i=0; i< array.length ; i++){

            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Find the element after rotating the array cyclically by given offset
     * @param array
     * @param index of the starting element
     * @param offset if positive, indicated forward.  If negative, indicated backward
     * @return element in the array
     */
    private static char findElement(final char[] array, final int index, final int offset) {

        if(index >= array.length) {
            System.out.println(" Error in the given index, it can be greater than Array length");
        }

        int finalIndex = index;


        if( offset > 0){

            int relativeOffset = offset % 26;

            // Traverse the array forward, and if end of array then start at beginning
            for(int i = index, j = relativeOffset; i < array.length && j > 0 ;  j--) {

                i += 1;
                if( i == array.length){
                    i = 0;
                }
                finalIndex = i;
            }

        } else {

            int relativeOffset = (offset % 26) * (-1);

            // Traverse the array backward, and if begin of the array then start at end
            for(int i = index, j = relativeOffset; i < array.length && j > 0 ;  j--) {

                i -= 1;
                if( i == -1){
                    i = 25;
                }
                finalIndex = i;

            }
        }

        if ( finalIndex < 0 || finalIndex >= array.length) {
            System.out.println("ERROR:  Found index out of bounds");
            finalIndex = index;
        }

        return array[finalIndex];
    }

    /**
     * check character in the caseArray and encode character with the given offset.
     * @param encodedText
     * @param character
     * @param caseArray
     * @param offset
     * @return  return true, if encoded.
     */
    private static boolean encodeStringWithArray(StringBuffer encodedText,final char character, final char[] caseArray, final int offset) {

        int foundIndex = findIndex(caseArray, character);
        if(foundIndex != -1) {
            char encodedChar = findElement(caseArray, foundIndex, offset);
            encodedText.append(encodedChar);
            return true;
        }

        return false;
    }






}
