#!/bin/sh

APP_PATH=/home/emmanuele/workspace/java/transaction-report/target/transaction-report-0.0.1-SNAPSHOT-fat.jar
TRANSACTIONS_DIR=/home/emmanuele/Scrivania/Documenti/Finanze\ personali/Movimenti

# Loading credit card transactions
for year in $(seq 2017 2018)
do
    for month in $(seq -w 1 12)
    do
        echo "Period: "$year-$month
        echo
        java -jar $APP_PATH "$TRANSACTIONS_DIR/$year-$month""_carta_credito.xml" CREDIT_CARD
        echo "========================================================================"
    done
done

# Loading current account transactions
for year in $(seq 2015 2018)
do
    for month in $(seq -w 1 12)
    do
        echo "Period: "$year-$month
        echo
        java -jar $APP_PATH "$TRANSACTIONS_DIR/$year-$month""_conto_corrente.xml" CURRENT_ACCOUNT
        echo "========================================================================"
    done
done
