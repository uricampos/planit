import React from 'react';
import { motion } from 'framer-motion';

import './Styles/styles.css';

function Login() {
    return (
        <div className="container-login">
            <div className="card-login">
                <div className="form-login"></div>
                <motion.div className="footer-login"
                    initial={{opacity: 0}}
                    animate={{opacity: 1}}
                    transition={{duration: 1.5, ease: "easeInOut"}}
                >
                    <p>ou</p>
                    <p
                        className="footer-login-paragraph"
                        onClick={() => (window.location.pathname = '/register')}
                    >
                        Registre-se aqui!
                    </p>
                </motion.div>
            </div>
        </div>
    );
}

export default Login;
