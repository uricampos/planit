import React from 'react';
import { Calendar, momentLocalizer } from 'react-big-calendar';
import moment from 'moment';

import Sidebar from '../../Components/Sidebar';

import './Styles/styles.css';
import '../../../../node_modules/react-big-calendar/lib/css/react-big-calendar.css';

const localizer = momentLocalizer(moment);

let events = [
    {
        start: moment('2023-06-21T14:30-01:00').toDate(),
        end: moment().toDate(),
        title: 'Cabelo - Pedrinho',
    },
];

function Agenda() {
    return (
        <div className='container'>
            <div className="sidebar">
                <Sidebar />
            </div>
            <div className="calendar">
                <Calendar
                    localizer={localizer}
                    events={events}
                    style={{ heigth: 500 }}
                />
            </div>
        </div>
    );
}

export default Agenda;
