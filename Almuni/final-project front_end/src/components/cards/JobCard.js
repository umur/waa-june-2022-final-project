import React from 'react'

const JobCard= (props) => {

const job= props.props
console.log(job)
  return (
    <div class="card" style={{"width": "450px;"}}>
  <img src={job.imageLink} class="card-img-top" alt="..."/>
  <div class="card-body">
    <h5 class="card-title">{job.companyName}</h5>
    <p class="card-text">{job.description}</p>
    <p class="card-text">{job.benefits}</p>
    <p class="card-text">{job.postDate}</p>
    {/* <p class="card-text">{job.tags}</p> */}
    <p class="card-text">{job.street}</p>
    <p class="card-text">{job.city}</p>
    <p class="card-text">{job.state}</p>
    <p class="card-text">{job.zipCode}</p>
     <a class="btn btn-primary" href={job.tags}>ApplyJob</a> 
    {/* <a href="https://www.google.com/search?q=recent+amazon+develober+job+posted+2022&rlz=1C1RXQR_enUS993US993&sxsrf=ALiCzsYKqATqLvHhlV5_S_-JcUjQvpQ-fA:1657641783492&ei=N5vNYpSvHYGgiLMP-MyrsAQ&oq=recent+Amazon+Develober+job+posted&gs_lcp=Cgdnd3Mtd2l6EAEYADIHCCEQChCgAToKCAAQRxCwAxDJAzoHCAAQRxCwAzoHCCMQsAIQJ0oECEEYAEoECEYYAFCIBli8DGDWIGgBcAB4AIABmQGIAfgCkgEDMC4zmAEAoAEByAEIwAEB&sclient=gws-wiz&ibp=htl;jobs&sa=X&ved=2ahUKEwjkqcL73PP4AhVANlkFHdsfB1MQkd0GegQICBAB#fpstate=tldetail&htivrt=jobs&htiq=recent+amazon+develober+job+posted+2022&htidocid=Iey6DocyncAAAAAAAAAAAA%3D%3D" class="btn btn-primary">View / Apply Jobs</a> */}
  </div>
</div>
  )
}

export default JobCard
