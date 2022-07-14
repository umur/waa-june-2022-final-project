import React from 'react'

const FiterJobs = () => {

  return (
    <div className='searchBar'>
      <h1 className='search'>Filter Jobs</h1>
    <div class="input-group">
  <div class="form-outline">
    <input type="search" className="form-control" />
    <label class="form-label">Search By Tags</label>
  </div>
  <button type="button" className="btnsearch">search
    <i class="fas fa-search"></i>
  </button>
</div>

<div class="input-group">
  <div class="form-outline">
    <input type="search" className="form-control" />
    <label class="form-label">Search By State</label>
  </div>
  <button type="button" className="btnsearch">search
    <i class="fas fa-search"></i>
  </button>
</div>
<div class="input-group">
  <div class="form-outline">
    <input type="search" className="form-control" />
    <label class="form-label">Search By City</label>
  </div>
  <button type="button" className="btnsearch">search
    <i class="fas fa-search"></i>
  </button>
</div>
<div class="input-group">
  <div class="form-outline">
    <input type="search" className="form-control" />
    <label class="form-label">Search By Compony Name</label>
  </div>
  <button type="button" className="btnsearch">search
    <i class="fas fa-search"></i>
  </button>
</div>
</div>


  )
}

export default FiterJobs