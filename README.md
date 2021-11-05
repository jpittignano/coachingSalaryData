# Salaries of Football College Coaches

## Introduction

Sports have always been a significant part of my life. Playing field hockey, a sport that is generally not that popular, I thought it would be interesting to look at collegiate level football, arguably one of the most niche things about America. Specifically, I decided to look at the salaries that these coaches receive. It is crazy to think that some of these coaches are making almost 10 million dollars, over 18 times more than the average worker in the United States. I had the desire to explore this further and look at how different factors affect the actual salary amount.

The questions that I attempted to answer with my code are:
  Which conference has the highest average salary?
  Is there a link between the size of a college and football coach salary?




## Methods

This data was generated by USA Today Sports, who is also the owner of it. They requested all the salary information from coaches at over 130 public schools. Some of the schools are under laws that do not allow them to  release full compensation data on coaches. That is why some of the data is “na” in my csv. I was able to use this data because it is technically accessible state data that was required to be given to USA Today Sports when they asked. Therefore, when they published the data along with an article, it was totally ok for me to use it.

One of the most important ways I went about answering my questions was creating my getElement method. I used it a ton of times throughout my other functions, and it made my code a lot less repetitive and easier to manage. This method, when I called it, found any element in my file depending on the line and column number that matched with the parameters. For my first question, I used a method bestConference to find out which conference had the highest average salary for the coaches. In this method, I used String currentConference = getElement("coachSalaries.csv", count, conferenceColumn) to find each of the conferences in my data. I used multiple parallel arrays to find the average of each conference salary and then compared them and returned the conference with the highest one. For my second question, I made a .txt with the top 50 largest schools in the United States. I created a method numSchoolsTopFiftySizeOverMil to find how many schools were in the top 50 for size and also had a coaching salary of over 1 million dollars. I made sure to go step by step, and used print statements to debug my code when needed.

One difficulty that I ran into while analyzing my data was that each item in the csv is a String, and I needed to take averages and add numbers together. So, I needed to find a way to convert the Strings to integers. I did this by using the Integer.parseInt method. Another challenge that I overcame was that a lot of the data in my set was not applicable. So when I would go to get a salary it would sometimes give me na. In order to combat this issue, I had to add in if statements to check if a salary was applicable or not before I, for example, added it into an array.


## Results and Conclusion

My data showed me that the conference with the highest average salary was the SEC, or the Southeastern Conference. It had an average coach salary of $5,339,305. By analyzing this data set I also discovered that there is a correlation between size and college football coach salary. 29 of the schools ranked top 50 for size also have coaches that make over 1 million dollars every year. This makes sense, considering a lot of big state schools have very successful football teams.

If I had more time, I think it would definitely be interesting to look at the COVID reduction of these schools, depending on whether they are in the north or south. I think that this is definitely a prevalent topic of discussion, and it would be fascinating to see if there is a correlation between the salary reduction and location of a state. It would definitely be a lot more complex than the code that I have, but if I had the time I would love to try it!
