import { useState } from "react";
import "./App.css";

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL;

function App() {
  const [longUrl, setLongUrl] = useState("");
  const [result, setResult] = useState(null);
  const [stats, setStats] = useState(null);
  const [error, setError] = useState("");
  const [copied, setCopied] = useState(false);

  const fetchStats = async (shortCode) => {
    try {
      const response = await fetch(
        `${API_BASE_URL}/api/stats/${shortCode}`
      );

      if (!response.ok) return;

      const data = await response.json();
      setStats(data);
    } catch (err) {
      console.error("Failed to fetch analytics", err);
    }
  };

  const handleSubmit = async () => {
    setError("");
    setResult(null);
    setStats(null);
    setCopied(false);

    try {
      const response = await fetch(`${API_BASE_URL}/api/shorten`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ longUrl }),
      });

      if (!response.ok) {
        const errData = await response.json();
        setError(errData.errors?.longUrl || "Something went wrong");
        return;
      }

      const data = await response.json();
      setResult(data);
      fetchStats(data.shortCode);
    } catch (err) {
      setError("Backend not reachable");
    }
  };

  const copyToClipboard = () => {
    navigator.clipboard.writeText(result.shortUrl);
    setCopied(true);
  };

  const formatDate = (dateString) => {
    if (!dateString) return "—";
  
    // Treat backend LocalDateTime as UTC
    const utcDate = new Date(dateString + "Z");
  
    return utcDate.toLocaleString("en-IN", {
      timeZone: "Asia/Kolkata",
      year: "numeric",
      month: "short",
      day: "2-digit",
      hour: "2-digit",
      minute: "2-digit",
      second: "2-digit",
      hour12: true,
    });
  };

  return (
    <div className="container">
      <h2>URL Shortener</h2>

      <input
        type="text"
        placeholder="Paste your long URL here"
        value={longUrl}
        onChange={(e) => setLongUrl(e.target.value)}
      />

      <button onClick={handleSubmit}>Shorten</button>

      {error && <div className="error">{error}</div>}

      {result && (
        <div className="result">
          <p><strong>Short URL:</strong></p>

          <a href={result.shortUrl} target="_blank" rel="noreferrer">
            {result.shortUrl}
          </a>

          <div style={{ marginTop: "10px" }}>
            <button onClick={copyToClipboard}>
              {copied ? "Copied!" : "Copy"}
            </button>
          </div>

          {stats && (
            <div style={{ marginTop: "15px" }}>
              <p>
                <strong>Click Count:</strong> {stats.clickCount}
              </p>
              <p>
                <strong>Created At:</strong> {formatDate(stats.createdAt)}
              </p>
              <p>
                <strong>Last Accessed:</strong>{" "}
                {formatDate(stats.lastAccessedAt)}
              </p>
            </div>
          )}
        </div>
      )}
    </div>
  );
}

export default App;
