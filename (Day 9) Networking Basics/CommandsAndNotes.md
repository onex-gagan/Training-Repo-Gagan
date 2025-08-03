````markdown
# 🌐 Networking Basics – Essential Linux Commands for Connectivity & Troubleshooting

This note covers essential networking commands and tools that are fundamental for:

- Troubleshooting connectivity
- Analyzing network issues
- Securely interacting with remote servers

---

## 1️⃣ `ping` – Check Basic Reachability

### ✅ Purpose
- Test if a host/server is reachable over the network.
- Measures round-trip time for packets.

### ⚙️ How It Works
- Sends **ICMP Echo Request** packets.
- Waits for **ICMP Echo Reply** from the destination.

### 📌 Syntax
```bash
ping <hostname or IP>
ping google.com
````

### 🔧 Common Options

* `-c <count>` : Number of packets to send
* `-i <interval>` : Interval between packets
* On Windows: `-t` to ping until stopped

### 📍 Use Cases

* Check if a remote server is up
* Troubleshoot network or DNS issues
* Measure latency

---

## 2️⃣ `curl` – HTTP/API Testing Tool

### ✅ Purpose

* Transfer data using protocols like HTTP, HTTPS, FTP.
* Test REST APIs, endpoints, and web servers.

### 📌 Basic Syntax

```bash
curl <URL>
curl http://localhost:8080
```

### 🔧 Key Options

| Option    | Description                         |
| --------- | ----------------------------------- |
| `-v`      | Verbose mode (headers, DNS, etc.)   |
| `-O`      | Save file with same name from URL   |
| `-L`      | Follow redirects                    |
| `-X POST` | Send POST request                   |
| `-H`      | Add custom HTTP header              |
| `-d`      | Send request data (e.g., JSON body) |

### 📌 Example: POST Request

```bash
curl -X POST https://jsonplaceholder.typicode.com/posts \
-H "Content-Type: application/json" \
-d '{ "title": "foo", "body": "bar", "userId": 1 }'
```

### 📍 Use Cases

* Check if web servers are responding
* Debug APIs and endpoints
* Download content and test HTTP methods

---

## 3️⃣ `wget` – Alternative Downloader

### ✅ Purpose

* Non-interactive file download utility
* Script-friendly and supports automation

### 📌 Syntax

```bash
wget <URL>
wget http://example.com/file.zip
```

### 🔧 Key Features

* `-r` : Download entire website recursively
* `-c` : Resume interrupted downloads
* Can run in the background for large files

### 📍 Use Cases

* Download files from scripts
* Mirror websites
* Alternative to `curl` for downloads

---

## 4️⃣ `netstat` / `ss` – View Open Ports and Connections

### ✅ Purpose

Display:

* Active connections
* Listening ports
* Routing tables

### 📌 Syntax

```bash
netstat -tulpn
ss -tulpn
```

### 🔧 Flags

| Flag | Description             |
| ---- | ----------------------- |
| `-t` | TCP connections         |
| `-u` | UDP connections         |
| `-l` | Listening ports only    |
| `-p` | Show PID/program name   |
| `-n` | Don't resolve hostnames |

### 🆚 Why Prefer `ss`?

* Faster and modern replacement for `netstat`
* Pre-installed on most Linux distros

### 📍 Use Cases

* Check open/listening ports
* Identify services using specific ports (e.g., 22, 8080)
* Diagnose port conflicts

---

## 5️⃣ `ifconfig` / `ip addr` – View Network Interfaces

### ✅ Purpose

* Show and configure IPs and interfaces

### 📌 Syntax

```bash
ifconfig
ip addr show
```

### ⚠️ Note

* `ifconfig` is deprecated on modern systems
* Use `ip addr` from the `iproute2` suite

### 📍 Use Cases

* Check your local IP address
* Verify network interfaces
* Troubleshoot interface-related issues

---

## 6️⃣ `ssh` – Secure Remote Login

### ✅ Purpose

* Connect to remote servers securely via SSH protocol

### 📌 Syntax

```bash
ssh user@remote_server
```

### 🔐 Key-Based Authentication

```bash
ssh-keygen                # Generate key pair
ssh-copy-id user@server   # Copy public key to remote server
```

* Private key: `~/.ssh/id_rsa`
* Public key: `~/.ssh/id_rsa.pub`

### 📍 Use Cases

* Login and manage remote servers
* Enable secure, password-less access
* Perform tunneling and port forwarding

---

## 7️⃣ `scp` / `sftp` – Secure File Transfers

### 🔁 `scp` – Secure Copy (non-interactive)

**Syntax:**

```bash
scp localfile.txt user@remote:/path/
scp user@remote:/path/file.txt .
```

### 🔁 `sftp` – Secure FTP (interactive)

**Syntax:**

```bash
sftp user@remote
```

**Inside SFTP Session:**

* `ls` – List files
* `get file.txt` – Download file
* `put file.txt` – Upload file

### 📍 Use Cases

* Transfer files to/from remote servers
* Automate deployment and backups
* Use `sftp` for interactive session-based transfers

---

## 💡 Quick Tips

* Use `man <command>` for help pages (e.g., `man curl`)
* Prefer `ss` over `netstat` for speed and clarity
* Combine tools for effective debugging:

  * Use `ping` to check if the server is reachable
  * Use `curl` to see if the web service is responding
* Use `ssh -i <keyfile>` for secure key-based logins

---

## ✅ Summary Table

| Command   | Purpose                           | Example                            |
| --------- | --------------------------------- | ---------------------------------- |
| `ping`    | Check connectivity and latency    | `ping google.com`                  |
| `curl`    | HTTP/API testing                  | `curl -v https://api.example.com`  |
| `wget`    | Download files                    | `wget http://example.com/file.zip` |
| `ss`      | View sockets and ports            | `ss -tulpn`                        |
| `ip addr` | Show IP and interfaces            | `ip addr show`                     |
| `ssh`     | Secure remote login               | `ssh user@host`                    |
| `scp`     | Copy files securely               | `scp file.txt user@host:/path/`    |
| `sftp`    | Interactive file transfer via SSH | `sftp user@host`                   |
