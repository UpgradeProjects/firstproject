import { useEffect, useState } from "react";

function App() {
    const [setting, setSetting] = useState({ key: "site_title", value: "" });
    const [buttonText, setButtonText] = useState("Сохранить");

    useEffect(() => {
        fetch("http://localhost:8080/api/settings")
            .then((res) => res.json())
            .then((data) => {
                if (data) setSetting(data);
            });
    }, []);

    const handleChange = (e) => {
        setSetting({ ...setting, value: e.target.value });
    };

    const handleSave = () => {
        fetch("http://localhost:8080/api/settings", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(setting),
        })
            .then(response => response.json())
            .then(data => setButtonText("Сохранено"))
            .catch(error => console.error("Ошибка:", error));
    };

    return (
        <div>
            <div className="container">
                <input
                    placeholder="Запишите сумму"
                    className="input"
                    value={setting.value}
                    onChange={handleChange}
                />
                <button
                    id="btn-save"
                    className="save-btn"
                    onClick={handleSave}
                >
                    {buttonText}
                </button>
            </div>
        </div>
    );
}

export default App;
