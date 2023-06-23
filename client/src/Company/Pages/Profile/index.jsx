import React from 'react';

import Sidebar from '../../Components/Sidebar';

import './Styles/styles.css';

function Perfil() {
    return (
        <div className="container">
            <div className="sidebar">
                <Sidebar />
            </div>
            <h1>Profile</h1>
        </div>
    );
}

export default Perfil;
