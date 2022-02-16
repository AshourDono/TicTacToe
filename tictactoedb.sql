
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

-- #=======================================================================================#
-- #			   	                      Database: `tictactoedb`        		        	           #
-- #=======================================================================================#

CREATE DATABASE IF NOT EXISTS `tictactoedb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `tictactoedb`;

-- #=======================================================================================#
-- #			   	                  -- Table structure for table `games`	        	           #
-- #=======================================================================================#

CREATE TABLE IF NOT EXISTS`games` (
  `gid` bigint(20) UNSIGNED NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `turn` enum('X','O','') NOT NULL DEFAULT '',
  `cell0` enum('X','O','') NOT NULL DEFAULT '',
  `cell1` enum('X','O','') NOT NULL DEFAULT '',
  `cell2` enum('X','O','') NOT NULL DEFAULT '',
  `cell3` enum('X','O','') NOT NULL DEFAULT '',
  `cell4` enum('X','O','') NOT NULL DEFAULT '',
  `cell5` enum('X','O','') NOT NULL DEFAULT '',
  `cell6` enum('X','O','') NOT NULL DEFAULT '',
  `cell7` enum('X','O','') NOT NULL DEFAULT '',
  `cell8` enum('X','O','') NOT NULL DEFAULT '',
  `player1` bigint(20) UNSIGNED NOT NULL,
  `player2` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- #=======================================================================================#
-- #			   	                  Table structure for table `players`		        	           #
-- #=======================================================================================#

CREATE TABLE IF NOT EXISTS `players` (
  `pid` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(150) NOT NULL,
  `passwd` varchar(150) NOT NULL,
  `status` enum('offline','online','busy','none') NOT NULL DEFAULT 'none',
  `score` bigint(150) UNSIGNED NOT NULL DEFAULT 0,
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- #=======================================================================================#
-- #			   	                  Dumping data for table `players`  		        	           #
-- #=======================================================================================#

INSERT INTO `players` (`pid`, `username`, `passwd`, `status`, `score`) VALUES
(1, 'alabasy', '123456789', 'offline', 30),
(2, 'ashour', '123456789', 'offline', 20),
(3, 'nermeen', '123456789', 'offline', 50),
(4, 'elsheikh', '123456789', 'offline', 40),
(5, 'nada', '123456789', 'offline', 80),

-- #=======================================================================================#
-- #			   	                        Indexes for table `games`		            	           #
-- #=======================================================================================#

ALTER TABLE `games`
  ADD PRIMARY KEY (`gid`),
  ADD UNIQUE KEY `gid` (`gid`),
  ADD KEY `player1` (`player1`),
  ADD KEY `player2` (`player2`);

-- #=======================================================================================#
-- #			   	                      Indexes for table `players`		            	           #
-- #=======================================================================================#

ALTER TABLE `players`
  ADD PRIMARY KEY (`pid`),
  ADD UNIQUE KEY `pid` (`pid`),
  ADD UNIQUE KEY `username` (`username`) USING HASH;

-- #=======================================================================================#
-- #			   	                    AUTO_INCREMENT for table `games`		        	           #
-- #=======================================================================================#

ALTER TABLE `games`
  MODIFY `gid` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

-- #=======================================================================================#
-- #			   	                  AUTO_INCREMENT for table `players`		        	           #
-- #=======================================================================================#

ALTER TABLE `players`
  MODIFY `pid` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

-- #=======================================================================================#
-- #			   	                    Constraints for table `games`   		        	           #
-- #=======================================================================================#

ALTER TABLE `games`
  ADD CONSTRAINT `games_ibfk_1` FOREIGN KEY (`player1`) REFERENCES `players` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `games_ibfk_2` FOREIGN KEY (`player2`) REFERENCES `players` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
