import { Route, Routes } from 'react-router-dom';

import Main from './Pages/Main';
import Login from './Pages/Login';
import Home from './Company/Pages/Home';
import Profile from './Company/Pages/Profile';
import Agenda from './Company/Pages/Agenda';

import './styles/globals.css';

function App() {
    return (
        <Routes>
            <Route path="/" element={<Main />} />
            <Route path='/login' element={<Login />} />
            <Route path="empresa/home" element={<Home />} />
            <Route path="empresa/profile" element={<Profile />} />
            <Route path="empresa/agenda" element={<Agenda />} />
        </Routes>
    );
}

export default App;
