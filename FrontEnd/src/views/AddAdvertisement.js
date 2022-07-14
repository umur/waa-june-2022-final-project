// import * as React from 'react';
// import Box from '@mui/material/Box';
// import TextField from '@mui/material/TextField';
// import { Button } from '@mui/material';
// import KeyCloakService from '../security/KeycloakService.tsx';
// import axios from 'axios';
// import { useEffect, useState } from 'react';
// import TagAutoComplete from '../components/TagAutoComplete';

// export default function AddAdvertisement() {

  

//  //the argument to useState will become the value to the state object in destruction
//  const [advertisement,setAdvertisement]=useState({});
//  const [tags,setTags]=useState({});
//  const [student,setStudent]=useState({});


//  const url = "http://localhost:8080/jobs";

//  return (
//   <Box
//     component="form"
//     sx={{
//       '& .MuiTextField-root': { m: 1, width: '25ch' },
//     }}
//     noValidate
//     autoComplete="off"
//   >
//     <div>
//       <TextField
//         required
//         id="outlined-required"
//         label="companyName"
//         defaultValue={advertisement.companyName}
//         value={advertisement.companyName}
//         onChange={(e)=>setAdvertisement({...advertisement,companyName:e.target.value})}
//       />
//       <TextField
//         required
//         id="outlined-required"
//         label="benifits"
//         defaultValue={advertisement.benefits}
//         value={advertisement.benefits}
//         onChange={(e)=>setAdvertisement({...advertisement,benefits:e.target.value})}
//       />
//       <TextField
//         required
//         id="outlined-required"
//         label="Descriptions"
//         defaultValue={advertisement.description}
//         value={advertisement.description}
//         onChange={(e)=>setAdvertisement({...advertisement,description:e.target.value})}
//       />

// <TagAutoComplete></TagAutoComplete>

//     </div>
//     <Button  variant="text" onClick={()=>{
//     //   delete state.address;
//     //   state.address=addressState;
//   axios({
//     method: 'PUT',
//     url:'http://localhost:8080/students/save-profile',
//     headers: {
//       'Content-Type': 'application/json'
//     },
//     params: {
//       "access_token": KeyCloakService.GetToken(),
//     },
// //    data:JSON.stringify(state),
//    withCredentials: false
//  })
// }}>Text</Button>
//   </Box>
// ); 
// }
