import React from 'react';

import { motion } from 'framer-motion';

import './Styles/styles.css';

function Main() {
    return (
        <div className="container">
            <motion.div className="title">
                <div className="navbar">
                    <motion.button
                        className="btn-login"
                        whileHover={{
                            scale: 1.08,
                            opacity: 1,
                            transitio: {
                                duration: 0.3,
                                ease: [0, 0.71, 0.2, 1.01],
                                scale: {
                                    type: 'spring',
                                    damping: 5,
                                    stiffness: 100,
                                    restDelta: 0.0001,
                                },
                            },
                        }}
                        onClick={() => window.location.pathname = "/login"}
                    >
                        Login
                    </motion.button>
                </div>
                <motion.h1
                    className="title-h1"
                    initial={{ opacity: 0, y: 100 }}
                    animate={{ opacity: 0.75, y: 0 }}
                    transition={{ duration: 1 }}
                    whileHover={{
                        scale: 1.2,
                        opacity: 1,
                        transition: {
                            duration: 0.3,
                            ease: [0, 0.71, 0.2, 1.01],
                            scale: {
                                type: 'spring',
                                damping: 10,
                                stiffness: 100,
                                restDelta: 0.0001,
                            },
                        },
                    }}
                >
                    PLANIT
                </motion.h1>
                <div className="wrapper-title-paragraph">
                    <motion.p
                        className="title-paragraph"
                        initial={{ opacity: 0, y: 100 }}
                        animate={{ opacity: 0.75, y: 0 }}
                        transition={{ duration: 2 }}
                    >
                        Lorem ipsum dolor sit amet consectetur, adipisicing
                        elit. Officiis deleniti eveniet, fugiat dolore totam
                        dolorem! Accusantium totam blanditiis repellendus
                        inventore soluta ut, libero rerum, odio delectus eveniet
                        dicta quibusdam iste consequatur. Vel a odio aut ipsum
                        accusantium totam numquam consequuntur minima. Obcaecati
                        adipisci cum veniam commodi eos architecto eum ut?
                    </motion.p>
                </div>
            </motion.div>
            <div className="presentation"></div>
        </div>
    );
}

export default Main;
