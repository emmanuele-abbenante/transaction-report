CREATE TABLE TRANSACTION (
  TRANSACTION_DATE_TIME TIMESTAMP,
  VALUE_DATE DATE,
  REASON VARCHAR(100),
  DESCRIPTION VARCHAR(500),
  CURRENCY VARCHAR(5),
  CURRENCY_AMOUNT DOUBLE,
  CARD_NUMBER VARCHAR(20),
  EUR_AMOUNT DOUBLE,
  COUNTERPART VARCHAR(5),
  ATM_NAME VARCHAR(100),
  COUNTERPART_IBAN VARCHAR(30),
  PAYMENT_REASON VARCHAR(100)
)