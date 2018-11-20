/*CREATE DATABASE musicdb;
USE musicdb;

CREATE TABLE interpreter(
interID INT AUTO_INCREMENT,
interName VARCHAR(40),
PRIMARY KEY (interID)
);

CREATE TABLE album (
albumID INT AUTO_INCREMENT,
albumName VARCHAR(40),
interID INT,
PRIMARY KEY (albumID),
FOREIGN KEY (interID) REFERENCES interpreter(interID)
);

CREATE TABLE song(
songID INT AUTO_INCREMENT,
songName VARCHAR(40),
songLength INT,
albumID INT,
PRIMARY KEY (songID),
FOREIGN KEY (albumID) REFERENCES album(albumID)
);*/


SELECT *
FROM album
INNER JOIN interpreter ON interpreter.interID = album.interID
INNER JOIN song ON album.albumID = song.albumID;

INSERT INTO interpreter
SELECT NULL, 'Mustermääääänn';

INSERT INTO album
SELECT NULL, 'PHP'
	 , (SELECT interID FROM interpreter ORDER BY interID DESC LIMIT 1 );

INSERT INTO song
SELECT NULL, 'Dort drüben im $see', 150, (SELECT albumID FROM album ORDER BY albumID DESC LIMIT 1 );


SELECT * FROM song;

DELETE FROM album WHERE albumID!=0;
DELETE FROM interpreter WHERE interID = 1;
DELETE FROM song WHERE songID = 4;



