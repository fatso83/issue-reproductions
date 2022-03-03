import * as React from "react";

import { motion } from "framer-motion";

const animation = { opacity: [1, 0, 1] };

const transition = {
  // Conceptually, using `Infinity` should be right here, and is even used in the Getting Started examples
  // Unfortunately, it seems to be a Framer Motion v2 (and up to v6!) that makes it use 5-15% CPU even
  // when the component has been unmounted from the VDOM! Setting some number here somehow prevents it
  // from burning through the user's battery when idling. 10 repetitions should be about ten seconds
   repeat: Infinity,
  //repeat: 10,
  ease: "linear",
  duration: 0.9,
};

const StyledLoaderCircle = (props: any) => {
  return (
    <motion.div
      {...props}
      style={{
        borderRadius: "50%",
        width: "1.25rem",
        height: "1.25rem",
        margin: "0 10px",
        backgroundColor: "green",
      }}
    />
  );
};

const StyledLoader = (props: any) => {
  return (
    <motion.div
      style={{
        display: "flex",
        flexDirection: "row",
        justifyContent: "center",
        alignItems: "center",
      }}
      {...props}
    />
  );
};

function Loader(props: any): JSX.Element {
  return (
    <StyledLoader>
      <StyledLoaderCircle animate={animation} transition={transition} />
      <StyledLoaderCircle
        animate={animation}
        transition={{ ...transition, delay: 0.3 }}
      />
      <StyledLoaderCircle
        animate={animation}
        transition={{ ...transition, delay: 0.6 }}
      />
    </StyledLoader>
  );
}

export default function App(props) {
  const [loading, setLoading] = React.useState(true);

  React.useEffect(() => {
    setTimeout(() => setLoading(false), 1000);
  }, []);

  if (loading) return <Loader />;
  return <p>Finished loading</p>;
}
