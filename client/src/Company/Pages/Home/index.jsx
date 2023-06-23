import React from 'react';
import { DataGrid } from '@mui/x-data-grid';

import Sidebar from '../../Components/Sidebar';

import './Styles/styles.css';

const rows = [
    { id: 1, name: 'Lucas Supino', col1: 'Cabelo', col2: '14:00' },
    { id: 2, name: 'João Alberto', col1: 'Cabelo e Barba', col2: '14:40' },
    {
        id: 3,
        name: 'André Miqueias',
        col1: 'Cabelo, Barba e Sobrancelha',
        col2: '15:20',
    },
];

const columns = [
    { field: 'name', headerName: 'Name', width: 300 },
    { field: 'col1', headerName: 'Service', width: 450 },
    { field: 'col2', headerName: 'Time', width: 100 },
];

function Home() {
    return (
        <div className="container">
            <div className="sidebar">
                <Sidebar />
            </div>
            <div style={{ height: '100%', width: '100%' }}>
                <DataGrid
                    checkboxSelection={true}
                    rows={rows}
                    columns={columns}
                />
            </div>
        </div>
    );
}

export default Home;
