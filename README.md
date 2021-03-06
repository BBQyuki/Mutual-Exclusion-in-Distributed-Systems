**Team Member**: Xin Tong/Yifan Xu/ Longhao Gao

<span id="h.vnwy1o4fnlvh" class="anchor"><span id="_Toc457597499" class="anchor"></span></span>What is it?
==================================================================================================================

Implementation of three different distributed mutual exclusion protocols, which are Lamport and Roucairol & Carvalho’s and Ricart-Agrawala's.

Also implemented automatic correctness verification and performance evaluation.

<span id="h.9ub5kvoqtgu4" class="anchor"><span id="_Toc457597500" class="anchor"></span></span>Project Requirements:
====================================================================================================================

1.  Two interfaces in SOA manner: enterCS() and leaveCS().

2.  All the nodes in full-mesh topology, only one FIFO connections allowed between each node.

3.  Automatic verification of the algorithm correctness.

4.  Performance needs to be monitored and evaluated.

<span id="h.hyk6cp5280yv" class="anchor"><span id="_Toc457597502" class="anchor"></span></span>System Architect
---------------------------------------------------------------------------------------------------------------

The project was designed with Layered architectural style. The
application, algorithm and FIFO channel were decomposed into layers.
Each layer provides interface to upper layer and use the lower layer’s
services.

The bottom layer is the transport layer which provides both TCP and SCTP
connection. In order to provide FIFO for TCP connection, we forced to
flush the TCP buffered each time we send a message.

The Message Service Layer provide not only String based message delivery
to specific node, but also embedded the Logical and Vector clock inside
it. The clock will tick automatically once new messages are sent or
received. The Lock service could be utilized by upper layers.

The algorithm layer is in charge of orchestrate the entering of critical
section. It’s the core part of this project. We implemented three
different types of algorithms.

The application layer is in charge of simulator the behavior of enter
and leaving critical section. Besides, both the correction verification
subsystem and performance measure subsystem located on this layer
because the application layer provides them with all kinds of timer log.

![](media/image1.png)

<span id="h.l6k46z6b8tdo" class="anchor"><span id="_Toc457597513" class="anchor"></span></span>Performance Measurements
-----------------------------------------------------------------------------------------------------------------

### <span id="h.tz1odevwp44i" class="anchor"><span id="_Toc457597514" class="anchor"></span></span>Results varied on different number of nodes

  ---------------------------------------------------------------------------------- --------
  ![](media/image3.png)   d=20ms
                                                                                     
                                                                                     c=10ms
  ---------------------------------------------------------------------------------- --------

  ------------------------------------------------------------------------ --------
  ![](media/image4.png)   d=20ms
                                                                           
                                                                           c=10ms
  ------------------------------------------------------------------------ --------

  ----------------------------------------------------------------------- --------
  ![](media/image5.png)   d=20ms
                                                                          
                                                                          c=10ms
  ----------------------------------------------------------------------- --------

### <span id="h.rfb4g6m6exfo" class="anchor"><span id="_Toc457597515" class="anchor"></span></span>Results varied on different execution times

  ---------------------------------------------------------- -------------
  ![](media/image6.png)   N = 5 nodes
                                                             
                                                             D =20ms
  ---------------------------------------------------------- -------------

  ------------------------------------------------------------------------ -------------
  ![](media/image7.png)   N = 5 nodes
                                                                           
                                                                           D =20ms
  ------------------------------------------------------------------------ -------------

  ---------------------------------------------------------------------------------- -------------
  ![](media/image8.png)   N = 5 nodes
                                                                                     
                                                                                     D =20ms
  ---------------------------------------------------------------------------------- -------------

### 

### <span id="h.j7hjlpi1cpuu" class="anchor"><span id="_Toc457597516" class="anchor"></span></span>Results varied on different delay in execution

  -------------------------------------------------------------------- ------------
  ![](media/image9.png)   n= 5 nodes
                                                                       
                                                                       c= 10 ms
  -------------------------------------------------------------------- ------------

  ------------------------------------------------------------------------ ------------
  ![](media/image10.png)   n= 5 nodes
                                                                           
                                                                           c= 10 ms
  ------------------------------------------------------------------------ ------------

  ----------------------------------------------------------------------------------- ------------
  ![](media/image11.png)   n= 5 nodes
                                                                                      
                                                                                      c= 10 ms
  ----------------------------------------------------------------------------------- ------------
