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
  PRIMARY KEY (TRANSACTION_DATE_TIME, VALUE_DATE, DESCRIPTION)
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
INSERT INTO COUNTERPARTIES (NAME, EXPENSE_KIND) VALUES ('LORETO ARGENTINA M12', 'Abbonamento mezzi');
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