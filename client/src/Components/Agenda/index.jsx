import React from 'react';
import { Calendar, momentLocalizer } from 'react-big-calendar';
import moment from 'moment';
import '../../../node_modules/react-big-calendar/lib/css/react-big-calendar.css';

const localizer = momentLocalizer(moment);

let events = [
    {
        start: moment("2023-06-21T14:30-01:00").toDate(),
        end: moment().toDate(),
        title: 'Cabelo - Pedrinho',
    },
];

function Agenda() {
    return (
        <>
            <Calendar localizer={localizer} events={events} style={{heigth: 500}}/>
        </>
    );
}

export default Agenda;
