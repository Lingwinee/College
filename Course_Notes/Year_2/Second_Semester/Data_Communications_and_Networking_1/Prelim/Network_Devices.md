# Network Devices - Lecture 02

## 📋 Summary
* **Core Concept:** A computer network is a digital telecommunications network that allows nodes to share resources. Network devices include clients, servers, switches, routers, and firewalls, each serving specific roles in enabling connectivity and security within and between networks.

> **Takeaways:** Understanding the distinction between network devices is fundamental for CCNA certification. Switches provide connectivity within LANs, routers enable connectivity between LANs and the Internet, and firewalls monitor and control network traffic based on security rules. The client-server model forms the basis of most network communications.

---

## 📖 Definition

* **Computer Network:** A digital telecommunications network that allows nodes to share resources.

* **Node:** Any device connected to a network, including routers, switches, firewalls, servers, and clients.

* **Client:** A device that accesses a service made available by a server.

* **Server:** A device that provides functions or services for clients.

* **LAN (Local Area Network):** A network that connects devices within a limited geographical area, typically within the same building or campus.

* **Switch:** A network device with many network interfaces (usually 24+) that provides connectivity to hosts within the same LAN.

* **Router:** A network device with fewer interfaces than switches, used to provide connectivity between LANs and to send data over the Internet.

* **Firewall:** A network security device that monitors and controls network traffic based on configured rules.

* **Next-Generation Firewall:** A firewall that includes modern and advanced filtering capabilities beyond traditional packet filtering.

---

## 📊 Network Device Comparison

| Device | Ports/Interfaces | Primary Function | Scope | Example Models |
| :--- | :--- | :--- | :--- | :--- |
| Switch | Many (24+) | Connect devices within same LAN | Intra-network | Catalyst 9200, Catalyst 3650 |
| Router | Fewer (typically 2-8) | Connect different LANs, Internet access | Inter-network | ISR 900, ISR 1000, ISR 4000 |
| Firewall | Variable | Monitor and control traffic based on rules | Security boundary | ASA5500-X, Firepower 2100 |
| Client | 1 (typically) | Access services from servers | End device | PC, laptop, smartphone |
| Server | 1-2 (typically) | Provide services to clients | End device | Web server, file server |

---

## 🖥️ Client and Server Relationship

### Client-Server Model

The client-server model is fundamental to network communications:

1. **Client Role:** Requests services or resources
2. **Server Role:** Provides services or resources
3. **Bidirectional Nature:** The same device can be both a client and a server in different situations

### Example Scenarios

**Scenario 1: File Sharing**
- PC1 requests "file.txt" from PC2
- PC1 acts as the client
- PC2 acts as the server

**Scenario 2: Web Browsing**
- Your cellphone requests a video post from Facebook
- Cellphone acts as the client
- Facebook server acts as the server
- The Internet is the transmission medium

**Scenario 3: Peer-to-Peer**
- Two smartphones sharing files wirelessly
- Each device can act as both client and server
- Role depends on which device is requesting vs. providing the service

---

## 🔀 Switches

### Primary Characteristics

1. **High Port Density:** Usually 24, 48, or more ports
2. **LAN Connectivity:** Provide connectivity to hosts within the same LAN
3. **No Inter-LAN Routing:** Do NOT provide connectivity between different LANs
4. **Layer 2 Operation:** Primarily operate at the Data Link layer (more on this in later lectures)

### Common Use Cases

* Connecting multiple computers in an office
* Connecting servers in a data center
* Creating a network backbone within a building
* Providing PoE (Power over Ethernet) to devices like IP phones and cameras

### Limitation

Switches alone cannot connect separate LANs or provide Internet access. They require routers for inter-network communication.

---

## 🌐 Routers

### Primary Characteristics

1. **Lower Port Density:** Typically have fewer interfaces than switches
2. **Inter-Network Connectivity:** Provide connectivity BETWEEN different LANs
3. **Internet Gateway:** Used to send data over the Internet
4. **Path Selection:** Determine the best path for data to reach its destination

### Common Use Cases

* Connecting branch offices to headquarters
* Providing Internet access to a LAN
* Connecting multiple LANs within an organization
* Creating VPN connections between sites

### Example Network Flow

```
Tagbilaran Branch LAN → Router → Internet → Router → Mandaue Branch LAN
```

Without routers, the two LANs would be isolated and unable to communicate.

---

## 🛡️ Firewalls

### Types of Firewalls

#### 1. Network Firewalls
* **Type:** Hardware devices
* **Function:** Filter traffic between networks
* **Placement:** Can be "inside" or "outside" the network
* **Examples:** ASA5500-X, Firepower 2100

#### 2. Host-Based Firewalls
* **Type:** Software applications
* **Function:** Filter traffic entering and exiting a host machine
* **Placement:** Installed on individual devices (PCs, servers)
* **Examples:** Windows Firewall, iptables (Linux), macOS Firewall

### Firewall Operations

**Scenario 1: Allowed Traffic**
1. PC1 sends data to the Internet
2. Firewall inspects the traffic
3. Traffic matches allowed rules
4. Firewall permits traffic (OK)
5. Data continues to destination

**Scenario 2: Blocked Traffic**
1. Malicious traffic attempts to enter the network from the Internet
2. Firewall inspects the traffic
3. Traffic violates security rules
4. Firewall blocks traffic (X)
5. Threat is prevented from reaching internal network

### Next-Generation Firewalls (NGFW)

Modern firewalls include advanced capabilities:
* Deep packet inspection
* Intrusion prevention systems (IPS)
* Application awareness and control
* Advanced malware protection
* URL filtering
* SSL/TLS inspection

---

## 💻 Practical Examples

### Example 1: Simple Client-Server Communication
```python
# Simple client-server model demonstration

class Server:
    def __init__(self, name):
        self.name = name
        self.files = {"file.txt": "This is the content of the file."}
    
    def handle_request(self, client_name, requested_file):
        """
        Server responds to client requests
        """
        if requested_file in self.files:
            print(f"{self.name}: OK, sending {requested_file} to {client_name}")
            return self.files[requested_file]
        else:
            print(f"{self.name}: File not found")
            return None

class Client:
    def __init__(self, name):
        self.name = name
    
    def request_file(self, server, filename):
        """
        Client requests a file from server
        """
        print(f"{self.name}: Give me {filename}, please")
        return server.handle_request(self.name, filename)

# Usage
pc1 = Client("PC1")
pc2 = Server("PC2")

file_content = pc1.request_file(pc2, "file.txt")
if file_content:
    print(f"{pc1.name} received: {file_content}")
```

**Output:**
```
PC1: Give me file.txt, please
PC2: OK, sending file.txt to PC1
PC1 received: This is the content of the file.
```

### Example 2: Switch Simulation (Simplified)
```python
# Simplified switch behavior within a LAN

class Switch:
    def __init__(self, name):
        self.name = name
        self.connected_devices = []
        self.mac_table = {}  # MAC address table
    
    def connect_device(self, device):
        """
        Connect a device to the switch
        """
        self.connected_devices.append(device)
        print(f"Device {device.name} connected to {self.name}")
    
    def forward_frame(self, source_device, destination_mac, data):
        """
        Forward data within the same LAN
        """
        print(f"{self.name}: Forwarding data from {source_device.name}")
        
        # Find destination device by MAC address
        for device in self.connected_devices:
            if hasattr(device, 'mac_address') and device.mac_address == destination_mac:
                device.receive_data(data)
                return True
        
        print(f"{self.name}: Destination not found in this LAN")
        return False

class EndDevice:
    def __init__(self, name, mac_address):
        self.name = name
        self.mac_address = mac_address
    
    def receive_data(self, data):
        print(f"{self.name} received: {data}")

# Usage
sw1 = Switch("SW1")
pc1 = EndDevice("PC1", "00:11:22:33:44:55")
pc2 = EndDevice("PC2", "00:11:22:33:44:66")

sw1.connect_device(pc1)
sw1.connect_device(pc2)

# PC1 sends data to PC2
sw1.forward_frame(pc1, "00:11:22:33:44:66", "Hello from PC1")
```

**Output:**
```
Device PC1 connected to SW1
Device PC2 connected to SW1
SW1: Forwarding data from PC1
PC2 received: Hello from PC1
```

### Example 3: Router Simulation
```python
# Simplified router behavior connecting different LANs

class Router:
    def __init__(self, name):
        self.name = name
        self.routing_table = {}  # Network to interface mapping
    
    def add_route(self, network, next_hop):
        """
        Add a route to the routing table
        """
        self.routing_table[network] = next_hop
        print(f"{self.name}: Route added - {network} via {next_hop}")
    
    def route_packet(self, source_network, destination_network, data):
        """
        Route packet between different LANs
        """
        if destination_network in self.routing_table:
            next_hop = self.routing_table[destination_network]
            print(f"{self.name}: Routing packet from {source_network} to {destination_network}")
            print(f"{self.name}: Next hop is {next_hop}")
            return True
        else:
            print(f"{self.name}: No route to {destination_network}")
            return False

# Usage
router1 = Router("R1")

# Configure routing table
router1.add_route("192.168.1.0/24", "Interface G0/0")
router1.add_route("192.168.2.0/24", "Interface G0/1")
router1.add_route("0.0.0.0/0", "Internet Gateway")  # Default route

# Route between LANs
router1.route_packet("192.168.1.0/24", "192.168.2.0/24", "Data packet")
router1.route_packet("192.168.1.0/24", "8.8.8.8", "Internet-bound packet")
```

**Output:**
```
R1: Route added - 192.168.1.0/24 via Interface G0/0
R1: Route added - 192.168.2.0/24 via Interface G0/1
R1: Route added - 0.0.0.0/0 via Internet Gateway
R1: Routing packet from 192.168.1.0/24 to 192.168.2.0/24
R1: Next hop is Interface G0/1
R1: Routing packet from 192.168.1.0/24 to 8.8.8.8
R1: Next hop is Internet Gateway
```

### Example 4: Firewall Simulation
```python
# Simplified firewall behavior

class Firewall:
    def __init__(self, name):
        self.name = name
        self.rules = []
    
    def add_rule(self, source, destination, action):
        """
        Add a firewall rule
        action: 'allow' or 'deny'
        """
        rule = {
            'source': source,
            'destination': destination,
            'action': action
        }
        self.rules.append(rule)
        print(f"{self.name}: Rule added - {action.upper()} from {source} to {destination}")
    
    def inspect_traffic(self, source, destination):
        """
        Inspect traffic and apply rules
        """
        print(f"\n{self.name}: Inspecting traffic from {source} to {destination}")
        
        # Check rules in order
        for rule in self.rules:
            if (rule['source'] == source or rule['source'] == 'any') and \
               (rule['destination'] == destination or rule['destination'] == 'any'):
                if rule['action'] == 'allow':
                    print(f"{self.name}: ✓ Traffic ALLOWED")
                    return True
                else:
                    print(f"{self.name}: ✗ Traffic DENIED")
                    return False
        
        # Default deny
        print(f"{self.name}: ✗ Traffic DENIED (default deny)")
        return False

# Usage
fw1 = Firewall("FW1")

# Configure firewall rules
fw1.add_rule("192.168.1.0/24", "Internet", "allow")  # Allow internal to Internet
fw1.add_rule("Internet", "192.168.1.100", "allow")   # Allow Internet to web server
fw1.add_rule("Internet", "192.168.1.0/24", "deny")   # Deny Internet to internal

# Test traffic
fw1.inspect_traffic("192.168.1.10", "Internet")      # Should be allowed
fw1.inspect_traffic("Internet", "192.168.1.100")     # Should be allowed
fw1.inspect_traffic("Internet", "192.168.1.50")      # Should be denied
fw1.inspect_traffic("Malicious-IP", "192.168.1.10")  # Should be denied (default)
```

**Output:**
```
FW1: Rule added - ALLOW from 192.168.1.0/24 to Internet
FW1: Rule added - ALLOW from Internet to 192.168.1.100
FW1: Rule added - DENY from Internet to 192.168.1.0/24

FW1: Inspecting traffic from 192.168.1.10 to Internet
FW1: ✓ Traffic ALLOWED

FW1: Inspecting traffic from Internet to 192.168.1.100
FW1: ✓ Traffic ALLOWED

FW1: Inspecting traffic from Internet to 192.168.1.50
FW1: ✗ Traffic DENIED

FW1: Inspecting traffic from Malicious-IP to 192.168.1.10
FW1: ✗ Traffic DENIED (default deny)
```

### Example 5: Complete Network Simulation
```python
# Combining all devices in a network simulation

class NetworkSimulation:
    def __init__(self):
        self.devices = {}
    
    def add_device(self, device_type, name):
        self.devices[name] = {'type': device_type, 'name': name}
        print(f"Added {device_type}: {name}")
    
    def simulate_communication(self, source, destination, via_devices):
        """
        Simulate network communication path
        """
        print(f"\n--- Simulating communication from {source} to {destination} ---")
        print(f"Path: {source}", end="")
        
        for device in via_devices:
            print(f" → {device}", end="")
        
        print(f" → {destination}")
        print("Communication successful!\n")

# Usage
network = NetworkSimulation()

# Build network topology
network.add_device("Client", "PC1")
network.add_device("Switch", "SW1")
network.add_device("Router", "R1")
network.add_device("Firewall", "FW1")
network.add_device("Internet", "Internet")
network.add_device("Firewall", "FW2")
network.add_device("Router", "R2")
network.add_device("Switch", "SW2")
network.add_device("Server", "SRV1")

# Simulate communication
network.simulate_communication("PC1", "SRV1", 
    ["SW1", "R1", "FW1", "Internet", "FW2", "R2", "SW2"])
```

**Output:**
```
Added Client: PC1
Added Switch: SW1
Added Router: R1
Added Firewall: FW1
Added Internet: Internet
Added Firewall: FW2
Added Router: R2
Added Switch: SW2
Added Server: SRV1

--- Simulating communication from PC1 to SRV1 ---
Path: PC1 → SW1 → R1 → FW1 → Internet → FW2 → R2 → SW2 → SRV1
Communication successful!
```

---

## 🔑 Key Concepts Summary

### Network Device Hierarchy

**End Devices (Endpoints)**
- Clients and Servers
- Generate and consume network traffic
- Examples: PCs, laptops, smartphones, servers

**Network Infrastructure Devices**
- Switches: Connect devices within a LAN
- Routers: Connect different LANs and provide Internet access
- Firewalls: Control and monitor traffic for security

### Critical Distinctions

| Aspect | Switch | Router |
| :--- | :--- | :--- |
| Port Count | Many (24+) | Few (2-8) |
| Connectivity Scope | Within LAN | Between LANs |
| Internet Access | No | Yes |
| Primary Layer | Layer 2 (Data Link) | Layer 3 (Network) |

### Client-Server Flexibility

A device's role is determined by context:
- Your smartphone is a **client** when browsing Facebook
- Your smartphone is a **server** when sharing files via AirDrop
- Same device, different roles in different scenarios

### Firewall Security Principles

1. **Default Deny:** Block all traffic unless explicitly allowed
2. **Stateful Inspection:** Track connection states
3. **Rule-Based Filtering:** Apply security policies systematically
4. **Defense in Depth:** Use both network and host-based firewalls

---

## 📚 References
* [Lecture 02](https://drive.google.com/file/d/1t0JShfffCUBpxCjNvLsrP08Jo0oLxhcR/view?usp=drive_link) - Presentation Link
* **Course Material:** Data Communications and Networking with TCP/IP Protocol Suite (2022)
* **Instructor:** Engr. Violdan E. Bayocot
* **Institution:** University of San Jose - Recoletos, School of Computer Studies
* **Certification Path:** CCNA (Cisco Certified Network Associate)

---

## 💡 Additional Notes

### Cybersecurity Context

**Switches:**
- Can be vulnerable to MAC flooding attacks
- VLANs provide security segmentation
- Port security prevents unauthorized device connections

**Routers:**
- Access Control Lists (ACLs) provide basic security
- Can be targets for route injection attacks
- Critical for network segmentation and isolation

**Firewalls:**
- First line of defense in network security
- Essential for implementing security policies
- NGFWs provide advanced threat protection
- Both network and host-based firewalls are necessary for defense in depth


### Study Tips

1. **Memorize device characteristics:**
   - Switches: Many ports, LAN-only, Layer 2
   - Routers: Few ports, inter-network, Layer 3
   - Firewalls: Security, rule-based filtering

2. **Understand the client-server model:**
   - Client requests, server provides
   - Roles are contextual, not fixed

3. **Practice identifying devices:**
   - Look at network diagrams
   - Identify which device type is appropriate for each function

4. **Know the data flow:**
   - Client → Switch → Router → Firewall → Internet
   - Understand why each device is needed

5. **Cisco product families:**
   - Catalyst series: Switches
   - ISR series: Routers
   - ASA/Firepower series: Firewalls