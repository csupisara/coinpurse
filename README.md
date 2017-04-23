# CoinPurse tasks by Supisara Chuthathumpitak

I ran the tasks on a MacBook Pro, and got these results:

## Filter values by currency of Rupee
 INPUT: 10.0-Rupee 10.0-Baht 1.0-Baht 10.0-Baht 0.5-Rupee 5.0-Baht 1.0-Ringgit 5.0-Ringgit 0.5-Rupee 2.0-Ringgit 1.0-Rupee 50.0-Ringgit 0.25-Baht 2.0-Baht
RESULT: 10.0-Rupee 0.5-Rupee 0.5-Rupee 1.0-Rupee

## Sort values by currency
 INPUT: 1.0-Rupee 1.0-Baht 1.0-Ringgit 10.0-Rupee 5.0-Ringgit 0.5-Rupee 0.25-Baht 0.5-Rupee 2.0-Ringgit 10.0-Baht 5.0-Baht 50.0-Ringgit 10.0-Baht 2.0-Baht
RESULT: 1.0-Baht 0.25-Baht 10.0-Baht 5.0-Baht 10.0-Baht 2.0-Baht 1.0-Ringgit 5.0-Ringgit 2.0-Ringgit 50.0-Ringgit 1.0-Rupee 10.0-Rupee 0.5-Rupee 0.5-Rupee

## Sum values by currency
monetary objects= 0.5-Rupee 50.0-Ringgit 10.0-Baht 5.0-Baht 2.0-Baht 0.5-Rupee 10.0-Baht 2.0-Ringgit 1.0-Baht 5.0-Ringgit 1.0-Ringgit 10.0-Rupee 0.25-Baht 1.0-Rupee
28.25 Baht
12.0 Rupee
58.0 Ringgit

# Explanation of this program...
This program can insert and remove monetary objects from the purse. For examples, coins and banknote. A purse has a fixed capacity, but the value is unlimited. When withdraw a money, it will take out the most valuable first.
