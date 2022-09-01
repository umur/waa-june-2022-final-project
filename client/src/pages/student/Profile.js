import { useDispatch, useSelector } from "react-redux";
import React, { useEffect } from "react";
import { getUserProfile } from "../../redux/reducers/UserProfile/actions";

import { Breadcrumb, Container, Row, Col, Card } from "react-bootstrap";
import JobHistoryInfo from "../../components/profiles/JobHistoryInfo";
import FileUploadPage from "../../pages/FileUploadPage";

import { getJobHistoryById } from "../../redux/reducers/JobHistory/actions";
import image from "../../../src/userprofile.png";

function StudentProfile() {
  const dispatch = useDispatch();
  const userProfile = useSelector((state) => state.userProfile);
  const jobHistory = useSelector((state) => state.jobHistory);

  useEffect(() => {
    dispatch(getUserProfile());
    dispatch(getJobHistoryById(userProfile?.id));
  }, []);

  return (
    <Container>
      <Breadcrumb name="Basic Information" />
      <section className="content">
        <Container fluid="lg">
          <Row>
            <Col md={{ span: 3 }}>
              <img src={image} alt="user-image" width="250px" height="250px" />
            </Col>
            <Col md={{ span: 6 }}>
              <div className="row d-flex justify-content-center align-items-center h-100">
                <div className="card">
                  <div className="card-body p-4 text-block">
                    <div className="mb-5">
                      <p className="lead fw-normal mb-1">User Profile</p>
                      <div
                        className="p-4"
                        style={{ backgroundColor: "#f8f9fa" }}
                      >
                        <p className="text-right"></p>
                        <p className="font-italic mb-1">
                          Name:{" "}
                          {userProfile?.firstName + " " + userProfile?.lastName}
                        </p>
                        <p className="font-italic mb-0">
                          Email: {userProfile?.email}
                        </p>
                        <p className="font-italic mb-0">
                          Address: {userProfile?.address?.state} -
                          {userProfile?.address?.city}
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </Col>
          </Row>
          <br />

          <h3 className="text-center">Job History</h3>
          <div>
            {jobHistory.length &&
              jobHistory?.map((history) => {
                return (
                  <JobHistoryInfo
                    key={history?.id}
                    id={history?.id}
                    companyName={history?.companyName}
                    startDate={history?.startDate}
                    endDate={history?.endDate}
                    reasonToLeave={history?.reasonToLeave}
                    comment={history?.comment}
                  ></JobHistoryInfo>
                );
              })}
          </div>
        </Container>
      </section>
    </Container>
  );
}

export default StudentProfile;
