import React from 'react';
import { PieChart, Pie, Cell, ResponsiveContainer, Tooltip, Legend } from 'recharts';
import './PieChart.css';

const UserPieChart = ({ data, title }) => {
  const chartData = [
    { name: 'Admins', value: data.adminCount || 0, color: '#007bff' },
    { name: 'Users', value: data.userCount || 0, color: '#28a745' }
  ].filter(item => item.value > 0);

  if (chartData.length === 0) {
    return (
      <div className="chart-container">
        <div className="chart-header">
          <h3>{title || 'User Roles'}</h3>
        </div>
        <div className="no-data">
          <p>No data available for pie chart</p>
        </div>
      </div>
    );
  }

  return (
    <div className="chart-container">
      <div className="chart-header">
        <h3>{title || 'User Roles'}</h3>
      </div>
      <div className="pie-chart-wrapper">
        <ResponsiveContainer width="100%" height={300}>
          <PieChart>
            <Pie data={chartData} cx="50%" cy="50%" labelLine={false} outerRadius={120} dataKey="value">
              {chartData.map((entry, index) => (
                <Cell key={`cell-${index}`} fill={entry.color} />
              ))}
            </Pie>
            <Tooltip />
            <Legend />
          </PieChart>
        </ResponsiveContainer>
      </div>
    </div>
  );
};

export default UserPieChart;
