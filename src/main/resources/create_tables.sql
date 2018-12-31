CREATE SCHEMA TRANSACTION_REPORT;

CREATE TABLE TRANSACTIONS (
  TRANSACTION_DATE_TIME TIMESTAMP,
  VALUE_DATE DATE,
  REASON VARCHAR(100),
  DESCRIPTION VARCHAR(500),
  CURRENCY VARCHAR(5),
  CURRENCY_AMOUNT DOUBLE,
  CARD_NUMBER VARCHAR(20),
  EUR_AMOUNT DOUBLE,
  COUNTERPART VARCHAR(100),
  ATM_NAME VARCHAR(100),
  COUNTERPART_IBAN VARCHAR(30),
  PAYMENT_REASON VARCHAR(100),
  FOREIGN_CURRENCY VARCHAR(5),
  EXCHANGE_RATE DOUBLE
)

CREATE TABLE COUNTERPARTIES (
  NAME VARCHAR(100),
  EXPENSE_KIND VARCHAR(100)
)

INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('PENNY MARKET', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('PAM PANORAMA MI TIBALDI', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CDC 1070 SMA MILANO SAN G', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('UPIM SAN GOTTARDO', 'Abbigliamento');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FARMACIA STAZIONE PORTA G', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FARMACIA MONCUCCO SNC', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('BEATO TE', 'Pranzi lavoro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('SCARPAMONDO', 'Abbigliamento');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ATLANTIC LORENTEGGIO', 'Pranzi lavoro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ESSELUNGA LORENTEGGIO', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CDC 4250 SMA MI TIBAL 920', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CASH ISP 1221-MILAN', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CASH ISP 1220-MILAN', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('BANCA POP DI MILANO', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('UBI BANCA MILANO', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('Gabriella Gruppi', 'Affitto');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MEDIAWORLD MI TROYA CC', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('LORETO ARGENTINA M12', 'Abbonamento/biglietti ATM');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CREPEATALY S.R.L. SEMPLIF', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ESSELUNGA LORENTEGGIO 697', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FABBRISCA VAPORE 7 - U', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FARMACIA TIBALDI', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MC DONALD S', 'Pranzi lavoro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MC DONALD S 990', 'Pranzi lavoro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('OVIESSE', 'Abbigliamento');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('PENNY MARKET 375', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('PRINCI', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('TINTORIA LAVANDERIA DI TE', 'Abbigliamento');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('VENCHI 384', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('PIZZASLICE S.R.L.', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('PAM PANORAMA MI TIBAL 125', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ESSELUNGA PAPINIANO 217', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CENTROMEDICO SANTAGOS 906', 'Visite mediche/esami clinici');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FARMACIA STAZIONE P.T', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('NANO BLEU', 'Altro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('PAM PANORAMA MI TIBAL 125', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MONDADORI MEGASTORE D 214', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ROMANO GIUSEPPE', 'Altro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('PAGAM BOLLETT TABACCHERIA', 'Bollette');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ESSELUNGA CASSALA 648', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('OSPEDALE A.S.S.T. SANTI P', 'Visite mediche/esami clinici');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('COSE NOSTRE 237', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ATLANTIC LORENTEGGIO 576', 'Pranzi lavoro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('PASTICCERIA SIENI', 'Altro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('TIPOTA PUB', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CASH ISP 1560-MILAN', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CHEBANCA SPA MILANO  ', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ASAHI DI WU BULONG  020', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CENTRO MEDICO SANTAGO 682', 'Visite mediche/esami clinici');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('KING S PUB', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MANGIA SPAGHETTI', 'Pranzi lavoro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('M.C. FOOD', 'Pranzi lavoro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FAI VILLA NECCHI 372', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('GHE PENSI MI', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('DECATHLON 00000342 373', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MAX 3R', 'Abbigliamento');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CDC 8719 CORSO GENOVA 820', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FARMACIA IMPERIA SNC DI M', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('PANINO GIUSTO S.R.L.', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CDI CENTRO DIAGNOSTIC 610', 'Visite mediche/esami clinici');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('AEROGARA- PRISTIGASHTI', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FIM CO 2015 OOD', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('DELABAR OOD', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('BAR 3-SOFIA AIRPORT', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ALL AMERICAN DINER SRL', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('BERTAME LORENZO', 'Pranzi lavoro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CENTROMEDICO SANTAGOS 045', 'Visite mediche/esami clinici');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('D  G', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FARMACIA DEI PADRI FB 988', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('JUST CAFE 294', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MEDIA WORLD', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('RISTORANTE FRESCO CIM 412', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('RISTORANTE IL CAMINO', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CONBIPEL 055', 'Abbigliamento');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('SCARPE  SCARPE 479', 'Abbigliamento');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('3286 OVS MILANO BUENO 988', 'Abbigliamento');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ASST NORD MILANO POLIAMBU', 'Visite mediche/esami clinici');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ATM M2 PIOLA', 'Abbonamento/biglietti ATM');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ATM M2 ROMOLO', 'Abbonamento/biglietti ATM');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ATM M2 ROMOLO 118', 'Abbonamento/biglietti ATM');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('AVUCCIRIA', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('BAR TOURING', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CARREFOUR EXPRESS 466', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CASH ISP 3753-MILAN', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CASH WITHDRAWAL', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('C.D.I. SPA P RIALZATO', 'Visite mediche/esami clinici');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('C.D.I.SPA V.LE ABRUZZ 625', 'Visite mediche/esami clinici');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('EDICOLA M2 ROMOLO 709', 'Abbonamento/biglietti ATM');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ESSELUNGA SESTO ULTER 154', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FARMACIA CALO', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FARMACIA DELLA RIPA', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FARMACIA MEDA 605', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('GABEL 988', 'Casa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('H  M 358', 'Abbigliamento');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('HODELI SNC DI HUANG XI', 'Abbigliamento');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('IKEA CORSICO 971', 'Casa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('KI POINT SNC', 'Casa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('LA CUCCUMA', 'Pranzi lavoro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('LIBRERIA FELTRINELLI 085', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MACELLERIA MAGGIO MARI', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MERCERIA', 'Abbigliamento');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MI  TI', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MUSEO DELLA CITTA DI 141', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MUSEO DELLA SCIENZA E TEC', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('PINACOTECA DI BRERA 577', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('SERVIZI MUSEALI BOLOGNA', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('STAR RISE 190', 'Pranzi lavoro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('UNICREDIT - MILANO V', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('UPCYCLE S.R.L.', 'Pranzi lavoro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('VENERANDA BIBLIOTECA AMBR', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('VIA ALZAIA NAVIGLIO PAVES', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('BUFFET PALERMO 074', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CIVITA SICILIA S.R.L.', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('COECO MASCHERPA 883', 'Casa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('LA CUBANA CAFFE', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('NUBIANA - SAN GOTTARDO', 'Casa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('PENTAROSA', 'Casa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('PayPal Europe S.a.r.l. et Cie S.C.A', '');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('SCAMBIO CAFFE E CUCI', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('SISALPAY - MI512', 'Bollette');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('WIND 681', 'Bollette');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ZG S.R.L.', 'Pranzi lavoro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CON.FID. STATION SRL', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('GS SPA', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('A2A ENERGIA', 'Bollette');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('Amazon Prime Now Italy', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('Amazon.it Retail', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('Foodora Italy', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ILIAD Italia', 'Bollette');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('INTERNET BOOKSHOP ITAL', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('RYANAIR', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('WIND.IT RICARICA CELLULAR', 'Bollette');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ZIG ZAG SHARING', 'Trasporti');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('Amazon *Mktplce EU','Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('AMAZON IT','Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('Amazon Prime Now IT','Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('Amazon.it Prime','Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CDC 4250 SMA MI TIBAL','Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CENTRO MEDICO SANTAGOS','Visite mediche/esami clinici');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('EASYJET','Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('EDIMAKERSRL','Altro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('EPRICE SRL','Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ESSELUNGA CASSALA','Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('EVENTIM / TICKETONE','Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FACEBK','Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('Foodora Berlin','Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('IKEA CORSICO','Casa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MALPENSOMMA LOMBARD','Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MUSEO POLDI PEZZOLI','Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('NTV WWW.ITALOTREROMA','Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('PrimeNowMktp','Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('TRENITALIA','Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('VIEDETESORI','Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('VOLOTEA AIRLINES','Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('WIKIMEDIA SAN FRANCISCO','Altro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('WIND.IT','Bollette');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('WWW.CDI.MILANO','Visite mediche/esami clinici');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('WWW.JUSTEAT.IT','Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('WWW.MIMOTO.IT','Trasporti');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('WWW.MOBIKE.COM','Trasporti');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('TRIPSTA','Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('VIVATISANT AGATA','Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('PAGO LA PA','Bollette');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('WWW.TIMILANO','Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('DIGITALSERV','Tempo libero');

INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('4250 SMA MI TIBALDI VIALE TIBALDI7', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ACCENTURE TECHNOLOGY SOLUTIONS SRL', 'Stipendio');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('AMOMA.COM HOTELS', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ART FACTORY RISTORANTE', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('AUTOGRILL SPA 0373 358', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('A VUCCIARIA VIA ALZAIA NAVIGLIO PAVES', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('AZIENDA FARMACIE MILAN', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('BANCAITB-TABACCHERIA RIV VIA MEDA GIUSEPPE 2', 'Bollette');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('BANCA POPOLARE COMMERCIO E INDUSTRIA', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('BANCA POPOLARE DI MILANO', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('BANCO DI BRESCIA SPA', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('BAR IMBARCHI LINATE 861', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CANTO DEI NELLI 652', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CASA DI CURA MULTIMEDICA VIA SAN VITTORE 12', 'Visite mediche/esami clinici');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CASH ISP 4595-CORSI', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CASSA DI RISPARMIO DI PARMA E PIACENZA', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CHURRASCARIA PICANHAS PIAZZALE LORENZO LOTTO, 1', 'Pranzi lavoro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('Claudio Simonetti', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('COOP. FARM. COLOMBO CORSO C. COLOMBO 1', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('COSE NOSTRE VIA DELLA CHIESA RO', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CREDITO SICILIANO S.P.A.', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('DECATHLON 00000342 485', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('DECATHLON 00000342 LARGO CAIROLI', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('DEUTSCHE BANK SPA', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ESSELUNGA SESTO ULTERIAN V.PO 7', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FABBRICA PIZZERIA', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FARMACIA COMUNALE N. 13', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FARMACIA IMPERIA SNC D VIA SPEZIA, 20', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FARMACIA MONCUCCO SNC VIA RIMINI 29', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FARMACIA STAZIONE P.TA VIA VIGEVANO 45', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FARMACIA TIBALDI S.N.C VIALE TIBALDI, 15', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FARMACIA TRIVULZIO', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FERRAMENTA DAMA DI DANIE VIA MEDA 25', 'Casa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FOTO OTTICA CAVOUR VIA FATEBENEFRATELL', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('GARZARELLA MARIA ANTONIETTA MARSIB ILIO ROBERTA', 'Bollette');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('H  M 523', 'Abbigliamento');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('H  M 7 VIA RUGGERO VII 14/', 'Abbigliamento');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('IL LIBRACCIO-VIA CORSI VIA CORSICO 9', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('INTESA SANPAOLO SPA', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('KIPOINT FIRENZE SMN', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('LA FELTRINELLI LIBRI E MUSICA VIA CAVOUR 133', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('LIBRERIA BONOLA VIA QUARENGHI 23', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('LIBRERIA FELTRINELLI 2 VIA UGO FOSCOLO 1/3', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MC1 MODA UOMO', 'Abbigliamento');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MC DONALD S VIA QUARENGHI 23', 'Pranzi lavoro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MI CAMERA BOOKSTORE VIA MEDARDO ROSSO 19', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MITI VIA ALZAIA NAV. PAVESE 8', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('MONDADORI DUOMO CENTER 2 VIA DOGANA 2', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('OSPEDALE AZIENDA OSPEDALI', 'Visite mediche/esami clinici');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('OSPEDALE AZIENDA OSPED VIA ANTONIO DI RUDINI, 8', 'Visite mediche/esami clinici');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('OVIESSE VIA SPADARI 2', 'Abbigliamento');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('PARAFARMACIA SAN RICC 767', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('RISTORANTE MONTE STELL VIA CARLO VALVASSORI PERO', 'Pranzi lavoro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('RYANAIR IRDBUQ0', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('RYANAIR WZJV9R0', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('SKIRA EDITORE VIA TORINO 61', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('SKIRA P.ZZA DUOMO N.12', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('Soleventi and Tour', 'Altro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('SOY RESTAURANT VIA TIRABOSCHI, 1', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('SUPERMERCATO ESSELUNGA VIA CASSALA 22 -', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('TIJUANA CAFE', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('TRATTORIA NAPOLETANA VIA MATTEO MARIA BOIARDO', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('TRONY VIA DELLA PALLA 2', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('UNICREDIT - PALERMO', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('UNICREDIT SPA', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('UNICREDIT - UGIS LIV', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('WWW.ALITALI 0552327003759', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('VIALE TIBALDI', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('LA CERCHIA SRL', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('LINEA COMUNE', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('NUOVO TRITTICO SRL  ', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('Fulvia Sara Rulli', 'Viaggi');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('Bassi Pietro', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('I GREEN SRL', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ANTICA BIRRERIA PERONI', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('BAR RECUPERO', 'Altro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CASH ISP 8838-PALER', 'Prelievo');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CDC 4250 SMA MI TIBALDI', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CICCIO PASSAMI LOLIO', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('CUBANA CAFE', 'Altro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('DETERSIVI FERDICO', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('DOLCERIA PALAZZOLO S.R', 'Altro');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('Edoardo Iacono', 'Tempo libero');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('FARMACIA CANNATA SNC', 'Farmaci');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('LA PIANA', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('LIDL 9724', 'Spesa');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('WOODSTOCK', 'Cene/aperitivi/etc');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('ABBENANTE EMMANUELE', '');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('Emmanuele Abbenante', '');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('GGG S.R.L.', '');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('18617518', '');
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('GENERAL SERVICE  SECU VIALE ROMOLO 6', '');

CREATE TABLE COUNTERPARTIES_PATTERNS (
  PATTERN VARCHAR(100),
  NAME VARCHAR(100)
)

INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('Amazon Prime Now Italy.*', 'Amazon Prime Now Italy');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('A2A ENERGIA.*', 'A2A ENERGIA');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('Amazon.it Retail.*', 'Amazon.it Retail');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('.*ZIG ZAG SHARING.*', 'ZIG ZAG SHARING');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('Foodora Italy.*', 'Foodora Italy');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('FOODORA ITALY.*', 'FOODORA ITALY');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('ILIAD Italia.*', 'ILIAD Italia');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('INTERNET BOOKSHOP ITAL.*', 'INTERNET BOOKSHOP ITAL');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('RYANAIR.*', 'RYANAIR');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('WIND.IT RICARICA CELLULAR.*', 'WIND.IT RICARICA CELLULAR');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('.*NTV WWW.ITALOTREROMA.*','NTV WWW.ITALOTREROMA');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('.*WWW.CDI.MILANO.*','WWW.CDI.MILANO');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('Amazon \\*Mktplce EU.*','Amazon *Mktplce EU');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('AMAZON IT.*','AMAZON IT');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('AMAZON ITALY RETAIL.*','AMAZON ITALY RETAIL');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('Amazon Prime Now IT.*','Amazon Prime Now IT');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('Amazon.it Prime.*','Amazon.it Prime');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('ATM M2 ROMOLO.*','ATM M2 ROMOLO');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('CDC 4250 SMA MI TIBAL.*','CDC 4250 SMA MI TIBAL');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('CENTRO MEDICO SANTAGOS.*','CENTRO MEDICO SANTAGOS');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('EASYJET.*','EASYJET');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('EPRICE SRL.*','EPRICE SRL');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('ESSELUNGA CASSALA.*','ESSELUNGA CASSALA');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('EVENTIM / TICKETONE.*','EVENTIM / TICKETONE');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('FACEBK.*','FACEBK');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('FARMACIA MONCUCCO SNC.*','FARMACIA MONCUCCO SNC');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('Foodora Berlin.*','Foodora Berlin');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('IKEA CORSICO.*','IKEA CORSICO');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('.*MALPENSOMMA LOMBARD.*','MALPENSOMMA LOMBARD');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('MUSEO POLDI PEZZOLI.*','MUSEO POLDI PEZZOLI');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('PAGO LA PA.*','PAGO LA PA');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('.*DIGITALSERV.*','DIGITALSERV');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('.*EDIMAKERSRL.*','EDIMAKERSRL');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('.*VIEDETESORI.*','VIEDETESORI');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('PENNY MARKET.*','PENNY MARKET');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('PrimeNowMktp.*','PrimeNowMktp');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('.*WWW.TIMILANO.*','WWW.TIMILANO');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('TRENITALIA.*','TRENITALIA');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('TRIPSTA.*','TRIPSTA');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('.*VIVATISANT AGATA.*','VIVATISANT AGATA');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('VOLOTEA AIRLINES.*','VOLOTEA AIRLINES');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('WIKIMEDIA SAN FRANCISCO.*','WIKIMEDIA SAN FRANCISCO');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('WIND.IT.*','WIND.IT');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('WWW.JUSTEAT.IT.*','WWW.JUSTEAT.IT');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('WWW.MIMOTO.IT.*','WWW.MIMOTO.IT');
INSERT INTO COUNTERPARTIES_PATTERNS (PATTERN, NAME) VALUES ('WWW.MOBIKE.COM.*','WWW.MOBIKE.COM');

CREATE TABLE CURR_ACC_TRANS_PATTERNS (
  PATTERN VARCHAR(500),
  FIELDS VARCHAR(200)
)

INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'Operazione VPAY del (?<date>.*) alle ore (?<time>.*) con Carta[ \t\n]*(?<cardnumber>.*) Div=(?<currency>.*) Importo in divisa=(?<currencyamount>.*) \/ Importo in Euro=(?<euramount>.*)[ \t\n]*presso (?<counterpart>.*)',
  'date;time;cardnumber;currency;currencyamount;euramount;counterpart'
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'Operazione VPAY del (?<date>.*) alle ore (?<time>.*) con Carta[ \t\n]*(?<cardnumber>.*) Div=(?<currency>.*) Importo in divisa=(?<currencyamount>.*) \/ Importo in Euro=(?<euramount>.*)[ \t\n]*presso (?<counterpart>.*) - Transazione C-less.*',
  'date;time;cardnumber;currency;currencyamount;euramount;counterpart'
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'Operazione VPAY del (?<date>.*) alle ore (?<time>.*) con Carta[ \t\n]*(?<cardnumber>.*) Div=(?<currency>.*) Importo in divisa=(?<currencyamount>.*) \/ Importo in Euro=(?<euramount>.*)[ \t\n]*presso (?<counterpart>.*)\.Tasso di cambio (?<foreignCurrency>.*)/EUR=(?<exchangeRate>.*) - Transazione C-less.*',
  'date;time;cardnumber;currency;currencyamount;euramount;counterpart;foreignCurrency;exchangeRate'
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'Operazione PagoBancomat eseguita con carta (?<cardnumber>.*) il (?<date>.*) alle ora (?<time>.*) di Abi acquirer presso (?<counterpart>.*)',
  'cardnumber;date;time;counterpart'
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'Prelievo carta del (?<date>.*) alle ore (?<time>.*) con Carta[ \t\n]*(?<cardnumber>.*) di Abi Div=(?<currency>.*) Importo in divisa=(?<currencyamount>.*) / Importo in[ \t\n]*Euro=(?<euramount>.*) presso (?<counterpart>.*)',
  'date;time;cardnumber;currency;currencyamount;euramount;counterpart'
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'Prelievo Bancomat con carta (?<cardnumber>.*) il (?<date>.*) alle ore (?<time>.*) su sportello .* della (?<counterpart>.*) presso.*',
  'cardnumber;date;time;counterpart'
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'Prelievo carta del (?<date>.*) alle ore (?<time>.*) con Carta[ \t\n]*(?<cardnumber>.*) di Abi Div=(?<currency>.*) Importo in divisa=(?<currencyamount>.*) / Importo in[ \t\n]*Euro=(?<euramount>.*) presso (?<counterpart>.*)\.Tasso di cambio (?<foreignCurrency>.*)/EUR=(?<exchangeRate>.*)',
  'date;time;cardnumber;currency;currencyamount;euramount;counterpart;foreignCurrency;exchangeRate'
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'Canone mensile Carta di Credito',
  ''
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'DA (?<counterpartiban>.*) Giroconto',
  'counterpartiban'
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'DA (?<counterpartiban>.*) GIRO da .*',
  'counterpartiban'
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'A (?<counterpartiban>.*) [gG]iroconto.?',
  'counterpartiban'
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'A (?<counterpartiban>.*) GIRO da CCA .*',
  'counterpartiban'
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  '.* ADDEBITO CARTA CREDITO .* E\/C AL .* COD\.CLIENTE: .*',
  NULL
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'BONIFICO DA VOI DISPOSTO NOP .* A FAVORE DI (?<counterpart>.*) C. BENEF. (?<counterpartiban>.*) NOTE: (?<paymentreason>.*)',
  'counterpart;counterpartiban;paymentreason'
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'Bonifico N. .* BIC Ordinante .* Data Ordine Codifica Ordinante (?<counterpartiban>.*) Anagrafica Ordinante (?<counterpart>.*) Note: (?<paymentreason>.*)',
  'counterpartiban;counterpart;paymentreason'
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'Ricarica carta prepagata MasterCard ING Direct',
  NULL
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'Operazione di ricarica telefonica .* del numero .* eseguita il .* alle ore .* con Id-transazione .*',
  NULL
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'Imposta di Bollo.*',
  NULL
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'Commissione per ricarica carta prepagata MasterCard ING Direct',
  NULL
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'STORNO SCRITTURA',
  NULL
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'Addebito mensile alert',
  NULL
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'Estratto conto carta di credito al .*',
  NULL
);
INSERT INTO CURR_ACC_TRANS_PATTERNS
(
  PATTERN,
  FIELDS
)
VALUES
(
  'Commissione prelievo contante in Italia e in Europa. Operazione del (?<date>.*) alle ore (?<time>.*) con Carta[ \t\n]*(?<cardnumber>.*) di ABI Div=(?<currency>.*) Importo in divisa=(?<currencyamount>.*)\/Importo in euro=(?<euramount>.*)[ \t\n]*presso (?<counterpart>.*)',
  'date;time;cardnumber;currency;currencyamount;euramount;counterpart'
);
