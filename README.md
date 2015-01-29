# trelloChallenge
Trello Employment Challenge - Android App

Employment at Trello.com is generally contingent on completing a challenge question.

For a recent Android Developer position the challenge was as follows:

 Find an 8 letter string of characters that contains only letters from

    `acdegilmnoprstuw`

such that the hash(the_string) is

    `25180466553932`

if hash is defined by the following pseudo-code:

`
    Int64 hash (String s) {
        Int64 h = 7
        String letters = "acdegilmnoprstuw"
        for(Int32 i = 0; i < s.length; i++) {
            h = (h * 37 + letters.indexOf(s[i]))
        }
        return h
    }
`

This Android app solves the challenge, displays the solution, and displays my contact information.
