import { Route, Routes } from 'react-router-dom';

import Agenda from './Company/Components/Agenda';
import Profile from './Company/Components/Profile'
import Home from './Company/Components/Home';
import Main from './Components/Main';

import './styles/globals.css';

function App() {
    return (
        <Routes>
            <Route path='/' element={<Main />} />
            <Route path="empresa/home" element={<Home />} />
            <Route path="empresa/profile" element={<Profile />} />
            <Route path="empresa/agenda" element={<Agenda />} />
        </Routes>
    );
}

export default App;
