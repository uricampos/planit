import { Route, Routes } from 'react-router-dom';

import Sidebar from './Components/Sidebar';
import Agenda from './Components/Agenda';
import Profile from './Components/Profile';
import Home from './Components/Home';
import './styles/globals.css';

function App() {
    return (
            <div className="container">
                <div className="sidebar">
                    <Sidebar />
                </div>
                <div className="routes">
                    <Routes>
                        <Route path="empresa/home" element={<Home />} />
                        <Route path="empresa/profile" element={<Profile />} />
                        <Route path="empresa/agenda" element={<Agenda />} />
                    </Routes>
                </div>
            </div>
    );
}

export default App;
