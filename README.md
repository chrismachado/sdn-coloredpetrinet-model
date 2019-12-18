# sdn-coloredpetrinet-model
This model aims to represent the basic concept of software-defined networks using Color Petri networks.

## Prerequisites
- [CPN Tools](http://cpntools.org/)
- [Java](https://www.java.com/pt_BR/)




## Getting Started
First of all you will need to clone this repository using:
> $ git clone https://github.com/chrismachado/sdn-coloredpetrinet-model.git

### OS Setup
The tool **CPN Tools** only run correctly on Windows, so if you're using Linux OS's based, I recommend you to change for Windows with grub 
or on virtual machine.

### Develop Enviroment
I'm using the IntelliJ IDEA to run my Java classes. But, you can do this on command line if you want.

## SDN Scenario 
The core idea of an Software Defined Network is the divison of the data plane and the control plane. So, we have the idea of central a controller 
device, whereupon we can implements various high level applications. Thus, some benefits can be explored, such as the high programmability feature.
For this scenarios we've only implemented two features, DROP or ACCEPT some packet from IP source or IP destination, but you can implements more complex 
features with this base model.

<p align="center"><a href="http://fvcproductions.com"><img src="https://lh3.googleusercontent.com/9gCnaJyLml3dRY9emV4xzv_wsEHhxvXhSi9Tc9xcse08j8xErooEmDE_wmSe4Qnta_tOZGBopJDXl2I2tLN3bf4S5DFi6KMcGuaLFo-y"></a></p>


## Running Scenario
To do this open file finalwork.cpn on _cpn/model/finalwork.cpn_. Something like [this](https://drive.google.com/file/d/176YVVT89E80Ha6WBVOV9UTu6ioPYaNH0/view?usp=sharing) should be the result when you've oppened.
Then you will need to start two Java classes, *RunnerMain* and *UserActionMain*.

