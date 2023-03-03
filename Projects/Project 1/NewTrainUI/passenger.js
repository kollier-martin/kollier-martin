/**
 * @author Erika Johnson & Kollier Martin
 * @description userLogout function logs out current user by
 * clearing the token from the local Storage.
 */
function userLogout() {
    localStorage.clear();
    console.log("Logged Out");
    window.location.href = "index.html";
}

/***
 *
 * LIST OF PASSENGER INFO AND TRAIN INFO, DISPLAYED WITHIN A TABLE
 *
 ***/
(async function getTrainList() {
    let trainUrl = 'http://localhost:8080/Erika-Kollier/train';
    const token = localStorage.getItem("Token");

    let response = await fetch(trainUrl, {
        method: "GET",
        headers: {
            "Content-Type": "application/json;charset=utf-8",
            "Authorization": token
        }
    })

    let json = await response.json();
    await populateTable(json);
})();

function populateTable(json) {
    let table = document.getElementById("TrainRouteTable");
    let rows = Object.values(json).pop().length;
    let values = Object.values(json).pop();

    try {
        for (let i = 0; i < rows; i++) {
            let tr = table.insertRow(0);

            for (let value of values.pop()) {
                let cell = tr.insertCell(-1);
                cell.innerHTML = value;
            }
        }
    } catch (error) {
        console.log("Error:", error);
    }
}

/***
 * CREATE A TICKET, VIEW TICKET FOR CHECKIN OR CANCEL
 ***/
function createATicket() {

    const form = document.getElementById("purchaseTicketForm")
    const tbody = document.getElementById("viewTickets")
    const tableEl = document.getElementById("userTickets")

    function onAddTickets(e) {
        e.preventDefault();
        const departureStation = document.getElementById("currentCity").value;
        const arrivalStation = document.getElementById("destCity").value;
        const totalTickets = document.getElementById("tickets").value;
        const token = localStorage.getItem("Token");
        const baseUrl = "http://localhost:8080/Erika-Kollier/ticket?new";

        let departure = {
            departureStation: departureStation
        }

        // This POST method is used for the fetching of the Train ID to display to the user
        fetch("http://localhost:8080/Erika-Kollier/ticket?getID", {
            method: "POST",
            headers: {
                "Content-Type": "application/json;charset=utf-8",
                "Authorization": token
            },
            body: JSON.stringify(departure)
        })
            .then(response => response.json())
            .then(function (response) {
                let trainID = Object.values(response).pop();
                let username = localStorage.getItem("Current User")

                alert("Ticket(s) Purchased")
                tbody.innerHTML += `
            <tr> 
                <td>${trainID}</td>
                <td>${departureStation}</td>
                <td>${arrivalStation}</td>
                <td>${totalTickets}</td>
                <td><button type = "button" class = "btn-warning" onclick="deleteTicket(this)">Cancel</button></td>
                <td><button type = "button" class = "btn-primary" onclick="checkIn(this)">Check-In</button></td>
                
            </tr>
            `
                // This POST method is used for backend ticket creation
                let newTicket = {
                    username: username,
                    departureStation: departureStation,
                    arrivalStation: arrivalStation,
                    totalTickets: totalTickets,
                    tid: trainID
                }

                fetch(baseUrl, {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json;charset=utf-8",
                        "Authorization": token
                    },
                    body: JSON.stringify(newTicket),
                })
                    .then(response => response.json())
                    .then(function (response) {
                        console.log(response)
                    })
                    .catch((err) => {
                        console.log(err);
                    })
            })
            .catch((err) => {
                console.log(err);
            })
    }

    form.addEventListener('submit', onAddTickets)
}

/**
 * This contains the logic to cancel  a ticket
 * @param json The response from the backend
 */
function deleteTicket(e) {
    const tbody = document.getElementById("viewTickets")
    const tid = tbody.getElementsByTagName("tr")[0].innerText[0];
    const username = localStorage.getItem("Current User");
    const deleteUrl = "http://localhost:8080/Erika-Kollier/ticket?cancel"
    const token = localStorage.getItem("Token");

    fetch(deleteUrl, {
        method: 'DELETE',
        headers: {
            "Content-Type": "application/json;charset=utf-8",
            "Authorization": token,
            "Username": username,
            "TrainID": tid
        }
    })
        .then(response => response.json())
        .then(response => {
            if (Object.values(response).pop() === localStorage.getItem("Current User") + " " + "Ticket Cancel Success = true") {
                alert("Your ticket has been canceled.")
                e.closest('tr').remove();
            } else {
                alert("Error has occurred. Ticket cancelling has failed.")
            }
        })
}

/**
 * This contains the logic to checkIn for a ticket
 * @param json The response from the backend
 */
function checkIn(e) {
    const tbody = document.getElementById("viewTickets")
    const checkInUrl = "http://localhost:8080/Erika-Kollier/ticket?checkin"
    const token = localStorage.getItem("Token");
    const tid = tbody.getElementsByTagName("tr")[0].innerText[3];
    const username = localStorage.getItem("Current User");

    fetch(checkInUrl, {
        method: 'PUT',
        headers: {
            "Content-Type": "application/json;charset=utf-8",
            "Authorization": token,
            "Username": username,
            "TrainID": tid
        }
    })
        .then(response => response.json())
        .then(function (response) {
            if (Object.values(response).pop() === localStorage.getItem("Current User") + " Successful Check-In") {
                alert("You have successfully checked in!")
                e.style = "background-color:#44C525; " +
                    "color:white; " +
                    "position: relative; " +
                    "padding: 1px 6px; " +
                    "align: center; " +
                    "left: 8px; " +
                    "display: inline-block; " +
                    "text-align: center; " +
                    "align-items: flex-start; " +
                    "top: 5px; ";
                e.textContent = "Checked In!"
                e.value = "Checked In!"
                e.disabled = true;
            } else {
                alert("Error has occurred. Check in has failed.")
            }
        })
}

/**
 * Get TicketList returns the current User's owned tickets
 */
function getTicketList() {
    let ticketUrl = 'http://localhost:8080/Erika-Kollier/ticket?myTickets=' + localStorage.getItem("Current User");
    const token = localStorage.getItem("Token");


    fetch(ticketUrl, {
        method: "GET",
        headers: {
            "Content-Type": "application/json;charset=utf-8",
            "Authorization": token
        }
    })
        .then(response => response.json())
        .then(function (response) {
            if (Object.values(response).pop() !== "User Has No Tickets") {
                populateTicketTable(response);
            } else {
                console.log("User Has No Tickets!");
            }
        })
}

/**
 * This contains the logic to populate the list with 'getTicketList()'
 * @param json The response from the backend
 */
function populateTicketTable(json) {
    let table = document.getElementById("viewTickets")
    let rows = Object.values(json).length;
    let values = Object.values(json).pop();

    try {
        for (let i = 0; i < rows; i++) {
            let tr = table.insertRow(0);
            let cancelBtn = document.createElement('input');
            cancelBtn.type = "button";
            cancelBtn.value = "Cancel";
            cancelBtn.textContent = "Cancel";
            cancelBtn.className = "ticketButtons";
            cancelBtn.onclick = function () {
                deleteTicket(this)
            };
            cancelBtn.style = "background-color:#C1371A; " +
                "color:white; " +
                "position: relative; " +
                "padding: 1px 6px; " +
                "align: center; " +
                "left: 8px; " +
                "display: inline-block; " +
                "text-align: center; " +
                "align-items: flex-start; " +
                "top: 5px; ";

            let checkInBtn = document.createElement('input');
            checkInBtn.type = "button";
            checkInBtn.value = "Check-In";
            checkInBtn.textContent = "Check-In";
            checkInBtn.className = "ticketButtons";
            checkInBtn.onclick = function () {
                checkIn(this)
            };
            checkInBtn.style = "background-color:#0d6efd; " +
                "color:white; " +
                "position: relative; " +
                "padding: 1px 6px; " +
                "align: center; " +
                "left: 80px; " +
                "display: inline-block; " +
                "text-align: center; " +
                "align-items: flex-start; " +
                "top: -24px; ";
            for (let value of values.pop()) {
                let cell = tr.insertCell(-1);
                cell.innerHTML = value;
                tr.append(cancelBtn);
                tr.append(checkInBtn);
            }
        }
    } catch (error) {
        console.log("Error:", error);
    }
}