import React from 'react'
import { useNavigate } from 'react-router';

const HomePage=()=>{

    const navigate = useNavigate();

    const onClick =()=>{
  navigate('/home/signin');
    }
    const onClickedContact=()=>{
      navigate("/home/contactUs")
    }

    return(

        <div className='home'>
{/* <h2>Alumni Management Portal</h2> */}
<p className='text' >Welcome to Alumni  Management Portal</p>
       <div id='btn'>

<button type="submit" className="btn btn-secondary" onClick={()=>{onClick()}}>Sign in</button>
</div>
<br/><br/>
<div className='image'>
<img src='https://th.bing.com/th/id/OIP.FQ9HfqcPNtt6xW1Q0aByogHaFj?w=197&h=180&c=7&r=0&o=5&dpr=2.5&pid=1.7' alt='miuImage' />
<img src='https://msd.miu.edu/wp-content/uploads/eIMG_6978.1.JPG'/>
{/* <img src='https://compro.miu.edu/wp-content/uploads/group_oct2017_waiving_edit_1000.jpg'/> */} good pic
{/* <image src='https://scontent.ffod1-1.fna.fbcdn.net/v/t1.6435-9/74889377_10159146928987796_3343877282568601600_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=2c4854&_nc_ohc=qsyZmr4uZUAAX_q9yQl&_nc_ht=scontent.ffod1-1.fna&oh=00_AT9hvjB7b-vHFSlL0HLvo5lTPJyRQ8-Ncip514HjFRmMvA&oe=62F41FA4'/> */}
<img src='https://th.bing.com/th/id/OIP.FQ9HfqcPNtt6xW1Q0aByogHaFj?w=197&h=180&c=7&r=0&o=5&dpr=2.5&pid=1.7' alt='miuImage' />
</div>
<div id='btn'>
<button type="submit" className="btn btn-secondary" onClick={()=>{onClickedContact()}}>Contact Us</button>

        </div>
        </div> 
    )
}
export default HomePage