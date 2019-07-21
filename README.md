# JSON-Conversion
Convert JSON files to HTML

Copy the JSON.jar and lib folder to any convenient place on your computer.  Then execute the JSON.jar file.  The lib folder must be directly below the folder holding JSON.jar.
  
  
JSON CONVERTER
Overview:  
This program converts JSON formatted text files into more readable HTML.  It is tailored specifically to those JSON files produced 
by a formerly popular knitting site.  The program will however operate on all properly formatted JSON files. A file named json.css 
is created along with the HTML files. This .css file must be in the same folder with the html files for the html files to be presented 
as intended. 

File Selection:
The file selection interface allows the user to: 
  1) Select a single JSON file. 
  2) Select multiple JSON files. 
  3) Select a folder name that holds JSON files. If a file is selected then those selected files may have any suffix.  
It is up to the user to ensure that they are valid JSON files from the knitting site.  If a folder is selected then the program will 
convert all files found in that folder with a suffix of ".json". All HTML output files will be written to the same folder as the source 
JSON files.
NOTE: A folder with a large number of files can take a very long time to process. My wife's favorites files, numbering in excess of 1400 files, 
  required a few minutes to process.. 
  
Preferences:
By default all HTML produced is black type on a white background.  You may prefer to display categories of text in a different manner.  
The content of the output is unchanged.  Only the presentation is effected. 

Disclaimer:
This program was thrown together in a few evenings.  It has not had the luxury of the usual software life cycle advantages such as project 
management, unit testing, beta testing, limited release and review.  Nope, I banged out some code and hoped for the best.  
And so, if this program does not perform as intended please let me know and I'll have another go at it.
