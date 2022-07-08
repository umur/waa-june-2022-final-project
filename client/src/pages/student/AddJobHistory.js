function AddJobHistory() {
  return (
    <div className="col-8 offset-2">
      <form>

        <div className="row">
          <div className="mb-3 col-12">
            <label for="companyName" className="form-label">Company Name</label>
            <input type="text" className="form-control" id="companyName" />
          </div>

          <div className="mb-3 col-6">
            <label for="startDate" className="form-label">Start Date</label>
            <input type="text" className="form-control" id="startDate" />
          </div>
          <div className="mb-3 col-6">
            <label for="endDate" className="form-label">End Date</label>
            <input type="text" className="form-control" id="endDate" />
          </div>





          <div className="mb-3 col-12">
            <label for="reasonToLeave" className="form-label">Reason To Leave</label>
            <textarea className="form-control" id="reasonToLeave" />
          </div>

          <div className="mb-3 col-12">
            <label for="comments" className="form-label">Comments</label>
            <textarea className="form-control" id="reasonToLeave" />
          </div>

        </div>

        <div className="row">
          <div className="col-md-12">
            <button type="submit" rows="4" className="btn btn-primary float-end">Add</button>
          </div>
        </div>


      </form>

    </div>
  );
}

export default AddJobHistory;