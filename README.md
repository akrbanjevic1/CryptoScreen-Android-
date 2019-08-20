# CryptoScreen
An Android App I made that retrieves real-time data about Crypto currencies. Currently calls data on BitCoin, Ethereum, and LiteCoin.
This app was initially created to help me learn how to make my Android apps interact with API's. For this application, I am using the Alpha
Vantage API (found at: https://www.alphavantage.co/). The way the app is structured is as follows:

1. Main activity (with 1 button) that upon click will take you to the second activity.
2. Second Activity (with 3 buttons) that upon click will retrieve the data in JSON format for the three crypto-currencies.

The source for the image is here:
https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwjzkbaxsqvjAhWPVs0KHbVVADoQjRx6BAgBEAU&url=https%3A%2F%2Ffreerangestock.com%2Fphotos%2F53397%2Fintertwined-arrows-background-shows-futuristic-wallpaper-or-tech.html&psig=AOvVaw0jljIZVR22SbgRCvHPITcN&ust=1562883903499685

The values that this app returns are as follows:
  1. Original Currency (Cryptocurrency)
  2. Receiving Currency (Fiat Currency)
  3. Amount in the fiat currency (set to the US Dollar (USD) for now)
  4. The current date
  5. Timezone
  
All in all, this app has been a fun learning experience. In the future, I will be combining
the parse methods for the textviews into one, but for now, I wanted to force myself
to get practice by writing the methods multiple times. In addition, I also aim to 
allow the user to change their fiat currency (so it's not just USD). 

7/28/2019:
I am now working on adding Firebase to the app. I have already created the activity for the log-in screen, and I have written the code to start that activity. In addion, I am currently in the process of adding the necessary dependencies. 
