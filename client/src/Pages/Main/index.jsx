import React, { useRef } from 'react';

import { motion, useInView } from 'framer-motion';

import './Styles/styles.css';

function Main() {
    const ref = useRef(null);
    const isInView = useInView(ref, { once: true });

    return (
        <div className="container-main">
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
                        onClick={() => (window.location.pathname = '/login')}
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
                    onClick={() => (window.location.pathname = '/')}
                >
                    PLANIT
                </motion.h1>
                <div className="wrapper-title-paragraph">
                    <motion.p
                        className="title-paragraph"
                        initial={{ opacity: 0, y: 100 }}
                        animate={{ opacity: 0.75, y: -50 }}
                        transition={{ duration: 1.1, ease: 'easeInOut' }}
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
            <div className="presentation" ref={ref}>
                <motion.div className="presentation-left-div">
                    <motion.p
                        className="presentation-paragraph"
                        initial={{ x: -1000, opacity: 0 }}
                        animate={isInView ? { x: 0, opacity: 1 } : { x: -1000 }}
                        transition={
                            isInView ? { duration: 0.5, ease: 'easeInOut' } : {}
                        }
                    >
                        Lorem ipsum dolor sit amet, consectetur adipisicing
                        elit. Amet odit at quae dolor, deserunt aspernatur
                        itaque repudiandae ratione odio hic! Aspernatur vel,
                        odio quis sequi repudiandae esse animi! Accusantium quos
                        tenetur hic quam, labore voluptatum sed non ab quaerat,
                        magnam ut deserunt quis velit autem repellendus itaque
                        ipsam laudantium quae modi quidem ratione cumque. Iusto
                        quod, natus molestias soluta nobis necessitatibus animi
                        quae! Unde recusandae iure similique a minus provident
                        assumenda ratione ab ipsam. Obcaecati, assumenda et
                        adipisci repellendus eum consectetur voluptatem deleniti
                        nesciunt nobis quod ducimus repudiandae quisquam, sint
                        numquam fugit inventore blanditiis, cum sequi accusamus
                        facere. Autem, tenetur.
                    </motion.p>
                </motion.div>
                <motion.div className="presentation-right-div">
                    <motion.p
                        className="presentation-paragraph"
                        initial={{ x: 1000, opacity: 0 }}
                        animate={isInView ? { x: 0, opacity: 1 } : { x: 1000 }}
                        transition={
                            isInView ? { duration: 0.5, ease: 'easeInOut' } : {}
                        }
                    >
                        Lorem ipsum dolor sit amet consectetur, adipisicing
                        elit. Impedit dicta quas earum, neque at quasi iure
                        cupiditate placeat assumenda ut minima pariatur nostrum
                        blanditiis praesentium voluptate magni consectetur.
                        Veniam, facere expedita eligendi quo aliquam praesentium
                        tenetur placeat voluptatibus magni, maiores obcaecati ex
                        iusto reprehenderit rerum soluta quod labore porro
                        consequuntur. Amet quaerat similique rerum quas? Id quia
                        praesentium delectus consequuntur distinctio fugiat
                        velit, odio accusantium nihil modi deserunt perspiciatis
                        soluta officia voluptatum, sit blanditiis quidem
                        molestias incidunt magnam! Commodi enim exercitationem
                        perspiciatis ad nulla. Explicabo hic quos incidunt
                        saepe, quidem suscipit molestiae quaerat ducimus
                        aspernatur nam quae doloremque maxime ipsum!
                    </motion.p>
                </motion.div>
            </div>
            <div className="presentation-2">
                <motion.div className="presentation-2-left-div" ref={ref}>
                    <motion.p
                        className="presentation-2-paragraph"
                        initial={{ opacity: 0, y: 100 }}
                        animate={
                            isInView ? { opacity: 1, y: 0 } : { opacity: 0 }
                        }
                        transition={
                            isInView ? { duration: 2, ease: 'easeInOut' } : {}
                        }
                    >
                        Lorem ipsum dolor sit amet consectetur adipisicing elit.
                        Molestias itaque voluptatibus perferendis architecto
                        cumque, nulla dolorem! Quia illum laudantium architecto
                        commodi esse aut, reprehenderit porro? Placeat
                        laudantium ducimus maiores veritatis voluptatum quidem
                        sapiente, mollitia labore nobis reprehenderit enim
                        numquam modi debitis. Quod veritatis odio, commodi natus
                        sapiente quae quidem amet tempore, expedita ullam quo.
                        Provident tenetur dolores, sint tempore obcaecati
                        molestiae nam facilis eveniet inventore corrupti
                        sapiente praesentium maxime doloremque, autem voluptatem
                        facere reprehenderit odio dolorem eos. Praesentium dicta
                        consequatur quibusdam quasi aliquid aspernatur similique
                        molestiae reprehenderit distinctio, iusto suscipit iure
                        modi error eligendi ex, fugiat consectetur delectus
                        repudiandae reiciendis?
                    </motion.p>
                </motion.div>
                <motion.div className="presentation-2-right-div" ref={ref}>
                    <motion.p
                        className="presentation-2-paragraph"
                        initial={{ opacity: 0, y: 100 }}
                        animate={
                            isInView ? { opacity: 1, y: 0 } : { opacity: 0 }
                        }
                        transition={
                            isInView ? { duration: 2, ease: 'easeInOut' } : {}
                        }
                    >
                        Lorem ipsum dolor sit amet consectetur adipisicing elit.
                        Ut exercitationem est amet non quidem unde inventore
                        obcaecati praesentium veniam odio. Quae ipsum cumque
                        voluptates sed incidunt, excepturi odit nemo temporibus
                        provident vero mollitia voluptatem similique, ullam
                        quos, praesentium repellendus aliquam doloremque.
                        Accusantium est ad cum beatae atque molestiae laudantium
                        ut consequuntur officia sed aspernatur, corporis harum
                        placeat pariatur necessitatibus. Est totam
                        exercitationem, laudantium quas aliquam obcaecati odio,
                        aliquid dolor a voluptas natus fugit excepturi. Qui
                        velit aut provident quasi veritatis optio delectus porro
                        fugit rerum dolorem sed aperiam, aspernatur sint quo.
                        Laudantium ut dolor blanditiis cumque omnis amet id
                        quis.
                    </motion.p>
                </motion.div>
            </div>
            <footer className="footer">
                <p
                    className="footer-p-name"
                    onClick={() => (window.location.pathname = '/')}
                >
                    platnit.com
                </p>
                <p className="footer-p-contact">planit@planit.com</p>
            </footer>
        </div>
    );
}

export default Main;
