import React from 'react';
import JobListing from './Listing';

export default function JobListings(props) {
    return(
        <div className='container'>{
            props.listings.map((item) =>{
                return <JobListing 
                    key = {item.id}
                    id = {item.id}
                    title = {item.title}
                    aboutUs = {item.aboutUs}
                    description = {item.description}
                />
            })
        } </div>
    )
}
