-- This script does random queries

#
USERS
	# A 'User' can have multiple ticketes O
	# Only one USER_ID 

# TICKETS
	# The TICKET_IDs must be different

# JUNCTION
	# A junction table that ties TRAINS and USERS together

# TRAINS 
	# A table containing the train information

USE Project1;

#
Query All
SELECT *
FROM USERS u
         JOIN JUNCTION j ON u.USER_ID = j.USER_ID
         JOIN TRAINS t ON t.TICKET_ID = j.TRAIN_ID
         JOIN TICKETS t2 ON t2.TICKET_ID = u.TICKET_ID;

#
This query tells the USER how many tickets they have
SELECT *
FROM USERS u
         JOIN TICKETS t ON t.TICKET_ID = u.USER_ID;

#
Adds a description to the ticket
UPDATE TICKETS t
    JOIN TRAINS t2
on t.TICKET_ID = t2.TICKET_ID
    SET t.DESCRIPTION = CONCAT(t2.PASSENGERS, ' ', t2.ARRIVAL_STATION, ' ', t2.ARRIVAL_INFO, ' ', t2.DEPARTURE_STATION, ' ', t2.DEPARTURE_INFO, ' ', t2.AVAILABLE);