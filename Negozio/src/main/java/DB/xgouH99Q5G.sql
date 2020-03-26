-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Mar 26, 2020 alle 08:51
-- Versione del server: 8.0.13-4
-- Versione PHP: 7.2.24-0ubuntu0.18.04.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `xgouH99Q5G`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotti`
--

CREATE TABLE `prodotti` (
  `idProdotto` int(11) NOT NULL,
  `nome` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `qta` int(11) DEFAULT NULL,
  `prezzo` double DEFAULT NULL,
  `descrizione` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dump dei dati per la tabella `prodotti`
--

INSERT INTO `prodotti` (`idProdotto`, `nome`, `qta`, `prezzo`, `descrizione`) VALUES
(9, 'kinder', 2, 1, 'cioccolato'),
(10, 'mele', 4, 1, 'frutta');

-- --------------------------------------------------------

--
-- Struttura della tabella `scontrino`
--

CREATE TABLE `scontrino` (
  `idscontrino` int(11) NOT NULL,
  `utente` int(11) DEFAULT NULL,
  `data` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `costo` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dump dei dati per la tabella `scontrino`
--

INSERT INTO `scontrino` (`idscontrino`, `utente`, `data`, `costo`) VALUES
(123, 123, '25/03/20', NULL),
(145, 123, '25/03/20', 4),
(172, 123, '25/03/20', 2),
(177, 123, '25/03/20', 0),
(191, 123, '25/03/20', NULL),
(207, 123, '25/03/20', 2),
(208, 123, '25/03/20', NULL),
(214, 123, '25/03/20', NULL),
(216, 123, '25/03/20', 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `idUtente` int(11) NOT NULL,
  `nome` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pass` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `eta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`idUtente`, `nome`, `pass`, `eta`) VALUES
(123, 'admin', 'admin', 22);

-- --------------------------------------------------------

--
-- Struttura della tabella `vendite`
--

CREATE TABLE `vendite` (
  `idScontrino` int(11) DEFAULT NULL,
  `idProdotto` int(11) DEFAULT NULL,
  `qtaVenduta` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dump dei dati per la tabella `vendite`
--

INSERT INTO `vendite` (`idScontrino`, `idProdotto`, `qtaVenduta`) VALUES
(214, 9, 2),
(214, 9, 2),
(214, 10, 2),
(191, 9, 2),
(191, 10, 2),
(208, 9, 2),
(207, 10, 2),
(145, 9, 2),
(145, 10, 2),
(172, 10, 2);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `prodotti`
--
ALTER TABLE `prodotti`
  ADD PRIMARY KEY (`idProdotto`);

--
-- Indici per le tabelle `scontrino`
--
ALTER TABLE `scontrino`
  ADD PRIMARY KEY (`idscontrino`),
  ADD KEY `utente_idx` (`utente`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`idUtente`);

--
-- Indici per le tabelle `vendite`
--
ALTER TABLE `vendite`
  ADD KEY `prodotto_idx` (`idProdotto`),
  ADD KEY `scontrino_idx` (`idScontrino`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `prodotti`
--
ALTER TABLE `prodotti`
  MODIFY `idProdotto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `idUtente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=124;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `scontrino`
--
ALTER TABLE `scontrino`
  ADD CONSTRAINT `utente` FOREIGN KEY (`utente`) REFERENCES `utente` (`idutente`);

--
-- Limiti per la tabella `vendite`
--
ALTER TABLE `vendite`
  ADD CONSTRAINT `prodotto` FOREIGN KEY (`idProdotto`) REFERENCES `prodotti` (`idprodotto`),
  ADD CONSTRAINT `scontrino` FOREIGN KEY (`idScontrino`) REFERENCES `scontrino` (`idscontrino`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
