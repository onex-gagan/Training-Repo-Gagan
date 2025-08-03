* **Process Management**
* **Package Management**
* **Environment Variables**

---

````markdown
# ⚙️ Linux Process Management, Package Management & Environment Variables

These notes provides a quick reference for three essential Linux topics:

1. **Process Management**
2. **Package Management (APT)**
3. **Environment Variables**

---

## 🧠 Process Management in Linux

A **process** is any program in execution. Linux provides various tools to monitor, control, and kill processes.

### 🔍 View Running Processes

```bash
ps aux                    # List all running processes
top                       # Real-time process viewer
htop                      # Advanced viewer (if installed)
````

### 🧾 Common Fields (from `ps aux`)

| Field   | Meaning       |
| ------- | ------------- |
| USER    | Process owner |
| PID     | Process ID    |
| %CPU    | CPU usage     |
| %MEM    | Memory usage  |
| COMMAND | Command run   |

### 🔫 Killing or Managing Processes

```bash
kill PID                  # Gracefully stop a process
kill -9 PID               # Forcefully terminate
pkill process_name        # Kill by process name
```

### 🔄 Run Processes in Background

```bash
./script.sh &             # Run in background
jobs                      # Show background jobs
fg %1                     # Bring job 1 to foreground
bg %1                     # Resume job 1 in background
```

---

## 📦 Package Management (APT-based Distros like Ubuntu)

APT (Advanced Package Tool) is used to install, update, and remove software packages.

### 📥 Installing Packages

```bash
sudo apt update                      # Refresh package list
sudo apt install package-name        # Install a package
sudo apt install vim curl git       # Install multiple packages
```

### 📤 Removing Packages

```bash
sudo apt remove package-name         # Remove but keep config
sudo apt purge package-name          # Remove including config
```

### 🔁 Updating & Upgrading

```bash
sudo apt update                      # Update package lists
sudo apt upgrade                     # Upgrade all installed packages
sudo apt full-upgrade                # Upgrade with dependency changes
```

### 🔎 Searching Packages

```bash
apt search keyword
apt show package-name
```

---

## 🌍 Environment Variables in Linux

Environment variables store configuration and system-wide values accessible by processes and shells.

### 📋 Viewing Environment Variables

```bash
printenv           # List all environment variables
echo $HOME         # Display specific variable
```

### ➕ Setting Variables (Temporary)

```bash
export VAR_NAME=value
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
```

These last only for the current session or script unless added to config files.

### ♻️ Persistent Environment Variables

To make variables available in every session:

```bash
# Add to ~/.bashrc or ~/.profile (bash users)
export PATH=$PATH:/custom/path
```

Then run:

```bash
source ~/.bashrc     # Apply changes immediately
```

### ✅ Example Usage

```bash
export EDITOR=vim
echo $EDITOR          # Output: vim
```

---

## ✅ Summary

| Topic              | Key Commands/Concepts                     |
| ------------------ | ----------------------------------------- |
| Process Management | `ps`, `top`, `kill`, `bg`, `fg`, `jobs`   |
| Package Management | `apt install`, `apt remove`, `apt update` |
| Env Variables      | `export`, `echo`, `.bashrc`, `printenv`   |

---
