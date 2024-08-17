import React, { useState } from "react";
import { motion } from "framer-motion";

type ExpandableProps = {
  BaseComponent: React.ReactNode;
  HoverComponent: React.ReactNode;
};

const Expandable = ({ BaseComponent, HoverComponent }: ExpandableProps) => {
  const [isHovered, setIsHovered] = useState(false);

  return (
    <motion.div
      className="bg-black text-white p-4 cursor-pointer overflow-hidden"
      onHoverStart={() => setIsHovered(true)}
      onHoverEnd={() => setIsHovered(false)}
      style={{ 
        minHeight: '20vh',
        height: isHovered ? '40vh' : '20vh',
        transition: 'height 0.7s ease'
      }}
    >
      {isHovered ? (
        <motion.div
          initial={{ opacity: 0.5 }}
          animate={{ opacity: 1 }}
          transition={{ duration: 2.0 }}
        >
          {HoverComponent}
        </motion.div>
      ) : (
        <motion.div
          initial={{ opacity: 0.5 }}
          animate={{ opacity: 1 }}
          transition={{ duration: 0.1 }}
        >
          {BaseComponent}
        </motion.div>
      )}
    </motion.div>
  );
};

export default Expandable;
