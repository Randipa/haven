import React from 'react';
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';

const UserRoleBarChart = ({ data, title }) => {
  const chartData = [
    { name: 'Admins', count: data.adminCount || 0, fill: '#916ed6' },
    { name: 'Users', count: data.userCount || 0, fill: '#28a745' }
  ];

  const CustomTooltip = ({ active, payload, label }) => {
    if (active && payload && payload.length) {
      return (
        <div className="custom-tooltip">
          <p className="tooltip-label">{`${label}: ${payload[0].value}`}</p>
          <p className="tooltip-desc">
            {`${((payload[0].value / data.totalUsers) * 100).toFixed(1)}% of users`}
          </p>
        </div>
      );
    }
    return null;
  };

  return (
    <div className="chart-container">
      <div className="chart-header">
        <h3>{title || 'User Role Distribution'}</h3>
        <p className="chart-subtitle">Breakdown of users by role</p>
      </div>
      <div className="chart-wrapper">
        <ResponsiveContainer width="100%" height={300}>
          <BarChart data={chartData} margin={{ top: 20, right: 30, left: 20, bottom: 5 }}>
            <CartesianGrid strokeDasharray="3 3" stroke="#e0e0e0" />
            <XAxis dataKey="name" tick={{ fontSize: 12 }} axisLine={{ stroke: '#666' }} />
            <YAxis tick={{ fontSize: 12 }} axisLine={{ stroke: '#666' }} />
            <Tooltip content={<CustomTooltip />} />
            <Legend wrapperStyle={{ fontSize: '12px', paddingTop: '20px' }} />
            <Bar dataKey="count" radius={[4,4,0,0]} stroke="#fff" strokeWidth={1} />
          </BarChart>
        </ResponsiveContainer>
      </div>
    </div>
  );
};

export default UserRoleBarChart;
