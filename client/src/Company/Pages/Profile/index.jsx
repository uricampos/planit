import React from 'react';

import Sidebar from '../../Components/Sidebar';

import './Styles/styles.css';

function Perfil() {
    return (
        <div className="container">
            <div className="sidebar">
                <Sidebar />
            </div>
            <h1 style={{height: "100vh"}}>Profile</h1>
        </div>
    );
}

export default Perfil;
