import { Route, Routes } from 'react-router-dom';

import Agenda from './Company/Pages/Agenda';
import Profile from './Company/Pages/Profile';
import Home from './Company/Pages/Home';
import Main from './Pages/Main';

import './styles/globals.css';

function App() {
    return (
        <Routes>
            <Route path="/" element={<Main />} />
            <Route path="empresa/home" element={<Home />} />
            <Route path="empresa/profile" element={<Profile />} />
            <Route path="empresa/agenda" element={<Agenda />} />
        </Routes>
    );
}

export default App;
