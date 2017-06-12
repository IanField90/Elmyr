package fr.xgouchet.elmyr

import org.assertj.core.api.Java6Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

/**
 * @author Xavier F. Gouchet
 */
class ForgerSpek_Text : Spek({

    describe("A forger ") {
        val forger = Forger()
        var seed: Long = 0
        val testRepeatCountSmall = 16

        beforeEachTest {
            seed = System.nanoTime()
            forger.reset(seed)
        }


        // region Chars

        context("forging characters") {
            it("forges an Ascii printable character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.anAsciiChar()
                    assertThat(char)
                            .isGreaterThanOrEqualTo(Forger.MIN_PRINTABLE)
                            .isLessThanOrEqualTo(Forger.MAX_ASCII)
                })
            }

            it("forges an Extended Ascii printable character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.anExtendedAsciiChar()
                    assertThat(char)
                            .isGreaterThanOrEqualTo(Forger.MIN_PRINTABLE)
                            .isLessThanOrEqualTo(Forger.MAX_ASCII_EXTENDED)
                })
            }

            it("forges an alpha character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.anAlphabeticalChar(case = Case.ANY)
                    assertThat(Forger.ALPHA)
                            .contains(char)
                })
            }

            it("forges an alpha uppercase character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.anAlphabeticalChar(case = Case.UPPER)
                    assertThat(Forger.ALPHA_UPPER)
                            .contains(char)
                })
            }

            it("forges an alpha lowercase character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.anAlphabeticalChar(case = Case.LOWER)
                    assertThat(Forger.ALPHA_LOWER)
                            .contains(char)
                })
            }

            it("forges an alpha digit character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.anAlphaNumericalChar(case = Case.ANY)
                    assertThat(Forger.ALPHA_NUM)
                            .contains(char)
                })
            }

            it("forges an alpha digit uppercase character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.anAlphaNumericalChar(case = Case.UPPER)
                    assertThat(Forger.ALPHA_NUM_UPPER)
                            .contains(char)
                })
            }

            it("forges a non alpha digit uppercase character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aNonAlphaNumericalChar()
                    assertThat(Forger.ALPHA_NUM_UPPER)
                            .doesNotContain(char)
                })
            }

            it("forges an alpha digit lowercase character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.anAlphaNumericalChar(case = Case.LOWER)
                    assertThat(Forger.ALPHA_NUM_LOWER)
                            .contains(char)
                })
            }

            it("forges an digit character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aNumericalChar()
                    assertThat(Forger.DIGIT)
                            .contains(char)
                })
            }

            it("forges a non digit character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aNonNumericalChar()
                    assertThat(Forger.DIGIT)
                            .doesNotContain(char)
                })
            }

            it("forges an hexa-digit character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.anHexadecimalChar(case = Case.LOWER)
                    assertThat(Forger.HEXA_LOWER)
                            .contains(char)
                })
            }
            it("forges an hexa-digit character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.anHexadecimalChar(case = Case.UPPER)
                    assertThat(Forger.HEXA_UPPER)
                            .contains(char)
                })
            }

            it("forges a vowel character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aVowelChar(case = Case.ANY)
                    assertThat(Forger.VOWEL)
                            .contains(char)
                })
            }
            it("forges a vowel uppercase character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aVowelChar(case = Case.UPPER)
                    assertThat(Forger.VOWEL_UPPER)
                            .contains(char)
                })
            }
            it("forges a vowel lowercase character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aVowelChar(case = Case.LOWER)
                    assertThat(Forger.VOWEL_LOWER)
                            .contains(char)
                })
            }

            it("forges a consonant character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aConsonantChar(case = Case.ANY)
                    assertThat(Forger.CONSONANT)
                            .contains(char)
                })
            }
            it("forges a consonant uppercase character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aConsonantChar(case = Case.UPPER)
                    assertThat(Forger.CONSONANT_UPPER)
                            .contains(char)
                })
            }
            it("forges a consonant lowercase character") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aConsonantChar(case = Case.LOWER)
                    assertThat(Forger.CONSONANT_LOWER)
                            .contains(char)
                })
            }

            it("forges a whitespace") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aWhitespaceChar()
                    assertThat(Forger.WHITESPACE)
                            .contains(char)
                })
            }
        }

        context("forging constrained chars") {
            it("forges a char …") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.ANY)
                    // How do you assert that an char is an char ... ?
                })
            }

            it("forges an hexadecimal upper char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.HEXADECIMAL, Case.UPPER)
                    assertThat(Forger.HEXA_UPPER)
                            .contains(char)
                })
            }

            it("forges an hexadecimal lower char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.HEXADECIMAL, Case.LOWER)
                    assertThat(Forger.HEXA_LOWER)
                            .contains(char)
                })
            }

            it("forges a numerical char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.NUMERICAL)
                    assertThat(arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'))
                            .contains(char)
                })
            }

            it("forges an upper alphanum char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.ALPHA_NUM, Case.UPPER)
                    assertThat(Forger.ALPHA_NUM_UPPER)
                            .contains(char)
                })
            }

            it("forges a lower alphanum char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.ALPHA_NUM, Case.LOWER)
                    assertThat(Forger.ALPHA_NUM_LOWER)
                            .contains(char)
                })
            }

            it("forges an alphanum char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.ALPHA_NUM)
                    assertThat(Forger.ALPHA_NUM)
                            .contains(char)
                })
            }

            it("forges an upper alpha char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.ALPHA, Case.UPPER)
                    assertThat(Forger.ALPHA_UPPER)
                            .contains(char)
                })
            }

            it("forges a lower alpha char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.ALPHA, Case.LOWER)
                    assertThat(Forger.ALPHA_LOWER)
                            .contains(char)
                })
            }

            it("forges an alpha char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.ALPHA)
                    assertThat(Forger.ALPHA)
                            .contains(char)
                })
            }

            it("forges a whitespace char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.WHITESPACE)
                    assertThat(Forger.WHITESPACE)
                            .contains(char)
                })
            }

            it("forges an ASCII char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.ASCII)
                    assertThat(char)
                            .isGreaterThanOrEqualTo(Forger.MIN_PRINTABLE)
                            .isLessThan(Forger.MAX_ASCII)
                })
            }

            it("forges an extended ASCII char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.ASCII_EXTENDED)
                    assertThat(char)
                            .isGreaterThanOrEqualTo(Forger.MIN_PRINTABLE)
                            .isLessThan(Forger.MAX_ASCII_EXTENDED)
                })
            }

            it("forges a non alpha char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.NON_ALPHA)
                    assertThat(Forger.ALPHA)
                            .doesNotContain(char)
                })
            }

            it("forges a non alphanum char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.NON_ALPHA_NUM)
                    assertThat(Forger.ALPHA_NUM)
                            .doesNotContain(char)
                })
            }

            it("forges a non numerical char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.NON_NUMERICAL)
                    assertThat(arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'))
                            .doesNotContain(char)
                })
            }

            it("forges a non hexadecimal char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.NON_HEXADECIMAL)
                    assertThat(Forger.HEXA_LOWER)
                            .doesNotContain(char)
                    assertThat(Forger.HEXA_UPPER)
                            .doesNotContain(char)
                })
            }

            it("forges a non whitespace char") {
                repeat(testRepeatCountSmall, {
                    val char = forger.aChar(CharConstraint.NON_WHITESPACE)
                    assertThat(Forger.WHITESPACE)
                            .doesNotContain(char)
                })
            }
        }
        // endregion

        // region Strings

        context("forging meaningful strings ") {

            it("forges a lowercase word-like string") {
                repeat(testRepeatCountSmall, {
                    val size = forger.aTinyInt()
                    val word = forger.aWord(Case.LOWER, size)
                    assertThat(word)
                            .hasSize(size)
                            .matches("[aeiouy]?([zrtpqsdfghjklmwxcvbn][aeiouy])*[zrtpqsdfghjklmwxcvbn]?")
                })
            }

            it("forges an uppercase word-like string") {
                repeat(testRepeatCountSmall, {
                    val size = forger.aTinyInt()
                    val word = forger.aWord(Case.UPPER, size)
                    assertThat(word)
                            .hasSize(size)
                            .matches("[AEIOUY]?([ZRTPQSDFGHJKLMWXCVBN][AEIOUY])*[ZRTPQSDFGHJKLMWXCVBN]?")
                })
            }

            it("forges a capitalized word-like string") {
                repeat(testRepeatCountSmall, {
                    val size = forger.aTinyInt()
                    val word = forger.aWord(Case.CAPITALIZE, size)
                    assertThat(word)
                            .hasSize(size)
                            .matches("[A-Z][aeiouy]?([zrtpqsdfghjklmwxcvbn][aeiouy])*[zrtpqsdfghjklmwxcvbn]?")
                })
            }

            it("forges an anycase word-like string") {
                repeat(testRepeatCountSmall, {
                    val size = forger.aTinyInt()
                    val word = forger.aWord(Case.ANY, size)
                    assertThat(word)
                            .hasSize(size)
                            .matches("[aeiouyAEIOUY]?([zrtpqsdfghjklmwxcvbnZRTPQSDFGHJKLMWXCVBN][aeiouyAEIOUY])*[zrtpqsdfghjklmwxcvbnZRTPQSDFGHJKLMWXCVBN]?")
                })
            }

            it("forges an anycase word-like string of anySize") {
                repeat(testRepeatCountSmall, {
                    val word = forger.aWord(Case.ANY)
                    assertThat(word)
                            .matches("[aeiouyAEIOUY]?([zrtpqsdfghjklmwxcvbnZRTPQSDFGHJKLMWXCVBN][aeiouyAEIOUY])*[zrtpqsdfghjklmwxcvbnZRTPQSDFGHJKLMWXCVBN]?")
                    assertThat(word.length)
                            .isGreaterThan(0)
                            .isLessThan(32)
                })
            }

            it("forges a lipsum sentence of size 1") {
                repeat(testRepeatCountSmall, {
                    val size = 1
                    val case = forger.aValueFrom(Case::class.java)
                    val word = forger.aSentence(case, size)

                    assertThat(word)
                            .isEqualTo("‽")
                })
            }

            it("forges a lowercase lipsum sentence") {
                repeat(testRepeatCountSmall, {
                    val size = forger.aSmallInt() + 1
                    val word = forger.aSentence(Case.LOWER, size)

                    assertThat(word)
                            .hasSize(size)
                            .matches("([a-z]+ )*[a-z]+\\.")
                })
            }

            it("forges an uppercase lipsum sentence") {
                repeat(testRepeatCountSmall, {
                    val size = forger.aSmallInt() + 1
                    val word = forger.aSentence(Case.UPPER, size)
                    assertThat(word)
                            .hasSize(size)
                            .matches("([A-Z]+ )*[A-Z]+\\.")
                })
            }

            it("forges a capitalized lipsum sentence") {
                repeat(testRepeatCountSmall, {
                    val size = forger.aSmallInt() + 1
                    val word = forger.aSentence(Case.CAPITALIZE, size)
                    assertThat(word)
                            .hasSize(size)
                            .matches("[A-Z][a-z]*( [A-Z][a-z]+)*\\.")
                })
            }

            it("forges a sentence capitalized lipsum sentence") {
                repeat(testRepeatCountSmall, {
                    val size = forger.aSmallInt() + 1
                    val word = forger.aSentence(Case.CAPITALIZED_SENTENCE, size)
                    assertThat(word)
                            .hasSize(size)
                            .matches("[A-Z][a-z]*( [a-z]+)*\\.")
                })
            }

            it("forges a sentence capitalized lipsum sentence of any size") {
                repeat(testRepeatCountSmall, {
                    val word = forger.aSentence(Case.CAPITALIZED_SENTENCE)
                    assertThat(word)
                            .matches("[A-Z][a-z]+( [a-z]+)*\\.")
                    assertThat(word.length)
                            .isGreaterThan(4)
                            .isLessThanOrEqualTo(260)
                })
            }

            it("forges an uppercase hexadecimal string") {
                repeat(testRepeatCountSmall, {
                    val size = forger.aTinyInt()
                    val word = forger.anHexadecimalString(Case.UPPER, size)
                    assertThat(word)
                            .hasSize(size)
                            .matches("[A-F0-9]+")
                })
            }

            it("forges a lowercase hexadecimal string") {
                repeat(testRepeatCountSmall, {
                    val size = forger.aTinyInt()
                    val word = forger.anHexadecimalString(Case.LOWER, size)
                    assertThat(word)
                            .hasSize(size)
                            .matches("[a-f0-9]+")
                })
            }

            it("forges a url string") {
                repeat(testRepeatCountSmall, {
                    val url = forger.aUrl()
                    assertThat(url)
                            .matches(Regex("""[a-z]+://[a-z]+\.[a-z]+\.[a-z]+/(([\w]+/)*|([\w-]+))(#\w+)?(\?\w+=\w+(&\w+=\w+)*)?""").pattern)
                })
            }

            it("forges an email string") {
                repeat(testRepeatCountSmall, {
                    val email = forger.anEmail()
                    assertThat(email)
                            .matches(Regex("""[\w._\-+]+@([a-z]+\.)*[a-z]+""").pattern)
                })
            }
        }

        context("forging constrained string ") {

            it("forges an hexadecimal string") {
                repeat(testRepeatCountSmall, {
                    val url = forger.aString(StringConstraint.HEXADECIMAL)
                    assertThat(url)
                            .matches("[a-fA-F0-9]+")
                })
            }

            it("forges a word string") {
                repeat(testRepeatCountSmall, {
                    val url = forger.aString(StringConstraint.WORD)
                    assertThat(url)
                            .matches("[aeiouyAEIOUY]?([zrtpqsdfghjklmwxcvbnZRTPQSDFGHJKLMWXCVBN][aeiouyAEIOUY])*[zrtpqsdfghjklmwxcvbnZRTPQSDFGHJKLMWXCVBN]?")
                })
            }

            it("forges a lipsum string") {
                repeat(testRepeatCountSmall, {
                    val url = forger.aString(StringConstraint.LIPSUM, Case.CAPITALIZED_SENTENCE)
                    assertThat(url)
                            .matches("[A-Z][a-z]+( [a-z]+)*\\.")
                })
            }

            it("forges a url string") {
                repeat(testRepeatCountSmall, {
                    val url = forger.aString(StringConstraint.URL)
                    assertThat(url)
                            .matches(Regex("""[a-z]+://[a-z]+\.[a-z]+\.[a-z]+/(([\w]+/)*|([\w-]+))(#\w+)?(\?\w+=\w+(&\w+=\w+)*)?""").pattern)
                })
            }

            it("forges an email string") {
                repeat(testRepeatCountSmall, {
                    val email = forger.aString(StringConstraint.EMAIL)
                    assertThat(email)
                            .matches(Regex("""[\w._\-+]+@([a-z]+\.)*[a-z]+""").pattern)
                })
            }
        }

        context("forging regex based strings ") {
            it("forges a regex based string") {
                val regexes = arrayOf(
                        // wildcard
                        "",
                        ".?",
                        ".*",
                        ".+",

                        // choice
                        "[aeiou][tkfprs]",
                        "[a-h][i-p][q-z]",
                        "[a-h]+[i-p]*[q-z]?",
                        "[a-h]-[q-z]",

                        // groups
                        "([a-h]-[q-z])+",
                        "(([0-9]-)+[q-z]+\n)+",
                        "((foo?)(ba[rz]))+",

                        // character classes
                        "[a-h]\\s+[q-z]",
                        "(\\s\\S)",
                        "\\w\\w \\d\\d\\d \\w\\w",
                        "\\w\\W / \\d\\D",

                        // whitespaces
                        "\\t\\n",

                        // escaped characters
                        "\\<\\(\\[\\{\\\\\\^\\-\\=\\$\\!\\|\\]\\}\\)\\?\\*\\+\\.\\>",

                        // quantifier range
                        "[abc]{3}-[xyz]{2,9}",

                        // Or
                        "abc|xyz",
                        "foo|ba[rz]|spam|bacon",
                        "test(foo|bar)"
                )

                regexes.forEach {
                    val regex = it
                    repeat(testRepeatCountSmall, {
                        val res = forger.aStringMatching(regex)
                        assertThat(res)
                                .matches(regex)

                        val res2 = forger.aStringMatching(Regex(regex))
                        assertThat(res2)
                                .matches(regex)
                    })
                }
            }
        }

        // endregion


    }
})