import React from 'react';
import HomeRoundedIcon from '@mui/icons-material/HomeRounded';
import PersonRoundedIcon from '@mui/icons-material/PersonRounded';
import EventRoundedIcon from '@mui/icons-material/EventRounded';
import LogoutRoundedIcon from '@mui/icons-material/LogoutRounded';

export const SidebarData = [
    {
        title: 'Home',
        icon: <HomeRoundedIcon />,
        link: '/empresa/home',
    },
    {
        title: 'Profile',
        icon: <PersonRoundedIcon />,
        link: '/empresa/profile',
    },
    {
        title: 'Agenda',
        icon: <EventRoundedIcon />,
        link: '/empresa/agenda',
    },
    {
        title: 'Logout',
        icon: <LogoutRoundedIcon />,
        link: '/',
    },
];
