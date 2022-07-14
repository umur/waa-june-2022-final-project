import React, { useEffect, useState } from "react";
import * as echarts from "echarts";
import ReactEcharts from "echarts-for-react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import Chip from "@mui/material/Chip";
import Tooltip from "@mui/material/Tooltip";

const countcompanyurl = "http://localhost:8080/jobs/companiescount";
const counttagsurl = "http://localhost:8080/jobs/tagscount";
const jobadvurl = "http://localhost:8080/jobs/paginated";
const openFileURl = "http://localhost:8080/jobattachment/";

const pageRequest = {
  page: 0,
  pageSize: 10,
  sortBy: "companyName",
  isAscending: true,
};

export const Home = () => {
  const [numOfJobAdv, setNumOfJobAdv] = useState([]);
  const [numOfTags, setNumOfTags] = useState([0, 0, 0, 0, 0,0, 0, 0, 0, 0]);
  const [jobAvsertisements, setJobAdvertisements] = useState([]);
  const [openId, setOpenId] = useState(0);

  /////get the paginated jobadvertisements///////
  const fetchJobAvsertisements = async () => {
    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(pageRequest),
    };
    const response = await fetch(jobadvurl, requestOptions);
    const jsonData = await response.json();

    setJobAdvertisements(jsonData.content);
  };

  useEffect(() => {
    fetchJobAvsertisements();
  }, []);

  //////////////Open an attachment PDF or Image////////////////////
  async function openFile(id) {
    const response = await fetch(openFileURl + id);

    if (response.ok) {
      console.log(response);
      const blobData = await response.blob();
      const url = window.URL.createObjectURL(blobData);
      console.log(response.headers.get("Content-Disposition"));
      var newTab = window.open("");
      newTab?.document.write(
        `<!DOCTYPE html><head><title>Document preview</title></head><body><img src="${url}" width="auto" height="auto" ></body></html>`
      );

      var link = document.createElement("a");
      link.href = url;
      link.download = "file.pdf";
      link.click();
      setTimeout(function () {
        // For Firefox it is necessary to delay revoking the ObjectURL
        window.URL.revokeObjectURL(blobData);
      }, 100);
    }
  }

  /////fetch number of advertisement per company/////////

  const fetchAdvNumber = async () => {
    const response = await fetch(countcompanyurl);
    const jsonData = await response.json();

    setNumOfJobAdv(jsonData);
  };

  useEffect(() => {
    fetchAdvNumber();
  }, []);

  var myData = numOfJobAdv.map((res) => res.companyname);

  var l = numOfJobAdv.map((res) => res.total);

  var option1 = {
    xAxis: {
      type: "category",
      data: myData,
    },
    yAxis: {
      name: "Number of Advertisements",
      type: "value",
    },
    series: [
      {
        data: l,
        type: "bar",
        color: ["#FFFF00"],
      },
    ],
  };

  //////fetch number of Tags on pie chart//////////////
  const fetchTagNumber = async () => {
    const response = await fetch(counttagsurl);
    const jsonData = await response.json();

    setNumOfTags(jsonData);
  };

  var ll = numOfTags.map((res) => res.value);

  useEffect(() => {
    fetchTagNumber();
  }, []);

  var option2 = {
    xAxis: {
      data: ["Java", "Frontend", "DevOps", "Data Analytics", "Backend","iOS","Android","Software Engineering",".Net"],
    },
    yAxis: {},
    series: [
      {
        data: ll,
        type: "line",
        label: {
          show: true,
          position: "bottom",
          textStyle: {
            fontSize: 20,
          },
        },
      },
    ],
  };

  return (
    <>
      <div>
        <ReactEcharts
          style={{ width: 800, height: 400 }}
          lazyUpdate={true}
          option={option1}
        />
        <ReactEcharts
          style={{ width: 1200, height: 400 }}
          lazyUpdate={true}
          option={option2}
        />
      </div>
      <div>
        <TableContainer component={Paper}>
          <Table sx={{ minWidth: 650 }} aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell>Comapny Name </TableCell>
                <TableCell>Description</TableCell>
                <TableCell align="right">Benefit</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {jobAvsertisements.map((row) => (
                <Tooltip title="Click to view attachment">
                  <TableRow
                    onClick={() => openFile(row.id)}
                    key={row.name}
                    sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
                  >
                    <TableCell component="th" scope="row">
                      {row.companyName}
                    </TableCell>
                    <TableCell>{row.description}</TableCell>
                    <TableCell align="right">{row.benefits}</TableCell>
                  </TableRow>
                </Tooltip>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </div>
    </>
  );
};
